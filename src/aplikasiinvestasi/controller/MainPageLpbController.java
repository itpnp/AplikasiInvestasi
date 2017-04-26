/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.model.MasterLpb;
import aplikasiinvestasi.model.MasterLpj;
import aplikasiinvestasi.service.LpbService;
import aplikasiinvestasi.service.LpjService;
import aplikasiinvestasi.service.impl.LpbServiceImpl;
import aplikasiinvestasi.service.impl.LpjServiceImpl;
import aplikasiinvestasi.utils.BulanEnum;
import aplikasiinvestasi.utils.ButtonColumns;
import aplikasiinvestasi.utils.FormatDate;
import aplikasiinvestasi.utils.FormatRupiah;
import aplikasiinvestasi.utils.Table;
import aplikasiinvestasi.utils.TableHeaderRenderer;
import aplikasiinvestasi.view.MainPageLpb;
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
public class MainPageLpbController {
    
    private final MainPageLpb mainPage = new MainPageLpb();
    private AddNewLpbController addLpb;
    private AddNewLpbImportController addLpbImport;
    private AddLpjController addLpj;
    private CreditLpbPageController creditController;
    private LpbService lpbService = new LpbServiceImpl();
    private LpjService lpjService = new LpjServiceImpl();
    private PrintOptionController printOption;
    private UpdateLpbController updateController;
    private UpdateLpjController updateLpjController;
    private List<MasterLpb> listLpb;
    private List<MasterLpj> listLpj;
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public MainPageLpbController(){
        mainPage.setVisible(true);
        listLpb = lpbService.getAllData();
        listLpj = lpjService.getAllData();
        viewDataOnTable();
        DefaultComboBoxModel monthModel = new DefaultComboBoxModel(BulanEnum.namaBulan());
        mainPage.getBulanParam().setModel(monthModel);
        DefaultComboBoxModel yearModel = new DefaultComboBoxModel(BulanEnum.tahun());
        mainPage.getTahunParam().setModel(yearModel);
        mainPage.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainPage.getAddButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewLpbButton(e);
            }
        });
        mainPage.getAddLpbImportButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addImportLpbButton(e);
            }
        });
        mainPage.getViewLPJ().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showlistLpj(e);
            }
        });
        mainPage.getViewLpb().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showlistLpb(e);
            }
        });
        mainPage.getPrintButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printButtonAction(e);
            }
        });
        mainPage.getLpjButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addLpjButton(e);
            }
        });
        mainPage.getCreditButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                creditButtonAction(e);
            }
        });
        mainPage.getSearchButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchButton(e);
            }
        });
        addLpb = new AddNewLpbController(this, lpbService);
        addLpj = new AddLpjController(this, lpjService);
        addLpbImport = new AddNewLpbImportController(this, lpbService);

    }
    
    public MainPageLpb getMainPage(){
        return mainPage;
    }
    
    public void addNewLpbButton(java.awt.event.ActionEvent awt){
        addLpb.getLpb();
    }
    public void addLpjButton(java.awt.event.ActionEvent awt){
        addLpj.getLpj();
    }
    public void addImportLpbButton(java.awt.event.ActionEvent awt){
        addLpbImport.getLpb();
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
        model.addColumn("ACTION");
        
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
            obj[12] = "UPDATE";
            model.addRow(obj);
        }
        
        
       mainPage.getViewTable().setModel(model);
       mainPage.setTitle("Laporan LPB dan LPJ");
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
                openEditPage(listLpb.get(modelRow));
            }
        };
       ButtonColumns buttonColumns = new ButtonColumns(mainPage.getViewTable(), detail, 12);
       buttonColumns.setMnemonic(KeyEvent.VK_D);
       float[] columnSize = {7.0f, 4.0f, 3.0f, 6.0f, 6.0f, 23.0f, 9.0f,11.0f,2.0f,3.0f,10.0f,10.0f,6.0f};
       Table.resizeTable(mainPage.getViewTable(), columnSize);
    }
    public void viewLpjOnTable(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Invest");
        model.addColumn("<html><center>Kode<br>Rekening");
        model.addColumn("<html><center>Alokasi<br>Biaya");
        model.addColumn("<html><center>Kode<br>Departemen");
        model.addColumn("Tanggal");
        model.addColumn("Keterangan");
        model.addColumn("LPJ INTR");
        model.addColumn("LPJ EKSTR");
        model.addColumn("QTY");
        model.addColumn("Satuan");
        model.addColumn("Harga");
        model.addColumn("Debet");
        model.addColumn("ACTION");
        for(MasterLpj lpj : listLpj){
            Object[] obj = new Object[13];
            if(lpj.getMasterInvest()!=null){
                obj[0] = lpj.getMasterInvest().getKodeInvest();
            }else{
                obj[0] = "-";
            }
            obj[1]  = lpj.getKodeRekening();
            obj[2]  = lpj.getAlokasiBiaya();
            obj[3]  = lpj.getMasterDepartemen().getKodeDepartement();
            obj[4]  = FormatDate.convert(lpj.getTanggal());
            obj[5]  = lpj.getKeterangan();
            obj[6]  = lpj.getNoIpbInternal();
            obj[7]  = lpj.getNoIpbEksternal();
            obj[8]  = lpj.getJumlah();
            obj[9]  = lpj.getSatuan();
            obj[10] = FormatRupiah.convert(String.valueOf(lpj.getHargaSatuan()));
            obj[11] = FormatRupiah.convert(String.valueOf(lpj.getDebet()));
            obj[12] = "UPDATE";
            model.addRow(obj);
        }
        mainPage.getViewTable().setModel(model);
        mainPage.setTitle("Laporan LPB dan LPJ");
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
                openEditLpjPage(listLpj.get(modelRow));
            }
        };
       ButtonColumns buttonColumns = new ButtonColumns(mainPage.getViewTable(), detail, 12);
       buttonColumns.setMnemonic(KeyEvent.VK_D);
       float[] columnSize = {7.0f, 4.0f, 3.0f, 6.0f, 6.0f, 23.0f, 9.0f,11.0f,2.0f,3.0f,10.0f,10.0f,6.0f};
       Table.resizeTable(mainPage.getViewTable(), columnSize);
    }
    public LpbService getService(){
        return lpbService;
    }
    public LpjService getLpjService(){
        return lpjService;
    }
    public void showlistLpj(java.awt.event.ActionEvent awt){
        this.getAllData();
        this.viewLpjOnTable();
    }
    public void showlistLpb(java.awt.event.ActionEvent awt){
        this.getAllData();
        this.viewDataOnTable();
    }
    public void printButtonAction(java.awt.event.ActionEvent awt){
        printOption = new PrintOptionController(this);
        printOption.openExportPage().setVisible(true);
    }
    public void creditButtonAction(java.awt.event.ActionEvent e){
        creditController = new CreditLpbPageController(this);
        creditController.creditPage().setVisible(true);
        creditController.creditPage().setTitle("Credit Page");
    }
    public void openEditPage(MasterLpb masterLpb){
        updateController = new UpdateLpbController(this);
        updateController.setData(masterLpb);
        updateController.editPage().setVisible(true);
    }
    public void openEditLpjPage(MasterLpj masterLpj){
        updateLpjController = new UpdateLpjController(this);
        updateLpjController.setData(masterLpj);
        updateLpjController.editPage().setVisible(true);
    }
    public void searchButton(java.awt.event.ActionEvent e){
        if(mainPage.getBulanParam().getSelectedIndex() != 0 && mainPage.getTahunParam().getSelectedIndex() !=0){
           listLpb = lpbService.getAllDataByMonthAndYear(""+mainPage.getBulanParam().getSelectedIndex(), mainPage.getTahunParam().getSelectedItem().toString());
        }else if(mainPage.getBulanParam().getSelectedIndex() == 0 && mainPage.getTahunParam().getSelectedIndex() !=0){
            listLpb = lpbService.getAllDataByYear(""+mainPage.getTahunParam().getSelectedItem().toString());
        }
        viewDataOnTable();
    }
    public void getAllData(){
        listLpb = lpbService.getAllData();
        listLpj = lpjService.getAllData();
    }
}
