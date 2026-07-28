package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementDisplayed {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		Thread.sleep(1000);

		ElementUtil eleUtil=new ElementUtil(driver);

		By emailId=	By.id("input-email11");
		//		boolean flag=driver.findElement(emailId).isDisplayed();
		//		System.out.println(flag);

		//		if(eleUtil.doIsDisplayed(emailId)){
		//		eleUtil.doSendKeys(emailId,"archana@test.com");
		//		}

		//		boolean flag=driver.findElement(emailId).isEnabled();
		//		System.out.println(flag);

//		if(eleUtil.doIsEnabled(emailId)) {
//			eleUtil.doSendKeys(emailId,"archie@test");
//		}

		driver.findElement(emailId).sendKeys("srchie@test");
		//findElement method throws NoSuchElementException - If no matching elements are found
		//ElementNotFoundException -- Not a Selenium Exception at all



	}

}
