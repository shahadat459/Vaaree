package com.qa.vaaree.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.vaaree.utils.AppConstants;
import com.qa.vaaree.utils.ElementUtil;

import io.qameta.allure.Step;

public class AccountPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. constructor of the page class
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}

	// 2. private by locators
	private By logout = By.linkText("Logout");
	private By dashboardLink = By.linkText("Dashboard");
	private By search = By.xpath("//input[@placeholder='Search for products']");
	private By searchBtn = By.xpath("//button[@class='t4s-search-header__submit']");

	// page actions
	@Step("getting title...")
	public String getAccPageTitle() {
		String title = eleUtil.waitForTitleIsAndCapture("Account – Vaaree", AppConstants.SHORT_DEFAULT_WAIT);
		System.out.println("Acc page title : " + title);
		return title;
	}
	@Step("getting URL...")
	public String getAccPageUrl() {
		String url = eleUtil.waitForURLContainsAndCapture("account", AppConstants.SHORT_DEFAULT_WAIT);
		System.out.println("Acc page URL : " + url);
		return url;
	}

	@Step("checking logout link...")
	public boolean isLogoutLinkExist() {
		return eleUtil.checkElementIsDisplayed(logout);
	}

	@Step("checking dashboard link...")
	public boolean isdashboardLinkExist() {
		return eleUtil.checkElementIsDisplayed(dashboardLink);
	}

	@Step("searching the {0} product...")
	public SearchResultsPage doSearch(String searchTerm) {
		eleUtil.waitForElementVisible(search,AppConstants.SHORT_DEFAULT_WAIT);
		eleUtil.doSendKeys(search, searchTerm);
		eleUtil.doClick(searchBtn);
		return new SearchResultsPage(driver);
	}

}
