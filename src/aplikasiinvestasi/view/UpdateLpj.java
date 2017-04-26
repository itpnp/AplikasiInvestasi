/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author Rizaldi Habibie
 */
public class UpdateLpj extends javax.swing.JDialog {

    /**
     * Creates new form UpdateLpb
     */
    public UpdateLpj(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       Dimension frameSize = getSize();
       setLocation(
       (screenSize.width - frameSize.width) / 2,
       (screenSize.height - frameSize.height) / 2);
    }

    public JRadioButton getHolo2Radio() {
        return Holo2Radio;
    }

    public void setHolo2Radio(JRadioButton Holo2Radio) {
        this.Holo2Radio = Holo2Radio;
    }

    public JTextField getKeteranganField() {
        return KeteranganField;
    }

    public void setKeteranganField(JTextField KeteranganField) {
        this.KeteranganField = KeteranganField;
    }

    public JButton getAddInvest() {
        return addInvest;
    }

    public void setAddInvest(JButton addInvest) {
        this.addInvest = addInvest;
    }

    public JTextField getAlokasiBiayaField() {
        return alokasiBiayaField;
    }

    public void setAlokasiBiayaField(JTextField alokasiBiayaField) {
        this.alokasiBiayaField = alokasiBiayaField;
    }

    public JTextField getDebetField() {
        return debetField;
    }

    public void setDebetField(JTextField debetField) {
        this.debetField = debetField;
    }

    public JComboBox getDepartemenComboBox() {
        return departemenComboBox;
    }

    public void setDepartemenComboBox(JComboBox departemenComboBox) {
        this.departemenComboBox = departemenComboBox;
    }

    public JLabel getFormatDebet() {
        return formatDebet;
    }

    public void setFormatDebet(JLabel formatDebet) {
        this.formatDebet = formatDebet;
    }

    public JLabel getFormatHarga() {
        return formatHarga;
    }

    public void setFormatHarga(JLabel formatHarga) {
        this.formatHarga = formatHarga;
    }

    public ButtonGroup getGroupSource() {
        return groupSource;
    }

    public void setGroupSource(ButtonGroup groupSource) {
        this.groupSource = groupSource;
    }

    public ButtonGroup getGroupStatus() {
        return groupStatus;
    }

    public void setGroupStatus(ButtonGroup groupStatus) {
        this.groupStatus = groupStatus;
    }

    public ButtonGroup getGroupUnit() {
        return groupUnit;
    }

    public void setGroupUnit(ButtonGroup groupUnit) {
        this.groupUnit = groupUnit;
    }

    public JTextField getHargaField() {
        return hargaField;
    }

    public void setHargaField(JTextField hargaField) {
        this.hargaField = hargaField;
    }

    public JRadioButton getHolo1Radio() {
        return holo1Radio;
    }

    public void setHolo1Radio(JRadioButton holo1Radio) {
        this.holo1Radio = holo1Radio;
    }

    public JTextField getInvestField() {
        return investField;
    }

    public void setInvestField(JTextField investField) {
        this.investField = investField;
    }

    public JTextField getJumlahField() {
        return jumlahField;
    }

    public void setJumlahField(JTextField jumlahField) {
        this.jumlahField = jumlahField;
    }

    public JTextField getKodeRekeningField() {
        return kodeRekeningField;
    }

    public void setKodeRekeningField(JTextField kodeRekeningField) {
        this.kodeRekeningField = kodeRekeningField;
    }

    public JTextField getNomorLpbEksternalField() {
        return nomorLpbEksternalField;
    }

    public void setNomorLpbEksternalField(JTextField nomorLpbEksternalField) {
        this.nomorLpbEksternalField = nomorLpbEksternalField;
    }

    public JTextField getNomorLpbInternalField() {
        return nomorLpbInternalField;
    }

    public void setNomorLpbInternalField(JTextField nomorLpbInternalField) {
        this.nomorLpbInternalField = nomorLpbInternalField;
    }

    public JRadioButton getPolosOption() {
        return polosOption;
    }

    public void setPolosOption(JRadioButton polosOption) {
        this.polosOption = polosOption;
    }

    public JRadioButton getResmiOption() {
        return resmiOption;
    }

    public void setResmiOption(JRadioButton resmiOption) {
        this.resmiOption = resmiOption;
    }

    public JTextField getSatuanField() {
        return satuanField;
    }

    public void setSatuanField(JTextField satuanField) {
        this.satuanField = satuanField;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }

    public JXDatePicker getTanggalField() {
        return tanggalField;
    }

    public void setTanggalField(JXDatePicker tanggalField) {
        this.tanggalField = tanggalField;
    }

    public JButton getRemoveButton() {
        return removeButton;
    }

