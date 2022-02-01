package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class AccountCreationPage extends BaseClass {

	@FindBy(xpath="//h1[text()='Create an account']")
	WebElement formTitle;
	
	// Constructor to invoke WebElement.
	public AccountCreationPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Method to validate whether user is navigation to account creation page.
	public boolean validateAccountCreatePage() {
		return formTitle.isDisplayed();
		
	}

}
