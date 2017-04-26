/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.model.MasterDepartemen;
import aplikasiinvestasi.model.MasterInvest;
import aplikasiinvestasi.service.BskkService;
import aplikasiinvestasi.service.DepartemenService;
import aplikasiinvestasi.service.LpbService;
import aplikasiinvestasi.service.LpjService;
import aplikasiinvestasi.service.impl.DepartemenServiceImpl;
import aplikasiinvestasi.utils.ButtonColumns;
import aplikasiinvestasi.view.ChooseDataInvest;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Rizaldi Habibie
 */
public class ChooseDataInvestController {
    private ChooseDataInvest chooseData;
    private LpbService lpbService;
    private LpjService lpjService;
    private List<MasterInvest> listInvest;
    private List<MasterDepartemen> listPenanggungJawab;
    private AddNewLpbController addLpbLokal;
    private AddNewLpbImportController addLpbImport;
    private AddLpjController addLpj;
    private PrintOptionController printOption;
    private final DepartemenService departemenService = new DepartemenServiceImpl();
    private UpdateLpbController updateController;
    private UpdateLpjController updateLpjController;
    private Action detail;
    private BskkService bskkService;
    private AddBskkController addBskkController;
    private UpdateBskkController updateBskkController;
    
    public ChooseDataInvestController(AddNewLpbController lpbController){
        chooseData = new ChooseDataInvest(lpbController.getParent().getMainPage(), true);
        this.lpbService = lpbController.getService();
        listInvest = lpbService.getAllInvestData();
        addLpbLokal = lpbController;
        detail = new AbstractAction(){
        @Override
        public void actionPerformed(ActionEvent e)
            {
                int modelRow = Integer.valueOf( e.getActionCommand() );
                addLpbLokal.setMasterInvest(listInvest.get(modelRow));
                chooseData.dispose();
            }
        };
    }
    public ChooseDataInvestController(AddNewLpbImportController lpbController){
        chooseData = new ChooseDataInvest(lpbController.getParent().getMainPage(), true);
        this.lpbService = lpbController.getService();
        listInvest = lpbService.getAllInvestData();
        addLpbImport = lpbController;
        detail = new AbstractAction(){
        @Override
        public void actionPerformed(ActionEvent e)
            {
                int modelRow = Integer.valueOf( e.getActionCommand() );
                addLpbImport.setMasterInvest(listInvest.get(modelRow));
                chooseData.dispose();
            }
        };
    }
    public ChooseDataInvestController(AddLpjController lpjController){
        chooseData = new ChooseDataInvest(lpjController.getParent().getMainPage(), true);
        this.lpjService = lpjController.getService();
        listInvest = lpjService.getAllInvestData();
        addLpj = lpjController;
        detail = new AbstractAction(){
        @Override
        public void actionPerformed(ActionEvent e)
            {
                int modelRow = Integer.valueOf( e.getActionCommand() );
                addLpj.setMasterInvest(listInvest.get(modelRow));
                chooseData.dispose();
            }
        };
    }
     public ChooseDataInvestController(PrintOptionController printController){
        chooseData = new ChooseDataInvest(printController.getParentController().getMainPage(), true);
        this.lpbService = printController.getService();
        listInvest = lpjService.getAllInvestData();
        printOption = printController;
        detail = new AbstractAction(){
        @Override
        public void actionPerformed(ActionEvent e)
            {
                int modelRow = Integer.valueOf( e.getActionCommand() );
                printOption.setMasterInvest(listInvest.get(modelRow));
                chooseData.dispose();
            }
        };
    }
    
