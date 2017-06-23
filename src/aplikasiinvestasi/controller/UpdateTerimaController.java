/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.model.MasterTerima;
import aplikasiinvestasi.service.TerimaService;
import aplikasiinvestasi.utils.FormatRupiah;
import aplikasiinvestasi.view.UpdateTerima;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Rizaldi Habibie
 */
public class UpdateTerimaController {
    private UpdateTerima updateTerima;
    private TerimaService terimaService;
    private TerimaPageController terimaPage;
    private MasterTerima masterTerima;
    
    public UpdateTerimaController(TerimaPageController terimaPage){
        this.terimaPage = terimaPage;
        updateTerima = new UpdateTerima(terimaPage.getMainPage(), true);
        this.terimaService = terimaPage.getTerimaService();
       
    }
    public UpdateTerima getUpdatePage(){
         return updateTerima;
    }
    public void setData(MasterTerima terimaBskk){
        this.masterTerima = terimaBskk;
        updateTerima.getJenisField().setText(terimaBskk.getJenis());
        updateTerima.getjXDatePicker1().setDate(terimaBskk.getTanggal());
        updateTerima.getJumlahField().setText(""+terimaBskk.getJumlah());
        updateTerima.getLabelRupiah().setText(FormatRupiah.convert(""+terimaBskk.getJumlah()));
    }
    public void saveUpdate(java.awt.event.ActionEvent e){
        masterTerima.setJenis(updateTerima.getJenisField().getText());
        masterTerima.setJumlah(Long.parseLong(updateTerima.getJumlahField().getText()));
        masterTerima.setTanggal(updateTerima.getjXDatePicker1().getDate());
        if(terimaService.update(masterTerima)){
            terimaPage.viewData();
        }
    }
    public void jumlahField(java.awt.event.KeyEvent evt){
        formatRupiah(updateTerima.getLabelRupiah(), updateTerima.getJumlahField());
    }
    public void formatRupiah(JLabel labelFormat, JTextField textFormat){
       labelFormat.setText(FormatRupiah.convert(textFormat.getText()));
    }
    public void initComponent(){
        updateTerima.getjXDatePicker1().setFormats("dd MMMM yyyy");
        updateTerima.getSaveButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveUpdate(e);
            }
        });
        updateTerima.getJumlahField().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jumlahField(evt);
            }
        });
        updateTerima.getJumlahField().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                saveUpdate(e);
            }
        });
    }
}
