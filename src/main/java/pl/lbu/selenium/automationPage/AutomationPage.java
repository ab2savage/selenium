package pl.lbu.selenium.automationPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import java.util.List;
import pl.lbu.selenium.selenium.page.Page;

public class AutomationPage extends Page {

	private String url;

	public void getPageByUrl(String url) {
		driver.get(url);
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public String getURL() {
		return url;
	}

	public void setURL(String url) {
		this.url = url;
	}

	public void getAllInputByType(String type) {
		List<WebElement> buttonList = driver.findElements(By.xpath("//input"));

		for (WebElement element : buttonList) {
			if (element.getAttribute("type").equals(type) && !element.getAttribute("type").equals("hidden")) {
				getAttributes(element);
			}
		}
	}

	public void getAllAHref() {
		List<WebElement> aHrefList = driver.findElements(By.xpath("//a[@href!='']"));

		for (WebElement element : aHrefList) {

			if (waitForClicable(element)) {
				getAttributes(element);
			}

		}
	}

	private void getAttributes(WebElement element) {
		System.out.println("id: " + element.getAttribute("id"));
		System.out.println("name: " + element.getAttribute("name"));
		System.out.println("text: " + element.getText());
		System.out.println("value: " + element.getAttribute("value"));
		System.out.println("href: " + element.getAttribute("href"));
		System.out.println("class: " + element.getAttribute("class"));
		System.out.println("title: " + element.getAttribute("title"));
		System.out.println("background: " + element.getCssValue("background"));
		System.out.println("style: " + element.getCssValue("style"));
		System.out.println("background-color: " + element.getCssValue("background-color"));
		System.out.println("color: " + Color.fromString(element.getCssValue("color")).asHex());
		System.out.println("parent tag: " + element.findElement(By.xpath("..")).getTagName());
		System.out.println("xpath: " + "//" + element.findElement(By.xpath("..")).getTagName() + "/"
				+ element.getTagName() + "[text()='" + element.getText() + "']");
		System.out.println("------------------------");
	}

}
