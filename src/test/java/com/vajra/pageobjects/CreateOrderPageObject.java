package com.vajra.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateOrderPageObject {
	WebDriver driver;
	boolean HomeCreate;
	boolean SearchCus;
	boolean CustomerIDBox;
	boolean SearchCustomerPage;
	boolean SearchCustomerNameDisplay;
	boolean OrderHeader;
	boolean OrderItem;

	public CreateOrderPageObject(WebDriver rdriver) {
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(partialLinkText = "Home / Create Docume")
	WebElement HomeCreateDocument;

	@FindBy(linkText ="Search Customer")
	WebElement SearchCustomer;

	@FindBy(xpath="//body/div[2]/div[1]/div[1]/div[1]/div[1]/aside[1]/div[2]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]")
	WebElement EnterCustomerID;

	@FindBy(xpath="//body/div[2]/div[1]/div[1]/div[1]/div[1]/aside[1]/div[2]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/button[1]")
	WebElement ClickOnSearchButton;

	@FindBy(xpath = "//thead/tr[1]/th[2]")
	WebElement SearchCustomerPageDisplay;

	@FindBy(xpath = "//span[contains(text(),'Ali')]")
	WebElement CustomerNameDisplay;

@FindBy(id="single-button")
WebElement ActionButton;

@FindBy(partialLinkText = "Create Ord")
WebElement CreateOrder;

@FindBy(xpath = "//h2[contains(text(),'Order Header')]")
WebElement OrderHeaderPage;

@FindBy (name = "occasion")
WebElement occasion;

@FindBy (id = "occasionDate")
WebElement occasionDate;

@FindBy(name="occasionRemarks")
WebElement occasionRemarks;

@FindBy(xpath = "//body/div[2]/div[1]/div[2]/div[1]/div[1]/aside[1]/div[2]/div[1]/div[1]/div[3]/div[1]/button[2]")
WebElement NextButton;

@FindBy(xpath = "//h2[contains(text(),'Order Details')]")
WebElement OrderItemPage;

	public void ClickOnHomeCreateDocument() {
		if( HomeCreate= HomeCreateDocument.isDisplayed()) {
			HomeCreateDocument.click();	
		}

	}
	public void ClickOnSearchCustomer() {
		if(SearchCus=SearchCustomer.isDisplayed()) {
			SearchCustomer.click();
		}

	}
	public void EnterCustomerID(String OrderCustomerID) {
		if(CustomerIDBox=EnterCustomerID.isDisplayed()) {
			EnterCustomerID.sendKeys(OrderCustomerID);
		}
	}
	public void ClickOnSearchButton() {
		ClickOnSearchButton.click();
		if(SearchCustomerPage=SearchCustomerPageDisplay.isDisplayed()) {
			System.out.println("Got Customer Search page");
		}
	}
	public void SearchCustomerNameDisplay() {

		try {
			if(SearchCustomerNameDisplay=CustomerNameDisplay.isDisplayed()) {
				System.out.println("Search Customer Found");
			}
		}
		catch(Exception e){
			System.out.println("Customer Not Matched");
		}
	}
	
	public void ActionButton() {
		ActionButton.click();
	}
	
	public void CreateOrder() {
		CreateOrder.click();
		
	}
	public void VerifyOrderHeaderPage() {
		OrderHeader=OrderHeaderPage.isDisplayed();

	}
	public void selectOccasion() {
		Select occasionDropdown= new Select(occasion);
		occasionDropdown.selectByVisibleText("Self");
	}
	public void SelectOccasionDate() {
		occasionDate.click();
		occasionDate.sendKeys(Keys.ENTER);
	}
	public void EnterOccasionRemarks() {
		occasionRemarks.sendKeys("Akash Automations");
	}
	
	public void ClickOnNextButton() {
		NextButton.click();
	}
	public void VerifyOrderItemPage() {
		if(OrderItem=OrderItemPage.isDisplayed())
			System.out.println("Welcome to Order Item Page");
	}
}