package forme.klijent;

import domen.Klijent;
import forme.klijent.model.ModelTabeleKlijent;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Window;
import java.io.IOException;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import kontroler.Kontroler;
import util.Sesija;

/**
 *
 * @author Darko
 */
public class FrmPretragaKlijenata extends javax.swing.JPanel {

    /**
     * Creates new form FrmPretragaKlijenata
     */
    public FrmPretragaKlijenata() {
        initComponents();
        srediFormu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPretraga = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblKlijent = new javax.swing.JTable();
        btnIzmeni = new javax.swing.JButton();
        btnOdustani = new javax.swing.JButton();

        jLabel1.setText("Pretraga: ");

        txtPretraga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPretragaActionPerformed(evt);
            }
        });

        jtblKlijent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtblKlijent);

        btnIzmeni.setText("Izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnOdustani.setText("Odustani");
        btnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdustaniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtPretraga))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIzmeni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOdustani)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIzmeni)
                    .addComponent(btnOdustani))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        SwingUtilities.getWindowAncestor(this).dispose();
    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        int red = jtblKlijent.convertRowIndexToModel(jtblKlijent.getSelectedRow());
        if (red != -1) {
            ModelTabeleKlijent mtk = (ModelTabeleKlijent) jtblKlijent.getModel();
            Klijent k = mtk.vratiKlijenta(red);

            Sesija.getInstance().put("izabrani_klijent", k);

            FrmUnosKlijenta f = new FrmUnosKlijenta();
            JDialog d = new JDialog(getParentFrame(), "Izmena klijenta", true);
            d.setLayout(new BorderLayout());
            d.add(f, BorderLayout.CENTER);
            d.pack();
            d.setVisible(true);

            srediFormu();
        } else {
            JOptionPane.showMessageDialog(this, "Izaberite klijenta!");
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void txtPretragaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPretragaActionPerformed
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(jtblKlijent.getModel());
        sorter.setRowFilter(RowFilter.regexFilter(txtPretraga.getText()));
        jtblKlijent.setRowSorter(sorter);
    }//GEN-LAST:event_txtPretragaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnOdustani;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblKlijent;
    private javax.swing.JTextField txtPretraga;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
        try {
            List listaK = Kontroler.getInstance().vratiKlijente();

            ModelTabeleKlijent mtk = new ModelTabeleKlijent(listaK);
            jtblKlijent.setModel(mtk);
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Greska: " + ex);
        }
    }

    private Frame getParentFrame() {
        Window parentWindow = SwingUtilities.windowForComponent(this);
        Frame parentFrame = null;
        if (parentWindow instanceof Frame) {
            parentFrame = (Frame) parentWindow;
        }
        return parentFrame;
    }
}
