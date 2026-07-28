package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableCheckBox {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		selectUserName("Joe.Root");
		selectUserName("John.Smith");




	}

	public static void selectUserName(String userName) throws InterruptedException {

		//Wait for Checkbox 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement checkBox = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'"+userName+"')]/parent::td/preceding-sibling::td/child::input[@type='checkbox']"))
				);


		//Scroll to view element and Click

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", checkBox);

		wait.until(ExpectedConditions.elementToBeClickable(checkBox));

		// wait little for page stabilization
		try {
			Thread.sleep(1000); 
		} catch (Exception e) {

		}

		// click using JS (bypasses overlay)
		js.executeScript("arguments[0].click();", checkBox);
	}

}

