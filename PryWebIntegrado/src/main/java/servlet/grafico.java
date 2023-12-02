package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import controller.Negocio;
import java.io.OutputStream;
import org.jfree.chart.*;
import org.jfree.data.general.DefaultPieDataset;
//para barras o lineal
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.*;

/**
 *
 * @author LAB-USR-AQ265-A0805
 */
public class grafico extends HttpServlet {
    Negocio obj = new Negocio();
    JFreeChart torta(){
        DefaultPieDataset ds = new DefaultPieDataset();
        for(GPed x:obj.LisPedCli()){
            ds.setValue(x.getNombre(), x.getNroped());
        }
        //graficar en memoria
        JFreeChart gf = ChartFactory.createPieChart3D("Pedidos por cliente",ds );
        return gf;
    }
    JFreeChart barra(){
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        for(GPed x:obj.LisPedCli()){
            ds.setValue(x.getNroped(),"venta",x.getNombre());
        }
        //graficar en memoria
        JFreeChart gf = ChartFactory.createBarChart3D("Pedidos por cliente","Pedido", "Cliente",ds);
        return gf;
    }
    JFreeChart lineal(){
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        for(GPed x:obj.LisPedCli()){
            ds.setValue(x.getNroped(),"venta",x.getNombre());
        }
        //graficar en memoria
        JFreeChart gf = ChartFactory.createLineChart3D("Pedidos por cliente","Pedido", "Cliente",ds);
        return gf;
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("image/jpeg");
        String tipo = request.getParameter("tipo");
        OutputStream flujo = response.getOutputStream();
        if(tipo.equals("pie"))
        ChartUtilities.writeChartAsJPEG(flujo, torta(), 500, 500);
        if(tipo.equals("bar"))
        ChartUtilities.writeChartAsJPEG(flujo, barra(), 500, 500);
        if(tipo.equals("line"))
        ChartUtilities.writeChartAsJPEG(flujo, lineal(), 500, 500);
        flujo.close();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
