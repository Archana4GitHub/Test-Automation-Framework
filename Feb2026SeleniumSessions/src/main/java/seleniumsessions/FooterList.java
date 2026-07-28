package seleniumsessions;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterList {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		Thread.sleep(1000);

		driver.manage().window().maximize();

		//		List<WebElement> footerList=driver.findElements(By.xpath("//div[@class='sc-6293d692-0 eNMhGa']//li[@class='sc-6293d692-0 eNMhGa']//span"));
		//		for(WebElement e:footerList) {
		//			System.out.println(e.getText());
		//		}

		//		List<WebElement> footerList=driver.findElements(By.xpath("  //div[@class='sc-ace17a57-0 hFnGrz']/ul"));
		//		for(WebElement e:footerList) {
		//			System.out.println(e.getText());
		//		}

		By footerList1=By.xpath("//div[@class='sc-6293d692-0 eNMhGa']//li[@class='sc-6293d692-0 eNMhGa']//span");
		By footerList2=By.xpath("//@@@div[@class='sc-ace17a57-0 hFnGrz']/ul");

		//doGetFooterList(footerList1);
		doGetFooterList(footerList2);

	}

	public static List<WebElement> doGetElement(By locator) {
		return driver.findElements(locator);
	}

	public static void doGetFooterList(By locator) {
		List<WebElement> footerList= doGetElement(locator);
		for(WebElement e:footerList) {
			System.out.println(e.getText());
		}

	}

}
