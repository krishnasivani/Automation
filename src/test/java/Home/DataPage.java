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

import Utilities.CSVDownload;
import Utilities.CalendarDay_Month;
import Utilities.CalendarUtil;
import Utilities.LoginTest;
import Utilities.SearchUtilList;
import Utilities.SortList;
import PageObjectModels.DataPOM;

public class DataPage extends LoginTest{
    CalendarDay_Month Cal=new CalendarDay_Month();
	CalendarUtil calendar=new CalendarUtil();
	SortList sort=new SortList();
	SearchUtilList Search=new SearchUtilList();
	CSVDownload csv=new CSVDownload();
	public static String file_location = System.getProperty("user.dir") + "/AllData.xlsx";

	
	@Test(priority = 0)
	public void Test() throws IOException {
		LoginTest Log = new LoginTest();
		Log.Startup();
		Log.HomePage();
	    Log.Login();
	    driver=Log.Dashboard();
		driver.findElement(By.xpath("//a[contains(text(),'Data')]")).click();
	}
	
	@Test(dataProvider = "getData",priority=1)
	public void Data(String Date,String VehicleName) throws IOException, ParseException, InterruptedException{
		Thread.sleep(1000);
		String Device=VehicleName;	
		String From=Date;
		DataPOM DataLocators = PageFactory.initElements(driver, DataPOM.class);
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
	    DataLocators.ClickOnAll();	
	    Reporter.log("All Tab is Selected");

	}
	
	@Test(dataProvider = "getMsgIDData",priority=2)
	public void MsgID(String MsgID) throws InterruptedException {
		DataPOM DataLocators = PageFactory.initElements(driver, DataPOM.class);
		String ExpectedSearch=MsgID;
		DataLocators.ClickonMsgIDSort();
		Thread.sleep(500);
		List<WebElement> FieldsList=DataLocators.GetMsgIDElements();
		boolean Result=sort.DataSort(FieldsList);
		Reporter.log("Sorting of MsgID is " + Result);
		DataLocators.ClickonMsgIDInput(ExpectedSearch);
		Thread.sleep(500);
		List<WebElement> SearchList=DataLocators.GetMsgIDElements();
		boolean SearchResult=Search.SearchList(SearchList,ExpectedSearch);
		Reporter.log("Searching of MsgID " + ExpectedSearch + " is " + SearchResult);
		DataLocators.MsgIDInput.sendKeys(Keys.CONTROL, "a");
		DataLocators.MsgIDInput.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);		
	}
	
	@Test(dataProvider = "getProtocolData",priority=2)
	public void Protocol(String ProtocolID) throws InterruptedException {
		DataPOM DataLocators = PageFactory.initElements(driver, DataPOM.class);
		String ExpectedSearch=ProtocolID;
		DataLocators.ClickonProtocolSort();
		Thread.sleep(500);
		List<WebElement> FieldsList=DataLocators.GetProtocolElements();
		boolean SortResult=sort.DataSort(FieldsList);
		Reporter.log("Sorting of Protocol is " + SortResult);
		DataLocators.ClickonProtocolInput(ExpectedSearch);
		Thread.sleep(500);
		List<WebElement> SearchList=DataLocators.GetProtocolElements();
		boolean SearchResult=Search.SearchList(SearchList,ExpectedSearch);
		Reporter.log("Searching of Protocol "+ ExpectedSearch + " is " + SearchResult);
		DataLocators.ProtocolInput.sendKeys(Keys.CONTROL, "a");
		DataLocators.ProtocolInput.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);	
	}
	
	@Test(priority=4)
	public void DeviceTime() throws InterruptedException {
		DataPOM DataLocators = PageFactory.initElements(driver, DataPOM.class);
		DataLocators.ClickonDevTimeSort();
		Thread.sleep(500);
		List<WebElement> FieldsList=DataLocators.GetDevTimeElements();
		Thread.sleep(500);
		boolean Result=sort.DataSort(FieldsList);
		Reporter.log("Sorting of DeviceTime is " + Result);
	}
	
	@Test(priority=5)
	public void ProviderTime() throws InterruptedException {
		DataPOM DataLocators = PageFactory.initElements(driver, DataPOM.class);
		DataLocators.ClickonProvTimeSort();
		Thread.sleep(500);
		List<WebElement> FieldsList=DataLocators.GetProvTimeElements();
		Thread.sleep(500);
		boolean Result=sort.DataSort(FieldsList);
		Reporter.log("Sorting of Provider Time is " + Result);
	}
	
	@Test(priority=6)
	public void VisionTime() throws InterruptedException {
		DataPOM DataLocators = PageFactory.initElements(driver, DataPOM.class);
		DataLocators.ClickonVisionTimeSort();
		Thread.sleep(500);
		List<WebElement> FieldsList=DataLocators.GetVisionTimeElements();
		Thread.sleep(500);
		boolean Result=sort.DataSort(FieldsList);
		Reporter.log("Sorting of DeviceTime is " + Result);
	}
	
	@Test(dataProvider="getPayloadData",priority=7)
	public void PayloadType(String PayloadID) throws InterruptedException {
		DataPOM DataLocators = PageFactory.initElements(driver, DataPOM.class);
		String ExpectedSearch=PayloadID;
		DataLocators.ClickonPayloadTypeInput(ExpectedSearch);
		Thread.sleep(500);
		List<WebElement> SearchList=DataLocators.GetPayloadTypeElements();
		boolean SearchResult=Search.SearchList(SearchList,ExpectedSearch);
		Reporter.log("Searching of Payload Type of  "+ ExpectedSearch + " is " + SearchResult);
		DataLocators.PayloadTypeInput.sendKeys(Keys.CONTROL, "a");
		DataLocators.PayloadTypeInput.sendKeys(Keys.BACK_SPACE);
	}
	@Test(dataProvider = "getData",priority=8)
	public void CSVFunctionality(String Date,String VehicleName) throws InterruptedException, IOException {
		DataPOM DataLocators = PageFactory.initElements(driver, DataPOM.class);
		DataLocators.ClickonCSVDownload();
		String DeviceNo=VehicleName;
		String fileName="messages"+DeviceNo+"_";
		CSVDownload.waitForTheExcelFileToDownload(fileName, 200);
		}
	@Test(dataProvider = "getData",priority=9)
	public void BinFunctionality(String Date,String VehicleName) throws InterruptedException, IOException {
		DataPOM DataLocators = PageFactory.initElements(driver, DataPOM.class);
		DataLocators.ClickonBinDownload();
		String DeviceNo=VehicleName;
		String fileName="packets"+DeviceNo+"_";
		CSVDownload.waitForTheExcelFileToDownload(fileName, 200);
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
		public Object[][] getMsgIDData() throws IOException {
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
		public Object[][] getProtocolData() throws IOException {
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
		public Object[][] getPayloadData() throws IOException {
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
	 
	
	}
	
	

