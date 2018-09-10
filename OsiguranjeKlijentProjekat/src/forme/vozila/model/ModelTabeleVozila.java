/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.vozila.model;

import domen.Vozilo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Darko
 */
public class ModelTabeleVozila extends AbstractTableModel {

    private List<Vozilo> listaVozila;
    private String[] kolone = {"Reg_tablice", "Marka", "Model", "Snaga motora", "Godina proizvodnje"};

    public ModelTabeleVozila(List<Vozilo> lk) {
        listaVozila = lk;
    }

    @Override
    public int getRowCount() {
        if (listaVozila != null) {
            return listaVozila.size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vozilo v = listaVozila.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return v.getRegTablice();
            case 1:
                return v.getMarka();
            case 2:
                return v.getModel();
            case 3:
                return v.getSnagaMotora();
            case 4:
                return v.getGodinaProizvodnje();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
}
