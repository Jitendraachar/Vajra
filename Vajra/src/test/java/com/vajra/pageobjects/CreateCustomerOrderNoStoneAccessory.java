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

	/*
	 * @FindBy(name="occasionDate") WebElement occasionDate;
	 */
	@FindBy(name = "occasionRemarks")
	WebElement occasionRemarks;

	@FindBy(xpath = "//body/div[2]/div[1]/div[2]/div[1]/div[1]/aside[1]/div[2]/div[1]/div[1]/div[3]/div[1]/button[2]")
	WebElement NextButton;
	
	@FindBy(xpath ="//body/div[2]/div[1]/div[2]/div[1]/div[1]/aside[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[4]/div[1]/div[1]/label[1]" )
	WebElement Calanderbutton;
	
	@FindBy(xpath = "//body/div[@id='ui-datepicker-div']/div[1]/div[1]/select[1]")
	WebElement Month;
	
	@FindBy(xpath = "//body/div[@id='ui-datepicker-div']/div[1]/div[1]/select[2]")
	WebElement Year;
	
	@FindBy(xpath = "/html/body/div[4]//table//tbody//tr//td//a")
	List<WebElement> Alldates;
	
	@FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[1]/aside/div[2]/div/div/div[3]/div/button[2]")
	WebElement Next;
	
	public void Actions() {
		Actions.click();
	}
	public void  Actionelement(String ActionDropDown) {
		for(WebElement ordertypes:Actionelement)
		{
			System.out.println(ordertypes.getText());
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

	/*
	 * public void occasionDate() { occasionDate.click();
	 * occasionDate.sendKeys(Keys.ENTER); }
	 */
	public void occasionRemarks(String occasion_Remarks_Entered) {
		occasionRemarks.sendKeys(occasion_Remarks_Entered);	
	}
	
	public void calander() {
		Calanderbutton.click();
	}
	
	public void Month(String mt) {
		System.out.println(mt);
		Select month=new Select(Month);
		month.selectByVisibleText(mt);
	}

	public void Year(String year) {
		System.out.println(year);
		Select Yr=new Select(Year);
		Yr.selectByVisibleText(year);
	}
	public void Alldates(String dt) {
		for(WebElement dates:Alldates) {
			String Date=dates.getText();
			if(Date.equals(dt));
			{
				dates.click();
				break;	
			}
			
		}
	}
	public void clickOnNextButton() {
		Next.click();
	}

}