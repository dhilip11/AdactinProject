package com.cucumber.helper;

import org.openqa.selenium.WebDriver;

import com.maven.cucumbertask.CucumberProject.LoginPage;
import com.maven.cucumbertask.CucumberProject.SearchHotelPage;

public class PageObjectHelper {

	public WebDriver driver;
	
	public PageObjectHelper(WebDriver xdriver) {
		this.driver=xdriver;
	}

	private LoginPage lpp;
	private SearchHotelPage shp;

	public LoginPage getLpp() {
		if (lpp==null) {
			lpp=new LoginPage(driver);
		}
		return lpp;
	}

	public SearchHotelPage getShp() {
		if (shp==null) {
			shp=new SearchHotelPage(driver);
		}
		return shp;
	}

}
