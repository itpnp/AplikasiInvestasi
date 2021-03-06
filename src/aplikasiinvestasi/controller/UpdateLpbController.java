/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.model.MasterDepartemen;
import aplikasiinvestasi.model.MasterInvest;
import aplikasiinvestasi.model.MasterLpb;
import aplikasiinvestasi.service.LpbService;
import aplikasiinvestasi.utils.FormatRupiah;
import aplikasiinvestasi.view.MainPageLpb;
import aplikasiinvestasi.view.UpdateLpb;
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
public class UpdateLpbController {
    private UpdateLpb updateLpb;
    private MainPageLpbController mainPageController;
    private MasterLpb masterLpb;
    private LpbService lpbService;
    private List<MasterDepartemen> listDepartemen;
    private ChooseDataInvestController chooseData;
    private String harga;
    private DecimalFormat df;
    
    public UpdateLpbController(MainPageLpbController mainPageController){
        this.mainPageController = mainPageController;
        updateLpb = new UpdateLpb(mainPageController.getMainPage(), true);
        this.lpbService = mainPageController.getService();
    }
    
    public void setData(MasterLpb masterLpb){
        this.masterLpb = masterLpb;
        updateLpb.getAlokasiBiayaField().setText(this.masterLpb.getAlokasiBiaya());
        updateLpb.getDebetField().setText(""+this.masterLpb.getDebet());
        updateLpb.getSuplierField().setText(this.masterLpb.getSuplier());
        if(this.masterLpb.getMasterDepartemen().getUnit().equals("Holo I")){
            updateLpb.getDepartemenComboBox().setModel(new DefaultComboBoxModel(this.comboboxModel("Holo I").toArray()));
            updateLpb.getHolo1Radio().setSelected(true);
        }else{
            updateLpb.getDepartemenComboBox().setModel(new DefaultComboBoxModel(this.comboboxModel("Holo II").toArray()));
            updateLpb.getHolo2Radio().setSelected(true);
        }
        updateLpb.getDepartemenComboBox().setSelectedItem(this.masterLpb.getMasterDepartemen().getNamaDepartment());
        if(this.masterLpb.getSumberBarang().equals("LOKAL")){
            updateLpb.getLokalRadio().setSelected(true);
        }else{
            updateLpb.getImportRadio().setSelected(true);
        }
        if(this.masterLpb.getStatus().equals("POLOS")){
            updateLpb.getPolosOption().setSelected(true);
        }else{
            updateLpb.getResmiOption().setSelected(true);
        }
        updateLpb.getSatuanField().setText(this.masterLpb.getSatuan());
        updateLpb.getNomorLpbInternalField().setText(this.masterLpb.getNoIpbInternal());
        updateLpb.getNomorLpbEksternalField().setText(this.masterLpb.getNoIpbEksternal());
        updateLpb.getKodeRekeningField().setText(this.masterLpb.getKodeRekening());
        updateLpb.getHargaField().setText(""+this.masterLpb.getHargaSatuan());
        if(this.masterLpb.getMasterInvest() != null){
            updateLpb.getInvestField().setText(this.masterLpb.getMasterInvest().getKodeInvest());
        }
        updateLpb.getJumlahField().setText(""+this.masterLpb.getJumlah());
        updateLpb.getKeteranganField().setText(this.masterLpb.getKeterangan());
        updateLpb.getInvestField().setEditable(false);
        updateLpb.getTanggalField().setFormats("dd MMM yyyy");
        updateLpb.getTanggalField().setDate(masterLpb.getTanggal());
        updateLpb.getFormatHarga().setText(FormatRupiah.convert(""+masterLpb.getHargaSatuan()));
        updateLpb.getFormatDebet().setText(FormatRupiah.convert(""+masterLpb.getDebet()));
    }
    
