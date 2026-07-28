package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	private static final By Email_Text_Box_Locator=By.id("email");
	private static final By Password_Text_Box_Locator=By.id("passwd");
	private static final By Submit_Button_Locator=By.id("SubmitLogin");
	
	public MyAccountPage  doLoginWith(String emailAddress,String password) {
		enterText(Email_Text_Box_Locator,emailAddress);
		enterText(Password_Text_Box_Locator,password);
		clickOn(Submit_Button_Locator);
		MyAccountPage myAccountPage=new MyAccountPage(getDriver());
		return myAccountPage;
		
		
	}
	
	
	

}
