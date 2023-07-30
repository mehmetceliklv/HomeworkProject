@All @UI @UIContactForm
Feature: Contact Form

  Scenario: Verify Contact Form Details

    Given User goes to contact form URL
    And   User verifies the current URL
    When  User verifies that form button is displayed and enabled
    Then  User clicks on the form button and verifies that form is displayed
    Then  User verifies that name and surname box is displayed and enabled
    Then  User verifies that personal code box is displayed and enabled
    Then  User verifies that case number box is displayed and enabled
    Then  User verifies that contact phone number box is displayed and enabled
    Then  User verifies that email adress box is displayed and enabled
    Then  User verifies that adress box is displayed and enabled
    Then  User verifies that comment and objection box is displayed and enabled
    Then  User verifies that dropdown is displayed and enabled
    Then  User verifies that dropdown has required options
    Then  User verifies that submit button is displayed and enabled
    Then  User verifies that cancel button is displayed and enabled

  Scenario: Verify successful form submission when optional fields are omitted

    Given User goes to contact form URL
    When  User clicks on the form button
    Then  User fills all the required fields with valid data except case number
    Then  User clicks the Submit button
    And   the form is submitted successfully, and the user receives a confirmation message.

  Scenario: Verify successful form submission when optional fields are filled

    Given User goes to contact form URL
    When  User clicks on the form button
    Then  User fills all the required fields with valid data
    And   User fills the optional fields
    Then  User clicks the Submit button
    And   the form is submitted successfully, and the user receives a confirmation message.

  Scenario: Verify all validation error messages under necessary fields when necessary fields are empty

    Given User goes to contact form URL
    When  User clicks on the form button
    Then  User clicks the Submit button
    And   User verifies that error messages are displayed for all required fields

  Scenario: Verify validation error message when invalid email address entered

    Given User goes to contact form URL
    When  User clicks on the form button
    Then  User enters invalid email address to email box
    And   User verifies that error message is correct and displayed for email box

  Scenario: Verify cancellation of form submission

    Given User goes to contact form URL
    When  User clicks on the form button
    Then  User clicks the cancel button
    And   User verifies that form submission is cancelled

