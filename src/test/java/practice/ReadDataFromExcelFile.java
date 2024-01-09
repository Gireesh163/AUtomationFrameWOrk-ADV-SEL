package practice;
import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadDataFromExcelFile {

	public static void main(String[] args) throws IOException {
		// step 1: Open the document in java readable format
		FileInputStream fis = new FileInputStream (".\\src\\test\\resources\\Test.xlsx");
		// step2 : create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		//step3 : navigate required sheet
		Sheet sh = wb.getSheet("Contacts");
		//step4 : navigate required row
				Row rw = sh.getRow(1); 
		//step5 : navigate required cell
				Cell cl = rw.getCell(2);
		//step5 : Capture the data inside the cell
				String value = cl.getStringCellValue();
		System.out.println(value);	
		// step 7: close the workbook
		wb.close();
	}
}
