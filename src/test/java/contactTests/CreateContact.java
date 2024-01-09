package contactTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateContact { //only disadvantage of POM class is we cannot handle dynamic xpath(as it is creating during run time), we have to hard code in script

	public static void main(String[] args) throws Exception {
		// create object of required utility Classes
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		
			//* Read common data from property file*/
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
							
			//*Read Test data from excel file*/
					
					String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 1, 2); 
					
			// step 1 : Launch the base browser
					WebDriver driver = new EdgeDriver();
					sUtil.maximizeWindow(driver);
					sUtil.addImplicitlyWait(driver);
					
			// step 2: Load the application
					driver.get(URL);
					
					// stpe3: login to application
				LoginPage lp = new LoginPage(driver);
				lp.loginToApp(USERNAME, PASSWORD);// buisness library
					
					
					// step4: Click on contact link
					HomePage hp = new HomePage(driver);
					hp.clickOnContactLink();
					
					// step5: click on create contact look image
					ContactPage cp = new ContactPage(driver);
					cp.clickOnCreateContactLookUpImg();
					
					// step6: create new contact
				CreateNewContactPage cncp = new CreateNewContactPage(driver);
				cncp.createNewContact(LASTNAME);
					
					// step7: validate
				ContactInfoPage cip = new ContactInfoPage(driver);
				String contactHeader = cip.captureContactHeaderText();
					
							
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
						hp.logOutCLick(driver);
						// step10: close the browser
						driver.quit();
	}
}
