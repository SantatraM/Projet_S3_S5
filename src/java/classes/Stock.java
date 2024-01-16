package classes;


import connect.Connexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class Stock {
    String idStock;
    String activite;
    float quantite;
    Date dateStock;

    public Stock() {
    }

    public Stock(String idStock, String activite, float quantite, Date dateStock) {
        this.idStock = idStock;
        this.activite = activite;
        this.quantite = quantite;
        this.dateStock = dateStock;
    }
    
    public void insertStockActivite(Connection con,String idActivite,float quantite,Date dateStock){
        int estOuvert = 0;
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }
            String sql = "INSERT INTO stock(idActivite,quantite,dateStock) VALUES('"+idActivite+"',"+quantite+",'"+dateStock+"')";
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
    
    public void insertSortieStock(Connection con,String idActivite,float quantiteSortie){
        int estOuvert = 0;
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }
            String sql = "INSERT INTO sortie(idActivite,quantitesortie) VALUES('"+idActivite+"',"+quantiteSortie+")";
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
    

    public String getIdStock() {
        return idStock;
    }

    public void setIdStock(String idStock) {
        this.idStock = idStock;
    }

    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    public float getQuantite() {
        return quantite;
    }

    public void setQuantite(float quantite) {
        this.quantite = quantite;
    }

    public Date getDateStock() {
        return dateStock;
    }

    public void setDateStock(Date dateStock) {
        this.dateStock = dateStock;
    }
    
    
}
