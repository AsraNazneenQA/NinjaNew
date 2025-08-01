package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.CategoryPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.ProductPage;
import testBases.BaseClass;
import utilities.DataProviders;
import utilities.RetryAnalyzer;

public class TC6_AddToWishList extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC6_AddToWishList.class);

    @Test(
            groups = {"sanity", "regression", "datadriven"},
         
            retryAnalyzer = RetryAnalyzer.class
        )
    void testAddToWishList() throws Exception {
        logger.debug("Starting TC6_AddToWishList test");

        try {
            HomePage hp = new HomePage(getDriver());
            logger.debug("HomePage initialized");

            hp.clickMyAccount();
            logger.debug("Clicked My Account");

            hp.Clicklogin();
            logger.debug("Clicked Login");

            LoginPage lp = new LoginPage(getDriver());
            lp.EnterEmail("sid@cloudberry.services");
            logger.debug("Entered Email");

            lp.Enterpwd("Test123");
            logger.debug("Entered Password");

            lp.clickloginbtn();
            logger.debug("Clicked Login Button");

            CategoryPage cp = new CategoryPage(getDriver());
            cp.Clicklaptop();
            logger.debug("Clicked on Laptop Category");

            cp.Clickdisplay();
            logger.debug("Clicked on Display Category");

            Thread.sleep(500);  // Consider replacing with WebDriverWait

            cp.ClickProduct();
            logger.debug("Clicked on Product");

            ProductPage pp = new ProductPage(getDriver());
            pp.addToWishlist();
            logger.debug("Clicked 'Add to Wishlist'");

            boolean success = pp.isSuccessMessageDisplayed();
            logger.debug("Success message displayed: " + success);

            Assert.assertTrue(success, "Wishlist message not shown.");
            logger.info("Test passed: Product added to wishlist");

        } catch (AssertionError ae) {
            logger.error("Assertion failed in TC6_AddToWishList", ae);
            Assert.fail("Assertion failed: " + ae.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected exception in TC6_AddToWishList", e);
            Assert.fail("Test failed due to unexpected error: " + e.getMessage());
        }
    }
}
