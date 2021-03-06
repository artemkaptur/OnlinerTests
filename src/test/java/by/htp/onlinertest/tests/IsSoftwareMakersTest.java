/**
 * 
 */
package by.htp.onlinertest.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.onlinertest.steps.Steps;

/**
 * @author Артем
 *
 */
public class IsSoftwareMakersTest {
	private Steps steps;

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(groups = { "2" }, description = "Check is software makers in Minsk or not")
	public void isSoftwareMakersTest() throws InterruptedException {
		assertTrue(steps.getSoftwareMakers().size() != 0, "No software makers from Minsk in search result");
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}

}
