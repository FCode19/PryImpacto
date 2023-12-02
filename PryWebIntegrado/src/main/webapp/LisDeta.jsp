<%@page import="java.util.*"%>
<%@page import="model.Detalle"%>
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
        <%
          List<Detalle> lis=(ArrayList<Detalle>)request.getAttribute("dato");
          String nom=(String)request.getAttribute("dato2");
        %>
        <h2 class="text-cyan">Lista de Detalle de <%=nom%></h2>   
        <table class="table table-hover">
            <thead>
                <tr class="text-white bg-black">
                    <th>Pedido<th>Cliente<th>Fecha<th>Ver
            </thead>
            <% 
                for(Detalle x:lis){
                out.print("<tr><td>"+x.getId()+"<td>"+x.getProduN()+"<td>"+x.getCan()+"<td>"+x.getUnit());
                 }
            %>
        </table>
    </center>
    </body>
</html>
