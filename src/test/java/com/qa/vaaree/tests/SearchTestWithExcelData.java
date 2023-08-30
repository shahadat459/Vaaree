package com.qa.vaaree.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.vaaree.base.BaseTest;
import com.qa.vaaree.utils.ExcelUtil;

public class SearchTestWithExcelData extends BaseTest {
	@BeforeClass
	public void searchSetup() {
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@DataProvider(name = "prodExcelData")
	public Object[][] getProdExcelTestData() {
		Object[][] prodData = ExcelUtil.getTestData("productData");
		System.out.println("data=====>>" + prodData.toString());
		return prodData;
	}

	@Test(dataProvider = "prodExcelData")
	public void productImagesTest(String searchKey, String productName, String imgCount) {
		searchResultsPage = accountPage.doSearch(searchKey);
		productDescPage = searchResultsPage.selectProduct(productName);
		String actImgCount = productDescPage.getProductImagesCount();
		System.out.println("Product Images actual Count : " + actImgCount);
		Assert.assertEquals(actImgCount, imgCount);
	}

}
