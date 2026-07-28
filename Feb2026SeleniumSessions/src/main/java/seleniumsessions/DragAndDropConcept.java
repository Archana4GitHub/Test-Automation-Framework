package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropConcept {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
		WebElement sourceElement=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement targetElement=driver.findElement(By.xpath("//div[@id='droppable']"));

		Actions act=new Actions(driver);

//		act
//		.clickAndHold(sourceElement)
//		.moveToElement(targetElement)
//		.release()
//		.build()
//		.perform();
		
		act.dragAndDrop(sourceElement, targetElement).perform(); //This will work
		act.dragAndDrop(sourceElement, targetElement).build().perform(); // this will work
		act.dragAndDrop(sourceElement, targetElement).build(); //This will not work -->NA
		
		






	}
}
