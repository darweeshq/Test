package pages;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
	}
	public void goToCheckOutURL() throws InterruptedException {
		driver.get("https://magento.softwaretestingboard.com/checkout/#shipping");
		Thread.sleep(3000);
	}
}
