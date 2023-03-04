package com.excelreader;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExcelUtil {
    Logger logger=Logger.getLogger(this.getClass().getName());
    private  XSSFWorkbook workbook;

    public void loadExcelFile(){
        try{
            logger.log(Level.INFO,"Loading Excel File");
            File file=new File("src/test/resources/Testdata/challenge.xlsx");
            FileInputStream fis=new FileInputStream(file);
            workbook=new XSSFWorkbook(fis);
            logger.log(Level.INFO,"Excel File loaded Successfully");
        }catch (Exception e){
            logger.log(Level.SEVERE,"Failed to load Excel File , Error : "+e.getMessage());
        }
    }

    private int getRowCount(String sheetName){
       return workbook.getSheet(sheetName).getLastRowNum();
    }

    private int getColCount(String sheetName){
        return workbook.getSheet(sheetName).getRow(0).getLastCellNum();
    }

    private int searchColumn(String sheetName,String colName){
        int colFound=0;
        int colCount=getColCount(sheetName);
        for(int c=0;c<=colCount;c++){
          String colHeader=workbook.getSheet(sheetName).getRow(0).getCell(c).getStringCellValue();
          if(colHeader.trim().equals(colName)){
              colFound=c;
              break;
          }
        }
        return colFound;
    }

    private int searchRow(String sheetName,String testCaseName){
        int rowFound=0;
        int rowCount=getRowCount(sheetName);
        for(int r=0;r<=rowCount;r++){
            String tcName=workbook.getSheet(sheetName).getRow(r).getCell(0).getStringCellValue();
            if(tcName.trim().equals(testCaseName)){
                rowFound=r;
                break;
            }
        }
        return rowFound;
    }


    public String getData(String sheetName,String testCaseName,String colName) {
        int row = searchRow(sheetName, testCaseName);
        int col = searchColumn(sheetName, colName);
        String data = "";
        switch (workbook.getSheet(sheetName).getRow(row).getCell(col).getCellType()) {
            case STRING:
                data = workbook.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
                System.out.println(data);
                break;
            case NUMERIC:
                data = String.valueOf(workbook.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue());
                System.out.println(data);
                break;
        }
        return data;
    }



}
