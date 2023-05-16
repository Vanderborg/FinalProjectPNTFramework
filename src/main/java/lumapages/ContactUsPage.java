package lumapages;

import base.CommonAPI;
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

  public ContactUsPage(WebDriver driver) {PageFactory.initElements(driver,this);}

    Logger log = LogManager.getLogger(ContactUsPage.class.getName());

  public void submitFeedbackToSite() {
        type(nameTextField, "Adam Vanderborg");
        log.info("jj ");
        type(emailTextField,"adamvanderborg@gmail.com");
        type(feedbackField,"Get a better website");
        click(submitBttn);
    }
}

