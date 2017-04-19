/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.model.MasterInvest;
import aplikasiinvestasi.service.InvestPageService;
import aplikasiinvestasi.service.impl.InvestPageServiceImpl;
import aplikasiinvestasi.utils.BulanEnum;
import aplikasiinvestasi.utils.ButtonColumns;
import aplikasiinvestasi.utils.FormatDate;
import aplikasiinvestasi.utils.FormatRupiah;
import aplikasiinvestasi.utils.Table;
import aplikasiinvestasi.utils.TableHeaderRenderer;
import aplikasiinvestasi.view.IjinInvestPage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Rizaldi Habibie
 */
public final class IjinInvestPageController {
    private MainPageController mainController;
    private IjinInvestPage investPage = new IjinInvestPage();
    private InvestPageService investService = new InvestPageServiceImpl();
    private DetailInvestViewController detailInvest;
    private List<MasterInvest> listMaster;
    private PrintOptionInvestController printController;
    
    public IjinInvestPageController(MainPageController mainController){
        this.mainController = mainController;
        investPage.getAddButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewInvest(e);
            }
        });
       investPage.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt) {
            float[] columnSize = {8.0f, 6.0f, 13.0f, 30.0f, 2.0f, 13.0f, 10.0f,10.0f,8.0f};
            Table.resizeTable(investPage.getViewTable(), columnSize);            
            }
        });
       
       investPage.getSearchButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search(e);
            }
        });
       investPage.getExportButton().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                exportButton(e);
            }
        });
       investPage.getMonthCombo().setModel(new DefaultComboBoxModel(BulanEnum.namaBulan()));
       investPage.getYearCombo().setModel(new DefaultComboBoxModel(BulanEnum.tahun()));
    }
    
    public void addNewInvest(java.awt.event.ActionEvent awt){
        mainController.addNewInvest(investPage);
    }
    
    public IjinInvestPage getIjinInvestPage(){
        return investPage;
    }
    public void getAllData(){
        listMaster = investService.getAllData();
        
        investPage.getViewTable().validate();
        investPage.repaint();
    }
    public void viewData(){
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nomor Proposal");
        model.addColumn("<html><center>Tanggal<br>Invest");
        model.addColumn("Nomor Ijin Invest");
        model.addColumn("Jenis Invest");
        model.addColumn("Jml");
        model.addColumn("Departemen");
        model.addColumn("Rencana Biaya");
        model.addColumn("Action");
        for(MasterInvest invest : listMaster){
            Object[] obj = new Object[8];
            obj[0] = invest.getKodeInvest();
            obj[1] = FormatDate.convert(invest.getTanggalIjinInvest());
            obj[2] = invest.getNomorIjin();
            obj[3] = invest.getJenisInvest();
            obj[4] = invest.getJumlah();
            obj[5] = invest.getDepartemenPemohon().getNamaDepartment();
            obj[6] = FormatRupiah.convert(String.valueOf(invest.getRencanaBiaya()));
            obj[7] = "Detail";
            model.addRow(obj);
        }
        investPage.getViewTable().setModel(model);
        JTableHeader jheader = investPage.getViewTable().getTableHeader();
        Dimension dim = jheader.getPreferredSize();
        dim.height = 35; 
        jheader.setPreferredSize(dim);
        jheader.setDefaultRenderer(new TableHeaderRenderer());
        Action detail = new AbstractAction(){
        @Override
        public void actionPerformed(ActionEvent e)
            {
                int modelRow = Integer.valueOf( e.getActionCommand() );
               openDetailInvest(modelRow);
            }
        };
        ButtonColumns buttonColumns = new ButtonColumns(investPage.getViewTable(), detail, 7);
        buttonColumns.setMnemonic(KeyEvent.VK_D);
        float[] columnSize = {8.0f, 6.0f, 13.0f, 30.0f, 2.0f, 13.0f, 10.0f,10.0f,8.0f};
        Table.resizeTable(investPage.getViewTable(), columnSize);
    }
    public void openDetailInvest(int index){
         detailInvest = new DetailInvestViewController(this);
         detailInvest.setData(listMaster.get(index));
         mainController.openDetailInvest(detailInvest);
    }
    public InvestPageService getService(){
        return investService;
    }
    
    public void search(java.awt.event.ActionEvent awt){
        if(investPage.getYearCombo().getSelectedIndex() == 0 && investPage.getMonthCombo().getSelectedIndex()==0){
            
        }else if(investPage.getYearCombo().getSelectedIndex() != 0 && investPage.getMonthCombo().getSelectedIndex()==0){
            listMaster = investService.findByYear(investPage.getYearCombo().getSelectedItem().toString());
        }else if(investPage.getYearCombo().getSelectedIndex() == 0 && investPage.getMonthCombo().getSelectedIndex()!=0){
            listMaster = investService.findByMonth(""+investPage.getMonthCombo().getSelectedIndex());
        }else if(investPage.getYearCombo().getSelectedIndex() != 0 && investPage.getMonthCombo().getSelectedIndex()!= 0){
            listMaster = investService.findByMonthAndYear(""+investPage.getMonthCombo().getSelectedIndex(), investPage.getYearCombo().getSelectedItem().toString());
        }
        viewData();
    }
    
    public MainPageController getParentController(){
        return mainController;
    }
    public void exportButton(java.awt.event.ActionEvent e){
        printController = new PrintOptionInvestController(this);
        printController.exportDialog().setVisible(true);
    }
}

