package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NopCommerceSearch {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://demo.nopcommerce.com");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("book");
		Thread.sleep(3000);

		//Assignment: Generic Method : return list<String>with all suggestions

		List<WebElement> suggList=driver.findElements(By.xpath("//div[@role='search']//li//span"));
		for(WebElement e:suggList) {
			String sugOption=e.getText();	
			System.out.println("Suggestion Options:"+sugOption);
			if(sugOption.contains("Envy")) {
				e.click();
			}
		}

		/*
		 * Do Assignment: Google Search--Single xpath
		 * Automation Parctice: Suggestion List with for Loop
		 */


	}

}
