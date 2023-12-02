<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.Negocio,model.Categoria,model.Proveedores"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar producto</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            Negocio obj = new Negocio();
        %>
    <center>
        <h1>Registro de Productos</h1>
        <form action="controlProd" method="post">
            <table class="table table-bordered">
                <input type="hidden" name="opc" value="2">
                <tr><td>Nombre<td><input name="nom" required>
                <tr><td>Precio Unitario<td><input name="uni" required>
                <tr><td>Stock<td><input name="sto" required>
                <tr><td>Categoria<td><select name="cat" required>
                    <option>--Elegir--</option>
                    <%
                        for (Categoria x : obj.LisCat()) {
                            out.print("<option value=" + x.getId()+ ">" + x.getNombre()+ "</option>");
                        }
                    %>
                </select>
                <tr><td>Proveedor<td><select name="pro" required>
                    <option>--Elegir--</option>
                    <%
                        for (Proveedores x : obj.LisProve()) {
                            out.print("<option value=" + x.getId()+ ">" + x.getNombre()+ "</option>");
                        }
                    %>
                </select>
                <tr><td colspan="2"><center><input type="submit" class="btn btn-success"></center>
            </table>   
            
            
        </form>
                </center>
    </body>
</html>
