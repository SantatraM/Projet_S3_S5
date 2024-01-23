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
public class Bouquet {
    String idBouquet;
    String nomBouquet;

    public Bouquet(String idBouquet, String nomBouquet) {
        this.idBouquet = idBouquet;
        this.nomBouquet = nomBouquet;
    }

    public Bouquet() {
    }

    public String getIdBouquet() {
        return idBouquet;
    }

    public void setIdBouquet(String idBouquet) {
        this.idBouquet = idBouquet;
    }

    public String getNomBouquet() {
        return nomBouquet;
    }

    public void setNomBouquet(String nomBouquet) {
        this.nomBouquet = nomBouquet;
    }
    
    public Vector<Bouquet> getAllBouquet(Connection con){
        int estOuvert = 0;
        Vector<Bouquet> listBouquet = new Vector<Bouquet>();
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }
            String sql = "SELECT * FROM bouquet";
            Statement prs = con.createStatement();
            ResultSet resultSet = prs.executeQuery(sql);
            while(resultSet.next()){
                listBouquet.add(new Bouquet(resultSet.getString("idbouquet"),resultSet.getString("nombouquet")));
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
        return listBouquet;
    }

    public void insertBouquet(Connection con,String nom){
        int estOuvert = 0;
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }
            String sql = "INSERT INTO bouquet(nomBouquet) VALUES('"+nom+"')";
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

    public Bouquet getBouquetParID(Connection con,String idBouquet){
        int estOuvert = 0;
        Bouquet listBouquet = new Bouquet();
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }
            String sql = "SELECT * FROM bouquet where idbouquet='"+idBouquet+"'";
            Statement prs = con.createStatement();
            ResultSet resultSet = prs.executeQuery(sql);
            while(resultSet.next()){
                listBouquet=new Bouquet(resultSet.getString("idbouquet"),resultSet.getString("nombouquet"));
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
        return listBouquet;
    }

        public void insertVolumeHoraire(Connection con, String idBouquet, int duree){
        int estOuvert = 0;
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }
            String sql = "INSERT INTO volumeHoraire(idBouquet,duree) VALUES('"+idBouquet+"',"+duree+")";
            System.out.println(sql);
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
