package base;

import config.ConfigReader;
import driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class BaseTest {

 @BeforeMethod
 public void setUp() {
 String browser = ConfigReader.getProperty("browser");
 DriverManager.initDriver(browser);
 
 int timeout = Integer.parseInt(ConfigReader.getProperty("timeout"));
 DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
 
 String env = ConfigReader.getProperty("environment");
 String url = ConfigReader.getProperty(env + ".url");
 DriverManager.getDriver().get(url);
 }

 @AfterMethod
 public void tearDown() {
 DriverManager.quitDriver();
 }
}