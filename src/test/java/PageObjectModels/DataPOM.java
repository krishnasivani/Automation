package PageObjectModels;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

import Utilities.CalendarDay_Month;

public class DataPOM {
	@FindBy(how=How.XPATH, using="//label[@class='ui-dropdown-label ui-inputtext ui-corner-all']")
    private WebElement Vehicledropdown;

    @FindBy(how=How.XPATH, using="//input[@class='ui-dropdown-filter ui-inputtext ui-widget ui-state-default ui-corner-all']")
    private WebElement SearchVehicleText;
    
    @FindBy(how=How.XPATH,using="//li[@class='ui-dropdown-item ui-corner-all']")
    private WebElement SelectVehicle;
    
    @FindBy(how=How.XPATH,using="//label[@class='ui-dropdown-label ui-inputtext ui-corner-all']")
    private WebElement GetDeviceName;
    
    @FindBy(how=How.XPATH,using="//span[@class='ui-button-icon-left ui-clickable fa fa-fw fa-calendar']")
    private WebElement Calendar;
    
    @FindBy(how=How.XPATH,using="//span[contains(text(),'All')]")
    private WebElement All;
    
    @FindBy(how=How.XPATH,using="//p-datatable[@id='tripDataTableAll']//tbody[@class='ui-datatable-data ui-widget-content']")
    private WebElement AllDataTable;
    
    @FindBy(how=How.XPATH,using="//div[@class='trip-list-table-wrapper']//table//tbody")
    private WebElement TripsTable;
    
    @FindBy(how=How.XPATH,using="//div[@class='trips-layout-left col-md-12']//th[1]//span[2]")
    private WebElement MsgIDSort;
    
    @FindBy(how=How.XPATH,using="//p-datatable[@id='tripDataTableAll']//div//div//table//th[1]//input")
    public WebElement MsgIDInput;
    
    @FindBy(how=How.XPATH,using="//div[@class='trips-layout-left col-md-12']//th[2]//span[2]")
    private WebElement ProtocolSort;
    
    @FindBy(how=How.XPATH,using="//p-datatable[@id='tripDataTableAll']//div//div//table//th[2]//input")
    public WebElement ProtocolInput;
    
    @FindBy(how=How.XPATH,using="//div[@class='trips-layout-left col-md-12']//th[3]//span[2]")
    private WebElement DevTimeSort;
    
    @FindBy(how=How.XPATH,using="//div[@class='trips-layout-left col-md-12']//th[4]//span[2]")
    private WebElement ProvTimeSort;
    
    @FindBy(how=How.XPATH,using="//div[@class='trips-layout-left col-md-12']//th[5]//span[2]")
    private WebElement VisionTimeSort;
    
    @FindBy(how=How.XPATH,using="//p-datatable[@id='tripDataTableAll']//div//div//table//th[6]//input")
	public WebElement PayloadTypeInput;
    
    @FindBy(how=How.XPATH,using="//a[@class='sprite2 binaryLogs']")
    private WebElement BinDownload;
    
    @FindBy(how=How.XPATH,using="//a[@class='sprite2 csvLogs']")
    private WebElement csvDownload;

    public void clickOnVehicleDropdown(){
    	Vehicledropdown.click();
    	}
    public void clickOnSearchTextBox(){
    	SearchVehicleText.click();
    	}
    
    public void setDevice(String DeviceID){
    	SearchVehicleText.sendKeys(DeviceID);
    	}
    public void ClickSelectVehicle() {
    	SelectVehicle.click();
    }
    
	public String GetSelectedDevice() {
		// TODO Auto-generated method stub
		return GetDeviceName.getText();
	}
	public void ClickOnCalendar() {
		Calendar.click();
	}
	public void ClickOnAll() {
		All.click();
	}

	 public List<WebElement> GetTripsRowElements() {
	    	List<WebElement> RowTripElements=TripsTable.findElements(By.tagName("tr"));
	    	return RowTripElements;
	    }

	public void ClickonMsgIDSort() {
		MsgIDSort.click();
	}
	
	public void ClickonMsgIDInput(String MsgID) {
		MsgIDInput.click();
		MsgIDInput.sendKeys(MsgID);
	}
	
	 public List<WebElement> GetMsgIDElements() {
	    	List<WebElement> MsgIDElements=AllDataTable.findElements(By.cssSelector("tr td:nth-child(1)"));
	    	return MsgIDElements;
	    }
	public void ClickonProtocolSort() {
		ProtocolSort.click();
	}
	public void ClickonProtocolInput(String Protocol) {
		ProtocolInput.click();
		ProtocolInput.sendKeys(Protocol);
	}
		   
    public List<WebElement> GetProtocolElements() {
    	List<WebElement> ProtocolElements=AllDataTable.findElements(By.cssSelector("tr td:nth-child(2)"));
		return ProtocolElements;
    }
    
    public void ClickonDevTimeSort() {
		DevTimeSort.click();
	}
		   
    public List<WebElement> GetDevTimeElements() {
    	List<WebElement> DevTimeElements=AllDataTable.findElements(By.cssSelector("tr td:nth-child(3)"));
		return DevTimeElements;
    }
    
    public void ClickonProvTimeSort() {
  		ProvTimeSort.click();
  	}
    public List<WebElement> GetProvTimeElements() {
      	List<WebElement> ProvTimeElements=AllDataTable.findElements(By.cssSelector("tr td:nth-child(4)"));
  		return ProvTimeElements;
    }
    public void ClickonVisionTimeSort() {
  		VisionTimeSort.click();
  	}
    public List<WebElement> GetVisionTimeElements() {
      	List<WebElement> VisionTimeElements=AllDataTable.findElements(By.cssSelector("tr td:nth-child(5)"));
  		return VisionTimeElements;
    }
    
    public void ClickonPayloadTypeInput(String PayloadType) {
		PayloadTypeInput.click();
		PayloadTypeInput.sendKeys(PayloadType);
	}
    public List<WebElement> GetPayloadTypeElements() {
      	List<WebElement> PayloadTypeElements=AllDataTable.findElements(By.cssSelector("tr td:nth-child(6)"));
  		return PayloadTypeElements;
    }
    
    public void ClickonBinDownload() {
  		BinDownload.click();
  	}
    
    public void ClickonCSVDownload() {
  		csvDownload.click();
  	}

    
    

}
