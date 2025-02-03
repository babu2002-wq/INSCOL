package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class SignIn extends BasePage{

	public SignIn(WebDriver driver) {
		super(driver);
	}
	
	
	By logo=By.xpath("//img[@class='w-36 ng-tns-c2505047745-1']");
	By welcome=By.xpath("//h2[normalize-space()='Welcome back']");
	By email=By.xpath("//input[@id='mat-input-0']");
	By password=By.xpath("//input[@id='mat-input-1']");
	By remembertext=By.xpath("//label[normalize-space()='Remember Me']");
	By remembercheckbox=By.xpath("//input[@id='mat-mdc-checkbox-1-input']");
	By forgotpassword=By.xpath("//a[normalize-space()='Forgot Password?']");
	By signin=By.xpath("//span[@class='mdc-button__label']");
	By passwordtoggle=By.xpath("//button[@class='mat-mdc-tooltip-trigger mdc-icon-button mat-mdc-icon-button mat-unthemed mat-mdc-button-base ng-tns-c1798928316-3']//span[@class='mat-mdc-button-touch-target']");
	By register=By.xpath("//a[normalize-space()='Click here to create one']");
	By signinmsg=By.xpath("//h4[normalize-space()='Sign in with your credentials below.']");
	By togglemsg=By.xpath("//mat-hint[@id='mat-mdc-hint-0']");
	By registerPageMsg=By.xpath("//h2[normalize-space()='Register for an account']");
	By signinback=By.xpath("//a[normalize-space()='Sign in here']");
	
	
	public WebElement LogoDisplayed() {
		WebElement inslogo=driver.findElement(logo);
		return inslogo;
		
	}
	
	public void enterusername(String user) {
		WebElement emailID=driver.findElement(email);
		emailID.clear();
		emailID.sendKeys(user);
	}
	
	public void enterpassword(String pass) {
		WebElement Password=driver.findElement(password);
		Password.clear();
		Password.sendKeys(pass);
	}
	
	public WebElement WelcomeDisplayed() {
		return driver.findElement(welcome);
	}
	
	public WebElement rememberDisplayed() {
		WebElement remember=driver.findElement(remembertext);
		return remember;	
	}
	
	public void rememberClick() {
		driver.findElement(remembercheckbox).click();
	}
	
	public String SignInMsg() {
		String signInMsg=driver.findElement(signinmsg).getText();
		return signInMsg;
	}
	
	public void forgotPassword() {
		WebElement ForgotPass=driver.findElement(forgotpassword);
		ForgotPass.click();
		
	}
	
	public void createAccount() {
		WebElement CreateNew=driver.findElement(register);
		CreateNew.click();
	}
	
	public void passwordTest() {
		WebElement Togglebtn=driver.findElement(passwordtoggle);
		Togglebtn.click();
		
	}
	
	public void signInClick() {
		driver.findElement(signin).click();
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public String ToggleMsg() {
		String Togglemsg=driver.findElement(togglemsg).getText();
		return Togglemsg;
	}
	
	
}
