import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyWithMultipleValue {

	public static void main(String[] args) {
		ArrayList<String> dataTypes=new ArrayList<String>();
		dataTypes.add("char");
		dataTypes.add("int");
		dataTypes.add("boolean");
		System.out.println(dataTypes);
		ArrayList<String> accessSpecifiers=new ArrayList<String>();
		accessSpecifiers.add("public");
		accessSpecifiers.add("private");
		accessSpecifiers.add("protected");
		System.out.println(accessSpecifiers);
		HashMap<String,List<String>> map=new HashMap<String,List<String>>();
		map.put("dataTypes", dataTypes);
		map.put("accessSpecifiers", accessSpecifiers);
		System.out.println(map);
		System.out.println("Keys are " + map.keySet());
		System.out.println("Values are " + map.values());
		for(Map.Entry<String, List<String>> entry: map.entrySet())
		{
			String key=entry.getKey();
			List<String> value = entry.getValue();
			System.out.println("key is " + key + " and the value is " + value);
		}
		
	}

}
