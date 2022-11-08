
	package pages;

	import java.util.List;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;

	public class GetItemPrice {
		WebDriver driver;
		public GetItemPrice(WebDriver driver) {
			this.driver = driver;
		}
		public String getItemPrice() throws InterruptedException {
			Thread.sleep(8000);
			List<WebElement> getItemPrice = driver.findElements(By.xpath("//span[@data-price-type=\"finalPrice\"]"));
			String price = getItemPrice.get(0).getText();
			return price;
			
		}
	}

