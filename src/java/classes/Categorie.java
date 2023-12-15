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
public class Categorie {
    String idCategorie;
    String nomCategorie;

    public Categorie(String idCategorie, String nomCategorie) {
        this.idCategorie = idCategorie;
        this.nomCategorie = nomCategorie;
    }

    public Categorie() {
    }

    public String getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(String idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }
    
    public Vector<Categorie> getAllCategorie(Connection con){
        int estOuvert = 0;
        Vector<Categorie> listCategorie = new Vector<Categorie>();
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }

            String sql = "SELECT * FROM categorie";

            Statement prs = con.createStatement();
            ResultSet resultSet = prs.executeQuery(sql);
            
            
            while(resultSet.next()){
                listCategorie.add(new Categorie(resultSet.getString("idcategorie"),resultSet.getString("nomcategorie")));
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
        return listCategorie;
    }

    public void insertCategorie(Connection con,String nom){
        int estOuvert = 0;

        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }

            String sql = "INSERT INTO categorielieu (nomcategorielieu) VALUES('"+nom+"')";
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
