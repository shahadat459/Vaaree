package com.qa.vaaree.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.vaaree.utils.ElementUtil;

public class SearchResultsPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. constructor of the page class
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}

	// 2. private by locators
	private By productList = By.cssSelector("div.t4s-product-wrapper");
	private By productName = By.cssSelector("div#ProductInfo-template--template--16835081404662__main__main h1");

	// Page actions:
	public String searchResultsPageTitle(String searchTerm) {
		return eleUtil.waitForTitleIsAndCapture(searchTerm, 5);
	}

	public int getProductResultCount() {
		int resultCount = eleUtil.waitForElementsVisible(productList, 10).size();
		System.out.println("product search count : " + resultCount);
		return resultCount;
	}

	public ProductDescPage selectProduct(String productName) {
		By productNameLocator = By.linkText(productName);
		eleUtil.doClick(productNameLocator);
		return new ProductDescPage(driver);

	}

}
