<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" href="img/logo.png">
        <title>Inicia sesión</title>
    </head>
    <body>
        <center><div><img class="logo" src="img/logo.png"></div></center>
        <form action="controlCli">
        <div class="form">
            <div class="title">Bienvenido</div>
            <div class="subtitle">!Crea tu cuenta!</div>
            <input type="hidden" name="opc" value="1">
            <input type="hidden" name="pag" value="pagPrincipal.jsp">
            <div class="input-container ic1">
                <input name="nom" id="Nombres" class="input" type="text" placeholder=" " />
                <div class="cut"></div>
                <label for="Nombres" class="placeholder">Nombres</label>
            </div>
            <div class="input-container ic2">
                <input name="direc" id="Apellidos" class="input" type="text" placeholder=" " />
                <div class="cut"></div>
                <label for="Apellidos" class="placeholder">Dirección</label>
            </div>
            <div class="input-container ic2">
                <input name="ema" id="email" class="input" type="text" placeholder=" " />
                <div class="cut"></div>
                <label for="email" class="placeholder">Correo</>
            </div>
            <div class="input-container ic2">
                <input name="tel" id="Telefono" class="input" type="number" placeholder=" " />
                <div class="cut"></div>
                <label for="Telefono" class="placeholder">Telefono</>
            </div>
            <div class="input-container ic2">
                <input name="contra" id="Contra" class="input" type="password" placeholder=" " />
                <div class="cut"></div>
                <label for="Contra" class="placeholder">Contraseña</>
            </div>
            <button type="text" class="submit" onclick="submit()">Crear Cuenta</button>
        </form>
            <div class="input-container ic2">
                <a type="button" class="text" onclick="href =window.location.href = 'pagRegistra.jsp'">¿Ya tienes cuenta? Inicia sesión</a>
            </div>
        </div>
    </body>
</html>