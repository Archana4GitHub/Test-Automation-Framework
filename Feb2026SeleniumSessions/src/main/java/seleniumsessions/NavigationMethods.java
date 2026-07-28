package seleniumsessions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationMethods {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {

		//To Launch the Browser
		WebDriverManager.chromedriver().setup();
		//WebDriverManager.chromedriver().browserVersion("89.0").setup();
		WebDriver driver=new ChromeDriver();

		//To Load your webpage 
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		Thread.sleep(1000);

		/*
		 * To Load your webpage using URL
		   driver.navigate().to(new URL("https//www.amazon.com"));
		   Thread.sleep(1000);
		   System.out.println(driver.getTitle());
		 */

		//To Load your webpage
		driver.navigate().to("https://amazon.com");
		Thread.sleep(1000);
		System.out.println(driver.getTitle());

		//To navigate to previous page
		driver.navigate().back();
		Thread.sleep(1000);
		System.out.println(driver.getTitle());

		//To navigate to Forward page
		driver.navigate().forward();
		Thread.sleep(1000);
		System.out.println(driver.getTitle());

		//To refresh the webpage
		driver.navigate().refresh();

		//To close all opened window
		driver.quit();




	}

}
