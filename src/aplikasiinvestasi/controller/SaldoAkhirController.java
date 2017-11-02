/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.model.SaldoAkhir;
import aplikasiinvestasi.service.SaldoAkhirService;
import aplikasiinvestasi.service.impl.SaldoAkhirServiceImpl;
import aplikasiinvestasi.utils.BulanEnum;
import aplikasiinvestasi.utils.ButtonColumns;
import aplikasiinvestasi.utils.FormatRupiah;
import aplikasiinvestasi.utils.TableHeaderRenderer;
import aplikasiinvestasi.view.SaldoAkhirPage;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
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
public class SaldoAkhirController {
  private SaldoAkhirService saldoService;
  private SaldoAkhirPage mainPage;
  private List<SaldoAkhir> listSaldo;
  
  public SaldoAkhirController(){
      mainPage = new SaldoAkhirPage();
      saldoService = new SaldoAkhirServiceImpl();
      mainPage.getSaldoField().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jumlahField(evt);
            }
        });
      mainPage.getSaveButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save(e);
            }
        });
      mainPage.getSaldoField().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save(e);
            }
        });
      mainPage.getSearchButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search(e);
            }
        });
      mainPage.getBulanField().setModel(new DefaultComboBoxModel(BulanEnum.namaBulan()));
      mainPage.getTahunField().setModel(new DefaultComboBoxModel(BulanEnum.tahun()));
      mainPage.getBulanParam().setModel(new DefaultComboBoxModel(BulanEnum.namaBulan()));
      mainPage.getTahunParam().setModel(new DefaultComboBoxModel(BulanEnum.tahun()));
      
  }
  
  public SaldoAkhirPage getPage(){
      return mainPage;
  }
  
  public void getAllData(){
      listSaldo = new ArrayList<>();
      listSaldo = saldoService.getAllData();
  }
  public void viewData(){
      DefaultTableModel model = new DefaultTableModel();
      model.addColumn("BULAN");
      model.addColumn("TAHUN");
      model.addColumn("SALDO");
      model.addColumn("ACTION");
      
      for(SaldoAkhir saldo : listSaldo){
          Object[] obj = new Object[4];
          obj[0] = saldo.getBulan();
          obj[1] = saldo.getTahun();
          obj[2] = FormatRupiah.convert(""+saldo.getSaldo());
          obj[3] = "UPDATE";
          model.addRow(obj);
      }
      mainPage.getViewTable().setModel(model);
      JTableHeader jheader = mainPage.getViewTable().getTableHeader();
      Dimension dim = jheader.getPreferredSize();
      dim.height = 35; 
      jheader.setPreferredSize(dim);
      jheader.setDefaultRenderer(new TableHeaderRenderer());
      Action detail = new AbstractAction(){
      @Override
      public void actionPerformed(ActionEvent e)
          {
             int modelRow = Integer.valueOf( e.getActionCommand());
//           openEditLpjPage(listTerima.get(modelRow));
          }
      };
       ButtonColumns buttonColumns = new ButtonColumns(mainPage.getViewTable(), detail, 3);
  }
  
  public void save(java.awt.event.ActionEvent e){
      SaldoAkhir saldo = new SaldoAkhir();
      saldo.setBulan(mainPage.getBulanField().getSelectedItem().toString());
      saldo.setTahun(mainPage.getTahunField().getSelectedItem().toString());
      saldo.setSaldo(Long.valueOf(mainPage.getSaldoField().getText()));
      if(saldoService.save(saldo)){
          empty();
          getAllData();
         viewData();
      }
  }
  public void empty(){
      mainPage.getBulanField().setSelectedIndex(0);
      mainPage.getTahunField().setSelectedIndex(0);
      mainPage.getSaldoField().setText("");
      mainPage.getLabelRupiah().setText("Rp. - ,00");
  }
  public void jumlahField(java.awt.event.KeyEvent evt){
        formatRupiah(mainPage.getLabelRupiah(), mainPage.getSaldoField());
    }
    public void formatRupiah(JLabel labelFormat, JTextField textFormat){
       labelFormat.setText(FormatRupiah.convert(textFormat.getText()));
    }
    
  public void search(java.awt.event.ActionEvent e){
      if(mainPage.getBulanParam().getSelectedIndex()>0 && mainPage.getTahunParam().getSelectedIndex()>0 ){
        listSaldo = new ArrayList<>();
        listSaldo = saldoService.findByMonthAndYear(mainPage.getBulanField().getSelectedItem().toString(), mainPage.getTahunField().getSelectedItem().toString());
        this.viewData();
      }
  }  
  
}
