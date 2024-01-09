package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;


public class Scenario1 {

	public static void main(String[] args) throws InterruptedException {
		// step 1 : Launch the base browser
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// step 2: Load the application
		driver.get("http://localhost:8888");
		
		// stpe3: login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		// step4: Click on contact link
		driver.findElement(By.linkText("Contacts")).click();
		
		// step5: click on create contact look image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		// step6: create new contact
		driver.findElement(By.name("lastname")).sendKeys("Punarv");
		
		//step7: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		// step8: validate
			String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			
				
					if(contactHeader.contains("Punarv"))
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
			Actions act = new Actions(driver);
			act.moveToElement(ele).perform();
			Thread.sleep(1000);
			driver.findElement(By.linkText("Sign Out")).click();
			// step10: close the browser
			driver.quit();
			
		
	}

}
