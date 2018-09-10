/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.klijent;

import domen.Klijent;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Darko
 */
public class KreirajNovogKlijentaSO extends OpstaSO {

    List<OpstiDomenskiObjekat> listaKlijenata;
    
    private Klijent vratiKlijenta() {
        if (listaKlijenata.isEmpty()) {
            return null;
        }
        return (Klijent) listaKlijenata.get(0);
    }
    

    @Override
    protected void izvrsiOperaciju(Object obj) throws Exception {
        listaKlijenata = db.pretrazi(new Klijent());
    }

    public int getNovogKlijenta() {
        if (vratiKlijenta() == null) {
            return 1;
        }
        return vratiKlijenta().getKlijentId() + 1;
    }
}
