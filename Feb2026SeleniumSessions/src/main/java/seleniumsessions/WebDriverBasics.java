package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverBasics {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver","/Users/Archana/Downloads/chromedriver.exe");

		WebDriverManager.chromedriver().setup();

		//Top Casting: 
		//ChromeDriver class object can be referred by parent WebDriver Interface ref Variable.
		WebDriver driver = new ChromeDriver(); //launch chrome
		driver.get("https://google.com");//Invalid Argument Exception if you don't provide https in url.
		Thread.sleep(100);
		String title=driver.getTitle();
		System.out.println(title);

		//Validation Point/ Checkpoint/ act vs exp result/ assertions
		if(title.equals("Google")) {
			System.out.println("correct title");
		}
		else {
			System.out.println("incorrect title");
		}


		//(automation steps + //validation point /checkpoint/ act vs exp result /assertions) --> Automation Testing

		System.out.println(driver.getCurrentUrl().contains("google"));
		//System.out.println(driver.getPageSource());

		driver.quit(); //close browser
	}


}
