package com.actitme.generics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class FileLib {
	/**
	 * generic method for reading the data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyFileData(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./data/commondata.properties.txt");
		Properties p=new Properties();
		p.load(fis);
		String value =p.getProperty(key);
		return value;
	}
	/**
	 * read the data from the Excel file
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return String data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
public String getExcelData(String path, String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream(path);
	//open the excel in the readable format
	Workbook wb=WorkbookFactory.create(fis);
	String data = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	return data;
}
/**
 * write the data back to excel
 * @param path
 * @param sheetname
 * @param row
 * @param cell
 * @param value
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public void setExcelData(String path,String sheetname,int row,int cell, String value) throws EncryptedDocumentException, IOException {
	//convert external resource file into java readable object
			FileInputStream fis=new FileInputStream(path);
			//open the excel in the readable format
			Workbook wb=WorkbookFactory.create(fis);
			 wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
			//get java file object in write mode
			FileOutputStream fos= new FileOutputStream("./data/testscriptdata.xlsx"); 
			//save the workbook in write mode
			wb.write(fos);
			wb.close();
}
}

