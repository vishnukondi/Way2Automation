package CommonFunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilFile {
	
	Workbook wb;
	
	
	public ExcelUtilFile() throws Throwable {
		
		FileInputStream fis = new FileInputStream("D:\\Testing\\HybridFrameWork_CRM\\Automation\\InputData\\TestData.xlsx");
	    wb= WorkbookFactory.create(fis);
	}
	
	public int rowCount(String sheetName) {
		return wb.getSheet(sheetName).getLastRowNum();
	}
	
	public int colCount(String sheetName, int rowNum) {
		return wb.getSheet(sheetName).getRow(rowNum).getLastCellNum();
	}
	
	
	public String getData(String sheetName, int rowNum, int colNum) {
		String data = "";
		if( wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getCellType()==Cell.CELL_TYPE_NUMERIC) {
			int cellData = (int) wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getNumericCellValue();
			data = String.valueOf(cellData);
		}
		else
		{
			data = wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getStringCellValue();
		}
		return data;
	}
	
	public void setData(String sheetName, int rowNum, int colNum, String data) throws Throwable {
		 wb.getSheet(sheetName).getRow(rowNum).createCell(colNum).setCellValue(data);
		// if(data.equalsIgnoreCase("Pass"))
		
		 FileOutputStream fos =  new FileOutputStream("D:\\Testing\\HybridFrameWork_CRM\\Automation\\InputData\\Output.xlsx");
		 wb.write(fos);
		 fos.flush();
		 fos.close();
	}
	
	

}
