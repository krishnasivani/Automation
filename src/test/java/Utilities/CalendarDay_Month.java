package Utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarDay_Month {
	public void SelectDay(WebDriver driver,String Date,String Month) {
		WebDriverWait wait = new WebDriverWait(driver, 60); 
        By Timexpath= By.xpath("//div[@class='ui-datepicker-title']");
		WebElement CurrentToTime = wait.until(ExpectedConditions.elementToBeClickable(Timexpath));
		WebElement ArrowElement1=driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']//a[1]"));
		 while(true) {
	    	   //ArrowElement1.click();
	    	  if( CurrentToTime.getText().equalsIgnoreCase(Month)){
	    		  List<WebElement> Tocolumns=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td[not(contains(@class,' '))]/a"));
	    		  for (WebElement cell: Tocolumns) {	 	        	
	 	        		// System.out.println(cell.getText());	 	        	 
	 	        		 if (cell.getText().equals(Date)) {
	 	        			 cell.click();
	 	        			 break;	 	             
	 	        	 }
	 	         }
		    		 break; 
	    	  }
	    	  else {
	    		  ArrowElement1.click();
	    	  }
	       } 	    	
	}	

}
