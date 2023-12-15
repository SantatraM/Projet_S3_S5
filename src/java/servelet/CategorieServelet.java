
package servelet;

import classes.Categorie;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CategorieServelet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Categorie categorie = new Categorie();
        
        String nombreCategorie = request.getParameter("nombreCategorie");
        int nbCategorie = Integer.valueOf(nombreCategorie);
        for(int i=1;i<=nbCategorie;i++) {
            String nom = request.getParameter("categorie"+i);
            categorie.insertCategorie(null, nom);
        }
        
        RequestDispatcher dispat =  request.getRequestDispatcher("insertCategorie.jsp");
        dispat.forward(request, response);
    }

   
}
