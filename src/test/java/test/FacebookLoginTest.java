package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

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
	@Test
	public void enterValidCredentials() throws InterruptedException, IOException {
		extentTest=extentReports.createTest("enterValidCredentials");
		//WebDriver driver=LaunchBrowser.openBrowser("https://www.facebook.com/");
		FacebookLoginPage loginTest=new FacebookLoginPage(driver);
		loginTest.enterEmailID("Arise");
		loginTest.enterPassword("12345");
		loginTest.clickLoginButton();
		Screenshot.takeScreenshot(driver, "name");	
		}
	
	
	@Test
	public void enterValidUnameAndInvalidPassword() throws InterruptedException, IOException {
		extentTest=extentReports.createTest("enterValidUnameAndInvalidPassword");
		//WebDriver driver=LaunchBrowser.openBrowser("https://www.facebook.com/");
		FacebookLoginPage loginTest=new FacebookLoginPage(driver);
		loginTest.enterEmailID("Arise");
		loginTest.enterPassword("123");
		loginTest.clickLoginButton();
		Screenshot.takeScreenshot(driver, "name1");
	}
	
	@Test
	public void enetrInvalidUnameAndValidPassword() throws InterruptedException, IOException {
		extentTest=extentReports.createTest("enetrInvalidUnameAndValidPassword");
		//WebDriver driver=LaunchBrowser.openBrowser("https://www.facebook.com/");
		FacebookLoginPage loginTest=new FacebookLoginPage(driver);
		
		loginTest.enterEmailID("A");
		loginTest.enterPassword("12345");
		loginTest.clickLoginButton();
		Screenshot.takeScreenshot(driver, "name2");
		
	}

}
