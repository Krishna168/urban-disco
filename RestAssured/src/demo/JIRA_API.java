package demo;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import payload.AddPayLoad;
import payload.ReusableMethods;

public class JIRA_API {

	public static void main (String[] args)
	{
		RestAssured.baseURI="http://localhost:8080/";

		//login jira with credentials.

		SessionFilter session = new SessionFilter();
		String responseString=given().log().all().header("Content-Type", "application/json")
				.body("{ \"username\": \"krishnahari095\", \"password\": \"Krishna12345*\" }")
				.filter(session).when().post("rest/auth/1/session").then().log().all().extract().response().asString();

		//Creating issue

		String response=given().log().all().header("Content-Type", "application/json")
				.body(AddPayLoad.CreateDefect("get defect","details about api defect1")).filter(session)
				.when().post("rest/api/2/issue")
				.then().log().all().statusCode(201).extract().response().asString();
		JsonPath js2=ReusableMethods.rawToJson(response);
		String DefectID=js2.getString("id");
		System.out.println("Defect ID is : " + DefectID);


		//Adding a comment to the created issue.
		String expectedMessage="Hello... Gud Morning!!!!";
		String addCommentResponse=given().pathParams("id",DefectID).log().all()
				.header("Content-Type","application/json")
				.body(AddPayLoad.CreateComment(expectedMessage))
				.filter(session)
				.when().post("/rest/api/2/issue/{id}/comment")
				.then().log().all().assertThat().statusCode(201).extract().response().asString();
		JsonPath js1=ReusableMethods.rawToJson(addCommentResponse);
		String commentID=js1.getString("id");

		//Adding an attachment to the existing issue.

		given().log().all().header("X-Atlassian-Token", "no-check").filter(session)
		.pathParam("id", DefectID).header("Content-Type","multipart/form-data")
		.multiPart("file", new File("G:\\new defect.docx"))
		.when().post("rest/api/2/issue/{id}/attachments")
		.then().log().all().assertThat().statusCode(200);

		//Getting the issue details.

		String issueDetails=given().log().all().filter(session).pathParam("id", DefectID)
				.queryParam("fields", "comment")
				.when().get("/rest/api/2/issue/{id}")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		JsonPath js=ReusableMethods.rawToJson(issueDetails);	
		int commentsSize=js.get("fields.comment.comments.size()");
		System.out.println(commentsSize);
		for(int i=0;i<commentsSize;i++)
		{
			String commentidIssue=js.get("fields.comment.comments["+i+"].id").toString();
			if(commentidIssue.equalsIgnoreCase(commentID))
			{
				String message=js.get("fields.comment.comments["+i+"].body").toString();
				System.out.println(message);
				Assert.assertEquals(message, expectedMessage);
			}
		}


//Note: log().all() or sysout the response ...both are same and  both will be used for printing response in console.
		



	}

}
