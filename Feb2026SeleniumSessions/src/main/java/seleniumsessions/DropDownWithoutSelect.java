package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownWithoutSelect {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.html-code-generator.com/drop-down/state-names");
		Thread.sleep(2000);

		//driver.findElement(By.id("user-country")).sendKeys("Haiti");

		By country=By.id("user-country");
		By state=By.id("user-state");

		List<WebElement> countryList=
				driver.findElements(By.xpath("//select[@id='country']//option"));
		for(WebElement e:countryList) {
			String text=e.getText();
			if(text.equals("Haiti")) {
				e.click();
				System.out.println("India is selected");
				break;
			}
		}
	}
}





