package forme.glavna;

import forme.klijent.FrmUnosKlijenta;
import java.awt.BorderLayout;
import javax.swing.JDialog;

/**
 *
 * @author Darko
 */
public class FrmMain extends javax.swing.JFrame {

    /**
     * Creates new form FrmMain
     */
    public FrmMain() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblStatus = new javax.swing.JLabel();
        lblReferent = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jmnPolisa = new javax.swing.JMenu();
        jmnItemUnosPolise = new javax.swing.JMenuItem();
        jmnItemRaskidanjePolise = new javax.swing.JMenuItem();
        jmnItemPretragaPolise = new javax.swing.JMenuItem();
        jmnKlijent = new javax.swing.JMenu();
        jmnItemUnosKlijenta = new javax.swing.JMenuItem();
        jmnItemIzmenaKlijenta = new javax.swing.JMenuItem();
        jmnItemPretragaKlijenta = new javax.swing.JMenuItem();
        imnItemBrisanjeKlijenta = new javax.swing.JMenuItem();
        jmnVozila = new javax.swing.JMenu();
        jmnItemPretragaVozila = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Osiguranje");

        lblStatus.setText("...");

        lblReferent.setText("Referent: ");

        jmnPolisa.setText("Polisa");

        jmnItemUnosPolise.setText("Unos polise");
        jmnPolisa.add(jmnItemUnosPolise);

        jmnItemRaskidanjePolise.setText("Raskidanje polise");
        jmnPolisa.add(jmnItemRaskidanjePolise);

        jmnItemPretragaPolise.setText("Pretraga polise");
        jmnPolisa.add(jmnItemPretragaPolise);

        jMenuBar.add(jmnPolisa);

        jmnKlijent.setText("Klijent");

        jmnItemUnosKlijenta.setText("Unos klijenta");
        jmnItemUnosKlijenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnItemUnosKlijentaActionPerformed(evt);
            }
        });
        jmnKlijent.add(jmnItemUnosKlijenta);

        jmnItemIzmenaKlijenta.setText("Izmena klijenta");
        jmnKlijent.add(jmnItemIzmenaKlijenta);

        jmnItemPretragaKlijenta.setText("Pretraga klijenta");
        jmnKlijent.add(jmnItemPretragaKlijenta);

        imnItemBrisanjeKlijenta.setText("Brisanje klijenta");
        jmnKlijent.add(imnItemBrisanjeKlijenta);

        jMenuBar.add(jmnKlijent);

        jmnVozila.setText("Vozila");

        jmnItemPretragaVozila.setText("Pretraga vozila");
        jmnItemPretragaVozila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnItemPretragaVozilaActionPerformed(evt);
            }
        });
        jmnVozila.add(jmnItemPretragaVozila);

        jMenuBar.add(jmnVozila);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStatus)
                    .addComponent(lblReferent))
                .addContainerGap(330, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblReferent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                .addComponent(lblStatus)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmnItemPretragaVozilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnItemPretragaVozilaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmnItemPretragaVozilaActionPerformed

    private void jmnItemUnosKlijentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnItemUnosKlijentaActionPerformed
        FrmUnosKlijenta f = new FrmUnosKlijenta();
        JDialog d = new JDialog(this, "Unos klijenta", true);
        d.setLayout(new BorderLayout());
        d.add(f, BorderLayout.CENTER);
        d.pack();
        d.setVisible(true);
    }//GEN-LAST:event_jmnItemUnosKlijentaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem imnItemBrisanjeKlijenta;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jmnItemIzmenaKlijenta;
    private javax.swing.JMenuItem jmnItemPretragaKlijenta;
    private javax.swing.JMenuItem jmnItemPretragaPolise;
    private javax.swing.JMenuItem jmnItemPretragaVozila;
    private javax.swing.JMenuItem jmnItemRaskidanjePolise;
    private javax.swing.JMenuItem jmnItemUnosKlijenta;
    private javax.swing.JMenuItem jmnItemUnosPolise;
    private javax.swing.JMenu jmnKlijent;
    private javax.swing.JMenu jmnPolisa;
    private javax.swing.JMenu jmnVozila;
    private javax.swing.JLabel lblReferent;
    private javax.swing.JLabel lblStatus;
    // End of variables declaration//GEN-END:variables
}
