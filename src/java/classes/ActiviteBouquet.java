/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import connect.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author hp
 */
public class ActiviteBouquet {
    String idActiviteBouquet;
    String Bouquet;
    String Activite;

    public ActiviteBouquet() {
    }

    public ActiviteBouquet(String idActiviteBouquet, String Bouquet, String Activite) {
        this.idActiviteBouquet = idActiviteBouquet;
        this.Bouquet = Bouquet;
        this.Activite = Activite;
    }
    
    
    
    public void insertActiviteBouquet(Connection con,String idbouquet,String idActivite){
        int estOuvert = 0;

        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }

            String sql = "INSERT INTO bouquetActivite(idbouquet,idactivite) VALUES('"+idbouquet+"','"+idActivite+"')";

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

    public Vector<ActiviteBouquet> getAllActiviteBouquet(Connection con,String Bouquet){
        int estOuvert = 0;
        Vector<ActiviteBouquet> listBouquet = new Vector<ActiviteBouquet>();
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }
            String sql = "SELECT * FROM v_bouquetActivite where idbouquet='"+Bouquet+"'";
            Statement prs = con.createStatement();
            ResultSet resultSet = prs.executeQuery(sql);
            while(resultSet.next()){
                listBouquet.add(new ActiviteBouquet(resultSet.getString("idbouquetactivite"),resultSet.getString("nombouquet"), resultSet.getString("nomactivite")));
            }
        } catch (Exception e) {
        } finally{
            try {
                if (estOuvert == 1) {
                    con.close();
                }
            } catch (Exception e) {
            }
        }
        return listBouquet;
    }

    public String getIdActiviteBouquet() {
        return idActiviteBouquet;
    }

    public void setIdActiviteBouquet(String idActiviteBouquet) {
        this.idActiviteBouquet = idActiviteBouquet;
    }

    public String getBouquet() {
        return Bouquet;
    }

    public void setBouquet(String Bouquet) {
        this.Bouquet = Bouquet;
    }

    public String getActivite() {
        return Activite;
    }

    public void setActivite(String Activite) {
        this.Activite = Activite;
    }

    
}
