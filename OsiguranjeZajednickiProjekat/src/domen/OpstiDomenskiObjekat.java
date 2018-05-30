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

    List<OpstiDomenskiObjekat> vratiListuIzResultSeta(ResultSet rs) throws Exception;

    OpstiDomenskiObjekat vratiObjekatIzResultSeta(ResultSet rs) throws Exception;

}
