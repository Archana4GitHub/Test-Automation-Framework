package driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {
	private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return driverThreadLocal.get();
	}

	public static void initDriver(String browser) {
		if (getDriver() == null) {
			WebDriver driver;
			
			switch (browser.toLowerCase()) {
			
			case "chrome":
				ChromeOptions options = new ChromeOptions();
				driver = new ChromeDriver(options);
				break;
				
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				throw new IllegalArgumentException("Browser not supported: " + browser);
			}
			driver.manage().window().maximize();
			driverThreadLocal.set(driver);
		}
	}

	public static void quitDriver() {
		if (getDriver() != null) {
			getDriver().quit();
			driverThreadLocal.remove();
		}
	}
}
