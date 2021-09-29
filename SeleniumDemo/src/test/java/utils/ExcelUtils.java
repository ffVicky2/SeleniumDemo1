package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public static void main(String[] args) {
		//getRowCount();
		getCellData();
	}
	
	public static void getRowCount() {
		
		try {	
			projectPath = System.getProperty("user.dir");
			workbook = new XSSFWorkbook(projectPath+"/excel/data.xlsx");
		    sheet = workbook.getSheet("Sheet1");	
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("Number of rows:" +rowCount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.getCause();
			e.printStackTrace();
		}
	}
	
	public static void getCellData() {		
		
		try {
			projectPath = System.getProperty("user.dir");
			workbook = new XSSFWorkbook(projectPath+"/excel/data.xlsx");
			sheet = workbook.getSheet("Sheet1");
			String cellData = sheet.getRow(0).getCell(2).getStringCellValue();
			double cellValue = sheet.getRow(1).getCell(1).getNumericCellValue();		
			System.out.println(cellData);
			System.out.println(cellValue);
		} catch (Exception e) {			
			System.out.println(e.getMessage());
			e.getCause();
			e.printStackTrace();
		}	  
		
	}

}
