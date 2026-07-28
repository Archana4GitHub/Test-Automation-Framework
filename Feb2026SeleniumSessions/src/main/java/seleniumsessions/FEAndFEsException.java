package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FEAndFEsException {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		Thread.sleep(1000);

		driver.manage().window().maximize();
		Thread.sleep(3000);

		//driver.findElement(By.id("global-menu-item-0g")).click();
		//NoSuchELementException

		List<WebElement> footerList=driver.findElements(By.xpath("//div[@class='sc-6293d692-0 eNMhGa']//li[@class='sc-6293d692-0 eNMhGah']//span"));
		System.out.println(footerList.size());

		//driver.findElements will not throw any Exception elements are not found.
		//Since it returns a List of WebElements so, if you check the size of List ,0 will be returned.
		//
		//		if(footerList.size()>0) {
		//			System.out.println("footers are present on the page....");
		//			for(WebElement e:footerList) {
		//				System.out.println(e.getText());
		//				System.out.println(footerList.size());
		//			}
		//
		//		}

		//A better way of checking the element is present or not.
		By footerLists=By.xpath("//div[@class='sc-6293d692-0 eNMhGa']//li[@class='sc-6293d692-0 eNMhGah']//span");
		System.out.println(isElementPresent(footerLists));
	}


	public static boolean isElementPresent(By locator) {
		if(getElements(locator).size()>0) {
			return true;

		}
		return false;
	}

	public static List<WebElement>getElements(By locator){
		return driver.findElements(locator);
	}
}




/* 
 * *****************************Exceptions******************************
 * 1. org.openqa.selenium.InvalidSelectorException: comes when locator is passed wrong.
 *  invalid selector: Unable to locate an element with the xpath expression //@@@div[@class='sc-ace17a57-0 hFnGrz']/ul 
 *
 * 2.StaleElementRefException
 * 3.ElementNotInteractableException: Element is there on page but not able to Interact
 * 4.ElementNotFoundException: Not in Selenium
 * 5.NoSuchSessionException: Quit and close 
 * 6.NoAlertException
 * 7.NoSuchElementException:Element itself not present on the page.
 */




















