package forme;

import domen.Drzava;
import domen.Dogadjaj;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import modeli.ModelTabeleDogadjaj;

 public class DijalogAzurirajDogadjaj extends javax.swing.JDialog {
    Dogadjaj d = new Dogadjaj();
    int redZaIzmenu;
    /**
     * Creates new form DijalogAzurirajPraksu
     */
    public DijalogAzurirajDogadjaj(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();  
        this.setLocationRelativeTo(null);
        popuniCBDrzave();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNaziv = new javax.swing.JLabel();
        lblDatumPocetkaPrakse = new javax.swing.JLabel();
        lblDatumZavrsetkaPrakse = new javax.swing.JLabel();
        lblDrzava = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        txtDatumPocetkaPrakse = new javax.swing.JTextField();
        txtDatumZavrsetkaPrakse = new javax.swing.JTextField();
        btnAzuriraj = new javax.swing.JButton();
        btnOtkazi = new javax.swing.JButton();
        cmbDrzave = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ažuriranje dogadjaja");

        lblNaziv.setText("Naziv:");

        lblDatumPocetkaPrakse.setText("Datum početka dogadjaja:");

        lblDatumZavrsetkaPrakse.setText("Datum završetka dogadjaja:");

        lblDrzava.setText("Država:");

        btnAzuriraj.setText("Ažuriraj");
        btnAzuriraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAzurirajActionPerformed(evt);
            }
        });

        btnOtkazi.setText("Otkaži");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        cmbDrzave.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnAzuriraj, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                        .addComponent(btnOtkazi, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDatumZavrsetkaPrakse)
                            .addComponent(lblDrzava))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbDrzave, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDatumZavrsetkaPrakse)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDatumPocetkaPrakse)
                            .addComponent(lblNaziv))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNaziv)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDatumPocetkaPrakse)
                                .addGap(2, 2, 2)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNaziv)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDatumPocetkaPrakse)
                    .addComponent(txtDatumPocetkaPrakse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDatumZavrsetkaPrakse)
                    .addComponent(txtDatumZavrsetkaPrakse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDrzave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDrzava))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOtkazi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAzuriraj, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed

    private void btnAzurirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAzurirajActionPerformed
        // TODO add your handling code here:
        if(txtDatumPocetkaPrakse.getText().isEmpty() || txtDatumZavrsetkaPrakse.getText().isEmpty()
                || txtNaziv.getText().isEmpty() || cmbDrzave.getSelectedIndex()==-1) {
            JOptionPane.showMessageDialog(this, "Potrebno je popuniti sva polja!");
            return;
        }
        
        String naziv = txtNaziv.getText();
        Drzava drzava = (Drzava) cmbDrzave.getSelectedItem();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date datumPocetka = null;
        Date datumZavrsetka = null;
        try {
            datumPocetka = sdf.parse(txtDatumPocetkaPrakse.getText());
            datumZavrsetka = sdf.parse(txtDatumZavrsetkaPrakse.getText());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        AzuriranjeDogadjaja azuriranje = (AzuriranjeDogadjaja) this.getParent();
        
        d.setDatumPocetka(datumPocetka);
        d.setDatumZavrsetka(datumZavrsetka);
        d.setDrzava(drzava);
        d.setNaziv(naziv);
        
        AzuriranjeDogadjaja azpr = (AzuriranjeDogadjaja) this.getParent();
        azpr.izmeniDogadjaj(d);
        //Kontroler.getInstance().izmeniPraksu(p);
        resetujPolja();
        
    }//GEN-LAST:event_btnAzurirajActionPerformed

    public Dogadjaj getD() {
        return d;
    }

    public void setD(Dogadjaj d) {
        this.d = d;
    }

    
    
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
            java.util.logging.Logger.getLogger(DijalogAzurirajDogadjaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DijalogAzurirajDogadjaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DijalogAzurirajDogadjaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DijalogAzurirajDogadjaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DijalogAzurirajDogadjaj dialog = new DijalogAzurirajDogadjaj(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAzuriraj;
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JComboBox cmbDrzave;
    private javax.swing.JLabel lblDatumPocetkaPrakse;
    private javax.swing.JLabel lblDatumZavrsetkaPrakse;
    private javax.swing.JLabel lblDrzava;
    private javax.swing.JLabel lblNaziv;
    private javax.swing.JTextField txtDatumPocetkaPrakse;
    private javax.swing.JTextField txtDatumZavrsetkaPrakse;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables

    void popuniPolja(Dogadjaj dog) {
        d = dog;
        txtDatumPocetkaPrakse.setText(dog.getDatumPocetka()+"");
        txtDatumZavrsetkaPrakse.setText(dog.getDatumZavrsetka()+"");
        cmbDrzave.setSelectedItem(dog.getDrzava());
        txtNaziv.setText(dog.getNaziv());
    }

    private void resetujPolja() {
        txtDatumPocetkaPrakse.setText("");
        txtDatumZavrsetkaPrakse.setText("");
        cmbDrzave.setSelectedIndex(-1);
        txtNaziv.setText("");
    }

    private void popuniCBDrzave() {
        ArrayList<Drzava> listaDrzava = new ArrayList<>();
        AzuriranjeDogadjaja azpr = (AzuriranjeDogadjaja) this.getParent();
        listaDrzava = azpr.getListaDrzava();
        cmbDrzave.removeAllItems();
        for(Drzava d : listaDrzava) {
            cmbDrzave.addItem(d);
        }
        cmbDrzave.setSelectedIndex(-1);
    }
}
