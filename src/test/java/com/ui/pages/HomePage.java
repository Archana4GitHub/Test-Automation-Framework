package com.ui.pages;

import static com.constants.Env.QA;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

public final class HomePage extends BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public HomePage(WebDriver wd) {
		super(wd); // To call the Parent class constructor from the child constructor
		goToWebsite(JSONUtility.readJSON(QA).getUrl());
	}

	public HomePage(Browser chrome, boolean isHeadless) {
		super(chrome, isHeadless); // To call the Parent class constructor from the child constructor
		maximizeWindow();

		goToWebsite("https://automationpractice.techwithjatin.com/");
	}

	private static final By Sign_In_Link_Locator = By.xpath("//a[contains(text(),\"Sign in\")]");

	public LoginPage goToLoginPage() { // Page Functions----->cannot use void !!!
		logger.info("Trying to perform click to go to Sign in Page");
		clickOn(Sign_In_Link_Locator);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

	public void quit() {
		if (getDriver() != null) {
			getDriver().quit();

		}
	}
}
