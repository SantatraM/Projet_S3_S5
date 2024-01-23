/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import connect.Connexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author hp
 */
public class Employer {
    String id;
    String nom;
    String prenom;
    String mail;
    String adresse;
    Date dateEmbauche;
    String profile;
    float tauxhoraire;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public float getTauxhoraire() {
        return tauxhoraire;
    }

    public void setTauxhoraire(float tauxhoraire) {
        this.tauxhoraire = tauxhoraire;
    }
    
    

    public Employer(String id,String nom, String prenom, String mail, String adresse, Date dateEmbauche) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.adresse = adresse;
        this.dateEmbauche = dateEmbauche;
    }

    public Employer(String id, String nom, String prenom, String mail, String adresse, Date dateEmbauche, String profile, float tauxhoraire) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.adresse = adresse;
        this.dateEmbauche = dateEmbauche;
        this.profile = profile;
        this.tauxhoraire = tauxhoraire;
    }
    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public static void insertProfil(Connection con,String libelle){
                int estOuvert = 0;
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }
            String sql = "INSERT INTO profile (libelle) VALUES('"+libelle+"')";
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
    
        public static void insertPoste(Connection con,String idEmploye,String idAsa){
                int estOuvert = 0;
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }
            String sql = "INSERT INTO employePost (idemploye,idasa) VALUES('"+idEmploye+"','"+idAsa+"')";
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
    
    
    public static void insertTauxHoraire(Connection con,String profile,Float txh){
                int estOuvert = 0;
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }
            String sql = "INSERT INTO tauxHoraireProfile (idprofile,tauxhoraire) VALUES('"+profile+"',"+txh+")";
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
    
    public static void insertEmployer(Connection con,String nom, String prenom, String mail, String adresse, Date dateEmbauche){
                int estOuvert = 0;
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }
            String sql = "INSERT INTO employe (nom,prenom,mail,adresse,dateembauche) VALUES('"+nom+"','"+prenom+"','"+mail+"','"+adresse+"','"+dateEmbauche+"')";
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
    
        public static  Vector<Employer> getAllEmployer(Connection con){
        int estOuvert = 0;
        Vector<Employer> listEmployer = new Vector<Employer>();
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }
            String sql = "SELECT * FROM v_tauxHoraireProfile";
            Statement prs = con.createStatement();
            ResultSet resultSet = prs.executeQuery(sql);                 
            while(resultSet.next()){
                listEmployer.add(new Employer(resultSet.getString("idemploye"),resultSet.getString("nom")
                        ,resultSet.getString("prenom"),resultSet.getString("mail"),resultSet.getString("adresse")
                        ,resultSet.getDate("dateEmbauche"),resultSet.getString("profile"),resultSet.getFloat("tauxhoraire")));
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
        return listEmployer;
    }
}
