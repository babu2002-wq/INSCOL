package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BasePage {

	WebDriver driver;
	Actions actions;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		this.actions = new Actions(driver);
	}
}
