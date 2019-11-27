package com.project.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.cucumber.helper.PageObjectHelper;
import com.maven.cucumbertask.CucumberProject.Allmethods;
import com.maven.cucumbertask.CucumberProject.LoginPage;
import com.maven.cucumbertask.CucumberProject.SearchHotelPage;
import com.project.testrunner.Testrunner;

import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Stepdefinition  extends Allmethods{
	
	public static WebDriver driver=Testrunner.driver;
	public static PageObjectHelper ph=new PageObjectHelper(driver);

	@When("^User  Login to the application using username as in test data$")
	public void user_Login_to_the_application_using_username_as_in_test_data() throws Throwable {
	   //LoginPage lp = new LoginPage(driver);
	  // elementIsEnabled(ph.getLpp().getUsername());
	   inputValestoElement(ph.getLpp().getUsername(), "Dhilip91");
	    
	}

	@When("^User enter password as in test data$")
	public void user_enter_password_as_in_test_data() throws Throwable {
		 //LoginPage lp = new LoginPage(driver);
		// elementIsEnabled(ph.getLpp().getPassword());
		   inputValestoElement(ph.getLpp().getPassword(), "Dhilip@11");
	}
	
	@When("^User click on the login button$")
	public void user_click_on_the_login_button() throws Throwable {
	//LoginPage lp = new LoginPage(driver);
	clickOntheElement(ph.getLpp().getLogin());
	
	}
	
	@When("^User Select location as in test data$")
	public void user_Select_location_as_in_test_data() throws Throwable {
	    //SearchHotelPage sp = new SearchHotelPage(driver);
	    selectOptionInDD(ph.getShp().getLocation(), "visibletext", "Sydney");
	    
	}

	@When("^User Select hotel as in test data$")
	public void user_Select_hotel_as_in_test_data() throws Throwable {
		//SearchHotelPage sp = new SearchHotelPage(driver);
	    selectOptionInDD(ph.getShp().getHotels(), "index", "1");
	    
	}

	@When("^User Select room type as in test data$")
	public void user_Select_room_type_as_in_test_data() throws Throwable {
		//SearchHotelPage sp = new SearchHotelPage(driver);
	    selectOptionInDD(ph.getShp().getRoomtype(), "visibletext", "Standard");
	    
	}

	@When("^User Select no-of-rooms as in test data$")
	public void user_Select_no_of_rooms_as_in_test_data() throws Throwable {
		//SearchHotelPage sp = new SearchHotelPage(driver);
	    selectOptionInDD(ph.getShp().getRoomno(), "visibletext", "1 - One");
	    
	}

	@When("^User Enter check-in-date as in test data$")
	public void user_Enter_check_in_date_as_in_test_data() throws Throwable {
		//SearchHotelPage sp = new SearchHotelPage(driver);
		clearValuesinElement(ph.getShp().getCheckin());
	    inputValestoElement(ph.getShp().getCheckin(), "25/11/2019");
	}

	@When("^User checkout-date field as in test data$")
	public void user_checkout_date_field_as_in_test_data() throws Throwable {
		//SearchHotelPage sp = new SearchHotelPage(driver);
		clearValuesinElement(ph.getShp().getCheckout());
	    inputValestoElement(ph.getShp().getCheckout(), "23/11/2019");
	    
	}

	@When("^User Enter the Adult per room$")
	public void user_Enter_the_Adult_per_room() throws Throwable {
		//SearchHotelPage sp = new SearchHotelPage(driver);
		
	    selectOptionInDD(ph.getShp().getAdultroom(), "visibletext", "1 - One");
	    
	}

	@When("^User Enter the Child per room$")
	public void user_Enter_the_Child_per_room() throws Throwable {
		//SearchHotelPage sp = new SearchHotelPage(driver);
	    selectOptionInDD(ph.getShp().getChildroom(), "visibletext", "1 - One");

	}

	@When("^User Enter the sumbit button$")
	public void user_Enter_the_sumbit_button() throws Throwable {
		SearchHotelPage sp = new SearchHotelPage(driver);
		clickOntheElement(sp.getSubmit());
		
	}

	@When("^User Verify that system gives an error saying ‘check-in-date should not be later than check-out-date’$")
	public void user_Verify_that_system_gives_an_error_saying_check_in_date_should_not_be_later_than_check_out_date() throws Throwable {
		SearchHotelPage sp = new SearchHotelPage(driver);
		getText(sp.getCheckinerror());
		String text = sp.getCheckinerror().getText();
		Assert.assertEquals("Check-In Date shall be before than Check-Out Date", text);
		
	}


	
	
}
