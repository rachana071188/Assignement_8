package com.assign.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Fileinfo {
	public String fileData(String keyvalue) throws IOException {
		try (FileInputStream fs = new FileInputStream("./src/test/resources/config/configs.properties")) {
	        Properties ps = new Properties();
	        ps.load(fs);
	        return ps.getProperty(keyvalue);
	    } catch (IOException e) {
	        e.printStackTrace(); // Handle or log the exception appropriately
	        return null; // Or throw a custom exception
	    }
	}
	
	
	
	
	
	public String datau(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fss=new FileInputStream("./src/test/resources/data_driven_config/datainfo.xlsx");
		Workbook workbook=WorkbookFactory.create(fss);
		Sheet sheet=workbook.getSheet(sheetName);
		 Row row = sheet.getRow(rowNum);
		 Cell cell = row.getCell(cellNum);
		String sx=cell.getStringCellValue();
		System.out.println(sx);
		return sx;
		
		
	}

}
