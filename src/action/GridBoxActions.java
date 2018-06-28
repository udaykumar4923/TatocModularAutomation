package action;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import util.WebElementLocators;

public class GridBoxActions {
	WebDriver driver;
	WebElementLocators locateGridBoxElements;
	
	public GridBoxActions(WebDriver driver) throws IOException {
		this.driver = driver;
		 locateGridBoxElements = new WebElementLocators(driver);
	}
	
	
    public void clickGridBox(String colorOfBox) {
    	if(colorOfBox == "greenbox") {
    		locateGridBoxElements.getWebElement("Green_gridbox").click();
    	}
    	else {
    		locateGridBoxElements.getWebElement("Red_gridbox").click();
    	}
    }
    
//  public void isclickingRedBoxTakesToErrorPage() {
//		clickGridBox("redbox");
//		String expectedUrl = "http://10.0.1.86/tatoc/error";
//		assertTrue(expectedUrl.contains(driver.getCurrentUrl()));
//		driver.navigate().back();
//	}
//
//  public void isclickingGreenBoxTakesToFrameAndDungeonPage() {
//		clickGridBox("greenbox");
//		String expectedUrl = "http://10.0.1.86/tatoc/basic/frame/dungeon";
//		assertTrue(expectedUrl.contains(driver.getCurrentUrl()));
//	}
    
}
