package testCases;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import testBases.BaseClass;
import utilities.DataProviders;
import utilities.RetryAnalyzer;

public class TC01_LaunchApplication extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC01_LaunchApplication.class);

    @Test(
            groups = {"sanity", "regression", "datadriven"},
            
            retryAnalyzer = RetryAnalyzer.class
        )
    public void testLaunchApplication() {
        logger.debug("Starting test: testLaunchApplication");

        try {
            HomePage hp = new HomePage(getDriver());
            logger.debug("HomePage object created.");

            String title = getDriver().getTitle();
            logger.debug("Page title retrieved: " + title);

            assertEquals(title, "Your store of fun");
            logger.info("Title assertion passed. Title is: " + title);

        } catch (AssertionError e) {
            logger.error("Assertion failed: Title does not match expected value.", e);
            Assert.fail("Test failed due to assertion error: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected exception occurred during test execution.", e);
            Assert.fail("Test failed due to unexpected error: " + e.getMessage());
        }
    }
}

