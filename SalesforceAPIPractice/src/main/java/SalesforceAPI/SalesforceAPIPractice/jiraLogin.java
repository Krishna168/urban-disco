package SalesforceAPI.SalesforceAPIPractice;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class jiraLogin {

	public static void main(String[] args) {
		
		RestAssured.baseURI="https://krishnajira16895.atlassian.net/rest/api/3/issue/AT-4/transitions";
		given().log().all().auth().basic("krishnahari095@gmail.com", "5HNzSu5viZxArgEvxcGfDCD9")
		.queryParam("expand", "transitions.fields")
		.header("Accept","application/json")
		.when().get().then().log().all().assertThat().statusCode(200);
		
	}
}
