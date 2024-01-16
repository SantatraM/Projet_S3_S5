/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelet;

import classes.*;
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
public class VoyageServelet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Bouquet bouquet = new Bouquet();
        Vector<Bouquet> listeBouquet = bouquet.getAllBouquet(null);
        
        Duree duree = new Duree();
        Vector<Duree> listeDuree = duree.getAllDuree(null);
        
        Categorie categ = new Categorie();
        Vector<Categorie> listeCategorie = categ.getAllCategorie(null);
        
        request.setAttribute("listeBouquet", listeBouquet);
        request.setAttribute("listeDuree", listeDuree);
        request.setAttribute("listeCategorie", listeCategorie);
        
        RequestDispatcher dispat =  request.getRequestDispatcher("insertVoyage.jsp");
        dispat.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idDuree = request.getParameter("duree");
        String categorieLieu = request.getParameter("categorie");
        String bouquet = request.getParameter("bouquet");
        String [] idActivite = request.getParameterValues("idActivite");
        String [] nb = request.getParameterValues("nbActivite");
        Voyage voyage = new Voyage();
        String idVoyage = voyage.insertVoyages(null, idDuree, categorieLieu, bouquet);
        for (int i = 0; i < idActivite.length; i++) {
            String activite = idActivite[i];
            int nbActivite = Integer.parseInt(nb[i]);

            voyage.insertActiviteVoyage(null, idVoyage, activite, nbActivite);
        }
        
        RequestDispatcher dispat =  request.getRequestDispatcher("index.jsp");
        dispat.forward(request, response);
        
    }

   
}
