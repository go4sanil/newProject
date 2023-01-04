package sanil.laptoppurchase.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.laptoppurchase.base.TestBase;

public class MyAccountPage extends TestBase {

	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}

	Actions action = new Actions(driver);

	@FindBy(css = "ul.nav.navbar-nav>li:nth-of-type(2)>a")
	WebElement laptopsAndNotebooksLink;

	@FindBy(xpath = "//a[text()='Show All Laptops & Notebooks']")
	WebElement showAllLaptopsAndNotebooks;

	public LaptopsAndNotebooksPage clickOnshowAllLaptopsAndNotebooks() {

		action.moveToElement(laptopsAndNotebooksLink).perform();

		showAllLaptopsAndNotebooks.click();
		return new LaptopsAndNotebooksPage();
	}

}
