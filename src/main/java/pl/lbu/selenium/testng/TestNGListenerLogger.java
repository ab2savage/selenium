package pl.lbu.selenium.testng;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.testng.IClass;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.xml.XmlTest;

import com.google.inject.Injector;
import com.google.inject.Module;

public class TestNGListenerLogger implements ITestListener, ITestContext {

	@Override
	public Object getAttribute(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttribute(String name, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<String> getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object removeAttribute(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getStartDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getEndDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResultMap getPassedTests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResultMap getSkippedTests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResultMap getFailedButWithinSuccessPercentageTests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResultMap getFailedTests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getIncludedGroups() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getExcludedGroups() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOutputDirectory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISuite getSuite() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITestNGMethod[] getAllTestMethods() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ITestNGMethod> getExcludedMethods() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResultMap getPassedConfigurations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResultMap getSkippedConfigurations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResultMap getFailedConfigurations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XmlTest getCurrentXmlTest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Module> getGuiceModules(Class<? extends Module> cls) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Injector getInjector(List<Module> moduleInstances) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Injector getInjector(IClass iClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addInjector(List<Module> moduleInstances, Injector injector) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
