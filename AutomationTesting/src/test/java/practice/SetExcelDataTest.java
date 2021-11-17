package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SetExcelDataTest {

	public static void main(String[] args) throws IOException {
		
		File f=new File("G:\\\\\\\\Selenium\\\\\\\\ExcelData.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook book=new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheet("Sheet1");
		
		sheet.getRow(2).createCell(2).setCellValue("Pass");
		sheet.getRow(3).createCell(2).setCellValue("Fail");
		FileOutputStream fos=new FileOutputStream(f);
		book.write(fos);
		book.close();


	}


}
