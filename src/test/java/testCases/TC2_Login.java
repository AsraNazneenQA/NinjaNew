package testCases;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AccountPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import testBases.BaseClass;
import utilities.DataProviders;
import utilities.RetryAnalyzer;

public class TC2_Login extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC2_Login.class);

    @Test(
        groups = {"sanity", "regression", "datadriven"},
        dataProvider = "LoginData",
        dataProviderClass = DataProviders.class,
        retryAnalyzer = RetryAnalyzer.class
    )
    void testLogin(String email, String pwd) throws Exception {
        logger.debug("Starting testLogin with Email: " + email);

        try {
            HomePage hp = new HomePage(getDriver());
            logger.debug("HomePage object created.");

            hp.clickMyAccount();
            logger.debug("Clicked on My Account.");

            hp.Clicklogin();
            logger.debug("Clicked on Login.");

            LoginPage lp = new LoginPage(getDriver());
            lp.EnterEmail(email);
            logger.debug("Entered email: " + email);

            lp.Enterpwd(pwd);
            logger.debug("Entered password.");

            lp.clickloginbtn();
            logger.debug("Clicked login button.");

            AccountPage ap = new AccountPage(getDriver());

            boolean status = lp.confirmationtext().isDisplayed();
            logger.debug("Login status: " + status);

            if (status) {
                logger.info("Login successful for user: " + email);

                ap.clickaccount();
                logger.debug("Clicked on account menu.");

                ap.clicklogout();
                logger.info("Logged out successfully for user: " + email);

                Assert.assertTrue(status);
            } else {
                logger.warn("Login failed for user: " + email);
                Assert.assertTrue(false, "Login failed.");
            }

        } catch (AssertionError ae) {
            logger.error("Assertion failed during login test for user: " + email, ae);
            Assert.fail("Assertion error: " + ae.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected exception during login test for user: " + email, e);
            Assert.fail("Unexpected error: " + e.getMessage());
        }
    }
}
