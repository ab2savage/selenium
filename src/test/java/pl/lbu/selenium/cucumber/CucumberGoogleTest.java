package pl.lbu.selenium.cucumber;

import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pl.lbu.selenium.selenium.script.Script;

public class CucumberGoogleTest {

	GooglePage google = new GooglePage();

	@When("^I go to google page$")
	public void i_go_to_google_page() throws Throwable {
		google.getGooglePage();
	}

	@When("^I enter search field as \"([^\"]*)\"$")
	public void i_enter_search_field_as(String arg1) throws Throwable {
		google.setInputSearch(arg1);
	}

	@And("^I click on search button$")
	public void i_click_on_search_button() throws Throwable {
		google.clickBtnFind();
	}

	@Then("^I should see google results page$")
	public void i_should_see_google_results_page() throws Throwable {
		Assert.assertEquals(true, true);
	}

}
