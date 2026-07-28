package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsConcept {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		Thread.sleep(3000);

		//Create WebElement + Perform Actions(Click, Sendkeys, isDisplayed, getText)

		//1.By ID:
		//		driver.findElement(By.id("input-email")).sendKeys("testautomation@demo.com");
		//		driver.findElement(By.id("input-password")).sendKeys("automation123");

		//2.
		//		WebElement emailId=driver.findElement(By.id("input-email"));
		//		WebElement password=driver.findElement(By.id("input-password"));

		//		emailId.sendKeys("testautomation@demo.com");
		//		password.sendKeys("automation123");

		//3. By Locator: Advantage is maintaining Object Repository 
		//		By emailId=By.id("input-email");
		//		By password=By.id("input-password");
		//
		//		WebElement emailID=driver.findElement(emailId);
		//		WebElement pwd=driver.findElement(password);
		//
		//		emailID.sendKeys("testautomation@demo.com");
		//		pwd.sendKeys("automation123");

		//4. By Locator : generic function
		//		By email=By.id("input-email");
		//		By password=By.id("input-password");
		//
		//		getElement(email).sendKeys("testautomation@demo.com");
		//		getElement(password).sendKeys("automation123");

		//		//5. By Locator:generic functions (GE,Actions)
		//		By email=By.id("input-email");
		//		By password=By.id("input-password");
		//
		//		doSendKeys(email,"testautomation@demo.com");
		//		doSendKeys(password,"automation123");
		//
		//		//6. By Locator: generic functions (GE,actions) in a Utility class
		//		ElementUtil eleUtil=new ElementUtil(driver);
		//		eleUtil.doSendKeys(email,"testautomation@demo.com");
		//		eleUtil.doSendKeys(password,"automation123");
		//		
		//7. Use BrUtil 7 EleUtil


		//8 String Locators --
		String email_id="input-email";
		String password_id="input-password";
		ElementUtil eleUtil=new ElementUtil(driver);

		By email=eleUtil.getBy("id",email_id);
		By password=eleUtil.getBy("id",password_id);


		eleUtil.doSendKeys(email,"testautomation@demo.com");
		eleUtil.doSendKeys(password,"automation123");

		driver.close();

	}

	public static By getBy(String locatorType,String locatorValue) {

		By locator=null;
		switch(locatorType.toLowerCase()) {
		case "id":
			locator=By.id(locatorValue);
			break;

		default:
			break;

		}
		return locator;
	}


	public static WebElement getElement(By locator) {
		return driver.findElement(locator); 
	}

	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);



	}

}


