/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.model.MasterBskk;
import aplikasiinvestasi.service.BskkService;
import aplikasiinvestasi.service.impl.BskkServiceImpl;
import aplikasiinvestasi.utils.BulanEnum;
import aplikasiinvestasi.utils.ButtonColumns;
import aplikasiinvestasi.utils.FormatDate;
import aplikasiinvestasi.utils.FormatRupiah;
import aplikasiinvestasi.utils.Table;
import aplikasiinvestasi.utils.TableHeaderRenderer;
import aplikasiinvestasi.view.ViewBskk;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Rizaldi Habibie
 */
public class ViewBskkController {
    private ViewBskk viewBskk;
    private BskkService bskkService;
    private List<MasterBskk> listBskk;
    
    public ViewBskkController(){
        this.bskkService = new BskkServiceImpl();
        this.viewBskk = new ViewBskk();
        getAllData();
        viewDataOnTable();
        viewBskk.getSearchButton().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                searchData(e);
            }
        });
        viewBskk.getBulanParam().setModel(new DefaultComboBoxModel(BulanEnum.namaBulan()));
        viewBskk.getTahunParam().setModel(new DefaultComboBoxModel(BulanEnum.tahun()));
    }
    
    public void getAllData(){
        listBskk = bskkService.getAllData();
    }
    
    public void viewDataOnTable(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Invest");
        model.addColumn("<html><center>KODE<br>REKENING");
        model.addColumn("<html><center>ALKS<br>BY");
        model.addColumn("DEPT");
        model.addColumn("TGL");
        model.addColumn("KETERANGAN");
        model.addColumn("<html><center>No<br>BPKK");
        model.addColumn("<html><center>DEBET<br>(RP)");
        
        for(MasterBskk bskk : listBskk){
            Object[] obj = new Object[9];
            if(bskk.getMasterInvest()!=null){
                obj[0] = bskk.getMasterInvest().getKodeInvest();
            }else{
                obj[0] = "-";
            }
            obj[1]  = bskk.getKodeRekening();
            obj[2]  = bskk.getMasterDepartemen().getKodeDepartement();
            obj[3]  = bskk.getMasterDepartemen().getAlokasi();
            obj[4]  = FormatDate.convert(bskk.getTanggal());
            obj[5]  = bskk.getKeterangan();
            obj[6]  = bskk.getNoBskk();
            obj[7]  = FormatRupiah.convert(String.valueOf(bskk.getDebet()));
            model.addRow(obj);
        }
        
       viewBskk.getViewTable().setModel(model);
       viewBskk.setTitle("Laporan BSKK");
       JTableHeader jheader = viewBskk.getViewTable().getTableHeader();
       Dimension dim = jheader.getPreferredSize();
       dim.height = 35; 
       jheader.setPreferredSize(dim);
       jheader.setDefaultRenderer(new TableHeaderRenderer());
              
       float[] columnSize = {8.0f, 7.0f, 5.0f, 5.0f, 6.0f, 50.0f, 9.0f,10.0f,};
       Table.resizeTable(viewBskk.getViewTable(), columnSize);
       
    }
    public void searchData(java.awt.event.ActionEvent e){
        if(viewBskk.getBulanParam().getSelectedIndex()!=0 && viewBskk.getTahunParam().getSelectedIndex()!=0 && viewBskk.getKodeInvestField().getText().isEmpty()){
            listBskk = bskkService.getDataByMonthAndYear(""+viewBskk.getBulanParam().getSelectedIndex(), viewBskk.getTahunParam().getSelectedItem().toString());
        }else if(viewBskk.getBulanParam().getSelectedIndex()==0 && viewBskk.getTahunParam().getSelectedIndex()!=0 && viewBskk.getKodeInvestField().getText().isEmpty()){
            listBskk = bskkService.getDataByYear(viewBskk.getTahunParam().getSelectedItem().toString());
        }else if(viewBskk.getBulanParam().getSelectedIndex()!=0 && viewBskk.getTahunParam().getSelectedIndex()!=0 && !viewBskk.getKodeInvestField().getText().isEmpty()){
            listBskk = bskkService.getDataByMonthAndYearAndInvestNumber(""+viewBskk.getBulanParam().getSelectedIndex(), viewBskk.getTahunParam().getSelectedItem().toString(), viewBskk.getKodeInvestField().getText());
        }else if(viewBskk.getBulanParam().getSelectedIndex()==0 && viewBskk.getTahunParam().getSelectedIndex()==0 && !viewBskk.getKodeInvestField().getText().isEmpty()){
            listBskk = bskkService.getDataByInvestNumber(viewBskk.getKodeInvestField().getText());
        }
        viewDataOnTable();
    }
    public ViewBskk getPage(){
        return viewBskk;
    }
}
