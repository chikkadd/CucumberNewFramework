@test
Feature: Login Page feature

  Scenario: Validate unAuthenticated home page
    Given user is on login page
    When user gets title of the page
    Then page title should be "Automation Exercise"

  Scenario: validate display of signUp link
    Given user is on login page
    Then verify that signUp button displayed

  Scenario: verify Login with correct credentials
    Given user is on login page
    And I click on login link
    When user enters username "chikke0102@gmail.com"
    And user enters password "rules@123"
    And user clicks on Login button
    When user gets title of the page
    Then page title should be "Automation Exercise"
    Then verify that Delete Account button is visible

  Scenario: Login with Incorrect credentials
    Given user is on login page
    And I click on login link
    When user enters username "chikkadd20@gmail.com"
    And user enters password "incorrect"
    And user clicks on Login button
    Then verify that 'Your email or password is incorrect!' displayed
