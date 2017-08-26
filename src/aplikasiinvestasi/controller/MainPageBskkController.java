/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.model.MasterBskk;
import aplikasiinvestasi.model.MasterCredential;
import aplikasiinvestasi.service.BskkService;
import aplikasiinvestasi.service.TerimaService;
import aplikasiinvestasi.service.impl.BskkServiceImpl;
import aplikasiinvestasi.service.impl.TerimaServiceImpl;
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
    private TerimaPageController terimaPage;
    private SaldoAkhirController saldoAkhirController;
    private TerimaService terimaService;
    private KeluarPageController keluarPageController;
    private MasterCredential userIdentity;
    private ChangeCredentialController changeCredential;
    
    public MainPageBskkController(MasterCredential user){
        this.bskkService = new BskkServiceImpl();
        this.terimaService = new TerimaServiceImpl();
        this.mainPage = new MainPageBskk();
        this.userIdentity = user;
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
        mainPage.getAllButton().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                getAllData();
                viewDataOnTable();
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
        
        mainPage.getCredentialButton().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                openCredentialPage(e);
            }
        });
        mainPage.getTerimaButton().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                openTerimaPage(e);
            }
        });
        mainPage.getHomeButton().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                openHomePage(e);
            }
        });
        mainPage.getSaldoAkhirButton().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                openSaldoPage(e);
            }
        });
        mainPage.getKeluarPageButton().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                openKeluarPage(e);
            }
        });
        mainPage.getBulanParam().setModel(new DefaultComboBoxModel(BulanEnum.namaBulan()));
        mainPage.getTahunParam().setModel(new DefaultComboBoxModel(BulanEnum.tahun()));
        terimaPage = new TerimaPageController();
        terimaPage.setMainPage(this.mainPage);
        keluarPageController = new KeluarPageController();
        keluarPageController.setMainPage(this.mainPage);
        saldoAkhirController = new SaldoAkhirController();
        changeCredential = new ChangeCredentialController(userIdentity,this);
    }
    
    public BskkService getService(){
        return bskkService;
    }
    public TerimaService getTerimaService(){
        return terimaService;
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
        if(mainPage.getBulanParam().getSelectedIndex()!=0 && mainPage.getTahunParam().getSelectedIndex()!=0 && mainPage.getKodeRekeningParam().getText().equals("") && mainPage.getNoBpkkParameter().getText().isEmpty() ){
            listBskk = bskkService.getDataByMonthAndYear(""+mainPage.getBulanParam().getSelectedIndex(), mainPage.getTahunParam().getSelectedItem().toString());
        }else if(mainPage.getBulanParam().getSelectedIndex()==0 && mainPage.getTahunParam().getSelectedIndex()!=0 && mainPage.getKodeRekeningParam().getText().equals("") && mainPage.getNoBpkkParameter().getText().isEmpty() ){
            listBskk = bskkService.getDataByYear(mainPage.getTahunParam().getSelectedItem().toString());
        }else if(!mainPage.getNoBpkkParameter().getText().isEmpty() || !mainPage.getNoBpkkParameter().getText().equals("") && mainPage.getKodeRekeningParam().getText().equals("") && mainPage.getNoBpkkParameter().getText().isEmpty() ){
            listBskk = bskkService.getDataByBpkk(mainPage.getNoBpkkParameter().getText());
       //ini buat kode rekening
        }else if(mainPage.getBulanParam().getSelectedIndex()!=0 && mainPage.getTahunParam().getSelectedIndex()!=0 && !mainPage.getKodeRekeningParam().getText().equals("") && mainPage.getNoBpkkParameter().getText().isEmpty() ){
            listBskk = bskkService.getDataByMonthAndYearAndKodeRekening(""+mainPage.getBulanParam().getSelectedIndex(), mainPage.getTahunParam().getSelectedItem().toString(),mainPage.getKodeRekeningParam().getText());
        }else if(mainPage.getBulanParam().getSelectedIndex()==0 && mainPage.getTahunParam().getSelectedIndex()!=0 && !mainPage.getKodeRekeningParam().getText().equals("") && mainPage.getNoBpkkParameter().getText().isEmpty() ){
            listBskk = bskkService.getDataByYearAndKodeRekening(mainPage.getTahunParam().getSelectedItem().toString(),mainPage.getKodeRekeningParam().getText());
        }else if(!mainPage.getNoBpkkParameter().getText().isEmpty() || !mainPage.getNoBpkkParameter().getText().equals("")){
            if(mainPage.getBulanParam().getSelectedIndex()!=0 && mainPage.getTahunParam().getSelectedIndex()!=0 && mainPage.getKodeRekeningParam().getText().equals("")){
                listBskk = bskkService.getDataByMonthAndYearAndBpkk(""+mainPage.getBulanParam().getSelectedIndex(), mainPage.getTahunParam().getSelectedItem().toString(),mainPage.getNoBpkkParameter().getText());
            }else if(mainPage.getBulanParam().getSelectedIndex()==0 && mainPage.getTahunParam().getSelectedIndex()==0 && mainPage.getKodeRekeningParam().getText().equals("") ){
                listBskk = bskkService.getDataByBpkk(mainPage.getNoBpkkParameter().getText());
            }else if(mainPage.getBulanParam().getSelectedIndex()==0 && mainPage.getTahunParam().getSelectedIndex()==0 && !mainPage.getKodeRekeningParam().getText().equals("")){
                listBskk = bskkService.getDataByBpkkAndKodeRekening(mainPage.getNoBpkkParameter().getText(),mainPage.getKodeRekeningParam().getText());
            }else if(mainPage.getBulanParam().getSelectedIndex()!=0 && mainPage.getTahunParam().getSelectedIndex()!=0 && !mainPage.getKodeRekeningParam().getText().equals("")){
                listBskk = bskkService.getDataByAllParameter(""+mainPage.getBulanParam().getSelectedIndex(), mainPage.getTahunParam().getSelectedItem().toString(),mainPage.getNoBpkkParameter().getText(),mainPage.getKodeRekeningParam().getText());
            }
        }else if(mainPage.getBulanParam().getSelectedIndex()==0 && mainPage.getTahunParam().getSelectedIndex()==0 && !mainPage.getKodeRekeningParam().getText().equals("") && mainPage.getNoBpkkParameter().getText().isEmpty() ){
            System.out.println("Here");
            System.out.println(mainPage.getKodeRekeningParam().getText());
            listBskk = bskkService.getDataByKodeRekening(mainPage.getKodeRekeningParam().getText());
        }
        viewDataOnTable();
    }
    public void openTerimaPage(java.awt.event.ActionEvent e){
        mainPage.getjPanel2().setVisible(false);
        saldoAkhirController.getPage().setVisible(false);
        keluarPageController.openPage().setVisible(false);
        mainPage.getContentPane().remove(mainPage.getjPanel2());
        mainPage.getContentPane().add(terimaPage.getPage(),java.awt.BorderLayout.CENTER);
        terimaPage.getPage().setVisible(true);
        mainPage.getContentPane().validate();
        terimaPage.getAllData();
        terimaPage.viewData();
    }
    
    public void openHomePage(java.awt.event.ActionEvent e){
         terimaPage.getPage().setVisible(false);
         saldoAkhirController.getPage().setVisible(false);
         keluarPageController.openPage().setVisible(false);
         mainPage.getContentPane().remove(terimaPage.getPage());
         mainPage.getContentPane().add(mainPage.getjPanel2(),java.awt.BorderLayout.CENTER);
         mainPage.getjPanel2().setVisible(true);
         mainPage.getContentPane().validate();       
    }
    public void openSaldoPage(java.awt.event.ActionEvent e){
        terimaPage.getPage().setVisible(false);
        mainPage.getjPanel2().setVisible(false);
         keluarPageController.openPage().setVisible(false);
         mainPage.getContentPane().remove(saldoAkhirController.getPage());
         mainPage.getContentPane().add(saldoAkhirController.getPage(),java.awt.BorderLayout.CENTER);
         saldoAkhirController.getPage().setVisible(true);
         mainPage.getContentPane().validate();
         saldoAkhirController.getAllData();
         saldoAkhirController.viewData();
    }
    
    public void openCredentialPage(java.awt.event.ActionEvent e){
        changeCredential.openPage().setVisible(true);
    }
    
    public void openKeluarPage(java.awt.event.ActionEvent e){
        mainPage.getjPanel2().setVisible(false);
        saldoAkhirController.getPage().setVisible(false);
        terimaPage.getPage().setVisible(false);
        mainPage.getContentPane().remove(mainPage.getjPanel2());
        mainPage.getContentPane().add(keluarPageController.openPage(),java.awt.BorderLayout.CENTER);
        keluarPageController.openPage().setVisible(true);
        mainPage.getContentPane().validate();
        keluarPageController.getAllData();
        keluarPageController.viewDataOnTable();
    }
}
