package com.maycur.thirdapitest.common.util;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Create by HuQiuYue on 2019-11-04
 */
public class ExcelUtil {

    public  List<String> ExcelToStrings(Workbook workbook,int sheetIndex,int colIndex) throws IOException {
        List<String> list = new ArrayList<>();
//        读取单个sheet
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        Iterator<Row>  rowIterator = sheet.rowIterator();

        while(rowIterator.hasNext()){
            Row row = rowIterator.next();
            if(row.getRowNum() != 0){
                list.add(row.getCell(colIndex).getStringCellValue());
            }
        }
        workbook.close();
        return list;
    }

    public List<String> sheets2Strings(Workbook workbook,int colIndex) throws IOException{
//        读取多个sheet
        List<String> list = new ArrayList<>();
        int numOfSheets = workbook.getNumberOfSheets();
        for(int i = 0;i < numOfSheets;i++){
            Sheet sheet = workbook.getSheetAt(i);
            Iterator<Row> rowIterator = sheet.rowIterator();
            while(rowIterator.hasNext()){
                Row row = rowIterator.next();
                if(row.getRowNum() != 0){
                    list.add(row.getCell(colIndex).getStringCellValue());
                }
            }
        }
        workbook.close();
        return list;
    }

}
