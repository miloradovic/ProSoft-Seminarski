package forme.polisa;

import domen.Polisa;
import forme.polisa.model.ModelTabelePolisa;
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
public class FrmPretragaPolise extends javax.swing.JPanel {

    /**
     * Creates new form FrmPretragaPolise
     */
    public FrmPretragaPolise() {
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
        jtblPolisa = new javax.swing.JTable();
        btnRaskidanje = new javax.swing.JButton();
        btnOdustani = new javax.swing.JButton();

        jLabel1.setText("Pretraga: ");

        txtPretraga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPretragaActionPerformed(evt);
            }
        });

        jtblPolisa.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtblPolisa);

        btnRaskidanje.setText("Raskidanje");
        btnRaskidanje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRaskidanjeActionPerformed(evt);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtPretraga))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRaskidanje)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRaskidanje)
                    .addComponent(btnOdustani))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        SwingUtilities.getWindowAncestor(this).dispose();
    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void btnRaskidanjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRaskidanjeActionPerformed
        int red = jtblPolisa.convertRowIndexToModel(jtblPolisa.getSelectedRow());
        if (red != -1) {
            ModelTabelePolisa mtp = (ModelTabelePolisa) jtblPolisa.getModel();
            Polisa p = mtp.vratiPolisu(red);

            Sesija.getInstance().put("izabrana_polisa", p);

            FrmRaskidanje f = new FrmRaskidanje();
            JDialog d = new JDialog(getParentFrame(), "Raskidanje polise", true);
            d.setLayout(new BorderLayout());
            d.add(f, BorderLayout.CENTER);
            d.pack();
            d.setVisible(true);

            srediFormu();
        } else {
            JOptionPane.showMessageDialog(this, "Izaberite polisu!");
        }
    }//GEN-LAST:event_btnRaskidanjeActionPerformed

    private void txtPretragaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPretragaActionPerformed
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(jtblPolisa.getModel());
        sorter.setRowFilter(RowFilter.regexFilter(txtPretraga.getText()));
        jtblPolisa.setRowSorter(sorter);
    }//GEN-LAST:event_txtPretragaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnRaskidanje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblPolisa;
    private javax.swing.JTextField txtPretraga;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
        try {
            List<Polisa> listaP = Kontroler.getInstance().pretraziPolise();
            ModelTabelePolisa mtp = new ModelTabelePolisa(listaP);
            jtblPolisa.setModel(mtp);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Greska: " + e);
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
