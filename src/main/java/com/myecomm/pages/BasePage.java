package com.myecomm.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;

public class BasePage {
	
	public static WebDriver driver;
	public static String baseUrl="http://automationpractice.com/index.php?";
	
	@BeforeSuite
	public void testSetUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/macbook/Desktop/SeleniumWebdrivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
		System.out.println("The driver quitted.");
	}


}