    public void setRemoveButton(JButton removeButton) {
        this.removeButton = removeButton;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupSource = new javax.swing.ButtonGroup();
        groupUnit = new javax.swing.ButtonGroup();
        groupStatus = new javax.swing.ButtonGroup();
        saveButton = new javax.swing.JButton();
        debetField = new javax.swing.JTextField();
        hargaField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        satuanField = new javax.swing.JTextField();
        formatHarga = new javax.swing.JLabel();
        formatDebet = new javax.swing.JLabel();
        jumlahField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nomorLpbEksternalField = new javax.swing.JTextField();
        nomorLpbInternalField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        KeteranganField = new javax.swing.JTextField();
        alokasiBiayaField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        departemenComboBox = new javax.swing.JComboBox();
        holo1Radio = new javax.swing.JRadioButton();
        Holo2Radio = new javax.swing.JRadioButton();
        polosOption = new javax.swing.JRadioButton();
        resmiOption = new javax.swing.JRadioButton();
        kodeRekeningField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        investField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        addInvest = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tanggalField = new org.jdesktop.swingx.JXDatePicker();
        removeButton = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        saveButton.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasiinvestasi/images/1478002140_floppy.png"))); // NOI18N
        saveButton.setText("SIMPAN");

        debetField.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N

        hargaField.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel11.setText("Harga");

        jLabel10.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel10.setText("Satuan");

        satuanField.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N

        formatHarga.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        formatHarga.setText("Rp.");

        formatDebet.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        formatDebet.setText("Rp.");

        jumlahField.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel9.setText("Quantity");

        jLabel8.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel8.setText("Nomor LPJ Eksternal");

        nomorLpbEksternalField.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N

        nomorLpbInternalField.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel7.setText("Nomor LPJ Internal");

        jLabel6.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel6.setText("Keterangan");

        KeteranganField.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N

        alokasiBiayaField.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel3.setText("Alokasi Biaya");

        jLabel4.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel4.setText("Departemen");

        departemenComboBox.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        departemenComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih Departemen --" }));

        groupUnit.add(holo1Radio);
        holo1Radio.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        holo1Radio.setText("Holo I");

        groupUnit.add(Holo2Radio);
        Holo2Radio.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        Holo2Radio.setText("Holo II");

        groupStatus.add(polosOption);
        polosOption.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        polosOption.setText("POLOS");

        groupStatus.add(resmiOption);
        resmiOption.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        resmiOption.setText("RESMI");

        kodeRekeningField.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel2.setText("Kode rekening");

        investField.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel1.setText("Nomor Invest");

        addInvest.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        addInvest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasiinvestasi/images/1479300850_Add.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel5.setText("Tanggal");

        tanggalField.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N

        removeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasiinvestasi/images/1481016960_cross-24.png"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel12.setText("Debet");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(saveButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(satuanField, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel12)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(debetField)
                            .addComponent(hargaField, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(formatDebet)
                            .addComponent(formatHarga)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addComponent(holo1Radio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Holo2Radio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(polosOption)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(resmiOption))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(investField, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kodeRekeningField, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(nomorLpbInternalField, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(tanggalField, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(KeteranganField, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(departemenComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(alokasiBiayaField, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(18, 18, 18)
                            .addComponent(nomorLpbEksternalField, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(76, 76, 76)
                            .addComponent(jLabel9)
                            .addGap(18, 18, 18)
                            .addComponent(jumlahField, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(addInvest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(investField)
                    .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(kodeRekeningField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(holo1Radio)
                    .addComponent(Holo2Radio)
                    .addComponent(polosOption)
                    .addComponent(resmiOption))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departemenComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(alokasiBiayaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tanggalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6))
                    .addComponent(KeteranganField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel7))
                    .addComponent(nomorLpbInternalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel8))
                    .addComponent(nomorLpbEksternalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel9))
                    .addComponent(jumlahField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel10))
                    .addComponent(satuanField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel11))
                    .addComponent(hargaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(formatHarga)))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(debetField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formatDebet))
                .addGap(13, 13, 13)
                .addComponent(saveButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(UpdateLpj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateLpj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateLpj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateLpj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UpdateLpj dialog = new UpdateLpj(new javax.swing.JFrame(), true);
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
    private javax.swing.JRadioButton Holo2Radio;
    private javax.swing.JTextField KeteranganField;
    private javax.swing.JButton addInvest;
    private javax.swing.JTextField alokasiBiayaField;
    private javax.swing.JTextField debetField;
    private javax.swing.JComboBox departemenComboBox;
    private javax.swing.JLabel formatDebet;
    private javax.swing.JLabel formatHarga;
    private javax.swing.ButtonGroup groupSource;
    private javax.swing.ButtonGroup groupStatus;
    private javax.swing.ButtonGroup groupUnit;
    private javax.swing.JTextField hargaField;
    private javax.swing.JRadioButton holo1Radio;
    private javax.swing.JTextField investField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jumlahField;
    private javax.swing.JTextField kodeRekeningField;
    private javax.swing.JTextField nomorLpbEksternalField;
    private javax.swing.JTextField nomorLpbInternalField;
    private javax.swing.JRadioButton polosOption;
    private javax.swing.JButton removeButton;
    private javax.swing.JRadioButton resmiOption;
    private javax.swing.JTextField satuanField;
    private javax.swing.JButton saveButton;
    private org.jdesktop.swingx.JXDatePicker tanggalField;
    // End of variables declaration//GEN-END:variables
}
