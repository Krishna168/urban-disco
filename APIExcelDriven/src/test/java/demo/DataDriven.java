package demo;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public ArrayList<String> getData(String testCaseName) throws IOException {

		ArrayList<String> d = new ArrayList<String>();

		FileInputStream fis = new FileInputStream("G:\\Rest API\\APIExcelDriven.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();
		// System.out.println(sheets);

		for (int i = 0; i < sheets; i++) {

			if (workbook.getSheetName(i).equals("testdata")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();
				Iterator<Cell> ce = firstRow.cellIterator();
				int k = 0;
				int column = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();
					if (value.getStringCellValue().equalsIgnoreCase("Testcases")) {
						column = k;
					}
					k++;
				}
				while (rows.hasNext()) {

					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
						Iterator<Cell> dr = r.cellIterator();
						while (dr.hasNext()) {
							Cell c = dr.next();
							if (c.getCellType() == CellType.STRING) {
								d.add(c.getStringCellValue());
							} else {
								d.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}

						}
					}
					workbook.close();
				}
			}
		}
		return d;
	}

}
