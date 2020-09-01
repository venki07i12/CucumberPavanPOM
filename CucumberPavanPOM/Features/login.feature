Feature: Login 

Scenario: Successful Login with Valid Credentials 
	Given User launch Chrome Browser 
	When User open URL "https://admin-demo.nopcommerce.com/login" 
	And User enters email as "admin@yourstore.com" and password as "admin" 
	And Click on login 
	Then Page Title should be "Dashboard / nopCommerce administration" 
	When User click on log out link 
	Then Page Title should be "Your store. Login" 
	And Close browser 
	
	
Scenario Outline: Login Data Driver 
	Given User launch Chrome Browser 
	When User open URL "https://admin-demo.nopcommerce.com/login" 
	And User enters email as "<email>" and password as "<password>" 
	And Click on login 
	Then Page Title should be "Dashboard / nopCommerce administration" 
	When User click on log out link 
	Then Page Title should be "Your store. Login" 
	And Close browser 
	
	Examples: 
		| email | password |
		|admin@yourstore.com | admin |
		|admin@yourstore.com | admin123 |