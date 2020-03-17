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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjectModels.DataPOM;
import Utilities.CSVDownload;
import Utilities.CalendarDay_Month;
import Utilities.CalendarUtil;
import Utilities.LoginTest;
import Utilities.SearchUtilList;
import Utilities.SortList;

public class DataTripsPage extends LoginTest{
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
		}
		
		@Test(priority=2)
		public void Trips() {
			DataPOM DataLocators = PageFactory.initElements(driver, DataPOM.class);
			List<WebElement> RowFieldsList=DataLocators.GetTripsRowElements();
		System.out.println(RowFieldsList.size());
			for (int i=0;i<RowFieldsList.size();i++)  {
				Reporter.log(RowFieldsList.get(i).getAttribute("title"));
				RowFieldsList.get(i).click();
				 Reporter.log("Trip Duration Time " + RowFieldsList.get(i).getText()); 
			}
		}
		
		@Test(dataProvider = "getData",priority=3)
		public void CSVFunctionality(String Date,String VehicleName) throws InterruptedException, IOException {
			DataPOM DataLocators = PageFactory.initElements(driver, DataPOM.class);
			DataLocators.ClickonCSVDownload();
			String DeviceNo=VehicleName;
			String fileName="messages"+DeviceNo+"_";
			CSVDownload.waitForTheExcelFileToDownload(fileName, 200);
			}
		@Test(dataProvider = "getData",priority=4)
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
}
