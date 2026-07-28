package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTabHandle {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {


		//Assignment: Not to close Parent window come back to parent window.
		//Launching the Browser
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//Maximize Window Screen
		driver.manage().window().maximize();

		driver.get("https://amazon.com");

		String parentWindowId=driver.getWindowHandle();

		driver.switchTo().newWindow(WindowType.TAB); //sel 4.x

		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		driver.close(); //close the child window

		//back to parent window
		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getTitle());



		//		driver.get("https://www.orangehrm.com/en/30-day-free-trial");//Parent window
		//		Thread.sleep(3000);
		//
		//		driver.findElement
		//		(By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']"))
		//		.click();

	}
}
