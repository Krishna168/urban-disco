package demo;

import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import payload.AddPayLoad;

public class SpecBuilderTest {

	public static void main(String[] args) {
	
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
		ResponseSpecification res=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		
		//Request
		RequestSpecification rs=given().spec(req)
				.body(AddPayLoad.SerializablePayLoad());
		
		//Submitting and getting the response.
		Response response=rs.when().post("/maps/api/place/add/json")
				.then().spec(res).extract().response();
		String responseString=response.asString();
		System.out.println(responseString);


	}

}
