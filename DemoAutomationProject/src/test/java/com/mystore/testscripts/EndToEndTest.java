package com.mystore.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummary;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;
import com.mystore.utility.Log;

public class EndToEndTest extends BaseClass{
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	LoginPage logInPage;
	AddressPage newAddressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummary orderSummary;
	OrderConfirmationPage orderConfirmationPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"smoke","sanity","regression"})
	// Method to launching web app.
	public void setup(String browser) throws Throwable {
		
		Log.info("Launching Web Application");
		launchApp(browser);
	}

	@AfterMethod(groups = {"smoke","sanity","regression"})
	// Method to close browser.
	public void tearDown() {
		Log.info("Closing Web Application");
		driver.quit();
	}
	
	//Method to validate End to end test
	@Test(groups = "regression")
	public void endToEndTest() throws Throwable {
		
		Log.startTestCase("endToEndTest");
		
		indexPage = new IndexPage();
		
		Log.info("Searching Product");
		searchResultPage = indexPage.searchProduct(prop.getProperty("searchProductName"));
		
		Log.info("Clicking on Product");
		addToCartPage = searchResultPage.clickOnProduct();
		
		Log.info("Entering Quantity");
		addToCartPage.enterQuantity(prop.getProperty("qty_addToCart"));
		
		Log.info("Entering Size");
		addToCartPage.selectSize(prop.getProperty("size_addToCart"));
		
		Log.info("Clicking on add to cart");
		addToCartPage.clickOnAddToCart();
		
		Log.info("Clicking on addToCartPage checkOut");
		orderPage = addToCartPage.clickOnCheckOut();
		
		Log.info("Clicking on orderPage checkOut");
		logInPage = orderPage.clickOnCheckOut();
		
		Log.info("Signing in.");
		newAddressPage = logInPage.login1(prop.getProperty("username"), prop.getProperty("password"));
		
		Log.info("Clicking on address page checkOut");
		shippingPage = newAddressPage.clickOnCheckOut();
		
		Log.info("Clicking on terms check box");
		shippingPage.clickOnCheckBox();
		
		Log.info("Clicking on proceed to checkOut");
		paymentPage = shippingPage.ClickOnProceedToCheckOut();
		
		Log.info("Clicking on payment method");
		orderSummary = paymentPage.clickOnPayment();
		
		Log.info("Clicking on confirm order");
		orderConfirmationPage = orderSummary.clickOnConfirmOrder();
		
		Log.info("Getting confirmation message");
		String confirmationMsg = orderConfirmationPage.validateConfirmMessage();
		
		Log.info("Validating conmfirmation message to validate endToEndTest");
		Assert.assertEquals(confirmationMsg, prop.getProperty("orderConfirmationMsg"));
		
		Log.endTestCase("endToEndTest");
		
	}

}
