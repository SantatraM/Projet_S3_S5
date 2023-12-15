package main;
import classes.Activite;
import connect.Connexion;
import java.util.Vector;
public class Main {
    public static void main(String[] args) throws Exception {
        Connexion c = new Connexion();

        c.getConnection();
        Activite a = new Activite();
//        a.insertActivite(null, "test");
        
        Vector<Activite> listActivite = a.getAllActivite(null);
        
        for(Activite ac : listActivite){
            System.out.println(ac.getNomActivite());
        }
    }
}