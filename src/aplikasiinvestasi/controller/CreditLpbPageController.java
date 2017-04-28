/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.dto.TotalKredit;
import aplikasiinvestasi.service.LpbService;
import aplikasiinvestasi.service.LpjService;
import aplikasiinvestasi.utils.BulanEnum;
import aplikasiinvestasi.utils.FormatRupiah;
import aplikasiinvestasi.view.CreditLpbPage;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rizaldi Habibie
 */
public class CreditLpbPageController {
    
    private CreditLpbPage creditPage;
    private MainPageLpbController mainPage;
    private LpbService lpbService;
    private LpjService lpjService;
    private List<TotalKredit> listKredit, listKreditLpj, listResult;
    
    public CreditLpbPageController(MainPageLpbController mainPage){
        this.mainPage = mainPage;
        this.creditPage = new CreditLpbPage(mainPage.getMainPage(),true);
        this.lpbService = mainPage.getService();
        this.lpjService = mainPage.getLpjService();
    }
    
    public void viewDataOnTable(List<TotalKredit> listKredit){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("<html><center>Kode<br>Rekening");
        model.addColumn("Bulan");
        model.addColumn("Tahun");
        model.addColumn("Kredit");
        for(TotalKredit kredit : listKredit){
            Object[] obj = new Object[4];
            obj[0] = kredit.getKodeRekening();
            obj[1] = kredit.getBulan();
            obj[2] = kredit.getTahun();
            obj[3] = FormatRupiah.convert(String.valueOf(kredit.getKredit()));
            model.addRow(obj);
        }
        creditPage.getViewTable().setModel(model);
    }
    
    public CreditLpbPage creditPage(){
        listKredit = lpbService.countAllCredit();
        viewDataOnTable(listKredit);
        creditPage.getBulanComboBox().setModel(new DefaultComboBoxModel(BulanEnum.namaBulan()));
        creditPage.setResizable(false);
        creditPage.getFindButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findData(e);
            }
        });
        return creditPage;
    }
    
    public void findData(java.awt.event.ActionEvent e){
                listResult = new ArrayList<>();

        if(creditPage.getAllCheck().isSelected()){
            String bulan = null;
            if((creditPage.getBulanComboBox().getSelectedIndex()) <10){
              bulan = "0"+(creditPage.getBulanComboBox().getSelectedIndex());
            }else{
                bulan = ""+(creditPage.getBulanComboBox().getSelectedIndex());
            }
            listKredit = lpbService.countCreditByMonthAndYear(bulan, creditPage.getTahunComboBox().getSelectedItem().toString());
            listKreditLpj = lpjService.countCreditByMonthAndYear(bulan, creditPage.getTahunComboBox().getSelectedItem().toString()); 
//            for(TotalKredit kreditLpj : listKreditLpj){
//                for(TotalKredit kreditLpb : listKredit){
//                    if(kreditLpb.getKodeRekening().equals(kreditLpj.getKodeRekening())){
//                        kreditLpb.setKredit(kreditLpb.getKredit()+kreditLpj.getKredit());
//                    }
//                }
//            }
            for (Iterator<TotalKredit> it = listKreditLpj.iterator(); it.hasNext() ;)
            {
                for(TotalKredit kreditLpb : listKredit){
                    TotalKredit x = it.next();
                    if(kreditLpb.getKodeRekening().equals(x.getKodeRekening())){
                        kreditLpb.setKredit(kreditLpb.getKredit()+x.getKredit());
                        it.remove();
                    }
                }
                
            }
            listResult.addAll(listKredit);
            listResult.addAll(listKreditLpj);
            viewDataOnTable(listResult);
        }else if(creditPage.getLpbCheck().isSelected()){
            String bulan = null;
            if((creditPage.getBulanComboBox().getSelectedIndex()) <10){
              bulan = "0"+(creditPage.getBulanComboBox().getSelectedIndex());
            }else{
              bulan = ""+(creditPage.getBulanComboBox().getSelectedIndex());
            }
            listKredit = lpbService.countCreditByMonthAndYear(bulan, creditPage.getTahunComboBox().getSelectedItem().toString());
            viewDataOnTable(listKredit);
        }else if(creditPage.getLpjCheck().isSelected()){
            String bulan = null;
            if((creditPage.getBulanComboBox().getSelectedIndex()) <10){
              bulan = "0"+(creditPage.getBulanComboBox().getSelectedIndex());
            }else{
                bulan = ""+(creditPage.getBulanComboBox().getSelectedIndex());
            }
            listKreditLpj = lpjService.countCreditByMonthAndYear(bulan, creditPage.getTahunComboBox().getSelectedItem().toString());
            viewDataOnTable(listKreditLpj);
        }else{
            
        }
        
    }
}
