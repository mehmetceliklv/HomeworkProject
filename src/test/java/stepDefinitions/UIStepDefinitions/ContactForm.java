package stepDefinitions.UIStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import pages.ContactFormPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utilities.ReusableMethods.getDropdownOptionsText;

public class ContactForm {
    ContactFormPage contactFormPage=new ContactFormPage();
    Faker faker=new Faker();
    JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
    @Given("User goes to contact form URL")
    public void user_goes_to_contact_form_url() {
        Driver.getDriver().get(ConfigReader.getProperty("contactFormUrl"));
        Driver.wait(3);
        contactFormPage.acceptCookiesButton.click();
    }
    @Given("User verifies the current URL")
    public void user_verifies_the_current_url() {
        Assert.assertEquals(ConfigReader.getProperty("contactFormUrl"),Driver.getDriver().getCurrentUrl());
    }
    @When("User verifies that form button is displayed and enabled")
    public void user_verifies_that_form_button_is_displayed_and_enabled() {
        ReusableMethods.verifyElementDisplayed(contactFormPage.formButton);
        ReusableMethods.verifyElementClickable(contactFormPage.formButton);
    }
    @Then("User clicks on the form button and verifies that form is displayed")
    public void user_clicks_on_the_form_button_and_verifies_that_form_is_displayed() {
        contactFormPage.formButton.click();
    }
    @Then("User verifies that name and surname box is displayed and enabled")
    public void user_verifies_that_name_and_surname_box_is_displayed_and_enabled() {
        ReusableMethods.verifyElementDisplayed(contactFormPage.nameSurnameBox);
        ReusableMethods.verifyElementClickable(contactFormPage.nameSurnameBox);
    }
    @Then("User verifies that personal code box is displayed and enabled")
    public void user_verifies_that_personal_code_box_is_displayed_and_enabled() {
        ReusableMethods.verifyElementDisplayed(contactFormPage.personalCodeBox);
        ReusableMethods.verifyElementClickable(contactFormPage.personalCodeBox);
    }
    @Then("User verifies that case number box is displayed and enabled")
    public void user_verifies_that_case_number_box_is_displayed_and_enabled() {
        ReusableMethods.verifyElementDisplayed(contactFormPage.caseNumberBox);
        ReusableMethods.verifyElementClickable(contactFormPage.caseNumberBox);
    }
    @Then("User verifies that contact phone number box is displayed and enabled")
    public void user_verifies_that_contact_phone_number_box_is_displayed_and_enabled() {
        ReusableMethods.verifyElementDisplayed(contactFormPage.contactPhoneNumberBox);
        ReusableMethods.verifyElementClickable(contactFormPage.contactPhoneNumberBox);
    }
    @Then("User verifies that email adress box is displayed and enabled")
    public void user_verifies_that_email_adress_box_is_displayed_and_enabled() {
        ReusableMethods.verifyElementDisplayed(contactFormPage.emailAdressBox);
        ReusableMethods.verifyElementClickable(contactFormPage.emailAdressBox);
    }
    @Then("User verifies that adress box is displayed and enabled")
    public void user_verifies_that_adress_box_is_displayed_and_enabled() {
        ReusableMethods.verifyElementDisplayed(contactFormPage.adressBox);
        ReusableMethods.verifyElementClickable(contactFormPage.adressBox);
    }
    @Then("User verifies that comment and objection box is displayed and enabled")
    public void user_verifies_that_comment_and_objection_box_is_displayed_and_enabled() {
        ReusableMethods.verifyElementDisplayed(contactFormPage.commentBox);
        ReusableMethods.verifyElementClickable(contactFormPage.commentBox);
    }
    @Then("User verifies that dropdown is displayed and enabled")
    public void user_verifies_that_dropdown_is_displayed_and_enabled() {
        ReusableMethods.verifyElementDisplayed(contactFormPage.answerOptionDropDown);
        ReusableMethods.verifyElementClickable(contactFormPage.answerOptionDropDown);
    }
    @Then("User verifies that dropdown has required options")
    public void user_verifies_that_dropdown_has_necessary_options() {
        List<String> actualOptions = getDropdownOptionsText(contactFormPage.answerOptionDropDown);
        List<String> expectedOptions = new ArrayList<>(Arrays.asList("","E-pasts", "Pasts"));
        Assert.assertEquals(expectedOptions, actualOptions);
    }
    @Then("User verifies that submit button is displayed and enabled")
    public void user_verifies_that_submit_button_is_displayed_and_enabled() {
        ReusableMethods.verifyElementDisplayed(contactFormPage.submitBotton);
        ReusableMethods.verifyElementClickable(contactFormPage.submitBotton);
    }
    @Then("User verifies that cancel button is displayed and enabled")
    public void user_verifies_that_cancel_button_is_displayed_and_enabled() {
        ReusableMethods.verifyElementDisplayed(contactFormPage.cancelBotton);
        ReusableMethods.verifyElementClickable(contactFormPage.cancelBotton);
    }

