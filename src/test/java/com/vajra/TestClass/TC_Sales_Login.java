package com.vajra.TestClass;
import java.io.IOException;
import org.testng.annotations.*;
import com.vajra.pageobjects.LoginPageObject;
import com.vajra.utilities.XLUtilities;
import junit.framework.Assert;

public class TC_Sales_Login extends BaseClasss {
	@Test(dataProvider="LoginUserIDs")
	public void loginSales(String username, String Passowrd,String Exc)throws IOException,InterruptedException {
		driver.get(SalesURL);
		LoginPageObject LPO=new LoginPageObject(driver);

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
				LPO.logoutlink();
				Assert.assertTrue(true);
				LPO.logoutbutton();
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
		
		int totalrows=XLUtilities.getRowCount(path,"Sale Login");
		int totalcols=XLUtilities.getCellCount(path, "Sale Login", 0);
		
		String logindata[][]= new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)
		{
			for (int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]=XLUtilities.getCellData(path,"Sale Login", i, j);			
			}
		}
		return 	logindata;
	}


}
