package parseJsonData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

//Reference - https://medium.com/@supriyaran/how-to-parse-nested-json-in-java-269ca24e260c
public class TestClass1 {
	
	String inputJson = "{\r\n"
			+ "  \"fid\": \"0001\",\r\n"
			+ "  \"ftype\": \"donut\",\r\n"
			+ "  \"fname\": \"Cake\",\r\n"
			+ "  \"fppu\": 0.55,\r\n"
			+ "  \"batters\": {\r\n"
			+ "    \"batter\": [\r\n"
			+ "      {\r\n"
			+ "        \"id\": \"1001\",\r\n"
			+ "        \"type\": \"Regular\"\r\n"
			+ "      },\r\n"
			+ "      {\r\n"
			+ "        \"id\": \"1002\",\r\n"
			+ "        \"type\": \"Chocolate\"\r\n"
			+ "      },\r\n"
			+ "      {\r\n"
			+ "        \"id\": \"1003\",\r\n"
			+ "        \"type\": \"Blueberry\"\r\n"
			+ "      },\r\n"
			+ "      {\r\n"
			+ "        \"id\": \"1004\",\r\n"
			+ "        \"type\": \"Devil's Food\"\r\n"
			+ "      }\r\n"
			+ "    ]\r\n"
			+ "  },\r\n"
			+ "  \"topping\": [\r\n"
			+ "    {\r\n"
			+ "      \"id\": \"5001\",\r\n"
			+ "      \"type\": \"None\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "      \"id\": \"5002\",\r\n"
			+ "      \"type\": \"Glazed\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "      \"id\": \"5005\",\r\n"
			+ "      \"type\": \"Sugar\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "      \"id\": \"5007\",\r\n"
			+ "      \"type\": \"Powdered Sugar\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "      \"id\": \"5006\",\r\n"
			+ "      \"type\": \"Chocolate with Sprinkles\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "      \"id\": \"5003\",\r\n"
			+ "      \"type\": \"Chocolate\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "      \"id\": \"5004\",\r\n"
			+ "      \"type\": \"Maple\"\r\n"
			+ "    }\r\n"
			+ "  ]\r\n"
			+ "}";
	
	
		public void parseObject(JSONObject json, String key) {
		//System.out.println("Key : "+key+" has value : "+json.get(key));
		
//		Map<Object, Object> map=new HashMap<Object, Object>();
//		map.put(key, json.get(key));
//		
//		Set<Object> keys=map.keySet();
//		for(Object o:keys) {
//			//System.out.println(map.get(o));
//			String str=String.valueOf(map.get(o));
//			System.out.println(str);
//		}
		
//		for(Map.Entry<Object, Object> entery:map.entrySet()) {
//			System.out.println(entery.getKey()+" "+entery.getValue());
//		}
		
//		List<Object> list=new ArrayList<Object>();
//		while(json.get(key)!=null) {
//			list.add(json.get(key));
//		}
//		
//		for(Object o:list) {
//			System.out.println(o);
//		}
		
		String str=json.get(key).toString();
		System.out.println(str);
		
		}
		
		public void getKey(JSONObject json, String key) {
			boolean exists = json.has(key);
			Iterator<?> keys;
			String nextKeys;
			if (!exists) {
				keys = json.keys();
				while (keys.hasNext()) {
					nextKeys = (String) keys.next();
					try {
						if (json.get(nextKeys) instanceof JSONObject) {
							if (exists == false) {
								getKey(json.getJSONObject(nextKeys), key);
							}
						} else if (json.get(nextKeys) instanceof JSONArray) {
							JSONArray jsonarray = json.getJSONArray(nextKeys);
							for (int i = 0; i < jsonarray.length(); i++) {
								String jsonarrayString = jsonarray.get(i).toString();
								JSONObject innerJSOn = new JSONObject(jsonarrayString);
								if (exists == false) {
									getKey(innerJSOn, key);
								}
							}
						}
					} catch (Exception e) {
					}
				}
			} else {
				parseObject(json, key);
			}
		}
	
	@Test
	public void f1() {
		System.out.println(inputJson);
		
		JSONObject inputJSONOBject = new JSONObject(inputJson);
		getKey(inputJSONOBject, "type");
		
   
	}

}
