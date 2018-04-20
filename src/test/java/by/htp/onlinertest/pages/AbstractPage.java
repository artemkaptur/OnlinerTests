/**
 * 
 */
package by.htp.onlinertest.pages;

import org.openqa.selenium.WebDriver;

/**
 * @author user
 *
 */
public abstract class AbstractPage {
	protected WebDriver driver;

	public abstract void openPage();

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}
}
