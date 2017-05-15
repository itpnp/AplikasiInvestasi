/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.model.MasterBskk;
import aplikasiinvestasi.model.MasterDepartemen;
import aplikasiinvestasi.model.MasterInvest;
import aplikasiinvestasi.service.BskkService;
import aplikasiinvestasi.utils.FormatDate;
import aplikasiinvestasi.utils.FormatRupiah;
import aplikasiinvestasi.view.AddBskk;
import aplikasiinvestasi.view.MainPageBskk;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rizaldi Habibie
 */
public class AddBskkController {
    
    private AddBskk addBskk;
    private BskkService bskkService;
    private DefaultComboBoxModel comboBoxModel;
    private List<MasterDepartemen> listDepartemen;
    private MasterInvest masterInvest;
    private MainPageBskkController mainPage;
    private MasterBskk masterBskk;
    private ChooseDataInvestController chooseData;
    private List<MasterBskk> listBskk;

    public AddBskkController(MainPageBskkController mainPage){
        this.mainPage = mainPage;
        this.bskkService = this.mainPage.getService();
        listBskk = new ArrayList<>();
    }
    
    public void viewDataOnTable(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Rekening");
        model.addColumn("Departemen");
        model.addColumn("Keterangan");
        model.addColumn("Debet");
        for(MasterBskk bskk : listBskk){
            Object[] obj = new Object[5];
            obj[0] = bskk.getKodeRekening();
            obj[1] = bskk.getMasterDepartemen().getNamaDepartment();
            obj[2] = bskk.getKeterangan();
            obj[3] = FormatRupiah.convert(""+bskk.getDebet());
            model.addRow(obj);
        }
        addBskk.getViewTable().setModel(model);
    }
    public void addButton(java.awt.event.ActionEvent e){
        if(validation()){
            MasterBskk bskk = new MasterBskk();
            bskk.setKodeRekening(addBskk.getKodeRekeningField().getText());
            bskk.setDebet(Long.parseLong(addBskk.getDebetField().getText()));
            bskk.setKeterangan(addBskk.getKeteranganField().getText());
            bskk.setTanggal(addBskk.getTanggalField().getDate());
            bskk.setNoBskk(addBskk.getNomorBpkkField().getText());
            bskk.setMasterDepartemen(listDepartemen.get(addBskk.getDepartemenComboBox().getSelectedIndex()));
            if(masterInvest != null){
                    bskk.setMasterInvest(masterInvest);
            }
            listBskk.add(bskk);
            this.viewDataOnTable();
            empty();
        }
    }
    public void save(java.awt.event.ActionEvent e){
        if(listBskk.size()>0){
            bskkService.saveInBatch(listBskk);
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Rekening");
            model.addColumn("Departemen");
            model.addColumn("Keterangan");
            model.addColumn("Debet");
            addBskk.getViewTable().setModel(model);
            mainPage.getAllData();
            mainPage.viewDataOnTable();
            listBskk = new ArrayList<>();
        }
        
    }
    
