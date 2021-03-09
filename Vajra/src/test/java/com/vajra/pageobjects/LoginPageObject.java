package com.vajra.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPageObject {
	WebDriver ldriver;
	 public LoginPageObject(WebDriver rdriver)
	 {
		 ldriver=rdriver;
		 PageFactory.initElements(rdriver, this);
	 }
	 
	 
		@FindBy(id="uname")
		WebElement UserIDField;
		
		@FindBy(id="passwd")
		WebElement PasswordFiled;
		
		@FindBy(className ="btn-primary")
		WebElement LoginButton;
		
		
		public void EnterUserID() {
			UserIDField.sendKeys("63");
		}
			public void EnterUserPass(){
				PasswordFiled.sendKeys("pass123");
			}
			
			public void ClickOnLoginButton() {
				LoginButton.click();
			}
	}

