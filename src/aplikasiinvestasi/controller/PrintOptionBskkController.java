/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.service.BskkService;
import aplikasiinvestasi.utils.BulanEnum;
import aplikasiinvestasi.view.PrintOptionBskk;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Rizaldi Habibie
 */
public class PrintOptionBskkController {
    private PrintOptionBskk print;
    private MainPageBskkController mainPage;
    private BskkService bskkService;
    
    public PrintOptionBskkController(MainPageBskkController mainPage){
        this.mainPage = mainPage;
        this.bskkService = mainPage.getService();
        this.print = new PrintOptionBskk(mainPage.getParent(), true);
    }
    
    public void export(java.awt.event.ActionEvent e){
        if(print.getBulanComboBox().getSelectedIndex()!=0 && print.getTahunComboBox().getSelectedIndex()!=0){
            bskkService.exportToExcel(""+print.getBulanComboBox().getSelectedIndex(), print.getTahunComboBox().getSelectedItem().toString());
        }else{
            JOptionPane.showMessageDialog(mainPage.getParent(), "Mohon mengisi bulan dan tahun");
        }
    }
    
    public PrintOptionBskk exportPage(){
        print.getExportButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                export(e);
            }
        });
        print.getBulanComboBox().setModel(new DefaultComboBoxModel(BulanEnum.namaBulan()));
        print.getTahunComboBox().setModel(new DefaultComboBoxModel(BulanEnum.tahun()));
        return print;
    }
}
