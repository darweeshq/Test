package pages;

import java.util.List;

import core.ReadCsvFile;

public class numberOfItemsToCheckFromCsvFile {
	public int CountMethod() throws Exception {
		List<String[]> lines = ReadCsvFile.readAllLines("inputSearch.csv");
		lines.remove(0);
		Object[][] data = new Object[lines.size()][lines.get(0).length];
		int index = 0;
		for(String[] line : lines) {
			data[index] = line;
			index++;
		}
		return index;
	}	
}
