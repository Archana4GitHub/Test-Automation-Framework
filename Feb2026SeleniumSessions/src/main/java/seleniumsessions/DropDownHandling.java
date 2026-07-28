package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandling {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

		//			driver.get("https://www.saucedemo.com/inventory.html");
		//			Thread.sleep(2000);
		//			driver.findElement(By.id("user-name")).sendKeys("standard_user");
		//			driver.findElement(By.id("password")).sendKeys("secret_sauce");
		//			driver.findElement(By.id("login-button")).click();
		//			Thread.sleep(3000);
		//			driver.switchTo().alert().accept();
		//			
		//			
		//			WebElement country =driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select"));
		//			
		//			Select select=new Select(country);
		//			select.selectByIndex(2);

		//		driver.get("https://www.tutorialspoint.com/selenium/practice/select-menu.php");
		//		Thread.sleep(1000);
		//		driver.findElement(By.id("inputGroupSelect03"));
		//		
		//		WebElement selectOne=driver.findElement(By.id("inputGroupSelect03"));
		//		
		//		Select select=new Select(selectOne);
		//		select.selectByIndex(3);
		//		select.selectByValue("3");
		//		select.selectByVisibleText("Mrs.");

		driver.get("https://www.html-code-generator.com/drop-down/state-names");
		Thread.sleep(2000);

//		WebElement country=driver.findElement(By.id("user-country")); 
//
//		Select select =new Select(country);
//		select.selectByVisibleText("India");
//		Thread.sleep(1000);
//
//		WebElement state=driver.findElement(By.id("user-state")); 
//		
//		Select select1=new Select(state);
//		select1.selectByVisibleText("Bihar");
		
		By country=By.id("user-country");
		By state=By.id("user-state");
		
		doSelectByVisibleText(country,"India");
		Thread.sleep(2000);
		doSelectByVisibleText(state,"Bihar");
		
		

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doSelectByVisibleText(By locator,String text) {
		Select select=new Select(getElement(locator));
		select.selectByVisibleText(text);
		
	}
	
	public static void doSelectByValue(By locator,String text) {
		Select select=new Select(getElement(locator));
		select.selectByValue(text);;
	}
	
	public static void doSelectByIndex(By locator,int index) {
		Select select=new Select(getElement(locator));
		select.selectByIndex(index);
		
	}
}
