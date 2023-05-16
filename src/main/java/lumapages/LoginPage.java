package lumapages;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends CommonAPI {

    @FindBy(css = "#email")
    public WebElement emailField;

    @FindBy(xpath = "(//input[@id='pass'])[1]")
    public WebElement passwordField;

//    @FindBy(xpath = "(//input[@id='captcha_user_login'])[1]")
//    public WebElement captchaTextField;

    @FindBy(css = "fieldset[class='fieldset login'] div[class='primary'] span")
    public WebElement signInBttn;

    public LoginPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void customerLogin(String email, String password){
        HomePage home = new HomePage(getDriver());
        home.navigateToSignIn();
        type(emailField, email);
        type(passwordField, password);
        click(signInBttn);
    }
}

