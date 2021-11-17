package resources;

public class Demo {
	/*this method of getting the resources values are not encouragable because we
	cannot create variable and method for each and every resources if the resources are
	in very large numbers. hence we use enum class to resolve this*/

	String addPlaceAPI="/maps/api/place/add/json";
	String getPlaceAPI="/maps/api/place/get/json";
	String deletePlaceAPI="/maps/api/place/delete/json";
	
	public String getaddPlaceAPI()
	{
		return addPlaceAPI;
	}
	public String getdeletePlaceAPI()
	{
		return deletePlaceAPI;
	}
	public String getgetPlaceAPI()
	{
		
		return getPlaceAPI;
	}
	
	
}
