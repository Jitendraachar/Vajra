package com.vajra.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateSaleBill {
	WebDriver driver;
	public CreateSaleBill(WebDriver rdriver) {
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(partialLinkText = "Functi")
	WebElement FunctionDropDown;
	
	@FindBy(linkText = "Bill")
	WebElement BillSubMenu;
	
	@FindBy(partialLinkText = "Sales Bi")
	WebElement SaleBillSubMenu;
	
	
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
}
