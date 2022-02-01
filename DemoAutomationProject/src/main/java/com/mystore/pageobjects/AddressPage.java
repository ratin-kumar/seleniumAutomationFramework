package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass {
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement proceedToCheckOut;

	// Constructor to invoke WebElement.
	public AddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Method to click on check out button.
	public ShippingPage clickOnCheckOut() {
		proceedToCheckOut.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return new ShippingPage();
	}
	
	
	
}
