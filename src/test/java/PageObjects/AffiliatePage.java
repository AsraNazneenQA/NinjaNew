package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AffiliatePage  extends BasePage{

	public AffiliatePage(WebDriver driver) {
		super(driver);
		}
	
	
@FindBy(xpath="//a[normalize-space()='Affiliate']")
WebElement Affiliatelink;
@FindBy(xpath="//input[@id='input-company']")
WebElement companylink;
@FindBy(xpath="//input[@id='input-website']")
WebElement websitelink;
@FindBy (xpath="//input[@id='input-tax']")
WebElement taxlink;
@FindBy(xpath="//input[@id='input-cheque']")
WebElement chequelink;
@FindBy(xpath= "//b[normalize-space()='Delivery Information']")
WebElement delClick;
@FindBy(xpath= "//button[normalize-space()='Continue']")
WebElement continuebutton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
WebElement successmessage;
public void navigatetoaffiliate() throws Exception {
	scrollToView(Affiliatelink);
	Thread.sleep(500);
	scrollandClick(Affiliatelink);
}
private void scrollandClick(WebElement element) throws Exception {
	scrollToView(element);
 Thread.sleep(500);
 element.click();
	
}
private void scrollToView(WebElement element) {
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	
}
public void fillAffiliateDetails(String company, String website, String tax, String chequeName)
        throws Exception {
    companylink.clear();
    companylink.sendKeys(company);

    websitelink.clear();
    websitelink.sendKeys(website);

    taxlink.clear();
    taxlink.sendKeys(tax);

    scrollToView(chequelink);
    Thread.sleep(300);
    chequelink.clear();
    chequelink.sendKeys(chequeName);

    scrollandClick(continuebutton);
}

	public boolean isAffiliateAdded() {
        return successmessage.isDisplayed();
    }

	
}

	
