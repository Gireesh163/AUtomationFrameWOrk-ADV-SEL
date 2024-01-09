package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.ContactInfoPage;
import objectRepository.ContactPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateContactTestUsingBaseClass extends BaseClass{
	// launching,login,logout all taken care by Base class
	@Test(groups ={"SmokeSuite","ReggressionSuite"})
	public void creatContactWithMandatoryField() throws Exception
	{						
			//*Read Test data from excel file*/
					
					String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 1, 2); 
					
					// step4: Click on contact link
					HomePage hp = new HomePage(driver);
					hp.clickOnContactLink();
					
					// step5: click on create contact look image
					ContactPage cp = new ContactPage(driver);
					cp.clickOnCreateContactLookUpImg();
					
					// step6: create new contact
				CreateNewContactPage cncp = new CreateNewContactPage(driver);
				cncp.createNewContact(LASTNAME);
					//Assert.fail(); // test will execute till it fail and in status it show failed
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
	}
}
