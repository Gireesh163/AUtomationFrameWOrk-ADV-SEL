package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class CreateNewContactPage extends SeleniumUtility {
	@FindBy(name="lastname")
	WebElement lastnameEdt;
	
	@FindBy(xpath  ="//input[@title='Save [Alt+S]']")
	WebElement saveEdt;
	
	@FindBy(name="leadsource")
	WebElement leadSourceDropDown;
	
	
public CreateNewContactPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}


public WebElement getLastnameEdt() {
	return lastnameEdt;
}

public WebElement getSaveEdt() {
	return saveEdt;
}

public WebElement getLeadSourceDropDown() {
	return leadSourceDropDown;
}

//Buisness lib
/**
 * this method is used to create new contact
 * @param LASTNAME
 */
public void createNewContact(String LASTNAME)
{
	lastnameEdt.sendKeys(LASTNAME);
	saveEdt.click();
}

/**
 * this method used to create new contact with lead source value
 * @param LASTNAME
 * @param LEADSOURCEVALUE
 */
public void createNewContact(String LASTNAME, String LEADSOURCEVALUE)
{
	lastnameEdt.sendKeys(LASTNAME);
	handleDropdown(leadSourceDropDown, LEADSOURCEVALUE);
	saveEdt.click();
}
}
