package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass{

	@FindBy(xpath="//a[contains(text(),'Pay by bank wire')]")
	WebElement payByBankWire;
	
	@FindBy(xpath="//a[contains(text(),'Pay by check')]")
	WebElement payByCheck;
	
	// Constructor to invoke WebElement.
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
		
	//Method to click on payment method
	public OrderSummary clickOnPayment() {
			payByBankWire.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			return new OrderSummary();
		}
	
}
