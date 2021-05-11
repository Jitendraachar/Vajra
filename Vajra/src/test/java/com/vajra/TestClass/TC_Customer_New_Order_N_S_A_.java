package com.vajra.TestClass;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vajra.pageobjects.CreateCustomerOrderNoStoneAccessory;
import com.vajra.pageobjects.CustomerSearch;
import com.vajra.pageobjects.LoginPageObject;
import com.vajra.pageobjects.OrderDetails_N_S_A;
import com.vajra.utilities.XLUtilities;

import junit.framework.Assert;


public class TC_Customer_New_Order_N_S_A_ extends BaseClasss{
	String Month="May";
	String Year="2021";
	String date="10";
	String OK="New Order-NO";
	String seg="Gold";
	String jew="Bangle Odd";
	String vcode="BKK";
	String pcs="1";
	String mc="Plain Gold";
	String sc="Bangle Odd Set Bangles 1 set of 6 pcs - Fancy Plain";
	String duemonth="May";
	String dueyear="2021";
	String duedate="10";
	String metalcolor="Yellow Gold";
	String SP="92.00";
	String mweight="Absolute";
	String emw="12";
	String Itemdesc="Automation by jitendra";
	String VI="Automation by jitendra";
	String lgth="None\"";
	String Sze="1 7/16 - 1 8/16\"";
	String plsh="Yellow Polish";
	String opensetting="Open Setting";
	String Autname="63 - Jitendra";
	String autpassword="pass123";
	String remarkautho="Jituautomation";
	//Login 
	@Test(dataProvider="LoginUserIDs",priority=1)
	public void loginSales(String username, String Passowrd,String Exc)throws IOException,InterruptedException {
		driver.get(SalesURL);
		LoginPageObject LPO=new LoginPageObject(driver);
		CustomerSearch CS=new CustomerSearch(driver);
		CreateCustomerOrderNoStoneAccessory  CCNSA=new CreateCustomerOrderNoStoneAccessory(driver);
		OrderDetails_N_S_A ODNSA=new OrderDetails_N_S_A(driver);
		LPO.EnterUserID(username);
		LPO.EnterUserPass(Passowrd);
		LPO.ClickOnLoginButton();
		String Actual_title=driver.getTitle();
		String exp_title="Sales - Dashboard - Sales";
		captureScreenShot(driver, "Login Page");

		if(Exc.equals("Valid"))
		{
			if(exp_title.equals(Actual_title))
			{
				Assert.assertTrue(true);
				CS.Home_Create_Document();
				CS.Search_Customer();
				Thread.sleep(1000);
				CS.Search();
				Thread.sleep(1000);
				CCNSA.Actions();
				Thread.sleep(1000);
				CCNSA.Actionelement("  Create Order");
				Thread.sleep(1000);
				CCNSA.Occasion("Self");
				CCNSA.calander();
				CCNSA.Month(Month);
				driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
				CCNSA.Year(Year);
				driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
				CCNSA.Alldates(date);
				driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
				CCNSA.occasionRemarks("Jitu Automation");
				Thread.sleep(1000);
				 JavascriptExecutor js = (JavascriptExecutor) driver;
				 js.executeScript("window.scrollBy(0,200)");
				 CCNSA.clickOnNextButton();
				 driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
				 ODNSA.orderkind(OK);
				 ODNSA.segment(seg);
				 js.executeScript("window.scrollBy(0,200)");
				 ODNSA.jewel(jew);
				 ODNSA.pieces(pcs);
				 ODNSA.vendorcode();
				 ODNSA.clickvendorcodesearch();
				 ODNSA.codeselect(vcode);
				 ODNSA.submitcode();
				 ODNSA.Articlecode();
				 ODNSA.Maincat(mc);
				 ODNSA.Subcategory(sc);
				 ODNSA.ARC();
				 ODNSA.clickacok();
				 ODNSA.dueCalander();
				 ODNSA.dmonth(duemonth);
				 ODNSA.dyear(dueyear);
				 Thread.sleep(1000);
				 ODNSA.ddate(duedate);
				 Thread.sleep(1000);
				 js.executeScript("window.scrollBy(0,200)");
				 ODNSA.Metalcolor(metalcolor);
				 ODNSA.Skinpuirty(SP);
				 ODNSA.Metalweight(mweight);
				 ODNSA.Expectedweight(emw);
				 ODNSA.itemdescription(Itemdesc);
				 ODNSA.vendorinstruction(VI);
				 js.executeScript("window.scrollBy(0,400)");
				 ODNSA.length(); 
				 ODNSA.lenghtdrp(lgth);
				 ODNSA.Size();
				 ODNSA.Sizedrp(Sze);
				 ODNSA.Polishtype();
				 ODNSA.polistdrp(plsh);
				 ODNSA.Settingtype();
				 ODNSA.SettingTypedrp(opensetting);
				 ODNSA.createordernext();
				Thread.sleep(1000);
				 ODNSA.Advance();
				 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				 driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
				 ODNSA.createadvancenext();
				 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				 ODNSA.saveandproceed();
				 driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
				 ODNSA.alertadvance();
				 ODNSA.Authorizationnames();
				 driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
				 ODNSA.selectauthname(Autname);
				 driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
				 ODNSA.autpassowrd(autpassword);
				 ODNSA.remarkauth(remarkautho);
				 ODNSA.Authobutton();
				 driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
				 ODNSA.OrderId();
				 
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		else if(Exc.equals("Invalid"))
		{
			if(exp_title.equals(Actual_title))
			{
				LPO.logoutlink();
				LPO.logoutbutton();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}

	}
	@DataProvider(name="LoginUserIDs")
	public String[][] getdata() throws IOException, InterruptedException{
		String path="C:\\Users\\jitendra.y\\git\\Vajra\\Vajra\\src\\test\\java\\com\\vajra\\TestData\\Usernameandpassword.xlsx";
		//XLUtilities xlutil= new XLUtilities(path);

		int totalrows=XLUtilities.getRowCount(path,"Customer search");
		int totalcols=XLUtilities.getCellCount(path, "Customer search", 1);

		String logindata[][]= new String[totalrows][totalcols];

		for(int i=1;i<=totalrows;i++)
		{
			for (int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]=XLUtilities.getCellData(path,"Customer search", i, j);			
			}
		}
		return 	logindata;
	}

}

