/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.model.MasterDepartemen;
import aplikasiinvestasi.model.MasterInvest;
import aplikasiinvestasi.model.MasterLpb;
import aplikasiinvestasi.service.LpbService;
import aplikasiinvestasi.service.RekeningService;
import aplikasiinvestasi.service.impl.RekeningServiceImpl;
import aplikasiinvestasi.utils.FormatDate;
import aplikasiinvestasi.utils.FormatRupiah;
import aplikasiinvestasi.utils.Table;
import aplikasiinvestasi.utils.TextValidation;
import aplikasiinvestasi.view.AddNewLpb;
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
public class AddNewLpbController {
    
    private MainPageLpbController mainPage;
    private AddNewLpb addLpb;
    private LpbService lpbService;
    private List<MasterDepartemen> listDepartemen;
    private DefaultComboBoxModel model;
    private ChooseDataInvestController chooseData;
    private MasterInvest masterInvest;
    private List<MasterLpb> listMaster;
    private RekeningService rekeningService;
    
    public AddNewLpbController(MainPageLpbController mainPage, LpbService lpbService){
        this.mainPage = mainPage;
        this.lpbService = lpbService;
        this.addLpb = new AddNewLpb(this.mainPage.getMainPage(), true);
        this.addLpb.getHargaField().setDocument(new TextValidation());
        this.listMaster = new ArrayList<>();
        this.rekeningService = new RekeningServiceImpl();
        this.addLpb.getHargaField().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                hargaKeyReleased(evt);
            }
        });
         this.addLpb.getDebetField().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                debetKeyReleased(evt);
            }
        });
        this.addLpb.getHolo1Radio().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setComboBoxModel(e);
            }
        });
        this.addLpb.getHolo2Radio().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setComboBoxModel(e);
            }
        });
        this.addLpb.getSaveButton().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                saveData(e);
            }
        });
        this.addLpb.getAddButton().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addData(e);
            }
        });
        
        this.addLpb.getHargaField().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addData(e);
            }
        });
        this.addLpb.getDepartemenComboBox().addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                departemenComboBoxPropertyChange(evt);
            }
        });
       
        this.addLpb.getDepartemenComboBox().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                departemenComboAction(e);
            }
        });
        this.addLpb.getAddInvest().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectDataInvest(e);
            }
        });
    }
    
    public AddNewLpb getLpb(){
        
        viewOnTable();
        this.addLpb.setTitle("Tambah Data LPB Lokal");
        this.addLpb.setVisible(true);
        return addLpb;
    }
    public void viewOnTable(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Tanggal");
        model.addColumn(("Internal"));
        model.addColumn("Eksternal");
        model.addColumn("Keterangan");
        model.addColumn("QTY");
        model.addColumn("Debet");
        for(MasterLpb lpb : listMaster){
            Object[] obj = new Object[6];
            obj[0] = FormatDate.convert(lpb.getTanggal());
            obj[1] = lpb.getNoIpbInternal();
            obj[2] = lpb.getNoIpbEksternal();
            obj[3] = lpb.getKeterangan();
            obj[4] = lpb.getJumlah();
            obj[5] = FormatRupiah.convert(""+lpb.getDebet());
            model.addRow(obj);;
        }
        addLpb.getViewTable().setModel(model);
        float[] columnSize = {10.0f, 14.0f, 16.0f, 40.0f, 3.0f, 16.0f};
        Table.resizeTable(addLpb.getViewTable(), columnSize);
    }
    public void addData(java.awt.event.ActionEvent awt){
        MasterLpb lpb = new MasterLpb();
        try{
            if(validation()){
                lpb.setAlokasiBiaya(addLpb.getAlokasiBiayaField().getText());
                lpb.setKodeRekening(addLpb.getKodeRekeningField().getText());
                lpb.setDebet(Long.parseLong(addLpb.getDebetField().getText()));
                lpb.setHargaSatuan(Long.parseLong(addLpb.getHargaField().getText()));
                lpb.setJumlah(Double.parseDouble(addLpb.getJumlahField().getText()));
                lpb.setKeterangan(addLpb.getKeteranganField().getText());
                lpb.setNoIpbEksternal(addLpb.getNomorLpbEksternalField().getText());
                lpb.setNoIpbInternal(addLpb.getNomorLpbInternalField().getText());
                lpb.setSatuan(addLpb.getSatuanField().getText());
                lpb.setTanggal(addLpb.getTanggalField().getDate());
                lpb.setActiveStatus("ACTIVE");
                lpb.setSumberBarang("LOKAL");
                lpb.setMasterDepartemen(listDepartemen.get(addLpb.getDepartemenComboBox().getSelectedIndex()));
                if(masterInvest != null){
                    lpb.setMasterInvest(masterInvest);
                }
                if(addLpb.getPolosOption().isSelected()){
                    lpb.setStatus("POLOS");
                }else if(addLpb.getResmiOption().isSelected()){
                    lpb.setStatus("RESMI");
                }
                listMaster.add(lpb);
                viewOnTable();
                empty();
//                if(lpbService.saveData(lpb)){
//                    empty();
//                    mainPage.getAllData();
//                    mainPage.viewDataOnTable();
//                }
                
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Error Form \n" +e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }
    }
    
    public void saveData(java.awt.event.ActionEvent awt){

     if(lpbService.saveInBatch(listMaster)){
        empty();
        mainPage.getAllData();
        mainPage.viewDataOnTable();
        listMaster = new ArrayList<>();
     }

    }
    
    public void departemenComboAction(java.awt.event.ActionEvent awt){
        addLpb.getAlokasiBiayaField().setText(listDepartemen.get(addLpb.getDepartemenComboBox().getSelectedIndex()).getAlokasi());
        addLpb.getAlokasiBiayaField().requestFocus();
    }
    
    private void departemenComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {                                                  
      if(listDepartemen != null){
        addLpb.getAlokasiBiayaField().setText(listDepartemen.get(addLpb.getDepartemenComboBox().getSelectedIndex()).getAlokasi());
        addLpb.getAlokasiBiayaField().requestFocus();
      }else{
        addLpb.getAlokasiBiayaField().setText("");
      }
    }   
    
    public void setComboBoxModel(java.awt.event.ActionEvent awt){
        model = new DefaultComboBoxModel();
        if(addLpb.getHolo1Radio().isSelected()){
            listDepartemen = lpbService.getDepartemenByUnit("Holo I");
        }else{
            listDepartemen = lpbService.getDepartemenByUnit("Holo II");
        }
        for(MasterDepartemen departemen : listDepartemen){
            model.addElement(departemen.getNamaDepartment());
        }
        addLpb.getDepartemenComboBox().setModel(model);
    }
    public void empty(){
        
        addLpb.getDebetField().setText("");
        addLpb.getHargaField().setText("");
        addLpb.getJumlahField().setText("");
        addLpb.getKeteranganField().setText("");
        addLpb.getSatuanField().setText("");
        addLpb.getKodeRekeningField().setText("");
        addLpb.getButtonGroup1().clearSelection();
        addLpb.getButtonGroup2().clearSelection();
        model = new DefaultComboBoxModel();
        model.addElement("-- Pilih Departemen --");
        addLpb.getDepartemenComboBox().setModel(model);
        addLpb.getAlokasiBiayaField().setText("");
        addLpb.getKodeRekeningField().requestFocus();
        addLpb.getFormatHarga().setText("Rp.");
        addLpb.getFormatDebet().setText("Rp.");
        addLpb.getInvestField().setText("");
        masterInvest = null;
    }
    
    private void hargaKeyReleased(java.awt.event.KeyEvent evt) {
       try{
        formatRupiah(addLpb.getFormatHarga(), addLpb.getHargaField());
        Double jumlahDebet = Double.parseDouble(addLpb.getJumlahField().getText())* Long.parseLong(addLpb.getHargaField().getText());
        long result = jumlahDebet.longValue();
        addLpb.getDebetField().setText(""+result);
        formatRupiah(addLpb.getFormatDebet(), addLpb.getDebetField()); 
       }catch(NumberFormatException e){
           addLpb.getDebetField().setText("");
           addLpb.getFormatDebet().setText("");
       }
       
    }

    private void debetKeyReleased(java.awt.event.KeyEvent evt){
       formatRupiah(addLpb.getFormatDebet(), addLpb.getDebetField());
    }
    
    public void formatRupiah(JLabel labelFormat, JTextField textFormat){
       labelFormat.setText(FormatRupiah.convert(textFormat.getText()));
    }
    public boolean validation(){
        boolean passed = true;
            if(addLpb.getKodeRekeningField().getText().equals("") ||addLpb.getKodeRekeningField().getText().isEmpty()){
                passed = false;
                JOptionPane.showMessageDialog(null,"Kode Rekenig Harus Diisi \n" , "Error", JOptionPane.ERROR_MESSAGE, null);
            }else if(!addLpb.getPolosOption().isSelected() && !addLpb.getResmiOption().isSelected()){
                passed = false;
                JOptionPane.showMessageDialog(null,"Mohon Pilih Status Polos/Resmi \n" , "Error", JOptionPane.ERROR_MESSAGE, null);
            }else if(!addLpb.getHolo1Radio().isSelected() && !addLpb.getHolo2Radio().isSelected()){
                passed = false;
                JOptionPane.showMessageDialog(null,"Mohon Pilih Departemen \n" , "Error", JOptionPane.ERROR_MESSAGE, null);
            }else if(addLpb.getKeteranganField().getText().equals("") || addLpb.getKeteranganField().getText().isEmpty()){
               passed = false;
               JOptionPane.showMessageDialog(null,"Keterangan Harus Diisi \n" , "Error", JOptionPane.ERROR_MESSAGE, null);
            }else if(addLpb.getNomorLpbInternalField().getText().equals("") || addLpb.getNomorLpbInternalField().getText().isEmpty()){
               passed = false;
               JOptionPane.showMessageDialog(null,"Nomor LPB Internal Belum Diisi \n" , "Error", JOptionPane.ERROR_MESSAGE, null);
            }else if(addLpb.getNomorLpbEksternalField().getText().equals("") || addLpb.getNomorLpbEksternalField().getText().isEmpty()){
               passed = false;
               JOptionPane.showMessageDialog(null,"Nomor LPB Eksternal Belum Diisi \n" , "Error", JOptionPane.ERROR_MESSAGE, null);
            }else if(addLpb.getJumlahField().getText().equals("") || addLpb.getJumlahField().getText().isEmpty()){
               passed = false;
               JOptionPane.showMessageDialog(null,"Jumlah Harus Diisi \n" , "Error", JOptionPane.ERROR_MESSAGE, null);
            }else if(addLpb.getHargaField().getText().equals("") || addLpb.getHargaField().getText().isEmpty()){
               passed = false;
               JOptionPane.showMessageDialog(null,"Harga Harus Diisi \n" , "Error", JOptionPane.ERROR_MESSAGE, null);
               
            }else if(!rekeningService.checkRekening(addLpb.getKodeRekeningField().getText())){
                passed = false;
                addLpb.getKodeRekeningField().requestFocus();
                JOptionPane.showMessageDialog(null,"Cannot Find That Code \n" , "Warning", JOptionPane.ERROR_MESSAGE, null);
            }
        return passed;
    }
    
    public void selectDataInvest(java.awt.event.ActionEvent e){
        chooseData = new ChooseDataInvestController(this);
        chooseData.chooseInvest().setVisible(true);
    }
    
    public LpbService getService(){
     return lpbService;
    }
    
    public MainPageLpbController getParent(){
        return mainPage;
    }

    public void setMasterInvest(MasterInvest masterInvest) {
        this.masterInvest = masterInvest;
        addLpb.getInvestField().setText(masterInvest.getNomorIjin());
    }
    
}
