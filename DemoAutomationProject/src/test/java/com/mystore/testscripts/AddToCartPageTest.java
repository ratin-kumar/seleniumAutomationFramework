package com.mystore.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

public class AddToCartPageTest extends BaseClass{
	
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	
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
	
	//Method to verify add to cart page.
	@Test(groups = {"regression","sanity"})
	public void addToCartTest() throws Throwable {
		
		Log.startTestCase("addToCartTest");
		
		indexPage = new IndexPage();
		
		Log.info("Serching Product.");
		searchResultPage = indexPage.searchProduct(prop.getProperty("searchProductName"));
		
		Log.info("Clicking on searched product");
		addToCartPage = searchResultPage.clickOnProduct();
		
		Log.info("Entering Quantity");
		addToCartPage.enterQuantity(prop.getProperty("qty_addToCart"));
		
		Log.info("Entering Size");
		addToCartPage.selectSize(prop.getProperty("size_addToCart"));
		
		Log.info("Clicking on add to cart button");
		addToCartPage.clickOnAddToCart();
		
		Log.info("Validation add to cart page");
		boolean result = addToCartPage.validateAddToCart();
		Assert.assertTrue(result);
		
		Log.endTestCase("addToCartTest");
	}

}
