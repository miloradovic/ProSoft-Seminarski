package forme.klijent.model;

import domen.Klijent;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Darko
 */
public class ModelTabeleKlijent extends AbstractTableModel {

    private List<Klijent> lk;
    private String[] kolone = {"Ime", "Prezime", "JMBG", "Ulica i broj", "Mesto"};

    public ModelTabeleKlijent(List<Klijent> lk) {
        this.lk = lk;
    }

    @Override
    public int getRowCount() {
        if (lk != null) {
            return lk.size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Klijent k = lk.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getIme();
            case 1:
                return k.getPrezime();
            case 2:
                return k.getJmbg();
            case 3:
                return k.getUlicaBroj();
            case 4:
                return k.getMesto().getNaziv();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
}
