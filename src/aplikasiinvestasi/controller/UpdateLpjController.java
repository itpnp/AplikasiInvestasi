/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.model.MasterDepartemen;
import aplikasiinvestasi.model.MasterInvest;
import aplikasiinvestasi.model.MasterLpb;
import aplikasiinvestasi.model.MasterLpj;
import aplikasiinvestasi.service.LpbService;
import aplikasiinvestasi.service.LpjService;
import aplikasiinvestasi.utils.FormatRupiah;
import aplikasiinvestasi.view.MainPageLpb;
import aplikasiinvestasi.view.UpdateLpb;
import aplikasiinvestasi.view.UpdateLpj;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Rizaldi Habibie
 */
public class UpdateLpjController {
    private UpdateLpj updateLpj;
    private MainPageLpbController mainPageController;
    private MasterLpj masterLpj;
    private LpjService lpjService;
    private List<MasterDepartemen> listDepartemen;
    private ChooseDataInvestController chooseData;
    private String harga;
    private DecimalFormat df;
    
    public UpdateLpjController(MainPageLpbController mainPageController){
        this.mainPageController = mainPageController;
        updateLpj = new UpdateLpj(mainPageController.getMainPage(), true);
        this.lpjService = mainPageController.getLpjService();
    }
    
    public void setData(MasterLpj masterLpj){
        this.masterLpj = masterLpj;
        updateLpj.getAlokasiBiayaField().setText(this.masterLpj.getAlokasiBiaya());
        updateLpj.getDebetField().setText(""+this.masterLpj.getDebet());
        if(this.masterLpj.getMasterDepartemen().getUnit().equals("Holo I")){
            updateLpj.getDepartemenComboBox().setModel(new DefaultComboBoxModel(this.comboboxModel("Holo I").toArray()));
            updateLpj.getHolo1Radio().setSelected(true);
        }else{
            updateLpj.getDepartemenComboBox().setModel(new DefaultComboBoxModel(this.comboboxModel("Holo II").toArray()));
            updateLpj.getHolo2Radio().setSelected(true);
        }
        updateLpj.getDepartemenComboBox().setSelectedItem(this.masterLpj.getMasterDepartemen().getNamaDepartment());
        
        if(this.masterLpj.getStatus().equals("POLOS")){
            updateLpj.getPolosOption().setSelected(true);
        }else{
            updateLpj.getResmiOption().setSelected(true);
        }
        updateLpj.getSatuanField().setText(this.masterLpj.getSatuan());
        updateLpj.getNomorLpbInternalField().setText(this.masterLpj.getNoIpbInternal());
        updateLpj.getNomorLpbEksternalField().setText(this.masterLpj.getNoIpbEksternal());
        updateLpj.getKodeRekeningField().setText(this.masterLpj.getKodeRekening());
        updateLpj.getPphField().setText(""+this.masterLpj.getPph());
        updateLpj.getHargaField().setText(""+this.masterLpj.getHargaSatuan());
        if(this.masterLpj.getMasterInvest() != null){
            updateLpj.getInvestField().setText(this.masterLpj.getMasterInvest().getKodeInvest());
        }
        updateLpj.getJumlahField().setText(""+this.masterLpj.getJumlah());
        updateLpj.getKeteranganField().setText(this.masterLpj.getKeterangan());
        updateLpj.getInvestField().setEditable(false);
        updateLpj.getTanggalField().setFormats("dd MMM yyyy");
        updateLpj.getTanggalField().setDate(masterLpj.getTanggal());
        updateLpj.getFormatHarga().setText(FormatRupiah.convert(""+masterLpj.getHargaSatuan()));
        updateLpj.getFormatDebet().setText(FormatRupiah.convert(""+masterLpj.getDebet()));
    }
    
