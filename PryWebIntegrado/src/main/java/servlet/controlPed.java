/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import controller.Negocio;
import controller.NegocioPed;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cliente;
import model.Detalle;

/**
 *
 * @author diego8658
 */
public class controlPed extends HttpServlet {

    NegocioPed obj = new NegocioPed();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     int op=Integer.parseInt(request.getParameter("opc"));
     if(op==1)lisPed(request, response);
     if(op==2)grabar(request, response);
    }
    
    protected void lisPed(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      int id=Integer.parseInt(request.getParameter("cod"));
      String nom=request.getParameter("nom");
      request.setAttribute("dato", obj.lisPed(id));
      request.setAttribute("dato2", nom);
      String pag="/LisPed.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    
      protected void grabar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession ses = request.getSession();
      List<Detalle> lista=(ArrayList<Detalle>)ses.getAttribute("canasta");
      Cliente cli=(Cliente)ses.getAttribute("cliente");
      int ped=obj.GrabaFac(cli.getId(), lista);
      double sm=0;
      for(Detalle x:lista) sm=sm+x.total();
      String cad="Factura Nro:"+ped+"<br> Cliente :"+cli.getNombre();
      cad+="<br> Importe a pagar :"+sm;
      ses.setAttribute("canasta", null);
      ses.setAttribute("cliente", null);
      response.sendRedirect("Qrimagen?texto="+cad);
     // String pag="/pagCategoria.jsp";
      //request.getRequestDispatcher(pag).forward(request, response);
       
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
