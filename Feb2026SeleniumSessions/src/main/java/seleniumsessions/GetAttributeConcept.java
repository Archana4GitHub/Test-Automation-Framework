package seleniumsessions;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAttributeConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

		driver.get("https://www.amazon.com");
		Thread.sleep(2000);

		//		String hrefVal=driver.findElement(By.linkText("Sell")).getAttribute("href");
		//		System.out.println(hrefVal);

		//		By links=By.tagName("a");
		//		getElementAttributeList(links,"href");

		By images=By.tagName("img");
		System.out.println(getElements(images).size());
		
		getElementAttributeList(images,"src");
		getElementAttributeList(images,"alt");
	}


	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static List<String> getElementAttributeList(By locator,String attrName) {
		List<WebElement> attributeList=getElements(locator);
		List<String> eleAttrList=new ArrayList<String>();

		for(WebElement w:attributeList) {
			String attrVal=w.getAttribute(attrName);
			System.out.println(attrVal);
			eleAttrList.add(attrVal);
		}
		return eleAttrList;
	}

}
