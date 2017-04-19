/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.model.MasterInvest;
import aplikasiinvestasi.service.LpbService;
import aplikasiinvestasi.utils.BulanEnum;
import aplikasiinvestasi.view.PrintOption;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Rizaldi Habibie
 */
public class PrintOptionController {
    private PrintOption printOption;
    private LpbService lpbService;
    private String bulan;
    private MainPageLpbController mainPage;
    private boolean printAll = true;
    private MasterInvest masterInvest;
    private ChooseDataInvestController chooseData;
    
    public PrintOptionController(MainPageLpbController mainPage){
        this.lpbService = mainPage.getService();
        printOption = new PrintOption(mainPage.getMainPage(), true);
        this.mainPage = mainPage;
    }
    
    public void exportToExcel(java.awt.event.ActionEvent e){
        
        if(printAll){
            if(printOption.getTahunComboBox().getSelectedIndex()==0){
                System.out.println("Print All, Tahun == 0");
                lpbService.printToExcel(""+printOption.getBulanComboBox().getSelectedIndex(), "0", null, this.getParentController().getMainPage()); 
            }else{
                System.out.println("Print All, Tahun > 0 ");
                lpbService.printToExcel(""+printOption.getBulanComboBox().getSelectedIndex(), printOption.getTahunComboBox().getSelectedItem().toString(), null, this.getParentController().getMainPage()); 
            }
        }else{
            if(printOption.getTahunComboBox().getSelectedIndex()==0){
                System.out.println("Print Invest, Tahun == 0");
                lpbService.printToExcel(String.valueOf(printOption.getBulanComboBox().getSelectedIndex()), "0", masterInvest.getKodeInvest(), this.getParentController().getMainPage()); 
            }else{
                System.out.println("Print Invest, Tahun > 0");
                lpbService.printToExcel(""+printOption.getBulanComboBox().getSelectedIndex(), printOption.getTahunComboBox().getSelectedItem().toString(), masterInvest.getKodeInvest(), this.getParentController().getMainPage()); 
            }
        }
        
        

    }
    public void printAllButton(java.awt.event.ActionEvent e){
        if(printOption.getAllLpbRadio().isSelected()){
            printAll = true;
            printOption.getKodeInvestField().setEnabled(false);
            printOption.getChooseButton().setEnabled(false);
        }
    }
    public void printInvestOnly(java.awt.event.ActionEvent e){
        if(printOption.getInvestRadio().isSelected()){
            printAll = false;
            printOption.getKodeInvestField().setEnabled(true);
            printOption.getChooseButton().setEnabled(true);
        }
    }
    public PrintOption openExportPage(){
         printOption.getAllLpbRadio().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printAllButton(e);
            }
        });
        printOption.getInvestRadio().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                printInvestOnly(e);
            }
        });
        printOption.getExportButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportToExcel(e);
            }
        });
        printOption.getChooseButton().addActionListener(new java.awt.event.ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 selectDataInvest(e);
             }
         });
        printOption.getBulanComboBox().setModel(new DefaultComboBoxModel(BulanEnum.namaBulan()));
        printOption.getTahunComboBox().setModel(new DefaultComboBoxModel(BulanEnum.tahun()));
        printOption.getAllLpbRadio().setSelected(true);
        printOption.getKodeInvestField().setEnabled(false);
        printOption.getChooseButton().setEnabled(false);
        return printOption;
    }
    
    public MainPageLpbController getParentController(){
        return mainPage;
    }
    
    public LpbService getService(){
        return lpbService;
    }
    
    public void setMasterInvest(MasterInvest masterInvest){
        this.masterInvest = masterInvest;
        printOption.getKodeInvestField().setText(masterInvest.getNomorIjin());
    }
    
     public void selectDataInvest(java.awt.event.ActionEvent e){
        chooseData = new ChooseDataInvestController(this);
        chooseData.chooseInvest().setVisible(true);
    }
}
