package forme.polisa.model;

import domen.Polisa;
import domen.StavkaPolise;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Darko
 */
public class ModelTabeleStavkaPolise extends AbstractTableModel {

    private Polisa polisa;
    private String[] kolone = {"RB", "Naziv", "Cena"};
    DecimalFormat df = new DecimalFormat("#.##");    

    public ModelTabeleStavkaPolise(Polisa polisa) {
        this.polisa = polisa;
    }

    @Override
    public int getRowCount() {
        if (polisa == null) {
            return 0;
        }
        return polisa.getListaStavki().size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaPolise sp = polisa.getListaStavki().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sp.getRb();
            case 1:
                return sp.getNaziv();
            case 2:
                df.setRoundingMode(RoundingMode.CEILING);
                return df.format(sp.getCena());

            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void dodajStavku(StavkaPolise sp) {
        polisa.getListaStavki().add(sp);
        polisa.pripremiPolisu();
        fireTableDataChanged();
    }

    public void obrisiStavku(int index) {
        polisa.getListaStavki().remove(index);
        polisa.pripremiPolisu();
        fireTableDataChanged();
    }

    public Polisa getPolisa() {
        return polisa;
    }
}
