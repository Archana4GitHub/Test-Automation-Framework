package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPOJO;

public class FakeAddressUtility {
	public static void main(String[] args) {
		getFakeAddress();
	}

	public static AddressPOJO getFakeAddress() {

		Faker faker = new Faker(Locale.US);
		AddressPOJO addressPOJO = new AddressPOJO(faker.company().name(), faker.address().streetAddress(),
				faker.address().secondaryAddress(), faker.address().city(), faker.address().state(),
				faker.address().zipCode(), faker.phoneNumber().phoneNumber(), faker.phoneNumber().cellPhone(),
				faker.lorem().sentence(),faker.address().buildingNumber() );

		return addressPOJO;
	}
}
