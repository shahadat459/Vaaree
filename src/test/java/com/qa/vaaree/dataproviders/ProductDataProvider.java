package com.qa.vaaree.dataproviders;

import org.testng.annotations.DataProvider;

import com.qa.vaaree.pojo.Product;

public class ProductDataProvider {
	@DataProvider(name = "productData")
	public Object[][] getProductTestData() {
		return new Object[][] {
			{new Product("bottle","Stella Textured Fliptop Bottle - Pink","4")},
			{new Product("bedsheet","Trance Lines Abstract Bedsheet","4")},
			{new Product("red","Quilted Trails Comforter - Red","3")}	
		};
		
		
	}
	
	@DataProvider(name = "productDataWithSearchKey")
	public Object[][] getProductSearchKeyData() {
		return new Object[][] {
			{"bottle"},
			{"bedsheet"},
			{"red"}
			
		};
	}
	
	@DataProvider(name = "productDataWithProductName")
	public Object[][]getProductData() {
		return new Object[][] {
			{"bottle","Stella Textured Fliptop Bottle - Pink"},
			{"bedsheet","Trance Lines Abstract Bedsheet"},
			{"red","Quilted Trails Comforter - Red"}
			
		};
	}
	
	@DataProvider(name = "productDataWithImgCount")
	public Object[][]getProductImageTestData() {
		return new Object[][] {
			{"bottle","Stella Textured Fliptop Bottle - Pink","4"},
			{"bedsheet","Trance Lines Abstract Bedsheet","4"},
			{"red","Quilted Trails Comforter - Red","3"}	
		};
	}

}
