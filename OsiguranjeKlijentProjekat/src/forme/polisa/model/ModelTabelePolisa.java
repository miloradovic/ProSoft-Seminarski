package forme.polisa.model;

import domen.Polisa;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Darko
 */
public class ModelTabelePolisa extends AbstractTableModel {

    private List<Polisa> lp;
    private String[] kolone = {"ID", "Klijent", "Vozilo", "Ukupno", "Premijski stepen", "Datum ugovaranja", "Datum raskidanja"};

    public ModelTabelePolisa(List<Polisa> lp) {
        this.lp = lp;
    }

    @Override
    public int getRowCount() {
        if (lp != null) {
            return lp.size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Polisa sp = lp.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sp.getPolisaId();
            case 1:
                return sp.getKlijent();
            case 2:
                return sp.getVozilo();
            case 3:
                return sp.getUkupno();
            case 4:
                return sp.getPremijskiStepen();
            case 5:
                return sp.getDatumUgovaranja();
            case 6:
                return sp.getDatumRaskidanja();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
}
