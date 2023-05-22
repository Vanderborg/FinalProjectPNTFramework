package nopcommercepages;

import base.CommonAPI;
import com.github.javafaker.Faker;
import nopcommerceobjects.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class RegisterLoginPage extends CommonAPI {

    @FindBy(id = "gender-male")
    public WebElement genderRadioButton;

    @FindBy(id = "FirstName")
    public WebElement firstNameField;

    @FindBy(id = "LastName")
    public WebElement lastNameField;

    @FindBy(css = "select[name='DateOfBirthDay']")
    public WebElement selectDateOfBirthDay;

    @FindBy(css = "select[name='DateOfBirthMonth']")
    public WebElement selectDateOfBirthMonth;

    @FindBy(css = "select[name='DateOfBirthYear']")
    public WebElement selectDateOfBirthYear;

    @FindBy(id = "Email")
    public WebElement emailField;

    @FindBy(id = "Company")
    public WebElement companyNameField;

    @FindBy(id = "Password")
    public WebElement passwordField;

    @FindBy(id = "ConfirmPassword")
    public WebElement confirmPasswordField;

    @FindBy(id = "register-button")
    public  WebElement registerButton;

    @FindBy(css = ".button-1.register-continue-button")
    public WebElement continueRegisterButton;

    @FindBy(id = "Email")
    public WebElement inputEmailField;

    @FindBy(id = "Password")
    public WebElement inputPasswordField;

    @FindBy(css = "#RememberMe")
    public WebElement rememberMeButton;

    @FindBy(xpath = "//button[normalize-space()='Log in']")
    public WebElement loginButton;

    @FindBy(css = ".button-1.checkout-as-guest-button")
    public WebElement checkOutAsGuestBttn;

    @FindBy(id = "save-info-button")
    public WebElement saveInfoButton;

    @FindBy(css = ".content")
    public WebElement customerInfoUpdatedText;


    public RegisterLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static String password;

    public static String email;

    public boolean verifyCustomerInfoTextIsDisplayed() {
        return checkDisplayed(customerInfoUpdatedText);
    }

    public void checkOutAsGuest() {
        click(checkOutAsGuestBttn);
    }

    public void registerAndLogin(String day, String month, String year, Customer customer) {
        new NopCommerceHomePage(getDriver()).clickOnRegisterButton();
        click(genderRadioButton);
        nameFields(customer);
        birthDateFields(day, month, year);
        List<String> pass = Arrays.asList(customer.getEmail(), customer.getPassword(), customer.getPassword());
        List<WebElement> passElements = Arrays.asList(emailField, passwordField, confirmPasswordField);
        for (int i = 0; i < pass.size() ; i++) {
            type(passElements.get(i), pass.get(i));
        }
        doubleClick(registerButton, continueRegisterButton);
        new NopCommerceHomePage(getDriver()).clickOnLoginButton();
        type(inputEmailField, customer.getEmail());
        type(inputPasswordField, customer.getPassword());
        doubleClick(rememberMeButton, loginButton);
    }

    public void logBackIn(){
        String newPassword = MyAccountPage.newPassword;
        new NopCommerceHomePage(getDriver()).clickOnLoginButton();
        type(emailField, email);
        type(inputPasswordField, newPassword);
        doubleClick(rememberMeButton, loginButton);
    }

    public void changeCustomerInfo(String day, String month, String year, Customer customer) {
        clearOutCustomerInfo();
        nameFields(customer);
        birthDateFields(day, month, year);
        type(inputEmailField, email);
        click(saveInfoButton);
    }

    public void nameFields(Customer customer) {
        List<String> nameFields = Arrays.asList(customer.getFirstName(), customer.getLastName());
        List<WebElement> nameFieldsElements = Arrays.asList(firstNameField, lastNameField);
        for (int i = 0; i < nameFields.size() ; i++) {
            type(nameFieldsElements.get(i), nameFields.get(i));
        }
    }

    public void birthDateFields(String day, String month, String year) {
        List<String> birth = Arrays.asList(day, month, year);
        List<WebElement> birthWebElements = Arrays.asList(selectDateOfBirthDay, selectDateOfBirthMonth, selectDateOfBirthYear);
        for (int i = 0; i < birth.size() ; i++) {
            selectFromDropdown(birthWebElements.get(i), birth.get(i));
        }
    }

    public void clearOutCustomerInfo() {
        List<WebElement> clearNameFields = Arrays.asList(firstNameField, lastNameField);
        for (WebElement clearAll:clearNameFields) {
            clear(clearAll);
        }
        List<WebElement> clearEmailFields = Arrays.asList(emailField, companyNameField);
        for (WebElement clearAll:clearEmailFields) {
            clear(clearAll);
        }
    }
}