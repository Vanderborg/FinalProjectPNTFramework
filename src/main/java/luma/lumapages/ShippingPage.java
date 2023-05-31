
package luma.lumapages;

import base.CommonAPI;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage extends CommonAPI {

    @FindBy(css = "input[value='tablerate_bestway']")
    public WebElement freeShippingOption;

    @FindBy(css = ".button.action.continue.primary")
    public WebElement continueToPaymentBttn;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[2]/div[1]/div[1]/div[1]/input[1]")
    public WebElement shippingFirstName;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[2]/div[1]/div[2]/div[1]/input[1]")
    public WebElement shippingLastName;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[2]/div[1]/fieldset[1]/div[1]/div[1]/div[1]/input[1]")
    public WebElement shippingAddress;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[2]/div[1]/div[4]/div[1]/input[1]")
    public WebElement shippingCity;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[2]/div[1]/div[5]/div[1]/select[1]")
    public WebElement shippingState;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[2]/div[1]/div[7]/div[1]/input[1]")
    public WebElement shippingZipCode;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[2]/div[1]/div[8]/div[1]/select[1]")
    public WebElement shippingCountry;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[2]/div[1]/div[9]/div[1]/input[1]")
    public WebElement shippingPhoneNumber;

    @FindBy(css = "input[value='tablerate_bestway']")
    public WebElement shippingBestWayBttn;

    @FindBy(id = "customer-email")
    public WebElement customerEmailField;

    @FindBy(css = "span[data-bind=\"i18n: 'Next'\"]")
    public WebElement continueToPaymentPageBttn;

    Logger LOG = LogManager.getLogger(ShippingPage.class);

    public ShippingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void shippingSelection() {
        click(freeShippingOption);
        LOG.info("Clicked on Free Shipping option");
        click(continueToPaymentBttn);
        LOG.info("Clicked on Continue to Payment button");
        waitFor(1);
        LOG.info("Waiting for 1 second");
    }

    public void fillOutShippingInfo() {
        Actions actions = new Actions(driver);
        String email = new Faker().bothify("??????##@gmail.com");
        String firstName = new Faker().name().firstName();
        String lastName = new Faker().name().lastName();
        String address = new Faker().address().streetAddress();
        String city = new Faker().address().city();
        String state = new Faker().address().state();
        String zipCode = new Faker().address().zipCode();
        String country = String.valueOf(new Faker().country());
        String phone = new Faker().phoneNumber().cellPhone();
        waitFor(2);
        LOG.info("Waiting for 2 seconds");
        type(customerEmailField, email);
        LOG.info("Entered customer email: " + email);
        type(shippingFirstName, firstName);
        LOG.info("Entered shipping first name: " + firstName);
        type(shippingLastName, lastName);
        LOG.info("Entered shipping last name: " + lastName);
        type(shippingAddress, address);
        LOG.info("Entered shipping address: " + address);
        type(shippingCity, city);
        LOG.info("Entered shipping city: " + city);
        selectFromDropdown(shippingState, state);
        LOG.info("Selected shipping state: " + state);
        type(shippingZipCode, zipCode);
        LOG.info("Entered shipping zip code: " + zipCode);
        type(shippingPhoneNumber, phone);
        LOG.info("Entered shipping phone number: " + phone);
        click(shippingBestWayBttn);
        LOG.info("Clicked on Shipping Best Way button");
        waitFor(2);
        LOG.info("Waiting for 2 seconds");
        click(continueToPaymentPageBttn);
        LOG.info("Clicked on Continue to Payment Page button");
        waitFor(1);
        LOG.info("Waiting for 1 second");
    }

    public void fillOutRegisteredUserInfo() {
        String address = new Faker().address().streetAddress();
        String city = new Faker().address().city();
        String state = new Faker().address().state();
        String zipCode = new Faker().address().zipCode();
        String phone = new Faker().phoneNumber().cellPhone();
        waitFor(2);
        LOG.info("Waiting for 2 seconds");
        type(shippingAddress, address);
        LOG.info("Entered shipping address: " + address);
        type(shippingCity, city);
        LOG.info("Entered shipping city: " + city);
        selectFromDropdown(shippingState, state);
        LOG.info("Selected shipping state: " + state);
        type(shippingZipCode, zipCode);
        LOG.info("Entered shipping zip code: " + zipCode);
        type(shippingPhoneNumber, phone);
        LOG.info("Entered shipping phone number: " + phone);
        click(shippingBestWayBttn);
        LOG.info("Clicked on Shipping Best Way button");
        waitFor(2);
        LOG.info("Waiting for 2 seconds");
        click(continueToPaymentPageBttn);
        LOG.info("Clicked on Continue to Payment Page button");
        waitFor(1);
        LOG.info("Waiting for 1 second");
    }
}