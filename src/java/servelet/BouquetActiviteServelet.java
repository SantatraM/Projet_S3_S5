package servelet;

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

public class BouquetActiviteServelet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idBouquet = request.getParameter("bouquet");
        String[] idActivite = request.getParameterValues("activite");
        ActiviteBouquet activites = new ActiviteBouquet();
        for(String activite : idActivite) {
            activites.insertActiviteBouquet(null, idBouquet, activite);
        }
        RequestDispatcher dispat =  request.getRequestDispatcher("index.jsp");
        dispat.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Bouquet bouquet = new Bouquet();
        Vector<Bouquet> listeBouquet = bouquet.getAllBouquet(null);
        
        request.setAttribute("listeBouquet", listeBouquet);
        RequestDispatcher dispat =  request.getRequestDispatcher("ActiviteBouquet.jsp");
        dispat.forward(request, response);
    }
}
