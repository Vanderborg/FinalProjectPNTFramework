package luma.lumapages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsletterSubscriptionPage extends CommonAPI {

    @FindBy(css = "#subscription")
    public WebElement SubscriptionCheckBox;

    @FindBy(css = "button[title='Save'] span")
    public WebElement saveBttn;

    Logger LOG = LogManager.getLogger(NewsletterSubscriptionPage.class);

    public NewsletterSubscriptionPage(WebDriver driver) {PageFactory.initElements(driver,this);}

    public void enableSubscriptionAndConfirm() {
        doubleClick(SubscriptionCheckBox,saveBttn);
        LOG.info("Clicks on the checkbox and clicks the save button.");}
}
