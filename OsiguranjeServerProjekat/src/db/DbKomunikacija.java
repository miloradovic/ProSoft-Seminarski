package db;

import domen.OpstiDomenskiObjekat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Darko
 */
public class DbKomunikacija {

    private Connection connection;

    public void ucitajDriver() throws Exception {
        try {
            Class.forName(SettingsLoader.getInstance().getValue("driver"));
        } catch (ClassNotFoundException ex) {
            throw new Exception("Neodgovarajuci driver!" + ex.getMessage());
        }
    }

    public void otvoriKonekciju() throws Exception {
        try {
            String url = SettingsLoader.getInstance().getValue("url");
            String user = SettingsLoader.getInstance().getValue("user");
            String password = SettingsLoader.getInstance().getValue("password");
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false); // Zahteva eksplicitnu potvrdu transakcije
        } catch (SQLException ex) {
            throw new Exception("Konekcija nije uspostavljena!" + ex.getMessage());
        }
    }

    public void zatvoriKonekciju() throws Exception {
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new Exception("Konekcija nije zatvorena! " + ex.getMessage());
        }
    }

    public void commitTransakcije() throws Exception {
        try {
            connection.commit();
        } catch (SQLException ex) {
            throw new Exception("Neuspesan commit transakcije! " + ex.getMessage());
        }
    }

    public void rollbackTransakcije() throws Exception {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            throw new Exception("Neuspesan rollback transakcije! " + ex.getMessage());
        }
    }

    public void sacuvaj(OpstiDomenskiObjekat odo) {
        // TODO        
    }

    public void obrisi(OpstiDomenskiObjekat odo) {
        // TODO
    }

    public void izmeni(OpstiDomenskiObjekat odo) {
        // TODO
    }

    public void getID() {
        // TODO
    }

    public List<OpstiDomenskiObjekat> vratiSveObjekte(OpstiDomenskiObjekat odo) throws Exception {
        try {
            String sql = "SELECT * FROM " + odo.vratiNazivTabele();
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            return odo.vratiListuIzResultSeta(rs);
        } catch (SQLException ex) {
            throw new Exception("Neuspesno ucitavanje objekata!", ex);
        }
    }

    public OpstiDomenskiObjekat vratiObjekat(OpstiDomenskiObjekat odo) {
        // TODO
        return odo;
    }

    public List<OpstiDomenskiObjekat> pretraziObjekte(int tipPretrage, Object parametarPretrage, OpstiDomenskiObjekat odo) {
        // TODO
        return null;
    }

//    public Referent nadjiReferenta(Referent login) throws Exception {
//        Referent r = new Referent();
//        try {
//            String sql = "SELECT * FROM Referent WHERE '" + login.getUser()
//                    + "' = KorisnickoIme AND '" + login.getPass() + "' = KorisnickaSifra";
//            Statement sqlStatement = connection.createStatement();
//            ResultSet rs = sqlStatement.executeQuery(sql);
//            if (rs.next()) {
//                r.setReferentId(rs.getInt(1));
//                r.setIme(rs.getString(2));
//                r.setPrezime(rs.getString(3));
//                r.setUser(rs.getString(4));
//                r.setPass(rs.getString(5));
//            }
//        } catch (SQLException e) {
//            throw new Exception("Neuspesno ucitavanje referenta " + e.getMessage());
//        }
//        return r;
//    }
//    public static void main(String[] args) {
//        try {
//            DbKomunikacija db = new DbKomunikacija();
//            db.ucitajDriver();
//            db.otvoriKonekciju();
//            Referent r = db.nadjiReferenta(new Referent("admin", "admin"));
//            db.zatvoriKonekciju();
//            System.out.println(r.toString());
//        } catch (Exception ex) {
//            System.out.println("Greska: " + ex);
//        }
//    }
}
