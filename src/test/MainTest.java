package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import action.FirstPageActions;
import action.FrameAndDungeonActions;
import action.GridBoxActions;
import action.PopupWindowsActions;

public class MainTest {
	WebDriver driver;
	FirstPageActions firstpage;
	GridBoxActions gridboxpage;
	FrameAndDungeonActions frameAndDungeonPage;
	PopupWindowsActions popupWindowsPage;
	
	@BeforeTest
	public void openTatocLink() throws IOException {
		driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		firstpage = new FirstPageActions( driver);
		gridboxpage = new GridBoxActions(driver);
		frameAndDungeonPage = new FrameAndDungeonActions(driver);
		popupWindowsPage = new PopupWindowsActions(driver);
	}
	
	@Test
	public void attempClickingBasicCourse() {
		firstpage.clickBasicCourse();
	}
	
	@Test
	public void attempGridBoxPage() {
		gridboxpage.clickGridBox("redbox");
		driver.navigate().back();
		gridboxpage.clickGridBox("greenbox");
	}
	
	@Test
	public void attemptFrameAndDungeonPage() {
		frameAndDungeonPage.isclickingWithoutColorMatchingTakesToErrorPage();
		//frameAndDungeonPage.proceed();
	}
	
}
