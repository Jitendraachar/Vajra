package com.vajra.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FGStock {
WebDriver driver;
public String ZoneName;
public static String FGStockNo;
public static String FgStockWt;
public FGStock(WebDriver rdriver) {
	driver=rdriver;
	PageFactory.initElements(rdriver, this);
}

@FindBy(partialLinkText = "Repo")
WebElement ReportDropdown;

@FindBy(linkText = "Stock")
WebElement StockDropDown;

@FindBy(partialLinkText = "FG Stock Item Report")
WebElement FGStockSubMenu;

@FindBy(xpath = "/html/body/div[2]/div/div/div/div/aside/form/div[1]/div[1]/select")
WebElement StatusDropDown;

@FindBy(name = "storeDc")
WebElement StoreOrDCDropDown;

@FindBy(xpath = "//*[@id=\"storeOrDcName\"]/div/div/button")
WebElement StoreOrDCNameDropDown;

@FindBy(xpath = "//b[contains(text(),'TS Madision')]")
public WebElement SelectStoreNameAsTSMadision;

@FindBy(xpath = "//b[contains(text(),'Jayanagar Madision')]")
WebElement SelectNameAsJayanagarMadision;

@FindBy(xpath = "//*[@id=\"zone\"]/div/div/button")
WebElement ZoneDropDown;

@FindBy(xpath = "//label[contains(text(),'Zone')]")
public List<WebElement> AllZoneName;

@FindBy(xpath = "/html/body/div[2]/div/div/div/div/aside/form/div[2]/div[1]/select")
WebElement SegmentDropDown;

@FindBy(xpath = "//button[@id='search']")
WebElement SeachButton;

@FindBy(xpath = "/html/body/div[1]/nav/div/div[2]/ul[2]/li[3]/div[2]")
WebElement LoginZoneName;

@FindBy(xpath ="/html/body/div[2]/div/div/div/div/aside/div[3]/div[1]" )
WebElement SearchGrid;

@FindBy(xpath = "//th[contains(text(),'LI.Sell. Price')]")
WebElement FGSearchGrid;

public void getLoginZoneName() {
	 ZoneName= LoginZoneName.getText();
	System.out.println("Zone Name is: "+ZoneName);
	return;
}
public void ClickOnReportDropdown() throws InterruptedException {
	//Thread.sleep(2000);
	ReportDropdown.isDisplayed();
	ReportDropdown.click();
}
public void ClickOnStockDropDown() {
	StockDropDown.isDisplayed();
	StockDropDown.click();
}
public void ClickOnFGStockSubMenu() {
	FGStockSubMenu.isDisplayed();
	FGStockSubMenu.click();
}
public void SelectStatusDropdown(String StatusFromTest) throws InterruptedException {
	Thread.sleep(3000);
	StatusDropDown.isDisplayed();
Select StatusAllDropDown=new Select(StatusDropDown);
StatusAllDropDown.selectByVisibleText(StatusFromTest);

}
public void SelectStoreOrDCDropDown(String StoreOrDC) {
	StatusDropDown.isSelected();
	Select StoreOrDCDrop=new Select(StoreOrDCDropDown);
	StoreOrDCDrop.selectByVisibleText(StoreOrDC);
}
public void SelectStoreOrDCNameDropDown(String StoreorDCName) {
	StoreOrDCDropDown.isSelected();
	StoreOrDCNameDropDown.click();
	if(StoreorDCName.equals("TS Madision")) {
		SelectStoreNameAsTSMadision.isDisplayed();
		SelectStoreNameAsTSMadision.click();
	}
	else if(StoreorDCName.equals("Jayanagar Madision")) {
		SelectNameAsJayanagarMadision.isDisplayed();
		SelectNameAsJayanagarMadision.click();
	}
	else {
		System.out.println("Please Provide correct StoreorDCName in TestClass, "+StoreorDCName+" is not Valid Name");
	Assert.assertTrue(false);
	}
	
	
}
public void ClickOnZoneDropDown() {
	ZoneDropDown.click();
}
public void SelectZoneDropDown(String ZoneName) throws InterruptedException {
	System.out.println("System Login Zone is: "+ZoneName);
	Thread.sleep(2000);
	//b[contains(text(),'Diamond-Bangle Odd')]
	driver.findElement(By.xpath("//b[contains(text(),'"+ZoneName+"')]")).click();
}

public void SelectSegment(String Segment) {
	//SegmentDropDown.click();
	Select SegmentDropDownLoad= new Select(SegmentDropDown);
	SegmentDropDownLoad.selectByVisibleText(Segment);
}
public void ClickOnSearchButton() {
	SeachButton.click();
}


public void getFgStockNo() throws InterruptedException {
	System.out.println("1");
	Thread.sleep(500);
	 Actions actions = new Actions(driver); 
	actions.moveToElement(FGSearchGrid);
	actions.clickAndHold(FGSearchGrid).sendKeys(Keys.ARROW_RIGHT,Keys.ARROW_RIGHT);
	actions.perform();
	//driver.findElement(By.xpath("//thead/tr[1]/th[1]")).click();
	Thread.sleep(2000);
FGStockNo=	driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/aside/div[3]/div[1]/table/tbody/tr[1]/td[13]")).getText();
	//System.out.println("Stock Number: "+FGStockNo);
	 FgStockWt=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/aside/div[3]/div[1]/table/tbody/tr[1]/td[16]")).getText();
//System.out.println("Stock Weight: "+FgStockWt);
}
}
