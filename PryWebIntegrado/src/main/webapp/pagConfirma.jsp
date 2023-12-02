<%@page import="model.Producto"%>
<%@page import="controller.NegocioProd"%>
<%@page import="model.Detalle"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resumen de compras</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilosAct.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
            <%
            HttpSession ses = request.getSession();
            List<Detalle> lista = (ArrayList<Detalle>) ses.getAttribute("canasta");
            NegocioProd obj = new NegocioProd();
            %>
    <center>
        <h2> Lista de Compras </h2>
        <a href="pagCompra.jsp" class="btn btn-success">Genera Factura</a>&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="" class="btn btn-success"> Cancela compra </a>
        <table class="table table-hover" border="1" style="margin-top: 20px">
             <thead><tr class="text-white bg-dark"><th>Codigo<th>Descripcion<th>Precio<th>Cantidad<th>Total
             </thead>
                    <%  double sm=0;
                        int fila = 0;
                        for (Detalle cp : lista) {
                            Producto pr = obj.consulProd(cp.getProduc());
                            sm=sm+cp.total();
                            out.print("<tr><td>" + cp.getId()+ "<td>" + pr.getNombre()+ "<td>"
                                    + pr.getUnit()+ "<td>" + cp.getCan()+ "<td>" + cp.total());
                                           }
                    %>
                <tr> <td colspan="4"> Total: <td><%=sm%>
         </table>
  
    </center>
    </body>
</html>
