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
import javax.swing.JTable;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author Rizaldi Habibie
 */
public class AddNewLpj extends javax.swing.JDialog {

    /**
     * Creates new form AddNewLpb
     */
    public AddNewLpj(java.awt.Frame parent, boolean modal) {
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

    public JTextField getSuplierField() {
        return suplierField;
    }

    public void setSuplierField(JTextField suplierField) {
        this.suplierField = suplierField;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

    public JTable getViewTable() {
        return viewTable;
    }

    public void setViewTable(JTable viewTable) {
        this.viewTable = viewTable;
    }

    public JRadioButton getHolo2Radio() {
        return Holo2Radio;
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

    public JTextField getInvestField() {
        return investField;
    }

    public void setInvestField(JTextField investField) {
        this.investField = investField;
    }

    public ButtonGroup getButtonGroup1() {
        return buttonGroup1;
    }

    public void setButtonGroup1(ButtonGroup buttonGroup1) {
        this.buttonGroup1 = buttonGroup1;
    }

    public ButtonGroup getButtonGroup2() {
        return buttonGroup2;
    }

    public void setButtonGroup2(ButtonGroup buttonGroup2) {
        this.buttonGroup2 = buttonGroup2;
    }

    public JTextField getPphField() {
        return pphField;
    }

    public void setPphField(JTextField pphField) {
        this.pphField = pphField;
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        holo1Radio = new javax.swing.JRadioButton();
        Holo2Radio = new javax.swing.JRadioButton();
        investField = new javax.swing.JTextField();
        kodeRekeningField = new javax.swing.JTextField();
        alokasiBiayaField = new javax.swing.JTextField();
        KeteranganField = new javax.swing.JTextField();
        departemenComboBox = new javax.swing.JComboBox();
        nomorLpbInternalField = new javax.swing.JTextField();
        nomorLpbEksternalField = new javax.swing.JTextField();
        jumlahField = new javax.swing.JTextField();
        satuanField = new javax.swing.JTextField();
        hargaField = new javax.swing.JTextField();
        debetField = new javax.swing.JTextField();
        tanggalField = new org.jdesktop.swingx.JXDatePicker();
        addInvest = new javax.swing.JButton();
        formatHarga = new javax.swing.JLabel();
        formatDebet = new javax.swing.JLabel();
        polosOption = new javax.swing.JRadioButton();
        resmiOption = new javax.swing.JRadioButton();
        addButton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        pphField = new javax.swing.JTextField();
        formatPph = new javax.swing.JLabel();
        ppnField = new javax.swing.JTextField();
        labelPpn = new javax.swing.JLabel();
        formatPpn = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        suplierField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewTable = new javax.swing.JTable();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel1.setText("Nomor Invest");

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel2.setText("Kode rekening");

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel3.setText("Alokasi Biaya");

        jLabel4.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel4.setText("Departemen");

        jLabel5.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel5.setText("Tanggal");

        jLabel6.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel6.setText("Keterangan");

        jLabel7.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel7.setText("Nomor LPJ Internal");

        jLabel8.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel8.setText("Nomor LPJ Eksternal");

        jLabel9.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel9.setText("Quantity");

        jLabel10.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel10.setText("Satuan");

        jLabel11.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel11.setText("Harga");

        jLabel12.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel12.setText("Debet");

        buttonGroup1.add(holo1Radio);
        holo1Radio.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        holo1Radio.setText("Holo I");

        buttonGroup1.add(Holo2Radio);
        Holo2Radio.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        Holo2Radio.setText("Holo II");

        investField.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N

        kodeRekeningField.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N

        alokasiBiayaField.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N

        KeteranganField.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N

        departemenComboBox.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        departemenComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih Departemen --" }));

        nomorLpbInternalField.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N

        nomorLpbEksternalField.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N

        jumlahField.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N

        satuanField.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N

        hargaField.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N

        debetField.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N

        tanggalField.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N

        addInvest.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        addInvest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasiinvestasi/images/1479300850_Add.png"))); // NOI18N

        formatHarga.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        formatHarga.setText("Rp.");

        formatDebet.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        formatDebet.setText("Rp.");

        buttonGroup2.add(polosOption);
        polosOption.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        polosOption.setText("POLOS");

        buttonGroup2.add(resmiOption);
        resmiOption.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        resmiOption.setText("RESMI");

        addButton.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasiinvestasi/images/1483954124_1.png"))); // NOI18N
        addButton.setText("Tambah");

        jLabel13.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel13.setText("Pph");

        pphField.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N

        formatPph.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        formatPph.setText("Rp.");

        ppnField.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N

        labelPpn.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        labelPpn.setText("Ppn");

        formatPpn.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        formatPpn.setText("Rp.");

        jLabel14.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel14.setText("Suplier");

        suplierField.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(polosOption)
                        .addGap(2, 2, 2)
                        .addComponent(resmiOption))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jumlahField, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(hargaField, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(formatHarga))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(74, 74, 74)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel14))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tanggalField, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(alokasiBiayaField, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(suplierField, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(67, 67, 67)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel2))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(holo1Radio)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Holo2Radio))
                                        .addComponent(departemenComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(kodeRekeningField, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(addButton)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(satuanField, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(labelPpn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ppnField, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(formatPpn)
                                        .addGap(134, 134, 134))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel13))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(debetField, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(formatDebet))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(pphField, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(formatPph))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nomorLpbInternalField)
                                    .addComponent(KeteranganField, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                                    .addComponent(nomorLpbEksternalField))))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(investField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(investField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kodeRekeningField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resmiOption)
                    .addComponent(polosOption)
                    .addComponent(Holo2Radio)
                    .addComponent(holo1Radio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departemenComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(alokasiBiayaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tanggalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(suplierField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KeteranganField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomorLpbInternalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomorLpbEksternalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel9))
                    .addComponent(jumlahField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel10))
                    .addComponent(satuanField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel11))
                    .addComponent(hargaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(formatHarga)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(debetField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(formatDebet)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(pphField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formatPph))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPpn)
                    .addComponent(ppnField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formatPpn))
                .addGap(4, 4, 4)
                .addComponent(addButton)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        viewTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(viewTable);

        saveButton.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasiinvestasi/images/1478002140_floppy.png"))); // NOI18N
        saveButton.setText("SIMPAN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(422, 599, Short.MAX_VALUE)
                .addComponent(saveButton)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AddNewLpb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AddNewLpb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AddNewLpb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AddNewLpb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                AddNewLpb dialog = new AddNewLpb(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Holo2Radio;
    private javax.swing.JTextField KeteranganField;
    private javax.swing.JButton addButton;
    private javax.swing.JButton addInvest;
    private javax.swing.JTextField alokasiBiayaField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField debetField;
    private javax.swing.JComboBox departemenComboBox;
    private javax.swing.JLabel formatDebet;
    private javax.swing.JLabel formatHarga;
    private javax.swing.JLabel formatPph;
    private javax.swing.JLabel formatPpn;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumlahField;
    private javax.swing.JTextField kodeRekeningField;
    private javax.swing.JLabel labelPpn;
    private javax.swing.JTextField nomorLpbEksternalField;
    private javax.swing.JTextField nomorLpbInternalField;
    private javax.swing.JRadioButton polosOption;
    private javax.swing.JTextField pphField;
    private javax.swing.JTextField ppnField;
    private javax.swing.JRadioButton resmiOption;
    private javax.swing.JTextField satuanField;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField suplierField;
    private org.jdesktop.swingx.JXDatePicker tanggalField;
    private javax.swing.JTable viewTable;
    // End of variables declaration//GEN-END:variables
}
