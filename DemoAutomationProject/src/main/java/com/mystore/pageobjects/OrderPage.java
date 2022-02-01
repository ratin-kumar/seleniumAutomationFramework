package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass{
	
	@FindBy(id="product_price_1_1_0")
	WebElement unitPrice;
	
	@FindBy(id="total_price")
	WebElement totalPrice;	
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement proceedToCheckOut;
	
	// Constructor to invoke WebElement.
	public OrderPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Method to get unit price
	public Double getUnitPrice() {
		String uprice = unitPrice.getText();
		//Regx to remove special character.
		String newUPrice=uprice.replaceAll("[^a-zA-Z0-9]","");
		//Converting string to double
		Double finalUnitPrice=Double.parseDouble(newUPrice);
		//Dividing with 100 because replaceall method will remove decimal also.
		return finalUnitPrice/100;
	}
	
	//Method to get Total price
		public Double getTotalPrice() {
			String tprice = totalPrice.getText();
			//Regx to remove special character.
			String newTPrice=tprice.replaceAll("[^a-zA-Z0-9]","");
			//Converting string to double
			Double finalTotalPrice=Double.parseDouble(newTPrice);
			//Dividing with 100 because replaceall method will remove decimal also.
			return finalTotalPrice/100;
		}

		//Method to click on checkout button.
		public LoginPage clickOnCheckOut() {
			proceedToCheckOut.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			return new LoginPage();
		}
		
		
}
