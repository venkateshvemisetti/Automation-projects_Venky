package com.rjio.accelator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelOperations {
	ReadProperties rp = new ReadProperties();
	String filename = rp.readPro("ExcelPath");
	FileInputStream file = null;

	public String readExcelData(String sheetname, int r, int c) {

		try {
			file = new FileInputStream(filename);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {

			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet(sheetname);
		return sheet.getRow(r).getCell(c).getStringCellValue();

	}

	@SuppressWarnings("resource")
	public int readExcelNum(String sheetname, int r, int c) throws IOException {
		file = new FileInputStream(filename);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		return (int) sheet.getRow(r).getCell(c).getNumericCellValue();
	}

	@SuppressWarnings({ "resource", "deprecation" })
	public String readExcel(String sheetname, int rnum, int cnum) {

		try {

			file = new FileInputStream(filename);
			XSSFWorkbook workbook = null;
			workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(sheetname);
			Row row = sheet.getRow(rnum);
			Cell cell = row.getCell(cnum);
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				// System.out.println(cell.getStringCellValue());
				// System.err.println(sheet.getRow(rnum).getCell(cnum).getStringCellValue());
				return cell.getStringCellValue();
			case Cell.CELL_TYPE_NUMERIC:
				// System.out.println(cell.getNumericCellValue());
				// System.err.println(sheet.getRow(rnum).getCell(cnum).getNumericCellValue());
				return String.valueOf((int) (cell.getNumericCellValue()));

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Test
	public void m1() throws IOException {
		
		System.out.println(readExcel("RJIO_NE", 0, 0));

	}

}
