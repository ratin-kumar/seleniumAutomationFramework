package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass{
	
	@FindBy(xpath="//p/strong[contains(text(),'Your order on My Store is complete.')]")
	WebElement confirmMessage;
	
	// Constructor to invoke WebElement.
	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Method to validate order confirmation
	public String validateConfirmMessage() {
		String confirmMsg=confirmMessage.getText();
		return confirmMsg;
	}

}
