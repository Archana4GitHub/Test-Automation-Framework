package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class PaymentPage extends BrowserUtility {
	
	private static final By PAYMENT_CONFIRMATION_MESSAGE_LOCATOR=By.xpath("//p[@class=\"alert alert-warning\"]");
	
	public PaymentPage(WebDriver driver) {
		super(driver);
	}

	public String getPaymentConfirmationMessage() {
		String message=getVisibleText(PAYMENT_CONFIRMATION_MESSAGE_LOCATOR);
		getLogger().info("Payment Confirmation Message: "+message);
		return message;
	}
}
