package db;

import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import domen.Referent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
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

    public List<Mesto> vratiMesta() throws Exception {
        List<Mesto> lm = new LinkedList<>();
        try {
            String sql = "SELECT * FROM Mesto";
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            while (rs.next()) {
                int ptt = rs.getInt(1);
                String naziv = rs.getString(2);
                Mesto m = new Mesto(ptt, naziv);
                lm.add(m);
            }
            return lm;
        } catch (SQLException ex) {
            throw new Exception("Neuspesno ucitavanje liste mesta! " + ex.getMessage());
        }
    }

    public Referent nadjiReferenta(Referent login) throws Exception {
        Referent r = new Referent();
        try {
            String sql = "SELECT * FROM Referent WHERE " + login.getUser()
                    + " = KorisnickoIme AND " + login.getPass() + " = KorisnickaSifra";
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            if (rs.next()) {
                r.setReferentId(rs.getInt(1));
                r.setIme(rs.getString(2));
                r.setPrezime(rs.getString(3));
                r.setUser(rs.getString(4));
                r.setPass(rs.getString(5));
            }
        } catch (SQLException e) {
            throw new Exception("Neuspesno ucitavanje referenta " + e.getMessage());
        }
        return r;
    }

    public List<OpstiDomenskiObjekat> vratiSve(OpstiDomenskiObjekat odo) throws Exception {
        try {
            String sql = "SELECT * FROM " + odo.vratiNazivTabele();
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            return odo.ucitaj(rs);
        } catch (SQLException ex) {
            throw new Exception("Neuspesno ucitavanje objekata!", ex);
        }
    }
}
