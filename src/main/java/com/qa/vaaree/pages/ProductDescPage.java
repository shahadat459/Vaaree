package com.qa.vaaree.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.vaaree.utils.ElementUtil;

public class ProductDescPage {

	private WebDriver driver;
	ElementUtil eleUtil;

	private By productHeaderName = By.cssSelector("div#ProductInfo-template--template--16835081404662__main__main h1");
	private By productImages = By.xpath("//div[@class='t4s_ratio t4s-product__media t4s-child-lazyloaded'] /img");
	// 1. constructor of the page class
	public ProductDescPage(WebDriver driver) {
		this.driver = driver;			
		eleUtil = new ElementUtil(this.driver);

	}

	public String getProductHeaderName() {
		return eleUtil.doGetElementText(productHeaderName);

	}
	
	public String  getProductImagesCount() {
		 int count = eleUtil.waitForElementsVisible(productImages,10).size();
		
		return Integer.toString(count);

	}

}
