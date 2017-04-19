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
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

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
    
    public UpdateLpbController(MainPageLpbController mainPageController){
        this.mainPageController = mainPageController;
        updateLpb = new UpdateLpb(mainPageController.getMainPage(), true);
        this.lpbService = mainPageController.getService();
    }
    
    public void setData(MasterLpb masterLpb){
        this.masterLpb = masterLpb;
        updateLpb.getAlokasiBiayaField().setText(this.masterLpb.getAlokasiBiaya());
        updateLpb.getDebetField().setText(""+this.masterLpb.getDebet());
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
        this.masterLpb.setDebet(Long.parseLong(updateLpb.getDebetField().getText()));
        this.masterLpb.setHargaSatuan(Long.parseLong(updateLpb.getHargaField().getText()));
        this.masterLpb.setJumlah(Double.parseDouble(updateLpb.getJumlahField().getText()));
        this.masterLpb.setKeterangan(updateLpb.getKeteranganField().getText());
        this.masterLpb.setNoIpbEksternal(updateLpb.getNomorLpbEksternalField().getText());
        this.masterLpb.setNoIpbInternal(updateLpb.getNomorLpbInternalField().getText());
        this.masterLpb.setSatuan(updateLpb.getSatuanField().getText());
        this.masterLpb.setTanggal(updateLpb.getTanggalField().getDate());
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
    }
    public UpdateLpb editPage(){
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
}
