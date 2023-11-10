<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>Registro</title>
    <link rel="stylesheet" href="style_signin.css" type="text/css"/>
</head>
<body>
    <section class="form-signin">
        <h2>Registro</h2>
        <form action="SvUsuarios" method="POST" id="registroForm">
            <input class="controls" type="text" name="nombre" placeholder="Nombre"/>
            <input class="controls" type="text" name="apellido1" placeholder="Primer apellido"/>
            <input class="controls" type="text" name="apellido" placeholder="Segundo apellido"/>
            <p></p>
            <input class="controls" type="email" name="email" placeholder="Ingresa tu correo electrónico"/>
            <input class="controls" type="tel" name="phone" placeholder="Número de teléfono"/>
            <p></p>
            <input class="controls" type="text" name="usuario" placeholder="Usuario"/>
            <input class="controls" type="password" name="contrasena" placeholder="Contraseña"/>
            <p></p>
            <input type="hidden" id="registroForm" name="registroForm" />
            <button class="buttons" type="submit">"Registrar"</button>
        </form>
    </section>
</body>
</html>