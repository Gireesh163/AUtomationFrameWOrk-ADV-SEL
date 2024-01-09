package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //Rule 1  // only disadvantage of POM class is we cannot handle dynamic xpath(as it is creating during run time), we have to hard code in script
	
	// Rule 2 Identification/Declaration
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password") 
	private WebElement passwordEdt;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath = "//input[@type='submit']")})
	private WebElement loginBtn;
	
	// Rule 3 Intialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4 Utilization (right click - source generate getter and setter - all getter)
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	// Buisness Libraray - Generic method - operate on element in current POM class only
	/**
	 * This method will perform login operation
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApp(String USERNAME, String PASSWORD)
	{
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
	
	
	
	
	

}
