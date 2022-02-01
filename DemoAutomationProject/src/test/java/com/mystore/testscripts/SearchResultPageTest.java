package com.mystore.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

public class SearchResultPageTest extends BaseClass{
	
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	
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
	
	//Method to verify productAvailablityTest.
	@Test(groups ="smoke")
	public void productAvailablityTest() throws Throwable {
		
		Log.startTestCase("productAvailablityTest");
		
		indexPage = new IndexPage();
		
		Log.info("Searching Product");
		searchResultPage = indexPage.searchProduct(prop.getProperty("searchProductName"));
		
		boolean result = searchResultPage.isProductAvailable();
		
		Log.info("Validating product availability");
		Assert.assertTrue(result);
		
		Log.endTestCase("productAvailablityTest");
	}

}
