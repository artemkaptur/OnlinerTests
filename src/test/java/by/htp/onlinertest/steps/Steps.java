/**
 * 
 */
package by.htp.onlinertest.steps;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import by.htp.onlinertest.driver.DriverSingleton;
import by.htp.onlinertest.pages.MainPage;
import by.htp.onlinertest.pages.MakersPage;

/**
 * @author user
 *
 */
public class Steps {
	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	private void searchMakersFromMinsk() throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		mainPage.clickOnMakers();
		MakersPage makersPage = new MakersPage(driver);
		makersPage.clickOnFromMinskCheckBox();
	}

	public List<WebElement> getMakersFromMinsk() throws InterruptedException {
		searchMakersFromMinsk();
		logger.info("Start searching makers from Minsk");
		MakersPage makersPage = new MakersPage(driver);
		return makersPage.getSearchResults();
	}

	public List<WebElement> getSoftwareMakers() throws InterruptedException {
		searchMakersFromMinsk();
		MakersPage makersPage = new MakersPage(driver);
		makersPage.selectSoftwareMakers();
		logger.info("Start searching software makers");
		return makersPage.getSearchResults();
	}

	public List<WebElement> getSoftwareMakersWithRep() throws InterruptedException {
		searchMakersFromMinsk();
		MakersPage makersPage = new MakersPage(driver);
		makersPage.selectSoftwareMakers();
		logger.info("Start searching software makers with reputation");
		return makersPage.getSearchResultsWithRep();
	}
}
