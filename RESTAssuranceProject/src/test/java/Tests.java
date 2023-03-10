import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;

public class Tests {
	@Test
	void test_01_POST() {
		
		List<String> locale = new ArrayList<String>();
		locale.add("en");
		locale.add("de");
		
		JSONObject request = new JSONObject();
		
		request.put("name", "item1");
		request.put("locale", locale);
		request.put("is_verified", true);
		request.put("department_id", 3);
		
		baseURI = "http://localhost:3000/";

		given().
			body(request.toJSONString()).
		when().
			post("/items").
		then().
			statusCode(201).
			log().all();
	}
	
	@Test
	void test_02_PUT() {
		
		List<String> locale = new ArrayList<String>();
		locale.add("en");
		locale.add("de");
		
		JSONObject request = new JSONObject();
		
		request.put("name", "UpdatedName");
		request.put("locale", locale);
		request.put("is_verified", true);
		request.put("department_id", 3);
		
		baseURI = "http://localhost:3000/";
		given().
			body(request.toJSONString()).
		when().
			put("/items/1").
		then().
			statusCode(200).
			log().all();
	}

	@Test
	void test_03_GET() {
		
		baseURI = "http://localhost:3000/";
		
		given().
			get("/items/1").
		then().
			statusCode(200).
			log().all();
	}
}
