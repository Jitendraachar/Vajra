package com.vajra.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {
	WebDriver driver;
	 public void SalesBillPage (WebDriver adriver)
	 {
		 driver=adriver;
				 PageFactory.initElements(adriver, this);
	 }
	 
	 
		@FindBy(id="uname")
		WebElement UserIDField;
		
		@FindBy(id="passwd")
		WebElement PasswordFiled;
		
		@FindBy(className ="btn-primary")
		WebElement LoginButton;
		
		
		public void EnterUserID() {
			UserIDField.sendKeys("");
		}
			public void EnterUserPass(){
				PasswordFiled.sendKeys("");
			}
			
			public void ClickOnLoginButton() {
				LoginButton.click();
			}
	}

