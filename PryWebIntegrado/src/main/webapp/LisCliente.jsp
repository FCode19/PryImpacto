<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
        <script src="js/filtrar.js" type="text/javascript"></script>
    </head>
    <body>
    <center>
        <h2>Filtra por Nombre</h2>
    </center>
    <a style="margin-left: 10%" href="AdiCli.jsp">Registra Cliente</a>
    <center>
        <table class="table table-bordered">
            <tr><td>Nombre<td><input id="txtnom">
        </table>
        <div id="tablares"></div>
    </center>
    </body>
</html>
