package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(id = "email")
	WebElement userName;

	@FindBy(id = "passwd")
	WebElement password;

	@FindBy(id = "SubmitLogin")
	WebElement signInBtn;

	@FindBy(id = "email_create")
	WebElement emailForNewAccount;

	@FindBy(id = "SubmitCreate")
	WebElement createNewAccountBtn;

	// Constructor to invoke WebElement
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Method to signin from index page in account
	public HomePage login(String uname, String psd) {
		userName.sendKeys(uname);
		password.sendKeys(psd);
		signInBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return new HomePage();
	}
	
	// Method to signin after checkout
	public AddressPage login1(String uname, String psd) {
		userName.sendKeys(uname);
		password.sendKeys(psd);
		signInBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return new AddressPage();
	}
	
	//Method to create new account
	public AccountCreationPage createNewAccount(String email) {
		emailForNewAccount.sendKeys(email);
		createNewAccountBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return new AccountCreationPage();
	}

}
