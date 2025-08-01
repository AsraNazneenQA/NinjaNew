package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBases.BaseClass;

public class AccountPage extends BasePage {
	
	public AccountPage(WebDriver driver) {
		
		super(driver);
		
		
	}
 @FindBy(xpath= "//span[normalize-space()='My Account']")
 WebElement Myaccount;
 @FindBy(xpath= "//li[@class='list-inline-item']//i[@class='fa-solid fa-caret-down']") 
 WebElement dropdown_myaccount;
 
 @FindBy(xpath= "//a[@class='list-group-item'][normalize-space()='Logout']")
 WebElement logout;
 public WebElement getMyaccount() {
	 
	 return Myaccount;
	 
 }
  public void clickaccount() {
	  dropdown_myaccount.click();
  }

public void clicklogout() throws Exception {
	
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", logout);
	Thread.sleep(500);
	logout.click();
}

}
