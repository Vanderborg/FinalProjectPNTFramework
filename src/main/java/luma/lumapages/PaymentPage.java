
package luma.lumapages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends CommonAPI {

    @FindBy(css = "button[title='Place Order']")
    public WebElement placeOrderBttn;

    @FindBy(css = "#billing-address-same-as-shipping-checkmo")
    public WebElement sameBillingAndShippingBox;

    @FindBy(xpath = "//span[normalize-space()='-$61.60']")
    public WebElement appliedDiscountShown;

    @FindBy(xpath = "//span[normalize-space()='Discount (Use promo code H20 at checkout)']")
    public WebElement waterBottleDiscount;

    @FindBy(css = ".message-error.error.message")
    public WebElement invalidWaterBottleDiscount;

    Logger LOG = LogManager.getLogger(PaymentPage.class);

    public PaymentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyDiscountApplied() {
        LOG.info("Verifying if discount is applied");
        return checkDisplayed(appliedDiscountShown);
    }

    public boolean verifyBottleDiscount() {
        LOG.info("Verifying if bottle discount is displayed");
        return checkDisplayed(waterBottleDiscount);
    }

    public boolean verifyInvalidBottleDiscount() {
        LOG.info("Verifying if invalid bottle discount is displayed");
        return checkDisplayed(invalidWaterBottleDiscount);
    }

    public void placeOrder() {
        waitFor(2);
        LOG.info("Waiting for 2 seconds");
        click(placeOrderBttn);
        LOG.info("Clicked on Place Order Button");
    }
}
