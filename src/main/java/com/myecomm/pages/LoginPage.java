package com.myecomm.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	By usernameField = By.id("email");
	By passwordField = By.id("passwd");
	By signInButton = By.id("SubmitLogin");	
	
	
	WebDriver driver;
	WebElement wait;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		//Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
		        .until(ExpectedConditions.presenceOfElementLocated(usernameField));
	}
	
	public void typeUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}
	
	public void typePassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void clickSignIn(){
		driver.findElement(signInButton).click();
	}
	
}
