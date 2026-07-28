package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandle {


	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.londonfreelance.org/courses/frames/index.html");
		Thread.sleep(1000);

		driver.manage().window().maximize();
		Thread.sleep(3000);// Even after putting wait for page load, does not work. 
		//because this html tag is present inside Frame

		//driver.switchTo().frame(2); //frame 0 frame 1 frame 2
		//driver.switchTo().frame("main");
		driver.switchTo().frame(driver.findElement(By.name("main")));
		Thread.sleep(3000);
		//frame is also a web element:
		//frame has its own HTML DOM : #document
		//html tags: frame,iframe


		String header=driver.findElement(By.xpath("/html/body/h2")).getText();
		System.out.println(header);
		
		//driver.switchTo().parentFrame();
		driver.switchTo().defaultContent(); //main page 
		
		
		//Assignment: URL:Selectorshub.com -->Practice
		//Salesforce UI
		
		//random pop up: limitation 
		//QA:disable adv.pop ups - can't automate so disable pop ups in QA

		driver.close();

	}

	private static void defaultContent() {
		// TODO Auto-generated method stub
		
	}
}
