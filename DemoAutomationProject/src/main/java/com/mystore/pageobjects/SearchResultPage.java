package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass {
	
	@FindBy(xpath="//*[@id=\"center_column\"]//img")
	WebElement productResult;
	
	// Constructor to invoke WebElement.
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Method to validate product availability
	public boolean isProductAvailable() {
		return productResult.isDisplayed();
	}
	
	//Method to verify that after click on product it should navigate to the addToCart page.
	public AddToCartPage clickOnProduct() {
		productResult.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return new AddToCartPage();
	}

}
