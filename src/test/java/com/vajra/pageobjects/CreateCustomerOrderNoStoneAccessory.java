package com.vajra.pageobjects;




import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.google.inject.Key;

//locators for Creating Order with out stone and accessory
public class CreateCustomerOrderNoStoneAccessory {

	WebDriver driver;
	public  CreateCustomerOrderNoStoneAccessory(WebDriver rdriver) {
		driver=rdriver;
		PageFactory.initElements(rdriver, this);	

	}
	@FindBy(xpath = "//tbody/tr[1]/td[8]/div[1]/button[1]")
	WebElement Actions;

	@FindBy(xpath = "//tbody/tr[1]/td[8]/div[1]/ul[1]")
	private  List<WebElement> Actionelement;

	@FindBy(xpath = "//tbody/tr[1]/td[8]/div[1]/ul[1]/li[1]/a[1]")
	WebElement Create_Order;

	@FindBy(name = "occasion")
	WebElement OccasionSelectDropDown;  

	@FindBy(name="occasionDate")
	WebElement occasionDate;

	@FindBy(name = "occasionRemarks")
	WebElement occasionRemarks;

	@FindBy(xpath = "//body/div[2]/div[1]/div[2]/div[1]/div[1]/aside[1]/div[2]/div[1]/div[1]/div[3]/div[1]/button[2]")
	WebElement NextButton;

	public void Actions() {
		Actions.click();
	}
	public void  Actionelement(String ActionDropDown) {
		for(WebElement ordertypes:Actionelement)
		{
		//	System.out.println(ordertypes.getText());
			String neworder= ordertypes.getText();
			if(neworder.contains(ActionDropDown)) {
				Create_Order.click();
			}
		}
	}
	public void Occasion(String occasionName) {
		Select Occasiondropdown = new Select(OccasionSelectDropDown);
		Occasiondropdown.selectByVisibleText(occasionName);
	}

	public void occasionDate() {
		occasionDate.click();
		occasionDate.sendKeys(Keys.ENTER);
	}
	public void occasionRemarks(String occasion_Remarks_Entered) {
		occasionRemarks.sendKeys(occasion_Remarks_Entered);	
	}

	public void clickOnNextButton() {
		NextButton.click();
	}

}