Feature: Search and Place Order for Vegetables

@SmokeTest1
Scenario: Search for items and validate the results
Given The user is on GreenKart Landing Page
When The user searches for Cucumber vegetable
Then Validate the Cucumber search results are displayed

@RegressionTest
Scenario Outline: Search for items and proceed to checkout page
Given The user is on GreenKart Landing Page
When The user searches for <Vegetables> vegetable
And Validate the <Vegetables> search results are displayed
And User adding the item to the cart
And User proceeded to the checkout page for purchase
Then Verify selected <Vegetables> items are displayed in the checkout page

Examples:
|Vegetables|
|Brinjal|
|Beetroot|