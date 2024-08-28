package api.devEx.requests;

import api.devEx.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static api.devEx.common.DataForApi.*;
import static io.restassured.RestAssured.given;

public class DevExRequests {
    public static Response response;
    public static String token;
    public static int id;

    public static Response getAllProfiles() {
        response = given().accept(ContentType.JSON)
                .when()
                .get(ConfigurationReader.get("retrieve_all_profiles"));
        response.prettyPrint();
        return response;
    }

    public static Response getOneUserWithPathParam(int id) {
        response = given().accept(ContentType.JSON)
                .pathParam("userID", id)
                .when()
                .get(ConfigurationReader.get("get_user_profile_by_id"));
        response.prettyPrint();
        return response;
    }

    public static Response registerNewUser(String email, String password,
                                           String name, String google, String facebook, String github) {
        response = given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(registerUserBody(email, password, name, google, facebook, github))
                .when()
                .post(ConfigurationReader.get("register_user"));
        token = response.path("token");
        return response;
    }

    public static Response postSaveProfile(String company, String website, String location,
                                           String status, String skills, String githubusername, String youtube, String twitter,
                                           String facebook, String linkedin, String instagram){
        response = given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .header("x-auth-token", ConfigurationReader.get("newUserToken"))
                .and()
                .body(saveProfileBody(company, website, location, status, skills, githubusername, youtube, twitter, facebook, linkedin, instagram))
                .when()
                .post(ConfigurationReader.get("post_save_profile"));
        response.prettyPrint();
        return response;
    }

    public static Response postExperience(String title, String company, String location,
                                          String from, String to, String current, String description){
        response=given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .header("x-auth-token",ConfigurationReader.get("postLoginToken"))
                .and()
                .body(postExperienceBody(title, company, location, from, to, current, description))
                .when()
                .post(ConfigurationReader.get("post_experience"));
        response.prettyPrint();
        id = response.path("experience.id[0]");
        return response;

    }

    public static Response getExperience(){
        response = given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .header("x-auth-token",ConfigurationReader.get("postLoginToken"))
                .and()
                .pathParam("experienceID",id)
                .when()
                .get(ConfigurationReader.get("get_experience_by_id"));
        response.prettyPrint();
        return response;
    }


}