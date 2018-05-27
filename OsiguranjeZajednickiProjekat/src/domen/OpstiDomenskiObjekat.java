package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Darko
 */
public interface OpstiDomenskiObjekat extends Serializable {

    String vratiNazivTabele();

    String vratiAtributeZaInsert();

    String vratiVrednostiZaInsert();

    List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception;

}
