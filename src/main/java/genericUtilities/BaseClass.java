package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;
/**
 * this class is used to provide basic configuration
 * @author GIREESH C S
 *
 */
public class BaseClass {
	
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	
	public WebDriver driver;
	
	@BeforeSuite(groups ={"SmokeSuite","ReggressionSuite"})
	public void bsConfig()
	{
		System.out.println("=========== DB Connection Successful =========");
	}
	
	@Parameters("Browser")// for crossbrowser execution, and give parameter inside method in string
	@BeforeTest // use this for distributed parallel execution instead of beforeClass 
	//@BeforeClass(alwaysRun = true)
	public void bcConfig(String BROWSER) throws Exception
	{
		String URL = pUtil.readDataFromPropertyFile("url");
		if(BROWSER.equalsIgnoreCase("Edge"))
		{
		driver = new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		driver.get(URL);
		
		System.out.println("============== browser launched ==============");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("==========Login Successful=========");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws Exception
	{
		HomePage hp = new HomePage(driver);
		hp.logOutCLick(driver);
		
		System.out.println("======= LogOut Successful =======");
	}
	@AfterTest //use this for distributed parallel execution instead of beforeClass (incase of parallel execution in suites file we have split classes in separate test tag,by copy paste and delete one class, and also change test name.chnge parallel mode to test while saving suite by giving regression number )
	//@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		
		System.out.println("=========Browser closed============");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("=============== DB Connection CLosed============");
		
	}
}
