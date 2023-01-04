package sanil.laptopPurchase.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.laptoppurchase.base.TestBase;

import sanil.laptoppurchase.pages.AccountLoginPage;
import sanil.laptoppurchase.pages.MyAccountPage;

public class MyAccountPageTest extends TestBase {
	@BeforeMethod
	public void setUp() throws InterruptedException {
		launchBrowser();
	}

	@Test
	public void verifyAlertBannerForInvalidLoginCredentials() throws InterruptedException {
		AccountLoginPage accountLoginPage = new AccountLoginPage();
		MyAccountPage myAccountPage = accountLoginPage.login("name1@gmail.com", "Password1");
		myAccountPage.clickOnshowAllLaptopsAndNotebooks();
		
	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}


}
