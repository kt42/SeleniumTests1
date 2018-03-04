package SeleniumTestPackage;

import java.io.File;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BCPTest {
	
	public static void main(String[] args) {
	
	File file = new File("C:/chromedriver.exe");
	System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	WebDriver driver1 = new ChromeDriver();
	
	//wait 5 secs for userid to be entered
	//driver1.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	//driver1.manage().window().setSize(new Dimension(500, 500));
	//driver1.manage().window().setPosition(new Point(1000, 300));
	
	driver1.get("https://support.wdf.sap.corp/sap(bD1lbiZjPTAwMSZkPW1pbg==)/crm_logon/default.htm?saprole=ZCSSNEXTPROC");
	
	driver1.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);  //wait 5 secs for userid to be entered
	
	WebElement element1 = driver1.findElement(By.cssSelector("div.th-ip-sp.th-ip-sp-no_icon.th-if-wrapper.th-onfocus"));
	// no such element: Unable to locate element: {"method":"css selector","selector":"div.th-ip-sp.th-ip-sp-no_icon.th-if-wrapper.th-onfocus"}
	
	//WebElement element1 = driver1.findElement(By.cssSelector("input.th-if th-ellipsis"));
	
	
	
	//WebElement element1 = driver1.findElement(By.id("C2_W11_V12_V74_Savebtn"));

	element1.click();
	element1.sendKeys("tdnejdsye");
	
	//WebElement element1 = driver1.findElement(By.xpath("//*[@id='C13_W41_V42_SavedSearches-btn']/img"));
	//WebElement element1 = driver1.findElement(By.id("C14_W44_V45_inputID"));
	//driver1.findElement(By.cssSelector("input[value=\'css=#C14_W44_V45_Searchbtn > span > b']")).click();
	// driver.findElement(By.id("identifierNext")).click();
	
	
	/*
	WebDriver driver2 = new ChromeDriver();
	driver2.navigate().to("http://softwaretestingbooks.com/");
	String appTitle = driver2.getTitle();
	System.out.println("Application title is : "+appTitle); 
	driver2.quit();
	 */
	
	}
}
