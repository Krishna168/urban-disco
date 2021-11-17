package demo;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payload.ReusableMethods;

public class StaticJson {
	@Test
	public void addBook() throws IOException
	{
		RestAssured.baseURI="http://216.10.245.166/";
		String response=given().log().all().header("Content-Type", "application/json")
				.body(GenerateStringFromResource("G:\\Rest API\\StaticJsonFile.json"))
				.when().post("/Library/Addbook.php")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();

		JsonPath js=ReusableMethods.rawToJson(response);
		String id=js.getString("ID");
		System.out.println(id);
	}
	public static String GenerateStringFromResource(String path) throws IOException
	{
		String filepath= new String(Files.readAllBytes(Paths.get(path)));  
		return filepath;
	}



}
