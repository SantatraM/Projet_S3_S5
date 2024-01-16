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
public class Duree {
    String id;
    String nom;
    int nbJour;

    public Duree(String id, String nom, int nbJour) {
        this.id = id;
        this.nom = nom;
        this.nbJour = nbJour;
    }

    public Duree() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbJour() {
        return nbJour;
    }

    public void setNbJour(int nbJour) {
        this.nbJour = nbJour;
    }
    
    public void insertDuree(Connection con,String nom, int nbJour){
        int estOuvert = 0;
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }
            String sql = "INSERT INTO duree (nomDuree,nbJour) VALUES('"+nom+"',"+nbJour+")";
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
      
    public Vector<Duree> getAllDuree(Connection con){
        int estOuvert = 0;
        Vector<Duree> listDuree = new Vector<Duree>();
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }
            String sql = "SELECT * FROM duree";
            Statement prs = con.createStatement();
            ResultSet resultSet = prs.executeQuery(sql);                 
            while(resultSet.next()){
                listDuree.add(new Duree(resultSet.getString("idDuree"),resultSet.getString("nomDuree"),resultSet.getInt("nbJour")));
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
        return listDuree;
    }
}

