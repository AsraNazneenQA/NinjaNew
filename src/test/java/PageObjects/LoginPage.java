package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	
	}
@FindBy(xpath= "//input[@id='input-email']")
WebElement Setemail;
@FindBy(xpath= "//input[@id='input-password']")
WebElement Setpassword;
@FindBy(xpath="//button[normalize-space()='Login']")
WebElement loginbtn;
@FindBy(xpath= "//h1[normalize-space()='My Account']")
WebElement text_MyAccount;
public void EnterEmail(String Email) {
	Setemail.sendKeys(Email);
}
public void Enterpwd(String Password) {
	Setpassword.sendKeys(Password);
}
public void clickloginbtn() {
	loginbtn.click();
}
public WebElement confirmationtext() {
	return text_MyAccount;

}


}
