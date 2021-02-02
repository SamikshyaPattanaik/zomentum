package com.zomentum.allPages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	//Home Page Header Text
	@FindBy(xpath = ".//span[text()='All Opportunities']")
	WebElement pageHeaderText;

	public void getHeaderText() {
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String text = pageHeaderText.getText();
		Assert.assertTrue(text.contains("Opportunities"), "Home Page Verified");
	}

	//Navigate Setting Menu
	@FindBy(id = "submenu-trigger")
	WebElement menuSetting;

	public void clickMenuSetting() {
		menuSetting.click();
	}

	//Navigate Logout
	@FindBy(xpath = ".//div[@class='logout-tile']")
	WebElement btnLogout;

	public void clickLogout() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		btnLogout.click();
		System.out.println("Logged Out successfully");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

}
