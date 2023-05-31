package nopcommerce.nopcommercepages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutCompletePage extends CommonAPI {

    @FindBy(xpath = "//h1[normalize-space()='Thank you']")
    public WebElement thankYouText;

    @FindBy(xpath = "//strong[normalize-space()='Your order has been successfully processed!']")
    public WebElement yourOrderHasBeenSuccessFullyProcessedText;

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    public WebElement backHomeButton;

    Logger LOG = LogManager.getLogger(CheckOutCompletePage.class.getName());

    public CheckOutCompletePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickBackToHomeButton() {
        click(backHomeButton);
        LOG.info("Clicked back to home button");
    }

    public boolean thankYouTextIsDisplayed() {
        LOG.info("Thank you text is displayed");
        return checkDisplayed(thankYouText);
    }

    public boolean yourOrderHasBeenProcessedIsDisplayed() {
        LOG.info("Your order has been processed is displayed");
        return checkDisplayed(yourOrderHasBeenSuccessFullyProcessedText);
    }
}