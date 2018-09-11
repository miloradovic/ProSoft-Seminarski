package so.polisa;

import domen.OpstiDomenskiObjekat;
import domen.Polisa;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Darko
 */
public class KreirajNovuPolisuSO extends OpstaSO {

    List<OpstiDomenskiObjekat> listaPolisa;

    private Polisa vratiPolisu() {
        if (listaPolisa.isEmpty()) {
            return null;
        }
        return (Polisa) listaPolisa.get(0);
    }

    @Override
    protected void izvrsiOperaciju(Object obj) throws Exception {
        listaPolisa = db.pretrazi(new Polisa());
    }

    public int getNovuPolisu() {
        if (vratiPolisu() == null) {
            return 1;
        }
        return vratiPolisu().getPolisaId() + 1;
    }
}
