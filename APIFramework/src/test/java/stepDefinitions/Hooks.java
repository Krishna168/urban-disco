package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlaceAPI")
	public void beforeScenario() throws IOException
	{

		StepDefinition sd= new StepDefinition();
		if(StepDefinition.place_id==null)
		{
			sd.the_AddPlace_Payload_with("Krishna", "Eng", "vadapalani");
			sd.user_calls_the_with_the_http_method("AddPlaceAPI", "POST");
			sd.verify_place_Id_created_maps_to_using("Krishna", "getPlaceAPI");
		}
	}
}