    public AddBskk addBskk(){
        addBskk = new AddBskk(this.mainPage.getParent(), true);
        this.addBskk.getHolo1Radio().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setModel(e);
            }
        });
        this.addBskk.getHolo2Radio().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setModel(e);
            }
        });
        this.addBskk.getDepartemenComboBox().addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                departemenComboBoxPropertyChange(evt);
            }
        });
       
        this.addBskk.getDepartemenComboBox().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                departemenComboAction(e);
            }
        });
        this.addBskk.getDebetField().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                debetKeyReleased(evt);
            }
        });
        this.addBskk.getSaveButton().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                save(e);
            }
        });
        this.addBskk.getAddInvest().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseInvest(e);
            }
        });
        addBskk.getNomorBpkkField().addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                nomorBpkkFieldFocusLost(evt);
            }
        });
        addBskk.getAddButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addButton(e);
            }
        });
        
        addBskk.setTitle("Tambah Data Baru");
        addBskk.getTanggalField().setFormats("dd MMM yyyy");
        addBskk.getInvestField().setEditable(false);
        addBskk.getTanggalLabel().setText(FormatDate.convert(addBskk.getTanggalField().getDate()));
        addBskk.getTanggalField().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tanggalAction(e);
            }
        });
        return addBskk;
    }
   
    public void setModel(java.awt.event.ActionEvent awt){
        comboBoxModel = new DefaultComboBoxModel();
        if(addBskk.getHolo1Radio().isSelected()){
            listDepartemen = bskkService.getDepartemenByUnit("Holo I");
        }else{
            listDepartemen = bskkService.getDepartemenByUnit("Holo II");
        }
        for(MasterDepartemen departemen : listDepartemen){
            comboBoxModel.addElement(departemen.getNamaDepartment());
        }
        addBskk.getDepartemenComboBox().setModel(comboBoxModel);
    }
    
    public void departemenComboAction(java.awt.event.ActionEvent awt){
        if(addBskk.getDepartemenComboBox().getSelectedItem().toString().equals("-- Pilih Departemen --")){
            
        }else{
            addBskk.getAlokasiBiayaField().setText(listDepartemen.get(addBskk.getDepartemenComboBox().getSelectedIndex()).getAlokasi());
            addBskk.getAlokasiBiayaField().requestFocus();
        }
    }
    
    private void departemenComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {                                                  
      if(listDepartemen != null){
        addBskk.getAlokasiBiayaField().setText(listDepartemen.get(addBskk.getDepartemenComboBox().getSelectedIndex()).getAlokasi());
        addBskk.getAlokasiBiayaField().requestFocus();
      }else{
        addBskk.getAlokasiBiayaField().setText("");
      }
    }
    
    public boolean validation(){
        if(addBskk.getKodeRekeningField().getText().equals("") ||addBskk.getKodeRekeningField().getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Kode Rekening Tidak Boleh Kosong", "Warning", JOptionPane.ERROR_MESSAGE, null);
            return false;
        }else if(addBskk.getKeteranganField().getText().equals("") || addBskk.getKeteranganField().getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Keterangan Tidak Boleh Kosong", "Warning", JOptionPane.ERROR_MESSAGE, null);
            return false;
        }else if(addBskk.getNomorBpkkField().getText().equals("") || addBskk.getNomorBpkkField().getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Nomor BPKK tidak Boleh Kosong", "Warning", JOptionPane.ERROR_MESSAGE, null);
            return false;
        }else if(addBskk.getDebetField().getText().equals("") || addBskk.getDebetField().getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Debet Tidak Boleh Kosong", "Warning", JOptionPane.ERROR_MESSAGE, null);
            return false;
        }else if(addBskk.getDepartemenComboBox().getSelectedItem().toString().equals("-- Pilih Departemen --")){
            JOptionPane.showMessageDialog(null,"Mohon Pilih Departemen", "Warning", JOptionPane.ERROR_MESSAGE, null);
            return false;
        }
        return true;
    }
    private void nomorBpkkFieldFocusLost(java.awt.event.FocusEvent evt) {                                         
       if(addBskk.getNomorBpkkField().getText().isEmpty()){
           addBskk.getNomorBpkkField().requestFocus();
       }else{
           addBskk.getBpkkLabel().setText(addBskk.getNomorBpkkField().getText());
       }
    }    
    private void tanggalAction(java.awt.event.ActionEvent e){
        addBskk.getTanggalLabel().setText(FormatDate.convert(addBskk.getTanggalField().getDate()));
    }
    public void empty(){
        
        addBskk.getDebetField().setText("");
        addBskk.getKeteranganField().setText("");
        addBskk.getKodeRekeningField().setText("");
        addBskk.getButtonGroup1().clearSelection();
        comboBoxModel = new DefaultComboBoxModel();
        comboBoxModel.addElement("-- Pilih Departemen --");
        addBskk.getDepartemenComboBox().setModel(comboBoxModel);
        listDepartemen = null;
        addBskk.getAlokasiBiayaField().setText("");
        addBskk.getKodeRekeningField().requestFocus();
        addBskk.getFormatDebet().setText("Rp.");
        addBskk.getInvestField().setText("");
        masterInvest = null;
        
        
    }
    public void formatRupiah(JLabel labelFormat, JTextField textFormat){
       labelFormat.setText(FormatRupiah.convert(textFormat.getText()));
    }
    private void debetKeyReleased(java.awt.event.KeyEvent evt){
       formatRupiah(addBskk.getFormatDebet(), addBskk.getDebetField());
    }
    public void setMasterInvest(MasterInvest masterInvest){
        this.masterInvest = masterInvest;
        addBskk.getInvestField().setText(this.masterInvest.getNomorIjin());
    }
    
    public BskkService getService(){
        return bskkService;
    }
    public MainPageBskk getParent(){
        return mainPage.getParent();
    }
    
    public void chooseInvest(java.awt.event.ActionEvent e){
       chooseData = new ChooseDataInvestController(this);
       chooseData.chooseInvest().setVisible(true);
    }
    
    public void setData(MasterBskk masterBskk){
        this.masterBskk = masterBskk;
        addBskk = new AddBskk(this.mainPage.getParent(), true);
        addBskk.getAlokasiBiayaField().setText(this.masterBskk.getMasterDepartemen().getAlokasi());
        addBskk.getDebetField().setText(""+this.masterBskk.getDebet());
        addBskk.getNomorBpkkField().setText(masterBskk.getNoBskk());
        if(this.masterBskk.getMasterDepartemen().getUnit().equals("Holo I")){
            addBskk.getDepartemenComboBox().setModel(new DefaultComboBoxModel(this.comboboxModel("Holo I").toArray()));
            addBskk.getHolo1Radio().setSelected(true);
        }else{
            addBskk.getDepartemenComboBox().setModel(new DefaultComboBoxModel(this.comboboxModel("Holo II").toArray()));
            addBskk.getHolo2Radio().setSelected(true);
        }
        addBskk.getDepartemenComboBox().setSelectedItem(this.masterBskk.getMasterDepartemen().getNamaDepartment());
        addBskk.getKodeRekeningField().setText(this.masterBskk.getKodeRekening());
        if(this.masterBskk.getMasterInvest() != null){
            addBskk.getInvestField().setText(this.masterBskk.getMasterInvest().getNomorIjin());
        }
        addBskk.getKeteranganField().setText(this.masterBskk.getKeterangan());
        addBskk.getInvestField().setEditable(false);
        addBskk.getTanggalField().setFormats("dd MMM yyyy");
        addBskk.getTanggalField().setDate(this.masterBskk.getTanggal());
        addBskk.getFormatDebet().setText(FormatRupiah.convert(""+this.masterBskk.getDebet()));
    }
    
    @SuppressWarnings("empty-statement")
     public List<String> comboboxModel(String unit){
        listDepartemen = bskkService.getDepartemenByUnit(unit);
        List<String> model = new ArrayList<>();;
        for(MasterDepartemen departemen : listDepartemen){
            model.add(departemen.getNamaDepartment());
        }
        return model;
    }
}