    @SuppressWarnings("empty-statement")
    public List<String> comboboxModel(String unit){
        listDepartemen = lpjService.getDepartemenByUnit(unit);
        List<String> model = new ArrayList<>();;
        for(MasterDepartemen departemen : listDepartemen){
            model.add(departemen.getNamaDepartment());
        }
        return model;
    }
    public void simpanAction(java.awt.event.ActionEvent e){
        this.masterLpj.setAlokasiBiaya(updateLpj.getAlokasiBiayaField().getText());
        this.masterLpj.setKodeRekening(updateLpj.getKodeRekeningField().getText());
        this.masterLpj.setDebet(Double.parseDouble(updateLpj.getDebetField().getText()));
        this.masterLpj.setHargaSatuan(Double.parseDouble(updateLpj.getHargaField().getText()));
        this.masterLpj.setJumlah(Double.parseDouble(updateLpj.getJumlahField().getText()));
        this.masterLpj.setKeterangan(updateLpj.getKeteranganField().getText());
        this.masterLpj.setNoIpbEksternal(updateLpj.getNomorLpbEksternalField().getText());
        this.masterLpj.setNoIpbInternal(updateLpj.getNomorLpbInternalField().getText());
        this.masterLpj.setSatuan(updateLpj.getSatuanField().getText());
        this.masterLpj.setTanggal(updateLpj.getTanggalField().getDate());
        this.masterLpj.setPph(Integer.parseInt(updateLpj.getPphField().getText()));
        this.masterLpj.setActiveStatus("ACTIVE");
        
        this.masterLpj.setMasterDepartemen(listDepartemen.get(updateLpj.getDepartemenComboBox().getSelectedIndex()));
        if(updateLpj.getPolosOption().isSelected()){
            this.masterLpj.setStatus("POLOS");
        }else if(updateLpj.getResmiOption().isSelected()){
           this.masterLpj.setStatus("RESMI");
        }
        lpjService.updateData(masterLpj);
        mainPageController.getAllData();
        mainPageController.viewLpjOnTable();
    }
    public UpdateLpj editPage(){
        this.updateLpj.getDepartemenComboBox().addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                departemenComboBoxPropertyChange(evt);
            }
        });
        updateLpj.getSaveButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simpanAction(e);
            }
        });
        updateLpj.getRemoveButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeButton(e);
            }
        });
        updateLpj.getAddInvest().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectDataInvest(e);
            }
        });
        updateLpj.getHolo1Radio().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(updateLpj.getHolo1Radio().isSelected()){
                    updateLpj.getDepartemenComboBox().setModel(new DefaultComboBoxModel(comboboxModel("Holo I").toArray()));
                }else if(updateLpj.getHolo2Radio().isSelected()){
                    updateLpj.getDepartemenComboBox().setModel(new DefaultComboBoxModel(comboboxModel("Holo II").toArray()));
                }
            }
        });
        updateLpj.getHolo2Radio().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(updateLpj.getHolo1Radio().isSelected()){
                    updateLpj.getDepartemenComboBox().setModel(new DefaultComboBoxModel(comboboxModel("Holo I").toArray()));
                }else if(updateLpj.getHolo2Radio().isSelected()){
                    updateLpj.getDepartemenComboBox().setModel(new DefaultComboBoxModel(comboboxModel("Holo II").toArray()));
                }
            }
        });
        this.updateLpj.getHargaField().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                hargaKeyReleased(evt);
            }
        });
        return updateLpj;
    }
     private void hargaKeyReleased(java.awt.event.KeyEvent evt) {
       try{
        df=new DecimalFormat("0.00");
        harga = updateLpj.getHargaField().getText();
        formatRupiah(updateLpj.getFormatHarga(), updateLpj.getHargaField());
        Double jumlahDebet = Double.parseDouble(updateLpj.getJumlahField().getText())* Double.parseDouble(harga);
        String formate = df.format(jumlahDebet); 
        double finalValue = Double.parseDouble(""+df.parse(formate));
        harga = String.format("%.2f", finalValue);
        harga = harga.replace(",", ".");
        updateLpj.getDebetField().setText(harga);
        formatRupiah(updateLpj.getFormatDebet(), updateLpj.getDebetField()); 
       }catch(NumberFormatException e){
           updateLpj.getDebetField().setText("");
           updateLpj.getFormatDebet().setText("");
       } catch (ParseException ex) {
            Logger.getLogger(AddLpjController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
     public void formatRupiah(JLabel labelFormat, JTextField textFormat){
       labelFormat.setText(FormatRupiah.convert(textFormat.getText()));
    }
    public void selectDataInvest(java.awt.event.ActionEvent e){
        chooseData = new ChooseDataInvestController(this);
        chooseData.chooseInvest().setVisible(true);
    }
    public MainPageLpb getParent(){
        return mainPageController.getMainPage();
    }
    public LpjService getService(){
        return lpjService;
    }
    public void setMasterInvest(MasterInvest masterInvest){
        this.masterLpj.setMasterInvest(masterInvest);
        updateLpj.getInvestField().setText(masterLpj.getMasterInvest().getKodeInvest());
    }
    
    public void removeButton(java.awt.event.ActionEvent e){
        this.masterLpj.setMasterInvest(null);
        this.updateLpj.getInvestField().setText("");
    }
    private void departemenComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {                                                  
      if(listDepartemen != null){
        updateLpj.getAlokasiBiayaField().setText(listDepartemen.get(updateLpj.getDepartemenComboBox().getSelectedIndex()).getAlokasi());
        updateLpj.getAlokasiBiayaField().requestFocus();
      }else{
        updateLpj.getAlokasiBiayaField().setText("");
      }
    } 
}
