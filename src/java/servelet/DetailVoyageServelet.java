/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelet;

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
public class DetailVoyageServelet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idVoyage = request.getParameter("idvoyage");
//        System.out.println(idVoyage);
        Voyage voyage = new Voyage();
        Vector<Voyage> listeVoyage = voyage.getAllVoyageByID(null, idVoyage);
        
        request.setAttribute("listeVoyage", listeVoyage);
        RequestDispatcher dispat = request.getRequestDispatcher("detailVoyage.jsp");
        dispat.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


}
