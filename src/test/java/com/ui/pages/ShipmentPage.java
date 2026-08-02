package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShipmentPage extends BrowserUtility {

	private static final By ACCEPT_TERMS_CHECKBOX_LOCATOR = By.xpath("//input[@name='cgv']");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.name("processCarrier");


	public ShipmentPage(WebDriver driver) {
		super(driver);
	}


	public PaymentPage goToPaymentPage() {

		scrollToElement(ACCEPT_TERMS_CHECKBOX_LOCATOR);

		if (!isSelected(ACCEPT_TERMS_CHECKBOX_LOCATOR)) {
			clickUsingJavaScript(ACCEPT_TERMS_CHECKBOX_LOCATOR);
		}

		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);

		return new PaymentPage(getDriver());
	}
}