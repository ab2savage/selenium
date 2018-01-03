package pl.lbu.selenium.automatitionPage;

import org.testng.annotations.Test;

import pl.lbu.selenium.automationPage.AutomationPage;
import pl.lbu.selenium.selenium.script.Script;

public class AutomationScript extends Script {

	AutomationPage automationPage = new AutomationPage();

	@Test
	public void getPageSource() {

		automationPage.getPageByUrl("https://www.google.pl/");
		automationPage.getAllInputByType("submit");
		automationPage.getAllInputByType("text");
		automationPage.getAllAHref();

	}
}
