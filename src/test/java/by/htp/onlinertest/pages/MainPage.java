/**
 * 
 */
package by.htp.onlinertest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author user
 *
 */
public class MainPage extends AbstractPage {
	private final String BASE_URL = "https://s.onliner.by/";

	@FindBy(xpath = "//*[@id='container']/div/div[2]/div/div/div/navigation/div/div/div[1]/ul/li[2]/a/span/span")
	private WebElement makers;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void clickOnMakers() {
		makers.click();
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}
}
