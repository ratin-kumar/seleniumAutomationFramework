package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderSummary extends BaseClass{
	
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	WebElement confirmOrderBtn;
	
	// Constructor to invoke WebElement.
	public OrderSummary() {
		PageFactory.initElements(driver, this);
	}
	
	//Method to click on confirm order button
	public OrderConfirmationPage clickOnConfirmOrder() {
		confirmOrderBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return new OrderConfirmationPage();
	}

}
