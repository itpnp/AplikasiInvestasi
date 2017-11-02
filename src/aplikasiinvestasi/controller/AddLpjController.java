/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.model.MasterDepartemen;
import aplikasiinvestasi.model.MasterInvest;
import aplikasiinvestasi.model.MasterLpj;
import aplikasiinvestasi.service.LpjService;
import aplikasiinvestasi.service.RekeningService;
import aplikasiinvestasi.service.impl.RekeningServiceImpl;
import aplikasiinvestasi.utils.FormatDate;
import aplikasiinvestasi.utils.FormatRupiah;
import aplikasiinvestasi.utils.Table;
import aplikasiinvestasi.utils.TextValidation;
import aplikasiinvestasi.view.AddNewLpj;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rizaldi Habibie
 */
public class AddLpjController {
    
    private AddNewLpj addLpj;
    private MainPageLpbController mainPage;
    private LpjService lpjService;
    private List<MasterDepartemen> listDepartemen;
    private DefaultComboBoxModel model;
    private ChooseDataInvestController chooseData;
    private MasterInvest masterInvest;
    private List<MasterLpj> listMaster;
    private RekeningService rekeningService;
    private String harga;
    private DecimalFormat df;
    
    public AddLpjController(MainPageLpbController mainPage, LpjService lpjService){
        this.mainPage = mainPage;
        this.lpjService = lpjService;
        this.addLpj = new AddNewLpj(this.mainPage.getMainPage(), true);
        this.addLpj.getHargaField().setDocument(new TextValidation());
        this.listMaster = new ArrayList<>();
        this.rekeningService = new RekeningServiceImpl();
        this.addLpj.getHargaField().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                hargaKeyReleased(evt);
            }
        });
         this.addLpj.getDebetField().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                debetKeyReleased(evt);
            }
        });
         this.addLpj.getPpnField().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ppnKeyReleased(evt);
            }
        });
         this.addLpj.getPphField().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pphKeyReleased(evt);
            }
        });
        this.addLpj.getHolo1Radio().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setComboBoxModel(e);
            }
        });
        this.addLpj.getHolo2Radio().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setComboBoxModel(e);
            }
        });
        this.addLpj.getResmiOption().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                openPpn(e);
            }
        });
         this.addLpj.getPolosOption().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                openPpn(e);
            }
        });
        this.addLpj.getSaveButton().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                saveData(e);
            }
        });
        this.addLpj.getAddButton().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addData(e);
            }
        });
        
        this.addLpj.getHargaField().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addData(e);
            }
        });
        this.addLpj.getDepartemenComboBox().addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                departemenComboBoxPropertyChange(evt);
            }
        });
       
        this.addLpj.getDepartemenComboBox().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                departemenComboAction(e);
            }
        });
        this.addLpj.getAddInvest().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectDataInvest(e);
            }
        });
        this.addLpj.getTanggalField().setFormats("dd MMMM yyyy");

    }
    public void viewOnTable(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Tanggal");
        model.addColumn(("Internal"));
        model.addColumn("Eksternal");
        model.addColumn("Keterangan");
        model.addColumn("QTY");
        model.addColumn("Debet");
        for(MasterLpj lpj : listMaster){
            Object[] obj = new Object[6];
            obj[0] = FormatDate.convert(lpj.getTanggal());
            obj[1] = lpj.getNoIpbInternal();
            obj[2] = lpj.getNoIpbEksternal();
            obj[3] = lpj.getKeterangan();
            obj[4] = lpj.getJumlah();
            obj[5] = FormatRupiah.convert(""+lpj.getDebet());
            model.addRow(obj);;
        }
        addLpj.getViewTable().setModel(model);
        float[] columnSize = {10.0f, 14.0f, 16.0f, 40.0f, 3.0f, 16.0f};
        Table.resizeTable(addLpj.getViewTable(), columnSize);
    }
    public void addData(java.awt.event.ActionEvent awt){
        MasterLpj lpj = new MasterLpj();
        try{
            if(validation()){
                lpj.setAlokasiBiaya(addLpj.getAlokasiBiayaField().getText());
                lpj.setKodeRekening(addLpj.getKodeRekeningField().getText());
                lpj.setDebet(Double.parseDouble(addLpj.getDebetField().getText()));
                lpj.setHargaSatuan(Double.parseDouble(addLpj.getHargaField().getText()));
                lpj.setJumlah(Double.parseDouble(addLpj.getJumlahField().getText()));
                lpj.setKeterangan(addLpj.getKeteranganField().getText());
                lpj.setNoIpbEksternal(addLpj.getNomorLpbEksternalField().getText());
                lpj.setNoIpbInternal(addLpj.getNomorLpbInternalField().getText());
                lpj.setSatuan(addLpj.getSatuanField().getText());
                lpj.setTanggal(addLpj.getTanggalField().getDate());
                lpj.setPph(Integer.valueOf(addLpj.getPphField().getText()));
                lpj.setActiveStatus("ACTIVE");
                lpj.setSuplier(addLpj.getSuplierField().getText());
                lpj.setMasterDepartemen(listDepartemen.get(addLpj.getDepartemenComboBox().getSelectedIndex()));
                if(masterInvest != null){
                    lpj.setMasterInvest(masterInvest);
                }
                if(addLpj.getPolosOption().isSelected()){
                    lpj.setStatus("POLOS");
                    lpj.setPpn(0.0);
                }else if(addLpj.getResmiOption().isSelected()){
                    lpj.setStatus("RESMI");
                    lpj.setPpn(Double.parseDouble(addLpj.getPpnField().getText()));
                }
                listMaster.add(lpj);
                viewOnTable();
                empty();
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Error Form \n" +e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }
    }
    public void saveData(java.awt.event.ActionEvent awt){

     if(lpjService.saveInBatch(listMaster)){
        empty();
        mainPage.getAllData();
        mainPage.viewDataOnTable();
        listMaster = new ArrayList<>();
     }

    }
    public void departemenComboAction(java.awt.event.ActionEvent awt){
        addLpj.getAlokasiBiayaField().setText(listDepartemen.get(addLpj.getDepartemenComboBox().getSelectedIndex()).getAlokasi());
        addLpj.getAlokasiBiayaField().requestFocus();
    }
    
    private void departemenComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {                                                  
      if(listDepartemen != null){
        addLpj.getAlokasiBiayaField().setText(listDepartemen.get(addLpj.getDepartemenComboBox().getSelectedIndex()).getAlokasi());
        addLpj.getAlokasiBiayaField().requestFocus();
      }else{
        addLpj.getAlokasiBiayaField().setText("");
      }
    }   
    
    public void setComboBoxModel(java.awt.event.ActionEvent awt){
        model = new DefaultComboBoxModel();
        if(addLpj.getHolo1Radio().isSelected()){
            listDepartemen = lpjService.getDepartemenByUnit("Holo I");
        }else{
            listDepartemen = lpjService.getDepartemenByUnit("Holo II");
        }
        for(MasterDepartemen departemen : listDepartemen){
            model.addElement(departemen.getNamaDepartment());
        }
        addLpj.getDepartemenComboBox().setModel(model);
    }
    
    public void openPpn(java.awt.event.ActionEvent awt){
        model = new DefaultComboBoxModel();
        if(addLpj.getResmiOption().isSelected()){
            addLpj.getLabelPpn().setVisible(true);
            addLpj.getPpnField().setVisible(true);
            addLpj.getFormatPpn().setVisible(true);
        }else{
            addLpj.getLabelPpn().setVisible(false);
            addLpj.getPpnField().setVisible(false);
            addLpj.getFormatPpn().setVisible(false);
        }
        for(MasterDepartemen departemen : listDepartemen){
            model.addElement(departemen.getNamaDepartment());
        }
        addLpj.getDepartemenComboBox().setModel(model);
    }
    
    public void empty(){
        
        addLpj.getDebetField().setText("");
        addLpj.getHargaField().setText("");
        addLpj.getJumlahField().setText("");
        addLpj.getKeteranganField().setText("");
        addLpj.getSatuanField().setText("");
        addLpj.getKodeRekeningField().setText("");
        addLpj.getButtonGroup1().clearSelection();
        addLpj.getButtonGroup2().clearSelection();
        model = new DefaultComboBoxModel();
        model.addElement("-- Pilih Departemen --");
        addLpj.getDepartemenComboBox().setModel(model);
        addLpj.getAlokasiBiayaField().setText("");
        addLpj.getKodeRekeningField().requestFocus();
        addLpj.getFormatHarga().setText("Rp.");
        addLpj.getFormatDebet().setText("Rp.");
        addLpj.getInvestField().setText("");
        masterInvest = null;
    }
    private void hargaKeyReleased(java.awt.event.KeyEvent evt) {
       try{
        df=new DecimalFormat("0.00");
        harga = addLpj.getHargaField().getText();
        harga  = harga.replace(',', '.');
        formatRupiah(addLpj.getFormatHarga(), addLpj.getHargaField());
        Double jumlahDebet = Double.parseDouble(addLpj.getJumlahField().getText())* Double.parseDouble(harga);
        String formate = df.format(jumlahDebet); 
        double finalValue = Double.parseDouble(""+df.parse(formate));
        harga = String.format("%.2f", finalValue);
        harga = harga.replace(",", ".");
        addLpj.getDebetField().setText(harga);
        formatRupiah(addLpj.getFormatDebet(), addLpj.getDebetField()); 
       }catch(NumberFormatException e){
           addLpj.getDebetField().setText("");
           addLpj.getFormatDebet().setText("");
       } catch (ParseException ex) {
            Logger.getLogger(AddLpjController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    private void debetKeyReleased(java.awt.event.KeyEvent evt){
       formatRupiah(addLpj.getFormatDebet(), addLpj.getDebetField());
    }
    
    private void ppnKeyReleased(java.awt.event.KeyEvent evt){
       formatRupiah(addLpj.getFormatPpn(), addLpj.getPpnField());
    }
    
    private void pphKeyReleased(java.awt.event.KeyEvent evt){
       formatRupiah(addLpj.getFormatPph(), addLpj.getPphField());
    }
    
    public void formatRupiah(JLabel labelFormat, JTextField textFormat){
       labelFormat.setText(FormatRupiah.convert(textFormat.getText()));
    }
    public boolean validation(){
        boolean passed = true;
            if(addLpj.getKodeRekeningField().getText().equals("") ||addLpj.getKodeRekeningField().getText().isEmpty()){
                passed = false;
                JOptionPane.showMessageDialog(null,"Kode Rekenig Harus Diisi \n" , "Error", JOptionPane.ERROR_MESSAGE, null);
            }else if(!addLpj.getPolosOption().isSelected() && !addLpj.getResmiOption().isSelected()){
                passed = false;
                JOptionPane.showMessageDialog(null,"Mohon Pilih Status Polos/Resmi \n" , "Error", JOptionPane.ERROR_MESSAGE, null);
            }else if(!addLpj.getHolo1Radio().isSelected() && !addLpj.getHolo2Radio().isSelected()){
                passed = false;
                JOptionPane.showMessageDialog(null,"Mohon Pilih Departemen \n" , "Error", JOptionPane.ERROR_MESSAGE, null);
            }else if(addLpj.getKeteranganField().getText().equals("") || addLpj.getKeteranganField().getText().isEmpty()){
               passed = false;
               JOptionPane.showMessageDialog(null,"Keterangan Harus Diisi \n" , "Error", JOptionPane.ERROR_MESSAGE, null);
            }else if(addLpj.getNomorLpbInternalField().getText().equals("") || addLpj.getNomorLpbInternalField().getText().isEmpty()){
               passed = false;
               JOptionPane.showMessageDialog(null,"Nomor LPB Internal Belum Diisi \n" , "Error", JOptionPane.ERROR_MESSAGE, null);
            }else if(addLpj.getNomorLpbEksternalField().getText().equals("") || addLpj.getNomorLpbEksternalField().getText().isEmpty()){
               passed = false;
               JOptionPane.showMessageDialog(null,"Nomor LPB Eksternal Belum Diisi \n" , "Error", JOptionPane.ERROR_MESSAGE, null);
            }else if(addLpj.getJumlahField().getText().equals("") || addLpj.getJumlahField().getText().isEmpty()){
               passed = false;
               JOptionPane.showMessageDialog(null,"Jumlah Harus Diisi \n" , "Error", JOptionPane.ERROR_MESSAGE, null);
            }else if(addLpj.getHargaField().getText().equals("") || addLpj.getHargaField().getText().isEmpty()){
               passed = false;
               JOptionPane.showMessageDialog(null,"Harga Harus Diisi \n" , "Error", JOptionPane.ERROR_MESSAGE, null);
               
            }else if(!rekeningService.checkRekening(addLpj.getKodeRekeningField().getText())){
                passed = false;
                addLpj.getKodeRekeningField().requestFocus();
                JOptionPane.showMessageDialog(null,"Cannot Find That Code \n" , "Warning", JOptionPane.ERROR_MESSAGE, null);
            }
        return passed;
    }
    
    public void selectDataInvest(java.awt.event.ActionEvent e){
        chooseData = new ChooseDataInvestController(this);
        chooseData.chooseInvest().setVisible(true);
    }
    
    public LpjService getService(){
     return lpjService;
    }
    
    public MainPageLpbController getParent(){
        return mainPage;
    }

    public void setMasterInvest(MasterInvest masterInvest) {
        this.masterInvest = masterInvest;
        addLpj.getInvestField().setText(masterInvest.getNomorIjin());
    }
    public AddNewLpj getLpj(){
        
        viewOnTable();
        this.addLpj.setTitle("Tambah Data LPJ");
        this.addLpj.setVisible(true);
        return addLpj;
    }
}
