/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Rizaldi Habibie
 */
public class ViewBskk extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewBskk
     */
    public ViewBskk() {
        initComponents();
    }

    public JComboBox getBulanParam() {
        return bulanParam;
    }

    public void setBulanParam(JComboBox bulanParam) {
        this.bulanParam = bulanParam;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }

    public JComboBox getTahunParam() {
        return tahunParam;
    }

    public void setTahunParam(JComboBox tahunParam) {
        this.tahunParam = tahunParam;
    }

    public JTable getViewTable() {
        return viewTable;
    }

    public void setViewTable(JTable viewTable) {
        this.viewTable = viewTable;
    }

    public JTextField getKodeInvestField() {
        return kodeInvestField;
    }

    public void setKodeInvestField(JTextField kodeInvestField) {
        this.kodeInvestField = kodeInvestField;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bulanParam = new javax.swing.JComboBox();
        tahunParam = new javax.swing.JComboBox();
        searchButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        kodeInvestField = new javax.swing.JTextField();

        jPanel2.setLayout(new java.awt.BorderLayout());

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

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.setPreferredSize(new java.awt.Dimension(786, 50));

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel1.setText("Bulan");

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel2.setText("Tahun");

        bulanParam.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        bulanParam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tahunParam.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        tahunParam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        searchButton.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasiinvestasi/images/search-icon.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel3.setText("Kode Invest");

        kodeInvestField.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bulanParam, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tahunParam, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kodeInvestField, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(tahunParam))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(bulanParam, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kodeInvestField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox bulanParam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kodeInvestField;
    private javax.swing.JButton searchButton;
    private javax.swing.JComboBox tahunParam;
    private javax.swing.JTable viewTable;
    // End of variables declaration//GEN-END:variables
}
