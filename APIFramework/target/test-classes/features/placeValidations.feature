Feature: Validating AddPlace API
@AddPlaceAPI @Regression
Scenario Outline: Verify if the place has been added successfuly using the AddPlace API
Given The AddPlace Payload with "<name>" "<language>" "<address>"
When User calls the "AddPlaceAPI" with the "POST" http method
Then The Response should be Success with Status code should be 200
And Confirm the "status" field in response should be "OK"
And Confirm the "scope" field in response should be "APP"
And verify place_Id created maps to "<name>" using "getPlaceAPI"

Examples:
|name|language|address|
|Twinkle|Marathi|No.101, Wall Street, Mexico|
#|hari1|Gujarathi|No.55, Goodword shipping appartment,Singapore|

@DeletePlaceAPI @Regression
Scenario: Verify if Delete functionality is working fine
Given The Delete Place payload
When User calls the "deletePlaceAPI" with the "POST" http method
Then The Response should be Success with Status code should be 200
And Confirm the "status" field in response should be "OK" 