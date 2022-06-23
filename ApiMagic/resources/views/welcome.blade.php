<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

    <title>Documentación | Api Magic</title>
    <style>
        body {
            margin: 1em;
            background-color: #4fa8fb;
        }

        div {
            background-color: white;
        }

        .contenido {
            margin: 5px;
            padding: 5px;
        }
    </style>
</head>
<body>
<div class="container border border-primary">

    <div class="container contenido border">
        <h1>URL de acceso</h1>
        https://viqoxwhm.lucusvirtual.es/public/api/
    </div>
    <div class="container contenido border text-justify">
        <h2>Registrar usuario | Metodo POST</h2>
        <p>https://viqoxwhm.lucusvirtual.es/public/api/registroForm</p>
        <p>Este metodo proporciona el registro del usuario con los siguientes atributos</p>
        <div class="container border">
            <h3>Atributos</h3>
            <ul>
                <li>nombre</li>
                <li>apellido_Paterno</li>
                <li>apellido_Materno</li>
                <li>correo</li>
                <li>contrasenia</li>
                <li>contrasenia2</li>
                <li>fecha_Nacimiento</li>
            </ul>
            Una vez teniendo esos datos la api mandara un correo para verificar el registro. Una vez validado el correo
            aparecera una leyenda
            <p class="font-weight-bold">La cuenta ya ha sido verificada</p>
        </div>

    </div>
    <div class="container contenido border text-justify">
        <h2>Verificar Credenciales | Metodo POST</h2>
        <p>https://viqoxwhm.lucusvirtual.es/public/api/verificarCredenciales</p>
        <p>Este metodo proporciona el acceso del usuario con los siguientes atributos</p>
        <div class="container border">
            <h3>Atributos</h3>
            <ul>
                <li>correo</li>
                <li>contrasenia</li>
            </ul>
            si los datos son correctos la api madara un JSON con los datos del usuario
            <pre class="container border"><code>
        {
        "id": 2,
        "nombre": "Alejandro",
        "apellido_Paterno": "Esperon",
        "apellido_Materno": "Macoco",
        "correo": "nerialvareze@gmail.com",
        "contrasenia": "$2y$05$oZBECqb7CpeSX.nbH8KRd.qERi6nDcU1rnNtlELDAF5RaVw5XXzQm",
        "fecha_Nacimiento": "2001-06-01",
        "estatus": 1,
        "codigo_confirmacion": null,
        "token_recovery": null,
        "created_at": "2022-06-22T05:47:18.000000Z",
        "updated_at": "2022-06-22T05:48:01.000000Z"
        }
        </code></pre>
        </div>
    </div>
    <div class="container contenido border text-justify">
        <h2>Verificar Email | Metodo GET</h2>
        <p>https://viqoxwhm.lucusvirtual.es/public/api/verificacionMail/{codigo}</p>
        <p>Este metodo realiza la validacion de correo con el codigo correspondiente en la url</p>
        <div class="container border">
            <h3>Atributos</h3>
            <ul>
                <li>codigo</li>
            </ul>
        </div>
    </div>
    <div class="container contenido border text-justify">
        <h2>Recuperar Contraseña | Metodo POST</h2>
        <p>https://viqoxwhm.lucusvirtual.es/public/api/recuperarContrasenia</p>
        <p>Este metodo crea un codigo de seguridad para cambiar la contraseña y enviarlo via email</p>
        <div class="container border">
            <h3>Atributos</h3>
            <ul>
                <li>correo</li>
            </ul>
        </div>
    </div>
    <div class="container contenido border text-justify">
        <h2>Verificar codigo | Metodo POST</h2>
        <p>https://viqoxwhm.lucusvirtual.es/public/api/codigo</p>
        <p>Este metodo valida si existe el codigo que proporciono el usuario</p>
        <div class="container border">
            <h3>Atributos</h3>
            <ul>
                <li>codigo</li>
            </ul>
        </div>
    </div>
    <div class="container contenido border text-justify">
        <h2>Cambiar Contraseña | Metodo POST</h2>
        <p>https://viqoxwhm.lucusvirtual.es/public/api/cambio/codigo</p>
        <p>Este obtine el codigo y la nueva contraseña de usuario</p>
        <div class="container border">
            <h3>Atributos</h3>
            <ul>
                <li>codigo</li>
                <li>contrasenia</li>
                <li>contrasenia2</li>
            </ul>
        </div>
    </div>
</div>

<!-- Optional JavaScript; choose one of the two! -->

<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
        crossorigin="anonymous"></script>

<!-- Option 2: Separate Popper and Bootstrap JS -->
<!--
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>
-->
</body>
</html>
