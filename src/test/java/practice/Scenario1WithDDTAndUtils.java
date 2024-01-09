package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;

public class Scenario1WithDDTAndUtils {
public static void main(String[] args) throws IOException, InterruptedException {
	// create object of required utility Classes
	PropertyFileUtility pUtil = new PropertyFileUtility();
	ExcelFileUtility eUtil = new ExcelFileUtility();
	SeleniumUtility sUtil = new SeleniumUtility();
	
	
		//* Read common data from property file*/
	String URL = pUtil.readDataFromPropertyFile("url");
	String USERNAME = pUtil.readDataFromPropertyFile("username");
	String PASSWORD = pUtil.readDataFromPropertyFile("password");
				
				
		//*Read Test data from excel file*/
				
				String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 1, 1); 
				
		// step 1 : Launch the base browser
				WebDriver driver = new EdgeDriver();
				sUtil.maximizeWindow(driver);
				sUtil.addImplicitlyWait(driver);
				
				
				// step 2: Load the application
				driver.get(URL);
				
				// stpe3: login to application
				//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				//driver.findElement(By.id("submitButton")).click();
				
				LoginPage lp = new LoginPage(driver);
				//lp.getUsernameEdt().sendKeys(USERNAME);
				//lp.getPasswordEdt().sendKeys(PASSWORD);
				//lp.getLoginBtn().click();
				
				lp.loginToApp(USERNAME, PASSWORD);// buisness library
				
				
				// step4: Click on contact link
				driver.findElement(By.linkText("Contacts")).click();
				
				// step5: click on create contact look image
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				
				// step6: create new contact
				driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
				
				//step7: save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				// step8: validate
					String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
					
						
							if(contactHeader.contains(LASTNAME))
							{
								System.out.println(contactHeader);
								System.out.println("pass");
							}
							else
							{
								System.out.println("fail");
							}
					// step9: logout of application
					WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
					sUtil.mouseOverACtion(driver, ele);
					
					Thread.sleep(1000);
					driver.findElement(By.linkText("Sign Out")).click();
					// step10: close the browser
					driver.quit();
					
	}

}
