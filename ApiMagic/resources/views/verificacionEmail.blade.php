<!DOCTYPE html>
<html lang="en-US">
<head>
    <meta charset="utf-8" />
</head>
<body>
<h2>Confirmacion de correo electronico</h2>
<p>Hola {{$nombre}}</p>
<p>Recientemente se uso tu correo para registrarse en una aplicacion</p>
<p>En caso de haber sido tu has clic en confirmar</p>
<a href="{{ route('verificacion.mail',["codigo"=> $codigo]  )}}">
    Clic para confirmar tu email
</a>
<p>En caso de no haber sido tu, ignora este mensaje</p>
</body>
</html>
