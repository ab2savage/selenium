package pl.lbu.selenium.script;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import pl.lbu.selenium.selenium.page.Page;

public class GooglePage extends Page {
	private final String URL = "https://www.google.pl/";

	@FindBy(xpath = "//input[@title='Szukaj']")
	private WebElement inpFind;

	@FindBys({ @FindBy(xpath = "//input[@value='Szukaj w Google']"), @FindBy(xpath = "//input[@type='submit']") })
	private WebElement btnFind;

	public void getGooglePage() {
		driver.get(URL);
	}

	public void setInputSearch(String inputText) {
		inpFind.clear();
		inpFind.sendKeys(inputText);
	}

	public void sendClickToInputFind() {
		inpFind.click();
	}

	public void clickBtnFind() {
		btnFind.click();
	}

}
