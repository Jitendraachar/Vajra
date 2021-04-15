package com.vajra.TestClass;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class dummyone {
	final	Logger logger=LogManager.getLogger("dummyone");
	 
	@Test
	private void pub() {
		//C:\Users\akash\git\Vajra\Configuration\log4j2.properties
		String log4jConfPath = System.getProperty("user.dir")+"\\Configuration\\log4j2.properties";

		BasicConfigurator.configure();
		
		PropertyConfigurator.configure("Configuration\\log4j2.properties");
		logger.info("Properties file location is "+log4jConfPath);
		
		//BasicConfigurator.configure(); 
		logger.info("We are in info");
		logger.fatal("We are in fatal");
		logger.debug("We are in debug");
System.out.println("in Method");
logger.info("We are in info for Printed");

if(1==1) {
logger.info("Test Pass");
logger.info("We are in info if Conditions");
Assert.assertTrue(true);
logger.info("Assert condition pass in info");

}
	}
}
