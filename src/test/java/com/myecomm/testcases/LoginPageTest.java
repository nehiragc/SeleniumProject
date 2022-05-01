package com.myecomm.testcases;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;


import com.myecomm.pages.*;

public class LoginPageTest extends BasePage{

	public String username = "testuser_3004@test.com";
	public String password = "qwerty123";
	
	@Test(priority=0)
	public void navigateToLoginPage() throws Throwable {
		HomePage homePage = new HomePage(driver);
		homePage.clickSignInButton();
		AssertJUnit.assertEquals(driver.getTitle(), "Login - My Store");
		System.out.println("Navigated to the log in page.");
		
	}
	
	@Test(priority=1)
	public void enterCredentialsAndLogin() {

		LoginPage login = new LoginPage(driver);
		login.typeUsername(username);
		login.typePassword(password);
		login.clickSignIn();
		
	    AssertJUnit.assertEquals(driver.getTitle(), "My account - My Store");
	    System.out.println("Logged in successfully.");

	}
}
