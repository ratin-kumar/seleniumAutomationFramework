package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass {

	//@FindBy(id = "//span[text()='My wishlists']")
	@FindBy(xpath = "//div[@id='center_column']/div/div[2]/ul/li/a/span")
	WebElement myWishList;

	//@FindBy(id = "//span[text()='Order history and details']")
	@FindBy(xpath="//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span")
	WebElement orderHistory;

	// Constructor to invoke WebElement.
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Method to validation wishlist.
	public boolean validateMyWishlist() {
		return myWishList.isDisplayed();
	}
	
	// Method to validation order history.
	public boolean validateOrderHistory() {
		return orderHistory.isDisplayed();
	}

	//Method to getting current URL.
	public String getCurrURL() {
		String homePageURL = driver.getCurrentUrl();
		return homePageURL;
	}
}
