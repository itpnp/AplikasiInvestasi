/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.dao.impl;

import aplikasiinvestasi.dao.LpbDao;
import aplikasiinvestasi.dto.TotalKredit;
import aplikasiinvestasi.model.MasterDepartemen;
import aplikasiinvestasi.model.MasterInvest;
import aplikasiinvestasi.model.MasterLpb;
import aplikasiinvestasi.model.MasterLpj;
import aplikasiinvestasi.service.LpjService;
import aplikasiinvestasi.service.impl.LpjServiceImpl;
import aplikasiinvestasi.utils.BulanEnum;
import aplikasiinvestasi.utils.FormatDate;
import aplikasiinvestasi.utils.FormatRupiah;
import aplikasiinvestasi.utils.HibernateUtil;
import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rizaldi Habibie
 */
public class LpbDaoImpl implements LpbDao {

    private Session session;
    private HSSFSheet sheet;
    private boolean importFlag = false, resmi= false, polos = false;
    private int importIndex, endImportIndex, endLokalIndex, totalLokalIndex;
    private LpjService lpjService = new LpjServiceImpl();
    private List<Integer> listPpnlpj = new ArrayList<>();
    private String rumus = "";
    private Double x;
    
     @Override
    public boolean saveInBatch(List<MasterLpb> listMaster) {
         boolean success = false;
         for(MasterLpb lpb : listMaster){
             if(saveData(lpb)){
                 success = true;
             }else{
                 success = false;
             }
         }
         if(success){
            JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan", "Success", JOptionPane.INFORMATION_MESSAGE, null);
         }else{
            JOptionPane.showMessageDialog(null,"Error Check Database", "Error", JOptionPane.ERROR_MESSAGE, null);
         }
         return success;
     }
     
