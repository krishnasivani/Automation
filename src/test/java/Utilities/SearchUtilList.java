package Utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchUtilList {
	public boolean SearchList(List<WebElement> FieldsList,String ExpectedSearch) throws InterruptedException {
	List<String> value = new ArrayList<String>();
    Thread.sleep(500);
		for (int i = 0; i < FieldsList.size(); i++) {
			String text = FieldsList.get(i).getText();				
		    value.add(text);
		}	
	boolean match=value.stream().allMatch(n->n.contains(ExpectedSearch));
	return match;
	}
}
