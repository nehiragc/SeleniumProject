package com.myecomm.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myecomm.pages.*;

public class AddToCartTest extends BasePage {
 
	
	public String productName = "t-shirt";
	
	@Test (priority=0)
	public void searchProduct() throws Throwable {
		HomePage homePage = new HomePage(driver);
		homePage.searchProduct(productName);
		System.out.println("Product is searched.");
		Assert.assertEquals(homePage.searchResult(), true);

		System.out.println("Search result not null.");
	}
	@Test (priority=1, dependsOnMethods={"searchProduct"})
	public void addProductToCart() {
		
		AddToCartPage addToCartPage = new AddToCartPage(driver);
		
		addToCartPage.addProductToCart();
		System.out.println("Added to cart.");
	}
	
	@Test (priority=2, dependsOnMethods={"searchProduct"}) 
	public void isProductAddedToCart() {
		
		AddToCartPage addToCartPage = new AddToCartPage(driver);
		addToCartPage.proceedToCheckout();
		Assert.assertTrue(addToCartPage.isProductAddedToCart());
		System.out.println("Product added to the cart.");

	}
}
