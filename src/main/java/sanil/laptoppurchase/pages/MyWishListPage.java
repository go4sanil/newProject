package sanil.laptoppurchase.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.laptoppurchase.base.TestBase;

public class MyWishListPage extends TestBase {

	public MyWishListPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div.alert")
	WebElement successAlertLink;

	public String getElementFromTable(String productName, int rowNumber) {

		List<WebElement> rowsInTable = driver
				.findElements(By.cssSelector("table[class='table table-bordered table-hover'] tbody tr"));

		return rowsInTable.get(rowNumber - 1).findElements(By.cssSelector("td")).get(1).getText();

	}

	public String getTextFromSuccessAlert() {

		return successAlertLink.getText();

	}

	public void removeLastElement() throws AWTException

	{
		List<WebElement> headers = driver
				.findElements(By.cssSelector("table[class='table table-bordered table-hover'] tbody tr"));
		headers.get(headers.size() - 1).findElements(By.cssSelector("td")).get(2).click();

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

}
