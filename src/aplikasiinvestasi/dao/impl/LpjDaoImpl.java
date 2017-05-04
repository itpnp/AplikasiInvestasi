/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.dao.impl;

import aplikasiinvestasi.controller.MainPageLpbController;
import aplikasiinvestasi.dao.LpjDao;
import aplikasiinvestasi.dto.TotalKredit;
import aplikasiinvestasi.model.MasterInvest;
import aplikasiinvestasi.model.MasterLpj;
import aplikasiinvestasi.utils.HibernateUtil;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rizaldi Habibie
 */
public class LpjDaoImpl implements LpjDao {

    private Session session;
    
    @Override
    public boolean saveData(MasterLpj masterLpj) {
        boolean success = false;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(masterLpj);
            session.getTransaction().commit();
            success = true;
        }catch(  HibernateException | ExceptionInInitializerError e){
            success = false;
            JOptionPane.showMessageDialog(null,"Error Check Database \n" +e, "Error", JOptionPane.ERROR_MESSAGE, null);
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
    public List<MasterLpj> getAllData() {
        List<MasterLpj> listLpj = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listLpj = session.createCriteria(MasterLpj.class).list();
            for(MasterLpj lpj : listLpj){
                if(lpj.getMasterInvest() != null){
                    Hibernate.initialize(lpj.getMasterInvest());
                }
                Hibernate.initialize(lpj.getMasterDepartemen());
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
        return listLpj;
    }

    @Override
    public List<MasterLpj> getAllDataByMonthAndYear(String month, String year) {
        List<MasterLpj> listLpj = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listLpj = session.createQuery("from MasterLpj where MONTH(tanggal) = '"+month+"' and YEAR(tanggal) = '"+year+"' order by kode_rekening").list();
            if(listLpj != null){
                for(MasterLpj lpj : listLpj){
                    if(lpj.getMasterDepartemen() != null){
                        Hibernate.initialize(lpj.getMasterDepartemen());
                    }
                    if(lpj.getMasterInvest()!=null){
                        Hibernate.initialize(lpj.getMasterInvest());
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
        return listLpj;
    }

    @Override
    public List<MasterLpj> getAllDataByInvestNumber(String investNumber) {
        List<MasterLpj> listLpj = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listLpj = session.createCriteria(MasterLpj.class, "a")
                    .createAlias("a.masterInvest", "invest")
                    .add(Restrictions.eq("invest.kodeInvest", investNumber)).list();
             if(listLpj != null){
                for(MasterLpj lpj : listLpj){
                    if(lpj.getMasterDepartemen() != null){
                        Hibernate.initialize(lpj.getMasterDepartemen());
                    }
                    if(lpj.getMasterInvest()!=null){
                        Hibernate.initialize(lpj.getMasterInvest());
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
        return listLpj;
    }

    @Override
    public List<MasterLpj> getAllDataByInvestNumberAndYear(String investNumber, String year) {
        List<MasterLpj> listLpj = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listLpj = session.createCriteria(MasterLpj.class, "a")
                    .createAlias("a.masterInvest", "invest")
                    .add(Restrictions.eq("invest.kodeInvest", investNumber))
                    .add(Restrictions.sqlRestriction("Year(tanggal) = '"+year+"'")).list();
             if(listLpj != null){
                for(MasterLpj lpj : listLpj){
                    if(lpj.getMasterDepartemen() != null){
                        Hibernate.initialize(lpj.getMasterDepartemen());
                    }
                    if(lpj.getMasterInvest()!=null){
                        Hibernate.initialize(lpj.getMasterInvest());
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
        return listLpj;
    }

    @Override
    public List<MasterLpj> getAllDataByInvestNumberAndMonth(String investNumber, String month) {
        List<MasterLpj> listLpj = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listLpj = session.createCriteria(MasterLpj.class, "a")
                    .createAlias("a.masterInvest", "invest")
                    .add(Restrictions.eq("invest.kodeInvest", investNumber))
                    .add(Restrictions.sqlRestriction("MONTH(tanggal) = '"+month+"'")).list();
             if(listLpj != null){
                for(MasterLpj lpj : listLpj){
                    if(lpj.getMasterDepartemen() != null){
                        Hibernate.initialize(lpj.getMasterDepartemen());
                    }
                    if(lpj.getMasterInvest()!=null){
                        Hibernate.initialize(lpj.getMasterInvest());
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
        return listLpj;
    }

    @Override
    public List<MasterLpj> getAllDataByInvestNumberAndYearAndMonth(String investNumber, String year, String month) {
        List<MasterLpj> listLpj = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listLpj = session.createCriteria(MasterLpj.class, "a")
                    .createAlias("a.masterInvest", "invest")
                    .add(Restrictions.eq("invest.kodeInvest", investNumber))
                    .add(Restrictions.sqlRestriction("MONTH(tanggal) = '"+month+"'"))
                    .add(Restrictions.sqlRestriction("YEAR(tanggal) = '"+year+"'")).list();
             if(listLpj != null){
                for(MasterLpj lpj : listLpj){
                    if(lpj.getMasterDepartemen() != null){
                        Hibernate.initialize(lpj.getMasterDepartemen());
                    }
                    if(lpj.getMasterInvest()!=null){
                        Hibernate.initialize(lpj.getMasterInvest());
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
        return listLpj;
    }

    @Override
    public List<TotalKredit> countAllCredit() {
        List<TotalKredit> listCredit = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createSQLQuery("SELECT kode_rekening, MONTHNAME( tanggal ) as bulan , YEAR( tanggal ) as tahun, SUM( debet ) as kredit " 
                                        +"FROM master_lpj "
                                        +"GROUP BY kode_rekening, MONTHNAME( tanggal ) , YEAR( tanggal ) ");
            List<Object[]> rows = query.list();
            for(Object[] obj : rows){
                TotalKredit kredit = new TotalKredit();
                kredit.setKodeRekening(obj[0].toString());
                kredit.setBulan(obj[1].toString());
                kredit.setTahun(obj[2].toString());
                kredit.setKredit(Long.parseLong(obj[3].toString()));
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
                                        +"FROM master_lpj where MONTH(tanggal) = '"+month+"' and YEAR(tanggal)='"+year+"'"
                                        +"GROUP BY kode_rekening, MONTHNAME( tanggal ) , YEAR( tanggal ) ");
            List<Object[]> rows = query.list();
            for(Object[] obj : rows){
                TotalKredit kredit = new TotalKredit();
                kredit.setKodeRekening(obj[0].toString());
                kredit.setBulan(obj[1].toString());
                kredit.setTahun(obj[2].toString());
                kredit.setKredit(Long.parseLong(obj[3].toString()));
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
            Query query = session.createSQLQuery("select SUM(debet) as total from master_lpj where kode_invest = '"+masterInvest.getKodeInvest()+"'");
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
    public void updateData(MasterLpj masterLpj) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(masterLpj);
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
    public List<MasterLpj> getAllDataByMonth(String month) {
        List<MasterLpj> listLpj = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listLpj = session.createQuery("from MasterLpj where MONTH(tanggal) = '"+month+"' order by kode_rekening").list();
            if(listLpj != null){
                for(MasterLpj lpj : listLpj){
                    if(lpj.getMasterDepartemen() != null){
                        Hibernate.initialize(lpj.getMasterDepartemen());
                    }
                    if(lpj.getMasterInvest()!=null){
                        Hibernate.initialize(lpj.getMasterInvest());
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
        return listLpj;
    }

    @Override
    public List<MasterLpj> getAllDataByYear(String year) {
        List<MasterLpj> listLpj = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listLpj = session.createQuery("from MasterLpj where YEAR(tanggal) = '"+year+"' order by kode_rekening").list();
            if(listLpj != null){
                for(MasterLpj lpj : listLpj){
                    if(lpj.getMasterDepartemen() != null){
                        Hibernate.initialize(lpj.getMasterDepartemen());
                    }
                    if(lpj.getMasterInvest()!=null){
                        Hibernate.initialize(lpj.getMasterInvest());
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
        return listLpj;
    }

    @Override
    public boolean saveInBatch(List<MasterLpj> listMaster) {
        boolean success = false;
         for(MasterLpj lpj : listMaster){
             if(saveData(lpj)){
                 success = true;
             }else{
                 success = false;
                 break;
             }
         }
         if(success){
            JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan", "Suuccess", JOptionPane.INFORMATION_MESSAGE, null);
         }else{
            JOptionPane.showMessageDialog(null,"Error Check Database", "Error", JOptionPane.ERROR_MESSAGE, null);
         }
         return success;
    }

    @Override
    public List<MasterLpj> findByYearMonthRekening(String year, String month, String rekening) {
        List<MasterLpj> listLpj = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listLpj = session.createCriteria(MasterLpj.class)
                    .add(Restrictions.eq("kodeRekening",rekening))
                    .add(Restrictions.sqlRestriction("MONTH(tanggal) = '"+month+"'"))
                    .add(Restrictions.sqlRestriction("YEAR(tanggal) = '"+year+"'"))
                    .list();
             if(listLpj != null){
                for(MasterLpj lpj : listLpj){
                    if(lpj.getMasterDepartemen() != null){
                        Hibernate.initialize(lpj.getMasterDepartemen());
                    }
                    if(lpj.getMasterInvest()!=null){
                        Hibernate.initialize(lpj.getMasterInvest());
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
        return listLpj;
    }

    @Override
    public void directPrint(JTable viewTable, String ppn) {
        
        try {
//            JRBeanCollectionDataSource collectionDataSource=new JRBeanCollectionDataSource(listLpj);
            Map parameter = new HashMap();
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("aplikasiinvestasi/utils/report1.jrxml");
            JasperDesign design=JRXmlLoader.load(in);
            JasperReport report=JasperCompileManager.compileReport(design);
            Map parameters = new HashMap(); 
            parameters.put("totalPpn", ppn);
            
            JasperPrint jasperPrint;
            jasperPrint = JasperFillManager.fillReport(report, parameters, new JRTableModelDataSource(viewTable.getModel()));
            jasperPrint.setName("Laporan");
            
            JasperViewer jv=new JasperViewer(jasperPrint, false);
            jv.setTitle("Laporan Mahasiswa");
            jv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(MainPageLpbController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /* Fetch printing properties from the GUI components */
        
//        MessageFormat header = new MessageFormat("Data LPJ");
//        MessageFormat footer = new MessageFormat("~");
//
//        boolean fitWidth = false;
//        boolean showPrintDialog = true;
//        boolean interactive = true;
//
//        /* determine the print mode */
//        JTable.PrintMode mode = JTable.PrintMode.FIT_WIDTH;
//
//        try {
//            /* print the table */
//            PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
//            set.add(OrientationRequested.LANDSCAPE);
//            set.add(MediaSizeName.NA_LEGAL);
//            set.add(new Copies(1));
//            
//            boolean complete = viewTable.print(mode, header, footer,
//                                                 showPrintDialog, set,
//                                                 interactive, null);
//
//            /* if printing completes */
//            if (complete) {
//                /* show a success message */
//                JOptionPane.showMessageDialog(null,
//                                              "Printing Complete",
//                                              "Printing Result",
//                                              JOptionPane.INFORMATION_MESSAGE);
//            } else {
//                /* show a message indicating that printing was cancelled */
//                JOptionPane.showMessageDialog(null,
//                                              "Printing Cancelled",
//                                              "Printing Result",
//                                              JOptionPane.INFORMATION_MESSAGE);
//            }
//        } catch (PrinterException pe) {
//            /* Printing failed, report to the user */
//            JOptionPane.showMessageDialog(null,
//                                          "Printing Failed: " + pe.getMessage(),
//                                          "Printing Result",
//                                          JOptionPane.ERROR_MESSAGE);
//        }
        
        //ini export ke excel
        
//        try{
//                HSSFWorkbook workbook = new HSSFWorkbook();
//                DataFormat format = workbook.createDataFormat();
//                HSSFSheet sheet;
//                
//                //Make LPJ
//		sheet = workbook.createSheet("LPJ");
//		sheet.getPrintSetup().setLandscape(true);
//		sheet.getPrintSetup().setPaperSize(HSSFPrintSetup.LEGAL_PAPERSIZE); 
//                
//	        HSSFCellStyle cellStyle = workbook.createCellStyle();
//	        HSSFCellStyle cellStyle2 = workbook.createCellStyle();
//                HSSFCellStyle cellStyle3 = workbook.createCellStyle();
//                
//	        HSSFFont font = workbook.createFont();
//	        HSSFFont font2 = workbook.createFont();
//                HSSFFont font3 = workbook.createFont();
//                
//                font2.setFontHeightInPoints((short)10);
//                font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
//                font2.setItalic(true);
//                font2.setFontName("Tahoma");
//                
//                font.setFontHeightInPoints((short)10);
//                font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
//                font.setFontName("Tahoma");
//                
//                font3.setFontHeightInPoints((short)10);
//                font3.setFontName("Tahoma");
//                
//		font.setFontHeightInPoints((short)10);
//                font.setFontName("Tahoma");
//		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//                cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
//                cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
//                cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//                cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//                cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
//                cellStyle.setFont(font);
//                cellStyle.setWrapText(true);
//                
//                cellStyle2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//                cellStyle2.setFont(font2);
//                
//                cellStyle3.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//                cellStyle3.setBorderTop(HSSFCellStyle.BORDER_THIN);
//                cellStyle3.setBorderRight(HSSFCellStyle.BORDER_THIN);
//                cellStyle3.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//                cellStyle3.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//                cellStyle3.setFont(font3);
//                
//                @SuppressWarnings("MismatchedReadAndWriteOfArray")
//		String[] header= new String[11];
//	        header[0]  = "PT. PURA NUSAPERSADA - UNIT HOLOGRAFI";
//	        header[1]  = "LAPORAN PENERIMAAN JASA";
//                
//                /*
//                 * create header file
//                 */
//                HSSFCell cell;
//                HSSFRow rowHeader, subHeader, rowData;
//                sheet.addMergedRegion(new CellRangeAddress(0,0,0,4));
//                for(int i = 0; i<3; i++){
//                    rowHeader = sheet.createRow(i);
//                    cell = rowHeader.createCell(0);
//                    cell.setCellValue(header[i]);
//                    cell.setCellStyle(cellStyle2);
//                    sheet.addMergedRegion(new CellRangeAddress(i,i,0,4));
//                }
//                
//            rowHeader = sheet.createRow(4);
//            for(int i=0; i<12; i++){
//            	cell = rowHeader.createCell(i);
//            	cell.setCellStyle(cellStyle);
//            }
//            subHeader = sheet.createRow(5);
//            for(int i=0; i<12; i++){
//            	cell = subHeader.createCell(i);
//            	cell.setCellStyle(cellStyle);
//            }
//            cell = rowHeader.createCell(0);
//            cell.setCellValue("KODE REKENING");
//            cell.setCellStyle(cellStyle);
//            sheet.addMergedRegion(new CellRangeAddress(4,5,0,0));
//            sheet.setColumnWidth(0, 3500);
//
//            cell = rowHeader.createCell(1);
//            cell.setCellValue("ALOKASI BIAYA");
//            cell.setCellStyle(cellStyle);
//            sheet.addMergedRegion(new CellRangeAddress(4,5,1,1));
//           
//            cell = rowHeader.createCell(2);
//            cell.setCellValue("KODE DEPT");
//            cell.setCellStyle(cellStyle);
//            sheet.addMergedRegion(new CellRangeAddress(4,5,2,2));
//            
//            cell = rowHeader.createCell(3);
//            cell.setCellValue("TANGGAL");
//            cell.setCellStyle(cellStyle);
//            sheet.addMergedRegion(new CellRangeAddress(4,5,3,3));
//            
//            cell = rowHeader.createCell(4);
//            cell.setCellValue("KETERANGAN");
//            cell.setCellStyle(cellStyle);
//            sheet.addMergedRegion(new CellRangeAddress(4,5,4,4));
//            
//            cell = rowHeader.createCell(5);
//            cell.setCellValue("REF NO. LPB");
//            cell.setCellStyle(cellStyle);
//            sheet.addMergedRegion(new CellRangeAddress(4,4,5,6));
//            
//            cell = subHeader.createCell(5);
//            cell.setCellValue("INTR");
//            cell.setCellStyle(cellStyle);
//            
//            cell = subHeader.createCell(6);
//            cell.setCellValue("EX");
//            cell.setCellStyle(cellStyle);
//            
//            cell = rowHeader.createCell(7);
//            cell.setCellValue("QTY");
//            cell.setCellStyle(cellStyle);
//            sheet.addMergedRegion(new CellRangeAddress(4,5,7,7));
//            
//            cell = rowHeader.createCell(8);
//            cell.setCellValue("SAT");
//            cell.setCellStyle(cellStyle);
//            sheet.addMergedRegion(new CellRangeAddress(4,5,8,8));
//            
//            cell = rowHeader.createCell(9);
//            cell.setCellValue("HRG");
//            cell.setCellStyle(cellStyle);
//            sheet.addMergedRegion(new CellRangeAddress(4,5,9,9));
//            
//            cell = rowHeader.createCell(10);
//            cell.setCellValue("DEBET (Rp.)");
//            sheet.addMergedRegion(new CellRangeAddress(4,5,10,10));
//            cell.setCellStyle(cellStyle);
//            
//            cell = rowHeader.createCell(11);
//            cell.setCellValue("KREDIT (Rp.)");
//            sheet.addMergedRegion(new CellRangeAddress(4,5,11,11));
//            cell.setCellStyle(cellStyle);
//            int dataEnd = 0;
//            TableModel model = viewTable.getModel();
//            for(int i = 0; i<viewTable.getRowCount();i++){
//               rowData = sheet.createRow(i+6);
//               dataEnd = i+6;
//               for(int y = 0; y<(viewTable.getColumnCount())-1;y++){
//                 cell = rowData.createCell(y);
//                 cell.setCellValue(viewTable.getValueAt(i, y).toString());
//                 cell.setCellStyle(cellStyle3); 
//               }
//            }
//            
//            rowData = sheet.createRow(dataEnd);
//            cell = rowData.createCell(10);
//            cell.setCellValue("Total PPN LPJ : ");
//            cell.setCellStyle(cellStyle); 
//            
//           
//            sheet.setPrintGridlines(false);
//            cell = rowData.createCell(11);
//            cell.setCellValue(ppn);
//            cell.setCellStyle(cellStyle); 
//            //Kalo Lemot, script dibawah ini Penyebabnya
//            for(int i=0; i<12; i++){
//               sheet.autoSizeColumn(i, true);
//            }
//             sheet.getPrintSetup().setPaperSize(HSSFPrintSetup.LEGAL_PAPERSIZE);
//             workbook.setPrintArea(0, 0, 11, 0, dataEnd);
//            FileOutputStream outputStream = null;
//            try {                
//                 outputStream = new FileOutputStream("//192.168.17.102/File Invest/temp.xls");
//                 workbook.write(outputStream);
//                 outputStream.close();
////                 File file = new File("//192.168.17.102/File Invest/temp.xls");
//                 try{
//                    FileInputStream textStream;
//                    textStream = new FileInputStream("//192.168.17.102/File Invest/temp.xls");
//                    System.out.println("Here gagaa");
//                    DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
//                    Doc mydoc = new SimpleDoc(textStream, flavor, null);
//                    PrintRequestAttributeSet aset =
//                        new HashPrintRequestAttributeSet();
//                     PrintService[] services = PrintServiceLookup.lookupPrintServices(
//                                    flavor, aset);
//                       PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
//                       if(services.length == 0) {
//                           if(defaultService == null) {
//                                 System.out.println("Printer Not Found");
//                           } else {
//                                //print using default
//                                DocPrintJob job = defaultService.createPrintJob();
//                                job.print(mydoc, aset);
//                                 System.out.println("Here");
//                           }
//
//                        } else {
//                           System.out.println("Modyaaaar");
//                           //built in UI for printing you may not use this
//                           PrintService service = ServiceUI.printDialog(null, 200, 200, services, defaultService, flavor, aset);
//                            if (service != null)
//                            {
//                               DocPrintJob job = service.createPrintJob();
//                               job.print(mydoc, aset);
//                            }
//
//                        }                 
//                 }catch(Exception e){
//                     System.out.println("Modyaaaar"+e);
//                     e.printStackTrace();
//                 }
//                 
////                 Desktop.getDesktop().print(file);
//            } catch (FileNotFoundException ex) {
//                JOptionPane.showMessageDialog(null,"Print Failed \n" +ex, "Error", JOptionPane.ERROR_MESSAGE, null);
//            }
//        }catch(Exception e){
//
//        }

    }   
}
