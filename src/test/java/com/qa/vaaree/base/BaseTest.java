package com.qa.vaaree.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.vaaree.factory.DriverFactory;
import com.qa.vaaree.pages.AccountPage;
import com.qa.vaaree.pages.HomePage;
import com.qa.vaaree.pages.LoginPage;
import com.qa.vaaree.pages.ProductDescPage;
import com.qa.vaaree.pages.RegisterPage;
import com.qa.vaaree.pages.SearchResultsPage;

public class BaseTest {
	WebDriver driver;
	protected DriverFactory df;
	protected Properties prop;
	protected SoftAssert softAssert;
	

	protected LoginPage loginPage;
	protected AccountPage accountPage;
	protected HomePage homePage;
	protected ProductDescPage productDescPage;
	protected RegisterPage registerPage;
	protected SearchResultsPage searchResultsPage;

	@Parameters({"browser"})
	@BeforeTest
	public void setup(String browserName) {
		df = new DriverFactory();
		prop = df.initProp();
		
		if(browserName!=null) {
			prop.setProperty("browser", browserName);
		}
		driver = df.initDriver(prop);

		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
