package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginPage {
	
	@FindBy (xpath="//input[@id='email']") private WebElement email;
	@FindBy (xpath="//input[@id='pass']") private WebElement pass;
    @FindBy (xpath="//button[@name='login']") private WebElement login;
    
    public FacebookLoginPage(WebDriver driver) {
    	PageFactory.initElements(driver,this);
    }
    
    public void enterEmailID(String emailID) {
    email.sendKeys(emailID);
    }
    
    public void enterPassword(String password) {
    pass.sendKeys(password);
    }
    
    public void clickLoginButton() {
    	login.click();
    }
}
