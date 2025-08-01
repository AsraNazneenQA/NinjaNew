package testCases;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.CategoryPage;
import PageObjects.ProductPage;
import testBases.BaseClass;
import utilities.DataProviders;
import utilities.RetryAnalyzer;

public class TC3_AddToCart extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC3_AddToCart.class);

    @Test(
            groups = {"sanity", "regression", "datadriven"},
            
            retryAnalyzer = RetryAnalyzer.class
        )
    public void addtocart() throws Exception {
        logger.debug("Starting TC3_AddToCart test...");

        try {
            CategoryPage cp = new CategoryPage(getDriver());
            logger.debug("CategoryPage object created.");

            cp.Clicklaptop();
            logger.debug("Clicked on 'Laptops' category.");

            cp.Clickdisplay();
            logger.debug("Clicked on 'Displays' category.");

            cp.ClickProduct();
            logger.debug("Clicked on the product to view details.");

            ProductPage pg = new ProductPage(getDriver());
            logger.debug("ProductPage object created.");

            pg.deliverydate();
            logger.debug("Entered delivery date.");

            pg.clickAddToCart();
            logger.debug("Clicked 'Add to Cart'.");

            boolean result = pg.isSuccessMessageDisplayed();
            logger.debug("Success message displayed: " + result);

            Assert.assertTrue(result, "Add To Cart Failed!");
            logger.info("Product successfully added to cart.");

        } catch (AssertionError ae) {
            logger.error("Assertion failed in Add To Cart test.", ae);
            Assert.fail("Assertion failed: " + ae.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected exception occurred in Add To Cart test.", e);
            Assert.fail("Test failed due to unexpected error: " + e.getMessage());
        }
    }
}
