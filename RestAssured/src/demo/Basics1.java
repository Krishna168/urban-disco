package demo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import payload.AddPayLoad;
import pojo.AddPlace1;

public class Basics1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//given- all input details.
		//when - Submit the API - contains the resource and http method.
		//then - validate the response.
		
		//Add Place
		RestAssured.baseURI="https://rahulshettyacademy.com";
		AddPlace1 response=given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(AddPayLoad.AddPlace()).when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).body("status", equalTo("OK"))
		.header("server", "Apache/2.4.18 (Ubuntu)").extract().response().as(AddPlace1.class);
	System.out.println(response.getPlace_id());
	System.out.println(response.getId());
		
		
		
		
		}

}
