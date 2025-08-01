package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage extends BasePage {

	public CategoryPage(WebDriver driver) {
		super(driver);
	}	
	
@FindBy(xpath="//a[normalize-space()='Laptops & Notebooks']")
WebElement link_laptops;
@FindBy(xpath="//a[normalize-space()='Show All Laptops & Notebooks']")
		WebElement link_ShowAll;

@FindBy(xpath="//a[normalize-space()='HP LP3065']")
WebElement product_HP;

public void Clicklaptop() throws Exception {

	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link_laptops);
    Thread.sleep(500);
link_laptops.click();

}

public void Clickdisplay() throws Exception {

	link_ShowAll.click();
}

public void ClickProduct() throws Exception {
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product_HP);
	Thread.sleep(300);
	
	product_HP.click();

}


}
