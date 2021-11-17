package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("G:\\\\Selenium\\\\ExcelData.xlsx");
		XSSFWorkbook book=new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheet("Sheet1");
		int totalRows = sheet.getLastRowNum();
		int totalColumn=sheet.getRow(0).getPhysicalNumberOfCells();
		
		for(int i=0;i<totalRows;i++)
		{
			for(int j=0;j<totalColumn;j++)
			{
			String data=sheet.getRow(i).getCell(j).getStringCellValue();
			System.out.println(data);
			}
		}
	}

}
