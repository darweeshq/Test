package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetItemTitle {
	WebDriver driver;
	public GetItemTitle(WebDriver driver) {
		this.driver = driver;
	}
	public String getItemTitle() throws InterruptedException {
		WebElement getItemTitle = driver.findElement(By.xpath("//span[@class=\"base\"]"));
		String Title = getItemTitle.getText();
		return Title;
		
	}
}
