package api.devEx.stepDefinitions;


import api.devEx.pages.LoginPage;
import api.devEx.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static api.devEx.requests.DevExRequests.*;
import static api.devEx.utilities.API_utils.getAccessToken;
import static org.junit.Assert.assertEquals;

public class Experience_StepDefs {


    @Given("The user sends a POST request and login with {string} and {string}")
    public void theUserSendsAPOSTRequestAndLoginWithAnd(String email, String password) {
        ConfigurationReader.set("postLoginToken",getAccessToken(email, password));
    }

    @When("The user sends a POST request for adding an experience with {string} {string} {string} {string} {string} {string} {string}")
    public void theUserSendsAPOSTRequestForAddingAnExperienceWith(String title, String company, String location, String from, String to, String current, String description) {
        postExperience(title, company, location, from, to, current, description);
    }

    @When("The user sends a GET request to get experience by ID")
    public void theUserSendsAGETRequestToGetExperienceByID() {
        getExperience();
    }

    @And("The user is on the Dashboard page")
    public void theUserIsOnTheDashboardPage() throws InterruptedException {
        //lazy way
        new LoginPage().setUpUI();
    }

    @Then("The user verifies that UI experience and API experience for the {string} should match")
    public void theUserVerifiesThatUIExperienceAndAPIExperienceForTheShouldMatch(String company) {
        String actualCompanyFrom_API= response.path("company");
        String actualCompanyFrom_UI = new LoginPage().getCompany(company);
        assertEquals(actualCompanyFrom_API,actualCompanyFrom_UI);
    }
}