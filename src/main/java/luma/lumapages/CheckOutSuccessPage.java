package luma.lumapages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutSuccessPage extends CommonAPI {

    @FindBy(xpath = "//div[@class='page-wrapper']//p[1]")
    public WebElement orderConfirmationSuccess;

    @FindBy(xpath = "//a[normalize-space()='Print receipt']")
    public WebElement printOrderReceiptBttn;

    Logger LOG = LogManager.getLogger(CheckOutSuccessPage.class);

    public CheckOutSuccessPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyCheckOutSuccess() {
        LOG.info("Verifying if the checkout is successful");
        return checkDisplayed(orderConfirmationSuccess);
    }

    public boolean verifyReceiptFromOrder() {
        LOG.info("Verifying if the order receipt is displayed");
        return checkDisplayed(printOrderReceiptBttn);
    }
}
