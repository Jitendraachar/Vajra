package com.vajra.pageobjects;




import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
}