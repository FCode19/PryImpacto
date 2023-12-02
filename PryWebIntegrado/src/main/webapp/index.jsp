<%@page import="controller.NegocioProd"%>
<%@page import="model.Producto"%>
<%@page import="controller.Negocio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categorias</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilosAct.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
          <%
            NegocioProd obj = new NegocioProd();
        %>
    <center>
        <h2>Lista de Categorías</h2>
        <hr>
        <table border="1" cellspacing="15" cellpadding="15">
            <tr>
            <%
            int cuenta=0;
            for(Producto p:obj.LisProdTot()){
                %>
                <td onmouseover="bgColor='#72DF65'" onmouseout="bgColor='white'">
                    <a href="controlProd?opc=6&cod=<%=p.getId()%>">
                        <img src="FOTOS/<%=p.getId()%>.jpg" width="150" height="150">
                        <br><%=p.getNombre()%></a>
            <%
                cuenta++;
                if(cuenta%3==0)out.print("<tr>");
                }
            %>
        </table>
    </center>
    </body>
</html>
