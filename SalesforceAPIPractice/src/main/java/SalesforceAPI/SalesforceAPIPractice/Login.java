package SalesforceAPI.SalesforceAPIPractice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class Login {

	public static void main(String[] args) {
/*
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("username", "krishnaprasath@learnsalesforce.com");
		map.put("password", "Winter$2024eF3PRgCgTa6WEG4HWuWPgLjGH");
		map.put("grant_type", "password");
		map.put("client_id", "3MVG9n_HvETGhr3CXjK4bC0TmpptqZUTrDYGr0Voe7nS87Oi2CvsU5.G2fKeYmyVMvPvrGzlFyjdbW.IDxJa0");
		map.put("client_secret", "32246C29AFC2B40F0510761830A145B8EA7A773BB9083A454932DFC099F08928");

		RestAssured.baseURI="https://login.salesforce.com/services/oauth2/token";
		given().log().all().body("{\r\n"
				+ "   \"username\":\"krishnaprasath@learnsalesforce.com\",\r\n"
				+ "   \"password\":\"Winter$2024eF3PRgCgTa6WEG4HWuWPgLjGH\",\r\n"
				+ "   \"grant_type\":\"client_credentials\",\r\n"
				+ "   \"client_id\":\"3MVG9n_HvETGhr3CXjK4bC0TmpptqZUTrDYGr0Voe7nS87Oi2CvsU5.G2fKeYmyVMvPvrGzlFyjdbW.IDxJa0\",\r\n"
				+ "   \"client_secret\":\"32246C29AFC2B40F0510761830A145B8EA7A773BB9083A454932DFC099F08928\",\r\n"
			+ "}").header("Content-Type","application/json").when().post().then().log().all().assertThat().statusCode(200);
	*/
		
		System.out.println("*********************Getting Access Token************************");
		RestAssured.baseURI="https://login.salesforce.com/services/oauth2/token";
		String response = given().log().all().contentType("multipart/form-data")
		.multiPart("username", "krishnaprasath@learnsalesforce.com")
		.multiPart("password", "Winter$2024eF3PRgCgTa6WEG4HWuWPgLjGH")
		.multiPart("grant_type", "password")
		.multiPart("client_id", "3MVG9n_HvETGhr3CXjK4bC0TmpptqZUTrDYGr0Voe7nS87Oi2CvsU5.G2fKeYmyVMvPvrGzlFyjdbW.IDxJa0")
		.multiPart("client_secret", "32246C29AFC2B40F0510761830A145B8EA7A773BB9083A454932DFC099F08928")
		.when().post().then().log().all().assertThat().statusCode(200).extract().response().asString();
		JsonPath js = new JsonPath(response);
		String accessToken = js.getString("access_token");
		System.out.println("The Access Token is " + accessToken);
		
		
		//Create a new Account
		System.out.println("***********************Creating New Account**************************");
		RestAssured.baseURI="https://d2w00000fc0ipeat-dev-ed.my.salesforce.com/services/data/v42.0/sobjects/Account/";
		String response1 = given().log().all().header("Content-Type","application/json").header("Authorization","Bearer "+accessToken)
		.body("{\r\n"
				+ "  \"Name\" : \"Test API Account 4\"\r\n"
				+ "}")
		.when().post().then().log().all().assertThat().statusCode(201).body("success", equalTo(true)).extract().response().asString();
		JsonPath js1 = new JsonPath(response1);
		String accountId = js1.get("id");
		System.out.println("The AccountID is "+accountId);
		
		
		//Update a new Account
		System.out.println("***********************Updating Account**************************");
		RestAssured.baseURI="https://d2w00000fc0ipeat-dev-ed.my.salesforce.com/services/data/v42.0/sobjects/Account/"+accountId;
		given().log().all().header("Authorization","Bearer "+accessToken).header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"AnnualRevenue\" : \"25000\"\r\n"
				+ "}")
		.when().patch().then().assertThat().statusCode(204);
		
		
		//Deleting the Account
		System.out.println("***********************Deleting Account**************************");
		RestAssured.baseURI="https://d2w00000fc0ipeat-dev-ed.my.salesforce.com/services/data/v42.0/sobjects/Account/"+accountId;
	    given().header("Authorization","Bearer "+accessToken).when().delete().then().assertThat().statusCode(204);
	    System.out.println("The AccountId " + accountId + "is deleted");
	}

}
