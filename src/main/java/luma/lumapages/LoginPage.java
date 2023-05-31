
package luma.lumapages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ConnectDB;
import utility.ExcelReader;

public class LoginPage extends CommonAPI {

    @FindBy(css = "a[class='action create primary'] span")
    public WebElement createAccountBttn;

    @FindBy(css = "#email")
    public WebElement emailField;

    @FindBy(xpath = "(//input[@id='pass'])[1]")
    public WebElement passwordField;

//    @FindBy(xpath = "(//input[@id='captcha_user_login'])[1]")
//    public WebElement captchaTextField;

    @FindBy(css = "fieldset[class='fieldset login'] div[class='primary'] span")
    public WebElement signInBttn;

    @FindBy(css = ".message-error.error.message")
    public WebElement invalidLoginErrorMsg;

    Logger LOG = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyInvalidLogin() {
        LOG.info("Verifying if invalid login error message is displayed");
        return checkDisplayed(invalidLoginErrorMsg);
    }

    public void navigateToCreateAccount() {
        click(createAccountBttn);
        LOG.info("Clicked on Create Account Button");
    }

    public void customerLogin(String email, String password) {
        LOG.info("Performing customer login");
        new HomePage(getDriver()).navigateToSignIn();
        LOG.info("Clicked on Sign In Button");
        type(emailField, email);
        LOG.info("Entered email: " + email);
        type(passwordField, password);
        LOG.info("Entered password");
        click(signInBttn);
        LOG.info("Clicked on Sign In Button");
    }

    public void logInWithSQLDatabase() {
        String email = new ConnectDB().readMysqlDataBaseColumn("lumalogininfo", "Email").toString().replace("[", "").replace("]", "");
        LOG.info("Email retrieved: " + email);
        String password = new ConnectDB().readMysqlDataBaseColumn("lumalogininfo", "Password").toString().replace("[", "").replace("]", "");
        LOG.info("Password retrieved");
        type(emailField, email);
        LOG.info("Entered email from SQL database: " + email);
        type(passwordField, password);
        LOG.info("Entered password from SQL database");
        click(signInBttn);
        LOG.info("Clicked on Sign In Button");
    }

    public void loginWithDataProvider(String dataEmail, String dataPassword) {
        LOG.info("Performing login with data provider");
        new HomePage(getDriver()).navigateToSignIn();
        type(emailField, dataEmail);
        LOG.info("Entered email from data provider: " + dataEmail);
        type(passwordField, dataPassword);
        LOG.info("Entered password from data provider");
        click(signInBttn);
        LOG.info("Clicked on Sign In Button");
    }

    public void excelLogin() {
        String email = new ExcelReader("C:\\Users\\acekn\\Downloads\\DataProvider.xlsx").getDataFromCell("Sheet1", 1, 0);
        String password = new ExcelReader("C:\\Users\\acekn\\Downloads\\DataProvider.xlsx").getDataFromCell("Sheet1", 1, 1);
        LOG.info("Performing customer login");
        new HomePage(getDriver()).navigateToSignIn();
        LOG.info("Clicked on Sign In Button");
        type(emailField, email);
        LOG.info("Entered email: " + email);
        type(passwordField, password);
        LOG.info("Entered password");
        click(signInBttn);
        LOG.info("Clicked on Sign In Button");
    }
}

