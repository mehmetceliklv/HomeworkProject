
@ApiUserCreationEndToEnd  @Api @All
Feature: Api User Creation by Admin  End-to-End


  Scenario:Verify API POST Request for creation of user with all mandatory fields filled

    Given User set path params for user creation
    Given User enters expected data for user creation
    And   User send request and get response from user creation endpoint
    Then  User  verify API data from user creation endpoint


  Scenario: Verify API GET Request to retrieve newly created user details

    Given User has a valid API endpoint and id for viewing the newly created contact
    When  User send a GET request to user list endpoint for viewing a single user details
    Then  the response status code should be 200 OK
    And   the response should contain the details of the newly created contact


  Scenario: Verify API PUT Request to update single user details

    Given User set path params for updating a single user
    When  User enter expected data for user update
    And   User send a PUT request to update single user details
    Then  the response status code should be 200 OK
    And   the response should contain the details of the updated user

  Scenario: Verify API DELETE Request to delete a single user

    Given User set path params for deleting a single user
    And   User send a DELETE request for deleting a single user
    Then  the response status code should be 204 OK
