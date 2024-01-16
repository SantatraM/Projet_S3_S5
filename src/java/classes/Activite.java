package classes;

import java.sql.*;
import connect.Connexion;
import java.util.Vector;

public class Activite {

    String idActivite;
    String nomActivite;
    int nombreActivite;
    int reste;

    public int getReste() {
        return reste;
    }

    public void setReste(int reste) {
        this.reste = reste;
    }
    
    

    public String getIdActivite(){
        return this.idActivite;
    }

    public String getNomActivite() {
        return nomActivite;
    }

    public int getNombreActivite() {
        return nombreActivite;
    }

    public void setNombreActivite(int nombreActivite) {
        this.nombreActivite = nombreActivite;
    }

    public Activite(String idActivite, int nombreActivite) {
        this.idActivite = idActivite;
        this.nombreActivite = nombreActivite;
    }

    public Activite(String idActivite, String nomActivite, int nombreActivite) {
        this.idActivite = idActivite;
        this.nomActivite = nomActivite;
        this.nombreActivite = nombreActivite;
    }

    public Activite(String idActivite, int reste, String nomActivite) {
        this.idActivite = idActivite;
        this.nomActivite = nomActivite;
        this.reste = reste;
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
    
    public Vector<Activite> getActiviteByVoyage(Connection con,String idVoyage){
        int estOuvert = 0;
        Vector<Activite> listActivite = new Vector<Activite>();
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }
            String sql = "SELECT * FROM v_activitevoyage where idvoyage='"+idVoyage+"'";
            System.out.println(sql);
            Statement prs = con.createStatement();
            ResultSet res = prs.executeQuery(sql);                 
            while(res.next()){
                listActivite.add(new Activite(res.getString("idactivite"), res.getString("nomactivite"), res.getInt("nombreactivite")));
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
    
    public int getResteActivite(Connection con,String idActivite,int nbActivite){
        int estOuvert = 0;
        int reste = 0;
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }
            String sql = "SELECT * FROM v_etatStockActivite where idactivite='"+idActivite+"'";
            Statement prs = con.createStatement();
            ResultSet res = prs.executeQuery(sql);                 
            while(res.next()){
                reste = res.getInt("reste");
               
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
        return reste;
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
    
    public void insertTarifActivite(Connection con,String idActivite,float tarif){
        int estOuvert = 0;
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }
            String sql = "INSERT INTO tarifActivite (idActivite,tarif) VALUES('"+idActivite+"',"+tarif+")";
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

    public Vector<Activite> getActiviteAndReste(Connection con){
        int estOuvert = 0;
        Vector<Activite> listActivite = new Vector<Activite>();
        try {
            if (con == null) {
                Connexion c = new Connexion();
                con = c.getConnection();
                estOuvert = 1;
            }
            String sql = "SELECT * FROM v_etatStockActivite";
            System.out.println(sql);
            Statement prs = con.createStatement();
            ResultSet res = prs.executeQuery(sql);                 
            while(res.next()){
                listActivite.add(new Activite(res.getString("idactivite"),res.getInt("reste"),res.getString("nomactivite")));
            }
        } catch (Exception e) {
            e.printStackTrace();
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
}