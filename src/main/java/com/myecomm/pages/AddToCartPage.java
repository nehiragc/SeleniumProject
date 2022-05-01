package com.myecomm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPage {
	
	By searchbar = By.id("search_query_top");
	By searchButton= By.name("submit_search");
	By addedToCart = By.className("clearfix");
	By addToCartButton = By.xpath("//span[text()='Add to cart']");
	By productImage = By.xpath("//*[@id=\"center_column\"]//img");
	By proceedToCheckout = By.xpath("//span[contains(text(),'Proceed to checkout')]");
	By productName = By.linkText("Faded Short Sleeve T-shirts");
			
	//By addProductToCart = By.className(null)
	
	WebDriver driver;
	WebElement wait;
	WebDriverWait wait2;
	
	
	public AddToCartPage(WebDriver driver){
		this.driver = driver;
		wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10))
		  //      .until(ExpectedConditions.presenceOfElementLocated(searchbar));
	}
	
	public void addProductToCart() {

		driver.findElement(productImage).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
		        .until(ExpectedConditions.presenceOfElementLocated(addToCartButton));
		driver.findElement(addToCartButton).click();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(20))
		        .until(ExpectedConditions.elementToBeClickable(proceedToCheckout));
		//driver.findElement(proceedToCheckout).click();
		
	}
	
	public void proceedToCheckout() {

		
		wait = new WebDriverWait(driver, Duration.ofSeconds(20))
		        .until(ExpectedConditions.elementToBeClickable(proceedToCheckout));
		driver.findElement(proceedToCheckout).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20))
		        .until(ExpectedConditions.elementToBeClickable(productName));
		
	}
	
	public Boolean isProductAddedToCart() {
		return wait2.until(ExpectedConditions.visibilityOfElementLocated(productName)).isDisplayed();
	}
	
	
}
