package testCase.stepDefinitions.API;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import pages.API.BaseTestApi;

public class BaseTest{

	BaseTestApi baseTestAPi;
	@Given("I hit the uri {string} with string {string}")
	public void i_hit_the_uri_with_string(String uri, String text) {
		baseTestAPi=new BaseTestApi();
		baseTestAPi.setBaseUri(uri);
		baseTestAPi.getURIPage(text);
	}

	@When("I get non empty response")
	public void i_get_non_empty_response() {
		baseTestAPi.responseNotNull();
	}

	@Then("I verify status code is {int}")
	public void i_verify_status_code_is(Integer int1) {
		baseTestAPi.verifyResponeStatusCode(int1);
	}

}