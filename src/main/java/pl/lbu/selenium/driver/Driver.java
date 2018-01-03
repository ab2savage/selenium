package pl.lbu.selenium.driver;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import pl.lbu.selenium.properties.Property;

public class Driver {

	private final String DRIVER_PROPERTIE = "driver";
	private final String CONFIG_PROPERTIES = "config.properties";
	private Property projectProperties = new Property(CONFIG_PROPERTIES);
	private final String LANGUAGE = projectProperties.getValueFromPropertiesFileByKey("lang");
	private static WebDriver webDriver;

	public Driver() {

	}

	private void setManage() {
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webDriver.manage().deleteAllCookies();
		webDriver.manage().window().maximize();
	}

	private void setDesiredCapabilitiesAndWebDriver() {
		String driverType = projectProperties.getValueFromPropertiesFileByKey(DRIVER_PROPERTIE);
		if (null != driverType && !driverType.equals("")) {
			DriverType type = DriverType.getDriverTypes(driverType);

			switch (type) {
			case CHROME:
				webDriver = setDesiredCapabilitiesForChrome();
				break;
			case IE:
				break;
			case FIREFOX:
				webDriver = setDesiredCapabilitiesForFirefox();
				break;
			default:
				webDriver = setDesiredCapabilitiesForChrome();
				break;
			}
		} else {
			webDriver = setDesiredCapabilitiesForChrome();
		}

	}

	private ChromeDriver setDesiredCapabilitiesForChrome() {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		URL url = this.getClass().getResource("/chromedriver.exe");
		ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(new File(url.getPath()))
				.usingAnyFreePort().build();
		ChromeOptions options = new ChromeOptions();
		options.merge(capabilities);
		return new ChromeDriver(service, options);
	}

	private FirefoxDriver setDesiredCapabilitiesForFirefox() {
		DesiredCapabilities firefoxCapabilities = DesiredCapabilities.firefox();
		URL url = this.getClass().getResource("/geckodriver.exe");
		GeckoDriverService firefoxService = new GeckoDriverService.Builder()
				.usingDriverExecutable(new File(url.getPath())).usingAnyFreePort().build();
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setPreference("intl.accept_languages", LANGUAGE);
		firefoxOptions.setProfile(firefoxProfile);
		firefoxOptions.setLogLevel(FirefoxDriverLogLevel.FATAL);
		firefoxOptions.merge(firefoxCapabilities);
		return new FirefoxDriver(firefoxService, firefoxOptions);
	}

	public WebDriver getWebDriver() {
		setDriver();
		return webDriver;
	}

	private void setDriver() {
		if (null == webDriver) {
			setDesiredCapabilitiesAndWebDriver();
			setManage();
		}
	}

}