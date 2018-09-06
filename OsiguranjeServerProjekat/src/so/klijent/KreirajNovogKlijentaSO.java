/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.klijent;

import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Darko
 */
public class KreirajNovogKlijentaSO extends OpstaSO {

    List<OpstiDomenskiObjekat> listaKlijenata;

    @Override
    protected void izvrsiOperaciju(Object obj) throws Exception {
        listaKlijenata = db.pretrazi((OpstiDomenskiObjekat) obj);
    }

    public int getNovogKlijenta() {
        if (listaKlijenata.isEmpty()) {
            return 0;
        }
        return listaKlijenata.size() + 1;
    }
}
