/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.model.MasterDepartemen;
import aplikasiinvestasi.model.MasterInvest;
import aplikasiinvestasi.model.MasterLpb;
import aplikasiinvestasi.service.DepartemenService;
import aplikasiinvestasi.service.LpbService;
import aplikasiinvestasi.service.impl.DepartemenServiceImpl;
import aplikasiinvestasi.utils.FormatDate;
import aplikasiinvestasi.utils.FormatRupiah;
import aplikasiinvestasi.utils.Table;
import aplikasiinvestasi.utils.TableHeaderRenderer;
import aplikasiinvestasi.view.ExcelLpbLokal;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Rizaldi Habibie
 */
public class PreviewExcelLpb {
    private LpbService lpbService;
    private DepartemenService departemenService;
    private MainPageLpbController mainPage;
    private List<MasterLpb> listLpb;
    private DefaultTableModel defaultTableModel;
    private ExcelLpbLokal viewPage;
    private String sumberBarang;
    
    public PreviewExcelLpb(MainPageLpbController mainPage, LpbService lpbService){
        departemenService = new DepartemenServiceImpl();
        this.lpbService = lpbService;
        this.mainPage = mainPage;
        this.viewPage = new ExcelLpbLokal(this.mainPage.getMainPage(),true);
        this.viewPage.getSaveButton().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                save(e);
            }
        });
    }
    
    public void setData(List<MasterLpb> listLpb){
        this.listLpb = listLpb;
    }
    
    public void showData(){
        viewPage.getViewTable().removeAll();
        viewPage.getViewTable().validate();
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("<html><b>Tanggal");
        defaultTableModel.addColumn("<html><b>Supplier");
        defaultTableModel.addColumn("<html><center><b>Kode Rekening");
        defaultTableModel.addColumn("<html><center><b>Alokasi Biaya");
        defaultTableModel.addColumn("<html><center><b>Kode Dept");
        defaultTableModel.addColumn("<html><center><b>Kode Invest");
        defaultTableModel.addColumn("<html><center><b>No Intr");
        defaultTableModel.addColumn("<html><center><b>No Ekstr");
        defaultTableModel.addColumn("<html><b>Keterangan");
        defaultTableModel.addColumn("<html><b>Jumlah");
        defaultTableModel.addColumn("<html><b>Satuan");
        defaultTableModel.addColumn("<html><center><b>Harga Satuan");
        defaultTableModel.addColumn("<html><b>Debet");
        defaultTableModel.addColumn("<html><b>Jenis");
        
        for(MasterLpb lpb : listLpb){
            Object[] obj = new Object[14];
            obj[0] = FormatDate.convert(lpb.getTanggal());
            obj[1] = lpb.getSuplier();
            obj[2] = lpb.getKodeRekening();
            obj[3] = lpb.getAlokasiBiaya();
            obj[4] = lpb.getMasterDepartemen().getKodeDepartement();
            obj[6] = lpb.getNoIpbInternal();
            obj[7] = lpb.getNoIpbEksternal();
            obj[8] = lpb.getKeterangan();
            obj[9] = lpb.getJumlah();
            obj[10] = lpb.getSatuan();
            obj[11] = FormatRupiah.convert(String.valueOf(lpb.getHargaSatuan()));
            obj[12] = FormatRupiah.convert(String.valueOf(lpb.getDebet()));
            obj[13] = lpb.getStatus();
            defaultTableModel.addRow(obj);
        }
        viewPage.getViewTable().setModel(defaultTableModel);
        float[] columnSize = {0.3f, 0.3f, 0.3f,0.2f, 0.3f,0.3f, 0.2f, 0.2f, 1.3f,0.2f,0.2f,0.4f,0.4f,0.2f};
       Table.resizeTable(viewPage.getViewTable(), columnSize);
    }
    
    public ExcelLpbLokal getPage(){
        String[] values = {"LOKAL", "IMPORT"};
        int x = JOptionPane.showOptionDialog(null, "Pilih Sumber Barang",
                "PILIH",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, values, values[0]);
        sumberBarang = values[x];
        showData();
        this.viewPage.setTitle("Import Data");
        this.viewPage.setVisible(true);
        return viewPage;
    }
    
    public void save(java.awt.event.ActionEvent awt){
        List<MasterLpb> listLpb = new ArrayList<>();
        int rowCount = viewPage.getViewTable().getRowCount();
        DateFormat formatter = new SimpleDateFormat("dd MMM yyyy"); 
        boolean error = false;
        for(int i=0;i<rowCount;i++){
            try {
                MasterLpb lpb = new MasterLpb();
                lpb.setTanggal((Date)formatter.parse(viewPage.getViewTable().getValueAt(i, 0).toString()));
                lpb.setSuplier(viewPage.getViewTable().getValueAt(i, 1).toString());
                lpb.setKodeRekening(viewPage.getViewTable().getValueAt(i, 2).toString());
                lpb.setAlokasiBiaya(viewPage.getViewTable().getValueAt(i, 3).toString());
                
                MasterDepartemen departemen = null;
                departemen = departemenService.findByCode(viewPage.getViewTable().getValueAt(i, 4).toString());
                if(departemen != null){
                    lpb.setMasterDepartemen(departemen);
                }else{
                    error = true;
                    JOptionPane.showMessageDialog(viewPage, "Cannot Find Department Code !", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                }
                MasterInvest invest = new MasterInvest();
                if(viewPage.getViewTable().getValueAt(i, 5) != null){
                    invest.setKodeInvest(viewPage.getViewTable().getValueAt(i, 5).toString());
                    lpb.setMasterInvest(invest);
                }
                lpb.setNoIpbInternal(viewPage.getViewTable().getValueAt(i, 6).toString());
                lpb.setNoIpbEksternal(viewPage.getViewTable().getValueAt(i, 7).toString());
                lpb.setKeterangan(viewPage.getViewTable().getValueAt(i, 8).toString());
                lpb.setJumlah(Double.valueOf(viewPage.getViewTable().getValueAt(i, 9).toString()));
                lpb.setSatuan(viewPage.getViewTable().getValueAt(i, 10).toString());
                lpb.setHargaSatuan(Double.valueOf(FormatRupiah.convertFromRupiah(viewPage.getViewTable().getValueAt(i, 11).toString())));
                lpb.setDebet(Double.valueOf(FormatRupiah.convertFromRupiah(viewPage.getViewTable().getValueAt(i, 12).toString())));
                lpb.setStatus(viewPage.getViewTable().getValueAt(i, 13).toString());
                lpb.setSumberBarang(sumberBarang);
                lpb.setActiveStatus("ACTIVE");
                listLpb.add(lpb);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
        if(!error){
          if(listLpb.size()>0){
            if(lpbService.saveInBatch(listLpb)){
                mainPage.getAllData();
                mainPage.viewDataOnTable();
                viewPage.setVisible(false);
            }  
          }  
        }
        
    }
}
