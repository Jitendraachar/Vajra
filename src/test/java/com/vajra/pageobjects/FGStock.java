package com.vajra.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FGStock {
WebDriver driver;
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

@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/div[1]/aside[1]/form[1]/div[1]/div[1]/select[1]")
WebElement StatusDropDown;

@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/div[1]/aside[1]/form[1]/div[1]/div[4]/select[1]")
WebElement StoreOrDCDropDown;

@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/div[1]/aside[1]/form[1]/div[1]/div[5]/div[1]/div[1]/div[1]/button[1]")
WebElement StoreOrDCNameDropDown;

@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/div[1]/aside[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/button[1]")
WebElement ZoneDropDown;

@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/div[1]/aside[1]/form[1]/div[2]/div[1]/select[1]")
WebElement SegmentDropDown;

@FindBy(xpath = "//button[@id='search']")
WebElement SeachButton;

public void ClickOnReportDropdown() throws InterruptedException {
	Thread.sleep(2000);
	//ReportDropdown.isDisplayed();
	ReportDropdown.click();
}
public void ClickOnStockDropDown() {
//	StockDropDown.isDisplayed();
	StockDropDown.click();
}
public void ClickOnFGStockSubMenu() {
	//FGStockSubMenu.isDisplayed();
	FGStockSubMenu.click();
}
public void SelectStatusDropdown(String Status) throws InterruptedException {
	Thread.sleep(3000);
	//StatusDropDown.isDisplayed();
	System.out.println("1");
Select StatusAllDropDown=new Select(StatusDropDown);
System.out.println("2");

StatusAllDropDown.selectByVisibleText(Status);
System.out.println("3");

}
public void SelectStoreOrDCDropDown(String StoreOrDC) {
	StatusDropDown.isSelected();
	Select StoreOrDCDrop=new Select(StoreOrDCDropDown);
	StoreOrDCDrop.selectByVisibleText(StoreOrDC);
}
public void SelectStoreOrDCNameDropDown(String StoreorDCName) {
	StoreOrDCDropDown.isSelected();
	Select StoreorDCNameDrop=new Select(StoreOrDCNameDropDown);
	StoreorDCNameDrop.selectByVisibleText(StoreorDCName);
	
}
}
