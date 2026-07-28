package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadPopUp {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		Thread.sleep(1000);

		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		driver.switchTo().frame(1);
		//NoSuchFrameException: no such frame

		//type=file is mandatory
		
		//driver.findElement(By.name("upfile")).sendKeys("C:\\Users\\Archana\\Desktop\\Reyansh 1st year");

		//autoIt -- only for windows os Not preferred because it will not run on unix,linux, resmote os

		driver.get("https://smallpdf.com/merge-pdf");
		driver.findElement(By.xpath("//button[@type='button' and @class='l3tlg0-0 ggoliT']")).sendKeys("C:\\Users\\Archana\\Desktop\\Reyansh 1st year");
		Thread.sleep(3000);


	}
}
