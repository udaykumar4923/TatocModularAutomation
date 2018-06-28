package action;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import util.WebElementLocators;

public class FirstPageActions {
	WebElementLocators locateWebELement;
	WebDriver driver;
	
	public FirstPageActions(WebDriver driver) throws IOException {
		this.driver = driver;
		locateWebELement = new WebElementLocators(driver);
	}
	
	public void clickBasicCourse() {
		locateWebELement.getWebElement("Basic_course_button").click();
	}
}
