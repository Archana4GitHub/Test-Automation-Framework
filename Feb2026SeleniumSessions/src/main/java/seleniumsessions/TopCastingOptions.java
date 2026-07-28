package seleniumsessions;

public class TopCastingOptions {

	public static void main(String[] args) {

		//1 valid
		//WebDriver driver=new ChromeDriver();
		
		//2 valid
		//WebDriver driver=new FirefoxDriver();
		
		//3 valid--Remote Execution using SeleniumGrid on Remote machine like Cloud,AWS,Docker
		//WebDriver driver=new RemoteWebDriver();
		
		//4 not useful
		//SearchContext driver=new ChromeDriver();
		
		//5 not useful
		//SearchContext driver=new RemoteWebDriver(remoteAddress, capabilities);
		
		//6 valid but java recommends using top casting using parent interface not using a parent class.
		//RemoteWebDriver driver=new ChromeDriver();
		
		//7 Invalid because constructor is defined as protected due to which we can not create its object.
		//ChromiumDriver=new ChromiumDriver();
		
		



	}

}
