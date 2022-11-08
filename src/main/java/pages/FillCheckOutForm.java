	package pages;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;

	public class FillCheckOutForm{
		WebDriver driver;
		public FillCheckOutForm(WebDriver driver) {
			this.driver = driver;
		}
		public void fillCheckOutForm() throws InterruptedException {
			Thread.sleep(15000);
			
			List<WebElement> Email = driver.findElements(By.xpath("//input[@type=\"email\"]"));
			Email.get(1).click();
			Email.get(1).sendKeys("darweeshq@gmail.com");
			Thread.sleep(300);
			
			WebElement firstName = driver.findElement(By.name("firstname"));
			firstName.click();
			firstName.sendKeys("Darweesh");
			Thread.sleep(300);
			
			WebElement lastName = driver.findElement(By.name("lastname"));
			lastName.click();
			lastName.sendKeys("Qaimari");
			Thread.sleep(300);
			
			WebElement StreetAddress0 = driver.findElement(By.name("street[0]"));
			StreetAddress0.click();
			StreetAddress0.sendKeys("Wadi El Joz, Emro Al Qays st., ");
			Thread.sleep(300);
			
			WebElement StreetAddress1 = driver.findElement(By.name("street[1]"));
			StreetAddress1.click();
			StreetAddress1.sendKeys("House # 61");
			Thread.sleep(300);
			
			WebElement City = driver.findElement(By.name("city"));
			City.click();
			City.sendKeys("Jerusalem");
			Thread.sleep(300);
			
			WebElement postCode = driver.findElement(By.name("postcode"));
			postCode.click();
			postCode.sendKeys("20777");
			Thread.sleep(300);
			
			WebElement Country = driver.findElement(By.xpath("//option[@data-title=\"Israel\"]"));
			Country.click();
			Thread.sleep(300);
			
			WebElement phone = driver.findElement(By.name("telephone"));
			phone.click();
			phone.sendKeys("0525768719");
			Thread.sleep(3000);
			
			WebElement submitDetails = driver.findElement(By.xpath("//span[@data-bind=\"i18n: 'Next'\"]"));
			submitDetails.click();
			Thread.sleep(300);

		}
	}


