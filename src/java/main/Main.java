package main;
import classes.Activite;
import classes.Categorie;
import connect.Connexion;
import java.sql.Connection;
import java.util.Vector;
public class Main {
    public static void main(String[] args) throws Exception {
        Connexion c = new Connexion();
        Connection con = c.getConnection();
        c.getConnection();
        Categorie a = new Categorie();
//        a.insertActivite(null, "test");
        
        Activite activite = new Activite();
        Vector<Activite> listeActivites = activite.getActiviteAndReste(con);
        
        System.out.println(listeActivites.size());
        for(int i =0;i<listeActivites.size();i++) {

            System.out.println(listeActivites.get(i).getNomActivite() +" " + listeActivites.get(i).getReste());
        }
    }
}