/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelet;

import classes.ActiviteBouquet;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
@WebServlet(name = "InsertFormuleVoyage", urlPatterns = {"/InsertFormuleVoyage"})
public class InsertFormuleVoyage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        ActiviteBouquet activitesBouquet = new ActiviteBouquet();
        Vector<ActiviteBouquet> listeActivites = activitesBouquet.getAllActivitesBouquet(null, request.getParameter("idBouquet"));
        
        Gson gson = new Gson();
        
        String jsonStr = gson.toJson(listeActivites);
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println(jsonStr);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
