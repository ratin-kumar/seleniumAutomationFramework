package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass{

	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(xpath="//*[@id=\"group_1\"]")
	WebElement size;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	WebElement addToCartBtn;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/header/div[3]/div/div/div[4]/div[1]/div[1]/h2")
	WebElement addToCartMessage;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckOutbtn;
	
	// Constructor to invoke WebElement.
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Method to entering Quantity
	public void enterQuantity(String qty) {
		quantity.clear();
		quantity.sendKeys(qty);
	}
	
	//Method to Select Size
	public void selectSize(String reqsize) {
		//Select class to handle drop down
		Select dropDownSize = new Select(size);
		dropDownSize.selectByVisibleText(reqsize);
	}
	
	//Method to click on add to cart button.
	public void clickOnAddToCart() throws InterruptedException {
		addToCartBtn.click();
		Thread.sleep(10000);//Need to check
	}
	
	//Method to verify product added in cart successfully
	public boolean validateAddToCart() {
		return addToCartMessage.isDisplayed();
	}
	
	//Method to click on proceed to checkout button.
	public OrderPage clickOnCheckOut() {
		proceedToCheckOutbtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return new OrderPage();
	}
}
