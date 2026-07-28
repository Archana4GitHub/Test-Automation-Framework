package seleniumsessions;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		
		driver.findElement(By.name("q")).sendKeys("Naveen Automation Labs");
		Thread.sleep(3000);
		
		List<WebElement> suggList=
				driver.findElements(By.xpath("//ul[@role='listbox']/li//div[@class='wM6W7d']//span"));
		
		for(WebElement e:suggList)
		{
			String text=e.getText();
			System.out.println(text);
			if(text.contains("youtube")) {
				e.click();
				break;
			}
		}
		

	}
}

