package sanil.laptopPurchase.test;

import java.awt.AWTException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.laptoppurchase.base.TestBase;

import sanil.laptoppurchase.pages.AccountLoginPage;
import sanil.laptoppurchase.pages.LaptopsAndNotebooksPage;
import sanil.laptoppurchase.pages.MyAccountPage;
import sanil.laptoppurchase.pages.MyWishListPage;

public class MyWishListTest extends TestBase {
	SoftAssert sf;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		sf = new SoftAssert();
	}

	@Test
	public void verifyAddingProductToWishList() throws AWTException {
		AccountLoginPage accountLoginPage = new AccountLoginPage();
		MyAccountPage myAccountPage = accountLoginPage.login("name1@gmail.com", "Password1");
		LaptopsAndNotebooksPage laptopsAndNotebooksPage = myAccountPage.clickOnshowAllLaptopsAndNotebooks();
		sf.assertEquals(driver.getTitle(), "Laptops & Notebooks");
		laptopsAndNotebooksPage.selectFromSortElementsList();
		laptopsAndNotebooksPage.clickOnWishListFirstItem();
		laptopsAndNotebooksPage.clickOnWishListSecondItem();
		laptopsAndNotebooksPage.clickOnWishListThirdItem();
		MyWishListPage myWishListPage = laptopsAndNotebooksPage.clickOnWishListLink();
		sf.assertEquals(myWishListPage.getElementFromTable("MacBook Air", 1), "MacBook Air");
		sf.assertEquals(myWishListPage.getElementFromTable("MacBook Pro", 2), "MacBook Pro");
		sf.assertEquals(myWishListPage.getElementFromTable("Sony VAIO", 3), "Sony VAIO");
		myWishListPage.removeLastElement();
		sf.assertEquals(myWishListPage.getTextFromSuccessAlert(), "Success: You have modified your wish list!");
		sf.assertAll();

	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}

}
