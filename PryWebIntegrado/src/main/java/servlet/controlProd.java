/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;


import controller.NegocioProd;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Detalle;
import model.Producto;

/**
 *
 * @author diego8658
 */
public class controlProd extends HttpServlet {

    NegocioProd obj = new NegocioProd();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     int op=Integer.parseInt(request.getParameter("opc"));
     if(op==1)lisProd(request, response);
     if(op==2)adiProd(request, response);
     if(op==3)actuProd(request, response);
     if(op==4)ediProd(request, response);
     if(op==5)anuProd(request, response);
     if(op==6)busProd(request, response);
     if(op==7)carrito(request, response);
    }
    
    protected void lisProd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      int id=Integer.parseInt(request.getParameter("cod"));
      String nom=request.getParameter("nom");
      request.setAttribute("dato", obj.LisProd(id));
      request.setAttribute("dato2", nom);
      String pag="/LisProd.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void adiProd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Producto p = new Producto();
        String pag = "/comboProdu.jsp";
        p.setNombre(request.getParameter("nom"));
        p.setUnit(Double.parseDouble(request.getParameter("uni")));
        p.setStock(Integer.parseInt(request.getParameter("sto")));
        p.setCateid(Integer.parseInt(request.getParameter("cat")));
        p.setProveid(Integer.parseInt(request.getParameter("pro")));
        obj.adiProd(p);
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void actuProd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Producto p = new Producto();
        p.setId(Integer.parseInt(request.getParameter("cod")));
        p.setNombre(request.getParameter("nom"));
        p.setUnit(Double.parseDouble(request.getParameter("uni")));
        p.setStock(Integer.parseInt(request.getParameter("sto")));
        p.setCateid(Integer.parseInt(request.getParameter("cat")));
        p.setProveid(Integer.parseInt(request.getParameter("pro")));
        obj.modProdu(p);
        String pag = "/comboProdu.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void ediProd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int nro = Integer.parseInt(request.getParameter("cod"));
        request.setAttribute("dato", obj.consulProd(nro));
        String pag = "/EditaProd.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void anuProd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int nro = Integer.parseInt(request.getParameter("cod"));
        obj.anuProd(nro);
        String pag = "/comboProdu.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void busProd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("cod"));
        request.setAttribute("dato", obj.consulProd(id));
        String pag = "/pagDetalle.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void carrito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("coda"));
        int can=Integer.parseInt(request.getParameter("cantidad"));
        Producto pr = obj.consulProd(id);
        Detalle cp= new Detalle();
        cp.setCan(can);
        cp.setId(id);
        cp.setProduc(id);
        cp.setUnit(pr.getUnit());
        List<Detalle> lista;
        HttpSession ses = request.getSession();
        if(ses.getAttribute("canasta")==null){
            lista=new ArrayList();
        } else {
            lista=(ArrayList<Detalle>)ses.getAttribute("canasta");
        }
        boolean existe=false;
        for(Detalle x:lista){
            if(x.getId() ==id){
                existe=true; break;
            }
        }
          if(!existe) lista.add(cp);
            ses.setAttribute("canasta", lista);
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
