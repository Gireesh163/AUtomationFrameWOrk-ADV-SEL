package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class HomePage extends SeleniumUtility { //Rule 1 - contact and logout
	
	// Rule 2 Identification/Declaration
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;
	
	// Rule 3 Intialization
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		//Rule 4 Utilization (right click - source generate getter and setter - all getter)

		public WebElement getContactLink() {
			return contactLink;
		}

		public WebElement getAdminstratorImg() {
			return adminstratorImg;
		}

		public WebElement getSignoutLink() {
			return signoutLink;
		}
		
// buisness Library
		/**
		 * this method used to click contact link
		 */
		public void clickOnContactLink()
		{
		contactLink.click();
		}
		
		/**
		 * this method is used to perform signout operation
		 * @param driver
		 * @throws Exception 
		 */
		public void logOutCLick(WebDriver driver) throws Exception 
		{
			mouseOverACtion(driver, adminstratorImg);
			Thread.sleep(1000);
			signoutLink.click();
		}
	
		

		
		
		
		

}
