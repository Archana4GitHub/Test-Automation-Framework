package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);



		//		WebElement rightClickEle=driver.findElement(By.xpath("//span[text()='right click me']"));
		//
		//		Actions act=new Actions(driver);
		//		act.contextClick(rightClickEle).perform();
		//
		//		List<WebElement> itemsList=
		//				driver.findElements(By.xpath("//ul[@class='context-menu-list context-menu-root']//span"));
		//		System.out.println(itemsList.size());
		//
		//		for(WebElement e:itemsList) {
		//			String text=e.getText();
		//			System.out.println(text);
		//			if(text.equals("Copy")) {
		//				e.click();
		//				break;
		//			}
		//		}

		By rightClick=By.xpath("//span[text()='right click me']");
		By rightClickOptions=By.xpath("//ul[@class='context-menu-list context-menu-root']//span");
		selectRightClickMenu(rightClick,rightClickOptions,"Copy");
		getRightClickOptionsList(rightClick,rightClickOptions);
		System.out.println(getRightClickOptionsCount(rightClick,rightClickOptions));

		if(getRightClickOptionsCount(rightClick,rightClickOptions)==6) {
			System.out.println("PASS");
		}

		driver.close();
	}

	public static void doContextClick(By locator) {
		Actions action=new Actions(driver);
		action.contextClick(getElement(locator)).perform();
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);

	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);

	}

	public static List<String> getRightClickOptionsList(By rightClick, By rightClickOptions) {
		//WebElement rightClickEle=getElement(rightClick);
		List<String> rightClickItems=new ArrayList<String>();


		doContextClick(rightClick);

		List<WebElement> itemsList=
				getElements(rightClickOptions);

		System.out.println(itemsList.size());

		for(WebElement e:itemsList) {
			String text=e.getText();
			System.out.println(text);
			rightClickItems.add(text);
		}

		return rightClickItems;
	}

	public static int getRightClickOptionsCount(By rightClick,By rightClickOptions) {
		return getRightClickOptionsList(rightClick,rightClickOptions).size();
	}

	public static void selectRightClickMenu(By rightClick, By rightClickOptions,String option) {

		//WebElement rightClickEle=getElement(rightClick);

		doContextClick(rightClick);

		List<WebElement> itemsList=
				getElements(rightClickOptions);

		System.out.println(itemsList.size());

		for(WebElement e:itemsList) {
			String text=e.getText();
			System.out.println(text);
			if(text.equals(option)) {
				e.click();
				break;
			}
		}


	}
}



