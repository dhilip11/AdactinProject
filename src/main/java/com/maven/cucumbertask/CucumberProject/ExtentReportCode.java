package com.maven.cucumbertask.CucumberProject;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportCode {

	static WebDriver driver;
	static ExtentTest test;
	static ExtentReports extent;
	static ExtentHtmlReporter htmlReporter;

	



@BeforeClass
	public void startTest() {
		htmlReporter = new ExtentHtmlReporter(
				"C:\\Users\\hi\\eclipse-workspace\\KalaiVaniV\\AirCanadaProject\\target\\extent1.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test = extent.createTest("Verify home page title", "Checking the title");
	}

	@Test
	public void atest() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\hi\\eclipse-workspace\\KalaiVaniV\\AirCanadaProject\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		test.log(Status.INFO, "Chrome Launched Successfully");
		driver.get("https://www.facebook.com/");
		if (driver.getCurrentUrl().contains("facebook")) {
			test.log(Status.PASS, "URL Launched Successfully");
		} else {
			test.log(Status.FAIL, "URL Launched Successfully");
		}
		if (driver.getTitle().contains("Facebook")) {
			test.log(Status.PASS, "Title Correct");
		} else {
			test.log(Status.FAIL, "Title Wrong");
		}
		
	}

	@Test
	public void btest() throws IOException {
		WebElement e = driver.findElement(By.id("email"));
		WebElement p = driver.findElement(By.id("pass"));
		WebElement b = driver.findElement(By.id("loginbutton"));
		e.sendKeys("Kalaivani");
		p.sendKeys("KV");
		if (e.getAttribute("value").equals("KalaiVani")) {
			test.log(Status.PASS, "Email Correct");
		} else {
			test.log(Status.FAIL, test.addScreenCaptureFromPath(capture()) + "Email Failed");
			
		}
		if (p.getAttribute("value").equals("KV")) {
			test.log(Status.PASS, "Password Correct");
		} else {
			test.log(Status.FAIL, "Password Wrong");
		}
		b.click();
	}

	@AfterClass
	public void close() {
		driver.quit();
		extent.flush();
	}
	
	public static String capture() throws IOException {
		TakesScreenshot t = (TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\hi\\eclipse-workspace\\KalaiVaniV\\AirCanadaProject\\Error Image"
				+ System.currentTimeMillis() + ".png");
		String errflpath = des.getAbsolutePath();
		FileUtils.copyFile(src, des);
		return errflpath;
	}

}




