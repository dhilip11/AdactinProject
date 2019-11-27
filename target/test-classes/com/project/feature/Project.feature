Feature: Sample Test Cases for Automation for AdactIn Hotel Application


@TC101
Scenario: To verify valid login details
When User  Login to the application using username as in test data
And User enter password as in test data
And User click on the login button

@TC102
Scenario: To verify whether the check-out date field accepts a later date than checkin date.
When User  Login to the application using username as in test data
And User enter password as in test data
And User click on the login button
And User Select location as in test data
And User Select hotel as in test data
And  User Select room type as in test data
And User Select no-of-rooms as in test data
And User Enter check-in-date as in test data
And  User checkout-date field as in test data
And User Enter the Adult per room
And User Enter the Child per room
And User Enter the sumbit button
And User Verify that system gives an error saying ‘check-in-date should not be later than check-out-date’

@TC103
Scenario: To check if error is reported if check-out date field is in the past
When User  Login to the application using username as in test data
And User enter password as in test data
And User click on the login button
And User Select location as in test data
And User Select hotel as in test data
And  User Select room type as in test data
And User Select no-of-rooms as in test data
And User Enter check-in-date as in test data
And  User checkout-date field as in test data
And User Enter the Adult per room
And User Enter the Child per room
And User Enter the sumbit button
