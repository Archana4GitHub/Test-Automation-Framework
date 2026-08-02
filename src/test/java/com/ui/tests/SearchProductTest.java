package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners({ com.ui.listeners.TestListener.class })
public class SearchProductTest extends TestBase {
	// Implement your test methods for searching products here

	private MyAccountPage myAccountPage;
	private static final String SEARCH_ITEM = " Mens Wallet";

	@BeforeMethod(description = "Valid user logs into the application")
	public void setup() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("cimlamakke@tozya.com", "password");
	}

	@Test(description = "Verify if the logged in user is able to search for a product and correct products results are displayed", groups = {
			"e2e", "sanity" })
	public void verifyproductSearchTest() {
		boolean actualResult = myAccountPage.searchForAProduct(SEARCH_ITEM)
				.isSearchTermPresentInProductList(SEARCH_ITEM);
		Assert.assertEquals(actualResult, true);
	}

}
