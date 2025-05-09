package com.intense.als;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelOperations {
	ReadProperties rp = new ReadProperties();
	String filename = rp.readPro("ExcelPath");
	FileInputStream file = null;

	@SuppressWarnings("deprecation")
	public LinkedHashMap<String, String> readExcelData() {
		try {

			file = new FileInputStream(filename);
			
			try (XSSFWorkbook workbook = new XSSFWorkbook(file)) {
				String sheetname = rp.readPro("ExcelSheetname1");
				XSSFSheet sheet = workbook.getSheet(sheetname);
				LinkedHashMap<String, String> keyValueMap = new LinkedHashMap<>();
				System.out.println(sheet.getLastRowNum());
				for (Row row : sheet) {
					Cell keyCell = row.getCell(0);
					Cell valueCell = row.getCell(1);

					if (keyCell != null && valueCell != null) {
						String key = "";
						String value = "";
						switch (keyCell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							key = keyCell.getStringCellValue();
							break;
						case Cell.CELL_TYPE_NUMERIC:
							key = String.valueOf((int) keyCell.getNumericCellValue());
							break;
						}

						switch (valueCell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							value = valueCell.getStringCellValue();
							break;
						case Cell.CELL_TYPE_NUMERIC:
							value = String.valueOf((int) valueCell.getNumericCellValue());
							break;
						}
						keyValueMap.put(key, value);

					}

				}

				return keyValueMap;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return new LinkedHashMap<>();
	}

	@SuppressWarnings("deprecation")
	public String readExcelDataValue(String keyname) {
		try {

			file = new FileInputStream(filename);
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			String sheetname = rp.readPro("ExcelSheetname1");
			XSSFSheet sheet = workbook.getSheet(sheetname);
			LinkedHashMap<String, String> keyValueMap = new LinkedHashMap<>();
			// System.out.println(sheet.getLastRowNum());
			for (Row row : sheet) {
				Cell keyCell = row.getCell(0);
				Cell valueCell = row.getCell(1);

				if (keyCell != null && valueCell != null) {
					String key = "";
					String value = "";
					switch (keyCell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						key = keyCell.getStringCellValue();
						break;
					case Cell.CELL_TYPE_NUMERIC:
						key = String.valueOf((int) keyCell.getNumericCellValue());
						break;
					}

					switch (valueCell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						value = valueCell.getStringCellValue();
						break;
					case Cell.CELL_TYPE_NUMERIC:
						value = String.valueOf((int) valueCell.getNumericCellValue());
						break;
					}
					keyValueMap.put(key, value);

				}

			}
			return keyValueMap.get(keyname);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings({ "resource", "deprecation" })
	public String readExcel(int rnum, int cnum) {

		try {

			file = new FileInputStream(filename);
			XSSFWorkbook workbook = null;
			workbook = new XSSFWorkbook(file);
			String sheetname = rp.readPro("ExcelSheetname1");
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
		return "No value returned from this.";

	}

	@Test
	public void m1() throws IOException {

		/*
		 * Map<String, String> queryreslutInfoT = readExcelData("ALSSoap"); for
		 * (Map.Entry<String, String> queryreslutInfoTvalues :
		 * queryreslutInfoT.entrySet()) {
		 * System.out.println(queryreslutInfoTvalues.getKey() + " = " +
		 * queryreslutInfoTvalues.getValue());}
		 */
		System.out.println("--- " + readExcelDataValue("secretKey"));

	}

}
