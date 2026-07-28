package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleBrowsers {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://google.com");

		String parentWindow=driver.getWindowHandle();

		//switching the domain: switch from 1 domain to another domain

		//		WebDriver driver1=new ChromeDriver();
		//		driver1.get("https://amazon.com");
		//		driver1.close(); 
		
		//with the same domain:
		//driver.navigate().to("amazon.com");
		
		//switching to different domain:
		driver.switchTo().newWindow(WindowType.WINDOW); //Child Window
		driver.get("https://amazon.com");
		Thread.sleep(1000);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();

		driver.switchTo().window(parentWindow); //Switching to Parent window
		Thread.sleep(1000);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.quit();


	}


}

