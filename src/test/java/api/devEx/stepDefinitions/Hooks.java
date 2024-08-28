package api.devEx.stepDefinitions;

import api.devEx.utilities.ConfigurationReader;
import api.devEx.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static io.restassured.RestAssured.*;


public class Hooks {
    @Before
    public void setUp(){
        baseURI = ConfigurationReader.get("baseURL");
    }

    @After
    public void tearDown(){
        reset();
       // Driver.closeDriver();
    }
}
