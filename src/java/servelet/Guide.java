/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelet;

import classes.Asa;
import classes.Duree;
import classes.Voyage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
public class Guide extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Guide</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Guide at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
                Duree d = new Duree();
        Vector<Duree> listeDuree = d.getAllDuree(null);
        request.setAttribute("listesDurrees", listeDuree);
        
        Asa asa = new Asa();
        Vector<Asa> listesAsa = asa.getAllAsa(null);
        request.setAttribute("listesAsa", listesAsa);
        RequestDispatcher dispat =  request.getRequestDispatcher("InsertNbGuide.jsp");
        dispat.forward(request, response);
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
            String idDuree = request.getParameter("duree");
        
            String nbGuideString = request.getParameter("nbGuide");
            int nbGuide = Integer.valueOf(nbGuideString);
            
            String idAsa = request.getParameter("asa");
            
            
            Duree d = new Duree();
             Vector<Duree> listeDuree = d.getAllDuree(null);
            for(int i=0;i<listeDuree.size();i++) {
                d.insertNbGuide(null, listeDuree.get(i).getId(),idAsa, nbGuide);
                nbGuide = nbGuide * 2 ;
            }
            
            
            RequestDispatcher dispat =  request.getRequestDispatcher("index.jsp");
            dispat.forward(request, response);
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
