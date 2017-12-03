package pl.lbu.selenium.selenium.script;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import pl.lbu.selenium.driver.Driver;
import pl.lbu.selenium.testRail.TestRailConfig;
import pl.lbu.selenium.testRail.TestRailProject;

@Listeners(pl.lbu.selenium.testng.TestNGListener.class)
public class Script {

	private Driver driver;
	private WebDriver webDriver;
	TestRailConfig testRailConfig = new TestRailConfig("https://savage.testrail.io/", "bubolka.lukasz@gmail.com",
			"FE1jofWVQVhGV641g5TR", "savage");

	public WebDriver driver() {
		return webDriver;
	}

	@BeforeTest
	public void setup() {
		driver = new Driver();
		webDriver = driver.getWebDriver();
		addToProject();
	}

	@AfterTest
	public void tearDown() {
		webDriver.close();
		String command = "taskkill /F /IM geckodriver.exe";
		try {
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addToProject() {
		if (isAnnotationPresent()) {

			String projectName = this.getClass().getAnnotation(TestRailProject.class).projectName();

			if (testRailConfig.isProjectExists(projectName)) {
				testRailConfig.createNewProject(projectName);
			}

		}
	}

	private boolean isAnnotationPresent() {
		return this.getClass().isAnnotationPresent(TestRailProject.class);
	}

}
