package db;

import util.SettingsLoader;
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
    private Statement sqlStatement;

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

    public int sacuvaj(OpstiDomenskiObjekat odo) throws Exception {
        int id = -1;
        try {
            System.out.println(odo.unos());
            sqlStatement = connection.createStatement();
            int key = sqlStatement.executeUpdate(odo.unos(), Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = sqlStatement.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            sqlStatement.close();
            return id;
        } catch (SQLException ex) {
            throw new Exception("Neuspesno cuvanje objekta!", ex);
        }
    }

    public void obrisi(OpstiDomenskiObjekat odo) throws Exception {
        try {
            System.out.println(odo.brisanje());
            sqlStatement = connection.createStatement();
            sqlStatement.executeUpdate(odo.brisanje());
            sqlStatement.close();
        } catch (SQLException e) {
            throw new Exception("Neuspesno brisanje objekta!", e);
        }
    }

    public void izmeni(OpstiDomenskiObjekat odo) throws Exception {
        try {
            System.out.println(odo.izmena());
            sqlStatement = connection.createStatement();
            sqlStatement.executeUpdate(odo.izmena());
            sqlStatement.close();
        } catch (SQLException e) {
            throw new Exception("Neuspesna izmena objekta!", e);
        }
    }

    public List<OpstiDomenskiObjekat> pretrazi(OpstiDomenskiObjekat odo) throws Exception {
        try {
            System.out.println(odo.pretraga());
            sqlStatement = connection.createStatement();
            List list = odo.ucitaj(sqlStatement.executeQuery(odo.pretraga()));
            sqlStatement.close();
            return list;
        } catch (Exception e) {
            throw new Exception("Neuspesna pretraga: " + e);
        }
    }

}
