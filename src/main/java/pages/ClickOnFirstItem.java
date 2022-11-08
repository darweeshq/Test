package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClickOnFirstItem {
		WebDriver driver;
		public ClickOnFirstItem(WebDriver driver) {
			this.driver = driver;
		}
		public void clickOnFirstItem() throws InterruptedException {
			Thread.sleep(3000);
			try {
			List<WebElement> clickOnItem = driver.findElements(By.xpath("//span[@class=\"product-image-wrapper\"]"));
			clickOnItem.get(0).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);
			clickOnItem.get(0).click();

			} catch (Exception e) {
				Thread.sleep(1000);
				List<WebElement> clickOnItem = driver.findElements(By.xpath("//a[@class=\"product-item-link\"]"));
				clickOnItem.get(0).sendKeys(Keys.ARROW_DOWN);
				Thread.sleep(1000);
				clickOnItem.get(0).click();

			}
			Thread.sleep(2000);
		}
	}
