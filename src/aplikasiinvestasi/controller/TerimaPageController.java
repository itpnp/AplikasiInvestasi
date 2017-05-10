/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.model.MasterTerima;
import aplikasiinvestasi.service.TerimaService;
import aplikasiinvestasi.service.impl.TerimaServiceImpl;
import aplikasiinvestasi.utils.ButtonColumns;
import aplikasiinvestasi.utils.FormatDate;
import aplikasiinvestasi.utils.FormatRupiah;
import aplikasiinvestasi.utils.Table;
import aplikasiinvestasi.utils.TableHeaderRenderer;
import aplikasiinvestasi.view.TerimaBskkPage;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Rizaldi Habibie
 */
public class TerimaPageController {
    private TerimaBskkPage terimaPage;
    private TerimaService terimaService = new TerimaServiceImpl();
    private List<MasterTerima> listTerima;
   
    
    public TerimaPageController(){
        terimaPage = new TerimaBskkPage();
        terimaPage.getSaveButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save(e);
            }
        });
        terimaPage.getJumlahField().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jumlahField(evt);
            }
        });
        terimaPage.getJumlahField().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                save(e);
            }
        });
        terimaPage.getFindButton().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                search(e);
            }
        });
    }
    public TerimaBskkPage getPage(){
        return terimaPage;
    }
    public void getAllData(){
        listTerima = terimaService.getAllData();
    }
    public void viewData(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Jenis");
        model.addColumn("Tanggal");
        model.addColumn("Action");
        for(MasterTerima terima : listTerima){
            Object[] obj = new Object [3];
            obj[0] = terima.getJenis();
            obj[1] = FormatDate.convert(terima.getTanggal());
            obj[2] = "UPDATE";
            model.addRow(obj);
        }
        terimaPage.getViewTable().setModel(model);
        JTableHeader jheader = terimaPage.getViewTable().getTableHeader();
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
       ButtonColumns buttonColumns = new ButtonColumns(terimaPage.getViewTable(), detail, 2);
       buttonColumns.setMnemonic(KeyEvent.VK_D);
       float[] columnSize = {30.0f, 30.0f, 30.0f, 10.0f};
       Table.resizeTable(terimaPage.getViewTable(), columnSize);
    }
    private void empty(){
        terimaPage.getJenisField().setText("");
        terimaPage.getJumlahField().setText("");
        terimaPage.getLabelRupiah().setText("Rp. - ,00");
    }
    public void jumlahField(java.awt.event.KeyEvent evt){
        formatRupiah(terimaPage.getLabelRupiah(), terimaPage.getJumlahField());
    }
    public void formatRupiah(JLabel labelFormat, JTextField textFormat){
       labelFormat.setText(FormatRupiah.convert(textFormat.getText()));
    }
    public void save(java.awt.event.ActionEvent e){
        MasterTerima terima = new MasterTerima();
        if(!terimaPage.getJenisField().getText().isEmpty()){
            terima.setJenis(terimaPage.getJenisField().getText());
            terima.setJumlah(Long.valueOf(terimaPage.getJumlahField().getText()));
            terima.setTanggal(terimaPage.getTanggalField().getDate());
            if(terimaService.save(terima)){
                empty();
                listTerima = terimaService.getAllData();
                viewData();
            }
        }
    }
    public void search(java.awt.event.ActionEvent e){
        if(terimaPage.getTahunParam().getSelectedIndex()>0){
            if(terimaPage.getBulanParam().getSelectedIndex()>0){
                listTerima = terimaService.findByMonth(""+terimaPage.getBulanParam().getSelectedIndex(), terimaPage.getTahunParam().getSelectedItem().toString());
                viewData();
            }else{
                listTerima = terimaService.findByYear(terimaPage.getTahunParam().getSelectedItem().toString());
                viewData();

            }
        }
    }
}
