package excel.tests;

import com.excel.lib.util.Xls_Reader;

public class ExcelUtilTest {

	public static void main(String[] args) {

		Xls_Reader reader = new Xls_Reader("./src/main/java/com/excel/lib/util/SampleExcel.xlsx");
		String sheetName = "login";
		String data=reader.getCellData(sheetName, "username", 6);
		System.out.println(data);
		
		int rowCount=reader.getRowCount(sheetName);
		System.out.println(rowCount);
		
		//System.out.println(reader.addColumn(sheetName, "status"));
		
		if(!reader.isSheetExist("Registration"))
		{
			reader.addSheet("Registration");
		}
		reader.setCellData(sheetName, "status", 2, "PASS");
		System.out.println(reader.getCellData(sheetName, "username", 7));
		
		System.out.println(reader.getColumnCount(sheetName));
		//reader.removeColumn("Registration", 0);
		System.out.println(reader.getCellData("Registration", "phonenumber", 2));
		System.out.println(reader.getCellData("Registration", "age", 2));
		//String age=reader.getCellData("Registration", "age", 2);
		//System.out.println(age.split(".")[1]);
		
	}

}
