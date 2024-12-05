package org.testcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DataRead {

	@Test
	public static String[][] readData(String fileName) throws IOException {
		
		FileInputStream input = new FileInputStream(System.getProperty("user.dir")+"\\data\\"+fileName+".xlsx");
		
		XSSFWorkbook book = new XSSFWorkbook(input);
		
		XSSFSheet sheet = book.getSheet("Sheet1");
		
		int rows = sheet.getLastRowNum();
		int cells = sheet.getRow(0).getLastCellNum();
		
		String data[][] = new String[rows][cells];
		for (int i = 1; i <=rows; i++) {
			XSSFRow row = sheet.getRow(i);
			
			for (int j = 0; j <cells; j++) {
				XSSFCell cell = row.getCell(j);
				String data1 = cell.getStringCellValue();
				
				System.out.println(data1);
				data[i-1][j]=data1;
			}
		}
		book.close();
		input.close();
		return data;

		
	}
}
