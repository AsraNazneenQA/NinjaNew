package PageObjects;


	
	import java.time.Duration;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class BasePage {

		WebDriver driver;
		WebDriverWait wait;
		public BasePage(WebDriver driver) {
			 wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			this.driver = driver;
			
			PageFactory.initElements(driver, this);
		}
		
		
	}	
	


