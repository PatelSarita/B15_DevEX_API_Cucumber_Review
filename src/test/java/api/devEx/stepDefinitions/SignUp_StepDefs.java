package api.devEx.stepDefinitions;

import api.devEx.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static api.devEx.requests.DevExRequests.*;
import static org.junit.Assert.*;

public class SignUp_StepDefs {

    @When("The user sends a POST request with {string} and {string} and {string} and {string} and {string} and {string}")
    public void theUserSendsAPOSTRequestWithAndAndAndAndAnd(String email, String password, String name, String google, String facebook, String github) {
        registerNewUser(email, password, name, google, facebook, github);
        response.prettyPrint();

    }

    @And("The user verifies that response body contains {string}")
    public void theUserVerifiesThatResponseBodyContains(String token) {

        assertTrue(response.body().asString().contains(token));

    }

    @And("The compiler gets the token")
    public void theCompilerGetsTheToken() {
        token=response.path("token");
        ConfigurationReader.set("newUserToken",token);
    }

    @When("The user sends a POST request with {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string}")
    public void theUserSendsAPOSTRequestWithAndAndAndAndAndAndAndAndAndAnd(String company, String website, String location,
                                                                           String status, String skills, String githubusername, String youtube, String twitter,
                                                                           String facebook, String linkedin, String instagram){
        postSaveProfile(company, website, location, status, skills, githubusername, youtube, twitter, facebook, linkedin, instagram);
    }

    @And("The user verifies that name is {string} and email is {string}")
    public void theUserVerifiesThatNameIsAndEmailIs(String expectedName, String expectedEmail) {
        assertEquals(expectedName,response.path("user.name"));
        assertEquals(expectedEmail,response.path("user.email"));
    }
}
