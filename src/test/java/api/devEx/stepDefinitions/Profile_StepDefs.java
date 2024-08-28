package api.devEx.stepDefinitions;


import api.devEx.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static api.devEx.requests.DevExRequests.*;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;


public class Profile_StepDefs {
   // Response response;
    /**we did a static import from DevExRequests class to have Response object and
      without using classname
     */

    @When("The user sends a GET request and able to see all profiles")
    public void theUserSendsAGETRequestAndAbleToSeeAllProfiles() {
        response = given().accept(ContentType.JSON)
                .when()
                .get(ConfigurationReader.get("retrieve_all_profiles"));
        response.prettyPrint();
    }

    @Then("The user verifies that the status code is {int}")
    public void theUserVerifiesThatTheStatusCodeIs(int expectedStatusCode) {
        assertEquals(expectedStatusCode,response.statusCode());
    }

    @When("The user sends a GET request and able to see all profiles second way")
    public void theUserSendsAGETRequestAndAbleToSeeAllProfilesSecondWay() {
       // response = DevExRequests.getAllProfiles();
        getAllProfiles();
    }

    @When("The user sends a GET request with {int}")
    public void theUserSendsAGETRequestWithId(int id) {
        getOneUserWithPathParam(id);
    }

    @And("The user verifies that user's info name is {string} and company is {string} and location is {string} and email is {string}")
    public void theUserVerifiesThatUserSInfoNameIsAndCompanyIsAndLocationIsAndEmailIs(String expectedName,
                                                                                      String expectedCompany, String expectedLocation, String expectedEmail) {
        System.out.println("response.path(\"user.name\") = " + response.path("user.name"));
        System.out.println("response.path(\"company\") = " + response.path("company"));
        System.out.println("response.path(\"location\") = " + response.path("location"));
        System.out.println("response.path(\"user.email\") = " + response.path("user.email"));

        assertEquals(expectedName,response.path("user.name"));
        assertEquals(expectedCompany,response.path("company"));
        assertEquals(expectedLocation,response.path("location"));
        assertEquals(expectedEmail,response.path("user.email"));
    }


}