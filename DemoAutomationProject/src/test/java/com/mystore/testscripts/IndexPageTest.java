package com.mystore.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.utility.Log;

public class IndexPageTest extends BaseClass {
	IndexPage indexpage = new IndexPage();

	@Parameters("browser")
	@BeforeMethod(groups = { "smoke", "sanity", "regression" })
	// Method to launching web app.
	public void setup(String browser) throws Throwable {

			Log.info("Launching Web Application");
			launchApp(browser);
		}
	

	@AfterMethod(groups = { "smoke", "sanity", "regression" })
	// Method to close browser.
	public void tearDown() {

		Log.info("Closing Web Application");
		driver.quit();
	}

	// Method to verify Title of the page
	@Test(groups = "smoke")
	public void verifyTitle() {

		Log.startTestCase("verifyTitle");

		Log.info("Getting Title of the page.");
		String actualTitle = indexpage.titleOfThePage();

		Log.info("Verifying title");
		Assert.assertEquals(actualTitle, prop.getProperty("titl"));//TestFail

		Log.endTestCase("verifyTitle");
	}
}
