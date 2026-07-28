package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DifferentLocators {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		Thread.sleep(1000);

		ElementUtil eleUtil=new ElementUtil(driver);


		//1. id: unique --I

		//2.name : can be duplicate --II
		//driver.findElement(By.name("email")).sendKeys("testautomation@demo.com");

		//		By email=By.name("email");
		//		By password=By.name("password");
		//
		//		eleUtil.doSendKeys(email,"testautomation@demo.com");
		//		eleUtil.doSendKeys(password,"automation123");

		//		String email_Id="email";
		//		String password="password";
		//
		//		eleUtil.doSendKeys(eleUtil.getBy("name",email_Id),"testautomation@demo.com");
		//		eleUtil.doSendKeys(eleUtil.getBy("name", password),"automation123");
		//
		//		By email_id=eleUtil.getBy("name",email_Id);
		//		eleUtil.doSendKeys(email_id,"testautomation@demo.com");

		//3. className: can be same for the different elements --Not recommended --III
		//		By email=By.className("form-control");
		//		driver.findElement(email).sendKeys("testautomation@demo.com");

		//4.X-path : it's not an attribute. This is the address of the element in html dom. 
		//		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("testautomation@demo.com");
		//		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("automation123");
		//		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();

//		By email=By.xpath("//*[@id=\"input-email\"]");
//		By password=By.xpath("//*[@id=\"input-password\"]");
//		By login=By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
//		eleUtil.doSendKeys(email,"testautomation@demo.com");
//		eleUtil.doSendKeys(password,"automation123");
//		eleUtil.doClick(login);

		//5.css selector: is not attribute.
		//driver.findElement(By.cssSelector("#input-email")).sendKeys("testautomation@demo.com");
		
		//6. linked text: only for links:
		//html tag:<a>
//		By registerLink=By.linkText("Register");
//		eleUtil.doClick(registerLink);
		
		//7. partialLinkText : only for links --used for longer linkTexts
		//Forgotten password
		//Forgotten username
		//It will always select the first link that matches on DOM.
		//Prefer to use partialLinkText when there is a long text links. Hardly to see.
		
//		By forgotPwdLink=By.partialLinkText("Forgotten"); 
//		eleUtil.doClick(forgotPwdLink);
		
		//8. tagName:html tag, not the attribute --Special UseCases
//		String text=driver.findElement(By.tagName("h2")).getText();
//		System.out.println(text );
		
		By header=By.tagName("h2");
		By register=By.linkText("Register");
		
		String text=eleUtil.doGetText(header);
		System.out.println(text);
		
		String regText=eleUtil.doGetText(register);
		System.out.println(regText);
		
		
		
		
		
		
		
		
		












	}

}
