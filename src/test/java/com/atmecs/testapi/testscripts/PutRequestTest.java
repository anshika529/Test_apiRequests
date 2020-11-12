package com.atmecs.testapi.testscripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.atmecs.testapi.dataprovider.UserDataProvider;
import com.sun.xml.xsom.impl.scd.Iterators.Map;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequestTest {
	@Test(dataProvider = "createuserdata", dataProviderClass = UserDataProvider.class)
	public void testUpdateUser(Object requestbody) throws MalformedURLException {
		System.out.println("Request body: " + requestbody);
		
		String requestUrl = "https://reqres.in/api/users/2";
		
		
		HashMap<String, Object> headers = new HashMap<String, Object>();
		headers.put("Content-Type", "application/json");
		
		RequestSpecification request = RestAssured.given().headers(headers);
		
		Response response = request.when().body(requestbody.toString()).
				put(new URL(requestUrl)).then().extract().response();
		
		int statusCode = response.getStatusCode();
		String responseBody = response.getBody().asString();
		
		System.out.println("Status Code: " + statusCode );
		System.out.println("responseBody: " + responseBody );
		
		Assert.assertEquals(statusCode, 200);
		
		JsonPath jsonPath = response.jsonPath();
		
		String name = jsonPath.getString("name");
		System.out.println("Name : " + name);
		
		
		JSONObject jsonObject = (JSONObject) requestbody;
		Assert.assertEquals(name, jsonObject.get("name").toString());
		
		
		String updatedAt = jsonPath.getString("updatedAt");
		System.out.println("updatedAt  : " + updatedAt);
	}
	
	
}
