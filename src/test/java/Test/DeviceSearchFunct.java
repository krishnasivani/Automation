package Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Utilities.LoginTest;

public class DeviceSearchFunct extends LoginTest{
	@Test(priority = 0)
	public void Test() throws IOException {
		LoginTest Log = new LoginTest();
		Log.Startup();
		Log.HomePage();
		Log.Login();
		driver = Log.Admin();
		driver.findElement(By.xpath("//td[contains(text(),'Device Management')]")).click();
	}
	
	@Test(priority=1)
	public void ClientSearch() throws InterruptedException {
		Thread.sleep(1000);
		Actions a = new Actions(driver);
		String Client="Amazon";
		WebElement ClientSearchBox = driver.findElement(By.xpath("//th[1]//input[1]"));
		a.moveToElement(ClientSearchBox).click().sendKeys(Client).build().perform();
	    List<String> value = new ArrayList<String>();
	    Thread.sleep(500);
		List<WebElement> table=driver.findElements(By.xpath("//tbody[@class='ui-datatable-data ui-widget-content ui-datatable-hoverable-rows']//td[1]"));
			for (int i = 0; i < table.size(); i++) {
				String text = table.get(i).getText();				
			    value.add(text);
			}
		
		boolean match=value.stream().allMatch(n->n.contains(Client));
		Reporter.log(value.get(0) + " Client Search : " + match );
		ClientSearchBox.sendKeys(Keys.CONTROL, "a");
		ClientSearchBox.sendKeys(Keys.BACK_SPACE);

	}
	@Test(priority=2)
	public void IMEISearch() throws InterruptedException {
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		String IMEI="3456789130627";
		WebElement IMEISearchBox = driver.findElement(By.xpath("//th[2]//input[1]"));
		a.moveToElement(IMEISearchBox).click().sendKeys(IMEI).build().perform();
	    List<String> value = new ArrayList<String>();
	    Thread.sleep(500);
		List<WebElement> table=driver.findElements(By.xpath("//tbody[@class='ui-datatable-data ui-widget-content ui-datatable-hoverable-rows']//td[2]"));
			for (int i = 0; i < table.size(); i++) {
				String text = table.get(i).getText();
				value.add(text);
			}
			boolean match=value.stream().allMatch(n->n.contains(IMEI));
			Reporter.log(value.get(0) +" IMEI Search:" + match);
		IMEISearchBox.sendKeys(Keys.CONTROL, "a");
		IMEISearchBox.sendKeys(Keys.BACK_SPACE);
	}
	
	@Test(priority=3)
	public void DeviceSearch() throws InterruptedException {
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		String Device="8021340031";
		WebElement DeviceSearchBox = driver.findElement(By.xpath("//th[3]//input[1]"));
		a.moveToElement(DeviceSearchBox).click().sendKeys(Device).build().perform();
		 List<String> value = new ArrayList<String>();
		Thread.sleep(500);
		List<WebElement> table=driver.findElements(By.xpath("//tbody[@class='ui-datatable-data ui-widget-content ui-datatable-hoverable-rows']//td[3]"));
			for (int i = 0; i < table.size(); i++) {
				String text = table.get(i).getText();
				value.add(text);
			}
			boolean match=value.stream().allMatch(n->n.contains(Device));
			Reporter.log(value.get(0) + " Device Search: " + match);		
			DeviceSearchBox.sendKeys(Keys.CONTROL, "a");
			DeviceSearchBox.sendKeys(Keys.BACK_SPACE);

	}
	@Test(priority=4)
	public void FWVersion() throws InterruptedException {
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		String FW="0B7.89";
		WebElement FWSearchBox = driver.findElement(By.xpath("//th[4]//input[1]"));
		a.moveToElement(FWSearchBox).click().sendKeys(FW).build().perform();
		 List<String> value = new ArrayList<String>();
		 Thread.sleep(500);
		List<WebElement> table=driver.findElements(By.xpath("//tbody[@class='ui-datatable-data ui-widget-content ui-datatable-hoverable-rows']//td[4]"));
			for (int i = 0; i < table.size(); i++) {
				String text = table.get(i).getText();
				value.add(text);
			}
			boolean match=value.stream().allMatch(n->n.contains(FW));
			Reporter.log(value.get(0) + " FW Search: " + match);
			FWSearchBox.sendKeys(Keys.CONTROL, "a");
			FWSearchBox.sendKeys(Keys.BACK_SPACE);

	}
	@Test(priority=5)
	public void ConfigVersion() throws InterruptedException {
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		String config="TU_BB1";
		WebElement CWSearchBox = driver.findElement(By.xpath("//th[5]//input[1]"));
		a.moveToElement(CWSearchBox).click().sendKeys(config).build().perform();
		 List<String> value = new ArrayList<String>();
		 Thread.sleep(500);
		List<WebElement> table=driver.findElements(By.xpath("//tbody[@class='ui-datatable-data ui-widget-content ui-datatable-hoverable-rows']//td[5]"));
			for (int i = 0; i < table.size(); i++) {
				String text = table.get(i).getText();
				value.add(text);
			}
			boolean match=value.stream().allMatch(n->n.contains(config));
			Reporter.log(value.get(0) + " CW Search: " + match);
			CWSearchBox.sendKeys(Keys.CONTROL, "a");
			CWSearchBox.sendKeys(Keys.BACK_SPACE);

	}
	@Test(priority=6)
	public void VehicleAlias() throws InterruptedException {
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		String Alias="0050_moj";
		WebElement VehicleSearchBox = driver.findElement(By.xpath("//th[6]//input[1]"));
		a.moveToElement(VehicleSearchBox).click().sendKeys(Alias).build().perform();
		 List<String> value = new ArrayList<String>();
		 Thread.sleep(500);
		List<WebElement> table=driver.findElements(By.xpath("//tbody[@class='ui-datatable-data ui-widget-content ui-datatable-hoverable-rows']//td[6]"));
			for (int i = 0; i < table.size(); i++) {
				String text = table.get(i).getText();
				value.add(text);
			}
			boolean match=value.stream().allMatch(n->n.contains(Alias));
			Reporter.log(value.get(0) + " Alias Search: " + match);
			VehicleSearchBox.sendKeys(Keys.CONTROL, "a");
			VehicleSearchBox.sendKeys(Keys.BACK_SPACE);
	}
	
