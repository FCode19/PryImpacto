<%-- 
    Document   : pagDetalle
    Created on : 30 nov. 2023, 17:18:04
    Author     : diego8658
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="controller.Proceso"%>
<%@page import="model.Cambio"%>
<%@page import="model.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalle de articulo</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilosAct.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
           Producto art = (Producto)request.getAttribute("dato");
           Cambio cm = new Proceso().obtener();
           double precio = art.getUnit()/cm.getVenta();
           DecimalFormat df = new DecimalFormat("#.00");
           String pr = df.format(precio);
        %>
    <center>
        <h2>Detalle del Artículo <%=art.getNombre()%></h2>
        <hr>
         <a href="pagLisArt.jsp">Categorías</a>
         <br>
        <form action="controlProd" name="fr">
            <input type="hidden" name="opc" value="7">
            <input type="hidden" name="coda" value="<%=art.getId()%>">
        <table border="1" cellspacing="15" cellpadding="15">
            <tr> <td rowspan="5"><img src="FOTOS/<%=art.getId()%>.jpg" width="200" height="200">
                 <td> Descripcion <td><%=art.getNombre()%>
            <tr> <td> Precio Unitario <td>S/<%=art.getUnit()%>                $<%=pr%>
            <tr> <td> Stock <td><%=art.getStock()%>
            <tr> <td> Cantidad a Comprar <td> <input type="text" name="cantidad">
            <tr> <td colspan="2"> <center><a href="#" onclick="valida()"><img src="images/btnCarrito.gif"></a></center>
        </table>
        </form>
            <script>
            function valida(){
                sk=<%=art.getStock()%>
                can=Number(fr.cantidad.value)
                if(can>sk){
                    alert('Stock no disponible. Solo hay '+sk); return;
                } 
                fr.submit();
            }
            </script>
    </center>
    </body>
</html>
