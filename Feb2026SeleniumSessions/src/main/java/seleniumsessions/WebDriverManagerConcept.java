package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerConcept {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * To Launch Firefox
		 * WebDriverManager.firefoxdriver().setup();
	       WebDriver driver=new FireFoxDriver(); //*
		 */

		//To Launch chrome 
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.get("https://www.amazon.com");
		Thread.sleep(500);
		String title=driver.getTitle();
		System.out.println("Title is: "+  title);

		driver.close();















	}

}
