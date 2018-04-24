/**
 * 
 */
package by.htp.onlinertest.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author user
 *
 */
public class MakersPage extends AbstractPage {
	private final String BASE_URL = "https://s.onliner.by/profiles";

	@FindBy(xpath = "//*[@id='service-list']/div[2]/div/div/div[1]/div[1]/div[1]/div/div[2]/div[1]/ul/li[1]/label/span/span[1]")
	private WebElement fromMinskCheckBox;

	@FindBy(xpath = "//*[@id='service-list']/div[2]/div/div/div[1]/div[1]/div[2]/div/div[2]/div/div/div[11]")
	private WebElement computerHelpCategory;

	@FindBy(xpath = "//*[@id='service-list']/div[2]/div/div/div[1]/div[1]/div[2]/div/div[2]/div/div/div[11]/div[2]/ul/li[1]/label/span/span[1]")
	private WebElement softwareSupport;

	public MakersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void clickOnFromMinskCheckBox() {
		fromMinskCheckBox.click();
	}

	public void selectSoftwareMakers() throws InterruptedException {
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", computerHelpCategory);
		computerHelpCategory.click();
		Thread.sleep(2000);
		softwareSupport.click();
	}

	public List<WebElement> getSearchResults() {
		List<WebElement> searchResults = driver.findElements(By.xpath(
				"//*[@id='service-list']/div[2]/div/div/div[2]/search-profiles-list/div/div/div/search-profiles-item/div/div/div[1]/div"));
		return searchResults;
	}

	public List<WebElement> getSearchResultsWithRep() {
		List<WebElement> searchResultsByOrders = driver.findElements(By.xpath(
				"//*[@id='service-list']/div[2]/div/div/div[2]/search-profiles-list/div/div/div/search-profiles-item/div/div/div[1]/div[not(substring(./div/div/a[1]/text(), 10, 2)='1 ') and not(substring(./div/div/a[1]/text(), 10, 2)='2 ') and not(substring(./div/div/div/rating-popover/div/a/span[2]/text(), 1, 2)='1 ') and not(substring(./div/div/div/rating-popover/div/a/span[2]/text(), 1, 2)='2 ')]"));
		return searchResultsByOrders;
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}
}
