package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class LoginPageTest {

	public static void main(String[] args) throws InterruptedException {

		BrowserUtil brUtil=new BrowserUtil();
		WebDriver driver=brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		String title=brUtil.getpageTitle();
		System.out.println(title);

		System.out.println(brUtil.getPageUrl());

		By email=By.id("input-email");
		By password=By.id("input-password");

		ElementUtil eleUtil=new ElementUtil(driver);
		eleUtil.doSendKeys(email,"testautomation@demo.com");
		eleUtil.doSendKeys(password,"automation123");

		brUtil.closeBrowser();







	}

}
