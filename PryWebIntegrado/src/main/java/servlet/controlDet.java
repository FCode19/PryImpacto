/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import controller.Negocio;
import controller.NegocioDet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Detalle;

/**
 *
 * @author diego8658
 */
public class controlDet extends HttpServlet {

    NegocioDet obj = new NegocioDet();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     int op=Integer.parseInt(request.getParameter("opc"));
     if(op==1)lisDet(request, response);
     if(op==2)anula(request, response);
    }
    
    protected void lisDet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      int id=Integer.parseInt(request.getParameter("cod"));
      String nom=request.getParameter("nom");
      request.setAttribute("dato", obj.lisDet(id));
      request.setAttribute("dato2", nom);
      String pag="/LisDeta.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void anula(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      if(request.getParameter("ind")!=null){
      int ind=Integer.parseInt(request.getParameter("ind"));
       HttpSession ses = request.getSession();
      List<Detalle> lista=(ArrayList<Detalle>)ses.getAttribute("canasta");
      lista.remove(ind);
      ses.setAttribute("canasta", lista);
      }
      String pag="/pagCompra.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
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
