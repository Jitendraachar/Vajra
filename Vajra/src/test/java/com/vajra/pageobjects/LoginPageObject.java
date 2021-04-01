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
	private WebElement UserIDField;

	@FindBy(id="passwd")
	private WebElement PasswordFiled;

	@FindBy(className ="btn-primary")
	WebElement LoginButton;

	@FindBy(xpath = "//body/div[1]/nav[1]/div[1]/div[2]/ul[2]/li[3]/a[1]/i[1]")
	WebElement logoutlink;

	@FindBy(xpath = "//body/div[1]/nav[1]/div[1]/div[2]/ul[2]/li[3]/ul[1]/li[2]/a[1]")
	WebElement logoutButton;

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
	}			


	public void logoutbutton() {
		if(logoutButton.isDisplayed()) {
			logoutButton.click();
		}
	}

}


