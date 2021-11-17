package demo;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import pojo.Api;
import pojo.GetCourses;
import pojo.Mobile;
import pojo.WebAutomation;

public class OAuthTest {

	public static void main(String[] args) throws InterruptedException {


		//Step 1: To get the Authorization Code.
		/*System.setProperty("webdriver.chrome.driver",
				"G:\\KrishnaEclipseWorkspace\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
		driver.findElement(By.id("identifierId")).sendKeys("prasath.ragavendran",Keys.ENTER);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("prasath12345",Keys.ENTER);
		Thread.sleep(5000);
		String url=driver.getCurrentUrl();*/

		String url="https://rahulshettyacademy.com/getCourse.php?code=4%2F3AEKOfr7WBMfBWaWvmMDT4sk1obCpW1g_8_jyfynRJbcNA9RL9JeqFGvZpr6rnJu5Nr1D-UgYfv0mZytGFw0C_c&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none#";
		String partialCode=url.split("code=")[1];
		String code=partialCode.split("&scope")[0];
		System.out.println("The Authorization Code is " + code);

		//Step 2: Get the Access Token using the Authorization from the Step 1

		String accessTokenResponse=given().urlEncodingEnabled(false)
				.queryParam("code", code)
				.queryParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
				.queryParam("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
				.queryParam("grant_type","authorization_code")
				.when().log().all()
				.post("https://www.googleapis.com/oauth2/v4/token").asString();
		JsonPath js=new JsonPath(accessTokenResponse);
		String accessToken=js.getString("access_token");
		System.out.println("The Access Token is " + accessToken);


		//Step 3: Get Access to RahulShetty courses api using the Access Token generated in the step 2.
		String response=given().queryParam("access_token", accessToken)
		.when().log().all()
		.get("https://rahulshettyacademy.com/getCourse.php").asString();
		System.out.println(response);

		GetCourses gc=given().queryParam("access_token", accessToken).expect().defaultParser(Parser.JSON)
				.when()
				.get("https://rahulshettyacademy.com/getCourse.php").as(GetCourses.class);
		System.out.println(gc.getLinkedIn());
		System.out.println(gc.getInstructor());
		//	System.out.println(gc.getCourses());

		// Print the course title "SoapUI Webservices testing" in api.
		System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());

		//Get me the price for "SoapUI Webservices testing" course title in api courses.
		List<Api> apiList=gc.getCourses().getApi();
		int apiListSize=apiList.size();
		for(int i=0;i<apiListSize;i++)
		{
			if(gc.getCourses().getApi().get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
			{
				System.out.println(gc.getCourses().getApi().get(i).getPrice());
			}
		}

		//Print all the Course Titles and its Prices in WebAutomation
		List<WebAutomation> webAutomationCourses=gc.getCourses().getWebAutomation();
		int webAutomationCoursesSize=webAutomationCourses.size();
		for(int i=0;i<webAutomationCoursesSize;i++)
		{
			System.out.println(gc.getCourses().getWebAutomation().get(i).getCourseTitle());
			System.out.println(gc.getCourses().getWebAutomation().get(i).getPrice());
		}


		//Get me the course title for which the price is equal to 0.
		try {
			List<Mobile> mobileCourses=gc.getCourses().getMobile();
			int mobileCoursesSize=webAutomationCourses.size();
			for(int i=0;i<mobileCoursesSize;i++)
			{
				if(gc.getCourses().getMobile().get(i).getPrice().equalsIgnoreCase("50"))
				{
					System.out.println(gc.getCourses().getMobile().get(i).getCourseTitle());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		//Comparing the WebAutomation course titles by adding it to the list.
		String[] courseTitles= {"Selenium Webdriver Java","Cypress","Protractor"};
		List<String> expectedList=Arrays.asList(courseTitles);
		ArrayList<String> actualList= new ArrayList<String>();
		List<WebAutomation> webAutomationCourses1=gc.getCourses().getWebAutomation();
		int webAutomationCoursesSize1=webAutomationCourses1.size();
		for(int i=0;i<webAutomationCoursesSize1;i++)
		{
			actualList.add(gc.getCourses().getWebAutomation().get(i).getCourseTitle());			
		}
		Assert.assertTrue(expectedList.equals(actualList));
		Assert.assertEquals(actualList, expectedList);

	}

}
