package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * this class consists of reusable method related Selenium tool
 * @author GIREESH C S
 *
 */

public class SeleniumUtility {
	/**
	 * this method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * this method will minimize the window
	 * @param driver
	 */
	public void miniimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * this method will fullscreen the window
	 * @param driver
	 */
	public void fullScreenWindow(WebDriver driver)
	{
		driver.manage().window().fullscreen();
	}
	/**
	 * this method will implicitly wait for 10sec for all web element to load
	 * @param driver
	 */
	public void addImplicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * this method will wait for 10 seconds for a particular web element to visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)//explictlywait
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * this method will wait for 10 seconds for a particular web element to clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)//explictlywait
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * this method will handle dropdown by index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * this method will handle dropdown by value
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element, String value)// overloadded method of privious method
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * this method will handle dropdown by visible text
	 * @param element
	 * @param value
	 */
	public void handleDropdown( String text,WebElement element)// overloadded method of privious method
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * this method is used to perform mouse hovering action on a web element
	 * @param driver
	 * @param element
	 */
	public void mouseOverACtion(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * this method is used to perform right click action on a web element
	 * @param driver
	 * @param element
	 */
	public void rightClickACtion(WebDriver driver,WebElement element) { 
		Actions act=new Actions(driver); 
		act.contextClick(element).perform(); 
		}
	/**
	 * this method is used to perform double click action on a web element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * this method is used to perform drag and drop action on a web element
	 * @param driver
	 * @param element1
	 * @param element2
	 */
	public void dragAndDropAction(WebDriver driver,WebElement srcEle,WebElement dstEle) {
		Actions act=new Actions(driver);
		act.dragAndDrop(srcEle,dstEle).perform();
	}
	/**
	 * this method is used to perform scrolldown action on a web element
	 * @param driver
	 */
	public void scrollDownAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;// interface
		js.executeScript("window.scrollBy(0,500);", "");// java script snippet
	}
	/**
	 * this method is used to perform scrollup action on a web element
	 * @param driver
	 */
	public void scrollUpAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;// interface
		js.executeScript("window.scrollBy(0,-500);", "");// java script snippet
	}
	/**
	 * this method is used to perform scroll right action on a web element
	 * @param driver
	 */
	public void scrollRightAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;// interface
		js.executeScript("window.scrollBy(50,0);", "");// java script snippet
	}
	/**
	 * this method is used to perform scroll left action on a web element
	 * @param driver
	 */
	public void scrollLeftAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;// interface
		js.executeScript("window.scrollBy(-50,0);", "");// java script snippet
	}
	// POPUP
	/**
	 * this method will accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * this method will cancel the alert popup
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * this method will capture the text in the alert popup and return to caller
	 * @param driver
	 * @return 
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	/**
	 * This method handle frame by frame index
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrame(WebDriver driver,int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
	}
	/**
	 * This method handle frame by frameName or Id
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrame(WebDriver driver,String frameNameID)
	{
		driver.switchTo().frame(frameNameID);
	}
	/**
	 * This method handle frame by frame Element
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrame(WebDriver driver,WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	/**
	 * this method will capture the screenshot and return the path to the caller
	 * @param driver
	 * @param screenShotname
	 * @return
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver, String screenShotname) throws IOException 
	{
	TakesScreenshot ts = (TakesScreenshot) driver;
	File src = ts.getScreenshotAs(OutputType.FILE);// temprovery dest
	File dst = new File(".\\Screenshots\\"+screenShotname+"+.png");// create screenshot folder in maven project and copy paste the path
	Files.copy(src, dst);
	return dst.getAbsolutePath();// attaching the screenshot to extent report
	}
	/**
	 * this method is used switch the control to required window based on title
	 * @param driver
	 * @param expPartialTitle
	 */
	public void handleWindow(WebDriver driver,String expPartialTitle)
	{
		// capture all the window IDs
		Set<String> allWinIds = driver.getWindowHandles();
		//Navigate through each window IDs
		for(String winId:allWinIds)
		{
			//switch all all window IDs and capture Title
			String actTitle = driver.switchTo().window(winId).getTitle();
			// compare the window ID
			if(actTitle.contains(expPartialTitle))
			{
				break;
			}
		}
	}
	
}
