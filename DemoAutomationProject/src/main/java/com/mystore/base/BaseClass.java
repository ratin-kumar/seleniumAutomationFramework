package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;

	@BeforeSuite(groups = { "smoke", "sanity", "regression" })
	// Method to initialize log4j.xml file and set extents for extent report
	public void loadConfig() throws Throwable {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");

		try {
			String path = System.getProperty("user.dir") + "\\Configuration\\Config.properties";

			// Creating object for Properties class.
			prop = new Properties();

			// Creating object for FileInputStream to read properties file.
			FileInputStream inputstream = new FileInputStream(path);

			prop.load(inputstream);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Method to launch app getting browser from testNg XML file

	public static void launchApp(String browser) throws Throwable {

		// Fetching data from Properties file.
		String url = prop.getProperty("url");

		// Defining multiple conditions for different browsers to passed from xml
		// file.
		if (browser.equalsIgnoreCase("Chrome")) {

			// WebDriver Manager for handling ChromeDriver
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("Firefox")) {
			// WebDriver Manager for handling FirefoxDriver
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("IE")) {
			// WebDriver Manager for handling InternetExplorerDriver
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		// Maximizing window.
		driver.manage().window().maximize();

		// Opening the Given URL.
		driver.get(url);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	// Method to launch app getting browser from property file

	public static void launchApp() throws Throwable {

		// Fetching data from Properties file.
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");

		// Defining multiple conditions for different browsers to passed from properties
		// file.
		if (browser.equalsIgnoreCase("Chrome")) {

			// WebDriver Manager for handling ChromeDriver
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("Firefox")) {
			// WebDriver Manager for handling FirefoxDriver
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("IE")) {
			// WebDriver Manager for handling InternetExplorerDriver
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		// Maximizing window.
		driver.manage().window().maximize();

		// Opening the Given URL.
		driver.get(url);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterSuite(groups = { "smoke", "sanity", "regression" })
	public void afterSuite() {
		ExtentManager.endReport();
	}

}
