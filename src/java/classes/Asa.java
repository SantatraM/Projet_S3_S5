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
public class Asa {
    String idAsa;
    String libelle;
    float salaire;

    public Asa() {
    }

    public String getIdAsa() {
        return idAsa;
    }

    public void setIdAsa(String idAsa) {
        this.idAsa = idAsa;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    public Asa(String idAsa, String libelle, float salaire) {
        this.idAsa = idAsa;
        this.libelle = libelle;
        this.salaire = salaire;
    }
    
    public void insertAsa(Connection con, String libelle, float salaire){
        int estOuvert = 0;
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }
            String sql = "INSERT INTO asa(libelle,salaire) VALUES('"+libelle+"',"+salaire+")";
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

        public Vector<Asa> getAllAsa(Connection con){
        int estOuvert = 0;
        Vector<Asa> listAsa = new Vector<Asa>();
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }
            String sql = "SELECT * FROM asa";
            Statement prs = con.createStatement();
            ResultSet resultSet = prs.executeQuery(sql);
            while(resultSet.next()){
                listAsa.add(new Asa(resultSet.getString("idAsa"),resultSet.getString("libelle"),resultSet.getFloat("salaire")));
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
        return listAsa;
    }
}
