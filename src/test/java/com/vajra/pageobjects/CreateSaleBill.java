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
	
	@FindBy(xpath = "//body/div[2]/nav[1]/div[1]/div[2]/ul[1]/li[3]/a[1]")
	WebElement FunctionDropDown;
	
	@FindBy(xpath = "//body/div[2]/nav[1]/div[1]/div[2]/ul[1]/li[3]/ul[1]/li[1]/a[1]")
	WebElement BillSubMenu;
	
	@FindBy(partialLinkText = "Sales Bi")
	WebElement SaleBillSubMenu;
	
	
	public void ClickOnFunctionDropDown() {
		BillSubMenu.isDisplayed();
		BillSubMenu.click();
	}
	public void ClickOnBillSubMenu() {
		SaleBillSubMenu.isDisplayed();
		SaleBillSubMenu.click();
	}
	public void ClickOnSaleBillSubMenu() {
		SaleBillSubMenu.isDisplayed();
		SaleBillSubMenu.click();
	}
}
