/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.model.MasterTerima;
import aplikasiinvestasi.service.BskkService;
import aplikasiinvestasi.service.TerimaService;
import aplikasiinvestasi.utils.BulanEnum;
import aplikasiinvestasi.view.PrintOptionBskk;
import java.awt.event.ActionEvent;
import java.util.List;
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
    private TerimaService terimaService;
    
    public PrintOptionBskkController(MainPageBskkController mainPage){
        this.mainPage = mainPage;
        this.bskkService = mainPage.getService();
        this.terimaService = mainPage.getTerimaService();
        this.print = new PrintOptionBskk(mainPage.getParent(), true);
    }
    
    public void export(java.awt.event.ActionEvent e){
        if(print.getBulanComboBox().getSelectedIndex()!=0 && print.getTahunComboBox().getSelectedIndex()!=0){
            List<MasterTerima> listTerima = terimaService.findByMonth(""+print.getBulanComboBox().getSelectedIndex(), print.getTahunComboBox().getSelectedItem().toString());
            bskkService.exportToExcel(""+print.getBulanComboBox().getSelectedIndex(), print.getTahunComboBox().getSelectedItem().toString(), listTerima);
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
