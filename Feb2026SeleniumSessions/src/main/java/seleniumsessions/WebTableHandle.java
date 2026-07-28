package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandle {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/icc-men-s-t20-world-cup-2025-26-1502138/india-vs-new-zealand-final-1512773/full-scorecard");
		driver.manage().window().maximize();
		Thread.sleep(3000);


		//span[contains(text(),'Hardik Pandya')]/ancestor::td/following-sibling::td/span

		String wkName1=getWicketTakerName("Hardik Pandya");
		String wkName2=getWicketTakerName("Ishan Kishan");
		System.out.println(wkName1);
		System.out.println(wkName2);
		
		
		System.out.println(getScoreCardList("Hardik Pandya"));
		System.out.println(getScoreCardList("Ishan Kishan"));

	}

	public static String getWicketTakerName(String name) {
		return driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]/ancestor::td/following-sibling::td/span")).getText();
	}

	public static List<String> getScoreCardList(String name) {
		List<String> scoreVal=new ArrayList<String>();
		List<WebElement> scoreList=
				driver.findElements(By.xpath("//span[contains(text(),'"+name+"')]/ancestor::td/following-sibling::td"));
		for(int i=1;i<scoreList.size();i++) {
			String score=scoreList.get(i).getText();
			scoreVal.add(score);
		}
		return scoreVal;
	}



}
