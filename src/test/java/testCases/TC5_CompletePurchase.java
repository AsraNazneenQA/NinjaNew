package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.CategoryPage;
import PageObjects.CheckoutPage;
import PageObjects.ConfirmationPage;
import PageObjects.LoginPage;
import PageObjects.ProductPage;
import testBases.BaseClass;
import utilities.DataProviders;
import utilities.RetryAnalyzer;

public class TC5_CompletePurchase extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC5_CompletePurchase.class);

    @Test(
            groups = {"sanity", "regression", "datadriven"},
            
            retryAnalyzer = RetryAnalyzer.class
        )
    public void testCompletePurchase() throws Exception {
        logger.debug("Starting TC5_CompletePurchase test...");

        try {
            CategoryPage cp = new CategoryPage(getDriver());
            logger.debug("CategoryPage initialized");

            cp.Clicklaptop();
            logger.debug("Clicked on Laptop category");

            cp.Clickdisplay();
            logger.debug("Clicked on Display category");

            Thread.sleep(500); // Consider replacing with WebDriverWait
            cp.ClickProduct();
            logger.debug("Clicked on a product");

            ProductPage pp = new ProductPage(getDriver());
            pp.deliverydate();
            logger.debug("Entered delivery date");

            pp.clickAddToCart();
            logger.debug("Clicked Add to Cart");

            pp.clickCheckout();
            logger.debug("Clicked Checkout");

            CheckoutPage cop = new CheckoutPage(getDriver());
            cop.clickLogin();
            logger.debug("Clicked Login on CheckoutPage");

            LoginPage lp = new LoginPage(getDriver());
            lp.EnterEmail("sid@cloudberry.services");
            logger.debug("Entered email");

            lp.Enterpwd("Test123");
            logger.debug("Entered password");

            lp.clickloginbtn();
            logger.debug("Clicked login button");

            cop.completeCheckout();
            logger.debug("Completed checkout process");

            ConfirmationPage confirmationPage = new ConfirmationPage(getDriver());
            boolean orderPlaced = confirmationPage.isOrderPlaced();
            logger.debug("Order placed status: " + orderPlaced);

            Assert.assertTrue(orderPlaced, "Order placement failed!");
            logger.info("Test passed: Order placed successfully");

        } catch (AssertionError ae) {
            logger.error("Assertion failed in TC5_CompletePurchase", ae);
            Assert.fail("Assertion failed: " + ae.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected exception in TC5_CompletePurchase", e);
            Assert.fail("Test failed due to unexpected error: " + e.getMessage());
        }
    }
}
