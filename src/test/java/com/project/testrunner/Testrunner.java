package com.project.testrunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.helper.ConfigReader;
import com.cucumber.listener.Reporter;
import com.maven.cucumbertask.CucumberProject.Allmethods;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin= {
		"com.cucumber.listener.ExtentCucumberFormatter:src\\test\\resources\\com\\cucumber\\reports\\ExtentReport\\extent.html"},
		features = "src\\test\\java\\com\\project\\feature", 
glue = "com.project.stepdefinition",tags= {"@TC101"}
)
		

public class Testrunner extends Allmethods {

	@BeforeClass
	public static void driverLaunch() throws Throwable {
		ConfigReader cr=new ConfigReader();
		System.out.println("driver launching");
		//Allmethods.getBrowser("chrome");
		getBrowser(cr.gettingBrowserName());
		
		
		//Allmethods.getUrl("https://adactin.com/HotelApp/index.php");
		getUrl(cr.gettingUrl());
	}

	@AfterClass
	public static void driverQuit() {
		driver.quit();
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+ "\\src\\test\\resources\\com\\cucumber\\prop\\extent-config.xml"));
		System.out.println("Driver Quit");

	}
}
