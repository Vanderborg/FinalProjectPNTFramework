
package luma.lumapages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends CommonAPI {

    @FindBy(css = ".message-success.success.message")
    public WebElement accountCreationSuccess;

    @FindBy(xpath = "//a[@aria-label='store logo']//img")
    public WebElement lumaHomeButton;

    @FindBy(xpath = "//a[normalize-space()='Address Book']")
    public WebElement addressBookTab;

    @FindBy(xpath = "//strong[normalize-space()='My Recent Reviews']")
    public WebElement verifyRecentReviews;

    @FindBy(xpath = "//a[normalize-space()='Newsletter Subscriptions']")
    public WebElement myAccountNewsletterSubscriptionTab;

    @FindBy(css = ".message-success.success.message")
    public WebElement newsletterSubscriptionConfirmation;

    @FindBy(xpath = "//a[normalize-space()='My Orders']")
    public WebElement myOrdersTab;

    Logger LOG = LogManager.getLogger(AccountPage.class);

    public AccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyAccountCreated() {
        LOG.info("Verifying account creation success message is displayed");
        return checkDisplayed(accountCreationSuccess);
    }

    public boolean verifyRecentReviewsVisible() {
        LOG.info("Verifying recent reviews section is visible");
        return checkDisplayed(verifyRecentReviews);
    }

    public void navigateToHomeScreen() {
        click(lumaHomeButton);
        LOG.info("Clicks the Luma Home button");
    }

    public void navigateToAddressBook() {
        click(addressBookTab);
        LOG.info("Clicks the Address Book tab");
    }

    public void navigateToNewsletterSubscriptionTab() {
        click(myAccountNewsletterSubscriptionTab);
        LOG.info("Clicks the Newsletter Subscriptions tab");
    }

    public void navigateToMyOrders() {
        click(myOrdersTab);
        LOG.info("Clicks the My Orders tab");
    }

    public boolean verifyNewsletterSubscriptionSuccessful() {
        LOG.info("Verifying newsletter subscription confirmation is displayed");
        return checkDisplayed(newsletterSubscriptionConfirmation);
    }
}
