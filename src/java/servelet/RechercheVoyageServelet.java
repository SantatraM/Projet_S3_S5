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
public class RechercheVoyageServelet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("tonga ato");
        Voyage voyage = new Voyage();
        Vector<Voyage> listeVoyage = voyage.getAllVoyage(null);
        request.setAttribute("listesVoyages", listeVoyage);
        RequestDispatcher dispat =  request.getRequestDispatcher("ListesVoyages.jsp");
        dispat.forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String activite = request.getParameter("activite");
        Voyage v = new Voyage();
        Vector<Voyage> listeVoyage = v.getAllVoyageByActivites(null, activite);
        request.setAttribute("listeVoyageActivite", listeVoyage);
        RequestDispatcher dispat = request.getRequestDispatcher("ListVoyageByActivite.jsp");
        dispat.forward(request, response);
    }

}
