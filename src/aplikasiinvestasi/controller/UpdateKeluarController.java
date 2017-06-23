/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.model.MasterKeluarBskk;
import aplikasiinvestasi.service.KeluarService;
import aplikasiinvestasi.utils.BulanEnum;
import aplikasiinvestasi.utils.FormatRupiah;
import aplikasiinvestasi.view.UpdateKeluar;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Rizaldi Habibie
 */
public class UpdateKeluarController {
    private UpdateKeluar updateKeluar;
    private KeluarService keluarService;
    private KeluarPageController keluarPage;
    private MasterKeluarBskk masterKeluar;
    
    public UpdateKeluarController(KeluarPageController keluarPage){
        this.keluarPage = keluarPage;
        this.updateKeluar = new UpdateKeluar(keluarPage.getMainPage(), true);
        this.keluarService = keluarPage.getKeluarService();
       
    }
    public UpdateKeluar getUpdatePage(){
         return updateKeluar;
    }
    public void setData(MasterKeluarBskk masterKeluar){
        this.masterKeluar = masterKeluar;
        updateKeluar.getKeteranganField().setText(masterKeluar.getKeterangan());
        updateKeluar.getBulanField().setSelectedItem(masterKeluar.getBulan());
        updateKeluar.getTahunField().setSelectedItem(masterKeluar.getTahun());
        updateKeluar.getNominalField().setText(FormatRupiah.convert(""+masterKeluar.getNominal()));
    }
    public void saveUpdate(java.awt.event.ActionEvent e){
        masterKeluar.setKeterangan(updateKeluar.getKeteranganField().getText());
        masterKeluar.setNominal(Long.parseLong(updateKeluar.getNominalField().getText()));
        masterKeluar.setBulan(updateKeluar.getBulanField().getSelectedItem().toString());
        masterKeluar.setTahun(updateKeluar.getTahunField().getSelectedItem().toString());
        if(keluarService.update(masterKeluar)){
            keluarPage.viewDataOnTable();
        }
    }
    public void jumlahField(java.awt.event.KeyEvent evt){
        formatRupiah(updateKeluar.getFormatRupiah(), updateKeluar.getNominalField());
    }
    public void formatRupiah(JLabel labelFormat, JTextField textFormat){
       labelFormat.setText(FormatRupiah.convert(textFormat.getText()));
    }
    public void initComponent(){
        updateKeluar.getBulanField().setModel(new DefaultComboBoxModel(BulanEnum.namaBulan()));
        updateKeluar.getTahunField().setModel(new DefaultComboBoxModel(BulanEnum.tahun()));
        updateKeluar.getSaveButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveUpdate(e);
            }
        });
        updateKeluar.getNominalField().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jumlahField(evt);
            }
        });
        updateKeluar.getNominalField().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                saveUpdate(e);
            }
        });
    }
}
