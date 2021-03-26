package com.vajra.TestClass;
import java.io.IOException;

import org.testng.annotations.*;

import com.vajra.pageobjects.LoginPageObject;
import com.vajra.utilities.XLUtilities;

public class LoginusingExcelsheet extends BaseClasss{

	@Test(dataProvider="LoginUserIDs")
	public void loginSales(String Slno,String username, String Passowrd)throws IOException,InterruptedException {
		driver.get(SalesURL);
		LoginPageObject LPO=new LoginPageObject(driver);
		
		LPO.EnterUserID(username);
		LPO.EnterUserPass(Passowrd);
		LPO.ClickOnLoginButton();
		
	}
	@DataProvider(name="LoginUserIDs")
	public static Object[][] login()throws IOException{
		String path=System.getProperty("C:\\Users\\jitendra.y\\git\\Vajra\\Vajra\\src\\test\\java\\com\\vajra\\TestData\\Usernameandpassword.xlsx");
		int rownum=XLUtilities.getRowCount(path, "Sale Login");
		int cocount=XLUtilities.getCellCount(path, "Sale Login", 1);
		String logindata[][]=new String[rownum][cocount];
		for (int i=1;i<=rownum;i++)
		{
			for(int j=0;j<=cocount;j++)
			{
				logindata[i-1][j]=XLUtilities.getCellData(path, "Sale Login", i, j);
			}
		}
		
		return logindata;
	}
	
}
