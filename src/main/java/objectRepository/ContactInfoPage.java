package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	WebElement contactHeaderText;
	
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactHeaderText() {
		return contactHeaderText;
	}

	// buisness lib
	/**
	 * This method capture ContactHeaderText and Return it
	 * @return
	 */
	public String captureContactHeaderText()
	{
		return contactHeaderText.getText();
	}
	
	

}
