package com.zomentum.testCases;

import org.testng.annotations.Test;
import com.zomentum.allPages.HomePage;
import com.zomentum.allPages.LoginPage;

public class TC001_Login extends Initiate{

	@Test
	public void login() throws InterruptedException {

		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);

		lp.getLoginPageText();
		lp.clickSignIn();
		lp.loginCredential(userid , password);

		hp.getHeaderText();
		hp.clickMenuSetting();
		hp.clickLogout();
	}
}
