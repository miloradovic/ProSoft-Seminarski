package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Darko
 */
public interface OpstiDomenskiObjekat extends Serializable {

    String unos();

    String izmena();

    String brisanje();
    
    String pretraga();

    List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception;

}
