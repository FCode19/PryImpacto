<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <center>
        <h2>Grafico de Pedidos por Cliente</h2>
        <form action="grafico" target="zona">
            <input type="radio" name="tipo" value="bar" onclick="submit()">barra
            <input type="radio" name="tipo" value="line" onclick="submit()">lineal
            <input type="radio" name="tipo" value="pie" onclick="submit()">circular
        </form>
        <iframe name="zona" width="100%" height="500"></iframe>
    </center>
    </body>
</html>
