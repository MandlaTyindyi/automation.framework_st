package TestUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReaderUtility {
	public static String[][] readExcelFile(String excelFilePath, String sheetName) throws IOException {
		
		String[][] data = null;   	
	  	try
	  	{
	   	FileInputStream fis = new FileInputStream(excelFilePath);
	   	XSSFWorkbook wb = new XSSFWorkbook(fis);
	   	XSSFSheet sh = wb.getSheet(sheetName);
	   	
	   	XSSFRow row = sh.getRow(0);//it was 0
	   	int noOfRows = sh.getPhysicalNumberOfRows();
	   	int noOfCols = row.getLastCellNum();
	   	
	   	XSSFCell cell;
	   	data = new String[noOfRows-1][noOfCols];
	   	
	   	for(int i =1; i<noOfRows;i++){
		     for(int j=0;j<noOfCols;j++){
		    	   row = sh.getRow(i);
		    	   cell= row.getCell(j);
		    	   data[i-1][j] = cell.getStringCellValue();
	   	 	   }
	   	}
	  	}
	  	catch (Exception e) {
	     	   System.out.println("The exception is: " +e.getMessage());
    }
    	return data;
	}


}
	


