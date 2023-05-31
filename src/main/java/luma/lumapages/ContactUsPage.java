package lumapages;

import base.CommonAPI;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends CommonAPI {

  @FindBy(css = "#name")
  public WebElement nameTextField;

  @FindBy(css = "#email")
  public WebElement emailTextField;

  @FindBy(css = "#comment")
  public WebElement feedbackField;

  @FindBy(css = "button[title='Submit'] span")
  public WebElement submitBttn;

  @FindBy(xpath = "//div[@class='message-success success message']")
  public WebElement successfulContactBttn;

  public ContactUsPage(WebDriver driver) {PageFactory.initElements(driver,this);}

    Logger log = LogManager.getLogger(ContactUsPage.class.getName());

  public boolean verifyContactUs() {return checkDisplayed(successfulContactBttn);}

  public void submitFeedbackToSite() {
      String name = new Faker().name().fullName();
      String email = new Faker().bothify("?????????????##@gmail.com");
        type(nameTextField, name);
        type(emailTextField,email);
        type(feedbackField,"Get a better website");
        click(submitBttn);
    }
}

