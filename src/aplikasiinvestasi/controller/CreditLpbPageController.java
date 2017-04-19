/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.dto.TotalKredit;
import aplikasiinvestasi.service.LpbService;
import aplikasiinvestasi.utils.BulanEnum;
import aplikasiinvestasi.utils.FormatRupiah;
import aplikasiinvestasi.view.CreditLpbPage;
import java.awt.event.ActionEvent;
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
    private List<TotalKredit> listKredit;
    
    public CreditLpbPageController(MainPageLpbController mainPage){
        this.mainPage = mainPage;
        this.creditPage = new CreditLpbPage(mainPage.getMainPage(),true);
        this.lpbService = mainPage.getService();
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
        String bulan = null;
        if((creditPage.getBulanComboBox().getSelectedIndex()+1) <10){
          bulan = "0"+(creditPage.getBulanComboBox().getSelectedIndex()+1);
        }else{
            bulan = ""+(creditPage.getBulanComboBox().getSelectedIndex()+1);
        }
        listKredit = lpbService.countCreditByMonthAndYear(bulan, creditPage.getTahunComboBox().getSelectedItem().toString());
        viewDataOnTable(listKredit);
    }
}
