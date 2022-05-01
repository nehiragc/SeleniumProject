package com.myecomm.pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	By signInButton = By.xpath("//a[@class='login']");

	By signIn = By.id("submitLogin");
	By searchbar = By.id("search_query_top");
	By searchButton = By.name("submit_search");
	//By searchResultText = By.xpath("//*[@id='center_column']/.//span[contains(@class,'heading-counter')]");
	By searchResultText = By.xpath("//html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/h1[1]/span[2]");
	By resultsColumn = By.id("center_column");
	
	WebDriver driver;
	WebElement wait;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void clickSignInButton() throws Throwable {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
		        .until(ExpectedConditions.elementToBeClickable(signInButton));
		driver.findElement(signInButton).click();
		
	}
	public void searchProduct(String searchProductName) throws Throwable {
		driver.findElement(searchbar).sendKeys(searchProductName);
		driver.findElement(searchButton).click();
		Thread.sleep(2000);
	}
	
	
	public boolean searchResult(){
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
		        .until(ExpectedConditions.presenceOfElementLocated(resultsColumn));
		String searchResult = driver.findElement(searchResultText).getText();
		return !searchResult.equals("0 results have been found.");	
	}
}
