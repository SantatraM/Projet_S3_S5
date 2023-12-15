package classes;

import java.sql.*;
import connect.Connexion;
import java.util.Vector;

public class Activite {

    String idActivite;
    String nomActivite;

    public String getIdActivite(){
        return this.idActivite;
    }

    public String getNomActivite() {
        return nomActivite;
    }

    public void setIdActivite(String idActivite) throws Exception{
        if(idActivite == null || idActivite == "") {
            throw new Exception("Le champs ne peut pas etre vide");
        }
        this.idActivite = idActivite;
    }
    public void setNomActivite(String nomActivite) {
        this.nomActivite = nomActivite;
    }

    public Activite() {
    }
    
    

    public Activite(String idActivite, String nomActivite) throws Exception{
        this.setIdActivite(idActivite);
        this.setNomActivite(nomActivite);
    }
    
    public Vector<Activite> getAllActivite(Connection con){
        int estOuvert = 0;
        Vector<Activite> listActivite = new Vector<Activite>();
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }

            String sql = "SELECT * FROM activite";

            Statement prs = con.createStatement();
            ResultSet resultSet = prs.executeQuery(sql);
            
            
            while(resultSet.next()){
                listActivite.add(new Activite(resultSet.getString("idactivite"),resultSet.getString("nomactivite")));
            }
            
            

        } catch (Exception e) {
            
        } finally{
            try {
                if (estOuvert == 1) {
                    con.close();
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        return listActivite;
    }

    public void insertActivite(Connection con,String nom){
        int estOuvert = 0;

        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }

            String sql = "INSERT INTO activite (nomActivite) VALUES('"+nom+"')";

            Statement prs = con.createStatement();

            prs.executeUpdate(sql);


        } catch (Exception e) {
            
        } finally{
            try {
                if (estOuvert == 1) {
                    con.close();
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

}