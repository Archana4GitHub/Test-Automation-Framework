package seleniumsessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandleWithList {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		//Launching the Browser
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

		//Maximize Window Screen
		driver.manage().window().maximize();

		driver.get("https://www.orangehrm.com/en/30-day-free-trial");//Parent window
		Thread.sleep(3000);

		driver.findElement
		(By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']"))
		.click();

		//Wait for Facebook Icon
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement fbIcon = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='facebook']"))
				);


		//Scroll to view element and Click
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", fbIcon);

		Thread.sleep(2000);

		fbIcon.click(); //Child Element

		Set<String> handles =driver.getWindowHandles();
		List<String>handlesList=new ArrayList<String>(handles);

		for(String e:handlesList) {
			System.out.println(e);
		}

		String parentWindowId=handlesList.get(0);
		String childWindowId=handlesList.get(1);

		driver.switchTo().window(childWindowId);
		System.out.println(driver.getTitle());
		driver.close();

		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getTitle());

		driver.quit();
	}
}

