package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AffiliatePage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import testBases.BaseClass;
import utilities.DataProviders;
import utilities.RetryAnalyzer;

public class TC4_AddAffiliate extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC4_AddAffiliate.class);

    @Test(
            groups = {"sanity", "regression", "datadriven"},
           
            retryAnalyzer = RetryAnalyzer.class
        )
    void testAddAffiliate() throws Exception {
        logger.debug("Starting TC4_AddAffiliate test...");

        try {
            HomePage hp = new HomePage(getDriver());
            logger.debug("HomePage object initialized");

            hp.clickMyAccount();
            logger.debug("Clicked on My Account");

            hp.Clicklogin();
            logger.debug("Clicked on Login");

            LoginPage lp = new LoginPage(getDriver());
            lp.EnterEmail("sid@cloudberry.services");
            logger.debug("Entered email");

            lp.Enterpwd("Test123");
            logger.debug("Entered password");

            lp.clickloginbtn();
            logger.debug("Clicked login button");

            AffiliatePage ap = new AffiliatePage(getDriver());
            ap.navigatetoaffiliate();
            logger.debug("Navigated to Affiliate section");

            ap.fillAffiliateDetails("CloudBerry", "cloudberry.services", "123456", "Shadab Siddiqui");
            logger.debug("Filled affiliate details");

            boolean result = ap.isAffiliateAdded();
            logger.debug("Affiliate added status: " + result);

            Assert.assertTrue(result, "Affiliate details not added successfully.");
            logger.info("Affiliate details successfully added.");

        } catch (AssertionError ae) {
            logger.error("Assertion failed in TC4_AddAffiliate", ae);
            Assert.fail("Assertion failed: " + ae.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected exception in TC4_AddAffiliate", e);
            Assert.fail("Test failed due to unexpected error: " + e.getMessage());
        }
    }
}

