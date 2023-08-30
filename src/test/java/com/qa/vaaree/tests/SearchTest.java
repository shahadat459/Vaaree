package com.qa.vaaree.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.vaaree.base.BaseTest;
import com.qa.vaaree.dataproviders.ProductDataProvider;

public class SearchTest extends BaseTest {

	@BeforeClass
	public void searchSetup() {
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(dataProvider = "productDataWithSearchKey", dataProviderClass = ProductDataProvider.class)
	public void searchProductTest(String searchKey) {
		searchResultsPage = accountPage.doSearch(searchKey);
		Assert.assertTrue(searchResultsPage.getProductResultCount() > 0);
	}

	@Test(dataProvider = "productDataWithSearchKey", dataProviderClass = ProductDataProvider.class)
	public void searchResultPageTitleTest(String searchKey) {
		searchResultsPage = accountPage.doSearch(searchKey);
		String title = searchResultsPage.searchResultsPageTitle(searchKey);
		System.out.println("Search result page title : " + title);
		Assert.assertTrue(title.contains(searchKey));
	}

	@Test(dataProvider = "productDataWithProductName", dataProviderClass = ProductDataProvider.class)
	public void selectProductTest(String searchKey, String productName) {
		searchResultsPage = accountPage.doSearch(searchKey);
		productDescPage = searchResultsPage.selectProduct(productName);
		Assert.assertEquals(productDescPage.getProductHeaderName(), productName);
	}

	@Test(dataProvider = "productDataWithImgCount", dataProviderClass = ProductDataProvider.class)
	public void ProductImagesTest(String searchKey, String productName, String imgCount) {
		searchResultsPage = accountPage.doSearch(searchKey);
		productDescPage = searchResultsPage.selectProduct(productName);
		String actImgCount = productDescPage.getProductImagesCount();
		System.out.println("Product Images actual Count : " + actImgCount);
		Assert.assertEquals(actImgCount, imgCount);
	}

}
