<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*, controller.Negocio" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar producto</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
     <%
         Negocio obj = new Negocio();
         Producto p =(Producto)request.getAttribute("dato");
      %>  
    <center><h1>Edicion de Producto</h1>
        <form action="control" method="post">
            <table class="table table-bordered">
                <input type="hidden" name="opc" value="3">
                <tr><td>Id<td><input name="cod" value="<%=p.getId()%>" readonly>
                <tr><td>Nombre<td><input name="nom" value="<%=p.getNombre()%>">
                <tr><td>Precio Unitario<td><input name="uni" value="<%=p.getUnit()%>">
                <tr><td>Stock<td><input name="sto" value="<%=p.getStock()%>">
                <tr><td>Categoria<td><select name="cat" required>
                    <option>--Elegir--</option>
                    <%
                        for (Categoria x : obj.LisCat()) {
                            if (x.getId()== p.getCateid()) {
                                out.print("<option value=" + x.getId()+ " selected>" + x.getNombre()+ "</option>");
                            }else
                            out.print("<option value=" + x.getId()+ ">" + x.getNombre()+ "</option>");
                        }
                    %>
                </select>
                <tr><td>Proveedor<td><select name="pro" required>
                    <option>--Elegir--</option>
                    <%
                        for (Proveedores x : obj.LisProve()) {
                            if (x.getId()== p.getProveid()) {
                                out.print("<option value=" + x.getId()+ " selected>" + x.getNombre()+ "</option>");
                            }else
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
