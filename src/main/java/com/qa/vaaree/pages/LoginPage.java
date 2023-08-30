package com.qa.vaaree.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.vaaree.utils.AppConstants;
import com.qa.vaaree.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	ElementUtil eleUtil;

	// 1. constructor of the page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);

	}

	// 2. private by locators
	private By emailId = By.id("CustomerEmail");
	private By password = By.id("CustomerPassword");
	private By signInBtn = By.xpath("//button[text()='Sign In']");
	private By forgotPwdLink = By.xpath("//a[text()='Forgot your password?']");
	private By login = By.xpath("//a[@class='t4s-pr']");
	private By footerLinks = By.xpath("//footer//li");
	private By logout = By.linkText("Logout");

	// 3. public page actions/methods
	public String getLoginPageTitle() {

		eleUtil.waitForTitleIsAndCapture("Online At Best Prices | Vaaree", AppConstants.MEDIUM_DEFAULT_WAIT);
		String title = driver.getTitle();
		System.out.println("login page title : " + title);
		return title;
	}

	public String getLoginPageUrl() {

		return eleUtil.waitForURLContainsAndCapture(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE, AppConstants.MEDIUM_DEFAULT_WAIT);

	}

	/*
	 * public boolean isForgotPwdExist() { driver.findElement(login).click();
	 * WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	 * WebElement forgotPwd =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(forgotPwdLink));
	 * driver.findElement(login).click(); return forgotPwd.isDisplayed(); }
	 */

	public List<String> getFooterLinksList() {
		List<WebElement> footerLinksList = eleUtil.waitForElementsVisible(footerLinks, AppConstants.MEDIUM_DEFAULT_WAIT);
		List<String> footerTextList = new ArrayList<String>();

		for (WebElement e : footerLinksList) {
			String text = e.getText();
			footerTextList.add(text);
		}

		return footerTextList;
	}

	public AccountPage doLogin(String email, String pwd) {
		driver.findElement(login).click();
		eleUtil.waitForElementVisible(emailId, AppConstants.MEDIUM_DEFAULT_WAIT).sendKeys(email);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(signInBtn);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(600));
		WebElement logoutLink = wait.until(ExpectedConditions.visibilityOfElementLocated(logout));
		if (logoutLink.isDisplayed()) {
			System.out.println("login successfull");
		}
		// returns the next landing page -- HomePage ---page chaining model
		return new AccountPage(driver);

	}

}
