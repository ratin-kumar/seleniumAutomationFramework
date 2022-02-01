package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass{

	@FindBy(id="cgv")
	WebElement TermsCheckBox;
	
	@FindBy(xpath="//*[@id=\"form\"]/p/button/span")
	WebElement proceedToCheckOutBtn;;
	
	// Constructor to invoke WebElement.
	public ShippingPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Method to click on check box.
	public void clickOnCheckBox() {
		TermsCheckBox.click();
	}
	
	//Method to click on proceed to checkout
	public PaymentPage ClickOnProceedToCheckOut() {
		proceedToCheckOutBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return new PaymentPage();
	}
}
