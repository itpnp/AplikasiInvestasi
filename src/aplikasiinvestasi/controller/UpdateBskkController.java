/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.model.MasterBskk;
import aplikasiinvestasi.model.MasterDepartemen;
import aplikasiinvestasi.model.MasterInvest;
import aplikasiinvestasi.service.BskkService;
import aplikasiinvestasi.utils.FormatRupiah;
import aplikasiinvestasi.view.MainPageBskk;
import aplikasiinvestasi.view.UpdateBskk;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Rizaldi Habibie
 */
public class UpdateBskkController {
    
    private UpdateBskk updateBskk;
    private BskkService bskkService;
    private DefaultComboBoxModel comboBoxModel;
    private List<MasterDepartemen> listDepartemen;
    private MasterInvest masterInvest;
    private MainPageBskkController mainPage;
    private MasterBskk masterBskk;
    private ChooseDataInvestController chooseData;
    
    public UpdateBskkController(MainPageBskkController mainPage){
        this.mainPage = mainPage;
        this.bskkService = this.mainPage.getService();
    }
    
      private void nomorBpkkFieldFocusLost(java.awt.event.FocusEvent evt) {                                         
        if(updateBskk.getNomorBpkkField().getText().isEmpty()){
            updateBskk.getNomorBpkkField().requestFocus();
        }
      }
    public UpdateBskk updateBskk(){
        this.updateBskk.getHolo1Radio().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setModel(e);
            }
        });
        this.updateBskk.getHolo2Radio().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setModel(e);
            }
        });
        this.updateBskk.getDepartemenComboBox().addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                departemenComboBoxPropertyChange(evt);
            }
        });
       
        this.updateBskk.getDepartemenComboBox().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                departemenComboAction(e);
            }
        });
        this.updateBskk.getDebetField().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                debetKeyReleased(evt);
            }
        });
        this.updateBskk.getSaveButton().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                update(e);
            }
        });
        
        this.updateBskk.getAddInvest().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseInvest(e);
            }
        });
        updateBskk.getNomorBpkkField().addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                nomorBpkkFieldFocusLost(evt);
            }
        });
        updateBskk.setTitle("Ubah Data");
        return updateBskk;
    }
    
     public void update(java.awt.event.ActionEvent e){
        if(validation()){
            this.masterBskk.setKodeRekening(updateBskk.getKodeRekeningField().getText());
            this.masterBskk.setDebet(Long.parseLong(updateBskk.getDebetField().getText()));
            this.masterBskk.setKeterangan(updateBskk.getKeteranganField().getText());
            this.masterBskk.setTanggal(updateBskk.getTanggalField().getDate());
            this.masterBskk.setNoBskk(updateBskk.getNomorBpkkField().getText());
            this.masterBskk.setMasterDepartemen(listDepartemen.get(updateBskk.getDepartemenComboBox().getSelectedIndex()));
            if(masterInvest != null){
                this.masterBskk.setMasterInvest(masterInvest);
             }
                bskkService.updateData(this.masterBskk);
                mainPage.getAllData();
                mainPage.viewDataOnTable();
        }
    }
     
   public void setModel(java.awt.event.ActionEvent awt){
        comboBoxModel = new DefaultComboBoxModel();
        if(updateBskk.getHolo1Radio().isSelected()){
            listDepartemen = bskkService.getDepartemenByUnit("Holo I");
        }else{
            listDepartemen = bskkService.getDepartemenByUnit("Holo II");
        }
        for(MasterDepartemen departemen : listDepartemen){
            comboBoxModel.addElement(departemen.getNamaDepartment());
        }
        updateBskk.getDepartemenComboBox().setModel(comboBoxModel);
    }
   
    public void departemenComboAction(java.awt.event.ActionEvent awt){
        if(updateBskk.getDepartemenComboBox().getSelectedItem().toString().equals("-- Pilih Departemen --")){
            
        }else{
            updateBskk.getAlokasiBiayaField().setText(listDepartemen.get(updateBskk.getDepartemenComboBox().getSelectedIndex()).getAlokasi());
            updateBskk.getAlokasiBiayaField().requestFocus();
        }
    }
    
    private void departemenComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {                                                  
      if(listDepartemen != null){
        updateBskk.getAlokasiBiayaField().setText(listDepartemen.get(updateBskk.getDepartemenComboBox().getSelectedIndex()).getAlokasi());
        updateBskk.getAlokasiBiayaField().requestFocus();
      }else{
        updateBskk.getAlokasiBiayaField().setText("");
      }
    }
    
    public boolean validation(){
        if(updateBskk.getKodeRekeningField().getText().equals("") ||updateBskk.getKodeRekeningField().getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Kode Rekening Tidak Boleh Kosong", "Warning", JOptionPane.ERROR_MESSAGE, null);
            return false;
        }else if(updateBskk.getKeteranganField().getText().equals("") || updateBskk.getKeteranganField().getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Keterangan Tidak Boleh Kosong", "Warning", JOptionPane.ERROR_MESSAGE, null);
            return false;
        }else if(updateBskk.getNomorBpkkField().getText().equals("") || updateBskk.getNomorBpkkField().getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Nomor BPKK tidak Boleh Kosong", "Warning", JOptionPane.ERROR_MESSAGE, null);
            return false;
        }else if(updateBskk.getDebetField().getText().equals("") || updateBskk.getDebetField().getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Debet Tidak Boleh Kosong", "Warning", JOptionPane.ERROR_MESSAGE, null);
            return false;
        }else if(updateBskk.getDepartemenComboBox().getSelectedItem().toString().equals("-- Pilih Departemen --")){
            JOptionPane.showMessageDialog(null,"Mohon Pilih Departemen", "Warning", JOptionPane.ERROR_MESSAGE, null);
            return false;
        }
        return true;
    }
      public void formatRupiah(JLabel labelFormat, JTextField textFormat){
       labelFormat.setText(FormatRupiah.convert(textFormat.getText()));
     }
     private void debetKeyReleased(java.awt.event.KeyEvent evt){
       formatRupiah(updateBskk.getFormatDebet(), updateBskk.getDebetField());
    }
    public void setMasterInvest(MasterInvest masterInvest){
        this.masterInvest = masterInvest;
        updateBskk.getInvestField().setText(this.masterInvest.getNomorIjin());
    }
    public void chooseInvest(java.awt.event.ActionEvent e){
       chooseData = new ChooseDataInvestController(this);
       chooseData.chooseInvest().setVisible(true);
    }
    
    public void setData(MasterBskk masterBskk){
        this.masterBskk = masterBskk;
        updateBskk= new UpdateBskk(this.mainPage.getParent(), true);
        updateBskk.getAlokasiBiayaField().setText(this.masterBskk.getMasterDepartemen().getAlokasi());
        updateBskk.getDebetField().setText(""+this.masterBskk.getDebet());
        updateBskk.getNomorBpkkField().setText(masterBskk.getNoBskk());
        if(this.masterBskk.getMasterDepartemen().getUnit().equals("Holo I")){
            updateBskk.getDepartemenComboBox().setModel(new DefaultComboBoxModel(this.comboboxModel("Holo I").toArray()));
            updateBskk.getHolo1Radio().setSelected(true);
        }else{
            updateBskk.getDepartemenComboBox().setModel(new DefaultComboBoxModel(this.comboboxModel("Holo II").toArray()));
            updateBskk.getHolo2Radio().setSelected(true);
        }
        updateBskk.getDepartemenComboBox().setSelectedItem(this.masterBskk.getMasterDepartemen().getNamaDepartment());
        updateBskk.getKodeRekeningField().setText(this.masterBskk.getKodeRekening());
        if(this.masterBskk.getMasterInvest() != null){
            updateBskk.getInvestField().setText(this.masterBskk.getMasterInvest().getNomorIjin());
        }
        updateBskk.getKeteranganField().setText(this.masterBskk.getKeterangan());
        updateBskk.getInvestField().setEditable(false);
        updateBskk.getTanggalField().setFormats("dd MMM yyyy");
        updateBskk.getTanggalField().setDate(this.masterBskk.getTanggal());
        updateBskk.getFormatDebet().setText(FormatRupiah.convert(""+this.masterBskk.getDebet()));
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
     public BskkService getService(){
        return bskkService;
    }
    public MainPageBskk getParent(){
        return mainPage.getParent();
    }
}
