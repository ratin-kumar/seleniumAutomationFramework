package com.mystore.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class HomePageTest extends BaseClass{
	
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;
	
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

	//Method to validate wishlist.
	@Test(groups ="smoke")
	public void wishListTest() {
		
		Log.startTestCase("wishListTest");
		indexpage = new IndexPage();
		
		Log.info("Clicking on signin");
		loginpage = indexpage.clickOnSignIn();
		
		Log.info("Entring Username and password.");
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		boolean result = homepage.validateMyWishlist();
		
		Log.info("Validation WishList test");
		Assert.assertTrue(result);
		
		Log.endTestCase("wishListTest");
	}
	
	//Method to validate order history details.
	@Test(groups ="smoke")
	public void orderHistoryandDetailsTest() {
		
		Log.startTestCase("orderHistoryandDetailsTest");
		
		indexpage = new IndexPage();
		
		Log.info("Clicking on Signin");
		loginpage = indexpage.clickOnSignIn();
		
		Log.info("Entering Username and password");
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		boolean result = homepage.validateOrderHistory();
		
		Log.info("Validating Order History");
		Assert.assertTrue(result);
		
		Log.endTestCase("orderHistoryandDetailsTest");
	}
}
