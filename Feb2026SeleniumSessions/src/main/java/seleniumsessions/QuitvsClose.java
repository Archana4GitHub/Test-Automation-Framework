package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QuitvsClose {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver(); //launch chrome
		////chrome on windows (9dd05550bc8e88e54e3cf95ac13b9612)
		//ChromeDriver: chrome on windows (a48bd5c162cbb5e645298b027c8940c8)
		
		driver.get("https://google.com"); //enter the URL 
		//chrome on windows (9dd05550bc8e88e54e3cf95ac13b9612)
		//ChromeDriver: chrome on windows (a48bd5c162cbb5e645298b027c8940c8)
		
		String title=driver.getTitle(); //get the page title--Google
		//chrome on windows (9dd05550bc8e88e54e3cf95ac13b9612)
		//ChromeDriver: chrome on windows (a48bd5c162cbb5e645298b027c8940c8)
		
		System.out.println(title);
		
		//driver.quit(); //quit browser
		//ChromeDriver: chrome on windows (9dd05550bc8e88e54e3cf95ac13b9612)
		
		//System.out.println(driver.getTitle()); //?
		//org.openqa.selenium.NoSuchSessionException: 
		//Session ID is null. Using WebDriver after calling quit()?
		//browser is already closed so session id is null.
		
		//ChromeDriver: chrome on windows (null)
		
		
		
		driver.close(); //close the browser
		//ChromeDriver: chrome on windows (a48bd5c162cbb5e645298b027c8940c8)
		//System.out.println(driver.getTitle()); //?
		
		// org.openqa.selenium.NoSuchSessionException: invalid session id
		
		//To resolve this issue after driver.close(),
		//you need to again launch the browser,enter the url and get the page title.
		
		driver=new ChromeDriver(); // re-initialize the driver and new session id will be created
		driver.get("https://www.google.com");
		title=driver.getTitle();  
		System.out.println(title);
		driver.close();
		
		

	}

}
