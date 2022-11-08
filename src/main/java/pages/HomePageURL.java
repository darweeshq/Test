package pages;
import org.openqa.selenium.WebDriver;

public class HomePageURL {
	WebDriver driver;
	public HomePageURL(WebDriver driver) {
		this.driver = driver;
	}
	public void goToHomePageURL() throws InterruptedException {
		driver.get("https://magento.softwaretestingboard.com/");
		Thread.sleep(3000);
	}
}
