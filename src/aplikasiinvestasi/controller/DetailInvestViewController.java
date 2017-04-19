/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.model.MasterBskk;
import aplikasiinvestasi.model.MasterDepartemen;
import aplikasiinvestasi.model.MasterInvest;
import aplikasiinvestasi.model.MasterLpb;
import aplikasiinvestasi.service.InvestPageService;
import aplikasiinvestasi.utils.FormatRupiah;
import aplikasiinvestasi.utils.Table;
import aplikasiinvestasi.utils.TableHeaderRenderer;
import aplikasiinvestasi.view.DetailInvestView;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Rizaldi Habibie
 */
public class DetailInvestViewController {
    
    private DetailInvestView detailInvest;
    private InvestPageService investService;
    private List<MasterDepartemen> listDepartemen, listPenanggungJawab;
    private MasterInvest invest;
    private List<MasterLpb> listLpb;
    private List<MasterBskk> listBskk;
    
    public DetailInvestViewController(IjinInvestPageController investPage){
       this.investService = investPage.getService();
       detailInvest = new DetailInvestView();
       detailInvest.getEditButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editButton(e);
            }
        });
       detailInvest.getExportButton().addActionListener(new java.awt.event.ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               export(e);
           }
       });
        detailInvest.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt) {
             float[] columnSize = {8.0f, 6.0f, 10.0f, 56.0f, 4.0f, 4.0f, 12.0f};
             Table.resizeTable(detailInvest.getViewTable(), columnSize);             
            }
        });
    }
    
    public void setData(MasterInvest invest){
        
      
        this.invest = invest;
        detailInvest.getNoSuratIjinField().setText(this.invest.getNomorIjin());
        detailInvest.getTanggalField().setFormats("dd MMMM yyyy");
        detailInvest.getTanggalField().setDate(this.invest.getTanggalIjinInvest());
        detailInvest.getJumlahField().setText(""+this.invest.getJumlah());
        detailInvest.getJenisField().setText(this.invest.getJenisInvest());
        detailInvest.getRencanaField().setText(FormatRupiah.convert(String.valueOf(this.invest.getRencanaBiaya())));
        
        if(this.invest.getDepartemenPemohon().getUnit().equals("Holo I")){
            detailInvest.getPemohonField().setModel(new DefaultComboBoxModel(this.comboboxModel("Holo I").toArray()));
            detailInvest.getPemohonField().setSelectedItem(this.invest.getDepartemenPemohon().getNamaDepartment());
            detailInvest.getUnit1().setSelected(true);
        }else{
            detailInvest.getPemohonField().setModel(new DefaultComboBoxModel(this.comboboxModel("Holo II").toArray()));
            detailInvest.getPemohonField().setSelectedItem(this.invest.getDepartemenPemohon().getNamaDepartment());
            detailInvest.getUnit2().setSelected(true);
        }
        if(this.invest.getDepartemenPengajuan().getUnit().equals("Holo I")){
            detailInvest.getPenanggungJawabField().setModel(new DefaultComboBoxModel(this.penanggungJawabModel("Holo I").toArray()));
            detailInvest.getPenanggungJawabField().setSelectedItem(this.invest.getDepartemenPengajuan().getNamaDepartment());
            detailInvest.getUnit3().setSelected(true);
        }else{
            detailInvest.getPenanggungJawabField().setModel(new DefaultComboBoxModel(this.penanggungJawabModel("Holo II").toArray()));
            detailInvest.getPenanggungJawabField().setSelectedItem(this.invest.getDepartemenPengajuan().getNamaDepartment());
            detailInvest.getUnit4().setSelected(true);
        }
        detailInvest.getPanelData().setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Nomor Proposal : "+this.invest.getKodeInvest(), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans", 1, 14)));
        detailInvest.getRealisasiLpbField().setText(FormatRupiah.convert(""+investService.countDebet(invest)[0]));
        detailInvest.getRealisasiLpbField().setEditable(false);
        detailInvest.getRealisasiBskkField().setText(FormatRupiah.convert(""+investService.countDebet(invest)[1]));
        detailInvest.getRealisasiBskkField().setEditable(false);
        detailInvest.getTotalRealisasiField().setText(FormatRupiah.convert(""+investService.countDebet(invest)[2]));
        detailInvest.getTotalRealisasiField().setEditable(false);
        showDataOnTable(invest);
        setEnableForm(false);
    }
    
    @SuppressWarnings("empty-statement")
    public List<String> comboboxModel(String unit){
        listDepartemen = investService.getDataByUnit(unit);
        List<String> model = new ArrayList<>();;
        for(MasterDepartemen departemen : listDepartemen){
            model.add(departemen.getNamaDepartment());
        }
        return model;
    }
    @SuppressWarnings("empty-statement")
    public List<String> penanggungJawabModel(String unit){
        listPenanggungJawab = investService.getDataByUnit(unit);
        List<String> model = new ArrayList<>();;
        for(MasterDepartemen departemen : listPenanggungJawab ){
            model.add(departemen.getNamaDepartment());
        }
        return model;
    }
    
    public DetailInvestView getDetailPage(){
        detailInvest.setTitle("Detail");
        return detailInvest;
    }    
    
    public void showDataOnTable(MasterInvest master){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("<html><center>Kode<br>Rekening");
        model.addColumn("<html><center>Alokasi<br>Biaya");
        model.addColumn("<html><center>Nama<br>Departemen");
        model.addColumn("Keterangan");
        model.addColumn("QTY");
        model.addColumn("Sumber");
        model.addColumn("Debet");
        listLpb = investService.getAllDataByInvestNumber(master.getKodeInvest());
        for(MasterLpb lpb : listLpb){
            Object[] obj = new Object[7];
            obj[0] = lpb.getKodeRekening();
            obj[1] = lpb.getAlokasiBiaya();
            obj[2] = lpb.getMasterDepartemen().getNamaDepartment();
            obj[3] = lpb.getKeterangan();
            obj[4] = lpb.getJumlah();
            obj[5] = "LPB";
            obj[6] = FormatRupiah.convert(""+lpb.getDebet());
            model.addRow(obj);
        }
        listBskk = investService.getDataByInvestNumber(master.getKodeInvest());
        for(MasterBskk bskk : listBskk){
            Object[] obj = new Object[7];
            obj[0] = bskk.getKodeRekening();
            obj[1] = bskk.getMasterDepartemen().getAlokasi();
            obj[2] = bskk.getMasterDepartemen().getNamaDepartment();
            obj[3] = bskk.getKeterangan();
            obj[4] = "-";
            obj[5] = "BSKK";
            obj[6] = FormatRupiah.convert(""+bskk.getDebet());
            model.addRow(obj);
        }
        detailInvest.getViewTable().setModel(model);
        JTableHeader jheader = detailInvest.getViewTable().getTableHeader();
        Dimension dim = jheader.getPreferredSize();
        dim.height = 35; 
        jheader.setPreferredSize(dim);
        jheader.setDefaultRenderer(new TableHeaderRenderer());
        float[] columnSize = {8.0f, 6.0f, 10.0f, 56.0f, 4.0f, 4.0f, 12.0f};
        Table.resizeTable(detailInvest.getViewTable(), columnSize);    
        
    }
    public void setEnableForm(boolean stat){
        detailInvest.getNoSuratIjinField().setEditable(stat);
        detailInvest.getTanggalField().setEditable(stat);
        detailInvest.getJumlahField().setEditable(stat);
        detailInvest.getJenisField().setEditable(stat);
        detailInvest.getRencanaField().setEditable(stat);
        detailInvest.getPemohonField().setEditable(stat);
        detailInvest.getPenanggungJawabField().setEditable(stat);
        detailInvest.getUnit1().setEnabled(stat);
        detailInvest.getUnit2().setEnabled(stat);
        detailInvest.getUnit3().setEnabled(stat);
        detailInvest.getUnit4().setEnabled(stat);
        detailInvest.getPemohonField().setEnabled(stat);
        detailInvest.getPenanggungJawabField().setEnabled(stat);
    }
    
    public void editButton(java.awt.event.ActionEvent e){
        if(detailInvest.getEditButton().getText().equals("EDIT")){
            setEnableForm(true);
            detailInvest.getRencanaField().setText(""+invest.getRencanaBiaya());
            detailInvest.getEditButton().setText("SIMPAN");
        }else if(detailInvest.getEditButton().getText().equals("SIMPAN")){
            invest.setNomorIjin(detailInvest.getNoSuratIjinField().getText());
            invest.setJumlah(Integer.valueOf(detailInvest.getJumlahField().getText()));
            invest.setJenisInvest(detailInvest.getJenisField().getText());
            invest.setRencanaBiaya(Long.parseLong(detailInvest.getRencanaField().getText()));
            invest.setTanggalIjinInvest(detailInvest.getTanggalField().getDate());
            invest.setDepartemenPemohon(listDepartemen.get(detailInvest.getPemohonField().getSelectedIndex()));
            invest.setDepartemenPengajuan(listPenanggungJawab.get(detailInvest.getPenanggungJawabField().getSelectedIndex()));
            setData(investService.update(invest));
            setEnableForm(false);
            detailInvest.getEditButton().setText("EDIT");
        }
    }
    public void export(java.awt.event.ActionEvent e){
        investService.exportToExcel(invest, listLpb, listBskk);
    }
}
