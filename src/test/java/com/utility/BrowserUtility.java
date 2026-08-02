package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private Logger logger = LoggerUtility.getLogger(this.getClass());
	private WebDriverWait wait;

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver); // Initialize through Instance variable driver!!!
		wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
	}

	public BrowserUtility(String browserName) {
		logger = LoggerUtility.getLogger(this.getClass());

		if (browserName.equalsIgnoreCase("chrome")) {

			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		}

		else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		}

		else {
			getLogger().error("Invalid Browser Name........Please Select chrome or Edge only.");

			System.err.println("Invalid Browser Name........Please Select chrome or Edge only. ");
		}
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		getLogger().info("Launching the Browser " + browserName);

		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old");// headless
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			} else {

				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			}
		}

		else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");// headless
				options.addArguments("disable-gpu");

				driver.set(new EdgeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			} else {
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			}

		} else if (browserName == Browser.FIREFOX) {
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");// headless
				options.addArguments("disable-gpu");

				driver.set(new FirefoxDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			} else {
				driver.set(new FirefoxDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			}
		}

		else {
			getLogger().error("Invalid Browser Name........Please Select chrome or Edge only.");

			System.err.println("Invalid Browser Name........Please Select chrome or Edge only. ");
		}
	}

	public void deleteCookies() {
		driver.get().manage().deleteAllCookies();

	}

	public void goToWebsite(String url) {
		getLogger().info("Visiting the website " + url);
		driver.get().get(url);
	}

	public void maximizeWindow() {
		getLogger().info("Maximizing the Browser Window");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		getLogger().info("Finding the Element with the locator " + locator);
		// WebElement element = driver.get().findElement(locator); // Find the element
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		getLogger().info("Element Found and now performing Click");

		element.click();
	}

	public void clickOnCheckBox(By locator) {
		getLogger().info("Finding the Element with the locator " + locator);
		// WebElement element = driver.get().findElement(locator); // Find the element
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		getLogger().info("Element Found and now performing Click");

		element.click();
	}

	public void clickOn(WebElement element) {

		getLogger().info("Element Found and now performing Click");

		element.click();
	}

	public void enterText(By locator, String textToEnter) {
		getLogger().info("Finding the Element with the locator " + locator);

		// WebElement element = driver.get().findElement(locator); // Find the element
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		element.sendKeys(textToEnter);
		getLogger().info("Element Found and now Entering the Text " + textToEnter);

	}

	public void clearText(By textBoxlocator) {
		getLogger().info("Finding the Element with the locator " + textBoxlocator);

		// WebElement element = driver.get().findElement(textBoxlocator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxlocator));

		getLogger().info("Element Found and clearing the text box field " + textBoxlocator);
		element.clear();

	}

	public void enterSpecialKey(By locator, Keys keyToEnter) {
		getLogger().info("Finding the Element with the locator " + locator);

		// WebElement element = driver.get().findElement(locator); // Find the element
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		element.sendKeys(keyToEnter);
		getLogger().info("Element Found and now enter the Special Key " + keyToEnter);
	}

	public String getVisibleText(By locator) {
		getLogger().info("Finding the Element with the locator " + locator);

		// WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		getLogger().info("Element Found and now returning the visible " + element.getText());

		return element.getText();

	}

	public String getVisibleText(WebElement element) {

		getLogger().info("Returning the visible Text " + element.getText());

		return element.getText();

	}

	public List<String> getAllVisibleText(By locator) {
		getLogger().info("Finding All the Elements with the locator " + locator);

		List<WebElement> elementList = driver.get().findElements(locator);
		getLogger().info("All Elements Found and now printing thee List of Elements");
		List<String> visibleTextList = new ArrayList<String>();

		for (WebElement element : elementList) {
			System.out.println(getVisibleText(element));
			visibleTextList.add(getVisibleText(element));
		}
		return visibleTextList;

	}

	public List<WebElement> getAllElements(By locator) {
		getLogger().info("Finding All the Elements with the locator " + locator);

		List<WebElement> elementList = driver.get().findElements(locator);
		getLogger().info("All Elements Found and now printing thee List of Elements");

		return elementList;

	}

	public void scrollToElement(By locator) {

		WebElement element = getDriver().findElement(locator);

		JavascriptExecutor js = (JavascriptExecutor) getDriver();

		js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
	}

	public void clickUsingJavaScript(By locator) {

		WebElement element = getDriver().findElement(locator);

		JavascriptExecutor js = (JavascriptExecutor) getDriver();

		js.executeScript("arguments[0].click();", element);
	}

	public boolean isSelected(By locator) {

		return getDriver().findElement(locator).isSelected();
	}

	public void selectFromDropDown(By dropDownLocator, String optionToSelect) {
		getLogger().info("Finding the Element with the locator " + dropDownLocator);
		WebElement element = driver.get().findElement(dropDownLocator);
		Select select = new Select(element);
		getLogger().info("Selecting the Option " + optionToSelect);
		select.selectByVisibleText(optionToSelect);
	}

	public String takeScreenShot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();

		File screenshotsData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path = "./screenshots/" + name + " - " + timeStamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotsData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	public Logger getLogger() {
		return logger;
	}
}
