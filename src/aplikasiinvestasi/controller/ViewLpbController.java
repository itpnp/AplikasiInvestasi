/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.model.MasterLpb;
import aplikasiinvestasi.service.LpbService;
import aplikasiinvestasi.service.impl.LpbServiceImpl;
import aplikasiinvestasi.utils.BulanEnum;
import aplikasiinvestasi.utils.FormatDate;
import aplikasiinvestasi.utils.FormatRupiah;
import aplikasiinvestasi.utils.Table;
import aplikasiinvestasi.utils.TableHeaderRenderer;
import aplikasiinvestasi.view.ViewLpb;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Rizaldi Habibie
 */
public class ViewLpbController {
    
    private ViewLpb viewLpb;
    private List<MasterLpb> listLpb;
    private LpbService lpbService;
    
    public ViewLpbController(){
        viewLpb = new ViewLpb();  
        lpbService = new LpbServiceImpl();
         viewLpb.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt) {
                float[] columnSize = {8.0f, 5.0f, 4.0f, 6.0f, 6.0f, 25.0f, 10.0f,11.0f,2.0f,3.0f,10.0f,10.0f};
                Table.resizeTable(viewLpb.getViewTable(), columnSize); 
            }
        });
        viewLpb.getSearchButton().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                searchButton(e);
            }
        });
        
        viewLpb.getKodeInvestField().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchButton(e);
            }
        });
    }
    
    public ViewLpb getLpb(){
        getAllData();
        viewDataOnTable();
        viewLpb.getBulanParam().setModel(new DefaultComboBoxModel(BulanEnum.namaBulan()));
        viewLpb.getTahunParam().setModel(new DefaultComboBoxModel(BulanEnum.tahun()));
        return viewLpb;
    }
    public void getAllData(){
        listLpb = lpbService.getAllData();
    }
    public void viewDataOnTable(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Invest");
        model.addColumn("<html><center>Kode<br>Rekening");
        model.addColumn("<html><center>Alokasi<br>Biaya");
        model.addColumn("<html><center>Kode<br>Departemen");
        model.addColumn("Tanggal");
        model.addColumn("Keterangan");
        model.addColumn("LPB INTR");
        model.addColumn("LPB EKSTR");
        model.addColumn("QTY");
        model.addColumn("Satuan");
        model.addColumn("Harga");
        model.addColumn("Debet");
        
        for(MasterLpb lpb : listLpb){
            Object[] obj = new Object[13];
            if(lpb.getMasterInvest()!=null){
                obj[0] = lpb.getMasterInvest().getKodeInvest();
            }else{
                obj[0] = "-";
            }
            obj[1]  = lpb.getKodeRekening();
            obj[2]  = lpb.getAlokasiBiaya();
            obj[3]  = lpb.getMasterDepartemen().getKodeDepartement();
            obj[4]  = FormatDate.convert(lpb.getTanggal());
            obj[5]  = lpb.getKeterangan();
            obj[6]  = lpb.getNoIpbInternal();
            obj[7]  = lpb.getNoIpbEksternal();
            obj[8]  = lpb.getJumlah();
            obj[9]  = lpb.getSatuan();
            obj[10] = FormatRupiah.convert(String.valueOf(lpb.getHargaSatuan()));
            obj[11] = FormatRupiah.convert(String.valueOf(lpb.getDebet()));
            model.addRow(obj);
        }
        
       viewLpb.getViewTable().setModel(model);
       viewLpb.setTitle("LPB");
       JTableHeader jheader = viewLpb.getViewTable().getTableHeader();
       Dimension dim = jheader.getPreferredSize();
       dim.height = 35; 
       jheader.setPreferredSize(dim);
       jheader.setDefaultRenderer(new TableHeaderRenderer());
       float[] columnSize = {8.0f, 5.0f, 4.0f, 6.0f, 6.0f, 25.0f, 10.0f,11.0f,2.0f,3.0f,10.0f,10.0f};
       Table.resizeTable(viewLpb.getViewTable(), columnSize); 
    }
    
    public void searchButton(java.awt.event.ActionEvent e){
        if(viewLpb.getBulanParam().getSelectedIndex() != 0 && viewLpb.getTahunParam().getSelectedIndex() !=0 
           && viewLpb.getKodeInvestField().getText().isEmpty()){
            
           listLpb = lpbService.getAllDataByMonthAndYear(""+viewLpb.getBulanParam().getSelectedIndex(), viewLpb.getTahunParam().getSelectedItem().toString());
           
        }else if(viewLpb.getBulanParam().getSelectedIndex() == 0 && viewLpb.getTahunParam().getSelectedIndex() !=0 &&
                viewLpb.getKodeInvestField().getText().isEmpty()){
            
            listLpb = lpbService.getAllDataByYear(""+viewLpb.getTahunParam().getSelectedItem().toString());
            
        }else if(viewLpb.getBulanParam().getSelectedIndex() != 0 && viewLpb.getTahunParam().getSelectedIndex() != 0
                && !viewLpb.getKodeInvestField().getText().isEmpty()){
            
           listLpb = lpbService.getAllDataByInvestNumberAndYearAndMonth(viewLpb.getKodeInvestField().getText(),viewLpb.getTahunParam().getSelectedItem().toString(),""+viewLpb.getBulanParam().getSelectedIndex());
        }else if(viewLpb.getBulanParam().getSelectedIndex() == 0 && viewLpb.getTahunParam().getSelectedIndex() != 0
                && !viewLpb.getKodeInvestField().getText().isEmpty()){
            
            listLpb = lpbService.getAllDataByInvestNumberAndYear(viewLpb.getKodeInvestField().getText(),viewLpb.getTahunParam().getSelectedItem().toString());
            
        }else if(viewLpb.getBulanParam().getSelectedIndex() == 0 && viewLpb.getTahunParam().getSelectedIndex() == 0
                && !viewLpb.getKodeInvestField().getText().isEmpty()){
            
            listLpb = lpbService.getAllDataByInvestNumber(viewLpb.getKodeInvestField().getText());
            
        }else if(viewLpb.getBulanParam().getSelectedIndex() != 0 && viewLpb.getTahunParam().getSelectedIndex() == 0
                && !viewLpb.getKodeInvestField().getText().isEmpty()){
                JOptionPane.showMessageDialog(viewLpb, "Mohon Pilih Tahun ","Warning",JOptionPane.ERROR_MESSAGE);
        }
        viewDataOnTable();
    }
}
