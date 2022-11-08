import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import core.OpenBrowsers;
import core.ReadCsvFile;
import core.TakeScreenShot;
import core.WriteCsvFile;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import pages.CheckOutPage;
import pages.ClickOnFirstItem;
import pages.FillCheckOutForm;
import pages.GetItemPrice;
import pages.GetItemTitle;
import pages.GetRealTotalValues;
import pages.HomePageURL;
import pages.pickColorSizeQuantity;
import pages.readAllureTest;
import pages.totalValueOfSalesIncludsShippingCost;
import pages.typeTextInSerchBox;

public class shopingCartFinalProject {

	WebDriver driver;
	ArrayList<String> outputHeaders = new ArrayList<String>();
	ArrayList<ArrayList<String>> outputData = new ArrayList<ArrayList<String>>();

	@BeforeSuite
	public void beforeSuite() throws InterruptedException, IOException {
		driver = OpenBrowsers.openchromeWithOptions();
//		driver = OpenBrowsers.openFFWithOptions();
		outputHeaders.add("Input Shirt search field");
		outputHeaders.add("Item Name");
		outputHeaders.add("Item Price");

		HomePageURL goToHomePageURL = new HomePageURL(driver);
		goToHomePageURL.goToHomePageURL();
		

	}
	@Attachment(value = "Screenshot", type = "image/png")
	public byte[] screenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
	@DataProvider (name = "SearchItems")
	public Object[][] dpMethod() throws Exception {
		List<String[]> lines = ReadCsvFile.readAllLines("inputSearch.csv");
		lines.remove(0);
		Object[][] data = new Object[lines.size()][lines.get(0).length];
		int index = 0;
		for(String[] line : lines) {
			data[index] = line;
			index++;
		}
		return data;
	}	
	@Test(dataProvider = "SearchItems")
	public void TestShopping(String ItemName) throws Exception {
	
		TakeScreenShot takeScr = new TakeScreenShot(driver);
		takeScr.takeScreenShot("Shirt-shot-"+ItemName+".jpg");

		System.out.println("Item search for: " + ItemName );

		System.out.println("- - - - - - - - - - - - - - - - -");

		Thread.sleep(3000);
		typeTextInSerchBox searchBox = new typeTextInSerchBox(driver);
		searchBox.setSearchBoxValue(ItemName);
		Thread.sleep(1000);
		
		ClickOnFirstItem clickOnFirstItemInTable = new ClickOnFirstItem(driver);
		clickOnFirstItemInTable.clickOnFirstItem();

		Thread.sleep(3000);
		Allure.addAttachment("AfterLogin"+ItemName, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
	
		pickColorSizeQuantity pickSizeColorAddToCart = new pickColorSizeQuantity(driver);
		pickSizeColorAddToCart.PickColorSizeQuantity();
		
		GetItemTitle ItemTitle = new GetItemTitle(driver);
		String itemTitle = ItemTitle.getItemTitle();
		
		GetItemPrice ItemPrice = new GetItemPrice(driver);
		String itemPrice = ItemPrice.getItemPrice();

				
		takeScr.takeScreenShot("Shirt-shot-"+itemTitle+".jpg");
		Allure.addAttachment("ScreenShot"+itemTitle, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

		System.out.println("- - - - - - - - - - - - - - - - - - - - - - -");
		Thread.sleep(1000);
	
		Thread.sleep(3000);
		ArrayList<String> results = new ArrayList<String>();
		results.add(ItemName);
		results.add(itemTitle);
		results.add(itemPrice);
		outputData.add(results);

	}
	@Test
	public void getResult() {
		List<String[]> data = new ArrayList<String[]>();
		for(ArrayList<String> row: outputData) {
			String[] row_data = new String[row.size()];
			for(int i= 0;i<row.size();i++) {
				row_data[i] = row.get(i);
			}
			data.add(row_data);
		}
		String[] headers = new String[outputHeaders.size()];
		for(int i= 0;i<outputHeaders.size();i++) {
			headers[i] = outputHeaders.get(i);
		}
		WriteCsvFile.writeDataLineByLine("outputSearchResults.csv", data, headers);

	}
	@Test
	public void fillCheckOutForm() throws Exception {
		CheckOutPage goToCheckOutPage = new CheckOutPage(driver);
		goToCheckOutPage.goToCheckOutURL();
		
		FillCheckOutForm fillCheckOutForm = new FillCheckOutForm(driver);
		fillCheckOutForm.fillCheckOutForm();
		Thread.sleep(3000);
		//Get cost of items and shipping rate from CSV file - ExpectedValue
		GetRealTotalValues RealValue = new GetRealTotalValues(driver);
		double realValue = RealValue.getItemTotal();
		
		//Get cost of items and shipping rate from Website - RealValue
		totalValueOfSalesIncludsShippingCost calculatedValue = new totalValueOfSalesIncludsShippingCost();
		double ExpectedValue = calculatedValue.CountMethod();
		
		System.out.println("Expected value of purchased items including shipping : " +ExpectedValue);
		System.out.println("Real value seen on Page of purchased items including shipping : " +realValue);

		SoftAssert CompareSumOfItemsAndShipping = new SoftAssert();
		CompareSumOfItemsAndShipping.assertEquals(ExpectedValue, realValue);		
		
	}
	@Test
	public void allureResults() throws IOException {
		readAllureTest allureReport = new readAllureTest();
		allureReport.allureTest();
	}
	
}