/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.dao.impl;

import aplikasiinvestasi.dao.InvestDao;
import aplikasiinvestasi.model.MasterBskk;
import aplikasiinvestasi.model.MasterInvest;
import aplikasiinvestasi.model.MasterLpb;
import aplikasiinvestasi.utils.FormatDate;
import aplikasiinvestasi.utils.FormatRupiah;
import aplikasiinvestasi.utils.HibernateUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.util.CellRangeAddress;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Rizaldi Habibie
 */
public class InvestDaoImpl implements InvestDao {
    
    private Session session;
    private HSSFSheet sheet;
    
    @Override
    public boolean saveData(MasterInvest masterInvest) {
        boolean success = false;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(masterInvest);
            session.getTransaction().commit();
            JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan", "success", JOptionPane.INFORMATION_MESSAGE, null);
            success = true;
        }catch(HibernateException e){
            JOptionPane.showMessageDialog(null,"Error Check Database", "Error", JOptionPane.ERROR_MESSAGE, null);
        }catch(ExceptionInInitializerError e){
           JOptionPane.showMessageDialog(null,"Error Check Database", "Error", JOptionPane.ERROR_MESSAGE, null);
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
    public List<MasterInvest> getAllData() {
        List<MasterInvest> listData = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from MasterInvest a order by a.tanggalIjinInvest");
            listData = query.list();
            for(MasterInvest invest : listData){
                Hibernate.initialize(invest.getDepartemenPemohon());
                Hibernate.initialize(invest.getDepartemenPengajuan());
            }
        }catch(HibernateException e){
            JOptionPane.showMessageDialog(null,"Error Check Database", "Error", JOptionPane.ERROR_MESSAGE, null);
        }catch(ExceptionInInitializerError e){
           JOptionPane.showMessageDialog(null,"Error Check Database", "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
        return listData;
    }

    @Override
    public MasterInvest update(MasterInvest masterInvest) {
        MasterInvest master = masterInvest;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(masterInvest);
            session.getTransaction().commit();
            JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan", "success", JOptionPane.INFORMATION_MESSAGE, null);
        }catch(HibernateException e){
           JOptionPane.showMessageDialog(null,"Error Check Database", "Error", JOptionPane.ERROR_MESSAGE, null);
        }catch(ExceptionInInitializerError e){
           JOptionPane.showMessageDialog(null,"Error Check Database", "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
        return master;
    }

    @Override
    public List<MasterInvest> findByYear(String year) {
        List<MasterInvest> listInvest = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listInvest = session.createQuery("from MasterInvest where YEAR(tanggal_ijin_invest) = '"+year+"' order by tanggal_ijin_invest").list();
            if(listInvest != null){
                for(MasterInvest invest: listInvest){
                    if(invest.getDepartemenPemohon() != null){
                        Hibernate.initialize(invest.getDepartemenPemohon());
                    }
                    if(invest.getDepartemenPengajuan()!=null){
                        Hibernate.initialize(invest.getDepartemenPengajuan());
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
        return listInvest;
    }

    @Override
    public List<MasterInvest> findByMonth(String month) {
        List<MasterInvest> listInvest = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listInvest = session.createQuery("from MasterInvest where MONTH(tanggal_ijin_invest) = '"+month+"' order by tanggal_ijin_invest").list();
            if(listInvest != null){
                for(MasterInvest invest: listInvest){
                    if(invest.getDepartemenPemohon() != null){
                        Hibernate.initialize(invest.getDepartemenPemohon());
                    }
                    if(invest.getDepartemenPengajuan()!=null){
                        Hibernate.initialize(invest.getDepartemenPengajuan());
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
        return listInvest;
    }

    @Override
    public List<MasterInvest> findByMonthAndYear(String month, String year) {
        List<MasterInvest> listInvest = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listInvest = session.createQuery("from MasterInvest where MONTH(tanggal_ijin_invest) = '"+month+"' and YEAR(tanggal_ijin_invest) = '"+year+"' order by tanggal_ijin_invest").list();
            if(listInvest != null){
                for(MasterInvest invest: listInvest){
                    if(invest.getDepartemenPemohon() != null){
                        Hibernate.initialize(invest.getDepartemenPemohon());
                    }
                    if(invest.getDepartemenPengajuan()!=null){
                        Hibernate.initialize(invest.getDepartemenPengajuan());
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
        return listInvest;
    }

    @Override
    public void exportAllToExcel(String bulan, String tahun) {
        File file = null;
	    try{
                List<MasterInvest> listInvest = null;
                if(bulan==null && tahun != null){
                    listInvest = this.findByYear(tahun);
                }else if(bulan != null && tahun !=null){
                    listInvest = this.findByMonthAndYear(bulan, tahun);
                }else if(bulan !=null && tahun ==null ){
                    listInvest = this.findByMonth(bulan);
                }
                
                HSSFWorkbook workbook = new HSSFWorkbook();
                DataFormat format = workbook.createDataFormat();
                HSSFCell cell;
                HSSFRow rowTitle, rowHeader1, rowHeader2 = null, rowData;
                
                /*
                 * Design Format Font And Cell Style
                 */
		sheet = workbook.createSheet("Daftar Ijin Invest dan Realisasi");
		sheet.getPrintSetup().setLandscape(true);
		sheet.getPrintSetup().setPaperSize(HSSFPrintSetup.LEGAL_PAPERSIZE); 
                
	        HSSFCellStyle titleStyle = workbook.createCellStyle();
	        HSSFCellStyle headerStyle = workbook.createCellStyle();
	        HSSFCellStyle dataStyle = workbook.createCellStyle();
                
                HSSFFont fontTitle = workbook.createFont();
	        HSSFFont fontHeader = workbook.createFont();
	        HSSFFont fontData = workbook.createFont();
                
                fontTitle.setFontHeightInPoints((short)12);
                fontTitle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
                fontTitle.setFontName("Book Antiqua");
                titleStyle.setFont(fontTitle);
                
                fontHeader.setFontHeightInPoints((short)11);
                fontHeader.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
                fontHeader.setFontName("Book Antiqua"); 
                fontHeader.setColor(HSSFColor.YELLOW.index);
                headerStyle.setFont(fontHeader);
                headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THICK);
                headerStyle.setBorderTop(HSSFCellStyle.BORDER_THICK);
                headerStyle.setBorderRight(HSSFCellStyle.BORDER_THICK);
                headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THICK);
                headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                headerStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
                headerStyle.setFillForegroundColor(HSSFColor.VIOLET.index);
                headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
                
                fontData.setFontHeightInPoints((short)11);
                fontData.setFontName("Book Antiqua");
                dataStyle.setFont(fontData);
                dataStyle.setBorderBottom(HSSFCellStyle.BORDER_THICK);
                dataStyle.setBorderTop(HSSFCellStyle.BORDER_THICK);
                dataStyle.setBorderRight(HSSFCellStyle.BORDER_THICK);
                dataStyle.setBorderLeft(HSSFCellStyle.BORDER_THICK);
                dataStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                
                /**
                 * Document Title
                 */
                Calendar cal = Calendar.getInstance();
                cal.setTime(listInvest.get(0).getTanggalIjinInvest());
                int month = cal.get(Calendar.MONTH) +1;
                int year = cal.get(Calendar.YEAR);
                
                @SuppressWarnings("MismatchedReadAndWriteOfArray")
		String[] title= new String[4];
                title[0] = "IJIN INVESTASI";
	        title[1] = "PT. PURA NUSAPERSADA";
	        title[2] = "UNIT HOLOGRAFI";
                if(bulan != null){
                    title[3]  = "Bulan "+month+"- "+year+"";
                }else{
                    title[3]  = "Tahun "+year+"";
                }
	        
                for(int i = 0; i<4; i++){
                    rowHeader1 = sheet.createRow(i);
                    cell = rowHeader1.createCell(1);
                    cell.setCellValue(title[i]);
                    cell.setCellStyle(titleStyle);
                    sheet.addMergedRegion(new CellRangeAddress(i,i,1,3));
                }
                
                /*
                 * Create Header Table
                 */
                @SuppressWarnings("MismatchedReadAndWriteOfArray")
		String[] header= new String[12];
                header[1] = "No";
	        header[2] = "Tanggal";
	        header[3] = "Nomor Surat Ijin";
                header[4] = "Jenis Investasi";
                header[5] = "Jumlah";
                header[6] = "Departement";
                header[7] = "Penanggung Jawab";
                header[8] = "Biaya";
                header[9] = "Rencana";
                header[10] = "Realisasi";
                header[11] = "Pemohon";
                
                rowHeader1 = sheet.createRow(5);
                for(int i=1; i<11; i++){
                    cell = rowHeader1.createCell(i);
                    cell.setCellStyle(headerStyle);
                    if(i>=8){
                        if(i==8){
                            cell.setCellValue(header[i]);
                            sheet.addMergedRegion(new CellRangeAddress(5,5,i,i+1));
                                                        
                        }else if(i==10){
                            cell.setCellValue(header[i+1]);
                            sheet.addMergedRegion(new CellRangeAddress(5,6,i,i));

                        }
                    }else{
                      cell.setCellValue(header[i]);
                      sheet.addMergedRegion(new CellRangeAddress(5,6,i,i));
                    }
                }
                
                rowHeader2 = sheet.createRow(6);
                for(int i=1; i<11; i++){
                    cell = rowHeader2.createCell(i);
                    cell.setCellStyle(headerStyle);
                    if(i==8){
                        cell.setCellValue(header[i]);
                    }else if(i==9){
                        cell.setCellValue(header[i]);
                    }
                }
                
                int rowIndex = 7;
                int jumlahRow = 1;
                if(listInvest.size() != 0){
                    for(MasterInvest invest : listInvest){
                        rowData = sheet.createRow(rowIndex);
                        cell = rowData.createCell(1);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(jumlahRow);
                        
                        cell = rowData.createCell(2);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(FormatDate.convert(invest.getTanggalIjinInvest()));
                        
                        cell = rowData.createCell(3);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(invest.getNomorIjin());
                        
                        cell = rowData.createCell(4);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(invest.getJenisInvest());
                        
                        cell = rowData.createCell(5);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(invest.getJumlah());
                        
                        cell = rowData.createCell(6);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(invest.getDepartemenPengajuan().getNamaDepartment());
                        
                        cell = rowData.createCell(7);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(invest.getDepartemenPengajuan().getKabagDepartment());
                        
                        cell = rowData.createCell(8);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(FormatRupiah.convert(String.valueOf(invest.getRencanaBiaya())));
                        
                        cell = rowData.createCell(9);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(FormatRupiah.convert(""+countDebet(invest)[0]));
                        
                        cell = rowData.createCell(10);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(invest.getDepartemenPemohon().getNamaDepartment());
                        
                        rowIndex++;
                        jumlahRow++;
                        
                    }
                }else{
                    rowData = sheet.createRow(rowIndex);
                    cell = rowData.createCell(1);
                    cell.setCellStyle(dataStyle);
                    cell.setCellValue("Sorry, Empty Result");
                }
                
                for(int i=0; i<12; i++){
                    sheet.autoSizeColumn(i, true);
                }
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
                    return;
                }
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error Converting To Excel \n" +e, "Error", JOptionPane.ERROR_MESSAGE, null);
                e.printStackTrace();
            }
    }

    @Override
    public Long[] countDebet(MasterInvest masterInvest) {
        Long[] totalDebet = new Long[3];
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createSQLQuery("select SUM(debet) as total from master_lpb where kode_invest = '"+masterInvest.getKodeInvest()+"'");
            if(query.uniqueResult()!= null){
                totalDebet[0] = Long.parseLong(""+query.uniqueResult());
            }else{
                totalDebet[0] = Long.parseLong("0");
            }
            query = session.createSQLQuery("select SUM(debet) as total from master_bskk where invest = '"+masterInvest.getKodeInvest()+"'");
            if(query.uniqueResult()!= null){
                totalDebet[1] = Long.parseLong(""+query.uniqueResult());
            }else{
                totalDebet[1] = Long.parseLong("0");
            }
            totalDebet[2] = totalDebet[0]+totalDebet[1];
            
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
        return totalDebet;
    }

    @Override
    public void exportToExcel(MasterInvest masterInvest,List<MasterLpb> listLpb, List<MasterBskk> listBskk) {
        File file = null;
        MasterInvest invest;
	    try{
                invest = masterInvest;
                HSSFWorkbook workbook = new HSSFWorkbook();
                DataFormat format = workbook.createDataFormat();
                HSSFCell cell;
                HSSFRow rowTitle, rowHeader1, rowHeader2 = null, rowData;
                
                /*
                 * Design Format Font And Cell Style
                 */
		sheet = workbook.createSheet("Realisasi Ijin Invests");
		sheet.getPrintSetup().setLandscape(true);
		sheet.getPrintSetup().setPaperSize(HSSFPrintSetup.LEGAL_PAPERSIZE); 
                
	        HSSFCellStyle titleStyle = workbook.createCellStyle();
	        HSSFCellStyle headerStyle = workbook.createCellStyle();
	        HSSFCellStyle dataStyle = workbook.createCellStyle();
                
                HSSFFont fontTitle = workbook.createFont();
	        HSSFFont fontHeader = workbook.createFont();
	        HSSFFont fontData = workbook.createFont();
                
                fontTitle.setFontHeightInPoints((short)12);
                fontTitle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
                fontTitle.setFontName("Book Antiqua");
                titleStyle.setFont(fontTitle);
                
                fontHeader.setFontHeightInPoints((short)11);
                fontHeader.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
                fontHeader.setFontName("Book Antiqua"); 
                fontHeader.setColor(HSSFColor.YELLOW.index);
                headerStyle.setFont(fontHeader);
                headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THICK);
                headerStyle.setBorderTop(HSSFCellStyle.BORDER_THICK);
                headerStyle.setBorderRight(HSSFCellStyle.BORDER_THICK);
                headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THICK);
                headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                headerStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
                headerStyle.setFillForegroundColor(HSSFColor.VIOLET.index);
                headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
                
                fontData.setFontHeightInPoints((short)11);
                fontData.setFontName("Book Antiqua");
                dataStyle.setFont(fontData);
                dataStyle.setBorderBottom(HSSFCellStyle.BORDER_THICK);
                dataStyle.setBorderTop(HSSFCellStyle.BORDER_THICK);
                dataStyle.setBorderRight(HSSFCellStyle.BORDER_THICK);
                dataStyle.setBorderLeft(HSSFCellStyle.BORDER_THICK);
                dataStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                
                /**
                 * Document Title
                 */
//                Calendar cal = Calendar.getInstance();
//                cal.setTime(invest.getTanggalIjinInvest());
//                int month = cal.get(Calendar.MONTH) +1;
//                int year = cal.get(Calendar.YEAR);
                
                @SuppressWarnings("MismatchedReadAndWriteOfArray")
		String[] title= new String[5];
                title[0] = "IJIN INVESTASI";
	        title[1] = "PT. PURA NUSAPERSADA";
	        title[2] = "UNIT HOLOGRAFI";
                title[3] = "Nomor Invest : "+invest.getNomorIjin();
	        title[4] = "Jenis Invest : "+invest.getJenisInvest();
                
                for(int i = 0; i<title.length; i++){
                    rowHeader1 = sheet.createRow(i);
                    cell = rowHeader1.createCell(1);
                    cell.setCellValue(title[i]);
                    cell.setCellStyle(titleStyle);
                    sheet.addMergedRegion(new CellRangeAddress(i,i,1,3));
                }
                
                /*
                 * Create Header Table
                 */
                @SuppressWarnings("MismatchedReadAndWriteOfArray")
		String[] header= new String[10];
                header[1] = "No";
	        header[2] = "Tanggal";
	        header[3] = "Kode Rekening";
                header[4] = "Alokasi Biaya";
                header[5] = "Nama Departemen";
                header[6] = "Keterangan";
                header[7] = "QTY";
                header[8] = "Sumber";
                header[9] = "Debet";
                
                rowHeader1 = sheet.createRow(6);
                for(int i=1; i<header.length; i++){
                      cell = rowHeader1.createCell(i);
                      cell.setCellStyle(headerStyle);
                      cell.setCellValue(header[i]);

                }

                int rowIndex = 7;
                int jumlahRow = 1;
                if(listLpb.size() != 0){
                    for(MasterLpb lpb : listLpb){
                        rowData = sheet.createRow(rowIndex);
                        cell = rowData.createCell(1);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(jumlahRow);
                        
                        cell = rowData.createCell(2);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(FormatDate.convert(lpb.getTanggal()));
                        
                        cell = rowData.createCell(3);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(lpb.getKodeRekening());
                        
                        cell = rowData.createCell(4);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(lpb.getAlokasiBiaya());
                        
                        cell = rowData.createCell(5);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(lpb.getMasterDepartemen().getNamaDepartment());
                        
                        cell = rowData.createCell(6);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(lpb.getKeterangan());
                        
                        cell = rowData.createCell(7);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(lpb.getJumlah());
                        
                        cell = rowData.createCell(8);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue("LPB");
                        
                        cell = rowData.createCell(9);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(FormatRupiah.convert(""+lpb.getDebet()));

                        
                        rowIndex++;
                        jumlahRow++;
                        
                    }
                }
                
                if(listBskk.size()>0){
                    for(MasterBskk lpb : listBskk){
                        rowData = sheet.createRow(rowIndex);
                        cell = rowData.createCell(1);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(jumlahRow);
                        
                        cell = rowData.createCell(2);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(FormatDate.convert(lpb.getTanggal()));
                        
                        cell = rowData.createCell(3);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(lpb.getKodeRekening());
                        
                        cell = rowData.createCell(4);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(lpb.getMasterDepartemen().getAlokasi());
                        
                        cell = rowData.createCell(5);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(lpb.getMasterDepartemen().getNamaDepartment());
                        
                        cell = rowData.createCell(6);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(lpb.getKeterangan());
                        
                        cell = rowData.createCell(7);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue("-");
                        
                        cell = rowData.createCell(8);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue("BSKK");
                        
                        cell = rowData.createCell(9);
                        cell.setCellStyle(dataStyle);
                        cell.setCellValue(FormatRupiah.convert(""+lpb.getDebet()));
                        
                        rowIndex++;
                        jumlahRow++;
                        
                    }
                }
                
                for(int i=0; i<12; i++){
                    sheet.autoSizeColumn(i, true);
                }
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
                    return;
                }
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error Converting To Excel \n" +e, "Error", JOptionPane.ERROR_MESSAGE, null);
                e.printStackTrace();
            }
    }
    
}
