package com.mystore.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;
import com.mystore.pageobjects.AccountCreationPage;

public class AccountCreationTest extends BaseClass{

	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;
	
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
	
	//Method to create account page test.
	@Test(groups = "sanity")
	public void createAccountPageTest() throws InterruptedException {
		
		Log.startTestCase("createAccountPageTest");
		
		indexPage = new IndexPage();
		
		Log.info("Clicking on SingIn button");
		loginPage = indexPage.clickOnSignIn();
		
		Log.info("Entering Email-Id in create account input box.");
		accountCreationPage = loginPage.createNewAccount(prop.getProperty("newacmailid"));
		
		Log.info("Validating Account Creation page.");
		boolean result = accountCreationPage.validateAccountCreatePage();
		Assert.assertTrue(result);
		
		Log.endTestCase("createAccountPageTest");
		
		
	}

}
