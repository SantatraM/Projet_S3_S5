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
public class Profile {
    String id;
    String libelle;

    public Profile() {
    }

    public Profile(String id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
         public static Vector<Profile> getAllProfile(Connection con){
        int estOuvert = 0;
        Vector<Profile> listProfile = new Vector<Profile>();
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }
            String sql = "SELECT * FROM profile";
            Statement prs = con.createStatement();
            ResultSet resultSet = prs.executeQuery(sql);                 
            while(resultSet.next()){
                listProfile.add(new Profile(resultSet.getString("idprofile"),resultSet.getString("libelle")));
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
        return listProfile;
    }
}
