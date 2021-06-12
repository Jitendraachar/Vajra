package com.vajra.pageobjects;

import java.sql.Driver;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LooseStoneStock {
	public String loginZoneNamefromUI;
	WebDriver driver;
	public LooseStoneStock(WebDriver rdriver) {
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	

	@FindBy(partialLinkText = "Repo")
	WebElement ReportDropdown;

	@FindBy(linkText = "Stock")
	WebElement StockDropDown;

	@FindBy(partialLinkText = "Loose Stone Stock Report")
	WebElement LooseStoneStockSubMenu;

	@FindBy(xpath = "//option[contains(text(),'Select Status')]")
	WebElement StatusDropdown;

	@FindBy(name = "storeDc")
	WebElement StoreOrDCDropDown;

	@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/div[1]/aside[1]/form[1]/div[1]/div[5]/div[1]/div[1]/div[1]/button[1]")
	WebElement StoreOrDCNameDropDown;

	@FindBy(xpath = "/html/body/div[2]/nav/div/div[2]/ul[2]/li[3]/div[2]")
	WebElement loginZoneName;

	@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/div[1]/aside[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/button[1]")
	WebElement ZoneDropDownSelection;

	@FindBy(xpath = "")
	WebElement ClickOnLoginZone;
	@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/div[1]/aside[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]")
	WebElement SegmentDropDown;

	@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/div[1]/aside[1]/form[1]/div[2]/div[5]/select[1]")
	WebElement StockOrPacketDropDown;

	@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/div[1]/aside[1]/form[1]/div[4]/button[1]")
	WebElement SearchButton;

	public void clickOnReportDropDown() throws InterruptedException {
		Thread.sleep(200);
	//	if(ReportDropdown.isDisplayed()) {
			ReportDropdown.click();
	//	}
//		else {
//			Assert.assertTrue(false, "---------LoginFailed");
	//	}
	}

	public void clickOnStockSubMenu() {
		StockDropDown.isDisplayed();
		StockDropDown.click();
	}
	public void clickOnLosseStoneStockSubMenu() {
		LooseStoneStockSubMenu.isDisplayed();
		LooseStoneStockSubMenu.click();
	}
	@FindBy
	WebElement AvailableStatus;
	
	public void selectStatusDropDown() throws InterruptedException {
		Thread.sleep(2000);
		StatusDropdown.click();
		Thread.sleep(2000);
		if(AvailableStatus.isDisplayed()) {
		AvailableStatus.click();
		}
		else {
			StatusDropdown.click();
			AvailableStatus.click();
		}
	}
	public void storeOrDCDropDown(String StoreOrDC) {
		StoreOrDCDropDown.isDisplayed();
		Select SeStoreOrDCDropDown=new Select(StoreOrDCDropDown);
		SeStoreOrDCDropDown.selectByVisibleText(StoreOrDC);
	}
	public void storeOrDCNameButton() {
		StoreOrDCNameDropDown.isEnabled();
		StoreOrDCNameDropDown.click();
	}
	public void getloginZoneName() {
		loginZoneName.isDisplayed();
		loginZoneNamefromUI=loginZoneName.getText();
	}
	public void clickOnZoneDropDown() {
		ZoneDropDownSelection.isDisplayed();
		ZoneDropDownSelection.click();

	}
	public void SelectZoneDropDown(String ZoneName) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//b[contains(text(),'"+ZoneName+"')]")).click();
	}
	public void clickOnSegmentDropdown() {
		SegmentDropDown.isDisplayed();
		SegmentDropDown.click();
	}
	public void selectStockOrPacketDropDown() {
		StockOrPacketDropDown.isDisplayed();
		StockOrPacketDropDown.click();
	}
	public void clickOnSearchButton() {
	SearchButton.click();
}
}