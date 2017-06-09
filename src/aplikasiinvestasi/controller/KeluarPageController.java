/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.model.MasterKeluarBskk;
import aplikasiinvestasi.service.KeluarService;
import aplikasiinvestasi.service.impl.KeluarServiceImpl;
import aplikasiinvestasi.utils.BulanEnum;
import aplikasiinvestasi.utils.ButtonColumns;
import aplikasiinvestasi.utils.FormatRupiah;
import aplikasiinvestasi.utils.Table;
import aplikasiinvestasi.utils.TableHeaderRenderer;
import aplikasiinvestasi.view.KeluarBskkPage;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Rizaldi Habibie
 */
public class KeluarPageController {
    private KeluarBskkPage keluarPage;
    private KeluarService keluarService;
    private List<MasterKeluarBskk> listKeluarBskk;
    
    public KeluarPageController(){
        keluarPage = new KeluarBskkPage();
        keluarService = new KeluarServiceImpl();
        keluarPage.getSaveButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData(e);
            }
        });
        keluarPage.getFindButton().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                search(e);
            }
        });
        keluarPage.getNominalField().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jumlahField(evt);
            }
        });
        keluarPage.getBulanField().setModel(new DefaultComboBoxModel(BulanEnum.namaBulan()));
        keluarPage.getTahunField().setModel(new DefaultComboBoxModel(BulanEnum.tahun()));
        keluarPage.getBulanParameter().setModel(new DefaultComboBoxModel(BulanEnum.namaBulan()));
        keluarPage.getTahunParameter().setModel(new DefaultComboBoxModel(BulanEnum.tahun()));
    }
    public KeluarBskkPage openPage(){
        return keluarPage;
    }
    public void getAllData(){
        listKeluarBskk = new ArrayList<>();
        listKeluarBskk = keluarService.getAllData();
    }
    
    public void viewDataOnTable(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NO");
        model.addColumn("Periode");
        model.addColumn("Nominal");
        model.addColumn("Keterangan");
        model.addColumn("Action");
        
        int no = 0;
        for(MasterKeluarBskk keluar : listKeluarBskk){
            no++;
            Object[] obj = new Object[5];
            obj[0] = no;
            obj[1] = keluar.getBulan()+"/"+keluar.getTahun();
            obj[2] = FormatRupiah.convert(String.valueOf(keluar.getNominal()));
            obj[3] = keluar.getKeterangan();
            obj[4] = "UPDATE";
            model.addRow(obj);
        }
        keluarPage.getViewTable().setModel(model);
        JTableHeader jheader = keluarPage.getViewTable().getTableHeader();
        Dimension dim = jheader.getPreferredSize();
        dim.height = 35; 
        jheader.setPreferredSize(dim);
        jheader.setDefaultRenderer(new TableHeaderRenderer());
        Action detail = new AbstractAction(){
        @Override
        public void actionPerformed(ActionEvent e)
            {
                int modelRow = Integer.valueOf( e.getActionCommand());
//                openEditLpjPage(listTerima.get(modelRow));
            }
        };
       ButtonColumns buttonColumns = new ButtonColumns(keluarPage.getViewTable(), detail, 4);
       buttonColumns.setMnemonic(KeyEvent.VK_D);
       float[] columnSize = {5.0f, 20.0f, 40.0f, 28.0f,7.0f};
       Table.resizeTable(keluarPage.getViewTable(), columnSize);
    }
    
    public void saveData(java.awt.event.ActionEvent e){
        MasterKeluarBskk keluar = new MasterKeluarBskk();
        keluar.setBulan(keluarPage.getBulanField().getSelectedItem().toString());
        keluar.setTahun(keluarPage.getTahunField().getSelectedItem().toString());
        keluar.setKeterangan(keluarPage.getKeteranganField().getText());
        keluar.setNominal(Long.valueOf(keluarPage.getNominalField().getText()));
        if(keluarService.save(keluar)){
            this.empty();
            this.getAllData();
            this.viewDataOnTable();
        }
    }
    public void empty(){
        keluarPage.getKeteranganField().setText("");
        keluarPage.getBulanField().setSelectedIndex(0);
        keluarPage.getTahunField().setSelectedIndex(0);
        keluarPage.getNominalField().setText("");
    }
    
    public void search(java.awt.event.ActionEvent e){
        listKeluarBskk = new ArrayList<>();
        listKeluarBskk = keluarService.findByMonthAndYear(keluarPage.getBulanField().getSelectedItem().toString(), keluarPage.getTahunField().getSelectedItem().toString());
        viewDataOnTable();
    }
    public void jumlahField(java.awt.event.KeyEvent evt){
        formatRupiah(keluarPage.getFormatRupiah(), keluarPage.getNominalField());
    }
    public void formatRupiah(JLabel labelFormat, JTextField textFormat){
       labelFormat.setText(FormatRupiah.convert(textFormat.getText()));
    }
}
