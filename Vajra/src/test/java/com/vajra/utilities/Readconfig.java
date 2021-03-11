package com.vajra.utilities;

import java.io.FileInputStream;
import java.util.*;

public class Readconfig {
	
	 Properties pro;
	
	public Readconfig()
	{
		try {
			//Read File from Same Directory
			FileInputStream src = new FileInputStream("./Configuration//config.properties");
			//Create a constructor
			pro =new Properties();
			//Load the Data from properties from config file
			pro.load(src);
		}catch(Exception e) {
			System.out.print("Exception is" +e.getMessage());
		}
	}
	
		public String readChrompath()
		{
			String Chropath= pro.getProperty("chromepath");
			return Chropath;
		}
		public String readFirefoxpath()
		{
			String Firefoxpath=pro.getProperty("firefoxpath");
			return Firefoxpath;
		}
	
		public String readBrowser()
		{
			String Broswer=pro.getProperty("Browser");
			return Broswer;
		}
		
	}


