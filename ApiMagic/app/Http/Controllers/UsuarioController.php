<?php

namespace App\Http\Controllers;

use App\Mail\RecuperarMailable;
use App\Mail\VerificacionEmail;
use App\Models\Usuario;
use Exception;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Mail;
use Illuminate\Support\Facades\Validator;

class UsuarioController extends Controller
{
    public function VerificarCredenciales(Request $datos){
        if (!$datos->correo || !$datos->contrasenia)
            return ["estatus" => "error", "mensaje" => "Completa los campos"];

        $usuario = Usuario::where('correo', $datos->correo)->first();

        if (!$usuario)
            return  ["estatus" => "error", "mensaje" => "¡El correo no esta registrado!"];
        if (!password_verify($datos->contrasenia, $usuario->contrasenia))
            return ["estatus" => "error", "mensaje" => "¡La contraseña que ingresaste es incorrecta!"];

        return $usuario;

    }

    public function registrarUsuario(Request $datos){
        $rules = [
            'nombre' => "required|min:3|max:32|alpha",
            'apellido_Paterno' => "required|min:3|max:32|alpha",
            'apellido_Materno' => "required|min:3|max:32|alpha",
            'correo' => "required|email|min:8|max:64",
            'fecha_Nacimiento' => "required|date",
            'contrasenia' => "required|min:8|max:64",
            'contrasenia2' => "required|min:8|max:64"
        ];
        try {
            //Validacion
            $validator = Validator::make($datos->all(), $rules);
            if ($validator->fails()){
                return $validator->errors();
            }else{
                //Se verifica si existe una cuenta ya
                $usuario = Usuario::where('correo', $datos->correo)->first();
                if ($usuario)
                    return ["estatus" => "Error", "mensaje" => "El correo ya esta registrado"];
                //Se comparan las contrasenias
                if ($datos->contrasenia != $datos->contrasenia2)
                    return ["estatus" => "Error", "mensaje" => "Las contrasenias no son iguales"];

                $max_num = 6;
                $codigo = "";
                for ($x = 0; $x < $max_num; $x++) {
                    $num_aleatorio = rand(0, 9);
                    $codigo = $codigo . strval($num_aleatorio);
                }
                $datos["codigo_confirmacion"] = $codigo;
                //Se registran los datos
                $usuario = new Usuario();
                $usuario->nombre = $datos->nombre;
                $usuario->apellido_Paterno = $datos->apellido_Paterno;
                $usuario->apellido_Materno = $datos->apellido_Materno;
                $usuario->correo = $datos->correo;
                $usuario->contrasenia = password_hash($datos->contrasenia, PASSWORD_DEFAULT, ['cost' => 5]);
                $usuario->fecha_Nacimiento = $datos->fecha_Nacimiento;
                $usuario->estatus = 1;
                $usuario->codigo_confirmacion = $datos->codigo_confirmacion;
                Mail::to($datos->correo)->send(new VerificacionEmail($usuario));
                $usuario->save();
                return ["mensaje" => "Cuenta creada"];
            }
        }catch (Exception $e){
            return (['estatus' => "Error", 'mensaje' => "Algo salio mal intenta de nuevo"]);
        }
    }
    //Funcion para verificar email
    public function verificacionMail($codigo){
        //Valida el codigo
        $usuario = Usuario::where('codigo_confirmacion', $codigo)->first();
        if ($usuario){
            $usuario->codigo_confirmacion = null;
            $usuario->save();
            return \response("Cuenta verificada, vuelve a la aplicacion", 201);
        }
        else{
            return \response("La cuenta ya ha sido verificada");
        }
    }
    public function recuperarContrasenia(Request $datos)
    {
        if (!$datos->correo)
            return ["estatus" => "error", "mensaje" => "¡Completa los campos!"];
        $usuario = Usuario::where('correo', $datos->correo)->first();
        if (!$usuario)
            return ["estatus" => "error", "mensaje" => "¡El correo no esta registrado!"];
        $max_num = 6;
        $codigo = "";
        for ($x = 0; $x < $max_num; $x++) {
            $num_aleatorio = rand(0, 9);
            $codigo = $codigo . strval($num_aleatorio);
        }
        $usuario->token_recovery = $codigo;
        $usuario->save();
        Mail::to($usuario->correo)->send(new RecuperarMailable($usuario));
        return ["estatus" => "success", "mensaje" => "¡El correo se a enviado"];
    }
    public function codigo(Request $datos)
    {
        if (!$datos->codigo)
            return ["estatus" => "error", "mensaje" => "¡El ingresa el codigo!"];

        $usuario = Usuario::where('token_recovery', $datos->codigo)->first();

        if (!$usuario)
            return ["estatus" => "error", "mensaje" => "¡Error en el codigo!"];

        return  ["estatus" => "success","codigo" => $datos->codigo];
    }
    public function cambio(Request $datos)
    {
        if (!$datos->contrasenia || !$datos->contrasenia2)
            return ["estatus" => "error", "mensaje" => "¡Completa los campos!"];

        if ($datos->contrasenia != $datos->contrasenia2)
            return ["estatus" => "error", "mensaje" => "¡Las contraseñas no son iguales!"];

        $usuario = Usuario::where('token_recovery', $datos->codigo)->first();
        $usuario->contrasenia = password_hash($datos->contrasenia, PASSWORD_DEFAULT, ['cost' => 5]);
        $usuario->token_recovery = null;
        $usuario->save();

        return ["estatus" => "success", "mensaje" => "¡Contraseña cambiada!"];
    }
}
