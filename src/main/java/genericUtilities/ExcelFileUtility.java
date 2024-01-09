package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this class consists of reusable method related to Excel file
 * @author GIREESH C S
 *
 */
public class ExcelFileUtility {
	/**
	 * this method read data from excel file and read value to caller
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws IOException
	 */

	public String readDataFromExcelFile(String sheetName, int rowNo,int cellNo) throws IOException
	{
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Test.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			String value = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue(); 
			return value;
	}
}
