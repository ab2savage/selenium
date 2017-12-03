package pl.lnu.selenium.testRail;

import org.testng.annotations.Test;

import pl.lbu.selenium.selenium.script.Script;
import pl.lbu.selenium.testRail.TestRailProject;

@TestRailProject(projectName = "testGoogle3")
public class GoogleScript extends Script {

	GoogleLogic googleLogic = new GoogleLogic();

	@Test
	public void googleTest() {
		googleLogic.searchTextInGoogle("test");
	}

}
