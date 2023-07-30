package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactFormPage extends BasePage{

    @FindBy(xpath="//a[@title='Iebildumu un komentāru forma']")
    public WebElement formButton;

    @FindBy(xpath="//input[@id='71a2bb97-3a3f-434b-e36d-344d0907e7b9']")
    public WebElement nameSurnameBox;

    @FindBy(css=".field-validation-error[data-valmsg-for='71a2bb97-3a3f-434b-e36d-344d0907e7b9']")
    public WebElement nameSurnameBoxErrorMessage;

    @FindBy(xpath="//input[@id='0348625f-721d-430f-f61b-3ea1a44df7b6']")
    public WebElement personalCodeBox;

    @FindBy(css=".field-validation-error[data-valmsg-for='0348625f-721d-430f-f61b-3ea1a44df7b6']")
    public WebElement personalCodeBoxErrorMessage;

    @FindBy(xpath="//input[@id='a6c1035f-7675-445b-ab1f-186d4481692f']")
    public WebElement caseNumberBox;

    @FindBy(xpath="//input[@id='ffc40b29-dfa8-42d8-d33a-1602ef5a4622']")
    public WebElement contactPhoneNumberBox;

    @FindBy(css=".field-validation-error[data-valmsg-for='ffc40b29-dfa8-42d8-d33a-1602ef5a4622']")
    public WebElement contactPhoneNumberBoxErrorMessage;

    @FindBy(xpath="//input[@id='c9247843-f302-4fa6-a1b4-2a75b06a95ee']")
    public WebElement emailAdressBox;

    @FindBy(css=".field-validation-error[data-valmsg-for='c9247843-f302-4fa6-a1b4-2a75b06a95ee']")
    public WebElement emailAdressBoxErrorMessage;

    @FindBy(xpath="//input[@id='6bbc463e-6ce2-4f52-de13-4777aef7dce7']")
    public WebElement adressBox;

    @FindBy(css=".field-validation-error[data-valmsg-for='6bbc463e-6ce2-4f52-de13-4777aef7dce7']")
    public WebElement adressBoxErrorMessage;

    @FindBy(xpath="//textarea[@id='bdd7ddc6-ca27-4f20-9fbe-f0264f3c2f3a']")
    public WebElement commentBox;

    @FindBy(css=".field-validation-error[data-valmsg-for='bdd7ddc6-ca27-4f20-9fbe-f0264f3c2f3a']")
    public WebElement commentBoxErrorMessage;

    @FindBy(xpath="//select[@id='e9a9505d-196d-4bac-8d8f-f8a3f406934d']")
    public WebElement answerOptionDropDown;

    @FindBy(css=".field-validation-error[data-valmsg-for='e9a9505d-196d-4bac-8d8f-f8a3f406934d']")
    public WebElement answerOptionDropDownErrorMessage;

    @FindBy(xpath="//input[@type='submit']")
    public WebElement submitBotton;

    @FindBy(xpath="//button[@title='Close']")
    public WebElement cancelBotton;

    @FindBy(xpath="//div[@class='preamble']//h1//font//font[contains(text(),'Form of objections and comments')]")
    public WebElement formAndObjectionsLabel;

    @FindBy(xpath="//button[@id='onetrust-accept-btn-handler']")
    public WebElement acceptCookiesButton;
}
