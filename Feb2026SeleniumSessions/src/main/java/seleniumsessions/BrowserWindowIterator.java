package seleniumsessions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowIterator {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		
		//Assignment: Not to close Parent window come back to parent window.
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

		String fbIcon="//img[@alt='facebook']";
		String linkedInIcon="//img[@alt='linkedin']";
		String xIcon="//img[@alt='youtube']";
		String youtubeIcon="//img[@src='/public/newweb/footer/youtube.png']";
		String instagramIcon="//img[@src='/public/newweb/footer/instagram.png']";
		
		WebElement eleFbIcon=waitForElementVisibility(fbIcon,10);
		elementIconClick(eleFbIcon);
		
		WebElement eleLinkedInIcon=waitForElementVisibility(linkedInIcon,10);
		elementIconClick(eleLinkedInIcon);
		
		WebElement eleXIcon=waitForElementVisibility(xIcon,10);
		elementIconClick(eleXIcon);
		
		WebElement youTubeIcon=waitForElementVisibility(youtubeIcon,10);
		elementIconClick(youTubeIcon);
		
		WebElement instaGramIcon=waitForElementVisibility(instagramIcon,10);
		elementIconClick(instaGramIcon);
		
		
		Set<String>handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		
		while(it.hasNext()) {
			String childWindowId=it.next();
			driver.switchTo().window(childWindowId);
			System.out.println(driver.getTitle());
			driver.close();
		}
	}
	//WebDriver Wait for visibility of Element
	public static WebElement waitForElementVisibility(String locator,int timeUnit) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeUnit));

		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))
				);
		return element;

	}

	//Scroll to view element and Click
	public static void elementIconClick(WebElement ele) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);

		Thread.sleep(2000);

		ele.click(); //Child Element

	}
}

