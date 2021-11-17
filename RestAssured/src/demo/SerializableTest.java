package demo;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import payload.AddPayLoad;

public class SerializableTest {

	public static void main(String[] args) {
		
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		Response res=given().log().all().queryParam("key", "qaclick123")
				.body(AddPayLoad.SerializablePayLoad())
				.when().post("/maps/api/place/add/json")
				.then().assertThat().statusCode(200).extract().response();
		String response=res.asString();
		System.out.println(response);


	}

}
