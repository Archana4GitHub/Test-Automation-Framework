package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;

public class LoginTestOld {

	public static void main(String[] args) throws InterruptedException {

		WebDriver wd=new ChromeDriver(); //Launch a Browser Window!! Browser Session is created!!

		BrowserUtility browserUtility=new HomePage(wd);
		browserUtility.deleteCookies();
		browserUtility.goToWebsite("https://automationpractice.techwithjatin.com/");

		browserUtility.maximizeWindow();	

		By signInLinkLocator=By.xpath("//a[contains(text(),\"Sign in\")]");
		browserUtility.clickOn(signInLinkLocator);

		By emailIdLocator=By.id("email");
		browserUtility.enterText(emailIdLocator, "cimlamakke@tozya.com");
		Thread.sleep(3000);

		By passwordIdLocator=By.id("passwd");
		browserUtility.enterText(passwordIdLocator, "password");
		Thread.sleep(3000);


		By submitLoginLocator=By.id("SubmitLogin");
		browserUtility.clickOn(submitLoginLocator); 
		Thread.sleep(3000);

















	}

}
