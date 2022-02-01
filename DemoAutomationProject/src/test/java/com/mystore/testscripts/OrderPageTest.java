package com.mystore.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

public class OrderPageTest extends BaseClass{
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;

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
	
	//Method to verify total price.
	@Test(groups ="regression")
	public void totalPriceTest() throws Throwable {
		
		Log.startTestCase("totalPriceTest");
		
		indexPage = new IndexPage();
		
		Log.info("Searching Product");
		searchResultPage = indexPage.searchProduct(prop.getProperty("searchProductName"));
		
		Log.info("Clicking on product");
		addToCartPage = searchResultPage.clickOnProduct();
		
		Log.info("Entering Quantity");
		addToCartPage.enterQuantity(prop.getProperty("qty_addToCart"));
		
		Log.info("Selecting Size");
		addToCartPage.selectSize(prop.getProperty("size_addToCart"));
		
		Log.info("Clicking on add to cart.");
		addToCartPage.clickOnAddToCart();
		
		Log.info("Clicking on checkout.");
		orderPage = addToCartPage.clickOnCheckOut();
		
		Log.info("Getting unit price of the product.");
		double unitPrice = orderPage.getUnitPrice();
		
		Log.info("Getting total price of the product");
		double totalPrice = orderPage.getTotalPrice();
		
		Log.info("Parsing quantity in integer form");
		int qty = Integer.parseInt(prop.getProperty("qty_addToCart"));
		
		Log.info("Calculating Expected price");
		double expextedPrice = (unitPrice*qty)+2;
		
		Log.info("Validating totalprice test");
		Assert.assertEquals(expextedPrice, totalPrice);
		
		Log.endTestCase("totalPriceTest");
	}
}
