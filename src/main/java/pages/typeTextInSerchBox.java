package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class typeTextInSerchBox{
	WebDriver driver;
	public typeTextInSerchBox(WebDriver driver) {
		this.driver = driver;
	}
	public void setSearchBoxValue(String searchText) throws InterruptedException {
		WebElement getSearchBox = driver.findElement(By.xpath("//input[@id=\"search\"]"));
		getSearchBox.click();
		getSearchBox.clear();
		Thread.sleep(1000);
		getSearchBox.sendKeys(searchText);
		getSearchBox.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

	}
}
