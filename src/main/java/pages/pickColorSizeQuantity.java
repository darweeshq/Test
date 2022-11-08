
	package pages;
	import java.util.List;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;

	public class pickColorSizeQuantity{
		WebDriver driver;
		public pickColorSizeQuantity(WebDriver driver) {
			this.driver = driver;
		}
		public void PickColorSizeQuantity() throws InterruptedException {
			try {
			WebElement clickOnSize = driver.findElement(By.xpath("//div[@class=\"swatch-option text\"]"));
			clickOnSize.click();
			Thread.sleep(1000);
			}catch(Exception e) {
				System.out.println("There is no size to select for this Item.");
			}
			try {
			List<WebElement> clickOnColor = driver.findElements(By.xpath("//div[@option-type=\"1\"]"));
			clickOnColor.get(0).click();
			Thread.sleep(2000);
			}catch(Exception e) {
				System.out.println("There is no color to select for this Item.");
			}
			try {
			WebElement addToCart = driver.findElement(By.xpath("//div/div/div/div/button[@type=\"submit\"]"));
			addToCart.click();
			Thread.sleep(1000);
			}catch(Exception e) {
				WebElement addToCart = driver.findElement(By.id("product-addtocart-button"));
				addToCart.click();
				Thread.sleep(1000);
				
			}
		}
	}
	

