package com.qa.vaaree.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.vaaree.base.BaseTest;
import com.qa.vaaree.dataproviders.ProductDataProvider;
import com.qa.vaaree.pojo.Product;

public class SearchDataTest extends BaseTest {

	@BeforeClass
	public void searchSetup() {
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(dataProvider = "productData", dataProviderClass = ProductDataProvider.class)
	public void searchProductTest(Product product) {
		searchResultsPage = accountPage.doSearch(product.getSearchKey());
		Assert.assertTrue(searchResultsPage.getProductResultCount() > 0);
	}

	@Test(dataProvider = "productData", dataProviderClass = ProductDataProvider.class)
	public void searchResultPageTitleTest(Product product) {
		searchResultsPage = accountPage.doSearch(product.getSearchKey());
		String title = searchResultsPage.searchResultsPageTitle(product.getSearchKey());
		System.out.println("Search result page title : " + title);
		Assert.assertTrue(title.contains(product.getSearchKey()));
	}

	@Test(dataProvider = "productData", dataProviderClass = ProductDataProvider.class)
	public void selectProductTest(Product product) {
		searchResultsPage = accountPage.doSearch(product.getSearchKey());
		productDescPage = searchResultsPage.selectProduct(product.getProductName());
		Assert.assertEquals(productDescPage.getProductHeaderName(), product.getProductName());
	}

	@Test(dataProvider = "productData", dataProviderClass = ProductDataProvider.class)
	public void ProductImagesTest(Product product) {
		searchResultsPage = accountPage.doSearch(product.getSearchKey());
		productDescPage = searchResultsPage.selectProduct(product.getProductName());
		String actImgCount = productDescPage.getProductImagesCount();
		System.out.println("Product Images actual Count : " + actImgCount);
		Assert.assertEquals(actImgCount, product.getProductImages());
	}

}
