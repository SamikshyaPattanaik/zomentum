package com.zomentum.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.zomentum.utility.ReadPropertiesFile;

public class Initiate {

	ReadPropertiesFile properties = new ReadPropertiesFile();
	public String URL = properties.getUrl();
	public String userid = properties.getUserId();
	public String password = properties.getPassword();
	public static WebDriver driver=null;

	@BeforeClass
	@Parameters("browser")
	public void setup(String browser) {

		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", properties.getChromePath());
			driver = new ChromeDriver();

		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", properties.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);



	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
