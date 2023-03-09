import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;

public class Test01_GET {
	@Test
	void test_01() {
		List<String> locale = new ArrayList<String>();
		locale.add("en");
		locale.add("de");
		JSONObject request = new JSONObject();
		request.put("name", "item1");
		request.put("locale", locale);
		request.put("is_verified", true);
		request.put("department_id", 3);
		System.out.println(request);
		System.out.println(request.toJSONString());
		given().
			body(request.toJSONString()).
		when().
			//post("https://variousitems.org/api/items").
			post("https://reqres.in/api/users").
		then().
			statusCode(201).
			log().all();
	}
	
}
