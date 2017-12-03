package pl.lbu.selenium.script;

import org.testng.annotations.Test;

import pl.lbu.selenium.selenium.script.Script;
import pl.lbu.selenium.testRail.TestRailProject;

//@TestRailProject(projectName = "testGoogleJ")
public class GoogleScript extends Script {

	GoogleLogic googleLogic = new GoogleLogic();

	@Test
	public void googleTest() {
		googleLogic.searchTextInGoogle("test");
	}

}
