Feature: Application Login

#Background: Open the browser and navigate to Application URL
#Given Chrome Browser should be opened
#When Navigate to the Application URl
#Then Check the Application URL by verifying its title

@SanityTest @SmokeTest
Scenario: HomePage displayed on default logging in for normal user
Given The user is on the Netbanking landing page
When The user logs into the application with "Krish" and "234"
Then HomePage should be displayed
And Cards displayed are "true"

@MobileTest
Scenario: HomePage displayed on default logging in for restricted user
Given The user is on the Netbanking landing page
When The user logs into the application with "hari" and "1256"
Then HomePage should be displayed
And Cards displayed are "false"

@WebTest
Scenario: HomePage displayed on default logging in for restricted user
Given The user is on the Netbanking landing page
When The user logs into the application with "kgiflfg" and "41268"
Then HomePage should be displayed
And Cards displayed are "false"



@MobileTest
Scenario: HomePage displayed on default logging in for signup details
Given The user is on the Netbanking landing page
When The user signs up with the following details
|krishna|prasath|11-02-1999|abc@gmail.com|587596|
Then HomePage should be displayed
And Cards displayed are "false"

@WebTest
Scenario Outline: HomePage displayed on default logging in for multiple users by parameterization
Given The user is on the Netbanking landing page
When The user log into the application with <username> and <password>
Then HomePage should be displayed
And Cards displayed are "true"

Examples:
|username|password|
|user1|pass1|
|user2|pass2|
|user3|pass3|
|user4|pass4|


