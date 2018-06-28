package action;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.WebElementLocators;

public class PopupWindowsActions {
	WebDriver driver;
	WebElementLocators popupWindowsElementLocators;
	
	public PopupWindowsActions(WebDriver driver) throws IOException {
		this.driver = driver;
		popupWindowsElementLocators = new WebElementLocators(driver);
	}
	

	
	
	private WebElement getLaunchWindow() {
		return driver.findElement(By.partialLinkText("Launch"));
	}
	
	
	private String getParentWindow() {
		ArrayList windowHandlers = new ArrayList(driver.getWindowHandles());
		String parentWindow = (String)(windowHandlers.get(0));
		return parentWindow;
	}
	
	private String getChildWindow() {
		ArrayList windowHandlers = new ArrayList(driver.getWindowHandles());
		String childWindow = ((String)windowHandlers.get(1));
		return childWindow;
	}
	
	public void proceedingWithoutOpeningNewWindowTakesToErrorPage() {
		driver.findElement(By.linkText("Proceed")).click();
   		String expectedUrl = "http://10.0.1.86/tatoc/error";
   		assertTrue(expectedUrl.contains(driver.getCurrentUrl()));
   		driver.navigate().back();
	}
	
	public void isLaunchWindowButtonPresent() {
		assertTrue(driver.findElement(By.partialLinkText("Launch")).isDisplayed());
	}
	
	public void  isClickingLaunchOpensNewWinDow() {
		getLaunchWindow().click();
		driver.switchTo().window(getChildWindow());
		String ExpectedUrl = "http://10.0.1.86/tatoc/basic/windows/popup";
		assertTrue(ExpectedUrl.contains(driver.getCurrentUrl()));
	}
	
	public void proceedWithoutTypingInTextBoxTakesToErrorPage() {
		driver.findElement(By.id("submit")).click();
		driver.switchTo().window(getParentWindow());
		driver.findElement(By.linkText("Proceed")).click();
   		String expectedUrl = "http://10.0.1.86/tatoc/error";
   		assertTrue(expectedUrl.contains(driver.getCurrentUrl()));
   		driver.navigate().back();
	}
	
	public void submittingAfterTypingInTextBoxTakesToPopupWindowsPage() {
		getLaunchWindow().click();
		driver.switchTo().window(getChildWindow());
		driver.findElement(By.id("name")).sendKeys("uday");
		driver.findElement(By.id("submit")).click();
		driver.switchTo().window(getParentWindow());
   		String expectedUrl = "http://10.0.1.86/tatoc/basic/windows#";
   		assertTrue(expectedUrl.contains(driver.getCurrentUrl()));
	}
	
	public void proceedingCompletingThePopupWindowsTakesToTokenPage() {
		driver.findElement(By.linkText("Proceed")).click();
   		String expectedUrl = "http://10.0.1.86/tatoc/basic/cookie";
   		assertTrue(expectedUrl.contains(driver.getCurrentUrl()));
	}
}
