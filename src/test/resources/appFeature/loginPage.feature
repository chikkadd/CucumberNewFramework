#Sample Feature Definition Template
Feature: Login Page feature

 
  Scenario: Login page title
    Given user is on login page
    When user gets title of the page
    Then page title should be "Automation Exercise"
    
	@test
  Scenario: validate signUp link
  Given user is on login page
  Then verify that signUp button displayed
  
  Scenario: Login with correct credentials
  Given user is on login page
  And I click on login link
  When user enters username "chikkadd20@gmail.com"
  And user enters password "rules@123"
  And user clicks on Login button 
  Then page title should be "Automation Exercise"  