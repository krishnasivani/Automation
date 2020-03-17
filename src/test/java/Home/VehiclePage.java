package Home;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjectModels.DataPOM;
import PageObjectModels.VehiclePOM;
import Utilities.CSVDownload;
import Utilities.CalendarDay_Month;
import Utilities.CalendarUtil;
import Utilities.LoginTest;
import Utilities.Present;
import Utilities.ScreenshotUtil;
import Utilities.SearchUtilList;
import Utilities.SortList;

public class VehiclePage extends LoginTest {
	 CalendarDay_Month Cal=new CalendarDay_Month();
		CalendarUtil calendar=new CalendarUtil();
		SortList sort=new SortList();
		SearchUtilList Search=new SearchUtilList();
		CSVDownload csv=new CSVDownload();
		Present ElementPresence=new Present();
		ScreenshotUtil screenshot=new ScreenshotUtil();
		public static String file_location = System.getProperty("user.dir") + "/Vehicle&Device.xlsx";

		
		@Test(priority = 0)
		public void Test() throws IOException {
			LoginTest Log = new LoginTest();
			Log.Startup();
			Log.HomePage();
		    Log.Login();
		    driver=Log.Dashboard();
			driver.findElement(By.xpath("//a[contains(text(),'Vehicle & Device')]")).click();
		}
		
		@Test(dataProvider = "getData",priority=1)
		public void Data(String Date,String VehicleName) throws IOException, ParseException, InterruptedException{
			Thread.sleep(1000);
			Thread.sleep(1000);
			String Device=VehicleName;	
			String From=Date;
			VehiclePOM DataLocators = PageFactory.initElements(driver, VehiclePOM.class);
			DataLocators.clickOnVehicleDropdown();
			DataLocators.clickOnSearchTextBox();
			DataLocators.setDevice(Device);
			DataLocators.ClickSelectVehicle();
			String SelectedDevice=DataLocators.GetSelectedDevice();
			Reporter.log(SelectedDevice + " is Selected");
			DataLocators.ClickOnCalendar();
			String FromDate= calendar.getDate(From);
		    String FromMonth=calendar.getMonth(From);
		    Cal.SelectDay(driver, FromDate,FromMonth);
		    Reporter.log(From + " Calendar Date is Selected");
		}
		@Test(priority=3)
		public void Trips() throws IOException {
			VehiclePOM DataLocators = PageFactory.initElements(driver, VehiclePOM.class);
			List<WebElement> RowFieldsList=DataLocators.GetTripsRowElements();
		  Reporter.log(RowFieldsList.size() + " Trips Found");
			for (int i=0;i<RowFieldsList.size();i++)  {
				Reporter.log(RowFieldsList.get(i).getAttribute("title"));
				RowFieldsList.get(i).click();
				 Reporter.log("Trip Duration Time " + RowFieldsList.get(i).getText()); 
			}
	    	 screenshot.ScreenshotFunction(driver, "Vehicle&Device\\Trips.png");

		}
		
		@Test(dataProvider = "getPIDData",priority=4)
		public void PID(String PIDValue) throws InterruptedException {
			VehiclePOM DataLocators = PageFactory.initElements(driver, VehiclePOM.class);
			String ExpectedSearch=PIDValue;
			DataLocators.ClickOnPID(ExpectedSearch);
			Thread.sleep(500);
			List<WebElement> SearchList=DataLocators.GetPIDElements();
			By locator=By.xpath("//td[@class='ui-datatable-emptymessage']");
			if(ElementPresence.isElementPresent(driver, locator))	{
				Reporter.log("Searching of PID "+ ExpectedSearch +"-" + "No Records Found");
			}
			else {
				boolean SearchResult=Search.SearchList(SearchList,ExpectedSearch);
				Reporter.log("Searching of PID "+ ExpectedSearch + " is " + SearchResult);
			}
			DataLocators.PID.sendKeys(Keys.CONTROL, "a");
			DataLocators.PID.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(1000);
		}
		
