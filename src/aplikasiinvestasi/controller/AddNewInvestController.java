/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.model.MasterDepartemen;
import aplikasiinvestasi.model.MasterInvest;
import aplikasiinvestasi.service.InvestPageService;
import aplikasiinvestasi.service.impl.InvestPageServiceImpl;
import aplikasiinvestasi.utils.FormatRupiah;
import aplikasiinvestasi.view.AddNewInvest;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Rizaldi Habibie
 */
public class AddNewInvestController {
    
    private MainPageController mainPage;
    private AddNewInvest addNewInvest = new AddNewInvest();
    private InvestPageService dataService = new InvestPageServiceImpl();
    private List<MasterDepartemen> listPemohon, listPenanggungJawab;
    
    public AddNewInvestController(MainPageController mainPage){
        this.mainPage = mainPage;
        addNewInvest.getRencanaField().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rencanaField(evt);
            }
        });
        addNewInvest.getCancelButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelButtonAction(e);
            }
        });
        addNewInvest.getSaveButton().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                saveData(e);
            }
        });
        addNewInvest.getUnit1().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setPenanggungJawab(e);
            }
        });
        addNewInvest.getUnit2().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setPenanggungJawab(e);
            }
        });
        addNewInvest.getUnit3().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setPemohon(e);
            }
        });
        addNewInvest.getUnit4().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setPemohon(e);
            }
        });
        addNewInvest.getTanggalInvest().setFormats("dd MMMM yyyy");
    }
    
    public void cancelButtonAction(java.awt.event.ActionEvent awt){
        mainPage.openInvestPage(addNewInvest);
    }
    public void rencanaField(java.awt.event.KeyEvent evt){
        formatRupiah(addNewInvest.getRupiahFormat(), addNewInvest.getRencanaField());
    }
    public void formatRupiah(JLabel labelFormat, JTextField textFormat){
       labelFormat.setText(FormatRupiah.convert(textFormat.getText()));
    }
    public AddNewInvest getAddNewInvest(){
        return addNewInvest;
    }
    public void saveData(java.awt.event.ActionEvent awt){
        MasterInvest invest = new MasterInvest();
        invest.setDepartemenPengajuan(listPenanggungJawab.get(addNewInvest.getPenanggungJawabCombo().getSelectedIndex()));
        invest.setDepartemenPemohon(listPemohon.get(addNewInvest.getPemohonField().getSelectedIndex()));
        invest.setNomorIjin(addNewInvest.getNomorSuratIjinField().getText());
        invest.setJenisInvest(addNewInvest.getJenisInvestField().getText());
        invest.setJumlah(Integer.parseInt(addNewInvest.getJumlahField().getText()));
        invest.setRencanaBiaya(Long.parseLong(addNewInvest.getRencanaField().getText()));
        invest.setTanggalIjinInvest(addNewInvest.getTanggalInvest().getDate());
        invest.setKodeInvest(addNewInvest.getKodeInvestField().getText());
        if(dataService.saveData(invest)){
            empty();
        }
    }
    
    @SuppressWarnings("empty-statement")
    public List<String> comboboxModel(String unit){
        listPemohon = dataService.getDataByUnit(unit);
        List<String> model = new ArrayList<>();;
        for(MasterDepartemen departemen : listPemohon){
            model.add(departemen.getNamaDepartment());
        }
        return model;
    }
    
    @SuppressWarnings("empty-statement")
    public List<String> comboboxModelPenanggungJawab(String unit){
        listPenanggungJawab = dataService.getDataByUnit(unit);
        List<String> model = new ArrayList<>();;
        for(MasterDepartemen departemen : listPenanggungJawab){
            model.add(departemen.getNamaDepartment());
        }
        return model;
    }
   public void setPenanggungJawab(java.awt.event.ActionEvent awt){
       if(addNewInvest.getUnit1().isSelected()){
            addNewInvest.getPenanggungJawabCombo().setModel(new DefaultComboBoxModel(this.comboboxModelPenanggungJawab(addNewInvest.getUnit1().getText()).toArray()));
       }else if(addNewInvest.getUnit2().isSelected()){
            addNewInvest.getPenanggungJawabCombo().setModel(new DefaultComboBoxModel(this.comboboxModelPenanggungJawab(addNewInvest.getUnit2().getText()).toArray()));
       }
   }
    public void setPemohon(java.awt.event.ActionEvent awt){
       if(addNewInvest.getUnit3().isSelected()){
            addNewInvest.getPemohonField().setModel(new DefaultComboBoxModel(this.comboboxModel(addNewInvest.getUnit3().getText()).toArray()));
       }else if(addNewInvest.getUnit4().isSelected()){
            addNewInvest.getPemohonField().setModel(new DefaultComboBoxModel(this.comboboxModel(addNewInvest.getUnit4().getText()).toArray()));
       }
   }
    public void empty(){
       addNewInvest.getPenanggungJawabCombo().setSelectedIndex(0);
       addNewInvest.getPemohonField().setSelectedIndex(0);
       addNewInvest.getNomorSuratIjinField().setText("");
       addNewInvest.getJenisInvestField().setText("");
       addNewInvest.getJumlahField().setText("");
       addNewInvest.getRencanaField().setText("");   
       addNewInvest.getKodeInvestField().setText("");
       addNewInvest.getTanggalInvest().setDate(new Date());
       addNewInvest.getButtonGroup1().clearSelection();
       addNewInvest.getButtonGroup2().clearSelection();
       addNewInvest.getRupiahFormat().setText("Rp.");
       String[] defaultCombo = new String[1];
       defaultCombo[0] = "-- Pilih Departemen --";
       addNewInvest.getPemohonField().setModel(new DefaultComboBoxModel(defaultCombo));
       addNewInvest.getPenanggungJawabCombo().setModel(new DefaultComboBoxModel(defaultCombo));
    }
}
