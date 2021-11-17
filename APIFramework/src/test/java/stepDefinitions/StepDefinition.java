package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinition extends Utils {

	RequestSpecification rs;
	ResponseSpecification res;
	Response response;
	TestDataBuild td=new TestDataBuild();
	 static String place_id;


	@Given("The AddPlace Payload with {string} {string} {string}")
	public void the_AddPlace_Payload_with(String name, String language, String address) throws IOException {
		rs=given().spec(requestSpecification())
				.body(td.addPlacePayLoad(name,language,address));
	}

	@When("User calls the {string} with the {string} http method")
	public void user_calls_the_with_the_http_method(String resource, String method) {

		//Below statement will call constructor based on the resource value which you pass.
		APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());

		res=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		if(method.equalsIgnoreCase("POST"))
			response=rs.when().post(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("GET"))
			response=rs.when().get(resourceAPI.getResource());
		else
			response=rs.when().delete(resourceAPI.getResource());

	}

	@Then("The Response should be Success with Status code should be {int}")
	public void the_Response_should_be_Success_with_Status_code_should_be(Integer int1) {

		assertEquals(response.getStatusCode(),200);
	}

	@Then("Confirm the {string} field in response should be {string}")
	public void confirm_the_field_in_response_should_be(String ActualKey, String ExpectedKeyValue) {


		assertEquals(getJsonPath(response,ActualKey),ExpectedKeyValue);
		//Assert.assertEquals(ExpectedKeyValue, ActualKeyValue);--->this method is depreciated.

	}

	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_Id_created_maps_to_using(String expectedName, String resource) throws IOException {
		
		 place_id=getJsonPath(response,"place_id");
		rs=given().spec(requestSpecification()).queryParam("place_id",place_id);
		user_calls_the_with_the_http_method(resource, "GET");
		String actualName=getJsonPath(response,"name");
		assertEquals(actualName,expectedName);
	}
	
	@Given("The Delete Place payload")
	public void the_Delete_Place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		rs=given().spec(requestSpecification())
				.body(td.deletePlacePayLoad(place_id));
	}





}
