<%@page import="java.util.*"%>
<%@page import="model.Pedido"%>
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
          List<Pedido> lis=(ArrayList<Pedido>)request.getAttribute("dato");
          String nom=(String)request.getAttribute("dato2");
        %>
        <h2 class="text-cyan">Lista de Pedidos de <%=nom%></h2>   
        <table class="table table-hover">
            <thead>
                <tr class="text-white bg-black">
                    <th>Pedido<th>Cliente<th>Fecha<th>Ver
            </thead>
            <% 
                for(Pedido x:lis){
                out.print("<tr><td>"+x.getId()+"<td>"+x.getClient()+"<td>"+x.getFecha());
            %>
            <td><a href="controlDet?opc=1&cod=<%=x.getId()%>&nom=<%=nom%>">Detalle</a>
            <%
                 }
            %>
        </table>
    </center>
    </body>
</html>
