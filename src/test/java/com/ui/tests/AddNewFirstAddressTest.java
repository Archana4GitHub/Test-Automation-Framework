package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.ui.pages.AddNewAddressPage;
import com.ui.pages.LoginPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;

public class AddNewFirstAddressTest extends TestBase {
	private Faker faker=new Faker();
	private MyAccountPage myAccountPage;
	private AddNewAddressPage addNewAddressPage;
	private AddressPOJO address;

	@BeforeMethod(description = "Valid First user logs into the application")
	public void setup() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("cimlamakke@tozya.com", "password");

		address = new AddressPOJO(faker.company().name(), faker.address().streetAddress(),
				faker.address().secondaryAddress(), faker.address().city(), faker.address().state(),
				faker.address().zipCode(), faker.phoneNumber().phoneNumber(), faker.phoneNumber().cellPhone(),
				faker.lorem().sentence(), faker.address().buildingNumber());
	}

	@Test
	public void addNewAddressTest() {
		String newAddress = myAccountPage.goToAddNewAddressPage().saveAddress(address);
		Assert.assertEquals(newAddress, address.getAddressAlias().toUpperCase());
	}
}
