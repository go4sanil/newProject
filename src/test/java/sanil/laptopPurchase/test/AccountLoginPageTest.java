package sanil.laptopPurchase.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.laptoppurchase.base.TestBase;

import sanil.laptoppurchase.pages.AccountLoginPage;

public class AccountLoginPageTest extends TestBase {
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		launchBrowser();
	}

	@Test
	public void verifyAlertBannerForInvalidLoginCredentials() {
		AccountLoginPage accountLoginPage = new AccountLoginPage();
		accountLoginPage.login("iron.man@gmail.com", "a-vengers.com");
		
	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}
	
	
	
	
}