    @When("User clicks on the form button")
    public void user_clicks_on_the_form_button() {
        contactFormPage.formButton.click();
    }
    @Then("User fills all the required fields with valid data except case number")
    public void user_fills_all_the_required_fields_with_valid_data_except_case_number() {
        contactFormPage.nameSurnameBox.sendKeys(faker.name().fullName());
        contactFormPage.personalCodeBox.sendKeys(faker.idNumber().valid());
        contactFormPage.contactPhoneNumberBox.sendKeys(faker.phoneNumber().cellPhone());
        contactFormPage.emailAdressBox.sendKeys(faker.internet().emailAddress());
        contactFormPage.adressBox.sendKeys(faker.address().fullAddress());
        contactFormPage.commentBox.sendKeys(faker.lorem().characters());

        Driver.selectDropdownByVisibleText(Driver.getDriver(),contactFormPage.answerOptionDropDown,"Pasts");
    }
    @Then("User clicks the Submit button")
    public void user_clicks_the_submit_button() {
        Driver.wait(2);
        Driver.clickWithJS(contactFormPage.submitBotton);
    }
    @Then("the form is submitted successfully, and the user receives a confirmation message.")
    public void the_form_is_submitted_successfully_and_the_user_receives_a_confirmation_message() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("User fills all the required fields with valid data")
    public void user_fills_all_the_required_fields_with_valid_data() {
        contactFormPage.nameSurnameBox.sendKeys(faker.name().fullName());
        contactFormPage.personalCodeBox.sendKeys(faker.idNumber().valid());
        contactFormPage.contactPhoneNumberBox.sendKeys(faker.phoneNumber().cellPhone());
        contactFormPage.emailAdressBox.sendKeys(faker.internet().emailAddress());
        contactFormPage.adressBox.sendKeys(faker.address().fullAddress());
        contactFormPage.commentBox.sendKeys(faker.lorem().characters());
        Driver.selectDropdownByVisibleText(Driver.getDriver(),contactFormPage.answerOptionDropDown,"Pasts");
    }
    @Then("User fills the optional fields")
    public void user_fills_the_optional_fields() {
        contactFormPage.caseNumberBox.sendKeys(faker.number().digit());
    }

    @Then("User verifies that error messages are displayed for all required fields")
    public void user_verifies_that_error_messages_are_displayed_for_all_required_fields() {
        ReusableMethods.verifyElementDisplayed(contactFormPage.nameSurnameBoxErrorMessage);
        ReusableMethods.verifyElementDisplayed(contactFormPage.personalCodeBoxErrorMessage);
        ReusableMethods.verifyElementDisplayed(contactFormPage.contactPhoneNumberBoxErrorMessage);
        ReusableMethods.verifyElementDisplayed(contactFormPage.emailAdressBoxErrorMessage);
        ReusableMethods.verifyElementDisplayed(contactFormPage.adressBoxErrorMessage);
        ReusableMethods.verifyElementDisplayed(contactFormPage.commentBoxErrorMessage);
        ReusableMethods.verifyElementDisplayed(contactFormPage.answerOptionDropDownErrorMessage);
    }
    @Then("User enters invalid email address to email box")
    public void user_enters_invalid_email_address_to_email_box() {
        contactFormPage.emailAdressBox.sendKeys("%^%^%@mail.com"+ Keys.TAB);
    }
    @Then("User verifies that error message is correct and displayed for email box")
    public void user_verifies_that_error_message_is_correct_and_displayed_for_email_box() {
        ReusableMethods.verifyElementDisplayed(contactFormPage.emailAdressBoxErrorMessage);
        Assert.assertEquals("Lūdzu, aizpildiet lauku",contactFormPage.emailAdressBoxErrorMessage.getText());
    }
    @Then("User clicks the cancel button")
    public void user_clicks_the_cancel_button() {
        Driver.clickWithJS(contactFormPage.cancelBotton);
    }
    @Then("User verifies that form submission is cancelled")
    public void user_verifies_that_form_submission_is_cancelled() {
        ReusableMethods.verifyElementNotDisplayed(contactFormPage.formAndObjectionsLabel);

    }




}
