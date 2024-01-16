/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import classes.Duree;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author hp
 */
public class DureeServelet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nomDuree = request.getParameter("duree");
        int nbJour  = Integer.valueOf(request.getParameter("nbJour"));
        
        Duree duree = new Duree();
        
        duree.insertDuree(null, nomDuree, nbJour);
        
        RequestDispatcher dispat =  request.getRequestDispatcher("insertDuree.jsp");
        dispat.forward(request, response);
    }

}
