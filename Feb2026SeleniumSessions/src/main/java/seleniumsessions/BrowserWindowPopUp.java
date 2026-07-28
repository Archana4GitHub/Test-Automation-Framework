package seleniumsessions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowPopUp {
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
		
		//Window Handles Concept
		//Set: it doesn't accept duplicate value and order is not maintained.
		//Use iterator to iterate Set.

		Set<String> handles =driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		
		String parentWindowId=it.next();
		System.out.println("parent window Id: "+parentWindowId);

		String childWindowId =it.next();
		System.out.println("child window Id: "+childWindowId);

		//driver.switchTo().window(null);
		
		driver.switchTo().window(childWindowId); //driver is switched to child window
		
		String childWindowTitle=driver.getTitle();
		System.out.println("child window title: "+childWindowTitle);
		
		driver.close(); //close the child window--driver is lost here
		
		//driver is lost unless you again switch driver to parent window
		
		//driver.switchTo().window(parentWindowId);  //driver is switched to parent window
		//if without switching, you are interacting with parent window:
		//it will throw :NoSuchWindowException: no such window: target window already closed
		
		String parentWindowTitle=driver.getTitle();
		System.out.println("Parent Window title: "+parentWindowTitle);
		
		driver.close();
		
		driver.switchTo().window(parentWindowTitle);
		
		//driver.quit();

	}
}


