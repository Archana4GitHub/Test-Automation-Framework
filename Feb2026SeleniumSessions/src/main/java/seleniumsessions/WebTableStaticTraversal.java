package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableStaticTraversal {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[3]/td[1]
		//*[@id="customers"]/tbody/tr[7]/td[1]

		String before_xpath="//*[@id=\"customers\"]/tbody/tr[";
		String after_xpath="]/td[1]";

		By rows=By.xpath("//table[@id=\"customers\"]//tr");
		By cols=By.xpath("//table[@id=\"customers\"]//th");

		getColumnData(before_xpath,after_xpath,rows);
	}

	public static int getRowCount(By locator) {
		int rowCount=driver.findElements(locator).size();
		return rowCount;

	}
	public static int getColCount(By locator) {
		int colCount=driver.findElements(locator).size();
		return colCount;
	}

	public static void getColumnData(String before_xpath,String after_xpath,By rows) {
		for(int row=2;row<=getRowCount(rows);row++) {
			String xpath=before_xpath+row+after_xpath;
			String text=driver.findElement(By.xpath(xpath)).getText();
			System.out.println(text);
		}

	}
}


//Assignment: Can you Fetch data from Column 2 and Column 3
//Can you print all the rows and all the column in one method. use 2 for loops  or matrix