package pages.API;

import org.apache.log4j.Logger;
import org.junit.Assert;

import org.junit.BeforeClass;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public  class BaseTestApi {
	
	protected Response response; 
	Logger logger;
	
	public BaseTestApi(){
		logger = Logger.getLogger("BaseTestApi.class");
	}

	@BeforeClass
	public void setup(){
		System.out.println("in base test setup");
	}	
	
	public void setBaseUri(String uri) {
		RestAssured.baseURI = uri;
		logger.info("the base uri is set");
	}
	public void getURIPage(String uriParameter) {
		response=RestAssured.given().get("/"+uriParameter).andReturn();
		logger.info("Getting the response from page URI");
	}
	
	public void responseNotNull() {
		Assert.assertNotNull(response);
	}
	
	public void verifyResponeStatusCode(int statusCode) {
		Assert.assertEquals(response.getStatusCode(),statusCode);
	}
	
	public String getResponeBody() {
		return response.getBody().asString();
	}
	
	public void verifyResponseField(String field, String expectedValue) {
		JsonPath jsonPath = response.jsonPath();
		Assert.assertEquals(jsonPath.get(field),expectedValue);
	}
}