		@Test(dataProvider = "getDescrData",priority=5)
		public void Description(String PIDDescr) throws InterruptedException {
			VehiclePOM DataLocators = PageFactory.initElements(driver, VehiclePOM.class);
			String ExpectedSearch=PIDDescr;
			DataLocators.ClickOnDescription(ExpectedSearch);
			Thread.sleep(500);
			List<WebElement> SearchList=DataLocators.GetDescElements();
			By locator=By.xpath("//td[@class='ui-datatable-emptymessage']");
			if(ElementPresence.isElementPresent(driver, locator))	{
				Reporter.log("Searching of Description "+ ExpectedSearch +"-" + "No Records Found");
			}
			else {
				boolean SearchResult=Search.SearchList(SearchList,ExpectedSearch);
				Reporter.log("Searching of Description "+ ExpectedSearch + " is " + SearchResult);
			}
			DataLocators.Description.sendKeys(Keys.CONTROL, "a");
			DataLocators.Description.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(1000);
		}
		@Test(dataProvider = "getUnitData",priority=6)
		public void Units(String UnitVal) throws InterruptedException {
			VehiclePOM DataLocators = PageFactory.initElements(driver, VehiclePOM.class);
			String ExpectedSearch=UnitVal;
			DataLocators.ClickOnUnits(ExpectedSearch);
			Thread.sleep(500);
			List<WebElement> SearchList=DataLocators.GetUnitElements();
			By locator=By.xpath("//td[@class='ui-datatable-emptymessage']");
			if(ElementPresence.isElementPresent(driver, locator))	{
				Reporter.log("Searching of Units "+ ExpectedSearch +"-" + "No Records Found");
			}
			else {
				boolean SearchResult=Search.SearchList(SearchList,ExpectedSearch);
				Reporter.log("Searching of Units "+ ExpectedSearch + " is " + SearchResult);
			}
			DataLocators.Units.sendKeys(Keys.CONTROL, "a");
			DataLocators.Units.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(1000);
		}
		@Test(dataProvider = "getPeriodicityData",priority=7)
		public void Periodicity(String PeriodicityVal) throws InterruptedException {
			VehiclePOM DataLocators = PageFactory.initElements(driver, VehiclePOM.class);
			String ExpectedSearch=PeriodicityVal;
			DataLocators.ClickOnPeriodicity(ExpectedSearch);
			Thread.sleep(500);
			List<WebElement> SearchList=DataLocators.GetPeriodicityElements();
			By locator=By.xpath("//td[@class='ui-datatable-emptymessage']");
			if(ElementPresence.isElementPresent(driver, locator))	{
				Reporter.log("Searching of Description "+ ExpectedSearch +"-" + "No Records Found");
			}
			else {
				boolean SearchResult=Search.SearchList(SearchList,ExpectedSearch);
				Reporter.log("Searching of Description "+ ExpectedSearch + " is " + SearchResult);
			}
			DataLocators.Periodicity.sendKeys(Keys.CONTROL, "a");
			DataLocators.Periodicity.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(1000);
		}
		@AfterClass
		public void Logout() {
			WebElement element = driver.findElement(By.xpath("//span[@class='nav-welcome-name']"));
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click()", element);
			executor.executeScript("arguments[0].click()", logout);
			Reporter.log("Logged Out");
			driver.close();
		}
		
		 @DataProvider
			public Object[][] getData() throws IOException {
				FileInputStream file = new FileInputStream(file_location);
				// Create Workbook instance holding reference to .xlsx file
				XSSFWorkbook workbook = new XSSFWorkbook(file);

				// Get first/desired sheet from the workbook
				XSSFSheet sheet = workbook.getSheetAt(0);
				DataFormatter formatter = new DataFormatter(Locale.US);
				Object[][] Data = new Object[1][2];
				Data[0][0] = formatter.formatCellValue(sheet.getRow(1).getCell(0));
				Data[0][1] = formatter.formatCellValue(sheet.getRow(1).getCell(1));
				return Data;
		}
		 
		 @DataProvider
			public Object[][] getPIDData() throws IOException {
				FileInputStream file = new FileInputStream(file_location);
				// Create Workbook instance holding reference to .xlsx file
				XSSFWorkbook workbook = new XSSFWorkbook(file);

				// Get first/desired sheet from the workbook
				XSSFSheet sheet = workbook.getSheetAt(0);
				DataFormatter formatter = new DataFormatter(Locale.US);
				Object[][] Data = new Object[1][1];
				Data[0][0] = formatter.formatCellValue(sheet.getRow(1).getCell(2));
				return Data;
		 }
		 
		 @DataProvider
			public Object[][] getDescrData() throws IOException {
				FileInputStream file = new FileInputStream(file_location);
				// Create Workbook instance holding reference to .xlsx file
				XSSFWorkbook workbook = new XSSFWorkbook(file);

				// Get first/desired sheet from the workbook
				XSSFSheet sheet = workbook.getSheetAt(0);
				DataFormatter formatter = new DataFormatter(Locale.US);
				Object[][] Data = new Object[1][1];
				Data[0][0] = formatter.formatCellValue(sheet.getRow(1).getCell(3));
				return Data;
		 }
		 @DataProvider
			public Object[][] getUnitData() throws IOException {
				FileInputStream file = new FileInputStream(file_location);
				// Create Workbook instance holding reference to .xlsx file
				XSSFWorkbook workbook = new XSSFWorkbook(file);

				// Get first/desired sheet from the workbook
				XSSFSheet sheet = workbook.getSheetAt(0);
				DataFormatter formatter = new DataFormatter(Locale.US);
				Object[][] Data = new Object[1][1];
				Data[0][0] = formatter.formatCellValue(sheet.getRow(1).getCell(4));
				return Data;
		 }
		 @DataProvider
			public Object[][] getPeriodicityData() throws IOException {
				FileInputStream file = new FileInputStream(file_location);
				// Create Workbook instance holding reference to .xlsx file
				XSSFWorkbook workbook = new XSSFWorkbook(file);

				// Get first/desired sheet from the workbook
				XSSFSheet sheet = workbook.getSheetAt(0);
				DataFormatter formatter = new DataFormatter(Locale.US);
				Object[][] Data = new Object[1][1];
				Data[0][0] = formatter.formatCellValue(sheet.getRow(1).getCell(5));
				return Data;
		 }

}
