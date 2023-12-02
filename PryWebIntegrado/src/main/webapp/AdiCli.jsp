<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar clientes</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/EstilosClientes.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Registro de Clientes</h1>
        <hr>
        <form action="controlCli" method="post">
            <table class="table table-bordered">
                <input type="hidden" name="opc" value="1">
                <input type="hidden" name="pag" value="LisCliente.jsp">
                <tr><td>Nombre<td><input name="nom" required>
                <tr><td>Direccion<td><input name="direc" required>
                <tr><td>Email<td><input name="ema" required>
                <tr><td>Telefono<td><input name="tel" required>
                <tr><td>Contraseña<td><input name="contra" type="password" required>
                <tr><td colspan="2"><input type="submit" class="btn btn-success">
            </table>   
            
            
        </form>
    </body>
</html>
