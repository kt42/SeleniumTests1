package SeleniumTestPackage;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class BCPTest {
	
	public static void main(String[] args) {
	
	File file = new File("C:/chromedriver.exe");
	System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	WebDriver driver1 = new ChromeDriver();
	
	//driver1.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	driver1.manage().window().setSize(new Dimension(750, 750));
	driver1.manage().window().setPosition(new Point(800, 50));
	
	driver1.get("https://support.wdf.sap.corp/sap(bD1lbiZjPTAwMSZkPW1pbg==)/crm_logon/default.htm?saprole=ZCSSNEXTPROC");
	
	// Create an array (List) of all elements in in the webpage with the tagname iframes 
	List<WebElement> elements = driver1.findElements(By.tagName("iframe"));
	
	// count these "iframes" - only ever seems to be 1 - also can never actually find the iframe in the page source..?
	int itemCount = elements.size();
	
	System.out.println("a1" + itemCount);
	
	// load this iframe from the array into a WebElement variable 
	WebElement iFrameElement = elements.get(0);
	
	// get the outer html of the iframe (this will contain name, title, id etc...)
	String iFrameElementHTML = iFrameElement.getAttribute("outerHTML");
	
	// ***NOTE: the BCP page generates an iframe with a dynamic id each time. The search bar that we want to use is embedded in this dynamic iframe.
	//			luckily the iframe id is listed in the outerHTML - so we can pull it out and load just that iframe itself in a new tab
	//			**This must be a new tab as the iframe will use the cookies from the previous BCP launch to operate - so it is a single time usable iframe per launch
	
	// Get the unique runtime generated iframe id
	String uniqueIFrameID = StringUtils.substringBetween(iFrameElementHTML, "/sap(", ")/bc");
    
	System.out.println(iFrameElementHTML);
	String iFrameDirectURL = "https://support.wdf.sap.corp/sap(" + uniqueIFrameID + ")/bc/bsp/sap/crm_ui_frame/BSPWDApplication.do";
	
	
	String newTab = null;
    String baseTab = driver1.getWindowHandle();
    
    //driver1.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
    JavascriptExecutor js1 = (JavascriptExecutor) driver1; 
    js1.executeScript("window.open();");
	
	
	Set <String> allTabs = driver1.getWindowHandles();
		
	allTabs.remove(baseTab);
		
	Iterator<String> itr = allTabs.iterator();
		
	while(itr.hasNext()){		
		newTab = (String) itr.next();
	}
	
	driver1.switchTo().window(newTab);
	
	
	driver1.get(iFrameDirectURL);
	
	WebElement element1 = driver1.findElement(By.id("C14_W44_V45_inputID"));
	element1.sendKeys("Your Search String here baby");

	WebElement element2 = driver1.findElement(By.id("C14_W44_V45_Searchbtn"));
	element2.click();
	
	//System.out.println(lala);
	//System.out.println(elements);
	
	//driver1.switchTo().frame(newwwww);
	

	
	//https://support.wdf.sap.corp/sap(ZT1TVE0wTWprd05sOWZYMTlmTjE5Zk1USXhBSkQ2NW93aUh0aUhfemJhbzlxZ3p3PT0=)/bc/bsp/sap/crm_ui_frame/BSPWDApplication.do
	

    									//	ZT1TVE0wTWprd05sOWZYMTlmTjE5Zk1USXhBSkQ2NW82TUh0aUlnTWU4RXlCZzFnPT0=
	//https://support.wdf.sap.corp/sap(" + 	ZT1TVE0wTWprd05sOWZYMTlmTjE5Zk1USXhBSkQ2NW93aUh0aUhfemJhbzlxZ3p3PT0= + ")/bc/bsp/sap/crm_ui_frame/BSPWDApplication.do"

	//https://support.wdf.sap.corp/sap(ZT1TVE0wTWprd05sOWZYMTlmTjE5Zk1USXhBSkQ2NW93aUh0aUhfemJhbzlxZ3p3PT0=)/bc/bsp/sap/crm_ui_frame/BSPWDApplication.do
	
	//WebElement element1 = driver1.findElement(By.id("C14_W44_V45_inputID"));
	
	//List<WebElement> elements2 = driver1.findElements(By.tagName("iframe"));
	//int itemCount2 = elements2.size();

	//System.out.println("a2" + itemCount2);
	


	//System.out.println(elements2);
	
	//driver.switchTo().frame(elements.get(0));
	//do your stuff
	//driver.switchTo().defaultContent();
	
	
	
	//driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  //wait 5 secs for userid to be entered

	//WebElement element1 = driver1.findElement(By.id("C14_W44_V45_inputID"));
	//no such element: Unable to locate element: {"method":"id","selector":"C14_W44_V45_inputID"}
	
	//WebElement element1 = driver1.findElement(By.name("C14_W44_V45_searchnode_incidentnumber"));
	// no such element: Unable to locate element: {"method":"name","selector":"C14_W44_V45_searchnode_incidentnumber"}
	
	//WebElement element1 = driver1.findElement(By.cssSelector("input.th-if.th-ellipsis"));
	// no such element: Unable to locate element: {"method":"css selector","selector":"input.th-if th-ellipsis"}
	
	//<a href="#">Forgot Password? </a>
	//WebElement element1 = driver1.findElement(By.linkText("exact:* Release Notes"));
	
	//WebElement element1 = driver1.findElement(By.partialLinkText("Current"));
	
	//class="th-gr-td"
	//class="th-ip-sp th-ip-sp-no_icon th-if-wrapper th-onfocus"
	//class="th-if th-ellipsis"
	// input.
	
	//WebElement element1 = driver1.findElement(By.cssSelector("div.th-ip-sp.th-ip-sp-no_icon.th-if-wrapper.th-onfocus"));
	// no such element: Unable to locate element: {"method":"css selector","selector":"div.th-ip-sp.th-ip-sp-no_icon.th-if-wrapper.th-onfocus"}
	
	
	
	//WebElement element1 = driver1.findElement(By.id("C2_W11_V12_V74_Savebtn"));
	//no such element: Unable to locate element: {"method":"id","selector":"C2_W11_V12_V74_Savebtn"}

	
	

	//WebElement element1 = driver1.findElement(By.id("C14_W44_V45_inputID"));
	//element1.click();
	//element1.sendKeys("tdnejdsye");
	
	//WebElement element1 = driver1.findElement(By.xpath("//*[@id='C13_W41_V42_SavedSearches-btn']/img"));
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
