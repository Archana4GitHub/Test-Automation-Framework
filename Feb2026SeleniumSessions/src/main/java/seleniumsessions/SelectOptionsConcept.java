package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectOptionsConcept {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

		driver.get("https://www.html-code-generator.com/drop-down/state-names");
		Thread.sleep(2000);

		//WebElement country=driver.findElement(By.id("user-country")); 
		//
		//		Select select =new Select(country);
		//		List<WebElement> countryOptions=select.getOptions();
		//		Thread.sleep(1000);
		//
		//		for(WebElement e:countryOptions) {
		//			System.out.println(e.getText());
		//		}

		By country=By.id("user-country");
		By state=By.id("user-state");

		//		doSelectByVisibleText(country,"India");
		//		Thread.sleep(5000);
		//		
		//		doSelectByVisibleText(state,"Bihar");
		//		
		//		System.out.println(doGetDropDownOptions(country).contains("India"));
		//		System.out.println(doGetDropDownOptions(state).contains("Bihar"));

		//		Select select=new Select(country);
		//		List<WebElement> optionList=select.getOptions();
		//		for(WebElement e:optionList) {
		//			if(e.getText().equals("India"))
		//			{
		//				e.click();
		//				break;
		//			}
		//		}

//		doSelectDropDownValue(country,"India");
//		Thread.sleep(2000);
//		doSelectDropDownValue(state,"Bihar");
		
		Select select=new Select(driver.findElement(country));
		System.out.println(select.isMultiple());
		select.getAllSelectedOptions();
		

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doSelectByVisibleText(By locator,String text) {
		Select select=new Select(getElement(locator));
		select.selectByVisibleText(text);

	}


	public static List<String> doGetDropDownOptions(By locator) {
		Select select=new Select(getElement(locator));
		List<WebElement> optionsList=select.getOptions();
		List<String> optionsValList=new ArrayList<String>();
		System.out.println(optionsList.size());

		for(WebElement e:optionsList) {
			String text =e.getText();
			//System.out.println(text);
			optionsValList.add(text);
		}
		return optionsValList;

	}

	public static void doSelectDropDownValue(By locator, String value) {
		Select select=new Select(getElement(locator));
		List<WebElement> optionList=select.getOptions();
		for(WebElement e:optionList) {
			if(e.getText().equals(value))
			{
				e.click();
				break;
			}
		}
	}


}
