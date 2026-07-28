package tests;

import base.BaseTest;
import driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test(priority = 1)
	public void testSuccessfulLogin() {
		LoginPage loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.loginAs("showroom.manager@xyz.co.jp", "SecurePass123!", "123");
		
		// Note: You will need to update this assertion based on the actual DOM of your application
		Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("dashboard"), "User was not routed to the dashboard.");
	}

	@Test(priority = 2)
	public void testInvalidPassword() {
		LoginPage loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.loginAs("showroom.manager@xyz.co.jp", "WrongPassword", "123");

		String actualError = loginPage.getErrorMessage();
		Assert.assertEquals(actualError, "Invalid credentials. Please try again.", "Error message mismatch.");
	}
}

