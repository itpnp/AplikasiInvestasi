/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.model.MasterTerima;
import aplikasiinvestasi.service.TerimaService;
import aplikasiinvestasi.service.impl.TerimaServiceImpl;
import aplikasiinvestasi.utils.ButtonColumns;
import aplikasiinvestasi.utils.Table;
import aplikasiinvestasi.utils.TableHeaderRenderer;
import aplikasiinvestasi.view.TerimaBskkPage;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
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
            obj[1] = terima.getTanggal();
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
}
