package com.tests.practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static void main(String[] args) throws Exception {

		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("G:\\\\Selenium\\\\TestData.xlsx");
		XSSFWorkbook book=new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheet("Sheet1");
		int totalRows = sheet.getLastRowNum();
		int totalColumn=sheet.getRow(0).getPhysicalNumberOfCells();

		for(int i=0;i<totalRows;i++)
		{

			if(sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase("TC10"))
			{
				for(int j=0;j<totalColumn;j++)
				{
					if(sheet.getRow(0).getCell(j).getStringCellValue().equalsIgnoreCase("product"))
					{
						if(sheet.getRow(i).getCell(j).getCellType()==CellType.STRING)
						{
							System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
						}
						
						else if(sheet.getRow(i).getCell(j).getCellType()==CellType.NUMERIC)
						{
							System.out.println(sheet.getRow(i).getCell(j).getNumericCellValue());
						}
						
						
					}
				}

			}

		}

	}

}
