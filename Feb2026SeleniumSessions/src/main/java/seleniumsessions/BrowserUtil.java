package seleniumsessions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {

	public WebDriver driver;

	/*
	 * This method is used to initialize the driver on the basis of given browser
	 * @param browserName
	 * @return This returns the driver
	 */

	public WebDriver launchBrowser(String browserName) {
		System.out.println("browser name is: + " +browserName);

		if(browserName.equalsIgnoreCase("chrome")) {
			//System.setProperties("webdriver.chrome.driver", value);
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}

		else if(browserName.equalsIgnoreCase("firefox")){
			//System.setProperties("webdriver.gecko.driver",value);
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}

		else if(browserName.equalsIgnoreCase("edge")){
			WebDriverManager.chromedriver().setup();
			driver=new EdgeDriver();

		}

		else {
			System.out.println("Please Enter the correct Browser");
		}
		return driver;
	}



	public void launchUrl(String url) throws InterruptedException {
		if(url==null) {
			System.out.println("please pass the right url");
			return;
		}

		if(url.contains("https") || url.contains("http")) {
			driver.get(url);
			Thread.sleep(500);
		}

		else {
			driver.close();
			try {
				throw new Exception("INVALIDURLEXCEPTION-Please pass the right Url");
			}
			catch(Exception e) {
				e.printStackTrace();

			}

			System.out.println("please pass the right url with http(s)");
			return;
		}
	}
	
	public void launchUrl(URL url) throws InterruptedException{
		driver.navigate().to(url);
		Thread.sleep(2000);
	}

	public String getpageTitle() {
		return driver.getTitle();
	}

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}

}


