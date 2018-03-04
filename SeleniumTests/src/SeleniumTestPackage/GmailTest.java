package SeleniumTestPackage;


import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class GmailTest {
	
	////
	////
	public static void main(String[] args) {
		
		/////
		
		////
		///
		///
		
		File file = new File("C:/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		WebDriver driver1 = new ChromeDriver();
		//wait 5 secs for userid to be entered
		//driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		////
		
		driver1.get("http://www.gmail.com");

		// Enter userd id
		WebElement element = driver1.findElement(By.id("identifierId"));
		element.sendKeys("bill44@gmail.com");
		driver1.findElement(By.id("identifierNext")).click();
		
		
		/*
		

		//wait 5 secs for userid to be entered
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//Enter Password
		WebElement element1 = driver.findElement(By.id("Passwd"));
		element1.sendKeys("Password");

		//Submit button
		element.submit();

		WebElement myDynamicElement = (new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(By.id("gbg4")));
		driver.findElement(By.id("gbg4")).click();

		//press signout button
		driver.findElement(By.id("gb_71")).click();
		
		
		
		
		 */
	
	
}

}
