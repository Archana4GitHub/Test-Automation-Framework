package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserRegistrationPage {


	public static void main(String[] args) throws InterruptedException {
		BrowserUtil brUtil =new BrowserUtil();
		WebDriver driver=brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		ElementUtil eleUtil=new ElementUtil(driver);

		String first_Name="input-firstname";
		String last_Name="input-lastname";
		String eMail="input-email";
		String telePhone="input-telephone";
		String password="input-password";
		String confirm_Password="input-confirm";
		String registerBtn="btn btn-primary";
		String privacy_policy="agree";


		By fN=eleUtil.getBy("id",first_Name);
		By lN=eleUtil.getBy("id",last_Name);
		By email=eleUtil.getBy("id",eMail);
		By telphn=eleUtil.getBy("id",confirm_Password);
		By pwd=eleUtil.getBy("id",password);
		By confirm_pwd=eleUtil.getBy("id",confirm_Password);
		By priPolicy=eleUtil.getBy("name",privacy_policy);
		By register=eleUtil.getBy("className", registerBtn);
		
		eleUtil.doSendKeys(fN,"archana");
		eleUtil.doSendKeys(lN, "archana");
		eleUtil.doSendKeys(email, "archanasaigal@gmail.com");
		eleUtil.doSendKeys(telphn,"+81-8095799584");
		eleUtil.doSendKeys(pwd, "archie@test123");
		eleUtil.doSendKeys(confirm_pwd, "archie@test123");
		eleUtil.getElement(priPolicy).click();
		eleUtil.getElement(register).click();
		
		Thread.sleep(3000);
		
		System.out.println(brUtil.getpageTitle().contains("Account"));
		
				
		
		
















	}

}
