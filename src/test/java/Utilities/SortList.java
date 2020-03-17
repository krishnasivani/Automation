package Utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class SortList {
	public boolean DataSort(List<WebElement> FiList) throws InterruptedException {
		List<WebElement> FieldsList=FiList;
		ArrayList<String> ActualList=new ArrayList<String>();
		for(int i=0;i<FieldsList.size();i++)
		{
		ActualList.add(FieldsList.get(i).getText());
		}
		Thread.sleep(500);
		ArrayList<String> ExpectedList =new ArrayList<String>(ActualList);
		Collections.sort(ExpectedList,String.CASE_INSENSITIVE_ORDER);
		Thread.sleep(500);
		boolean result=ActualList.equals(ExpectedList);
		Assert.assertEquals(result,true);
		return result;
	}
}
