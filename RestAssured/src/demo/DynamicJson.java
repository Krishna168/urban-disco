package demo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payload.AddPayLoad;
import payload.ReusableMethods;

public class DynamicJson {
	public String  id;
	@Test(dataProvider="BooksData")
	public void addBook(String isbn,String aisle)
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().header("Content-Type", "application/json")
		.body(AddPayLoad.AddBook(isbn,aisle))
		.when().post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js=ReusableMethods.rawToJson(response);
		 id=js.getString("ID");
		System.out.println(id);
		
		//RestAssured.baseURI="http://216.10.245.166";
		given().log().all().headers("Content-Type","application/json")
		.body(AddPayLoad.DeleteBook(id))
		.when().delete("/Library/DeleteBook.php")
		.then().log().all().statusCode(200).body("msg",equalTo("book is successfully deleted"));
	}
	
	
	@DataProvider(name="BooksData")
	public Object[][] getData()
	{
		return new Object[][] {{"abc","122"},{"bcd","152"},{"edr","8569"}};
	}
	
	/*
	@Test(dataProvider="BooksData")
	public void deleteBook(String isbn,String aisle)
	{
		RestAssured.baseURI="http://216.10.245.166";
		given().log().all().headers("Content-Type","application/json")
		.body(AddPayLoad.DeleteBook(id))
		.when().delete("Library/DeleteBook.php")
		.then().log().all().statusCode(200).body("msg",equalTo("book is successfully deleted"));
		
	}*/

}
