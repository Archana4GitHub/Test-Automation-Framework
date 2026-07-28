package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JsAlertPopUp {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		Thread.sleep(1000);

		driver.manage().window().maximize();
		Thread.sleep(3000);

		driver.findElement(By.name("login"));
		//driver.findElement(By.name("proceed")).click();
		
		//NoAlertPresentException: no such alert throws when alert is not there.
		

		Alert alert=driver.switchTo().alert(); //JS popup, confirmation, prompt
		Thread.sleep(3000);

		String text=alert.getText();
		System.out.println(text);

		//alert.sendKeys("testing");

		alert.accept(); //click on OK button
		//alert.dismiss(); //click on cancel button
		
		/*
		 * Assignment: 
		 * URL : https://the-internet.herokuapp.com/javascript_alerts
		 * Practice JavaScript Alert
		 * 
		 * Practice all scenarious and try to validate the RESULT displayed.
		 * 
		 * 
		 */







	}
}