	@Test(priority=7)
	public void CommandGroup() throws InterruptedException {
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		String Group="Allstate_Gen2_X";
		WebElement CommandGrpSearchBox = driver.findElement(By.xpath("//th[7]//input[1]"));
		a.moveToElement(CommandGrpSearchBox).click().sendKeys(Group).build().perform();
		 List<String> value = new ArrayList<String>();
		 Thread.sleep(500);
		List<WebElement> table=driver.findElements(By.xpath("//tbody[@class='ui-datatable-data ui-widget-content ui-datatable-hoverable-rows']//td[7]"));
			for (int i = 0; i < table.size(); i++) {
				String text = table.get(i).getText();
				value.add(text);
			}
			boolean match=value.stream().allMatch(n->n.contains(Group));
			Reporter.log(value.get(0) + " CommandGroup Search: " + match);
			CommandGrpSearchBox.sendKeys(Keys.CONTROL, "a");
			CommandGrpSearchBox.sendKeys(Keys.BACK_SPACE);
	}
	@Test(priority=8)
	public void Provider() throws InterruptedException {
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		String Provider="BitBrew";
		WebElement ProvSearchBox = driver.findElement(By.xpath("//th[8]//input[1]"));
		a.moveToElement(ProvSearchBox).click().sendKeys(Provider).build().perform();
		 List<String> value = new ArrayList<String>();
		 Thread.sleep(500);
		List<WebElement> table=driver.findElements(By.xpath("//tbody[@class='ui-datatable-data ui-widget-content ui-datatable-hoverable-rows']//td[8]"));
			for (int i = 0; i < table.size(); i++) {
				String text = table.get(i).getText();
				value.add(text);
			}
			boolean match=value.stream().allMatch(n->n.contains(Provider));
			Reporter.log(value.get(0) + " Provider Search: " + match);
			ProvSearchBox.sendKeys(Keys.CONTROL,"a");
			ProvSearchBox.sendKeys(Keys.BACK_SPACE);
	}
	
	@Test(priority=9)
	public void ShowCurrent() throws InterruptedException {
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		String Current="false";
		WebElement CurrSearchBox = driver.findElement(By.xpath("//th[9]//input[1]"));
		a.moveToElement(CurrSearchBox).click().sendKeys(Current).build().perform();
		 List<String> value = new ArrayList<String>();
		 Thread.sleep(500);
		List<WebElement> table=driver.findElements(By.xpath("//tbody[@class='ui-datatable-data ui-widget-content ui-datatable-hoverable-rows']//td[9]"));
		if(table.size()==0)	{
			Reporter.log( " Show Current Search: False " );
			CurrSearchBox.sendKeys(Keys.CONTROL,"a");
			CurrSearchBox.sendKeys(Keys.BACK_SPACE);
		}
		else {
		for (int i = 0; i < table.size(); i++) {
				String text = table.get(i).getText();
				value.add(text);
			}
			boolean match=value.stream().allMatch(n->n.contains(Current));
			Reporter.log(value.get(0) + " Show Current Search: " + match);
			CurrSearchBox.sendKeys(Keys.CONTROL,"a");
			CurrSearchBox.sendKeys(Keys.BACK_SPACE);
		}
	}
	
