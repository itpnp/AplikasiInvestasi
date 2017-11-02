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
       this.labelPpn.setVisible(false);
       this.ppnField.setVisible(false);
       this.formatPpn.setVisible(false);
    }

    public JRadioButton getHolo2Radio() {
        return Holo2Radio;
    }

    public JTextField getSuplierField() {
        return suplierField;
    }

    public void setSuplierField(JTextField suplierField) {
        this.suplierField = suplierField;
    }

    public JTextField getPphField() {
        return pphField;
    }

    public void setPphField(JTextField pphField) {
        this.pphField = pphField;
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

    public JLabel getFormatPpn() {
        return formatPpn;
    }

    public void setFormatPpn(JLabel formatPpn) {
        this.formatPpn = formatPpn;
    }

    public JLabel getLabelPpn() {
        return labelPpn;
    }

    public void setLabelPpn(JLabel labelPpn) {
        this.labelPpn = labelPpn;
    }

    public JTextField getPpnField() {
        return ppnField;
    }

    public void setPpnField(JTextField ppnField) {
        this.ppnField = ppnField;
    }

    public JLabel getFormatPph() {
        return formatPph;
    }

    public void setFormatPph(JLabel formatPph) {
        this.formatPph = formatPph;
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
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        KeteranganField = new javax.swing.JTextField();
        pphField = new javax.swing.JTextField();
        alokasiBiayaField = new javax.swing.JTextField();
        removeButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        formatPpn = new javax.swing.JLabel();
        nomorLpbEksternalField = new javax.swing.JTextField();
        nomorLpbInternalField = new javax.swing.JTextField();
        formatPph = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ppnField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        departemenComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        labelPpn = new javax.swing.JLabel();
        holo1Radio = new javax.swing.JRadioButton();
        Holo2Radio = new javax.swing.JRadioButton();
        polosOption = new javax.swing.JRadioButton();
        resmiOption = new javax.swing.JRadioButton();
        kodeRekeningField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        investField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        debetField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        jumlahField = new javax.swing.JTextField();
        addInvest = new javax.swing.JButton();
        satuanField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tanggalField = new org.jdesktop.swingx.JXDatePicker();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        hargaField = new javax.swing.JTextField();
        formatDebet = new javax.swing.JLabel();
        formatHarga = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        suplierField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(654, 525));

        jPanel1.setMinimumSize(new java.awt.Dimension(654, 525));
        jPanel1.setPreferredSize(new java.awt.Dimension(654, 525));
        jPanel1.setRequestFocusEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Alokasi Biaya");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Pph");

        KeteranganField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        pphField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        alokasiBiayaField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        removeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasiinvestasi/images/1481016960_cross-24.png"))); // NOI18N
        removeButton.setMaximumSize(new java.awt.Dimension(60, 25));
        removeButton.setMinimumSize(new java.awt.Dimension(60, 25));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Nomor LPJ Internal");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Debet");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Keterangan");

        formatPpn.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        formatPpn.setText("Rp.");

        nomorLpbEksternalField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        nomorLpbInternalField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        formatPph.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        formatPph.setText("Rp.");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Quantity");

        ppnField.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Nomor LPJ Eksternal");

        departemenComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        departemenComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih Departemen --" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Departemen");

        labelPpn.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        labelPpn.setText("Ppn");

        groupUnit.add(holo1Radio);
        holo1Radio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        holo1Radio.setText("Holo I");

        groupUnit.add(Holo2Radio);
        Holo2Radio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Holo2Radio.setText("Holo II");

        groupStatus.add(polosOption);
        polosOption.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        polosOption.setText("POLOS");

        groupStatus.add(resmiOption);
        resmiOption.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        resmiOption.setText("RESMI");

        kodeRekeningField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Kode rekening");

        investField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Nomor Invest");

        debetField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        saveButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasiinvestasi/images/1478002140_floppy.png"))); // NOI18N
        saveButton.setText("SIMPAN");

        jumlahField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        addInvest.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        addInvest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasiinvestasi/images/1479300850_Add.png"))); // NOI18N
        addInvest.setMinimumSize(new java.awt.Dimension(60, 25));

        satuanField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Satuan");

        tanggalField.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Harga");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Tanggal");

        hargaField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        formatDebet.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        formatDebet.setText("Rp.");

        formatHarga.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        formatHarga.setText("Rp.");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Suplier");

        suplierField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel2)
                        .addGap(23, 23, 23)
                        .addComponent(kodeRekeningField, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(holo1Radio, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(Holo2Radio)
                        .addGap(50, 50, 50)
                        .addComponent(polosOption)
                        .addGap(2, 2, 2)
                        .addComponent(resmiOption))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(departemenComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(alokasiBiayaField, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel1)
                        .addGap(23, 23, 23)
                        .addComponent(investField, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(addInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(labelPpn))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(hargaField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(formatHarga))
                            .addComponent(tanggalField, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(suplierField, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KeteranganField, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomorLpbInternalField, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomorLpbEksternalField, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jumlahField, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(debetField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(formatDebet))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(saveButton)
                                .addComponent(satuanField, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(pphField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ppnField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(formatPpn)
                                    .addComponent(formatPph))))))
                .addGap(19, 19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1))
                    .addComponent(investField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addInvest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(kodeRekeningField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(holo1Radio)
                    .addComponent(Holo2Radio)
                    .addComponent(polosOption)
                    .addComponent(resmiOption))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4))
                    .addComponent(departemenComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(alokasiBiayaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5))
                    .addComponent(tanggalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(suplierField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KeteranganField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomorLpbInternalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomorLpbEksternalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jumlahField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(satuanField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hargaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formatHarga)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(debetField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(formatDebet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pphField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formatPph, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formatPpn)
                    .addComponent(ppnField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPpn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton)
                .addGap(15, 15, 15))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

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
    private javax.swing.JLabel formatPph;
    private javax.swing.JLabel formatPpn;
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
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jumlahField;
    private javax.swing.JTextField kodeRekeningField;
    private javax.swing.JLabel labelPpn;
    private javax.swing.JTextField nomorLpbEksternalField;
    private javax.swing.JTextField nomorLpbInternalField;
    private javax.swing.JRadioButton polosOption;
    private javax.swing.JTextField pphField;
    private javax.swing.JTextField ppnField;
    private javax.swing.JButton removeButton;
    private javax.swing.JRadioButton resmiOption;
    private javax.swing.JTextField satuanField;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField suplierField;
    private org.jdesktop.swingx.JXDatePicker tanggalField;
    // End of variables declaration//GEN-END:variables
}
