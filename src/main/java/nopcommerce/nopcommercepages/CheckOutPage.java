package nopcommerce.nopcommercepages;

import base.CommonAPI;
import nopcommerce.nopcommercerandom.CreditCard;
import nopcommerce.nopcommercereusablemethods.Reusable;
import nopcommerce.nopcommerceobjects.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class CheckOutPage extends CommonAPI {

    @FindBy(css = "#BillingNewAddress_FirstName")
    public WebElement billFirstNameField;

    @FindBy(css = "#BillingNewAddress_LastName")
    public WebElement billLastNameField;

    @FindBy(css = "#BillingNewAddress_Email")
    public WebElement billEmailField;

    @FindBy(css = "#BillingNewAddress_CountryId")
    public WebElement countryDropDown;

    @FindBy(css = "#BillingNewAddress_StateProvinceId")
    public WebElement stateDropDown;

    @FindBy(css = "#BillingNewAddress_City")
    public WebElement billCityField;

    @FindBy(css = "#BillingNewAddress_Address1")
    public WebElement billAddressField;

    @FindBy(css = "#BillingNewAddress_ZipPostalCode")
    public WebElement billZipCodeField;

    @FindBy(css = "#BillingNewAddress_PhoneNumber")
    public WebElement billPhoneField;

    @FindBy(css = "button[onclick='Billing.save()']")
    public WebElement shippingButton;

    @FindBy(xpath = "//button[@class='button-1 shipping-method-next-step-button']")
    public WebElement paymentButton;

    @FindBy(xpath = "//input[@id='paymentmethod_0']")
    public WebElement checkMoneyRadioButton;

    @FindBy(css = "#paymentmethod_1")
    public WebElement creditCardRadioButton;

    @FindBy(css = "button[class='button-1 payment-method-next-step-button']")
    public WebElement paymentInfoButton;

    @FindBy(css = "#CreditCardType")
    public WebElement selectCreditCard;

    @FindBy(css = "#CardholderName")
    public WebElement cardHolderNameField;

    @FindBy(css = "#CardNumber")
    public WebElement cardNumberField;

    @FindBy(css = "#ExpireMonth")
    public WebElement selectMonthExpirationDate;

    @FindBy(css = "#ExpireYear")
    public WebElement selectYearExpirationDate;

    @FindBy(css = "#CardCode")
    public WebElement cardCodeField;

    @FindBy(css = ".button-1.payment-info-next-step-button")
    public WebElement confirmOrderButton;

    @FindBy(css = ".button-1.confirm-order-next-step-button")
    public WebElement checkOutCompleteButton;

    @FindBy(xpath = "//li[text()='Wrong card number']")
    public WebElement wrongCardNumberText;

    @FindBy(xpath = "//div[@id='payment-info-buttons-container']//p[@class='back-link']//a[@href='#']")
    public WebElement returnBackToCreditCard;

    Logger LOG = LogManager.getLogger(CheckOutPage.class.getName());

    public CheckOutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private boolean wrongCardNumberIsDisplayed() {
        LOG.info("Wrong card number is displayed");
        return checkDisplayed(wrongCardNumberText);
    }

    public void checkOutAsGuestWithCheckMoney() {
        new CartPage(getDriver()).clickCheckOut();
        LOG.info("Clicked checkout button");
        new RegisterLoginPage(getDriver()).checkOutAsGuest();
        LOG.info("Clicked checkout as guest");
        new Reusable().firstNameLastNameEmail(new Customer(), billFirstNameField, billLastNameField, billEmailField);
        LOG.info("Typed first and last name and email field");
        new Reusable().selectCountryAndState(countryDropDown, stateDropDown);
        LOG.info("Selected country and state");
        new Reusable().addressAndPhoneNumber(new Customer(), billCityField, billAddressField, billZipCodeField, billPhoneField);
        LOG.info("Typed city, address, zipcode and phone number field");
        continueWithCheckMoneyOrder();
        LOG.info("Continue with check money order info method");
    }

    public void checkOutAsGuestWithCreditCard(String creditNumber, String creditCode) {
        new CartPage(getDriver()).clickCheckOut();
        LOG.info("Clicked checkout button");
        new RegisterLoginPage(getDriver()).checkOutAsGuest();
        LOG.info("Clicked checkout as guest");
        new Reusable().firstNameLastNameEmail(new Customer(), billFirstNameField, billLastNameField, billEmailField);
        LOG.info("Typed first and last name and email field");
        new Reusable().selectCountryAndState(countryDropDown, stateDropDown);
        LOG.info("Selected country and state");
        new Reusable().addressAndPhoneNumber(new Customer(), billCityField, billAddressField, billZipCodeField, billPhoneField);
        LOG.info("Typed city, address, zipcode and phone number field");
        continueWithCreditCard(new Customer(), creditNumber, creditCode);
        LOG.info("Continue with credit card method");
    }

    public void registeredUserCheckMoneyCheckout() {
        new Reusable().addressAndPhoneNumber(new Customer(), billCityField, billAddressField, billZipCodeField, billPhoneField);
        LOG.info("Typed city, address, zipcode and phone number field");
        new Reusable().selectCountryAndState(countryDropDown, stateDropDown);
        LOG.info("Selected country and state");
        continueWithCheckMoneyOrder();
        LOG.info("Continue with check money order info method");
    }

    public void registeredUserCreditCardCheckout(String creditNumber, String creditCode) {
        new Reusable().selectCountryAndState(countryDropDown, stateDropDown);
        LOG.info("Selected country and state");
        new Reusable().billFirstNameLastName(billFirstNameField, billLastNameField);
        LOG.info("Typed first and last name field");
        new Reusable().selectCountryAndState(countryDropDown, stateDropDown);
        LOG.info("Selected country and state");
        new Reusable().addressAndPhoneNumber(new Customer(), billCityField, billAddressField, billZipCodeField, billPhoneField);
        LOG.info("Typed city, address, zipcode and phone number field");
        continueWithCreditCard(new Customer(), creditNumber, creditCode);
        LOG.info("Continue with credit card method");
    }

    public void continueWithCheckMoneyOrder() {
        List<WebElement> click = Arrays.asList(shippingButton, paymentButton, checkMoneyRadioButton, paymentInfoButton, confirmOrderButton, checkOutCompleteButton);
        for (WebElement clickAll : click) {
            click(clickAll);
            LOG.info("Clicked shipping, payment, check money radio, payment info, confirm order and checkout complete button");
        }
    }

    public void continueWithCreditCard(Customer customer, String creditNumber, String creditCode) {
        List<WebElement> click = Arrays.asList(shippingButton, paymentButton, creditCardRadioButton, paymentInfoButton);
        for (WebElement clickAll : click) {
            click(clickAll);
            LOG.info("Clicked shipping, payment, credit card radio and payment info button");
        }
        selectFromDropdown(selectCreditCard, CreditCard.randomCard());
        LOG.info("Selected credit card provider");
        List<String> cardHolder = List.of(customer.getFirstName() + " " + customer.getLastName(), creditNumber);
        List<WebElement> cardHolderElements = Arrays.asList(cardHolderNameField, cardNumberField);
        for (int i = 0; i < cardHolder.size(); i++) {
            type(cardHolderElements.get(i), cardHolder.get(i));
            LOG.info("Typed card holder name and card number field");
        }
        selectFromDropdown(selectMonthExpirationDate, CreditCard.randomExpMonth());
        LOG.info("Selected credit card month");
        selectFromDropdown(selectYearExpirationDate, CreditCard.randomExpYear());
        LOG.info("Selected credit card year");
        type(cardCodeField, creditCode);
        LOG.info("Typed credit card code");
        doubleClick(confirmOrderButton, checkOutCompleteButton);
        LOG.info("Clicked confirm order and checkout complete button");
    }
}