    @Override
    public boolean saveData(MasterLpb masterLpb) {
        boolean success = false;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(masterLpb);
            session.getTransaction().commit();
            success = true;
//            JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan", "Suuccess", JOptionPane.INFORMATION_MESSAGE, null);
        }catch(  HibernateException | ExceptionInInitializerError e){
            success = false;
            e.printStackTrace();
//            JOptionPane.showMessageDialog(null,"Error Check Database " +e, "Error", JOptionPane.ERROR_MESSAGE, null);
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
    public List<MasterLpb> getAllData() {
        List<MasterLpb> listLpb = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listLpb = session.createCriteria(MasterLpb.class).list();
            for(MasterLpb lpb : listLpb){
                if(lpb.getMasterInvest() != null){
                    Hibernate.initialize(lpb.getMasterInvest());
                }
                Hibernate.initialize(lpb.getMasterDepartemen());
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
        return listLpb;
    }

    @Override
    public List<MasterLpb> getAllDataByMonthAndYear(String month, String year) {
        List<MasterLpb> listLpb = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listLpb = session.createQuery("from MasterLpb where MONTH(tanggal) = '"+month+"' and YEAR(tanggal) = '"+year+"' order by kode_rekening").list();
            if(listLpb != null){
                for(MasterLpb lpb : listLpb){
                    if(lpb.getMasterDepartemen() != null){
                        Hibernate.initialize(lpb.getMasterDepartemen());
                    }
                    if(lpb.getMasterInvest()!=null){
                        Hibernate.initialize(lpb.getMasterInvest());
                    }
                }
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
        return listLpb;
    }

    @Override
    public List<MasterLpb> getAllDataByInvestNumber(String investNumber) {
        List<MasterLpb> listLpb = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listLpb = session.createCriteria(MasterLpb.class, "a")
                    .createAlias("a.masterInvest", "invest")
                    .add(Restrictions.eq("invest.kodeInvest", investNumber)).list();
             if(listLpb != null){
                for(MasterLpb lpb : listLpb){
                    if(lpb.getMasterDepartemen() != null){
                        Hibernate.initialize(lpb.getMasterDepartemen());
                    }
                    if(lpb.getMasterInvest()!=null){
                        Hibernate.initialize(lpb.getMasterInvest());
                    }
                }
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
        return listLpb;
    }

    @Override
    public void templateExcel(HSSFWorkbook workbook,String sheetTitle, List<MasterLpb> masterLpb, List<MasterLpj> masterLpj) {
	    try{
                DataFormat format = workbook.createDataFormat();
                Date date= new Date();
                Calendar cal = Calendar.getInstance();
                cal.setTime(masterLpb.get(0).getTanggal());
                int month = cal.get(Calendar.MONTH) +1;
                int year = cal.get(Calendar.YEAR);
                
                //Make LPB
		sheet = workbook.createSheet(sheetTitle);
		sheet.getPrintSetup().setLandscape(true);
		sheet.getPrintSetup().setPaperSize(HSSFPrintSetup.LEGAL_PAPERSIZE); 
                
	        HSSFCellStyle cellStyle = workbook.createCellStyle();
	        HSSFCellStyle cellStyle2 = workbook.createCellStyle();
	        HSSFCellStyle cellStyle3 = workbook.createCellStyle();
	        HSSFCellStyle cellStyle4 = workbook.createCellStyle();
	        HSSFCellStyle cellStyle5 = workbook.createCellStyle();
                HSSFCellStyle cellStyle6 = workbook.createCellStyle();
                HSSFCellStyle cellStyle7 = workbook.createCellStyle();
                HSSFCellStyle cellStyle8 = workbook.createCellStyle();
                HSSFCellStyle cellStyle9 = workbook.createCellStyle();
                HSSFCellStyle cellStyle10 = workbook.createCellStyle();
                HSSFCellStyle cellStyle11 = workbook.createCellStyle();
                HSSFCellStyle cellStyle12 = workbook.createCellStyle();
                HSSFCellStyle cellStyle13 = workbook.createCellStyle();
                HSSFCellStyle cellStyle14 = workbook.createCellStyle();
                HSSFCellStyle cellStyle15 = workbook.createCellStyle();
                
	        HSSFFont font = workbook.createFont();
	        HSSFFont font2 = workbook.createFont();
	        HSSFFont font3 = workbook.createFont();
                HSSFFont font4 = workbook.createFont();
                HSSFFont font5 = workbook.createFont();
                HSSFFont font6 = workbook.createFont();
                
                font6.setFontHeightInPoints((short)10);
                font6.setBold(true);
                font6.setItalic(true);
                font6.setFontName("Tahoma");
                
		font.setFontHeightInPoints((short)10);
                font.setFontName("Tahoma");
		cellStyle.setBorderBottom(BorderStyle.THIN);
                cellStyle.setBorderTop(BorderStyle.THIN);
                cellStyle.setBorderRight(BorderStyle.THIN);
                cellStyle.setBorderLeft(BorderStyle.THIN);
                cellStyle.setAlignment(HorizontalAlignment.CENTER);
                cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
                cellStyle.setFont(font);
                cellStyle.setWrapText(true);
                
                font2.setFontHeightInPoints((short)10);
                font2.setFontName("Tahoma");
                cellStyle2.setAlignment(HorizontalAlignment.LEFT);
                cellStyle2.setFont(font2);
                
                cellStyle12.setVerticalAlignment(VerticalAlignment.CENTER);
                cellStyle12.setDataFormat(format.getFormat("_-* #,##0.00_-;-* #,##0.00_-;_-* \"-\"??_-;_-@_-"));
                cellStyle12.setFont(font2);
                
                font4.setFontHeightInPoints((short)10);
                font4.setBold(true);
                font4.setFontName("Tahoma");
                font4.setColor(HSSFFont.COLOR_RED);
                cellStyle4.setVerticalAlignment(VerticalAlignment.CENTER);
                cellStyle4.setFont(font4);
                
		font3.setFontHeightInPoints((short)10);
                font3.setBold(true);
                font3.setFontName("Tahoma");
                cellStyle3.setAlignment(HorizontalAlignment.LEFT);
		cellStyle3.setFont(font3);
                cellStyle3.setWrapText(true);
		
                cellStyle5.setBorderBottom(BorderStyle.DASHED);
                cellStyle5.setBorderTop(BorderStyle.DASHED);
                cellStyle5.setBorderRight(BorderStyle.DASHED);
                cellStyle5.setBorderLeft(BorderStyle.DASHED);
                cellStyle5.setAlignment(HorizontalAlignment.CENTER);
                cellStyle5.setDataFormat(format.getFormat("_-* #,##0.00_-;-* #,##0.00_-;_-* \"-\"??_-;_-@_-"));
                cellStyle5.setVerticalAlignment(VerticalAlignment.CENTER);
                cellStyle5.setFont(font3);
                
                cellStyle6.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
                cellStyle6.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                cellStyle6.setAlignment(HorizontalAlignment.CENTER);
                cellStyle6.setFont(font4);
                
                cellStyle7.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
                cellStyle7.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                cellStyle7.setFont(font6);
                
                cellStyle8.setBorderBottom(BorderStyle.DOUBLE);
                cellStyle8.setBorderTop(BorderStyle.THIN);
                cellStyle8.setAlignment(HorizontalAlignment.CENTER);
                cellStyle8.setDataFormat(format.getFormat("_-* #,##0.00_-;-* #,##0.00_-;_-* \"-\"??_-;_-@_-"));
                cellStyle8.setVerticalAlignment(VerticalAlignment.CENTER);
                cellStyle8.setFont(font6);
                
                font5.setFontHeightInPoints((short)11);
                font5.setBold(true);
                font5.setFontName("Tahoma");
                font5.setColor(HSSFFont.COLOR_RED);
                cellStyle9.setBorderBottom(BorderStyle.DOUBLE);
                cellStyle9.setBorderTop(BorderStyle.THIN);
                cellStyle9.setAlignment(HorizontalAlignment.CENTER);
                cellStyle9.setVerticalAlignment(VerticalAlignment.CENTER);
                cellStyle9.setDataFormat(format.getFormat("_-* #,##0.00_-;-* #,##0.00_-;_-* \"-\"??_-;_-@_-"));
                cellStyle9.setFont(font5);
                
                cellStyle10.setAlignment(HorizontalAlignment.CENTER);
                cellStyle10.setVerticalAlignment(VerticalAlignment.CENTER);
                cellStyle10.setFont(font5);
                
                cellStyle11.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
                cellStyle11.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                cellStyle11.setFont(font6);
                
                cellStyle15.setBorderBottom(BorderStyle.THIN);
                cellStyle15.setBorderTop(BorderStyle.THIN);
                cellStyle15.setBorderRight(BorderStyle.THIN);
                cellStyle15.setBorderLeft(BorderStyle.THIN);
                cellStyle15.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
                cellStyle15.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                cellStyle15.setDataFormat(format.getFormat("_-* #,##0.00_-;-* #,##0.00_-;_-* \"-\"??_-;_-@_-"));
                cellStyle15.setFont(font3);
                
                font.setFontHeightInPoints((short)10);
                font.setFontName("Tahoma");
                cellStyle13.setAlignment(HorizontalAlignment.CENTER);
                cellStyle13.setVerticalAlignment(VerticalAlignment.CENTER);
                cellStyle13.setDataFormat(format.getFormat("DD MMM yyyy"));
                cellStyle13.setFont(font);
                
                cellStyle14.setBorderBottom(BorderStyle.DASHED);
                cellStyle14.setBorderTop(BorderStyle.DASHED);
                cellStyle14.setBorderRight(BorderStyle.DASHED);
                cellStyle14.setBorderLeft(BorderStyle.DASHED);
                cellStyle14.setAlignment(HorizontalAlignment.CENTER);
                cellStyle14.setVerticalAlignment(VerticalAlignment.CENTER);
                cellStyle14.setFont(font);
                
                @SuppressWarnings("MismatchedReadAndWriteOfArray")
		String[] header= new String[11];
	        header[0]  = "PT. PURA NUSAPERSADA - UNIT HOLOGRAFI";
	        header[1]  = "JURNAL PENERIMAAN BARANG";
	        header[2]  = "BULAN "+BulanEnum.namaBulan()[month]+" - "+year;
                
                /*
                 * create header file
                 */
                HSSFCell cell;
                HSSFRow rowHeader, subHeader, rowData;
                sheet.addMergedRegion(new CellRangeAddress(0,0,0,4));
                for(int i = 1; i<3; i++){
                    rowHeader = sheet.createRow(i);
                    cell = rowHeader.createCell(0);
                    cell.setCellValue(header[i]);
                    cell.setCellStyle(cellStyle3);
                    sheet.addMergedRegion(new CellRangeAddress(i,i,0,4));
                }
                
            rowHeader = sheet.createRow(4);
            for(int i=0; i<13; i++){
            	cell = rowHeader.createCell(i);
            	cell.setCellStyle(cellStyle);
            }
            subHeader = sheet.createRow(5);
            for(int i=0; i<13; i++){
            	cell = subHeader.createCell(i);
            	cell.setCellStyle(cellStyle);
            }
            cell = rowHeader.createCell(0);
            cell.setCellValue("KODE REKENING");
            cell.setCellStyle(cellStyle);
            sheet.addMergedRegion(new CellRangeAddress(4,5,0,0));
            sheet.setColumnWidth(0, 3500);

            cell = rowHeader.createCell(1);
            cell.setCellValue("ALOKASI BIAYA");
            cell.setCellStyle(cellStyle);
            sheet.addMergedRegion(new CellRangeAddress(4,5,1,1));
           
            cell = rowHeader.createCell(2);
            cell.setCellValue("KODE DEPT");
            cell.setCellStyle(cellStyle);
            sheet.addMergedRegion(new CellRangeAddress(4,5,2,2));
            
            cell = rowHeader.createCell(3);
            cell.setCellValue("TANGGAL");
            cell.setCellStyle(cellStyle);
            sheet.addMergedRegion(new CellRangeAddress(4,5,3,3));
            
            cell = rowHeader.createCell(4);
            cell.setCellValue("KETERANGAN");
            cell.setCellStyle(cellStyle);
            sheet.addMergedRegion(new CellRangeAddress(4,5,4,4));
           
            cell = rowHeader.createCell(5);
            cell.setCellValue("SUPLIER");
            cell.setCellStyle(cellStyle);
            sheet.addMergedRegion(new CellRangeAddress(4,5,5,5));
            
            cell = rowHeader.createCell(6);
            cell.setCellValue("REF NO. LPB");
            cell.setCellStyle(cellStyle);
            sheet.addMergedRegion(new CellRangeAddress(4,4,6,7));
            
            cell = subHeader.createCell(6);
            cell.setCellValue("INTR");
            cell.setCellStyle(cellStyle);
            
            cell = subHeader.createCell(7);
            cell.setCellValue("EX");
            cell.setCellStyle(cellStyle);
            
            cell = rowHeader.createCell(8);
            cell.setCellValue("QTY");
            cell.setCellStyle(cellStyle);
            sheet.addMergedRegion(new CellRangeAddress(4,5,8,8));
            
            cell = rowHeader.createCell(9);
            cell.setCellValue("SAT");
            cell.setCellStyle(cellStyle);
            sheet.addMergedRegion(new CellRangeAddress(4,5,9,9));
            
            cell = rowHeader.createCell(10);
            cell.setCellValue("HRG");
            cell.setCellStyle(cellStyle);
            sheet.addMergedRegion(new CellRangeAddress(4,5,10,10));
            
            cell = rowHeader.createCell(11);
            cell.setCellValue("DEBET (Rp.)");
            sheet.addMergedRegion(new CellRangeAddress(4,5,11,11));
            cell.setCellStyle(cellStyle);
            
            cell = rowHeader.createCell(12);
            cell.setCellValue("KREDIT (Rp.)");
            sheet.addMergedRegion(new CellRangeAddress(4,5,12,12));
            cell.setCellStyle(cellStyle);
            
            rowData = sheet.createRow(6);
	    cell = rowData.createCell(0);
            
            //Isi Data Polos Atau Resmi
            List<MasterLpb> listMaster = new ArrayList<>();
//            List<MasterLpj> listLpj = new ArrayList<>();
            String compareRekening;
            if(sheetTitle.equals("LPB POLOS")){
                cell.setCellValue("POLOS");
                cell.setCellStyle(cellStyle4);
                for(MasterLpb lpb : masterLpb){
                    if(lpb.getStatus().equals("POLOS") && lpb.getSumberBarang().equals("LOKAL")){
                        listMaster.add(lpb);
                    }
                }
                for(MasterLpb lpb : masterLpb){
                    if(lpb.getStatus().equals("POLOS") && lpb.getSumberBarang().equals("IMPORT")){
                        listMaster.add(lpb);
                    }
                }
//                for(MasterLpj lpj :masterLpj){
//                    if(lpj.getStatus().equals("POLOS")){
//                        listLpj.add(lpj);
//                    }
//                }

            }else if(sheetTitle.equals("LPB RESMI")){
                cell.setCellValue("RESMI");
                cell.setCellStyle(cellStyle4);
                for(MasterLpb lpb : masterLpb){
                    if(lpb.getStatus().equals("RESMI") && lpb.getSumberBarang().equals("LOKAL")){
                        listMaster.add(lpb);
                    }
                }
                for(MasterLpb lpb : masterLpb){
                    if(lpb.getStatus().equals("RESMI") && lpb.getSumberBarang().equals("IMPORT")){
                        listMaster.add(lpb);
                    }
                }
//                for(MasterLpj lpj :masterLpj){
//                    if(lpj.getStatus().equals("RESMI")){
//                        listLpj.add(lpj);
//                    }
//                }
            }else if(sheetTitle.equals("LPJ")){
                int rowIndex = 6;
                int startIndex = 7;
                rowData = sheet.createRow(rowIndex);
                cell = rowData.createCell(0);
                cell.setCellValue("LAPORAN PENERIMAAN JASA (LPJ)");
                cell.setCellStyle(cellStyle4);
                rowIndex++;
                rowIndex++;
                
                //START LPJ RESMI
                for(MasterLpj lpj: masterLpj){
                    if(lpj.getStatus().equals("RESMI")){
                        resmi = true;
                    }
                }
                if(resmi){
                   rowData = sheet.createRow(rowIndex);
                   cell = rowData.createCell(0);
                   cell.setCellValue("LPJ RESMI");
                   cell.setCellStyle(cellStyle4);
                   rowIndex++;
                   rowIndex++; 
                
                for(MasterLpj lpj: masterLpj){
                    if(lpj.getStatus().equals("RESMI")){
//                      if(masterLpj.size()>0){
//
//                        }
//                        rowData = sheet.createRow(rowIndex);
//                        cell = rowData.createCell(0);
//                        cell.setCellValue("LPJ RESMI");
//                        cell.setCellStyle(cellStyle4);
//                        rowIndex++;
//                        rowIndex++;
                        if(masterLpj.size()>0){
                            compareRekening = masterLpj.get(0).getKodeRekening();
                        }else{
                            compareRekening = null;
                        }
                        rowData = sheet.createRow(rowIndex);
                        compareRekening = fillDataLPJ(rowData, cell, cellStyle2,cellStyle12, cellStyle13, lpj);
                        rowIndex++;
                        rowData = sheet.createRow(rowIndex);
                        for(int i=0; i<13; i++){
                           cell = rowData.createCell(i);
                           cell.setCellStyle(cellStyle5);
                           if(i == 0){
                              cell.setCellValue("2101.05");
                           }else if(i == 4){
                              cell.setCellValue("HUTANG PBT");
                           }else if(i==12){
                              cell.setCellType(CellType.FORMULA);
                              cell.setCellFormula("+L"+(rowIndex)+"");
                           }
                        }
                        
                        rowIndex++;
                        rowIndex++;
                        
                        rowData = sheet.createRow(rowIndex);
                        fillDataLPJ2(rowData, cell, cellStyle2,cellStyle12, cellStyle13, lpj, "");
                        rowIndex++;
                        rowData = sheet.createRow(rowIndex);
                        for(int i=0; i<13; i++){
                           cell = rowData.createCell(i);
                           cell.setCellStyle(cellStyle5);
                           if(i == 0){
                              cell.setCellValue("2101.05");
                           }else if(i == 4){
                              cell.setCellValue("HUTANG PBT");
                           }else if(i==12){
//                              cell.setCellType(CellType.FORMULA);
//                              x = (lpj.getDebet()/100)*lpj.getPph();
                              cell.setCellValue(FormatRupiah.convert(""+lpj.getPph()));
//                              cell.setCellFormula("SUM(K"+startIndex+":K"+rowIndex+")");
                           }
                        }
                        rowIndex++;
                        rowIndex++;
                                
                        rowData = sheet.createRow(rowIndex);
                        lpj.setKodeRekening("2101.05");
                        fillDataLPJ2(rowData, cell, cellStyle2,cellStyle12, cellStyle13, lpj, "JURNAL ADJ");
//                        rowIndex++;
                        rowIndex++;
                        rowData = sheet.createRow(rowIndex);
                        for(int i=0; i<13; i++){
                            cell = rowData.createCell(i);
                            cell.setCellStyle(cellStyle5);
                            if(i == 0){
                               cell.setCellValue("2190.03");
                            }else if(i == 4){
                               cell.setCellValue("HUTANG PPH 23");
                            }else if(i==12){
                               cell.setCellValue(FormatRupiah.convert(""+lpj.getPph()));
                            }
                         }
                        rowIndex++;
                        rowIndex++;
                        rowData = sheet.createRow(rowIndex);
                        for(int i=0; i<5; i++){
                           cell = rowData.createCell(i);
                           cell.setCellStyle(cellStyle12);
                          if(i==0){
                             cell.setCellValue("1180.02");
                          }else if(i==3){
                             cell.setCellValue(FormatDate.convertNumber(lpj.getTanggal()));
                          }else if(i==4){
                             cell.setCellValue("PPN 10%");
                          }
                        }
                        cell = rowData.createCell(10);
                        cell.setCellStyle(cellStyle12);
//                        cell.setCellType(CellType.FORMULA);
//                        cell.setCellFormula("+K"+(rowIndex-8)+"*10%");
                        cell.setCellFormula(""+lpj.getPpn());

                        rowIndex++;
                        listPpnlpj.add(rowIndex);
                        rowData = sheet.createRow(rowIndex);
                        for(int i=0; i<13; i++){
                            cell = rowData.createCell(i);
                            cell.setCellStyle(cellStyle5);
                            if(i == 0){
//                              cell.setCellValue("2190.03");
                              cell.setCellValue("2101.05");
                            }else if(i == 4){
                                cell.setCellValue("HUTANG PBT");
                             }else if(i==12){
                              cell.setCellType(CellType.FORMULA);
                              cell.setCellFormula("+L"+(rowIndex)+"");
                             }
                         }
                        
//                        rowIndex++;
                        rowIndex++;
                        if(masterLpj.size()>0){
                            rowIndex++;
                            rowData = sheet.createRow(rowIndex);
                            cell = rowData.createCell(10);
                            cell.setCellValue("Total PPn");

                            cell = rowData.createCell(11);
                            cell.setCellStyle(cellStyle12);
                            cell.setCellType(CellType.FORMULA);
                            int f = 1;
                            for(Integer x : listPpnlpj){
                                rumus = rumus+"L"+x;
                               if(f==listPpnlpj.size()){

                               }else{
                                   rumus = rumus+"+";
                               }
                               f++;
                            }
                            cell.setCellFormula("SUM("+rumus+")+(L"+startIndex+")");
                            rumus = "";
                        }
                        rowIndex++;
                        rowIndex++;
                        resmi = false;
                    }//END OF IF
                }
            }
                //END LPJ IMPORT
                
                //START LPJ POLOS
                for(MasterLpj lpj : masterLpj){
                    if(lpj.getStatus().equals("POLOS")){
                        polos = true;
                    }
                }
                if(polos){
                    rowData = sheet.createRow(rowIndex);
                    cell = rowData.createCell(0);
                    cell.setCellValue("LPJ POLOS");
                    cell.setCellStyle(cellStyle4);
                    rowIndex++;
                    rowIndex++;
                for(MasterLpj lpj : masterLpj){
                    if(lpj.getStatus().equals("POLOS")){
                        rowIndex++;
                        startIndex = rowIndex;
                        compareRekening = masterLpj.get(0).getKodeRekening();
                        rowData = sheet.createRow(rowIndex);
                        compareRekening = fillDataLPJ(rowData, cell, cellStyle2,cellStyle12, cellStyle13, lpj);
                        rowIndex++;
                        rowData = sheet.createRow(rowIndex);
                        for(int i=0; i<13; i++){
                           cell = rowData.createCell(i);
                           cell.setCellStyle(cellStyle5);
                           if(i == 0){
                              cell.setCellValue("2101.05");
                           }else if(i == 4){
                              cell.setCellValue("HUTANG PBT");
                            }else if(i==12){
                              cell.setCellType(CellType.FORMULA);
                              cell.setCellFormula("SUM(L"+startIndex+":L"+rowIndex+")");
                            }
                        }
                        rowIndex++;
                        rowIndex++;
                                
                        rowData = sheet.createRow(rowIndex);
//                        fillDataLPJ2(rowData, cell, cellStyle2,cellStyle12, cellStyle13, lpj, "PPH "+lpj.getPph()+"%");
                        fillDataLPJ2(rowData, cell, cellStyle2,cellStyle12, cellStyle13, lpj, "");
                        rowIndex++;
                        rowData = sheet.createRow(rowIndex);
                        for(int i=0; i<13; i++){
                           cell = rowData.createCell(i);
                           cell.setCellStyle(cellStyle5);
                           if(i == 0){
                              cell.setCellValue("2101.05");
                           }else if(i == 4){
                              cell.setCellValue("HUTANG PBT");
                           }else if(i==12){
//                              cell.setCellType(CellType.FORMULA);
//                              x = (lpj.getDebet()/100)*lpj.getPph();
                               x = lpj.getPph();
                              cell.setCellValue(lpj.getPph());
//                              cell.setCellFormula("SUM(K"+startIndex+":K"+rowIndex+")");
                           }
                        }
                        rowIndex++;
                        rowIndex++;
                        rowData = sheet.createRow(rowIndex);
                        lpj.setKodeRekening("2101.05");
                        fillDataLPJ2(rowData, cell, cellStyle2,cellStyle12, cellStyle13, lpj, "JURNAL ADJ");
                        rowIndex++;
                        rowData = sheet.createRow(rowIndex);
                        for(int i=0; i<13; i++){
                            cell = rowData.createCell(i);
                            cell.setCellStyle(cellStyle5);
                            if(i == 0){
                               cell.setCellValue("2190.03");
                            }else if(i == 4){
                               cell.setCellValue("HUTANG PPH 23");
                            }else if(i==12){
                               cell.setCellValue(x);
                            }
                         }
                          rowIndex++;
                          rowIndex++;
                         sheet.setColumnWidth(0,2500);
                         sheet.setColumnWidth(1,2500);
                         sheet.setColumnWidth(2,2500);
                         for(int i=3; i<12; i++){
                            sheet.autoSizeColumn(i, true);
                            if(i>=9){
                               sheet.setColumnWidth(i, sheet.getColumnWidth(i) + 2000); 
                            }
                        }
                    }
                }
            }
                 //end of LPJ POLOS
            }
            if( !listMaster.isEmpty()){
                int rowIndex = 8;
                int startIndex = 9;
                compareRekening = listMaster.get(0).getKodeRekening();
                String compareStatus = listMaster.get(0).getSumberBarang();
                for(MasterLpb lpb : listMaster){
                    rowData = sheet.createRow(rowIndex);
                    if(!compareRekening.equals(lpb.getKodeRekening())||!compareStatus.equals(lpb.getSumberBarang())){
                        for(int i=0; i<13; i++){
                            cell = rowData.createCell(i);
                            cell.setCellStyle(cellStyle5);
                            if(i == 0){
                               cell.setCellValue("2101.01");
                            }else if(i == 4){
                                cell.setCellValue("HUTANG USAHA");
                            }else if(i==12){
                                cell.setCellType(CellType.FORMULA);
                                cell.setCellFormula("SUM(L"+startIndex+":L"+rowIndex+")");
                            }
                        }
                        rowIndex++;
                        rowIndex++;
                        rowIndex++;
                        startIndex = rowIndex+1;
                        rowData = sheet.createRow(rowIndex);
                    }       
                    //isi Data Disini
                    if(!importFlag){
                        if(lpb.getSumberBarang().equals("IMPORT")){
                            endLokalIndex = rowIndex-1;
                            cell = rowData.createCell(0);
                            cell.setCellValue("IMPORT");
                            cell.setCellStyle(cellStyle6);
                            importFlag = true;
                            rowIndex++;
                            rowIndex++;
                            startIndex = rowIndex+1;
                            importIndex = startIndex;
                            rowData = sheet.createRow(rowIndex);
                        }
                    }
                    compareRekening = fillData(rowData, cell, cellStyle2,cellStyle12, cellStyle13, lpb)[0];
                    compareStatus = fillData(rowData, cell, cellStyle2,cellStyle12, cellStyle13, lpb)[1];
                    endImportIndex = rowIndex+1;
                    rowIndex++;
                }
//                 rowIndex++;
                 rowData = sheet.createRow(rowIndex);
                 for(int i=0; i<13; i++){
                     cell = rowData.createCell(i);
                     cell.setCellStyle(cellStyle5);
                     if(i == 0){
                        cell.setCellValue("2101.01");
                     }else if(i == 4){
                        cell.setCellValue("HUTANG USAHA");
                     }else if(i==12){
                        cell.setCellType(CellType.FORMULA);
                        cell.setCellFormula("SUM(L"+startIndex+":L"+rowIndex+")");
                     }
                 }
                 if(importFlag){
                     rowIndex = rowIndex+3;
                     rowData = sheet.createRow(rowIndex);
                     for(int i= 0; i<3; i++){
                        cell = rowData.createCell(i+7);
                        cell.setCellStyle(cellStyle7);
                     }
                     cell = rowData.createCell(7);
                     cell.setCellValue("TOTAL LPB IMPORT ------->");
                     cell.setCellStyle(cellStyle7);
                     sheet.addMergedRegion(new CellRangeAddress(rowIndex+3,rowIndex+3,7,9));
                     sheet.setColumnWidth(8, 2500);
                     sheet.setColumnWidth(9, 2500);
                     
                     cell = rowData.createCell(10);
                     cell.setCellType(CellType.FORMULA);
                     cell.setCellStyle(cellStyle8);
                     cell.setCellFormula("SUM(L"+importIndex+":L"+endImportIndex+")");
                     
                     endImportIndex = endImportIndex+1;
                     cell = rowData.createCell(11);
                     cell.setCellStyle(cellStyle8);
                     cell.setCellType(CellType.FORMULA);
                     cell.setCellFormula("SUM(M"+importIndex+":M"+endImportIndex+")");
                     rowIndex = rowIndex + 5;
                 }
                 rowIndex++;
                 rowData = sheet.createRow(rowIndex);
                 cell = rowData.createCell(4);
                 cell.setCellValue("GRAND TOTAL --------->");
                 cell.setCellStyle(cellStyle10);
                 sheet.setColumnWidth(4, 14000);
                 
                 if(importFlag){
                    cell = rowData.createCell(10);
                    cell.setCellType(CellType.FORMULA);
                    cell.setCellStyle(cellStyle9);
                    cell.setCellFormula("SUM(L8:L"+(endLokalIndex-1)+")");
                    cell = rowData.createCell(11);
                    cell.setCellStyle(cellStyle9);
                    cell.setCellType(CellType.FORMULA);
                    cell.setCellFormula("SUM(M8:M"+endLokalIndex+")");
                    totalLokalIndex = rowIndex;                 
                    rowIndex++;
                 }else{
                    cell = rowData.createCell(11);
                    cell.setCellType(CellType.FORMULA);
                    cell.setCellStyle(cellStyle9);
                    cell.setCellFormula("SUM(L8:L"+rowIndex+")");
                    cell = rowData.createCell(12);
                    cell.setCellStyle(cellStyle9);
                    cell.setCellType(CellType.FORMULA);
                    cell.setCellFormula("SUM(M8:M"+rowIndex+")");
                    totalLokalIndex = rowIndex;                 
                    rowIndex++;
                 }
                 //Footer
                 if(sheetTitle.equals("LPB POLOS")){
                    rowData = sheet.createRow(rowIndex);
                    cell = rowData.createCell(9);
                    cell.setCellValue("REKAP PEMBELIAN");
                    cell.setCellStyle(cellStyle11);
                    sheet.addMergedRegion(new CellRangeAddress(rowIndex,rowIndex,9,10));

                    rowIndex++;
                    rowData = sheet.createRow(rowIndex);
                    cell = rowData.createCell(10);
                    cell.setCellValue("SEL");
                    cell.setCellStyle(cellStyle3);

                    cell = rowData.createCell(11);
                    cell.setCellType(CellType.FORMULA);
                    cell.setCellStyle(cellStyle5);
                    cell.setCellFormula("SUM(M"+(totalLokalIndex+1)+"-M"+(totalLokalIndex+2)+")");
                    
                    rowIndex++;
                    rowIndex++;
                    
                 }else if(sheetTitle.equals("LPB RESMI")){
                    //footer LPB RESMI
                    rowIndex++;
                    rowData = sheet.createRow(rowIndex);
                    cell = rowData.createCell(9);
                    cell.setCellValue("DPP");
                    cell.setCellStyle(cellStyle3);
                    
                    cell = rowData.createCell(10);
                    cell.setCellStyle(cellStyle3);
                    cell.setCellType(CellType.FORMULA);
                    cell.setCellFormula("+L"+(rowIndex-1)+"");
                    
                    rowIndex++;
                    rowData = sheet.createRow(rowIndex);
                    cell = rowData.createCell(11);
                    cell.setCellValue("REKAP PEMBELIAN");
                    cell.setCellStyle(cellStyle11);

                    rowIndex++;
                    rowData = sheet.createRow(rowIndex);
                    cell = rowData.createCell(9);
                    cell.setCellValue("SEL");
                    cell.setCellStyle(cellStyle3);
                    
                    cell = rowData.createCell(10);
                    cell.setCellStyle(cellStyle3);
                    cell.setCellType(CellType.FORMULA);
                    cell.setCellFormula("+K"+(rowIndex)+"-K"+(rowIndex-1)+"");
                    
                    rowIndex=  rowIndex+2;
                    rowData = sheet.createRow(rowIndex);
                    cell = rowData.createCell(6);
                    cell.setCellValue("ppn 10%");
                    cell.setCellStyle(cellStyle2);
                    sheet.addMergedRegion(new CellRangeAddress(rowIndex,rowIndex,6,7));

                    
                    rowIndex++;
                    rowData = sheet.createRow(rowIndex);
                    for(int i=0; i<5; i++){
                        cell = rowData.createCell(i);
                        cell.setCellStyle(cellStyle14);
                        if(i==0){
                         cell.setCellValue("1180.02");
                        }else if(i==4){
                         cell.setCellValue("PPN MASUKAN II");
                        }
                    }
                     cell = rowData.createCell(10);
                     cell.setCellStyle(cellStyle12);
                     cell.setCellType(CellType.FORMULA);
                     cell.setCellFormula("+L"+(rowIndex-4)+"*10%");
                    rowIndex++;
                    rowData = sheet.createRow(rowIndex);
                    for(int i=0; i<13; i++){
                        cell = rowData.createCell(i);
                        cell.setCellStyle(cellStyle5);
                        if(i == 0){
                           cell.setCellValue("2101.01");
                        }else if(i == 4){
                           cell.setCellValue("HUTANG USAHA");
                        }else if(i==12){
                           cell.setCellType(CellType.FORMULA);
                           cell.setCellFormula("+L"+(rowIndex)+"");
                        }
                    }
                    startIndex = rowIndex;
                    rowIndex = rowIndex+2;
                    rowData = sheet.createRow(rowIndex);
                    cell = rowData.createCell(9);
                    cell.setCellValue("TOTAL");
                    cell.setCellStyle(cellStyle3);
                    
                    cell = rowData.createCell(11);
                    cell.setCellType(CellType.FORMULA);
                    cell.setCellStyle(cellStyle15);
                    cell.setCellFormula("+K"+(rowIndex-6)+"+M"+(rowIndex-1)+"");
                    
                    rowIndex++;
                    rowIndex++;
                 }
                 //Kalo Lemot, script dibawah ini Penyebabnya
                 sheet.setColumnWidth(0,2500);
                 sheet.setColumnWidth(1,2500);
                 sheet.setColumnWidth(2,2500);
                 for(int i=3; i<13; i++){
                    sheet.autoSizeColumn(i, true);
                    if(i>=9){
                       sheet.setColumnWidth(i, sheet.getColumnWidth(i) + 2000); 
                    }
                }
                 importFlag = false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void printToExcel(String bulan, String tahun, String kodeInvest, Component parent) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        @SuppressWarnings("UnusedAssignment")
        List<MasterLpb> listMaster = null;
        List<MasterLpj> listLpj = null;
        File file = null;
        if(kodeInvest != null && !"0".equals(bulan) && !"0".equals(tahun)){
            listMaster = getAllDataByInvestNumberAndYearAndMonth(kodeInvest, tahun, bulan);
            listLpj = lpjService.getAllDataByInvestNumberAndYearAndMonth(kodeInvest, tahun, bulan);
        }else if(kodeInvest != null && !"0".equals(bulan) && "0".equals(tahun)){
            listMaster = getAllDataByInvestNumberAndMonth(kodeInvest, bulan);
            listLpj = lpjService.getAllDataByInvestNumberAndMonth(kodeInvest, bulan);
        }else if(kodeInvest != null && "0".equals(bulan) && !"0".equals(tahun)){
            listMaster = getAllDataByInvestNumberAndYear(kodeInvest, tahun);
            listLpj = lpjService.getAllDataByInvestNumberAndYear(kodeInvest, tahun);
        }else if(kodeInvest != null && "0".equals(bulan) && "0".equals(tahun)){
            listMaster = getAllDataByInvestNumber(kodeInvest);
            listLpj = lpjService.getAllDataByInvestNumber(kodeInvest);
        }else if(kodeInvest == null && !"0".equals(bulan) && "0".equals(tahun)){
            listMaster = getAllDataByMonth(bulan);
            listLpj = lpjService.getAllDataByMonth(bulan);
        }else if(kodeInvest == null && "0".equals(bulan) && !"0".equals(tahun)){
            listMaster = getAllDataByYear(tahun);
            listLpj = lpjService.getAllDataByYear(tahun);
        }else if(kodeInvest == null && !"0".equals(bulan) && !"0".equals(tahun)){
            listMaster = getAllDataByMonthAndYear(bulan, tahun);
            listLpj = lpjService.getAllDataByMonthAndYear(bulan, tahun);
        }else if(kodeInvest == null && "0".equals(bulan) && "0".equals(tahun)){
            listMaster = getAllData();
            listLpj = lpjService.getAllData();
        }
        
        if(listMaster.isEmpty()){
            System.out.println("kosong");
        }else{
            FileOutputStream outputStream = null;
            try {
  
                templateExcel(workbook,"LPB POLOS", listMaster, listLpj);
                templateExcel(workbook,"LPB RESMI", listMaster, listLpj);
                templateExcel(workbook,"LPJ", listMaster, listLpj);
                
                JFileChooser saveFile = new JFileChooser();
                int result = saveFile.showSaveDialog(null);
                if(result == JFileChooser.APPROVE_OPTION){
                    file = saveFile.getSelectedFile();
                    String path = String.valueOf(file+".xls");
                    outputStream = new FileOutputStream(path);
                    workbook.write(outputStream);
                    outputStream.close();
                    JOptionPane.showMessageDialog(null, "File Berhasil Disimpan di " + path,"Success",JOptionPane.WARNING_MESSAGE);
                    listPpnlpj = new ArrayList<>();
                    rumus = "";
                }else{
                    listPpnlpj = new ArrayList<>();
                    rumus = "";
                    return;
                }
                
            } catch (FileNotFoundException ex) {
                listPpnlpj = new ArrayList<>();
                rumus = "";
                JOptionPane.showMessageDialog(null,"Error Report Data \n" +ex, "Error", JOptionPane.ERROR_MESSAGE, null);
            } catch (IOException ex) {
                listPpnlpj = new ArrayList<>();
                rumus = "";
                JOptionPane.showMessageDialog(null,"Error Report Data \n" +ex, "Error", JOptionPane.ERROR_MESSAGE, null);
            } finally {
                try {
                    if(outputStream != null){
                      outputStream.close();  
                    }
                } catch (IOException ex) {
                    listPpnlpj = new ArrayList<>();
                    rumus = "";
                    JOptionPane.showMessageDialog(null,"Error Report Data \n" +ex, "Error", JOptionPane.ERROR_MESSAGE, null);
                }
            }
        }
        
    }

    @Override
    public String[] fillData(HSSFRow rowData, HSSFCell cell, HSSFCellStyle cellStyle2, HSSFCellStyle cellStyle12, HSSFCellStyle cellStyle13, MasterLpb lpb) {
     String compareRekening[] = new String[2];
                    
     cell = rowData.createCell(0);
     cell.setCellValue(lpb.getKodeRekening());
     cell.setCellStyle(cellStyle2);
     compareRekening[0] = lpb.getKodeRekening();
     compareRekening[1] = lpb.getSumberBarang();
                    
     cell = rowData.createCell(1);
     cell.setCellValue(lpb.getAlokasiBiaya());
     cell.setCellStyle(cellStyle2);

     cell = rowData.createCell(2);
     cell.setCellValue(lpb.getMasterDepartemen().getKodeDepartement());
     cell.setCellStyle(cellStyle2);

     cell = rowData.createCell(3);
     cell.setCellValue(FormatDate.convertNumber(lpb.getTanggal()));
     cell.setCellStyle(cellStyle13);

     cell = rowData.createCell(4);
     cell.setCellValue(lpb.getKeterangan());
     cell.setCellStyle(cellStyle2);
     
     cell = rowData.createCell(5);
     cell.setCellValue(lpb.getSuplier());
     cell.setCellStyle(cellStyle2);
     
     cell = rowData.createCell(6);
     cell.setCellValue(lpb.getNoIpbInternal());
     cell.setCellStyle(cellStyle2);

     cell = rowData.createCell(7);
     cell.setCellValue(lpb.getNoIpbEksternal());
     cell.setCellStyle(cellStyle2);

     cell = rowData.createCell(8);
     cell.setCellValue(lpb.getJumlah());
     cell.setCellStyle(cellStyle2);

     cell = rowData.createCell(9);
     cell.setCellValue(lpb.getSatuan());
     cell.setCellStyle(cellStyle2);

     cell = rowData.createCell(10);
     cell.setCellValue(lpb.getHargaSatuan());
     cell.setCellStyle(cellStyle12);
                    
     cell = rowData.createCell(11);
     cell.setCellValue(lpb.getDebet());
     cell.setCellStyle(cellStyle12);
     return compareRekening;
    }

    @Override
    public String fillDataLPJ(HSSFRow rowData, HSSFCell cell, HSSFCellStyle cellStyle2, HSSFCellStyle cellStyle12, HSSFCellStyle cellStyle13, MasterLpj lpj) {
     String compareRekening = null;
                    
     cell = rowData.createCell(0);
     cell.setCellValue(lpj.getKodeRekening());
     cell.setCellStyle(cellStyle2);
     compareRekening = lpj.getKodeRekening();
                    
     cell = rowData.createCell(1);
     cell.setCellValue(lpj.getAlokasiBiaya());
     cell.setCellStyle(cellStyle2);

     cell = rowData.createCell(2);
     cell.setCellValue(lpj.getMasterDepartemen().getKodeDepartement());
     cell.setCellStyle(cellStyle2);

     cell = rowData.createCell(3);
     cell.setCellValue(FormatDate.convertNumber(lpj.getTanggal()));
     cell.setCellStyle(cellStyle13);

     cell = rowData.createCell(4);
     cell.setCellValue(lpj.getKeterangan());
     cell.setCellStyle(cellStyle2);

     cell = rowData.createCell(5);
     cell.setCellValue(lpj.getNoIpbInternal());
     cell.setCellStyle(cellStyle2);

     cell = rowData.createCell(6);
     cell.setCellValue(lpj.getNoIpbEksternal());
     cell.setCellStyle(cellStyle2);

     cell = rowData.createCell(7);
     cell.setCellValue(lpj.getJumlah());
     cell.setCellStyle(cellStyle2);

     cell = rowData.createCell(8);
     cell.setCellValue(lpj.getSatuan());
     cell.setCellStyle(cellStyle2);

     cell = rowData.createCell(9);
     cell.setCellValue(lpj.getHargaSatuan());
     cell.setCellStyle(cellStyle12);
                    
     cell = rowData.createCell(10);
     cell.setCellValue(lpj.getDebet());
     cell.setCellStyle(cellStyle12);
     return compareRekening;
    }
    
    public void fillDataLPJ2(HSSFRow rowData, HSSFCell cell, HSSFCellStyle cellStyle2, HSSFCellStyle cellStyle12, HSSFCellStyle cellStyle13, MasterLpj lpj, String ket) {
                    
     cell = rowData.createCell(0);
     cell.setCellValue(lpj.getKodeRekening());
     cell.setCellStyle(cellStyle2);
                    
     cell = rowData.createCell(1);
     cell.setCellValue(lpj.getAlokasiBiaya());
     cell.setCellStyle(cellStyle2);

     cell = rowData.createCell(2);
     cell.setCellValue(lpj.getMasterDepartemen().getKodeDepartement());
     cell.setCellStyle(cellStyle2);

     cell = rowData.createCell(3);
     cell.setCellValue(FormatDate.convertNumber(lpj.getTanggal()));
     cell.setCellStyle(cellStyle13);

     cell = rowData.createCell(4);
     cell.setCellValue(ket);
     cell.setCellStyle(cellStyle2);

     cell = rowData.createCell(5);
     cell.setCellValue(lpj.getNoIpbInternal());
     cell.setCellStyle(cellStyle2);

     cell = rowData.createCell(6);
     cell.setCellValue(lpj.getNoIpbEksternal());
     cell.setCellStyle(cellStyle2);
    
    }
    
    @Override
    public List<TotalKredit> countAllCredit() {
        List<TotalKredit> listCredit = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createSQLQuery("SELECT kode_rekening, MONTHNAME( tanggal ) as bulan , YEAR( tanggal ) as tahun, SUM( debet ) as kredit " 
                                        +"FROM master_lpb "
                                        +"GROUP BY kode_rekening, MONTHNAME( tanggal ) , YEAR( tanggal ) ");
            List<Object[]> rows = query.list();
            for(Object[] obj : rows){
                TotalKredit kredit = new TotalKredit();
                kredit.setKodeRekening(obj[0].toString());
                kredit.setBulan(obj[1].toString());
                kredit.setTahun(obj[2].toString());
                kredit.setKredit(Double.parseDouble(obj[3].toString()));
                listCredit.add(kredit);
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
        return listCredit;
    }

    @Override
    public List<TotalKredit> countCreditByMonthAndYear(String month, String year) {
        List<TotalKredit> listCredit = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createSQLQuery("SELECT kode_rekening, MONTHNAME( tanggal ) as bulan , YEAR( tanggal ) as tahun, SUM( debet ) as kredit " 
                                        +"FROM master_lpb where MONTH(tanggal) = '"+month+"' and YEAR(tanggal)='"+year+"'"
                                        +"GROUP BY kode_rekening, MONTHNAME( tanggal ) , YEAR( tanggal ) ");
            List<Object[]> rows = query.list();
            for(Object[] obj : rows){
                TotalKredit kredit = new TotalKredit();
                kredit.setKodeRekening(obj[0].toString());
                kredit.setBulan(obj[1].toString());
                kredit.setTahun(obj[2].toString());
                kredit.setKredit(Double.parseDouble(obj[3].toString()));
                listCredit.add(kredit);
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
        return listCredit;
    }

    @Override
    public Long countDebet(MasterInvest masterInvest) {
        Long totalDebet = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createSQLQuery("select SUM(debet) as total from master_lpb where kode_invest = '"+masterInvest.getKodeInvest()+"'");
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
    public void updateData(MasterLpb masterLpb) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(masterLpb);
            session.getTransaction().commit();
            JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan", "Suuccess", JOptionPane.INFORMATION_MESSAGE, null);
        }catch(  HibernateException | ExceptionInInitializerError e){
            JOptionPane.showMessageDialog(null,"Error Check Database " +e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
    }

    @Override
    public List<MasterLpb> getAllDataByMonth(String month) {
        List<MasterLpb> listLpb = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listLpb = session.createQuery("from MasterLpb where MONTH(tanggal) = '"+month+"' order by kode_rekening").list();
            if(listLpb != null){
                for(MasterLpb lpb : listLpb){
                    if(lpb.getMasterDepartemen() != null){
                        Hibernate.initialize(lpb.getMasterDepartemen());
                    }
                    if(lpb.getMasterInvest()!=null){
                        Hibernate.initialize(lpb.getMasterInvest());
                    }
                }
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
        return listLpb;
    }

    @Override
    public List<MasterLpb> getAllDataByYear(String year) {
        List<MasterLpb> listLpb = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listLpb = session.createQuery("from MasterLpb where YEAR(tanggal) = '"+year+"' order by kode_rekening").list();
            if(listLpb != null){
                for(MasterLpb lpb : listLpb){
                    if(lpb.getMasterDepartemen() != null){
                        Hibernate.initialize(lpb.getMasterDepartemen());
                    }
                    if(lpb.getMasterInvest()!=null){
                        Hibernate.initialize(lpb.getMasterInvest());
                    }
                }
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
        return listLpb;
    }

    @Override
    public List<MasterLpb> getAllDataByInvestNumberAndYear(String investNumber, String year) {
        List<MasterLpb> listLpb = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listLpb = session.createCriteria(MasterLpb.class, "a")
                    .createAlias("a.masterInvest", "invest")
                    .add(Restrictions.eq("invest.kodeInvest", investNumber))
                    .add(Restrictions.sqlRestriction("Year(tanggal) = '"+year+"'"))
                    .addOrder(Order.asc("a.noIpbInternal")).list();
             if(listLpb != null){
                for(MasterLpb lpb : listLpb){
                    if(lpb.getMasterDepartemen() != null){
                        Hibernate.initialize(lpb.getMasterDepartemen());
                    }
                    if(lpb.getMasterInvest()!=null){
                        Hibernate.initialize(lpb.getMasterInvest());
                    }
                }
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
        return listLpb;
    }

    @Override
    public List<MasterLpb> getAllDataByInvestNumberAndMonth(String investNumber, String month) {
        List<MasterLpb> listLpb = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listLpb = session.createCriteria(MasterLpb.class, "a")
                    .createAlias("a.masterInvest", "invest")
                    .add(Restrictions.eq("invest.kodeInvest", investNumber))
                    .add(Restrictions.sqlRestriction("MONTH(tanggal) = '"+month+"'"))
                    .addOrder(Order.asc("a.noIpbInternal")).list();
             if(listLpb != null){
                for(MasterLpb lpb : listLpb){
                    if(lpb.getMasterDepartemen() != null){
                        Hibernate.initialize(lpb.getMasterDepartemen());
                    }
                    if(lpb.getMasterInvest()!=null){
                        Hibernate.initialize(lpb.getMasterInvest());
                    }
                }
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
        return listLpb;
    }

    @Override
    public List<MasterLpb> getAllDataByInvestNumberAndYearAndMonth(String investNumber, String year, String month) {
        List<MasterLpb> listLpb = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listLpb = session.createCriteria(MasterLpb.class, "a")
                    .createAlias("a.masterInvest", "invest")
                    .add(Restrictions.eq("invest.kodeInvest", investNumber))
                    .add(Restrictions.sqlRestriction("MONTH(tanggal) = '"+month+"'"))
                    .add(Restrictions.sqlRestriction("Year(tanggal) = '"+year+"'"))
                    .addOrder(Order.asc("a.noIpbInternal")).list();
             if(listLpb != null){
                for(MasterLpb lpb : listLpb){
                    if(lpb.getMasterDepartemen() != null){
                        Hibernate.initialize(lpb.getMasterDepartemen());
                    }
                    if(lpb.getMasterInvest()!=null){
                        Hibernate.initialize(lpb.getMasterInvest());
                    }
                }
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
        return listLpb;
    }

    @Override
    public List<MasterLpb> findByYearMonthRekening(String year, String month, String rekening) {
        List<MasterLpb> listLpb = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listLpb = session.createCriteria(MasterLpb.class, "a")
                    .add(Restrictions.sqlRestriction("MONTH(tanggal) = '"+month+"'"))
                    .add(Restrictions.sqlRestriction("YEAR(tanggal) = '"+year+"'"))
                    .add(Restrictions.eq("a.kodeRekening",rekening))
                    .addOrder(Order.asc("a.noIpbInternal")).list();
             if(listLpb != null){
                for(MasterLpb lpb : listLpb){
                    if(lpb.getMasterDepartemen() != null){
                        Hibernate.initialize(lpb.getMasterDepartemen());
                    }
                    if(lpb.getMasterInvest()!=null){
                        Hibernate.initialize(lpb.getMasterInvest());
                    }
                }
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
        return listLpb;
    }

    @Override
    public void directPrint(JTable viewTable, String ppn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MasterLpb> importFile() {
        List<MasterLpb> listLpb = new ArrayList<>();
        File file;
        JFileChooser saveFile = new JFileChooser();
        int result = saveFile.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
          file = saveFile.getSelectedFile();
        try {
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);
            DataFormatter dataFormatter = new DataFormatter();
            Iterator<Row> rowIterator = sheet.rowIterator();
            DateFormat formatter = new SimpleDateFormat("MM/dd/yy"); 
            Date date = null;
            boolean add = false;
            boolean error = false;
            while(rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                MasterLpb masterLpb = new MasterLpb();
                if(error){
                   add = false;
                   JOptionPane.showMessageDialog(null, "Ada data kosong !");
                   break;
                }else{
                    while(cellIterator.hasNext()){
                        Cell cell = cellIterator.next();
                        
                            if(cell.getRowIndex()>=7){
                                add = true;
                                if(dataFormatter.formatCellValue(cell).equals(null)||dataFormatter.formatCellValue(cell).equals("")){
                                    error = true;
                                    break;
                                }else{
                                    if(cell.getColumnIndex()==1){
                                        masterLpb.setSuplier(dataFormatter.formatCellValue(cell));
                                    }else if(cell.getColumnIndex()==2){
                                        masterLpb.setNoIpbInternal(dataFormatter.formatCellValue(cell));
                                    }else if(cell.getColumnIndex()==3){
                                        masterLpb.setNoIpbEksternal(dataFormatter.formatCellValue(cell));
                                    }else if(cell.getColumnIndex()==4){
                                        date = (Date)formatter.parse(dataFormatter.formatCellValue(cell));
                                        masterLpb.setTanggal( date);
                                    }else if(cell.getColumnIndex()==5){
                                        masterLpb.setKeterangan(cell.getStringCellValue());
                                    }else if(cell.getColumnIndex()==6){
                                        masterLpb.setKodeRekening(cell.getStringCellValue());
                                    }else if(cell.getColumnIndex()==7){
                                        masterLpb.setAlokasiBiaya(cell.getStringCellValue());
                                    }else if(cell.getColumnIndex()==8){
                                        MasterDepartemen masterDepartemen = new MasterDepartemen();
                                        masterDepartemen.setKodeDepartement(dataFormatter.formatCellValue(cell));
                                        masterLpb.setMasterDepartemen(masterDepartemen);   
                                    }else if(cell.getColumnIndex()==9){
                                        if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                                masterLpb.setJumlah(Double.valueOf(cell.getStringCellValue()));
                                        }
                                    }else if(cell.getColumnIndex()==10){
                                        masterLpb.setSatuan(cell.getStringCellValue());
                                    }else if(cell.getColumnIndex()==11){
                                        if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                                masterLpb.setHargaSatuan(Double.valueOf(cell.getStringCellValue()));
                                        }
                                    }else if(cell.getColumnIndex()==12){
                                        if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                                masterLpb.setDebet(masterLpb.getJumlah()*masterLpb.getHargaSatuan());
                                        }
                                    }else if(cell.getColumnIndex()==13){
                                        if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                                             cell.setCellType(Cell.CELL_TYPE_STRING);
                                             Double d = Double.valueOf(cell.getStringCellValue());
                                             if(d > 0){
                                              masterLpb.setStatus("RESMI");   
                                             }else{
                                                masterLpb.setStatus("POLOS");   
                                             }

                                        }
                                    }
                            }
                        }
                    }
//                    String cellValue = dataFormatter.formatCellValue(cell);
//                    System.out.print(cellValue +" index : "+cell.getColumnIndex()+ "\t");
                }
               if(add){
                  listLpb.add(masterLpb);
               }
//                System.out.println();
            }
            if(error){
                  return null; 
            }
            workbook.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InvalidFormatException ex) {
            ex.printStackTrace();
        } catch (EncryptedDocumentException ex) {
            ex.printStackTrace();
        } 
        catch (ParseException ex) {
            ex.printStackTrace();
        }
        }
        return listLpb;
    }

}
