
package servelet;

import classes.Bouquet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BouquetServelet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Bouquet bouquet = new Bouquet();
        String nombreBouquet = request.getParameter("nombreBouquet");
        int nbBouquet = Integer.valueOf(nombreBouquet);
        for(int i=1;i<=nbBouquet;i++) {
            String nom = request.getParameter("bouquet"+i);
            bouquet.insertBouquet(null, nom);
        }
        RequestDispatcher dispat =  request.getRequestDispatcher("insertBouquet.jsp");
        dispat.forward(request, response);
    }

   
}
