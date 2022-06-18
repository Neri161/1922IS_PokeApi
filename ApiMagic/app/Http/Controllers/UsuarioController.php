<?php

namespace App\Http\Controllers;

use App\Models\Usuario;
use Illuminate\Http\Request;

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

        if (!$datos->nombre || !$datos->apellido_Paterno || !$datos->apellido_Materno || !$datos->correo || !$datos->fecha_Nacimiento || !$datos->contrasenia || !$datos->contrasenia2)
            return ["estatus" => "Error", "Mensaje" => "Algunos campos estan vacios"];

        //Se verifica si existe una cuenta ya
        $usuario = Usuario::where('correo', $datos->correo)->first();
        if ($usuario)
            return ["estatus" => "Error", "Mensaje" => "El correo ya esta registrado"];
        //Se comparan las contrasenias
        if ($datos->contrasenia != $datos->contrasenia2)
            return ["estatus" => "Error", "Mensaje" => "Las contrasenias no son iguales"];

        $nombre = $datos->nombre;
        $apellidoP = $datos->apellido_Paterno;
        $apellidoM = $datos->apellido_Materno;
        $correo = $datos->correo;
        $contrasenia = password_hash($datos->contrasenia, PASSWORD_DEFAULT);
        $fechaNacimiento = $datos->fecha_Nacimiento;
        $estatus = 1;

        $usuario = new Usuario();
        $usuario->nombre = $nombre;
        $usuario->apellido_Paterno = $apellidoP;
        $usuario->apellido_Materno = $apellidoM;
        $usuario->correo = $correo;
        $usuario->contrasenia = $contrasenia;
        $usuario->fecha_Nacimiento = $fechaNacimiento;
        $usuario->estatus =$estatus;

        $usuario->save();
        return ["Mensaje" => "Cuenta creada"];
    }
}
