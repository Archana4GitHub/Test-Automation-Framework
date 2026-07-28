package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class MouseOverConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.devmedia.com.br/");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		//		WebElement contentEle=driver.findElement(By.className("menu-item-link"));
		//
		//		Actions action=new Actions(driver);
		//
		//		action.moveToElement(contentEle).perform();
		//
		//		driver.findElement(By.linkText("Iniciantes")).click();

		By parentMenu=By.className("menu-item-link");
		By childMenu=By.linkText("Iniciantes");
		//By subChildMenu=By.
		selectSubMenu(parentMenu,childMenu);
		//selectSubMenu(parentMenu,childMenu,subChildMenu);


	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void selectSubMenu(By parentMenu, By childMenu) throws InterruptedException {

		Actions action=new Actions(driver);

		action.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);

		getElement(childMenu).click();



	}

	public static void selectSubMenu(By parentMenu, By childMenu, By subChildMenu) throws InterruptedException {

		Actions action=new Actions(driver);

		action.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);

		action.moveToElement(getElement(childMenu)).perform();
		Thread.sleep(2000);


		getElement(subChildMenu).click();

	}

	public static void selectSubMenu(By parentMenu, By childMenu1, By subChildMenu2, By subChildMenu3) throws InterruptedException {

		Actions action=new Actions(driver);

		action.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);

		action.moveToElement(getElement(childMenu1)).perform();
		Thread.sleep(2000);

		action.moveToElement(getElement(subChildMenu2)).perform();
		Thread.sleep(2000);

		action.moveToElement(getElement(subChildMenu3)).perform();
		Thread.sleep(2000);

		getElement(subChildMenu3).click();



	}

}
