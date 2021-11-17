Feature: Log into application

Scenario Outline: Positive test validating login
Given Initialize the browser with chrome.
And Navigate to "http://qaclickacademy.com/" Site.
And Click on Login link in home page to land on secure sign in page.
When User enters <username> and <password> and logs in.
Then Verify that user is successfully logged in.
And Close the browsers.

Examples:
|username					|password		|
|krishnahari095@gmail.com	|krishna12345	|
|abc@gmail.com				|12896			|
