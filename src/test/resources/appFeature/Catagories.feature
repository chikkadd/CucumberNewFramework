Feature: Catagories section validation 

Background:
		Given user has already logged in to application 
		|username| password |
		|chikkadd20@gmail.com | rules@123 |

@smoke
Scenario: Catagories section validation 
		When user is on dashboard page
    Then dashboard page title should be "Automation Exercise"
    
@smoke
Scenario: Sub categories count 
    Given user is on dashboard page
    Then below sub catagories should be displayed
    |WOMEN|
    |MEN|
    |KIDS|
    Then number of catagories should be 3