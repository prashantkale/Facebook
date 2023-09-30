package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pom.FacebookLoginPage;
import utility.Reports;
import utility.Screenshot;

public class FacebookLoginTest extends BaseTest{
	
	ExtentReports extentReports;
	ExtentTest extentTest;
	@BeforeClass
	public void addReports() {
		extentReports=Reports.configureReports();
	}
	
	@BeforeMethod
	public void browser() throws InterruptedException {
		driver=LaunchBrowser.openBrowser("https://www.facebook.com/");
	}
	@Test(priority = 1)
	public void enterValidCredentials() throws InterruptedException, IOException {
		extentTest=extentReports.createTest("enterValidCredentials");
		//WebDriver driver=LaunchBrowser.openBrowser("https://www.facebook.com/");
		FacebookLoginPage loginTest=new FacebookLoginPage(driver);
		loginTest.enterEmailID("Arise");
		loginTest.enterPassword("12345");
		loginTest.clickLoginButton();
		Screenshot.takeScreenshot(driver, "name");	
		}
	
	
	@Test(priority = 2)
	public void enterValidUnameAndInvalidPassword() throws InterruptedException, IOException {
		extentTest=extentReports.createTest("enterValidUnameAndInvalidPassword");
		//WebDriver driver=LaunchBrowser.openBrowser("https://www.facebook.com/");
		FacebookLoginPage loginTest=new FacebookLoginPage(driver);
		loginTest.enterEmailID("Arise");
		loginTest.enterPassword("123");
		Thread.sleep(500);
		loginTest.clickLoginButton();
		Screenshot.takeScreenshot(driver, "name1");
	}
	
	@Test(priority = 3,dependsOnMethods = "enterValidUnameAndInvalidPassword")
	public void enetrInvalidUnameAndValidPassword() throws InterruptedException, IOException {
		extentTest=extentReports.createTest("enetrInvalidUnameAndValidPassword");
		//WebDriver driver=LaunchBrowser.openBrowser("https://www.facebook.com/");
		FacebookLoginPage loginTest=new FacebookLoginPage(driver);
		
		loginTest.enterEmailID("A");
		loginTest.enterPassword("12345");
		loginTest.clickLoginButton();
		Screenshot.takeScreenshot(driver, "name2");
		
	}
	@AfterMethod
	public void closeBrowser(ITestResult result) {
		if(result.getStatus()==result.SUCCESS)
		{
			extentTest.log(Status.PASS, result.getName());
		}
		else if(result.getStatus()==result.FAILURE)
		{
			extentTest.log(Status.FAIL,result.getName());
		}
		else if(result.getStatus()==result.SKIP)
		{
			extentTest.log(Status.SKIP,result.getName());
		}
		driver.close();
	}
	@AfterClass
	public void flushData() {
		extentReports.flush();
	}

}