    public ChooseDataInvestController(final UpdateLpbController updateController){
        chooseData = new ChooseDataInvest(updateController.getParent(), true);
        this.lpbService = updateController.getService();
        listInvest = lpbService.getAllInvestData();
        this.updateController = updateController;
        detail = new AbstractAction(){
        @Override
        public void actionPerformed(ActionEvent e)
            {
                int modelRow = Integer.valueOf( e.getActionCommand() );
                updateController.setMasterInvest(listInvest.get(modelRow));
                chooseData.dispose();
            }
        };
    }
    public ChooseDataInvestController(final UpdateLpjController updateController){
        chooseData = new ChooseDataInvest(updateController.getParent(), true);
        this.lpjService = updateController.getService();
        listInvest = lpjService.getAllInvestData();
        this.updateLpjController = updateController;
        detail = new AbstractAction(){
        @Override
        public void actionPerformed(ActionEvent e)
            {
                int modelRow = Integer.valueOf( e.getActionCommand() );
                updateLpjController.setMasterInvest(listInvest.get(modelRow));
                chooseData.dispose();
            }
        };
    }
    public ChooseDataInvestController(final AddBskkController addBskkController){
        chooseData = new ChooseDataInvest(addBskkController.getParent(), true);
        this.bskkService = addBskkController.getService();
        listInvest = this.bskkService.getAllInvestData();
        this.addBskkController = addBskkController;
        detail = new AbstractAction(){
        @Override
        public void actionPerformed(ActionEvent e)
            {
                int modelRow = Integer.valueOf( e.getActionCommand() );
                addBskkController.setMasterInvest(listInvest.get(modelRow));
                chooseData.dispose();
            }
        };
    }
    public ChooseDataInvestController(final UpdateBskkController updateBskkController){
        chooseData = new ChooseDataInvest(updateBskkController.getParent(), true);
        this.bskkService = updateBskkController.getService();
        listInvest = this.bskkService.getAllInvestData();
        this.updateBskkController = updateBskkController;
        detail = new AbstractAction(){
        @Override
        public void actionPerformed(ActionEvent e)
            {
                int modelRow = Integer.valueOf( e.getActionCommand() );
                updateBskkController.setMasterInvest(listInvest.get(modelRow));
                chooseData.dispose();
            }
        };
    }
    public void showAllData(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Invest");
        model.addColumn("Ijin Invest");
        model.addColumn("Penanggung Jawab");
        model.addColumn("Jenis Invest");
        model.addColumn(("Action"));
//        listInvest = lpbService.getAllInvetData();
        for(MasterInvest invest : listInvest){
            Object[] obj = new Object[5];
            obj[0] = invest.getKodeInvest();
            obj[1] = invest.getNomorIjin();
            obj[2] = invest.getDepartemenPengajuan();
            obj[3] = invest.getJenisInvest();
            obj[4] = "Pilih";
            model.addRow(obj);
        }
        chooseData.getViewTable().setModel(model);
        
        ButtonColumns buttonColumns = new ButtonColumns(chooseData.getViewTable(), detail, 4);
        buttonColumns.setMnemonic(KeyEvent.VK_D);
        
    }
    public void resizeColumn(){
        float[] columnWidthPercentage = {10.0f, 15.0f, 15.0f, 50.0f, 10.0f};
        int tW =   chooseData.getViewTable().getWidth();
        TableColumn column;
        TableColumnModel jTableColumnModel =   chooseData.getViewTable().getColumnModel();
        int cantCols = jTableColumnModel.getColumnCount();
        for (int i = 0; i < cantCols; i++) {
            column = jTableColumnModel.getColumn(i);
            int pWidth = Math.round(columnWidthPercentage[i] * tW);
            column.setPreferredWidth(pWidth);
        }
    }
    
    public ChooseDataInvest chooseInvest(){
        showAllData();
        chooseData.getUnit1().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDepartemenModel(e);
            }
        });
         chooseData.getUnit2().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDepartemenModel(e);
            }
        });
        return chooseData;
    }
    
    @SuppressWarnings("empty-statement")
    public List<String> comboBoxModel(String unit){
        listPenanggungJawab = departemenService .getDepartemenByUnit(unit);
        List<String> model = new ArrayList<>();;
        for(MasterDepartemen departemen : listPenanggungJawab){
            model.add(departemen.getNamaDepartment());
        }
        return model;
    }
    
    public void setDepartemenModel(java.awt.event.ActionEvent e){
        if(chooseData.getUnit1().isSelected()){
            chooseData.getPenanggungJawabField().setModel(new DefaultComboBoxModel(comboBoxModel("Holo I").toArray()));
        }else if(chooseData.getUnit2().isSelected()){
            chooseData.getPenanggungJawabField().setModel(new DefaultComboBoxModel(comboBoxModel("Holo II").toArray()));
        }
    }
    
}
