package seleniumsessions;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		//1. total links on the page
		//2. print the text of each Link
		//3. exclude the blank text
		//4. capture the text in a list and return

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

		driver.get("https://www.amazon.com");
		Thread.sleep(2000);

		//		List<WebElement> linksList=driver.findElements(By.tagName("a"));
		//		System.out.println("total links: " +linksList.size());

		//		for(WebElement e:linksList)
		//		{
		//			String text=e.getText();
		//			if(!text.isEmpty()) //text is empty : True and ! will make condition false so text is not empty will only be printed.
		//			System.out.println(text);
		//		}

		//		for(int i=0;i<linksList.size();i++)
		//		{
		//			String text=linksList.get(i).getText();
		//			if(!text.isEmpty()) {
		//				System.out.println(text);
		//
		//			}
		//		}

		By allLinks=By.tagName("a");

		List<WebElement> eleList=getElements(allLinks);
		System.out.println("total links: "+eleList.size());

		System.out.println("total links: "+getElements(allLinks).size());

		List<String> allLinksText=getLinksTextList(allLinks);
		System.out.println(allLinksText.size());
		System.out.println(allLinksText.contains("Sell"));
		for(String l:allLinksText) {
			System.out.println(l);

		}


	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);

	}

	public static List<String> getLinksTextList(By locator) {
		List<WebElement> eleLists=getElements(locator);
		List<String> eleTextList=new ArrayList<String>();
		for(WebElement e:eleLists) {
			String text=e.getText();
			if(!text.isEmpty()) {
				eleTextList.add(text);

			}
		}
		return eleTextList;


	}

}
