package forme.polisa.model;

import domen.StavkaPolise;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Darko
 */
public class ModelTabelePolise extends AbstractTableModel {

    private List<StavkaPolise> lp;
    private String[] kolone = {"RB", "Naziv", "Cena"};

    public ModelTabelePolise(List<StavkaPolise> lp) {
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
        StavkaPolise sp = lp.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sp.getRb();
            case 1:
                return sp.getNaziv();
            case 2:
                return sp.getCena();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
}
