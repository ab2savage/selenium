Feature: Google 

Background: 
	Start browser

Scenario: Test state 
	When I go to google page 
	Then I enter search field as "test" 
	And I click on search button 
	Then I should see google results page 
	
