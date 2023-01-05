package sanil.laptopPurchase.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.laptoppurchase.base.TestBase;

import sanil.laptoppurchase.pages.AccountLoginPage;
import sanil.laptoppurchase.pages.LaptopsAndNotebooksPage;
import sanil.laptoppurchase.pages.MyAccountPage;

public class LaptopsAndNotebooksPageTest extends TestBase {
	
	SoftAssert sf;
	@BeforeMethod
	public void setUp() throws InterruptedException {
		launchBrowser();
		sf = new SoftAssert();
	}

	@Test
	public void verifyAlertBannerForInvalidLoginCredentials() throws InterruptedException {
		AccountLoginPage accountLoginPage = new AccountLoginPage();
		MyAccountPage myAccountPage = accountLoginPage.login("name1@gmail.com", "Password1");
		LaptopsAndNotebooksPage laptopsAndNotebooksPage = myAccountPage.clickOnshowAllLaptopsAndNotebooks();
		
		sf.assertEquals(laptopsAndNotebooksPage.getHeadTitleText(), "Laptops & Notebooks");
		sf.assertEquals(driver.getTitle(), "Laptops & Notebooks","Web page title not matching");
		
		laptopsAndNotebooksPage.selectFromSortElementsList();
		laptopsAndNotebooksPage.clickOnWishListFirstItem();
		Thread.sleep(2000);		
		sf.assertEquals(laptopsAndNotebooksPage.getTextFromSuccessAlert(), "Success: You have added Sony VAIO to your wish list!\n×","Not matching product Sony VAIO");
			
		laptopsAndNotebooksPage.clickOnWishListSecondItem();
		Thread.sleep(2000);	
		sf.assertEquals(laptopsAndNotebooksPage.getTextFromSuccessAlert(), "Success: You have added MacBook Pro to your wish list!\n×","Not matching product MacBook Pro");
		
		laptopsAndNotebooksPage.clickOnWishListThirdItem();
		Thread.sleep(2000);	
		sf.assertEquals(laptopsAndNotebooksPage.getTextFromSuccessAlert(), "Success: You have added MacBook Air to your wish list!\n×","Not matching product MacBook Air");
		
		laptopsAndNotebooksPage.clickOnWishListLink();
		 sf.assertAll();
	}

	@AfterMethod
	public void teardown() {
		 quitBrowser();
	}

}
