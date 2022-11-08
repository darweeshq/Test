
	package pages;

	import java.util.List;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;

	public class GetRealTotalValues {
		WebDriver driver;
		public GetRealTotalValues(WebDriver driver) {
			this.driver = driver;
		}
		public double getItemTotal() throws InterruptedException {
			Thread.sleep(8000);
			List<WebElement> totalAndSHipping = driver.findElements(By.xpath("//span[@class=\"price\"]"));
			String total = totalAndSHipping.get(4).getText().replace("$", "");
			double tatal1 = Double.parseDouble(total);
			return tatal1;
			
		}
	}

