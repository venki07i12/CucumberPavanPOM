Feature:  Customers

Background: Below are the common steps for each scenario
	Given User launch Chrome Browser 
	When User open URL "https://admin-demo.nopcommerce.com/login" 
	And User enters email as "admin@yourstore.com" and password as "admin" 
	And Click on login 
	Then User can view Dashboard 

Scenario: Add a new Customer 
	When User Click on customers Menu 
	And Click on customers Menu Item 
	And Click on Add new button 
	Then User can view Add new customer page 
	When User enter customer info 
	And Click on save button 
	Then User can view confirmation message "The new customer has been added successfully." 
	And  Close browser 

	
Scenario: Search Customer by emialID 
	When User Click on customers Menu 
	And Click on customers Menu Item 
	And Enter customer email
	When Click on search button
	Then user should found email in the search button
	And  Close browser 
	
Scenario: Search Customer by Name 
	When User Click on customers Menu 
	And Click on customers Menu Item 
	And Enter customer Firstname
	And Enter customer Lastname
	When Click on search button
	Then user should found name in the search button
	And  Close browser 