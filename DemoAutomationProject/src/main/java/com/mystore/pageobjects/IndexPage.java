package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass{

	
	@FindBy(xpath="//a[@class='login']")
	WebElement signInBtn;
	
	@FindBy(id="search_query_top")
	WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	WebElement searchButton;
	
	//Constructor to invoke WebElement
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Method to click on SignIn button
	public LoginPage clickOnSignIn() {
		signInBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		return new LoginPage();
	}
	
	//Method to get title of the page
	public String titleOfThePage() {
		return driver.getTitle();
	}
	
	//Method to search product
	public SearchResultPage searchProduct(String productName) throws Throwable {
		searchProductBox.clear();
		searchProductBox.sendKeys(productName);
		searchButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return new SearchResultPage();
	}
}
