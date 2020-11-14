package forme;

import javax.swing.JFrame;
import komunikacija.KomunikacijaSaServerom;
import transfer.KlijentskiZahtev;

public class ClanForma extends javax.swing.JFrame {

    UnosPrijave unosPrijaveForma;
    PretragaDogadjaja pretragaDogadjaja;
    DijalogUnosPrijave unosPrijaveDijalog;
    PromenaLozinke promenaLozinkeForma;
    

    public ClanForma() {
        initComponents();
        this.setLocationRelativeTo(null);
        //this.setExtendedState(this.MAXIMIZED_BOTH);
        //this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmPromenaLozinke = new javax.swing.JMenuItem();
        jmPrijava = new javax.swing.JMenuItem();
        jmPretragaDogadjaja = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem4.setText("jMenuItem4");

        jMenuItem5.setText("jMenuItem5");

        jMenuItem6.setText("jMenuItem6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Član forma");

        jMenu1.setText("Opcije");

        jmPromenaLozinke.setText("Promena lozinke");
        jmPromenaLozinke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmPromenaLozinkeActionPerformed(evt);
            }
        });
        jMenu1.add(jmPromenaLozinke);

        jmPrijava.setText("Unos prijave");
        jmPrijava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmPrijavaActionPerformed(evt);
            }
        });
        jMenu1.add(jmPrijava);

        jmPretragaDogadjaja.setText("Pretraga i pregled dogadjaja");
        jmPretragaDogadjaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmPretragaDogadjajaActionPerformed(evt);
            }
        });
        jMenu1.add(jmPretragaDogadjaja);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmPromenaLozinkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmPromenaLozinkeActionPerformed
        // TODO add your handling code here:    
        promenaLozinkeForma = new PromenaLozinke();
        promenaLozinkeForma.setDefaultCloseOperation(PromenaLozinke.DISPOSE_ON_CLOSE);
        promenaLozinkeForma.pack();
        promenaLozinkeForma.setVisible(true);
    }//GEN-LAST:event_jmPromenaLozinkeActionPerformed

    private void jmPrijavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmPrijavaActionPerformed
        // TODO add your handling code here:
        unosPrijaveForma = new UnosPrijave();
        unosPrijaveForma.setDefaultCloseOperation(UnosPrijave.DISPOSE_ON_CLOSE);
        unosPrijaveForma.pack();
        unosPrijaveForma.setVisible(true);
    }//GEN-LAST:event_jmPrijavaActionPerformed

    private void jmPretragaDogadjajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmPretragaDogadjajaActionPerformed
        // TODO add your handling code here:
        pretragaDogadjaja = new PretragaDogadjaja();
        pretragaDogadjaja.setDefaultCloseOperation(PretragaDogadjaja.DISPOSE_ON_CLOSE);
        pretragaDogadjaja.pack();
        pretragaDogadjaja.setVisible(true);
    }//GEN-LAST:event_jmPretragaDogadjajaActionPerformed

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
            java.util.logging.Logger.getLogger(ClanForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClanForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClanForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClanForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClanForma().setVisible(true);
            }
        });
    }

    public UnosPrijave getUnosPrijaveForma() {
        return unosPrijaveForma;
    }

    public DijalogUnosPrijave getUnosPrijaveDijalog() {
        return unosPrijaveDijalog;
    }

    public PretragaDogadjaja getPretragaDogadjaja() {
        return pretragaDogadjaja;
    }  

    public PromenaLozinke getPromenaLozinkeForma() {
        return promenaLozinkeForma;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jmPretragaDogadjaja;
    private javax.swing.JMenuItem jmPrijava;
    private javax.swing.JMenuItem jmPromenaLozinke;
    // End of variables declaration//GEN-END:variables
}