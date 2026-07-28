package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQueryDropDownHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@type='text' and @class='comboTreeInputBox'  and @id='justAnInputBox']")).click();
		Thread.sleep(5000);

		//		List<WebElement> choiceLists= driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		//		//Thread.sleep(2000);
		//		for(WebElement e:choiceLists) {
		//			String text=e.getText();
		//			System.out.println(text);
		//			if(text.equals("choice 1") ) {
		//				e.click();
		//				break;
		//			}
		//		}

		By choices=By.xpath("//span[@class='comboTreeItemTitle']");

		//tc_01: single selection:
		selectChoice(choices,"choice 1");

		//tc_02: single selection:
		//selectChoice(choices,"choice 1","choice 2","choice 6 2 2","choice 7");

		//tc_03: all selection:
		//selectChoice(choices,"all");

		//Assignment:1. First select all and then deselect all using Generic method.
		//2. Try Single Selection and Multi Selection with Cascade option Select on same URL
		
	}

	public static List<WebElement> getElement(By locator) {
		return driver.findElements(locator);
	}

	public static void selectChoice(By locator,String... value) {
		List<WebElement> choiceLists=getElement(locator);

		if(!value[0].equalsIgnoreCase("all")) {
			for(WebElement e:choiceLists) {
				String text=e.getText();

				for(int i=0;i<value.length;i++) {
					if(text.equals(value[i])) {
						e.click();
						break;
					}
				}

			}
		}


		else {
			//all selection logic:
			try {
				for(WebElement e:choiceLists) {
					e.click();
				}
			}
			catch(ElementNotInteractableException e) {
				System.out.println("all choices are over......");
			}
		}
	}

}




//			System.out.println(text);
//			if(text.equals(value) ) {
//				e.click();
//				break;
//			}
//
//		}












