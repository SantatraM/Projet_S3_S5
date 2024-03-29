package servelet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Activite;
import java.util.Vector;
import javax.servlet.RequestDispatcher;

public class ActiviteServelet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreActivite = request.getParameter("nombreActivite");
        int nbActivite = Integer.valueOf(nombreActivite);
        Activite activite = new Activite();
        for(int i=1;i<=nbActivite;i++) {
            String nom = request.getParameter("activite"+i);
            activite.insertActivite(null, nom);
        }
        RequestDispatcher dispat =  request.getRequestDispatcher("insertActivity.jsp");
        dispat.forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Activite activite = new Activite();
        Vector<Activite> listeActivites = activite.getActiviteAndReste(null);
        request.setAttribute("listeActivites", listeActivites);
        RequestDispatcher dispat =  request.getRequestDispatcher("Activites.jsp");
        dispat.forward(request, response);
    }
}
