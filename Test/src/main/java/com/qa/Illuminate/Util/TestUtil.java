package com.qa.Illuminate.Util;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.qa.Illuminate.Base.TestBase;

public class TestUtil extends TestBase {

	static Workbook book;
	static Sheet sheet;

	public static String Sheetpath = "C:\\Users\\sh\\workspace\\Test\\src\\main\\java\\com\\qa\\Illuminate\\Testdata\\Logindata.xlsx";

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(Sheetpath);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {

			book = WorkbookFactory.create(file);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		sheet = book.getSheet(sheetName);

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
}