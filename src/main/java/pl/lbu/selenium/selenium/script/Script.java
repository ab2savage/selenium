package pl.lbu.selenium.selenium.script;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import pl.lbu.selenium.driver.Driver;



@Listeners(pl.lbu.selenium.testng.TestNGListenerLogger.class)
public class Script {

	private Driver driver;
	private WebDriver webDriver;

	public WebDriver driver() {
		return webDriver;
	}
	
	@BeforeTest
	public void setup()
	{
		driver = new Driver();
		webDriver = driver.getWebDriver();
	}
	
	@AfterTest
	public void tearDown()
	{
		webDriver.close();
		String command = "taskkill /F /IM geckodriver.exe";
		try {
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
