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
        java.awt.GridBagConstraints gridBagConstraints;

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(654, 525));

        jPanel1.setMinimumSize(new java.awt.Dimension(654, 525));
        jPanel1.setPreferredSize(new java.awt.Dimension(654, 525));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Alokasi Biaya");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 117, 0, 0);
        jPanel1.add(jLabel3, gridBagConstraints);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Pph");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 26;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 179, 0, 0);
        jPanel1.add(jLabel13, gridBagConstraints);

        KeteranganField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 331;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 11, 0, 0);
        jPanel1.add(KeteranganField, gridBagConstraints);

        pphField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 26;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 181;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        jPanel1.add(pphField, gridBagConstraints);

        alokasiBiayaField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 333;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 11, 0, 0);
        jPanel1.add(alokasiBiayaField, gridBagConstraints);

        removeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasiinvestasi/images/1481016960_cross-24.png"))); // NOI18N
        removeButton.setMaximumSize(new java.awt.Dimension(60, 25));
        removeButton.setMinimumSize(new java.awt.Dimension(60, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 18;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = -15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 0, 0, 28);
        jPanel1.add(removeButton, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Nomor LPJ Internal");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 77, 0, 0);
        jPanel1.add(jLabel7, gridBagConstraints);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Debet");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 166, 0, 0);
        jPanel1.add(jLabel12, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Keterangan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 123, 0, 0);
        jPanel1.add(jLabel6, gridBagConstraints);

        formatPpn.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        formatPpn.setText("Rp.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 28;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 4, 0, 0);
        jPanel1.add(formatPpn, gridBagConstraints);

        nomorLpbEksternalField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 332;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 0);
        jPanel1.add(nomorLpbEksternalField, gridBagConstraints);

        nomorLpbInternalField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 332;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 0);
        jPanel1.add(nomorLpbInternalField, gridBagConstraints);

        formatPph.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        formatPph.setText("Rp.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 26;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 4, 0, 0);
        jPanel1.add(formatPph, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Quantity");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 147, 0, 0);
        jPanel1.add(jLabel9, gridBagConstraints);

        ppnField.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 28;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 181;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        jPanel1.add(ppnField, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Nomor LPJ Eksternal");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 73, 0, 0);
        jPanel1.add(jLabel8, gridBagConstraints);

        departemenComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        departemenComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih Departemen --" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 181;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 11, 0, 0);
        jPanel1.add(departemenComboBox, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Departemen");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 121, 0, 0);
        jPanel1.add(jLabel4, gridBagConstraints);

        labelPpn.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        labelPpn.setText("Ppn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 28;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 180, 0, 0);
        jPanel1.add(labelPpn, gridBagConstraints);

        groupUnit.add(holo1Radio);
        holo1Radio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        holo1Radio.setText("Holo I");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 13, 0, 0);
        jPanel1.add(holo1Radio, gridBagConstraints);

        groupUnit.add(Holo2Radio);
        Holo2Radio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Holo2Radio.setText("Holo II");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 2, 0, 0);
        jPanel1.add(Holo2Radio, gridBagConstraints);

        groupStatus.add(polosOption);
        polosOption.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        polosOption.setText("POLOS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 1, 0, 0);
        jPanel1.add(polosOption, gridBagConstraints);

        groupStatus.add(resmiOption);
        resmiOption.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        resmiOption.setText("RESMI");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 2, 0, 0);
        jPanel1.add(resmiOption, gridBagConstraints);

        kodeRekeningField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 333;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 13, 0, 0);
        jPanel1.add(kodeRekeningField, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Kode rekening");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 105, 0, 0);
        jPanel1.add(jLabel2, gridBagConstraints);

        investField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 333;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 13, 0, 0);
        jPanel1.add(investField, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Nomor Invest");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 110, 0, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        debetField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 181;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 10, 0, 0);
        jPanel1.add(debetField, gridBagConstraints);

        saveButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasiinvestasi/images/1478002140_floppy.png"))); // NOI18N
        saveButton.setText("SIMPAN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 30;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 9, 19, 0);
        jPanel1.add(saveButton, gridBagConstraints);

        jumlahField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 332;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        jPanel1.add(jumlahField, gridBagConstraints);

        addInvest.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        addInvest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasiinvestasi/images/1479300850_Add.png"))); // NOI18N
        addInvest.setMinimumSize(new java.awt.Dimension(60, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = -15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 0, 0, 0);
        jPanel1.add(addInvest, gridBagConstraints);

        satuanField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 332;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        jPanel1.add(satuanField, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Satuan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 159, 0, 0);
        jPanel1.add(jLabel10, gridBagConstraints);

        tanggalField.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 206;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 0, 0);
        jPanel1.add(tanggalField, gridBagConstraints);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Harga");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 167, 0, 0);
        jPanel1.add(jLabel11, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Tanggal");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 148, 0, 0);
        jPanel1.add(jLabel5, gridBagConstraints);

        hargaField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 181;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        jPanel1.add(hargaField, gridBagConstraints);

        formatDebet.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        formatDebet.setText("Rp.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 4, 0, 0);
        jPanel1.add(formatDebet, gridBagConstraints);

        formatHarga.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        formatHarga.setText("Rp.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 4, 0, 0);
        jPanel1.add(formatHarga, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

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
    private org.jdesktop.swingx.JXDatePicker tanggalField;
    // End of variables declaration//GEN-END:variables
}
