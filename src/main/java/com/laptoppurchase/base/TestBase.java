package com.laptoppurchase.base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.laptoppurchase.browsers.Browsers;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public Browsers DEFAULT_BROWSER = Browsers.GOOGLE_CHROME;

    public void launchBrowser() {

    	switch (DEFAULT_BROWSER) {
		case GOOGLE_CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("Not a valid browser");
			break;
        }
    	

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    

        driver.manage().window().maximize();
 
        // Launch a page
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

    }

    public void quitBrowser() {

        driver.quit();
    }

}
