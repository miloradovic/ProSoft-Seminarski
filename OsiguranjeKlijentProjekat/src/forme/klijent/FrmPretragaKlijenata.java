/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.klijent;

import forme.klijent.model.ModelTabeleKlijent;
import java.io.IOException;
import java.util.List;
import javax.swing.SwingUtilities;
import komunikacija.Komunikacija;
import transfer.Operacija;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;

/**
 *
 * @author Darko
 */
public class FrmPretragaKlijenata extends javax.swing.JPanel {

    TransferObjekatZahtev toZahtev;
    TransferObjekatOdgovor toOdgovor;
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
        btnPretraga = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblKlijent = new javax.swing.JTable();
        btnIzmeni = new javax.swing.JButton();
        btnOdustani = new javax.swing.JButton();

        jLabel1.setText("Pretraga: ");

        btnPretraga.setText("Pretraga");

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPretraga))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPretraga)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnPretraga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblKlijent;
    private javax.swing.JTextField txtPretraga;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
        try {
            toZahtev = new TransferObjekatZahtev();
            toZahtev.setOperacija(Operacija.VRATI_KLIJENTE);
            Komunikacija.getInstance().posalji(toZahtev);

            toOdgovor = Komunikacija.getInstance().procitaj();
            List listaK = (List) toOdgovor.getRezultat();

            ModelTabeleKlijent mtk = new ModelTabeleKlijent(listaK);
            jtblKlijent.setModel(mtk);
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Greska: " + ex);
        }
    }
}
