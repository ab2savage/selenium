package pl.lbu.selenium.selenium.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import pl.lbu.selenium.driver.Driver;

public class Page {
	protected Driver driverClass = new Driver();
	protected WebDriver driver;

	public Page() {
		driver = driverClass.getWebDriver();
		PageFactory.initElements(driver, this);
	}

	protected void waitForLoad() {
		new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
				.executeScript("return document.readyState").equals("complete"));
	}

}