	@Test(priority=10)
	public void DeviceType() throws InterruptedException {
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		String DeviceType="TCU";
		WebElement DevTypeSearchBox = driver.findElement(By.xpath("//th[10]//input[1]"));
		a.moveToElement(DevTypeSearchBox).click().sendKeys(DeviceType).build().perform();
		 List<String> value = new ArrayList<String>();
		 Thread.sleep(500);
		List<WebElement> table=driver.findElements(By.xpath("//tbody[@class='ui-datatable-data ui-widget-content ui-datatable-hoverable-rows']//td[10]"));
		if(table.size()==0)	{
			Reporter.log( " Device Type Search: False " );
			DevTypeSearchBox.sendKeys(Keys.CONTROL,"a");
			DevTypeSearchBox.sendKeys(Keys.BACK_SPACE);
		}
		else {	
			for (int i = 0; i < table.size(); i++) {
					String text = table.get(i).getText();
					value.add(text);
				}
			boolean match=value.stream().allMatch(n->n.contains(DeviceType));
			Reporter.log(value.get(0) + " Device Type Search: " + match);
			DevTypeSearchBox.sendKeys(Keys.CONTROL,"a");
			DevTypeSearchBox.sendKeys(Keys.BACK_SPACE);
		}
	}
	
	@Test(priority=11)
	public void DeviceGroup() throws InterruptedException {
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		String DeviceGrp="BS6 Vehicle";
		WebElement DevGrpSearchBox = driver.findElement(By.xpath("//th[11]//input[1]"));
		a.moveToElement(DevGrpSearchBox).click().sendKeys(DeviceGrp).build().perform();
		 List<String> value = new ArrayList<String>();
		 Thread.sleep(500);
		List<WebElement> table=driver.findElements(By.xpath("//tbody[@class='ui-datatable-data ui-widget-content ui-datatable-hoverable-rows']//td[11]"));	
		if(table.size()==0)	{
			Reporter.log( " Device Group Search: False " );
			DevGrpSearchBox.sendKeys(Keys.CONTROL,"a");
			DevGrpSearchBox.sendKeys(Keys.BACK_SPACE);
		}
		else {
			for (int i = 0; i < table.size(); i++) {
					String text = table.get(i).getText();
					value.add(text);
				}
				boolean match=value.stream().allMatch(n->n.contains(DeviceGrp));
				Reporter.log(value.get(0) + " Device Group Search: " + match);
				DevGrpSearchBox.sendKeys(Keys.CONTROL,"a");
				DevGrpSearchBox.sendKeys(Keys.BACK_SPACE);
	}
	}
	
	@Test(priority=12)
	public void TCPPV() throws InterruptedException {
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		String TCPPV="301";
		WebElement TCPSearchBox = driver.findElement(By.xpath("//th[12]//input[1]"));
		a.moveToElement(TCPSearchBox).click().sendKeys(TCPPV).build().perform();
		 List<String> value = new ArrayList<String>();
		 Thread.sleep(500);
		List<WebElement> table=driver.findElements(By.xpath("//tbody[@class='ui-datatable-data ui-widget-content ui-datatable-hoverable-rows']//td[12]"));
		if(table.size()==0)	{
			Reporter.log( " TCP PV Search: False " );
			TCPSearchBox.sendKeys(Keys.CONTROL,"a");
			TCPSearchBox.sendKeys(Keys.BACK_SPACE);
		}
		else {	
			for (int i = 0; i < table.size(); i++) {
					String text = table.get(i).getText();
					value.add(text);
				}
				boolean match=value.stream().allMatch(n->n.contains(TCPPV));
				Reporter.log(value.get(0) + " TCP PV Search: " + match);
				TCPSearchBox.sendKeys(Keys.CONTROL,"a");
				TCPSearchBox.sendKeys(Keys.BACK_SPACE);
		}
	}
	
	@Test(priority=13)
	public void UDPPV() throws InterruptedException {
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		String UDPPV="7";
		WebElement UDPSearchBox = driver.findElement(By.xpath("//th[13]//input[1]"));
		a.moveToElement(UDPSearchBox).click().sendKeys(UDPPV).build().perform();
		 List<String> value = new ArrayList<String>();
		 Thread.sleep(500);
		List<WebElement> table=driver.findElements(By.xpath("//tbody[@class='ui-datatable-data ui-widget-content ui-datatable-hoverable-rows']//td[13]"));
		if(table.size()==0)	{
			Reporter.log("UDP PV Search: False " );
			UDPSearchBox.sendKeys(Keys.CONTROL,"a");
			UDPSearchBox.sendKeys(Keys.BACK_SPACE);
		}
		else {	
				for (int i = 0; i < table.size(); i++) {
						String text = table.get(i).getText();
						value.add(text);
					}
				boolean match=value.stream().allMatch(n->n.contains(UDPPV));
				Reporter.log(value.get(0) + " UDP PV Search: " + match);
				UDPSearchBox.sendKeys(Keys.CONTROL,"a");
				UDPSearchBox.sendKeys(Keys.BACK_SPACE);
	}
	}
	
}
