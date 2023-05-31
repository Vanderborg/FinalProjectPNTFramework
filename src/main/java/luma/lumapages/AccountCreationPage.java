
package luma.lumapages;

import base.CommonAPI;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage extends CommonAPI {

    @FindBy(css = "#firstname")
    public WebElement createFirstName;

    @FindBy(css = "#lastname")
    public WebElement createLastName;

    @FindBy(css = "#email_address")
    public WebElement createEmail;

    @FindBy(css = "#password")
    public WebElement createPassword;

    @FindBy(css = "#password-confirmation")
    public WebElement createPasswordConfirmation;

    @FindBy(css = "button[title='Create an Account'] span")
    public WebElement confirmAccountCreation;

    @FindBy(css = "#email_address-error")
    public WebElement emailError;

    @FindBy(css = "#password-error")
    public WebElement passwordError;

    Logger LOG = LogManager.getLogger(AccountCreationPage.class);

    public AccountCreationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void createAccount() {
        String firstName = new Faker().name().firstName();
        String lastName = new Faker().name().lastName();
        String email = new Faker().bothify("??????##@gmail.com");
        String passWord = new Faker().bothify("????????#####$%");
        type(createFirstName, firstName);
        LOG.info("First name entered: " + firstName);
        type(createLastName, lastName);
        LOG.info("Last name entered: " + lastName);
        type(createEmail, email);
        LOG.info("Email entered: " + email);
        type(createPassword, passWord);
        LOG.info("Password entered");
        type(createPasswordConfirmation, passWord);
        LOG.info("Password confirmation entered");
        click(confirmAccountCreation);
        LOG.info("Account creation form submitted");
    }

    public void invalidAccountCreation() {
        String firstName = new Faker().name().firstName();
        String lastName = new Faker().name().lastName();
        type(createFirstName, firstName);
        LOG.info("First name entered: " + firstName);
        type(createLastName, lastName);
        LOG.info("Last name entered: " + lastName);
        LOG.info("Invalid account creation form filled");
    }

    public void confirmAccountCreation() {
        click(confirmAccountCreation);
        LOG.info("Account creation confirmation button clicked");
    }

    public boolean verifyInvalidAccountCreationWithoutEmail() {
        LOG.info("Verifying if invalid account creation without email error is displayed");
        return checkDisplayed(emailError);
    }

    public boolean verifyInvalidAccountCreationWithoutPassword() {
        LOG.info("Verifying if invalid account creation without password error is displayed");
        return checkDisplayed(passwordError);
    }

    public void loginWithDataProvider(String email, String password) {
        new HomePage(getDriver()).navigateToSignIn();
        new LoginPage(getDriver()).navigateToCreateAccount();
        String firstName = new Faker().name().firstName();
        String lastName = new Faker().name().lastName();
        type(createFirstName, firstName);
        LOG.info("First name entered: " + firstName);
        type(createLastName, lastName);
        LOG.info("Last name entered: " + lastName);
        type(createEmail, email);
        LOG.info("Email entered: " + email);
        type(createPassword, password);
        LOG.info("Password entered");
        type(createPasswordConfirmation, password);
        waitFor(5);
        LOG.info("Password confirmation entered");
        click(confirmAccountCreation);
        LOG.info("Account creation form submitted");
    }
}
