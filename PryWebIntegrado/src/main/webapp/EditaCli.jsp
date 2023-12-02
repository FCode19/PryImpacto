<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Cliente" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Cliente</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
     <%
         Cliente c =(Cliente)request.getAttribute("dato");
      %>  
        <h1>Edicion de Cliente</h1>
        <form action="controlCli" method="post">
            <table class="table table-bordered">
                <input type="hidden" name="opc" value="2">
                <tr><td>Id<td><input name="cod" value="<%=c.getId()%>" readonly>
                <tr><td>Nombre<td><input name="nom" value="<%=c.getNombre()%>">
                <tr><td>Direccion<td><input name="direc" value="<%=c.getDirecc()%>">
                <tr><td>Email<td><input name="ema" value="<%=c.getEmail()%>">
                <tr><td>Telefono<td><input name="tel" value="<%=c.getTelef()%>">
                <tr><td>Contraseña<td><input name="contra" value="<%=c.getContra()%>" type="password">
                <tr><td colspan="2"><input type="submit" class="btn btn-success">
            </table>  
        </form>
    </body>
</html>