    @SuppressWarnings("empty-statement")
    public List<String> comboboxModel(String unit){
        listDepartemen = lpbService.getDepartemenByUnit(unit);
        List<String> model = new ArrayList<>();;
        for(MasterDepartemen departemen : listDepartemen){
            model.add(departemen.getNamaDepartment());
        }
        return model;
    }
    public void simpanAction(java.awt.event.ActionEvent e){
        this.masterLpb.setAlokasiBiaya(updateLpb.getAlokasiBiayaField().getText());
        this.masterLpb.setKodeRekening(updateLpb.getKodeRekeningField().getText());
        this.masterLpb.setDebet(Double.parseDouble(updateLpb.getDebetField().getText()));
        this.masterLpb.setHargaSatuan(Double.parseDouble(updateLpb.getHargaField().getText()));
        this.masterLpb.setJumlah(Double.parseDouble(updateLpb.getJumlahField().getText()));
        this.masterLpb.setKeterangan(updateLpb.getKeteranganField().getText());
        this.masterLpb.setNoIpbEksternal(updateLpb.getNomorLpbEksternalField().getText());
        this.masterLpb.setNoIpbInternal(updateLpb.getNomorLpbInternalField().getText());
        this.masterLpb.setSatuan(updateLpb.getSatuanField().getText());
        this.masterLpb.setTanggal(updateLpb.getTanggalField().getDate());
        this.masterLpb.setSuplier(updateLpb.getSuplierField().getText());
        this.masterLpb.setActiveStatus("ACTIVE");
        if(updateLpb.getLokalRadio().isSelected()){
          this.masterLpb.setSumberBarang("LOKAL");
        }else if(updateLpb.getImportRadio().isSelected()){
          this.masterLpb.setSumberBarang("IMPORT");
        }
        
        this.masterLpb.setMasterDepartemen(listDepartemen.get(updateLpb.getDepartemenComboBox().getSelectedIndex()));
        if(updateLpb.getPolosOption().isSelected()){
            this.masterLpb.setStatus("POLOS");
        }else if(updateLpb.getResmiOption().isSelected()){
           this.masterLpb.setStatus("RESMI");
        }
        lpbService.updateData(masterLpb);
        mainPageController.getAllData();
        mainPageController.viewDataOnTable();
    }
    public UpdateLpb editPage(){
        this.updateLpb.getDepartemenComboBox().addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                departemenComboBoxPropertyChange(evt);
            }
        });
        updateLpb.getSaveButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simpanAction(e);
            }
        });
        updateLpb.getRemoveButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeButton(e);
            }
        });
        updateLpb.getAddInvest().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectDataInvest(e);
            }
        });
        updateLpb.getHolo1Radio().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(updateLpb.getHolo1Radio().isSelected()){
                    updateLpb.getDepartemenComboBox().setModel(new DefaultComboBoxModel(comboboxModel("Holo I").toArray()));
                }else if(updateLpb.getHolo2Radio().isSelected()){
                    updateLpb.getDepartemenComboBox().setModel(new DefaultComboBoxModel(comboboxModel("Holo II").toArray()));
                }
            }
        });
        this.updateLpb.getHargaField().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                hargaKeyReleased(evt);
            }
        });
        updateLpb.getHolo2Radio().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(updateLpb.getHolo1Radio().isSelected()){
                    updateLpb.getDepartemenComboBox().setModel(new DefaultComboBoxModel(comboboxModel("Holo I").toArray()));
                }else if(updateLpb.getHolo2Radio().isSelected()){
                    updateLpb.getDepartemenComboBox().setModel(new DefaultComboBoxModel(comboboxModel("Holo II").toArray()));
                }
            }
        });
        return updateLpb;
    }
    
    public void selectDataInvest(java.awt.event.ActionEvent e){
        chooseData = new ChooseDataInvestController(this);
        chooseData.chooseInvest().setVisible(true);
    }
    public MainPageLpb getParent(){
        return mainPageController.getMainPage();
    }
    public LpbService getService(){
        return lpbService;
    }
    public void setMasterInvest(MasterInvest masterInvest){
        this.masterLpb.setMasterInvest(masterInvest);
        updateLpb.getInvestField().setText(masterLpb.getMasterInvest().getKodeInvest());
    }
    
    public void removeButton(java.awt.event.ActionEvent e){
        this.masterLpb.setMasterInvest(null);
        this.updateLpb.getInvestField().setText("");
    }
    private void departemenComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {                                                  
      if(listDepartemen != null){
        updateLpb.getAlokasiBiayaField().setText(listDepartemen.get(updateLpb.getDepartemenComboBox().getSelectedIndex()).getAlokasi());
        updateLpb.getAlokasiBiayaField().requestFocus();
      }else{
        updateLpb.getAlokasiBiayaField().setText("");
      }
    } 
    public void formatRupiah(JLabel labelFormat, JTextField textFormat){
       labelFormat.setText(FormatRupiah.convert(textFormat.getText()));
    }
    private void hargaKeyReleased(java.awt.event.KeyEvent evt) {
       try{
        df=new DecimalFormat("##.##");
        harga = updateLpb.getHargaField().getText();
        formatRupiah(updateLpb.getFormatHarga(), updateLpb.getHargaField());
        Double jumlahDebet = Double.parseDouble(updateLpb.getJumlahField().getText())* Double.parseDouble(harga);
        String formate = df.format(jumlahDebet); 
        Double finalValue = Double.parseDouble(""+df.parse(formate));
        harga = String.format("%.2f", finalValue);
        harga = harga.replace(",", ".");
        updateLpb.getDebetField().setText(harga);
        formatRupiah(updateLpb.getFormatDebet(), updateLpb.getDebetField()); 
        
       }catch(NumberFormatException e){
           updateLpb.getDebetField().setText("");
           updateLpb.getFormatDebet().setText("");
       } catch (ParseException ex) {
            Logger.getLogger(AddNewLpbController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
