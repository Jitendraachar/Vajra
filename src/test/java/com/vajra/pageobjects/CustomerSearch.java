package com.vajra.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerSearch {

	WebDriver driver;
	
	public CustomerSearch(WebDriver rdriver) {
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
		
	@FindBy(xpath = "//body/div[1]/nav[1]/div[1]/div[2]/ul[1]/li[1]/a[1]")
	WebElement Home_Create_Document;
	
	@FindBy(xpath = "//body/div[1]/nav[1]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]")
	WebElement Search_Customer;
	
	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[1]/div[1]/aside[1]/div[2]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/button[1]")
	WebElement Search;
	
	
	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[1]/div[1]/aside[1]/div[2]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/button[3]")
	WebElement Clear; 
	
	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[1]/div[1]/aside[1]/div[2]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]")
	WebElement Customer_ID;
	
	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[1]/div[1]/aside[1]/div[2]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/input[1]")
	WebElement Customer_Name;
	
	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[1]/div[1]/aside[1]/div[2]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[3]/input[1]")
	WebElement Contact_Number;
	
	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[1]/div[1]/aside[1]/div[2]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[4]/input[1]")
	WebElement Loyalty_Card;
	
	public void Home_Create_Document() {
		Home_Create_Document.click();
	}
	public void Search_Customer() {
		Search_Customer.click();
	}
	public void Search() {
		Search.click();
	}	
	public void Clear() {
		Clear.click();
	}
	public void Customer_ID(String Customer_id) {
		Customer_ID.sendKeys(Customer_id);
	}
	public void Customer_Name(String Customer_name)
	{
	Customer_Name.sendKeys(Customer_name);
	}
	public void Contact_Number(String Contact_number) {
		Contact_Number.sendKeys(Contact_number);
	}
	public void Loyalty_Card(String Loyalty_card) {
		Loyalty_Card.sendKeys(Loyalty_card);
	}
}
