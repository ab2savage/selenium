package lbu.pl.selenium.cucumber;

import org.openqa.selenium.WebDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import pl.lbu.selenium.driver.Driver;
import pl.lbu.selenium.selenium.script.Script;

@CucumberOptions(format = { "pretty",
		"json:path/to/json_repot.json" }, features = "pl.lbu.selenium.features", glue = "pl.lbu.selenium.src.test.java.pl.lbu.selenium.cucumber")
public class Runner {

	@After
	public void close() {
		Driver driverClass = new Driver();
		WebDriver driver = driverClass.getWebDriver();
		driver.close();
	}

}
