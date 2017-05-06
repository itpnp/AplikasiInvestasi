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
import aplikasiinvestasi.view.MainPageBskk;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Rizaldi Habibie
 */
public class MainPageBskkController {
    
    private MainPageBskk mainPage;
    private BskkService bskkService;
    private List<MasterBskk> listBskk;
    private AddBskkController addBskkController;
    private UpdateBskkController updateBskkController;
    
    public MainPageBskkController(){
        this.bskkService = new BskkServiceImpl();
        this.mainPage = new MainPageBskk();
        getAllData();
        viewDataOnTable();
        mainPage.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainPage.setVisible(true);
        addBskkController = new AddBskkController(this);
        updateBskkController = new UpdateBskkController(this);
        mainPage.getAddButton().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addNewData(e);
            }
        });
        mainPage.getExportButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openExportPage(e);
            }
        });
        mainPage.getSearchButton().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                searchData(e);
            }
        });
        mainPage.getBulanParam().setModel(new DefaultComboBoxModel(BulanEnum.namaBulan()));
        mainPage.getTahunParam().setModel(new DefaultComboBoxModel(BulanEnum.tahun()));
    }
    
    public BskkService getService(){
        return bskkService;
    }
    
    public MainPageBskk getParent(){
        return mainPage;
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
        model.addColumn("ACTION");
        
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
            obj[8] = "UPDATE";
            model.addRow(obj);
        }
        
       mainPage.getViewTable().setModel(model);
       mainPage.setTitle("Laporan BSKK");
       JTableHeader jheader = mainPage.getViewTable().getTableHeader();
       Dimension dim = jheader.getPreferredSize();
       dim.height = 35; 
       jheader.setPreferredSize(dim);
       jheader.setDefaultRenderer(new TableHeaderRenderer());
       Action detail = new AbstractAction(){
        @Override
        public void actionPerformed(ActionEvent e)
            {
                int modelRow = Integer.valueOf( e.getActionCommand() );
                openEditPage(listBskk.get(modelRow));
            }
        };
       
       ButtonColumns buttonColumns = new ButtonColumns(mainPage.getViewTable(), detail, 8);
       buttonColumns.setMnemonic(KeyEvent.VK_D);
       
       float[] columnSize = {8.0f, 6.0f, 5.0f, 5.0f, 6.0f, 48.0f, 6.0f,10.0f,6.0f};
       Table.resizeTable(mainPage.getViewTable(), columnSize);
       
    }
    
    public void addNewData(java.awt.event.ActionEvent e){
        addBskkController.addBskk().setVisible(true);
    }
    
    public void openEditPage(MasterBskk masterBskk){
        updateBskkController.setData(masterBskk);
        updateBskkController.updateBskk().setVisible(true);
    }
    public void openExportPage(java.awt.event.ActionEvent e){
        PrintOptionBskkController export = new PrintOptionBskkController(this);
        export.exportPage().setVisible(true);
    }
    
    public void searchData(java.awt.event.ActionEvent e){
        if(mainPage.getBulanParam().getSelectedIndex()!=0 && mainPage.getTahunParam().getSelectedIndex()!=0){
            listBskk = bskkService.getDataByMonthAndYear(""+mainPage.getBulanParam().getSelectedIndex(), mainPage.getTahunParam().getSelectedItem().toString());
        }else if(mainPage.getBulanParam().getSelectedIndex()==0 && mainPage.getTahunParam().getSelectedIndex()!=0){
            listBskk = bskkService.getDataByYear(mainPage.getTahunParam().getSelectedItem().toString());
        }else if(!mainPage.getNoBpkkParameter().getText().isEmpty() || !mainPage.getNoBpkkParameter().getText().equals("")){
            listBskk = bskkService.getDataByBpkk(mainPage.getNoBpkkParameter().getText());
        }
        viewDataOnTable();
    }
    
    public void openBskkPage(java.awt.event.ActionEvent e){
        
    }
    
}
