package pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	
	public static WebDriver openBrowser(String url) throws InterruptedException {
		
		//System.setProperty("WebDriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.navigate().to(url);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		return driver;
		
		
	}

}
