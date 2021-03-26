package com.vajra.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPageObject {
	WebDriver driver;
	 public LoginPageObject(WebDriver rdriver)
	 {
		 driver=rdriver;
		 PageFactory.initElements(rdriver, this);
	 }
		@FindBy(id="uname")
		WebElement UserIDField;
		
		@FindBy(id="passwd")
		WebElement PasswordFiled;
		
		@FindBy(className ="btn-primary")
		WebElement LoginButton;
		
		@FindBy(xpath = "/html/body/div[1]/nav/div/div[2]/ul[2]/li[3]/a/span/span")
		WebElement logoutlink;
		
		@FindBy(xpath = "/html/body/div[1]/nav/div/div[2]/ul[2]/li[3]/ul/li[2]/a")
		WebElement logoutbutton;
		
		public void EnterUserID(String sEID) {
			UserIDField.sendKeys(sEID);
		}
			public void EnterUserPass(String sEpass){
				PasswordFiled.sendKeys(sEpass);
			}
			
			public void ClickOnLoginButton() {
				LoginButton.click();
			}
			public String getPageTitle() {
				String title = driver.getTitle();
				return title;
			}
			public void logoutlink() {
				logoutlink.click();
				logoutbutton.click();
			}
			
	}


