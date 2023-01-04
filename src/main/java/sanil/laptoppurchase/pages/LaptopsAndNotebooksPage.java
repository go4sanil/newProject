package sanil.laptoppurchase.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.laptoppurchase.base.TestBase;

public class LaptopsAndNotebooksPage extends TestBase {

	public LaptopsAndNotebooksPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div#content>div:nth-of-type(4)>div:nth-of-type(1) button:nth-of-type(2)")
	WebElement wishListFirstItem;

	@FindBy(css = "div#content>div:nth-of-type(4)>div:nth-of-type(2) button:nth-of-type(2)")
	WebElement wishListSecondItem;

	@FindBy(css = "div#content>div:nth-of-type(4)>div:nth-of-type(3) button:nth-of-type(2)")
	WebElement wishListThirdItem;

	@FindBy(css = "div.alert")
	WebElement successAlertLink;

	@FindBy(css = "ul.list-inline>li:nth-of-type(3)")
	WebElement wishListLink;

	@FindBy(css = "select#input-sort")
	WebElement sortElement;

	@FindBy(css = "button.close")
	WebElement successAlertcloseBtn;
	
	@FindBy(css = "div#content h2")
	WebElement headTitleText;

	public void selectFromSortElementsList() {
		Select sc = new Select(sortElement);
		sc.selectByVisibleText("Rating (Highest)");
	}

	public void clickOnWishListFirstItem() {
		wishListFirstItem.click();

	}

	public void clickOnWishListSecondItem() {
		wishListSecondItem.click();

	}

	public void clickOnWishListThirdItem() {
		wishListThirdItem.click();

	}

	public String getTextFromSuccessAlert() {

		return successAlertLink.getText();

	}

	public MyWishListPage clickOnWishListLink() {
		wishListLink.click();
		return new MyWishListPage();

	}
	
	public String getHeadTitleText() {
		 
		return headTitleText.getText();

	}

}
