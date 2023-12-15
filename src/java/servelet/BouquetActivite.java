
package servelet;

import classes.Activite;
import classes.ActiviteBouquet;
import classes.Bouquet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BouquetActivite extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Bouquet bouquet = new Bouquet();
        Vector<Bouquet> listeBouquet = bouquet.getAllBouquet(null);
        
        Activite activite = new Activite();
        Vector<Activite> listeActivite = activite.getAllActivite(null);
        
        request.setAttribute("listeBouquet", listeBouquet);
        request.setAttribute("listeActivite", listeActivite);
        
        RequestDispatcher dispat =  request.getRequestDispatcher("insertBouquetActivite.jsp");
        dispat.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idbouquet = request.getParameter("bouquet");
        ActiviteBouquet activitesBouquet = new ActiviteBouquet();
        Bouquet bouquet = new Bouquet();
        Bouquet bouquetID = bouquet.getBouquetParID(null, idbouquet);
        String nomBouquet = bouquetID.getNomBouquet();
        Vector<ActiviteBouquet> listeActivites = activitesBouquet.getAllActiviteBouquet(null, idbouquet);
        if(listeActivites.size() == 0) {
            String erreur = "il y a pas d'activites sur cet bouquet";
            request.setAttribute("erreur", erreur);
            RequestDispatcher dispat =  request.getRequestDispatcher("retour.jsp");
            dispat.forward(request, response);
        }else {
            request.setAttribute("listesActivite", listeActivites);
            request.setAttribute("bouquet", nomBouquet);
            RequestDispatcher dispat =  request.getRequestDispatcher("ListeActivites.jsp");
            dispat.forward(request, response);
        }
    }
   
}
