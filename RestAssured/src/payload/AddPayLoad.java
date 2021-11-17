package payload;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class AddPayLoad {

	public static String AddPlace() {

		return "{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Krishna12\",\r\n" + 
				"  \"phone_number\": \"(+91) 801 555 1962\",\r\n" + 
				"  \"address\": \"10, Pillayar Koil Street, Vadapalani\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"house\",\r\n" + 
				"    \"home\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://google.com\",\r\n" + 
				"  \"language\": \"English-EN\"\r\n" + 
				"}";
	}
	public static String coursePrice()
	{
		return "{\r\n" + 
				"  \"dashboard\": {\r\n" + 
				"    \"purchaseAmount\": 1390,\r\n" + 
				"    \"website\": \"rahulshettyacademy.com\"\r\n" + 
				"  },\r\n" + 
				"  \"courses\": [\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"Selenium Python\",\r\n" + 
				"      \"price\": 50,\r\n" + 
				"      \"copies\": 6\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"Cypress\",\r\n" + 
				"      \"price\": 40,\r\n" + 
				"      \"copies\": 4\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"RPA\",\r\n" + 
				"      \"price\": 45,\r\n" + 
				"      \"copies\": 10\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"Appium\",\r\n" + 
				"      \"price\": 60,\r\n" + 
				"      \"copies\": 8\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}";
	}
	public static String AddBook(String isbn, String aisle)
	{
		String addbook = "{\r\n" + 
				"\r\n" + 
				"\"name\":\"Learn HARI API\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\"KPkhfjkld\"\r\n" + 
				"}\r\n" + 
				"";
		return addbook;
	}
	public static String DeleteBook(String id)
	{
		String deletebook = "{\r\n" + 
				" \r\n" + 
				"\"ID\" : \""+id+"\"\r\n" + 
				" \r\n" + 
				"} \r\n" + 
				"";
		return deletebook;
	}

	public static String CreateDefect(String Summary, String Description)
	{
		String createDefect = "{\r\n" + 
				"    \"fields\": {\r\n" + 
				"        \"project\": \r\n" + 
				"        {\r\n" + 
				"            \"key\": \"RJ\"\r\n" + 
				"        },\r\n" + 
				"        \"summary\": \""+Summary+"\",\r\n" + 
				"        \"description\": \""+Description+"\",\r\n" + 
				"        \"issuetype\": {\r\n" + 
				"            \"name\": \"Bug\"\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"}";
		return createDefect;
	}

	public static String CreateComment(String body)
	{
		String createComment = "{\r\n" + 
				"    \"body\": \""+body+"\",\r\n" + 
				"    \"visibility\": {\r\n" + 
				"        \"type\": \"role\",\r\n" + 
				"        \"value\": \"Administrators\"\r\n" + 
				"    }\r\n" + 
				"}";
		return createComment;
	}
	
	public static pojo.AddPlace SerializablePayLoad()
	{
		AddPlace ap=new AddPlace();
		ap.setAccuracy(50);
		ap.setAddress("29, side layout, cohen 09");
		ap.setLanguage("French-IN");
		ap.setName("Frontline house");
		ap.setPhone_number("Frontline house");
		ap.setWebsite("http://google.com");
		
		List<String> al=new ArrayList<String>();//List or ArrayList on LHS return type is both are same..
		al.add("shoe park");
		al.add("shop");
		ap.setTypes(al);
		
		Location l=new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		ap.setLocation(l);
		
		return ap;
	}



}
