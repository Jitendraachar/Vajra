package com.vajra.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
	
	static Properties pro;
	
	public void readConfig()
	{
		try {
			//Read File from Same Directory
			FileInputStream Properties= new FileInputStream("./Configuration/config.properties");
			//Create a constructore 
			pro =new Properties();
			//Load the Data from properties from config file
			pro.load(Properties);
		}catch(Exception e) {
			System.out.print("could not load the file");
		}
	}
		public static String readChrompath()
		{
			String Chropath=pro.getProperty("chromepath");
			return Chropath;
			
		}
		public static String readFirefoxpath()
		{
			String Firefoxpath=pro.getProperty("firefoxpath");
			return Firefoxpath;
		}
		public static String envirnoment()
		{
			String env=pro.getProperty("Environment");
			return env;
		}
		
	}


