package com.vajra.pageobjects;

import java.util.Iterator;
import java.util.Set;

import javax.xml.xpath.XPath;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateSaleBill {
	WebDriver driver;

	public CreateSaleBill(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	public static String CustomerNameOnSearchCustomerPopUp;

	@FindBy(partialLinkText = "Functi")
	WebElement FunctionDropDown;

	@FindBy(linkText = "Bill")
	WebElement BillSubMenu;

	@FindBy(partialLinkText = "Sales Bi")
	WebElement SaleBillSubMenu;

	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/aside[1]/div[2]/div[1]/div[1]/select[1]")
	WebElement CreateOrSearchSaleBillDropDown;

	@FindBy(xpath = "//option[contains(text(),'Create Sales Bill')]")
	WebElement CreateSaleBillUnderDropDown;

	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/aside[1]/div[2]/div[1]/div[2]/div[1]/div[1]/select[1]")
	WebElement SelectDocTypeDropDown;

	@FindBy(xpath = "//option[contains(text(),'FG Stock')]")
	WebElement FgStockUnderDocTypeDropDown;

	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/aside[1]/div[3]/div[1]/div[1]/div[1]/input[1]")
	WebElement SearchCustomerInputBox;

	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/aside[1]/div[3]/div[1]/div[1]/div[2]/button[1]/i[1]")
	WebElement SearchCustomerButton;

	@FindBy(xpath = "//input[@id='custId-0']")
	WebElement SelectCustomerRadioButton;

	@FindBy(xpath = "/html[1]/body[1]/div[7]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]")
	WebElement CustomerName;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement OkButtonForCustomerSearch;

	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div/aside/div[3]/div/div[1]/div[3]/label/span")
	WebElement SaleBillPageCustomerName;

	@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/aside[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[1]/input[1]")
	WebElement StockNumberTextBox;

	@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/aside[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/input[1]")
	WebElement StockWeightTextBox;

	@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/aside[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[3]/button[1]/i[1]")
	WebElement GetStockDataButton;

	public void ClickOnGetSaleBillGrid() {
		GetStockDataButton.click();
	}

	public void ClickOnFunctionDropDown() {
		FunctionDropDown.isDisplayed();
		FunctionDropDown.click();
	}

	public void ClickOnBillSubMenu() {
		BillSubMenu.isDisplayed();
		BillSubMenu.click();
	}

	public void ClickOnSaleBillSubMenu() {
		SaleBillSubMenu.isDisplayed();
		SaleBillSubMenu.click();
	}

	public void SelectCreatOrSearchSaleBillDropDown() throws InterruptedException {
		// CreateOrSearchSaleBillDropDown.isEnabled();
		Thread.sleep(200);
		CreateOrSearchSaleBillDropDown.click();
		// Select CreateOrSearchType= new Select(CreateOrSearchSaleBillDropDown);
		// CreateOrSearchType.selectByVisibleText("Create Sales Bill");
	}

	public void SelectCreateSaleBill() {
		CreateSaleBillUnderDropDown.isDisplayed();
		// Thread.sleep(300);
		CreateSaleBillUnderDropDown.click();
	}

	public void selectDocType() {
		SelectDocTypeDropDown.isDisplayed();
		SelectDocTypeDropDown.click();

		// CreateSaleBillUnderDropDown.isSelected();
		// Select DocTypeDropDown= new Select(SelectDocTypeDropDown);
		// DocTypeDropDown.selectByVisibleText("FG Stock");
	}

	public void selectFgStockUnderDocTypeDropDown() throws InterruptedException {
		Thread.sleep(2000);
		FgStockUnderDocTypeDropDown.isDisplayed();
		FgStockUnderDocTypeDropDown.click();
	}

	public void SearchCustomerBox() {
		SelectDocTypeDropDown.isSelected();
		SearchCustomerInputBox.sendKeys("63");
	}

	public void ClicksearchCustomerButton() {

		SearchCustomerInputBox.isDisplayed();
		SearchCustomerButton.click();
	}

	public void SelectCustomerFromPopUp() throws InterruptedException {
		Thread.sleep(200);
		// to Get Current Focus Window
		driver.getWindowHandles();
		SelectCustomerRadioButton.isDisplayed();
		SelectCustomerRadioButton.click();
	}

	public void customerName() {
		CustomerNameOnSearchCustomerPopUp = CustomerName.getText();
		System.out.println(CustomerNameOnSearchCustomerPopUp);
	}

	public void OkButtonForCustomerSearch() {
		OkButtonForCustomerSearch.isDisplayed();
		OkButtonForCustomerSearch.click();
	}

	public void SaleBillCreatePageCustomerName() throws InterruptedException {
		Thread.sleep(2000);
		SaleBillPageCustomerName.isDisplayed();
		String CreateSaleBillPageCustomerName = SaleBillPageCustomerName.getText();
		System.out.println("-----------------------------------------CreateSaleBillPageCustomerName is " + CreateSaleBillPageCustomerName);
	}

	public void enterStockNumber(String FgStockNo) {
		StockNumberTextBox.isDisplayed();
		// CharSequence[] FGStockumber=FgStockNo;
		StockNumberTextBox.sendKeys(FgStockNo);
	}

	public void EnterStockWt(String StockWt) {
		StockWeightTextBox.isDisplayed();
		StockWeightTextBox.sendKeys(StockWt);
	}

	public void ClickOnArrowButton() {
		GetStockDataButton.click();
	}

}
