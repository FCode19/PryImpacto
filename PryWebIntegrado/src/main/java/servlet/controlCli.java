/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import com.google.gson.Gson;
import controller.NegocioCli;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cliente;

/**
 *
 * @author diego8658
 */
public class controlCli extends HttpServlet {

    NegocioCli obj = new NegocioCli();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     int op=Integer.parseInt(request.getParameter("opc"));
     if(op==1)adiCli(request, response);
     if(op==2)actuCli(request, response);
     if(op==3)ediCli(request, response);
     if(op==4)anuCli(request, response);
     if(op==5)filtra(request, response);
     if(op==6)consulDir(request, response);
    }
    
    protected void adiCli(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cliente c = new Cliente();
        String pag = request.getParameter("pag");
        c.setNombre(request.getParameter("nom"));
        c.setDirecc(request.getParameter("direc"));
        c.setEmail(request.getParameter("ema"));
        c.setTelef(request.getParameter("tel"));
        c.setContra(request.getParameter("contra"));
        obj.adiCli(c);
        if(pag.equals("pagPrincipal.jsp")){
            pag = "pagListArt.jsp";
            HttpSession ses = request.getSession();
            ses.setAttribute("cliente", c);
        }
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void actuCli(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cliente c = new Cliente();
        c.setId(Integer.parseInt(request.getParameter("cod")));
        c.setNombre(request.getParameter("nom"));
        c.setDirecc(request.getParameter("direc"));
        c.setEmail(request.getParameter("ema"));
        c.setTelef(request.getParameter("tel"));
        c.setContra(request.getParameter("contra"));
        obj.modiCli(c);
        String pag = "/LisCliente.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void ediCli(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int nro = Integer.parseInt(request.getParameter("cod"));
        request.setAttribute("dato", obj.consulCli(nro));
        String pag = "/EditaCli.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void anuCli(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int nro = Integer.parseInt(request.getParameter("cod"));
        obj.anuCli(nro);
        String pag = "/LisCliente.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void filtra(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom =request.getParameter("consulta");
        PrintWriter out = response.getWriter();
        Gson gs = new Gson();
        out.print(gs.toJson(obj.filtraraCliente(nom)));
    }
    
     protected void consulDir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String ema = request.getParameter("ema");
         String con = request.getParameter("contra");
        Cliente c = new Cliente();
        c = obj.consulCliDic(ema);
        String pag ="";
        if(c!=null){
            if(con.equals(c.getContra())){
                pag = "/pagPrincipal.jsp";
                HttpSession ses = request.getSession();
                ses.setAttribute("cliente", c);
            }else
                pag = "/pagRegistra.jsp";
        }else{
        pag="/pagRegistra.jsp";
        }
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
