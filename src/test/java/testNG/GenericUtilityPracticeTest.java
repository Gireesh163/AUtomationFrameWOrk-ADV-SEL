package testNG;

import java.io.IOException;

import org.testng.annotations.Test;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;

public class GenericUtilityPracticeTest {

	@Test 
	public void genericUtilityPractice() throws IOException {
		
		PropertyFileUtility pUtil = new PropertyFileUtility();// first write RHS
		String value = pUtil.readDataFromPropertyFile("url");
		System.out.println(value);
		String value1 = pUtil.readDataFromPropertyFile("username");
		System.out.println(value1);
		String value2 = pUtil.readDataFromPropertyFile("password");
		System.out.println(value2);
		
		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String data = eUtil.readDataFromExcelFile("Contacts",1,1);
		System.out.println(data);
		
		
		JavaUtility jUtil = new JavaUtility();
		System.out.println(jUtil.getSystemDate());
	

	}

}
