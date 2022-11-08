package pages;

import java.util.List;

import core.ReadCsvFile;

public class totalValueOfSalesIncludsShippingCost {
	public double CountMethod() throws Exception {
		List<String[]> lines = ReadCsvFile.readAllLines("outputSearchResults.csv");
		lines.remove(0);
		double TotalItemPrice = 0;
		for(String[] line : lines) {
			String ItemPriceString = line[2];
			String ItemPriceWithoutDollarSihgn = ItemPriceString.replace("$", "");
			double ItemPrice = Double.parseDouble(ItemPriceWithoutDollarSihgn);
			TotalItemPrice = ItemPrice + TotalItemPrice;
			
		}
		double ShippingCost = 15;
		return TotalItemPrice+ShippingCost;

	}	
}
