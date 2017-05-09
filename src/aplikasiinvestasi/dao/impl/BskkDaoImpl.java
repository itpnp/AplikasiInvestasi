/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.dao.impl;

import aplikasiinvestasi.dao.BskkDao;
import aplikasiinvestasi.model.MasterBskk;
import aplikasiinvestasi.model.MasterInvest;
import aplikasiinvestasi.model.MasterTerima;
import aplikasiinvestasi.utils.BulanEnum;
import aplikasiinvestasi.utils.FormatDate;
import aplikasiinvestasi.utils.HibernateUtil;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.util.CellRangeAddress;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rizaldi Habibie
 */
public class BskkDaoImpl implements BskkDao{
    private Session session;
    private HSSFSheet sheet;
    
    
    @Override
    public List<MasterBskk> getAllData() {
        List<MasterBskk> listBskk = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Property year = Property.forName("year");
            listBskk = session.createCriteria(MasterBskk.class,"bskk").createAlias("bskk.masterDepartemen", "departemen")
                    .addOrder(Order.asc("bskk.kodeRekening"))
                    .addOrder(Order.asc("departemen.namaDepartment"))
                    .addOrder(Order.desc("bskk.tanggal")).list();
            for(MasterBskk bskk : listBskk){
                if(bskk.getMasterInvest() != null){
                    Hibernate.initialize(bskk.getMasterInvest());
                }
                Hibernate.initialize(bskk.getMasterDepartemen());
            }
            session.flush();
        }catch(  HibernateException | ExceptionInInitializerError e){
            JOptionPane.showMessageDialog(null,"Error Check Database \n" +e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
        return listBskk;
    }
    
    @Override
    public void saveInBatch(List<MasterBskk> listBskk) {
        boolean success = true;
        try{
            for(MasterBskk bskk : listBskk){
               if(saveData(bskk)){
                   
               }else{
                   success = false;
                   JOptionPane.showMessageDialog(null,"Data Gagal Disimpan", "Error", JOptionPane.ERROR_MESSAGE, null);
                   break;
               }
            }
            if(success){
                JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan", "Suuccess", JOptionPane.INFORMATION_MESSAGE, null);
            }
        }catch(Exception e){
        }
        
    }
    
    @Override
    public boolean saveData(MasterBskk masterBskk) {
        boolean success = false;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(masterBskk);
            session.getTransaction().commit();
            success = true;
            session.flush();
        }catch(  HibernateException | ExceptionInInitializerError e){
            JOptionPane.showMessageDialog(null,"Error Check Database " +e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
        return success;
    }

    @Override
    public void updateData(MasterBskk masterBskk) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(masterBskk);
            session.getTransaction().commit();
            JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan", "Suuccess", JOptionPane.INFORMATION_MESSAGE, null);
            session.flush();
        }catch(  HibernateException | ExceptionInInitializerError e){
            JOptionPane.showMessageDialog(null,"Error Check Database " +e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }    }

    @Override
    public List<MasterBskk> getDataByMonthAndYear(String month, String year) {
        List<MasterBskk> listBskk = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listBskk = session.createCriteria(MasterBskk.class, "bskk")
                    .createAlias("bskk.masterDepartemen", "departemen")
                    .add(Restrictions.sqlRestriction("MONTH(tanggal) = '"+month+"' and YEAR(tanggal) = '"+year+"'"))
                    .addOrder(Order.asc("bskk.kodeRekening"))
                    .addOrder(Order.asc("departemen.namaDepartment"))
                    .addOrder(Order.desc("bskk.tanggal")).list();
//            listBskk = session.createQuery("from MasterBskk where MONTH(tanggal) = '"+month+"' and YEAR(tanggal) = '"+year+"' order by kode_rekening").list();
            if(!listBskk.isEmpty()){
                for(MasterBskk bskk : listBskk){
                    if(bskk.getMasterInvest() != null){
                        Hibernate.initialize(bskk.getMasterInvest());
                    }
                    Hibernate.initialize(bskk.getMasterDepartemen());
                }
            }
            
            session.flush();
        }catch(  HibernateException | ExceptionInInitializerError e){
            JOptionPane.showMessageDialog(null,"Error Check Database \n" +e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
        return listBskk;
    }

    @Override
    public List<MasterBskk> getDataByYear(String year) {
        List<MasterBskk> listBskk = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listBskk = session.createCriteria(MasterBskk.class, "bskk")
                    .createAlias("bskk.masterDepartemen", "departemen")
                    .add(Restrictions.sqlRestriction("YEAR(tanggal) = '"+year+"'"))
                    .addOrder(Order.asc("bskk.kodeRekening"))
                    .addOrder(Order.asc("departemen.namaDepartment"))
                    .addOrder(Order.desc("bskk.tanggal")).list();
            for(MasterBskk bskk : listBskk){
                if(bskk.getMasterInvest() != null){
                    Hibernate.initialize(bskk.getMasterInvest());
                }
                Hibernate.initialize(bskk.getMasterDepartemen());
            }
            session.flush();
        }catch(  HibernateException | ExceptionInInitializerError e){
            JOptionPane.showMessageDialog(null,"Error Check Database \n" +e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
        return listBskk;
    }

    @Override
    public List<MasterBskk> getDataByInvestNumber(String investNumber) {
        List<MasterBskk> listBskk = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listBskk = session.createCriteria(MasterBskk.class, "a")
                    .createAlias("a.masterInvest", "invest")
                    .add(Restrictions.eq("invest.kodeInvest", investNumber)).list();            
            for(MasterBskk bskk : listBskk){
                if(bskk.getMasterInvest() != null){
                    Hibernate.initialize(bskk.getMasterInvest());
                }
                Hibernate.initialize(bskk.getMasterDepartemen());
            }
            session.flush();
        }catch(  HibernateException | ExceptionInInitializerError e){
            JOptionPane.showMessageDialog(null,"Error Check Database \n" +e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
        return listBskk;
    }

    @Override
    @SuppressWarnings({"null", "ConstantConditions"})
    public void exportToExcel(String bulan, String tahun, List<MasterTerima> listTerima) {
         @SuppressWarnings("UnusedAssignment")
         File file = null;
	    try{
                List<MasterBskk> listBskk = null;
                if(bulan==null && tahun != null){
                    listBskk = this.getDataByYear(tahun);
                }else if(bulan != null && tahun !=null){
                    listBskk = this.getDataByMonthAndYear(bulan, tahun);
                }
                
                HSSFWorkbook workbook = new HSSFWorkbook();
                DataFormat format = workbook.createDataFormat();
                HSSFCell cell;
                HSSFRow rowTitle, rowHeader, rowData;
                
                /*
                 * Design Format Font And Cell Style
                 */
                if(!listBskk.isEmpty() ){
                Calendar cal = Calendar.getInstance();
                cal.setTime(listBskk.get(0).getTanggal());
                int month = cal.get(Calendar.MONTH) +1;
                int year = cal.get(Calendar.YEAR);
                
		sheet = workbook.createSheet(BulanEnum.namaBulan()[month]+" '"+year);
		sheet.getPrintSetup().setLandscape(true);
		sheet.getPrintSetup().setPaperSize(HSSFPrintSetup.LEGAL_PAPERSIZE); 
                
	        HSSFCellStyle titleStyle = workbook.createCellStyle();
                HSSFCellStyle titleStyle2 = workbook.createCellStyle();
	        HSSFCellStyle headerStyle = workbook.createCellStyle();
	        HSSFCellStyle dataStyle = workbook.createCellStyle();
                HSSFCellStyle moneyStyle = workbook.createCellStyle();
                
                HSSFFont fontTitle = workbook.createFont();
                HSSFFont fontTitleRed = workbook.createFont();
	        HSSFFont fontHeader = workbook.createFont();
	        HSSFFont fontData = workbook.createFont();
                
                fontTitleRed.setFontHeightInPoints((short)12);
                fontTitleRed.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
                fontTitleRed.setColor(HSSFColor.RED.index);
                fontTitleRed.setFontName("Tahoma");
                titleStyle2.setFont(fontTitleRed);
                
                fontTitle.setFontHeightInPoints((short)12);
                fontTitle.setFontName("Tahoma");
                titleStyle.setFont(fontTitle);
                
                fontHeader.setFontHeightInPoints((short)12);
                fontHeader.setFontName("Tahoma"); 
                headerStyle.setFont(fontHeader);
                headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
                headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
                headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
                headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
                headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                headerStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
                headerStyle.setWrapText(true);
                
                fontData.setFontHeightInPoints((short)12);
                fontData.setFontName("Tahoma");
                dataStyle.setFont(fontData);
                dataStyle.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);
                dataStyle.setBorderTop(HSSFCellStyle.BORDER_DOTTED);
                dataStyle.setBorderRight(HSSFCellStyle.BORDER_DOTTED);
                dataStyle.setBorderLeft(HSSFCellStyle.BORDER_DOTTED);
                dataStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                
                fontData.setFontHeightInPoints((short)12);
                fontData.setFontName("Tahoma");
                moneyStyle.setFont(fontData);
                moneyStyle.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);
                moneyStyle.setBorderTop(HSSFCellStyle.BORDER_DOTTED);
                moneyStyle.setBorderRight(HSSFCellStyle.BORDER_DOTTED);
                moneyStyle.setBorderLeft(HSSFCellStyle.BORDER_DOTTED);
                moneyStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                moneyStyle.setDataFormat(format.getFormat("_-* #,##0.00_-;-* #,##0.00_-;_-* \"-\"??_-;_-@_-"));

                /**
                 * Document Title
                 */                
                @SuppressWarnings("MismatchedReadAndWriteOfArray")
		String[] title= new String[4];
                title[0] = "PT PURA NUSAPERSADA - UNIT HOLOGRAFI";
	        title[1] = "JURNAL PENGELUARAN KAS";
                title[2]  = "PERIODE : "+BulanEnum.namaBulan()[month]+" "+year+"";
	        
                for(int i = 0; i<3; i++){
                    rowHeader = sheet.createRow(i);
                    cell = rowHeader.createCell(1);
                    cell.setCellValue(title[i]);
                    if(i==2){
                        cell.setCellStyle(titleStyle2);
                    }else{
                        cell.setCellStyle(titleStyle);
                    }
                    sheet.addMergedRegion(new CellRangeAddress(i,i,1,5));
                }
                
                /*
                 * Create Header Table
                 */
                @SuppressWarnings("MismatchedReadAndWriteOfArray")
		String[] header= new String[9];
                header[1] = "KODE REKENING";
	        header[2] = "DEPT";
	        header[3] = "ALKS BY";
                header[4] = "TGL";
                header[5] = "KETERANGAN";
                header[6] = "NO BPKK";
                header[7] = "DEBET";
                header[8] = "KREDIT";
                
                for(int i = 0; i<3; i++){
                   rowHeader = sheet.createRow(i+4);
                   for(int j=1; j<9; j++){
                      cell = rowHeader.createCell(j);
                      cell.setCellStyle(headerStyle);
                   }
                }
                rowHeader = sheet.createRow(4);
                for(int i=1; i<9; i++){
                    cell = rowHeader.createCell(i);
                    cell.setCellStyle(headerStyle);
                    sheet.addMergedRegion(new CellRangeAddress(4,6,i,i));
                    cell.setCellValue(header[i]);
                }
                
                for(int i=7; i<10; i++){
                    rowHeader = sheet.createRow(i);
                    for(int j=0; j <9; j++){
                        cell = rowHeader.createCell(j);
                        cell.setCellStyle(dataStyle);
                        if(i==8 && j==5){
                            cell.setCellValue(" JUMLAH PINDAHAN BPKK GAJI ...>"); 
                        }
                    }
                    
                }
                
                    int rowIndex = 10;
                    int lastIndex = 0;
                    @SuppressWarnings("UnusedAssignment")
                    int startCount = 10, endCount = 0;
                    String compareRekening = listBskk.get(0).getKodeRekening();
                    
                    for(MasterBskk bskk : listBskk){
                        
                        if(!compareRekening.equals(bskk.getKodeRekening()) ){
                            endCount = rowIndex;
                            rowData = sheet.createRow(rowIndex);
                            for(int i = 1; i<9; i++){
                                cell = rowData.createCell(i);
                                cell.setCellStyle(dataStyle);
                            }
                            rowIndex++;
                            rowData = sheet.createRow(rowIndex);
                            for(int i = 1; i<9; i++){
                                cell = rowData.createCell(i);
                                if(i==1){
                                    cell.setCellStyle(dataStyle);
                                    cell.setCellValue("1101.02");
                                }else if(i==5){
                                    cell = rowData.createCell(5);
                                    cell.setCellStyle(dataStyle);
                                    cell.setCellValue("KAS UNIT");
                                }else if(i==8){
                                    cell = rowData.createCell(8);
                                    cell.setCellStyle(moneyStyle);
                                    cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
                                    cell.setCellFormula("SUM(H"+startCount+":H"+endCount+")");
                                }else{
                                    cell.setCellStyle(dataStyle);
                                }
                            }
                            
                            rowIndex++;
                            rowData = sheet.createRow(rowIndex);
                            for(int i = 1; i<9; i++){
                                cell = rowData.createCell(i);
                                cell.setCellStyle(dataStyle);
                            }
                            rowIndex++;
                            startCount = rowIndex;
                        }
                        compareRekening = bskk.getKodeRekening();
                        
                        rowData = sheet.createRow(rowIndex);
                        cell = rowData.createCell(1);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(bskk.getKodeRekening());
                        
                        cell = rowData.createCell(2);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(bskk.getMasterDepartemen().getKodeDepartement());
                        
                        cell = rowData.createCell(3);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(bskk.getMasterDepartemen().getAlokasi());
                        
                        cell = rowData.createCell(4);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(FormatDate.convert(bskk.getTanggal()));
                        
                        cell = rowData.createCell(5);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(bskk.getKeterangan());
                        
                        cell = rowData.createCell(6);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(bskk.getNoBskk());
                        
                        cell = rowData.createCell(7);
                        cell.setCellStyle(moneyStyle);
                        cell.setCellValue(bskk.getDebet());
                        
                        cell = rowData.createCell(8);
                        cell.setCellStyle(dataStyle);
                        
                        if(lastIndex==listBskk.size()-1 ){
                            rowIndex++;
                            rowData = sheet.createRow(rowIndex);
                            for(int i = 1; i<9; i++){
                                cell = rowData.createCell(i);
                                cell.setCellStyle(dataStyle);
                            }
                            endCount = rowIndex;
                            rowIndex++;
                            rowData = sheet.createRow(rowIndex);
                            for(int i = 1; i<9; i++){
                                cell = rowData.createCell(i);
                                if(i==1){
                                    cell.setCellStyle(dataStyle);
                                    cell.setCellValue("1101.02");
                                }else if(i==5){
                                    cell = rowData.createCell(5);
                                    cell.setCellStyle(dataStyle);
                                    cell.setCellValue("KAS UNIT");
                                }else if(i==8){
                                    cell = rowData.createCell(8);
                                    cell.setCellStyle(moneyStyle);
                                    cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
                                    cell.setCellFormula("SUM(H"+startCount+":H"+endCount+")");
                                }else{
                                    cell.setCellStyle(dataStyle);
                                }
                            }
                            startCount = endCount+1;
                        }
                        lastIndex++;
                        rowIndex++;
                    }
                    HSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);
                    for(int i=0; i<10; i++){
                        sheet.autoSizeColumn(i, true);
                    }
                    this.exportToExcelSheet2(workbook, sheet, listTerima);
                    @SuppressWarnings("UnusedAssignment")
                    FileOutputStream outputStream = null;
                    JFileChooser saveFile = new JFileChooser();
                    int result = saveFile.showSaveDialog(null);
                    if(result == JFileChooser.APPROVE_OPTION){
                        file = saveFile.getSelectedFile();
                        String path = String.valueOf(file+".xls");
                        outputStream = new FileOutputStream(path);
                        workbook.write(outputStream);
                        outputStream.close();
                        JOptionPane.showMessageDialog(null, "File Berhasil Disimpan di " + path,"Success",JOptionPane.WARNING_MESSAGE);
                    }else{
                    }
                } else {
                    JOptionPane.showMessageDialog(null,"Empty Result File \n", "Warning", JOptionPane.ERROR_MESSAGE, null);
                }
                
            }catch(HeadlessException | IOException e){
                JOptionPane.showMessageDialog(null,"Error Converting To Excel \n" +e, "Error", JOptionPane.ERROR_MESSAGE, null);
            }
    }

    @Override
    public Long countDebet(MasterInvest masterInvest) {
        Long totalDebet = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createSQLQuery("select SUM(debet) as total from master_bskk where kode_invest = '"+masterInvest.getKodeInvest()+"'");
            if(query.uniqueResult()!= null){
                totalDebet = Long.parseLong(""+query.uniqueResult());
            }else{
                totalDebet = Long.parseLong("0");
            }
        }catch(  HibernateException | ExceptionInInitializerError e){
            JOptionPane.showMessageDialog(null,"Error Check Database \n" +e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
        return totalDebet;
    }

    @Override
    public List<MasterBskk> getDataByMonthAndYearAndInvestNumber(String month, String year, String investNumber) {
        List<MasterBskk> listBskk = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listBskk = session.createCriteria(MasterBskk.class, "bskk")
                    .createAlias("bskk.masterDepartemen", "departemen")
                    .createAlias("bskk.masterInvest", "invest")
                    .add(Restrictions.eq("invest.kodeInvest", investNumber))
                    .add(Restrictions.sqlRestriction("MONTH(tanggal) = '"+month+"' and YEAR(tanggal) = '"+year+"'"))
                    .addOrder(Order.asc("bskk.kodeRekening"))
                    .addOrder(Order.asc("departemen.namaDepartment"))
                    .addOrder(Order.desc("bskk.tanggal")).list();
            if(!listBskk.isEmpty()){
                for(MasterBskk bskk : listBskk){
                    if(bskk.getMasterInvest() != null){
                        Hibernate.initialize(bskk.getMasterInvest());
                    }
                    Hibernate.initialize(bskk.getMasterDepartemen());
                }
            }
            
            session.flush();
        }catch(  HibernateException | ExceptionInInitializerError e){
            JOptionPane.showMessageDialog(null,"Error Check Database \n" +e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
        return listBskk;
    }

    @Override
    public List<MasterBskk> getDataByBpkk(String bpkkNumber) {
        List<MasterBskk> listBskk = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listBskk = session.createCriteria(MasterBskk.class, "a")
                    .add(Restrictions.eq("a.noBskk", bpkkNumber)).list();            
            for(MasterBskk bskk : listBskk){
                if(bskk.getMasterInvest() != null){
                    Hibernate.initialize(bskk.getMasterInvest());
                }
                Hibernate.initialize(bskk.getMasterDepartemen());
            }
            session.flush();
        }catch(  HibernateException | ExceptionInInitializerError e){
            JOptionPane.showMessageDialog(null,"Error Check Database \n" +e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
        return listBskk;
    }

    @Override
    public void exportToExcelSheet2(HSSFWorkbook workbook, HSSFSheet sheet, List<MasterTerima> listTerima) {
        sheet = workbook.createSheet("Rekap KK");
	sheet.getPrintSetup().setLandscape(true);
	sheet.getPrintSetup().setPaperSize(HSSFPrintSetup.LEGAL_PAPERSIZE);
        
        HSSFCellStyle titleStyle = workbook.createCellStyle();
        HSSFCellStyle titleStyle2 = workbook.createCellStyle();
	HSSFCellStyle dataStyle = workbook.createCellStyle();
        HSSFCellStyle underScore = workbook.createCellStyle();
        HSSFCellStyle moneyStyle = workbook.createCellStyle();
        HSSFCellStyle moneyStyle2 = workbook.createCellStyle();
        
        DataFormat format = workbook.createDataFormat();
        
        HSSFFont fontTitle = workbook.createFont();
        HSSFFont fontTitle2 = workbook.createFont();
	HSSFFont fontData = workbook.createFont();
                
        fontTitle.setFontHeightInPoints((short)16);
        fontTitle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        fontTitle.setColor(HSSFColor.BLACK.index);
        fontTitle.setFontName("Tahoma");
        titleStyle.setFont(fontTitle);
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        
        moneyStyle2.setDataFormat(format.getFormat("_-* #,##0.00_-;-* #,##0.00_-;_-* \"-\"??_-;_-@_-"));
        moneyStyle2.setFont(fontTitle);
        moneyStyle2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        
        fontTitle2.setFontHeightInPoints((short)12);
        fontTitle2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        fontTitle2.setColor(HSSFColor.BLACK.index);
        fontTitle2.setFontName("Tahoma");
        titleStyle2.setFont(fontTitle2);
//        titleStyle2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        
        fontData.setFontHeightInPoints((short)12);
        fontData.setFontName("Tahoma");
        dataStyle.setFont(fontData);
        
        underScore.setBorderTop(HSSFCellStyle.BORDER_THIN);
        underScore.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        underScore.setDataFormat(format.getFormat("_-* #,##0.00_-;-* #,##0.00_-;_-* \"-\"??_-;_-@_-"));
        underScore.setFont(fontTitle2);
        
        moneyStyle.setFont(fontData);
        moneyStyle.setDataFormat(format.getFormat("_-* #,##0.00_-;-* #,##0.00_-;_-* \"-\"??_-;_-@_-"));
        
        HSSFCell cell;
        HSSFRow rowData;
        Calendar cal = Calendar.getInstance();
        cal.setTime(listTerima.get(0).getTanggal());
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);  
        
        rowData = sheet.createRow(1);
        cell = rowData .createCell(0);
        sheet.addMergedRegion(new CellRangeAddress(1,1,0,7));
        cell.setCellValue("Rekap Kas Kecil Bulan "+BulanEnum.namaBulan()[month+1]+" Tahun "+year);
        cell.setCellStyle(titleStyle);
        
        rowData = sheet.createRow(4);
        cell = rowData .createCell(0);
        cell.setCellValue("SALDO AWAL BULAN "+BulanEnum.namaBulan()[month]+" TAHUN "+year);
        cell.setCellStyle(titleStyle);
        sheet.addMergedRegion(new CellRangeAddress(4,4,0,4));
        
        cell = rowData .createCell(5);
        cell.setCellValue("=");
        cell.setCellStyle(titleStyle);
        
        cell = rowData .createCell(6);
        cell.setCellValue("Rp");
        cell.setCellStyle(titleStyle);
        
        cell = rowData .createCell(7);
        cell.setCellValue(this.countSaldoBefore(month));
        cell.setCellStyle(moneyStyle2);
        
        rowData = sheet.createRow(7);
        cell = rowData .createCell(0);
        sheet.addMergedRegion(new CellRangeAddress(7,7,0,1));
        cell.setCellValue("TERIMA");
        cell.setCellStyle(titleStyle2);
        
        int nomor = 1;
        for(int i=0; i<listTerima.size(); i++){
            rowData = sheet.createRow(i+8);
            cell = rowData.createCell(0);
            cell.setCellValue(nomor);
            cell.setCellStyle(dataStyle);
            
            cell = rowData.createCell(1);
            cell.setCellValue(listTerima.get(i).getJenis());
            cell.setCellStyle(dataStyle);
            
            cell = rowData.createCell(2);
            cell.setCellValue("=");
            cell.setCellStyle(dataStyle);
            
            cell = rowData.createCell(3);
            cell.setCellValue("Rp");
            cell.setCellStyle(dataStyle);
            
            cell = rowData.createCell(4);
            cell.setCellValue(listTerima.get(i).getJumlah());
            cell.setCellStyle(moneyStyle);
            
            nomor++;
        }
        rowData = sheet.createRow(9+(listTerima.size()));
        cell = rowData.createCell(3);
        cell.setCellValue("Rp");
        cell.setCellStyle(dataStyle);
        
        cell = rowData.createCell(4);
        cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
        cell.setCellFormula("SUM(E8:E"+(8+listTerima.size())+")");
        cell.setCellStyle(underScore);
        
        rowData = sheet.createRow(13+listTerima.size());
        cell = rowData .createCell(0);
        sheet.addMergedRegion(new CellRangeAddress(13+listTerima.size(),13+listTerima.size(),0,1));
        cell.setCellValue("KELUAR");
        cell.setCellStyle(titleStyle2);
        
        nomor = 1;
        int data = 0;
        if(FormatDate.totalDays(month, year)==30){
            data = 6;
        }else{
            data = 7;
        }
        
       rowData = sheet.createRow(14+listTerima.size());
       cell = rowData.createCell(0);
       cell.setCellValue("1");
       cell.setCellStyle(dataStyle);
            
       cell = rowData.createCell(1);
       cell.setCellValue("PERIODE TGL 1-6/"+(month+1)+"/"+year);
       cell.setCellStyle(dataStyle);
       
       cell = rowData.createCell(2);
       cell.setCellValue("=");
       cell.setCellStyle(dataStyle);
            
       cell = rowData.createCell(3);
       cell.setCellValue("Rp");
       cell.setCellStyle(dataStyle);
       
       cell = rowData.createCell(4);
       cell.setCellValue(this.countDebetByDate(year+"/"+(month+1)+"/01", year+"/"+(month+1)+"/06"));
       cell.setCellStyle(moneyStyle);
       
       rowData = sheet.createRow(15+listTerima.size());
       cell = rowData.createCell(0);
       cell.setCellValue("2");
       cell.setCellStyle(dataStyle);
       
       cell = rowData.createCell(1);
       cell.setCellValue("PERIODE TGL 7-13/"+(month+1)+"/"+year);
       cell.setCellStyle(dataStyle);
       
       cell = rowData.createCell(2);
       cell.setCellValue("=");
       cell.setCellStyle(dataStyle);
            
       cell = rowData.createCell(3);
       cell.setCellValue("Rp");
       cell.setCellStyle(dataStyle);
       
       cell = rowData.createCell(4);
       cell.setCellValue(this.countDebetByDate(year+"/"+(month+1)+"/07", year+"/"+(month+1)+"/13"));
       cell.setCellStyle(moneyStyle);
       
       rowData = sheet.createRow(16+listTerima.size());
       cell = rowData.createCell(0);
       cell.setCellValue("3");
       cell.setCellStyle(dataStyle);
       
       cell = rowData.createCell(1);
       cell.setCellValue("PERIODE TGL 14-20/"+(month+1)+"/"+year);
       cell.setCellStyle(dataStyle);
       
       cell = rowData.createCell(2);
       cell.setCellValue("=");
       cell.setCellStyle(dataStyle);
            
       cell = rowData.createCell(3);
       cell.setCellValue("Rp");
       cell.setCellStyle(dataStyle);
       
       cell = rowData.createCell(4);
       cell.setCellValue(this.countDebetByDate(year+"/"+(month+1)+"/14", year+"/"+(month+1)+"/20"));
       cell.setCellStyle(moneyStyle);
       
       rowData = sheet.createRow(17+listTerima.size());
       cell = rowData.createCell(0);
       cell.setCellValue("4");
       cell.setCellStyle(dataStyle);
       
       cell = rowData.createCell(1);
       cell.setCellValue("PERIODE TGL 21-27/"+(month+1)+"/"+year);
       cell.setCellStyle(dataStyle);
       
       cell = rowData.createCell(2);
       cell.setCellValue("=");
       cell.setCellStyle(dataStyle);
            
       cell = rowData.createCell(3);
       cell.setCellValue("Rp");
       cell.setCellStyle(dataStyle);
       
       cell = rowData.createCell(4);
       cell.setCellValue(this.countDebetByDate(year+"/"+(month+1)+"/21", year+"/"+(month+1)+"/27"));
       cell.setCellStyle(moneyStyle);
       
       rowData = sheet.createRow(18+listTerima.size());
       cell = rowData.createCell(0);
       cell.setCellValue("5");
       cell.setCellStyle(dataStyle);
       
       cell = rowData.createCell(1);
       cell.setCellValue("PERIODE TGL 28-30/"+(month+1)+"/"+year);
       cell.setCellStyle(dataStyle);
       
       cell = rowData.createCell(2);
       cell.setCellValue("=");
       cell.setCellStyle(dataStyle);
            
       cell = rowData.createCell(3);
       cell.setCellValue("Rp");
       cell.setCellStyle(dataStyle);
       
       cell = rowData.createCell(4);
       cell.setCellValue(this.countDebetByDate(year+"/"+(month+1)+"/28", year+"/"+(month+1)+"/30"));
       cell.setCellStyle(moneyStyle);
       
       if(FormatDate.totalDays(month,year)>30){
            rowData = sheet.createRow(18+listTerima.size());
            cell = rowData.createCell(0);
            cell.setCellValue("6");
            cell.setCellStyle(dataStyle);
            
            cell = rowData.createCell(1);
            cell.setCellValue("PERIODE TGL 31/"+(month+1)+"/"+year);
            cell.setCellStyle(dataStyle);

            cell = rowData.createCell(2);
            cell.setCellValue("=");
            cell.setCellStyle(dataStyle);

            cell = rowData.createCell(3);
            cell.setCellValue("Rp");
            cell.setCellStyle(dataStyle);
            
            cell = rowData.createCell(4);
            cell.setCellValue(this.countDebetByDate(year+"/"+(month+1)+"/31", year+"/"+(month+1)+"/31"));
            cell.setCellStyle(moneyStyle);
       }
        
        rowData = sheet.createRow(20+(listTerima.size()));
        cell = rowData.createCell(3);
        cell.setCellValue("Rp");
        cell.setCellStyle(dataStyle);
        
        cell = rowData.createCell(4);
        cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
        cell.setCellFormula("SUM(E"+(14+listTerima.size())+":E"+(18+listTerima.size())+")");
        cell.setCellStyle(underScore);
        
        rowData = sheet.createRow(24+(listTerima.size()));
        cell = rowData .createCell(0);
        cell.setCellValue("SALDO AKHIR BULAN "+BulanEnum.namaBulan()[(month+1)]+" TAHUN "+year);
        cell.setCellStyle(titleStyle);
        sheet.addMergedRegion(new CellRangeAddress(24+(listTerima.size()),24+(listTerima.size()),0,4));
        
        cell = rowData.createCell(5);
        cell.setCellValue("=");
        cell.setCellStyle(titleStyle);
        
        cell = rowData.createCell(6);
        cell.setCellValue("Rp");
        cell.setCellStyle(titleStyle);
        
        cell = rowData .createCell(7);
        cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
        if(this.countSaldoBefore(month)>0){
            cell.setCellFormula("=+H5+E"+(8+(listTerima.size()))+"-E"+(20+(listTerima.size())));
        }else{
            cell.setCellFormula("SUM(E"+(14+listTerima.size())+":E"+(18+listTerima.size())+")"); 
        }
        
        cell.setCellStyle(moneyStyle2);
        
        for(int i=0; i<10; i++){
           sheet.autoSizeColumn(i, true);
           if(i==4){
              sheet.setColumnWidth(i, sheet.getColumnWidth(i) + 1000); 
           }else if(i==7){
              sheet.setColumnWidth(i, sheet.getColumnWidth(i) + 6000); 
           }
        }
     }

    @Override
    public Long countDebetByDate(String startDate, String endDate) {
        Long totalDebet = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createSQLQuery("select SUM(debet) as total from master_bskk where tanggal BETWEEN '"+startDate+"' AND '"+endDate+"'");
            if(query.uniqueResult()!= null){
                totalDebet = Long.parseLong(""+query.uniqueResult());
            }else{
                totalDebet = Long.parseLong("0");
            }
        }catch(  HibernateException | ExceptionInInitializerError e){
            JOptionPane.showMessageDialog(null,"Error Check Database \n" +e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
        return totalDebet;
    }

    @Override
    public Long countSaldoBefore(int month) {
        Long totalDebet = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createSQLQuery("select SUM(debet) as total from master_bskk where MONTH(tanggal) = '"+month+"'");
            if(query.uniqueResult()!= null){
                totalDebet = Long.parseLong(""+query.uniqueResult());
            }else{
                totalDebet = Long.parseLong("0");
            }
        }catch(  HibernateException | ExceptionInInitializerError e){
            JOptionPane.showMessageDialog(null,"Error Check Database \n" +e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
        return totalDebet;
    }
}
