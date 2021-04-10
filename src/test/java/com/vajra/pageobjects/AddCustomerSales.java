package com.vajra.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class AddCustomerSales {
	WebDriver driver;
	boolean AddCusButton;
	boolean createCus;
	boolean SuccessMsgDisplay;
	public AddCustomerSales(WebDriver rdriver) {
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(partialLinkText = "Add New Custom")
	WebElement AddCustomer;

	@FindBy(name = "customerTitles")
	WebElement CustomerTitle;

	@FindBy(name = "firstname")
	WebElement CustomerFirstName;

	@FindBy(name = "lastname")
	WebElement CustomerLastName;

	@FindBy (name = "gender")
	WebElement CustomerGender;

	@FindBy (name = "address1")
	WebElement CustomerAddressOne;

	@FindBy (name="address2")
	WebElement CustomerAddressTwo;

	@FindBy (name="address3")
	WebElement CustomerAddressThree;

	@FindBy (name="panNumber")
	WebElement CustomerPANNUmber;

	@FindBy(name="mobile")
	WebElement CustomerMobileNumberOne;

	@FindBy(name = "mobile2")
	WebElement CustomerMobileNumberTwo;

	@FindBy (name="landLineHome")
	WebElement CustomerlandLineHome;

	@FindBy (name="landLineOffice")
	WebElement CustomerLandLineOffice;

	@FindBy (name="country")
	WebElement CustomerCountry;

	@FindBy (name = "state")
	WebElement CustomerState;

	@FindBy (name="city")
	WebElement CustomerCity;

	@FindBy (name="email")
	WebElement CustomerEmailID;

	@FindBy (name = "pincode")
	WebElement CustomerPinCode;

	@FindBy (name = "gstinNo")
	WebElement CustomerGstinNo;

	@FindBy (name="aadharCard")
	WebElement CustomerAdharCard;

	@FindBy (xpath = "//body/div[2]/div[1]/div[1]/div[1]/div[1]/aside[1]/div[2]/div[2]/div[2]/div[1]/div[2]/form[1]/div[3]/button[1]")
	WebElement AddCustomerButton;

	@FindBy (xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/aside[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/h2[1]")
	WebElement SuccessMsg;



	public void ClickOnCreateCustomerButton() {
		
		if(AddCusButton=AddCustomer.isDisplayed()) {
			AddCustomer.click();

		}
	}

	public void SelectCustomerTitle(){
		Select CusTitle= new Select(CustomerTitle);
		CusTitle.selectByVisibleText("Mr");
	}

	public void EnterCustomerFirstName() {
		CustomerFirstName.sendKeys("Shivaaaa");
	}


	public void EnterCustomerLastName() {
		CustomerLastName.sendKeys("Shankaraaa");
	}

	public void SelectCustomerGender() {
		Select CusGender=new Select(CustomerGender);
		CusGender.selectByVisibleText("Male");
	}

	public void EnterCustomerAddressOne() {
		CustomerAddressOne.sendKeys("Himalya");
	}

	public void EnterCustomerAddressTwo() {
		CustomerAddressTwo.sendKeys("JK");
	}

	public void EnterCustomerAddressThree() {
		CustomerAddressThree.sendKeys("Mountin 1");
	}

	public void EnterCustomerPANNumber() {
		CustomerPANNUmber.sendKeys("");
	}

	public void EnterCustomerMobileNumberOne() {
		CustomerMobileNumberOne.sendKeys("1344689977");
	}

	public void EnterCustomerMobileNumberTwo() {
		CustomerMobileNumberTwo.sendKeys("");
	}
	
	public void EnterCustomerLandLineHomeNumber() {
		CustomerlandLineHome.sendKeys("");
	}
	
	public void EnterCustomerCustomerLandLineOffice() {
		CustomerLandLineOffice.sendKeys("");
	}
	
	public void SelectCustomerCountry() {
		Select CusCountry=new Select(CustomerCountry);
		CusCountry.selectByVisibleText("India");
	}

	public void SelectCustomerState() {

		Select CusState=new Select(CustomerState);
		CusState.selectByVisibleText("29 - Karnataka");
	}

	public void SelectCustomerCity() {
		Select CusCity= new Select(CustomerCity);
		CusCity.selectByVisibleText("Bagalkot");
	}

	public void EnterCustomerEmailID() {
		CustomerEmailID.sendKeys("ShivShankar3416@gmail.com");
	}

	public void EnterCustomerPINCode() {
		CustomerPinCode.sendKeys("654171");
	}
	public void EnterCustomerGSTNumber() {
		CustomerGstinNo.sendKeys("");
	}

	public void EnterCustomerAdharCardNumber() {
		CustomerAdharCard.sendKeys("");
	}

	public void ClickOnAddCustomerButton() {
		if(createCus=AddCustomerButton.isDisplayed()) {
			AddCustomerButton.click();
		}
	}
	public void VerifyCreatedCustomer() {
		if(SuccessMsgDisplay=SuccessMsg.isDisplayed()) {
			String SuccessMessage=SuccessMsg.getText();
			System.out.println(SuccessMessage);
			
			
			int CustomerID = Integer.parseInt(SuccessMessage);
			System.out.println("Customer ID is "+CustomerID);
		}
		else
			System.out.println("Unable to create Customer");
	}
}