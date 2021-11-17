package practice;

import library.ExcelDataConfig;

public class ExcelData {

	public static void main(String[] args) {
		
		ExcelDataConfig exc=new ExcelDataConfig("G:\\Selenium\\ExcelData.xlsx");
		String data=exc.getData(0, 0, 0);
		System.out.println(data);
		
		ExcelDataConfig esc=new ExcelDataConfig("G:\\Selenium\\TestData.xlsx");
		String cellData = esc.getCellData("Sheet1", "TC14", "appname");
		System.out.println(cellData);
		
		
	}

}
