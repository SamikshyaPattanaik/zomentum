package com.zomentum.allPages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver){ 
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//Sign in/Log in  Page Header Text
	@FindBy(xpath=".//span[@class='welcome-heading']/ancestor::div[@class='ant-row']")
	WebElement loginPageText;

	public void getLoginPageText() {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		String text = loginPageText.getText();
		Assert.assertTrue(text.contains("Please login to your account"), "Login Page Verifies");

	}

	//Navigate SignIn Button
	@FindBy(xpath=".//span[text()='Sign In']")
	WebElement BtnSignIn;

	public void clickSignIn() {
		BtnSignIn.click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	//Click On "User Id" Text box
	@FindBy(id="username")
	WebElement eleUserID;

	//Click on "Password" Text box
	@FindBy(id="password")
	WebElement elePassword;

	//Click On "Continue Button"
	@FindBy(xpath= ".//button[text()='Continue']")
	WebElement BtnContinue;

	public void loginCredential(String userid , String password) {
		eleUserID.sendKeys(userid);
		elePassword.sendKeys(password);
		BtnContinue.click();
	}

}
