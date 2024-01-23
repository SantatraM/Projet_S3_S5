/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import connect.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author hp
 */
public class Voyage {
    String idVoyage;
    String duree;
    String categorieLieu;
    String bouquet;
    String activites;
    int nbJour;
    int nbactivite;
    float tarifVoyage;
    float benefice;
    public Voyage() {
    }

    public Voyage(String idVoyage, String categorieLieu, String bouquet,String activite,int nbjour,int nbactivite) {
        this.idVoyage = idVoyage;
        this.categorieLieu = categorieLieu;
        this.bouquet = bouquet;
        this.activites = activite;
        this.nbJour = nbjour;
        this.nbactivite = nbactivite;
    }

    public Voyage(String idVoyage, String categorieLieu, String bouquet, int nbJour) {
        this.idVoyage = idVoyage;
        this.categorieLieu = categorieLieu;
        this.bouquet = bouquet;
        this.nbJour = nbJour;
    }

    public Voyage(String idVoyage, String categorieLieu, String bouquet, float tarifVoyage) throws Exception{
        this.idVoyage = idVoyage;
        this.categorieLieu = categorieLieu;
        this.bouquet = bouquet;
        this.setTarifVoyage(tarifVoyage);
    }
    
    
    public void reserverVoyage(Connection con ,String idVoyage) throws Exception {
        
        Activite a  = new Activite();
        Stock s = new Stock();
        int resteActivite = 0;
        Vector<Activite> activite = a.getActiviteByVoyage(con, idVoyage);
        int quantiteActivite = 0;
        for(int i=0;i<activite.size();i++) {
            quantiteActivite = activite.get(i).getNombreActivite();
            resteActivite = a.getResteActivite(con, activite.get(i).getIdActivite(),quantiteActivite);
            
            if ( resteActivite > quantiteActivite) {
                s.insertSortieStock(con, activite.get(i).getIdActivite(), quantiteActivite);
            }else{
                throw new Exception("la quantite est indisponible pour l'activite :"+ activite.get(i).getNomActivite());
            }
        }
        
    }
    
    public void insertActiviteVoyage(Connection con,String idvoyage,String idactivite,int nombreActivite){
        int estOuvert = 0;
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }
            String sql = "INSERT INTO activitevoyage(idvoyage,idactivite,nombreActivite) VALUES('"+idvoyage+"','"+idactivite+"',"+nombreActivite+")";
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
    
    public String insertVoyages(Connection con, String duree, String categorieLieu, String bouquet) {
        int estOuvert = 0;
        String generatedId = ""; // Initialiser à une valeur par défaut

        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }

            String sql = "INSERT INTO formuleVoyage(idduree, idcategorielieu, idbouquet) VALUES (?, ?, ?)";
            // Utiliser PreparedStatement pour éviter les injections SQL
            PreparedStatement prs = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            prs.setString(1, duree);
            prs.setString(2, categorieLieu);
            prs.setString(3, bouquet);

            int rowsAffected = prs.executeUpdate();

