package library;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	public XSSFWorkbook book;

	public ExcelDataConfig(String filePath)
	{
		try {
			FileInputStream fis=new FileInputStream(filePath);
			book=new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getData(int SheetNumber,int row, int column)
	{
		XSSFSheet sheet = book.getSheetAt(SheetNumber);
		String value=sheet.getRow(row).getCell(column).getStringCellValue();
		return value;
	}
	
	public String getCellData(String SheetName,String testCaseName,String Column)
	{
		XSSFSheet sheet = book.getSheet(SheetName);
		int totalRows = sheet.getLastRowNum();
		int totalColumn=sheet.getRow(0).getPhysicalNumberOfCells();
		String data = null;

		for(int i=0;i<=totalRows;i++)
		{

			if(sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(testCaseName))
			{
				for(int j=0;j<totalColumn;j++)
				{
					if(sheet.getRow(0).getCell(j).getStringCellValue().equalsIgnoreCase(Column))
					{
						if(sheet.getRow(i).getCell(j).getCellType()==CellType.STRING)
						{
							 data=sheet.getRow(i).getCell(j).getStringCellValue();
						}
						
						else if(sheet.getRow(i).getCell(j).getCellType()==CellType.NUMERIC)
						{
							
							double partial=sheet.getRow(i).getCell(j).getNumericCellValue();
							 data=NumberToTextConverter.toText(partial);
							
						}
						else if(sheet.getRow(i).getCell(j).getCellType()==CellType.FORMULA)
						{
							
							switch(sheet.getRow(i).getCell(j).getCachedFormulaResultType())
							{
							case BOOLEAN:
								Boolean partial2=sheet.getRow(i).getCell(j).getBooleanCellValue();
								data=partial2.toString();
								break;
							case NUMERIC:
								double partial1=sheet.getRow(i).getCell(j).getNumericCellValue();
								data=NumberToTextConverter.toText(partial1);
								break;
							case STRING:
								data=sheet.getRow(i).getCell(j).getStringCellValue();
								break;
							}
							 
							
						}
						
						
					}
				}

			}

		}

	return data;
	
		
	}

}
