package PageObjectModels;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class VehiclePOM {
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
    
    @FindBy(how=How.XPATH,using="//th[1]//input[1]")
	public WebElement PID;
    
    @FindBy(how=How.XPATH,using="//th[2]//input[1]")
    public WebElement Description;
    
    @FindBy(how=How.XPATH,using="//th[3]//input[1]")
    public WebElement Units;
    
    @FindBy(how=How.XPATH,using="//th[6]//input[1]")
    public WebElement Periodicity;
    
    @FindBy(how=How.XPATH,using="//div[@class='trip-list-table-wrapper']//table//tbody")
    private WebElement TripsTable;
    
  @FindBy(how=How.XPATH,using="//tbody[@class='ui-datatable-data ui-widget-content']")
  private WebElement DataTable;
    
    
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
	public List<WebElement> GetTripsRowElements() {
    	List<WebElement> RowTripElements=TripsTable.findElements(By.tagName("tr"));
    	return RowTripElements;
    }
    
	public void ClickOnPID(String PIDValue) {
		PID.click();
		PID.sendKeys(PIDValue);
	}
	public List<WebElement> GetPIDElements() {
    	List<WebElement> PIDElements=DataTable.findElements(By.cssSelector("tr td:nth-child(1)"));
    	return PIDElements;
    }
	
	public void ClickOnDescription(String DescValue) {
		Description.click();
		Description.sendKeys(DescValue);
	}
	public List<WebElement> GetDescElements() {
    	List<WebElement> DescElements=DataTable.findElements(By.cssSelector("tr td:nth-child(2)"));
    	return DescElements;
    }
	public void ClickOnUnits(String UnitValue) {
		Units.click();
		Units.sendKeys(UnitValue);
	}
	public List<WebElement> GetUnitElements() {
    	List<WebElement> UnitElements=DataTable.findElements(By.cssSelector("tr td:nth-child(3)"));
    	return UnitElements;
    }
	public void ClickOnPeriodicity(String PeriodicityValue) {
		Periodicity.click();
		Periodicity.sendKeys(PeriodicityValue);
	}
	public List<WebElement> GetPeriodicityElements() {
    	List<WebElement> PeriodicityElements=DataTable.findElements(By.cssSelector("tr td:nth-child(6)"));
    	return PeriodicityElements;
    }
	
	
}
