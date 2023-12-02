<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" href="img/logo.png">
        <title>Registrar</title>
    </head>
    <body>
        <center><div><img class="logo" src="img/logo.png"></div></center>
        <form action="controlCli">
            <input type="hidden" name="opc" value="6">
        <div class="form">
            <div class="title">Bienvenido</div>
            <div class="subtitle">Ingresa tus datos</div>
            
            <div class="input-container ic1">
                <input name="ema" id="email" class="input" type="text" placeholder=" " />
                <div class="cut"></div>
                <label for="email" class="placeholder">Correo</>
            </div>
            
            <div class="input-container ic1">
                <input name="contra" id="Contra" class="input" type="password" placeholder=" " />
                <div class="cut"></div>
                <label for="Contra" class="placeholder">Contraseña</>
            </div>
            <button type="text" class="submit" onclick="submit()">Iniciar sesion</button>
        </form>
            <div class="input-container ic2">
                <a type="button" class="text" onclick="window.location.href = 'paglogin.jsp'">¿No tienes cuenta? Registrate</a>
            </div>
        </div>
    </body>
</html>