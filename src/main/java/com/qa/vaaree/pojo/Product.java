package com.qa.vaaree.pojo;

public class Product {
	private String searchKey;
	private String productName;
	private String productImages;
	
	public Product(String searchKey, String productName, String count) {
		
		this.searchKey = searchKey;
		this.productName = productName;
		this.productImages = count;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImages() {
		return productImages;
	}

	public void setProductImages(String productImages) {
		this.productImages = productImages;
	}

	@Override
	public String toString() {
		return "Product [searchKey=" + searchKey + ", productName=" + productName + ", productImages=" + productImages
				+ "]";
	}
	

}
