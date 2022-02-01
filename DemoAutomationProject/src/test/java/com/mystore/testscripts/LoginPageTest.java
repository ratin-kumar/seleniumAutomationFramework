package com.mystore.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.Dataproviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTest extends BaseClass{
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
	
	//Method for LogIn page Test.
	@Test(dataProvider = "credentials", dataProviderClass = Dataproviders.class, groups= {"sanity","smoke"})
	public void loginTest(String username , String password) {
		
		Log.startTestCase("loginTest");
		
		indexpage = new IndexPage();
		
		Log.info("Clicking on sigin button");
		loginpage = indexpage.clickOnSignIn();
		
		Log.info("Entering UserName and Password from Excel Sheet and signing in");
		homepage = loginpage.login(username, password);
		
		Log.info("Getting current URL");
		String currentURL =homepage.getCurrURL();
		
		Log.info("Getting expected URL");
		String expectedURL=prop.getProperty("expectedurl");
		
		Log.info("Veryfing the sigin done.");
		Assert.assertEquals(currentURL, expectedURL);
		
		Log.endTestCase("logInTest");
	}

}
