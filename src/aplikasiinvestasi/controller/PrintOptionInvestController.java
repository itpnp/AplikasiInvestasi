/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.service.InvestPageService;
import aplikasiinvestasi.utils.BulanEnum;
import aplikasiinvestasi.view.PrintOptionInvest;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Rizaldi Habibie
 */
public class PrintOptionInvestController {
    private PrintOptionInvest printOption;
    private IjinInvestPageController ijinInvestPage;
    private InvestPageService investService;
    
    public PrintOptionInvestController(IjinInvestPageController ijinInvestPage){
        this.ijinInvestPage = ijinInvestPage;
        printOption = new PrintOptionInvest(this.ijinInvestPage.getParentController().getParent(), true);
        investService = ijinInvestPage.getService();
        printOption.getExportButton().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                printButton(e);
            }
        });
        printOption.getBulanComboBox().setModel(new DefaultComboBoxModel(BulanEnum.namaBulan()));
        printOption.getTahunComboBox().setModel(new DefaultComboBoxModel(BulanEnum.tahun()));
    }
    
    public void printButton(java.awt.event.ActionEvent e){
        if(printOption.getBulanComboBox().getSelectedIndex() == 0){
            if(printOption.getTahunComboBox().getSelectedIndex()!=0){
                investService.exportAllToExcel(null, printOption.getTahunComboBox().getSelectedItem().toString());
            }
        }else{
            if(printOption.getTahunComboBox().getSelectedIndex()==0){
                investService.exportAllToExcel(""+printOption.getBulanComboBox().getSelectedIndex(), null);
            }else{
                investService.exportAllToExcel(""+printOption.getBulanComboBox().getSelectedIndex(), printOption.getTahunComboBox().getSelectedItem().toString());
            }
        }
    }
    public PrintOptionInvest exportDialog(){
        return printOption;
    }
}
