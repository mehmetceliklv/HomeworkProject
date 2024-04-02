package stepDefinitions.ApiStepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.UserCreationPojo;
import pojos.UserResponsePojo;
import pojos.UserUpdateResponsePojo;
import utilities.CSVWriter;
import utilities.ConfigReader;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static stepDefinitions.Hooks.spec;

public class UsersStepDefinitions {

    static Response response;

    static String newUserId;

    static UserCreationPojo userCreationPojo=new UserCreationPojo();
    static UserResponsePojo userResponsePojo=new UserResponsePojo();
    static UserUpdateResponsePojo userUpdateResponsePojo=new UserUpdateResponsePojo();
    ObjectMapper obj=new ObjectMapper();
    static Faker faker= new Faker();
    static String firstName = faker.name().firstName();
    static String lastName = faker.name().lastName();
    static String username = (firstName + lastName).toLowerCase();
    static String email = username + "@mailinator.com";
    static String gender = faker.options().option("male", "female");

    @Given("User set path params for user creation")
    public void user_set_path_params_for_user_creation() {
        spec.pathParams("1","public","2","v2","3","users");
    }
    @Given("User enters expected data for user creation")
    public void user_enters_expected_data_for_user_creation() throws IOException {
        userCreationPojo.setName(firstName+" "+lastName);
        userCreationPojo.setEmail(email);
        userCreationPojo.setGender(gender);
        userCreationPojo.setStatus("active");

    }
    @Given("User send request and get response from user creation endpoint")
    public void user_send_request_and_get_response_from_user_creation_endpoint() {
        RestAssured.defaultParser = Parser.JSON;
        response =given().relaxedHTTPSValidation().spec(spec)
                .header("Authorization", "Bearer "+ ConfigReader.getProperty("token"))
                .contentType(ContentType.JSON)
                .body(userCreationPojo).when()
                .post("/{1}/{2}/{3}");
        response.prettyPrint();
    }
    @Then("User  verify API data from user creation endpoint")
    public void user_verify_api_data_from_user_creation_endpoint() throws IOException {
        String responseMessage = response.getBody().asString();
        System.out.println(responseMessage);
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(201, statusCode);


        UserResponsePojo actualResponse=obj.readValue(response.asString(),UserResponsePojo.class);
        newUserId=actualResponse.getId();
        System.out.println("newContactId"+newUserId);

        CSVWriter.writeUserToCSV(actualResponse,"users-list");
        Assert.assertEquals(userCreationPojo.getName(),actualResponse.getName());
        Assert.assertEquals(userCreationPojo.getEmail(),actualResponse.getEmail());
        Assert.assertEquals(userCreationPojo.getGender(),actualResponse.getGender());
        Assert.assertEquals(userCreationPojo.getStatus(),actualResponse.getStatus());
    }

    @Given("User has a valid API endpoint and id for viewing the newly created contact")
    public void user_has_a_valid_api_endpoint_and_id_for_viewing_the_newly_created_contact() {
        spec.pathParams("1","public","2","v2","3","users","4",newUserId);
    }
    @When("User send a GET request to user list endpoint for viewing a single user details")
    public void user_send_a_get_request_to_contact_list_endpoint_for_viewing_a_single_contact_details() {
        RestAssured.defaultParser = Parser.JSON;
        response =given().relaxedHTTPSValidation().spec(spec)
                .header("Authorization", "Bearer "+ ConfigReader.getProperty("token"))
                .contentType(ContentType.JSON)
                .body(userResponsePojo).when()
                .get("/{1}/{2}/{3}/{4}");
        userResponsePojo= response.getBody().as(UserResponsePojo.class);
        response.prettyPrint();
    }
    @Then("the response status code should be {int} OK")
    public void the_response_status_code_should_be_ok(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }
    @Then("the response should contain the details of the newly created contact")
    public void the_response_should_contain_the_details_of_the_newly_created_contact() {
        Assert.assertEquals(userCreationPojo.getName(),userResponsePojo.getName());
        Assert.assertEquals(userCreationPojo.getEmail(),userCreationPojo.getEmail());
        Assert.assertEquals(userCreationPojo.getGender(),userResponsePojo.getGender());
        Assert.assertEquals(userCreationPojo.getStatus(),userResponsePojo.getStatus());
    }

    @Given("User set path params for updating a single user")
    public void user_set_path_params_for_updating_a_single_user() {
        spec.pathParams("1","public","2","v2","3","users","4",newUserId);
    }
    @When("User enter expected data for user update")
    public void user_enter_expected_data_for_user_update() {
        userCreationPojo.setName("Michael Jackson");
        userCreationPojo.setEmail("michaeljackson14@mailinator.com");
        userCreationPojo.setGender("male");
        userCreationPojo.setStatus("inactive");
    }
    @When("User send a PUT request to update single user details")
    public void user_send_a_put_request_to_update_single_user_details() {
        RestAssured.defaultParser = Parser.JSON;
        response =given().relaxedHTTPSValidation().spec(spec)
                .header("Authorization", "Bearer "+ ConfigReader.getProperty("token"))
                .contentType(ContentType.JSON)
                .body(userCreationPojo).when()
                .put("/{1}/{2}/{3}/{4}");

        response.prettyPrint();
    }
    @Then("the response should contain the details of the updated user")
    public void the_response_should_contain_the_details_of_the_updated_user() throws JsonProcessingException {

        UserUpdateResponsePojo actualResponse=obj.readValue(response.asString(),UserUpdateResponsePojo.class);
        Assert.assertEquals("Michael Jackson",actualResponse.getName());
        Assert.assertEquals("michaeljackson14@mailinator.com",actualResponse.getEmail());
        Assert.assertEquals("male",actualResponse.getGender());
        Assert.assertEquals("inactive",actualResponse.getStatus());
    }
    @Given("User set path params for deleting a single user")
    public void user_set_path_params_for_deleting_a_single_user() {
        spec.pathParams("1","public","2","v2","3","users","4",newUserId);
    }
    @Given("User send a DELETE request for deleting a single user")
    public void user_send_a_delete_request_for_deleting_a_single_user() {
        RestAssured.defaultParser = Parser.JSON;
        response =given().relaxedHTTPSValidation().spec(spec)
                .header("Authorization", "Bearer "+ ConfigReader.getProperty("token"))
                .contentType(ContentType.JSON)
                .when()
                .delete("/{1}/{2}/{3}/{4}");
        response.prettyPrint();
    }

}
