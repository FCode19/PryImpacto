<%-- 
    Document   : pagCompra
    Created on : 29 nov. 2023, 18:34:36
    Author     : diego8658
--%>

<%@page import="model.Producto"%>
<%@page import="controller.NegocioProd"%>
<%@page import="model.Detalle"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilosAct.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            HttpSession ses = request.getSession();
            List<Detalle> lista = (ArrayList<Detalle>) ses.getAttribute("canasta");
            NegocioProd obj = new NegocioProd();
            String login = "paglogin.jsp";
            if(ses.getAttribute("cliente")!=null){
                login = "pagConfirma.jsp";
            }
        %>
        <center>
        <h2> Lista de Compras </h2>
        <a href="pagListArt.jsp" class="btn btn-success">Seguir comprando</a>&nbsp;&nbsp;&nbsp;&nbsp;
        <a href=<%=login%> class="btn btn-success"> Aceptar compra </a>
        <table class="table table-hover" border="1" style="margin-top: 20px">
             <thead><tr class="text-white bg-dark"><th>Codigo<th>Descripcion<th>Precio<th>Cantidad<th>Total<th>imagen<th>Del
             </thead>
                    <%  double sm=0;
                        int fila = 0;
                        for (Detalle cp : lista) {
                            Producto pr = obj.consulProd(cp.getProduc());
                            sm=sm+cp.total();
                            out.print("<tr><td>" + cp.getId()+ "<td>" + pr.getNombre()+ "<td>"
                                    + pr.getUnit()+ "<td>" + cp.getCan()+ "<td>" + cp.total());
                    %>
                    <td><img src="FOTOS/<%=cp.getProduc()%>.jpg" width="90" height="90">
                    <td><a href="controlDet?opc=2&ind=<%=fila%>"
                           class="btn btn-danger">Del</a>
                    <%
                        fila++;
                       }
                    %>
                <tr> <td colspan="4"> Total: <td><%=sm%>
         </table>
  
    </center>
    </body>
</html>
