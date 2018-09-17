package forme.polisa;

import domen.Polisa;
import domen.Referent;
import java.io.IOException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import kontroler.Kontroler;
import transfer.TransferObjekatOdgovor;
import util.Sesija;

/**
 *
 * @author Darko
 */
public class FrmRaskidanje extends javax.swing.JPanel {

    TransferObjekatOdgovor toOdgovor;
    Polisa p;

    /**
     * Creates new form FrmRaskidanje
     */
    public FrmRaskidanje() {
        initComponents();
        p = (Polisa) Sesija.getInstance().get("izabrana_polisa");
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
        jLabel2 = new javax.swing.JLabel();
        lblKlijent = new javax.swing.JLabel();
        lblVozilo = new javax.swing.JLabel();
        btnRaskidanje = new javax.swing.JButton();
        btnOdustani = new javax.swing.JButton();

        jLabel1.setText("Klijent : ");

        jLabel2.setText("Vozilo: ");

        lblKlijent.setText("...");

        lblVozilo.setText("...");

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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblVozilo)
                            .addComponent(lblKlijent))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRaskidanje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                        .addComponent(btnOdustani)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblKlijent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblVozilo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRaskidanje)
                    .addComponent(btnOdustani))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRaskidanjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRaskidanjeActionPerformed
        Referent r = (Referent) Sesija.getInstance().get("Referent");

        p.setReferentRaskidanje(r);
        p.setDatumRaskidanja(new Date());
        try {
            toOdgovor = Kontroler.getInstance().zapamtiPolisu(p);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Greska: " + e);
        }
        if (toOdgovor.getIzuzetak() != null) {
            JOptionPane.showMessageDialog(this, toOdgovor.getIzuzetak());
            return;
        }
        JOptionPane.showMessageDialog(this, "Polisa je raskinuta.");
        Sesija.getInstance().remove("izabrana_polisa");
        SwingUtilities.getWindowAncestor(this).dispose();
    }//GEN-LAST:event_btnRaskidanjeActionPerformed

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        Sesija.getInstance().remove("izabrana_polisa");
        SwingUtilities.getWindowAncestor(this).dispose();
    }//GEN-LAST:event_btnOdustaniActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnRaskidanje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblKlijent;
    private javax.swing.JLabel lblVozilo;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
        lblKlijent.setText(p.getKlijent().toString());
        lblVozilo.setText(p.getVozilo().toString());
    }
}
