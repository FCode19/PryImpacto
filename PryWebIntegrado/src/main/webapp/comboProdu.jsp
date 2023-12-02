<%@page import="controller.NegocioProd"%>
<%@page import="model.*"%>
<%@page import="controller.Negocio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            NegocioProd obj = new NegocioProd();
            Negocio neg = new Negocio();
            int codc = 0;
            if (request.getParameter("cbCat") != null) {
                codc = Integer.parseInt(request.getParameter("cbCat"));
            }
        %>
    <center>
        <h1>Productos por categoria</h1>
    </center>
    <a style="margin-left: 10%" href="AdiProd.jsp">Registrar Producto</a>
        <center>
        <form action="comboProdu.jsp">
                <label class="control-label">Seleccione Categoria</label>
                <select class="form-control" name="cbCat" id="cbCat" onchange="submit()">
                    <option>--Elegir--</option>
                    <%
                        for (Categoria x : neg.LisCat()) {
                            if (x.getId()== codc) {
                                out.print("<option value=" + x.getId()+ " selected>" + x.getNombre()+ "</option>");
                            }else
                            out.print("<option value=" + x.getId()+ ">" + x.getNombre()+ "</option>");
                        }
                    %>
                </select>
        </form>
        <table class="table table-hover">
            <thead>
                <tr class="text-white bg-black"><th>Producto<th>Descripcion<th>Precio unitario<th>Stock<th>Proveedor<th>Eliminar<th>Modificar
            </thead>
            <%
                for (Producto x : obj.LisProd(codc)) {
                    out.print("<tr><td>" + x.getId()+ "<td>" + x.getNombre()+ "<td>" + x.getUnit()+ "<td>" + x.getStock()+ "<td>" + x.getProve());
                %>
                <td><a href='controlProd?opc=5&cod=<%=x.getId()%>'>Del</td>
                <td><a href='controlProd?opc=4&cod=<%=x.getId()%>'>Edit</td>
            <%
                }
            %>
        </table>
    </center>
    </body>
</html>
