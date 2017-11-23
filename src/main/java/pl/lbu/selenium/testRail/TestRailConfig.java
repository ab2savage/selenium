package pl.lbu.selenium.testRail;

import java.util.Iterator;
import java.util.List;

import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.TestRail.Projects;
import com.codepine.api.testrail.TestRail.Suites;
import com.codepine.api.testrail.model.Project;
import com.codepine.api.testrail.model.Suite;

public class TestRailConfig {

	private TestRail testRail;

	public TestRailConfig(String url, String login, String password, String applicationName) {
		this.testRail = TestRail.builder(url, login, password).applicationName(applicationName).build();
	}

	public void createNewProject(String projectName) {
		testRail.projects().add(new Project().setName(projectName)).execute();
	}

	public Project getExistsProject(String projectName) {
		Projects projects = testRail.projects();

		Iterator<Project> iterator = projects.list().execute().iterator();

		while (iterator.hasNext()) {
			Project project = (Project) iterator.next();
			if (project.getName().equals(projectName)) {
				return project;
			}
		}
		return null;

	}

	public boolean isProjectExists(String projectName) {
		if (null == getExistsProject(projectName)) {
			return true;
		}
		return false;

	}

	public Suite getSuiteFromProject(Project project, String suitName) {
		Suites suites = testRail.suites();
		List<Suite> suiteList = suites.list(project.getId()).execute();
		for (Suite suite : suiteList) {
			if (suite.getName().equals(suitName)) {
				return suite;
			}
		}
		return null;

	}

	public void setSuite(Project project, String suiteName) {
		testRail.suites().add(project.getId(), new Suite().setName(suiteName)).execute();
	}

}
