@test
Feature: Catagories section validation 

@smoke
Scenario: Catagories section validation 
		Given user has already logged in to application 
		|username| password |
		|chikkadd20@gmail.com | rules@123 |
		When user is on dashboard page
    	Then dashboard page title should be "Automation Exercise"
    
@sanity
Scenario: Sub categories count 
		Given user has already logged in to application 
		|username| password |
		|chikkadd20@gmail.com | rules@123 |
    	Given user is on dashboard page
    	Then below sub catagories should be displayed
    	|WOMEN|
    	|MEN|
    	|KIDS|
    	Then number of catagories should be 3