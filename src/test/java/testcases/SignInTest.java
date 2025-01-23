package testcases;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.BaseClass;

import PageObjects.SignIn;

public class SignInTest extends BaseClass {
	

	@Test(priority=1)
	public void ValidateUrl() {
		
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://erpindia.inscol.com/auth/sign-in";
		Assert.assertEquals(actualURL, expectedURL, "The URLs do not match!");
		
	}
	
	@Test(priority=2)
	public void IsLogoDisplayed() {
		SignIn sign=new SignIn(driver);
		Assert.assertTrue(sign.LogoDisplayed().isDisplayed(), "Logo is not displayed!");
	}
	
	@Test(priority=10)
	public void enterusername() {
		SignIn sign=new SignIn(driver);
		sign.enterusername("uttam@cybrain.co.in");
	}
	
	@Test(priority=11)
	public void enterpassword() {
		SignIn sign=new SignIn(driver);
		sign.enterpassword("123");
	}
	
	@Test(priority=5)
	public void IsWelcomeDisplayed() {
		SignIn sign=new SignIn(driver);
		Assert.assertTrue(sign.WelcomeDisplayed().isDisplayed(), "Msg is not displayed!");
		Assert.assertEquals(sign.WelcomeDisplayed().getText(), "Welcome back");
	}
	
	@Test(priority=6)
	public void IsrememberDisplayed() {
		SignIn sign=new SignIn(driver);
		Assert.assertTrue(sign.rememberDisplayed().isDisplayed(), "Msg is not displayed!");
		Assert.assertEquals(sign.rememberDisplayed().getText(), "Remember Me");
	}
	
	@Test(priority=7)
	public void SignInDisplayed() {
		SignIn sign=new SignIn(driver);
		Assert.assertEquals(sign.SignInMsg(), "Sign in with your credentials below.");
	}
	
	@Test(priority=8)
	public void rememberClick() {
		SignIn sign=new SignIn(driver);
		sign.rememberClick();
	}
	
	@Test(priority=9)
	public void IsForgot() {
		SignIn sign=new SignIn(driver);
		String presentUrl=driver.getCurrentUrl();
		sign.forgotPassword();
		String newUrl=driver.getCurrentUrl();
		Assert.assertNotEquals( presentUrl, newUrl);
	}
	
	@Test(priority=12)
	public void register() {
		SignIn sign=new SignIn(driver);
		String presentUrl=driver.getCurrentUrl();
		sign.createAccount();
		String newUrl=driver.getCurrentUrl();
		Assert.assertNotEquals(presentUrl, newUrl);
		
	}
	
	//@Test(priority=11)
	public void toggleMsgDisplayed() {
		SignIn sign=new SignIn(driver);
		Assert.assertEquals(sign.ToggleMsg(), "Click the eye to toggle visibility");
	}
	
	@Test(priority=10)
	public void passwordToggleTest() {
		SignIn sign=new SignIn(driver);
		Assert.assertEquals(sign.getPassword().getAttribute("type"), "password" );
		sign.passwordTest();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Assert.assertEquals(sign.getPassword().getAttribute("type"), "text");
		sign.passwordTest();
		Assert.assertEquals(sign.getPassword().getAttribute("type"), "password" );
	}
	
	@Test(priority=14)
	public void IsSignClicked() {
		SignIn sign=new SignIn(driver);
		String presentUrl=driver.getCurrentUrl();
		sign.signInClick();
		String newUrl=driver.getCurrentUrl();
		Assert.assertNotEquals("URLs are the same!", presentUrl, newUrl);
	}
	
	
}
