package demo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payload.AddPayLoad;
import payload.ReusableMethods;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//given- all input details.
		//when - Submit the API - contains the resource and http method.
		//then - validate the response.
		
		//Add Place
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(AddPayLoad.AddPlace()).when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP")).body("status", equalTo("OK"))
		.header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		System.out.println(response);
		JsonPath js=ReusableMethods.rawToJson(response);//for parsing the json.
		
		String placeID=js.getString("place_id");
		System.out.println(placeID);
		
		// Put Place
		String newAddress="70 spring walk, USA";
		given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeID).header("Content-Type", "application/json")
		.body("{\r\n" + 
				"\"place_id\":\""+placeID+"\",\r\n" + 
				"\"address\":\""+newAddress+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"")
		.when().put("maps/api/place/update/json")
		.then().log().all().assertThat().body("msg",equalTo("Address successfully updated"));
		
		//Get Place
		
		String response1=given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeID).header("Content-Type", "application/json")
		.when().get("maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(response1);
		JsonPath js1=ReusableMethods.rawToJson1(response1);
		String actualAddress=js1.getString("address");
		System.out.println(actualAddress);
		System.out.println(newAddress);
		Assert.assertEquals(actualAddress, newAddress);
		
		
		//Delete Place
		
		given().log().all().queryParam("key", "qaclick123").queryParam("Content-Type", "application/json")
		.body("{\r\n" + 
				"    \"place_id\":\""+placeID+"\"\r\n" + 
				"}\r\n" + 
				"")
		.when().delete("maps/api/place/delete/json")
		.then().log().all().assertThat().statusCode(200).body("status", equalTo("OK"));//one way of asserting the statuscode and status value in the output
		
		//Get Place - To check if the deleted place is successful.
		given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeID)
		.when().get("/maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(404).body("msg", equalTo("Get operation failed, looks like place_id  doesn't exists"));
		
	}

}
