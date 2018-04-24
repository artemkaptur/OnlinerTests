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
 * @author user
 *
 */
public class IsMinskMakersTest {
	private Steps steps;

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(groups = { "1" }, description = "Check is makers in Minsk or not")
	public void isMakersinMinskTest() throws InterruptedException {
		assertTrue(steps.getMakersFromMinsk().size() != 0, "No makers from Minsk in search result");
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
