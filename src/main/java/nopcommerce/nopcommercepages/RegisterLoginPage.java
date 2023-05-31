package nopcommerce.nopcommercepages;

import base.CommonAPI;
import nopcommerce.nopcommerceenums.sql.SQLInjection;
import nopcommerce.nopcommercereusablemethods.Reusable;
import nopcommerce.nopcommerceobjects.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class RegisterLoginPage extends CommonAPI {

    @FindBy(css = "#gender-male")
    public WebElement genderRadioButton;

    @FindBy(css = "#FirstName")
    public WebElement firstNameField;

    @FindBy(css = "#LastName")
    public WebElement lastNameField;

    @FindBy(css = "select[name='DateOfBirthDay']")
    public WebElement selectDateOfBirthDay;

    @FindBy(css = "select[name='DateOfBirthMonth']")
    public WebElement selectDateOfBirthMonth;

    @FindBy(css = "select[name='DateOfBirthYear']")
    public WebElement selectDateOfBirthYear;

    @FindBy(css = "#Email")
    public WebElement emailField;

    @FindBy(css = "#Company")
    public WebElement companyNameField;

    @FindBy(css = "#Password")
    public WebElement passwordField;

    @FindBy(css = "#ConfirmPassword")
    public WebElement confirmPasswordField;

    @FindBy(css = "#register-button")
    public  WebElement registerButton;

    @FindBy(css = ".button-1.register-continue-button")
    public WebElement continueRegisterButton;

    @FindBy(css = "#Email")
    public WebElement inputEmailField;

    @FindBy(css = "#Password")
    public WebElement inputPasswordField;

    @FindBy(css = "#RememberMe")
    public WebElement rememberMeButton;

    @FindBy(xpath = "//button[normalize-space()='Log in']")
    public WebElement loginButton;

    @FindBy(css = ".button-1.checkout-as-guest-button")
    public WebElement checkOutAsGuestBttn;

    @FindBy(css = "#save-info-button")
    public WebElement saveInfoButton;

    @FindBy(css = ".content")
    public WebElement customerInfoUpdatedText;

    @FindBy(css = "#FirstName-error")
    public WebElement nameIsRequired;

    @FindBy(css = "#Password-error")
    public WebElement passwordIsRequired;

    @FindBy(css = "#ConfirmPassword-error")
    public WebElement confirmPasswordError;

    @FindBy(css = "a[href='/passwordrecovery']")
    public WebElement passwordRecoveryLink;

    @FindBy(css = "button[name='send-email']")
    public WebElement recoverPasswordButton;

    @FindBy(css = ".content")
    public WebElement emailInstructionsHasBeenSent;

    @FindBy(xpath = "//*[text()='1']")
    public WebElement mustHaveSixChar;

    @FindBy(css = "#Email-error")
    public WebElement emailErrorText;

    @FindBy(css = "h1[data-translate='block_headline']")
    public WebElement sorryYouHaveBeenBlocked;

    @FindBy(css = ".message-error.validation-summary-errors")
    public WebElement noCustomerFoundMessage;

    Logger LOG = LogManager.getLogger(RegisterLoginPage.class.getName());

    public String usableEmail = new Customer().getEmail();

    public RegisterLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean noCustomerFoundIsDisplayed() {
        LOG.info("No customer found is displayed");
        return checkDisplayed(noCustomerFoundMessage);
    }

    public boolean emailErrorIsDisplayed() {
        LOG.info("Email error is displayed");
        return checkDisplayed(emailErrorText);
    }

    public boolean blockHeaderIsDisplayed() {
        LOG.info("Block page is displayed");
        return checkDisplayed(sorryYouHaveBeenBlocked);
    }

    public boolean verifyCustomerInfoTextIsDisplayed() {
        LOG.info("Customer info updated text is displayed");
        return checkDisplayed(customerInfoUpdatedText);
    }

    public boolean nameIsRequiredText() {
        LOG.info("Name is required text is displayed");
        return checkDisplayed(nameIsRequired);
    }

    public boolean emailIsRequiredText() {
        LOG.info("Email is required text is displayed");
        return checkDisplayed(emailErrorText);
    }

    public boolean passwordIsRequiredText() {
        LOG.info("Password is required text is displayed");
        return checkDisplayed(passwordIsRequired);
    }

    public boolean confirmPasswordNotSameText() {
        LOG.info("Confirm password error text is displayed");
        return checkDisplayed(confirmPasswordError);
    }

    public boolean emailHasBeenSentText() {
        LOG.info("Email instructions text is displayed");
        return checkDisplayed(emailInstructionsHasBeenSent);
    }

    public boolean passwordMustHaveSixCharText() {
        LOG.info("Password must have six characters is required text is displayed");
        return checkDisplayed(mustHaveSixChar);
    }

    public void forgotPasswordProcess() {
        new NopCommerceHomePage(getDriver()).clickOnRegisterButton();
        LOG.info("Clicked on Register button");
        clickGenderButton();
        LOG.info("Selected gender button");
        new Reusable().firstNameLastName(firstNameField, lastNameField);
        LOG.info("Entered first and last name");
        new Reusable().birthDateFields(selectDateOfBirthDay, selectDateOfBirthMonth, selectDateOfBirthYear);
        LOG.info("Entered birth date");
        new Reusable().emailPasswordFields(usableEmail, emailField, passwordField, confirmPasswordField);
        LOG.info("Entered email and password fields");
        clickToRegister();
        LOG.info("Clicked on Register button");
        new NopCommerceHomePage(getDriver()).clickOnLoginButton();
        LOG.info("Clicked on Login button");
        click(passwordRecoveryLink);
        LOG.info("Clicked on password recovery link");
        type(emailField, usableEmail);
        LOG.info("Entered email");
        click(recoverPasswordButton);
        LOG.info("Clicked on recover password button");
    }

    public void checkOutAsGuest() {
        click(checkOutAsGuestBttn);
        LOG.info("Clicked on Checkout as Guest button");
    }

    public void clickToRegister() {
        click(registerButton);
        LOG.info("Clicked on Register button");
    }

    public void clickGenderButton() {
        click(genderRadioButton);
        LOG.info("Clicked on gender button");
    }

    public void justRegister() {
        new NopCommerceHomePage(getDriver()).clickOnRegisterButton();
        LOG.info("Clicked on Register button");
        clickGenderButton();
        LOG.info("Selected gender button");
        new Reusable().firstNameLastName(firstNameField, lastNameField);
        LOG.info("Entered first and last name");
        new Reusable().birthDateFields(selectDateOfBirthDay, selectDateOfBirthMonth, selectDateOfBirthYear);
        LOG.info("Entered birth date");
        new Reusable().emailPasswordFields(usableEmail, emailField, passwordField, confirmPasswordField);
        LOG.info("Entered email and password fields");
        doubleClick(registerButton, continueRegisterButton);
        LOG.info("Clicked on Register button");
    }

    public void registerWithWeakPassword() {
        new NopCommerceHomePage(getDriver()).clickOnRegisterButton();
        LOG.info("Clicked on Register button");
        clickGenderButton();
        LOG.info("Selected gender button");
        new Reusable().firstNameLastName(firstNameField, lastNameField);
        LOG.info("Entered first and last name");
        new Reusable().birthDateFields(selectDateOfBirthDay, selectDateOfBirthMonth, selectDateOfBirthYear);
        LOG.info("Entered birth date");
        new Reusable().weakPasswordFields(usableEmail, emailField, passwordField, confirmPasswordField);
        LOG.info("Entered email and password fields");
        clickToRegister();
        LOG.info("Clicked on Register button");
    }

    public void registerNoEmailAndPassword() {
        LOG.info("Executing registerNoEmailAndPassword()");
        new NopCommerceHomePage(getDriver()).clickOnRegisterButton();
        LOG.info("Clicked on Register button");
        clickGenderButton();
        LOG.info("Selected gender button");
        new Reusable().firstNameLastName(firstNameField, lastNameField);
        LOG.info("Entered first and last name");
        new Reusable().birthDateFields(selectDateOfBirthDay, selectDateOfBirthMonth, selectDateOfBirthYear);
        LOG.info("Entered birth date");
        clickToRegister();
        LOG.info("Clicked on Register button");
    }

    public void registerWithWrongConfirmPassword() {
        LOG.info("Executing registerWithWrongConfirmPassword()");
        new NopCommerceHomePage(getDriver()).clickOnRegisterButton();
        LOG.info("Clicked on Register button");
        new Reusable().firstNameLastName(firstNameField, lastNameField);
        LOG.info("Entered first and last name");
        new Reusable().birthDateFields(selectDateOfBirthDay, selectDateOfBirthMonth, selectDateOfBirthYear);
        LOG.info("Entered birth date");
        new Reusable().emailPasswordFields(usableEmail, emailField, passwordField, lastNameField);
        LOG.info("Entered email and incorrect password fields");
        clickToRegister();
        LOG.info("Clicked on Register button");
    }

    public void registerAndLogin() {
        LOG.info("Executing registerAndLogin()");
        justRegister();
        LOG.info("Executed justRegister()");
        new NopCommerceHomePage(getDriver()).clickOnLoginButton();
        LOG.info("Clicked on Login button");
        type(inputEmailField, usableEmail);
        LOG.info("Entered email");
        copyText(inputEmailField);
        LOG.info("Copied email");
        type(inputPasswordField, Reusable.password1);
        LOG.info("Entered password");
        doubleClick(rememberMeButton, loginButton);
        LOG.info("Double-clicked on Remember Me button and Login button");
    }

    public void loginWithNoRegister() {
        new NopCommerceHomePage(getDriver()).clickOnLoginButton();
        LOG.info("Clicked on Login button");
        type(inputEmailField, usableEmail);
        LOG.info("Entered email");
        copyText(inputEmailField);
        LOG.info("Copied email");
        type(inputPasswordField, Reusable.password1);
        LOG.info("Entered password");
        doubleClick(rememberMeButton, loginButton);
        LOG.info("Clicked on Remember Me button and Login button");
    }

    public void logBackIn(){
        LOG.info("Executing logBackIn()");
        new NopCommerceHomePage(getDriver()).clickOnLoginButton();
        LOG.info("Clicked on Login button");
        pasteText(emailField);
        LOG.info("Pasted text in email field");
        type(emailField, " ");
        LOG.info("Entered empty space in email field");
        type(inputPasswordField, Reusable.newPassword);
        LOG.info("Entered new password");
        doubleClick(rememberMeButton, loginButton);
        LOG.info("Double-clicked on Remember Me button and Login button");
    }

    public void changeCustomerInfo() {
        LOG.info("Executing changeCustomerInfo()");
        clearOutCustomerInfo();
        LOG.info("Cleared customer information");
        new Reusable().firstNameLastName(firstNameField, lastNameField);
        LOG.info("Entered new first and last name");
        new Reusable().birthDateFields(selectDateOfBirthDay, selectDateOfBirthMonth, selectDateOfBirthYear);
        LOG.info("Entered new birth date");
        type(inputEmailField, new Customer().getEmail());
        LOG.info("Entered new email");
        click(saveInfoButton);
        LOG.info("Clicked on Save Info button");
    }

    public void clearOutCustomerInfo() {
        LOG.info("Executing clearOutCustomerInfo()");
        List<WebElement> clearNameFields = Arrays.asList(firstNameField, lastNameField);
        for (WebElement clearAll : clearNameFields) {
            clear(clearAll);
        }
        LOG.info("Cleared name fields");
        List<WebElement> clearEmailFields = Arrays.asList(emailField, companyNameField);
        for (WebElement clearAll : clearEmailFields) {
            clear(clearAll);
        }
        LOG.info("Cleared email and company name fields");
    }

    public void loginSQlInjectionEmail() {
        LOG.info("Executing loginSQlInjectionEmail()");
        new NopCommerceHomePage(getDriver()).clickOnLoginButton();
        LOG.info("Clicked on Login button");
        type(inputEmailField, usableEmail + SQLInjection.SQL_INJECTION.getSQL());
        LOG.info("Entered email with SQL injection");
        type(inputPasswordField, Reusable.password1);
        LOG.info("Entered password");
        doubleClick(rememberMeButton, loginButton);
        LOG.info("Double-clicked on Remember Me button and Login button");
    }

    public void loginSQlInjectionPassword() {
        LOG.info("Executing loginSQlInjectionPassword()");
        new NopCommerceHomePage(getDriver()).clickOnLoginButton();
        LOG.info("Clicked on Login button");
        type(inputEmailField, usableEmail);
        LOG.info("Entered email");
        type(inputPasswordField, Reusable.password1 + SQLInjection.SQL_INJECTION.getSQL());
        LOG.info("Entered password with SQL injection");
        doubleClick(rememberMeButton, loginButton);
        LOG.info("Double-clicked on Remember Me button and Login button");
    }

    public void registerLoginWithDataProvider(String password) {
        LOG.info("Executing registerLoginWithDataProvider()");
        new NopCommerceHomePage(getDriver()).clickOnRegisterButton();
        LOG.info("Clicked on Register button");
        clickGenderButton();
        LOG.info("Selected gender button");
        new Reusable().firstNameLastName(firstNameField, lastNameField);
        LOG.info("Entered first and last name");
        new Reusable().birthDateFields(selectDateOfBirthDay, selectDateOfBirthMonth, selectDateOfBirthYear);
        LOG.info("Entered birth date");
        List<String> emailPass = Arrays.asList(usableEmail, password, password);
        List<WebElement> emailPassElements = Arrays.asList(emailField, passwordField, confirmPasswordField);
        for (int i = 0; i < emailPass.size(); i++) {
            type(emailPassElements.get(i), emailPass.get(i));
            LOG.info("Entered email and password fields");
        }
        doubleClick(registerButton, continueRegisterButton);
        LOG.info("Double-clicked on Register button");
        new NopCommerceHomePage(getDriver()).clickOnLoginButton();
        LOG.info("Clicked on Login button");
        type(inputEmailField, usableEmail);
        LOG.info("Entered email");
        type(inputPasswordField, password);
        LOG.info("Entered password");
        doubleClick(rememberMeButton, loginButton);
        LOG.info("Double-clicked on Remember Me button and Login button");
    }
}
