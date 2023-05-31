package lumapages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends CommonAPI {

    @FindBy(css = ".message-success.success.message")
    public WebElement accountCreationSuccess;

    public AccountPage(WebDriver driver) {PageFactory.initElements(driver,this);}

    public boolean verifyAccountCreated() {return checkDisplayed(accountCreationSuccess);}
}
