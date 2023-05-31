
package luma.lumapages;

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

  Logger LOG = LogManager.getLogger(ContactUsPage.class);

  public ContactUsPage(WebDriver driver) {PageFactory.initElements(driver,this);}

  public boolean verifyContactUs() {
    LOG.info("Verifying if contact form submission success message is displayed");
    return checkDisplayed(successfulContactBttn);
  }

  public void submitFeedbackToSite() {
    String name = new Faker().name().fullName();
    LOG.info("Generated random name: " + name);
    String email = new Faker().bothify("?????????????##@gmail.com");
    LOG.info("Generated random email: " + email);

    type(nameTextField, name);
    LOG.info("Entered name in the name field");
    type(emailTextField, email);
    LOG.info("Entered email in the email field");
    type(feedbackField, "Get a better website");
    LOG.info("Entered feedback in the feedback field");
    click(submitBttn);
    LOG.info("Clicked submit button to submit the feedback");
  }
}

