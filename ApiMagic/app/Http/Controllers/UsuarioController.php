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
}