            if (rowsAffected > 0) {
                // Récupérer l'ID généré
                ResultSet generatedKeys = prs.getGeneratedKeys();
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getString("idvoyage");
                }
            }

        } catch (Exception e) {
            e.printStackTrace(); // Gestion des erreurs
        } finally {
            try {
                if (estOuvert == 1) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace(); // Gestion des erreurs
            }
        }

        return generatedId;
    }
    
    public Vector<Voyage> getAllVoyage(Connection con){
        int estOuvert = 0;
        Vector<Voyage> listeVoyage = new Vector<Voyage>();
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }
            
            String sql = "SELECT * FROM v_voyage";
            System.out.println(sql);
            Statement prs = con.createStatement();
            ResultSet resultSet = prs.executeQuery(sql);                 
            while(resultSet.next()){
                listeVoyage.add(new Voyage(resultSet.getString("idvoyage"), resultSet.getString("nomcategorielieu"), resultSet.getString("nombouquet"), resultSet.getInt("nbjour")));
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
        return listeVoyage;
    }
    
    public Vector<Voyage> getAllVoyageByActivites(Connection con,String activite){
        int estOuvert = 0;
        Vector<Voyage> listeVoyage = new Vector<Voyage>();
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }
            
            String sql = "SELECT * FROM v_voyageActivite where nomactivite like '"+activite+"%'";
            System.out.println(sql);
            Statement prs = con.createStatement();
            ResultSet resultSet = prs.executeQuery(sql);                 
            while(resultSet.next()){
                listeVoyage.add(new Voyage(resultSet.getString("idvoyage"),  resultSet.getString("nomcategorielieu"),
                resultSet.getString("nombouquet"), resultSet.getString("nomactivite"), resultSet.getInt("nbjour"), resultSet.getInt("nombreactivite")));
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
        return listeVoyage;
    }
    
    public Vector<Voyage> getAllVoyageByID(Connection con,String idvoyage){
        int estOuvert = 0;
        Vector<Voyage> listeVoyage = new Vector<Voyage>();
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }
            
            String sql = "SELECT * FROM v_voyageActivite where idvoyage='"+idvoyage+"'";
            System.out.println(sql);
            Statement prs = con.createStatement();
            ResultSet resultSet = prs.executeQuery(sql);                 
            while(resultSet.next()){
                listeVoyage.add(new Voyage(resultSet.getString("idvoyage"),  resultSet.getString("nomcategorielieu"),
                resultSet.getString("nombouquet"), resultSet.getString("nomactivite"), resultSet.getInt("nbjour"), resultSet.getInt("nombreactivite")));
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
        return listeVoyage;
    }
    
    public Vector<Voyage> getVoyageEntre2Tarif(Connection con,float tarif1,float tarif2) throws Exception {
        int estOuvert = 0;
        Vector<Voyage> listeVoyage = new Vector<Voyage>();
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }
            
            String sql = "SELECT * FROM v_tariftotalvoyage where tarif between "+tarif1+" and "+tarif2;
            System.out.println(sql);
            System.out.println(sql);
            Statement prs = con.createStatement();
            ResultSet resultSet = prs.executeQuery(sql);                 
            while(resultSet.next()){
                listeVoyage.add(new Voyage(resultSet.getString("idvoyage"),  resultSet.getString("nomcategorielieu"),
                resultSet.getString("nombouquet"), resultSet.getFloat("tarif")));
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
        return listeVoyage;
    }

    public String getIdVoyage() {
        return idVoyage;
    }

    public void setIdVoyage(String idVoyage) {
        this.idVoyage = idVoyage;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getCategorieLieu() {
        return categorieLieu;
    }

    public void setCategorieLieu(String categorieLieu) {
        this.categorieLieu = categorieLieu;
    }

    public String getBouquet() {
        return bouquet;
    }

    public void setBouquet(String bouquet) {
        this.bouquet = bouquet;
    }

    public String getActivites() {
        return activites;
    }

    public void setActivites(String activites) {
        this.activites = activites;
    }

    public int getNbJour() {
        return nbJour;
    }

    public void setNbJour(int nbJour) {
        this.nbJour = nbJour;
    }

    public int getNbactivite() {
        return nbactivite;
    }

    public void setNbactivite(int nbactivite) {
        this.nbactivite = nbactivite;
    }

    public float getTarifVoyage() {
        return tarifVoyage;
    }

    public void setTarifVoyage(float tarifVoyage) throws Exception{
        if(tarifVoyage < 0){
            throw new Exception("tarif invalide");
        }
        this.tarifVoyage = tarifVoyage;
    }
    
    public void setTarifVoyage(String tarifVoyage) throws Exception {
        if(tarifVoyage == "" || tarifVoyage==null){
            throw new Exception("tarif invalide");
        }
        this.tarifVoyage = Float.valueOf(tarifVoyage);
    }

    public float getBenefice() {
        return benefice;
    }

    public void setBenefice(float benefice) {
        this.benefice = benefice;
    }

    public Voyage(String idVoyage, float benefice) {
        this.idVoyage = idVoyage;
        this.benefice = benefice;
    }
    
    public Vector<Voyage> getBenefice(Connection con) throws Exception {
        int estOuvert = 0;
        Vector<Voyage> listeVoyage = new Vector<Voyage>();
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }
            
            String sql = "SELECT * FROM v_benefice ";
            System.out.println(sql);
            System.out.println(sql);
            Statement prs = con.createStatement();
            ResultSet resultSet = prs.executeQuery(sql);                 
            while(resultSet.next()){
                listeVoyage.add(new Voyage(resultSet.getString("idvoyage"), resultSet.getFloat("benefice")));
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
        return listeVoyage;
    }
    
    public Vector<Voyage> getBeneficeIntervalle(Connection con,float benefice1,float benefice2) throws Exception {
        int estOuvert = 0;
        Vector<Voyage> listeVoyage = new Vector<Voyage>();
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }
            
            String sql = "SELECT * FROM v_benefice where benefice between "+benefice1+" and "+benefice2;
            System.out.println(sql);
            Statement prs = con.createStatement();
            ResultSet resultSet = prs.executeQuery(sql);                 
            while(resultSet.next()){
                listeVoyage.add(new Voyage(resultSet.getString("idvoyage"), resultSet.getFloat("benefice")));
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
        return listeVoyage;
    }
    
    public void insertVoyagePix(Connection con, String idVoyage, float prixVente){
        int estOuvert = 0;
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }
            String sql = "INSERT INTO voyagePrix(idvoyage,prixvente) VALUES('"+idVoyage+"',"+prixVente+")";
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
