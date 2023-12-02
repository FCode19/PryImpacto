<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.GStock,controller.Negocio"%>
<!DOCTYPE html>
<html>
  <script src="js/Chart.min.js"></script>
  <style>
    .container {
      width: 70%;
      margin: 15px auto;
    }
    body {
      text-align: center;
      color: green;
    }
    h2 {
      text-align: center;
      font-family: "Verdana", sans-serif;
      font-size: 30px;
    }
  </style>
  <body>
      <%
          Negocio  obj=new Negocio();
         String label="",data="";
         String tipo=request.getParameter("tipo");
         for(GStock x:obj.LisStock()){
         label =label+"'"+x.getNombre()+"',";
         data=data+x.getStock()+",";
         }
         if(obj.LisStock().size()>0){
         label=label.substring(0,label.length()-1);
         data=data.substring(0,data.length()-1);
          }
         String color;
         if(tipo.equals("bar")|| tipo.equals("line")){
           color="'rgba(153,205,1,0.6)'";
          }else{
          color="['rgba(153,205,1,0.6)','lightblue','red','orange','peru','green','blue','whitesmoke','skyblue','purple','white','black','yellow','brown']";
          }
      %>
    <div class="container">
      <h2>Grafico de Stock de Productos</h2>
      <div>
        <canvas id="myChart"></canvas>
      </div>
    </div>
  </body>
  <script>
    var ctx = document.getElementById("myChart").getContext("2d");
    var myChart = new Chart(ctx, {
      type: "<%=tipo%>",
      data: {
        labels: [<%=label%>],
        datasets: [
          {
            label: "año",
            data: [<%=data%>],
            backgroundColor: <%=color%>,
          },
        ],
      },
    });
  </script>
</html>
