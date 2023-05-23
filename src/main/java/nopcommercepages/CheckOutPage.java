package nopcommercepages;

import base.CommonAPI;
import nopcommerceenums.country.Country;
import nopcommerceenums.creditcard.CC;
import nopcommerceenums.excel.Excel;
import nopcommerceobjects.Customer;
import nopcommerceobjects.State;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ConnectDB;
import utility.ExcelReader;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.util.List.of;

public class CheckOutPage extends CommonAPI {

    @FindBy(css = "#BillingNewAddress_FirstName")
    public WebElement billingFirstNameField;

    @FindBy(css = "#BillingNewAddress_LastName")
    public WebElement billingLastNameField;

    @FindBy(css = "#BillingNewAddress_Email")
    public WebElement billingEmailField;

    @FindBy(css = "#BillingNewAddress_CountryId")
    public WebElement selectCountryDropDown;

    @FindBy(css = "#BillingNewAddress_StateProvinceId")
    public WebElement selectStateDropDown;

    @FindBy(css = "#BillingNewAddress_City")
    public WebElement billingCityField;

    @FindBy(css = "#BillingNewAddress_Address1")
    public WebElement billingAddressField;

    @FindBy(css = "#BillingNewAddress_ZipPostalCode")
    public WebElement billingZipCodeField;

    @FindBy(css = "#BillingNewAddress_PhoneNumber")
    public WebElement billingPhoneNumberField;

    @FindBy(css = "button[onclick='Billing.save()']")
    public WebElement continueToShippingButton;

    @FindBy(xpath = "//button[@class='button-1 shipping-method-next-step-button']")
    public WebElement continueToPaymentButton;

    @FindBy(xpath = "//input[@id='paymentmethod_0']")
    public WebElement checkMoneyOrderRadioButton;

    @FindBy(css = "#paymentmethod_1")
    public WebElement creditCardRadioButton;

    @FindBy(css = "button[class='button-1 payment-method-next-step-button']")
    public WebElement continueToPaymentInfoButton;

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
    public WebElement continueToConfirmOrderButton;

    @FindBy(css = "button.button-1.confirm-order-next-step-button")
    public WebElement creditCardContinueConfirmOrderButton;

    @FindBy(css = ".button-1.confirm-order-next-step-button")
    public WebElement confirmCheckOutCompleteButton;

    @FindBy(xpath = "//li[text()='Wrong card number']")
    public WebElement wrongCardNumberText;

    @FindBy(xpath = "//div[@id='payment-info-buttons-container']//p[@class='back-link']//a[@href='#']")
    public WebElement returnBackToCreditCard;

    public CheckOutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private boolean wrongCardNumberIsDisplayed() {
        return checkDisplayed(wrongCardNumberText);
    }

    public void clickConfirmCheckOutCompleteButton() {
        click(confirmCheckOutCompleteButton);
    }

    public void checkOutAsGuestWithCheckMoney(Customer customer, State state) {
        new CartPage(getDriver()).clickCheckOut();
        new RegisterLoginPage(getDriver()).checkOutAsGuest();
        firstNameLastNameEmailEntered(customer);
        addressAndPhoneNumberEntered(customer, state);
        continueWithCheckMoneyOrder();
    }

    public void checkOutAsGuestWithCreditCard(String card, String expirationMonthDate, String expirationYearDate, Customer customer, State state) {
        new CartPage(getDriver()).clickCheckOut();
        new RegisterLoginPage(getDriver()).checkOutAsGuest();
        firstNameLastNameEmailEntered(customer);
        addressAndPhoneNumberEntered(customer, state);
        continueWithCreditCard(card, expirationMonthDate, expirationYearDate, customer);
        clickConfirmCheckOutCompleteButton();
    }

    public void regUserCheckMoneyCheckout(Customer customer, State state) {
        addressAndPhoneNumberEntered(customer, state);
        continueWithCheckMoneyOrder();
    }

    public void regUserCCCheckout(String card, String expirationMonthDate, String expirationYearDate, Customer customer, State state) {
        copyText(billingFirstNameField);
        copyText(billingLastNameField);
        selectCountryAndState(state);
        addressAndPhoneNumberEntered(customer, state);
        continueWithCreditCard(card, expirationMonthDate, expirationYearDate, customer);
        clickConfirmCheckOutCompleteButton();
    }

    public void continueWithCheckMoneyOrder() {
        List<WebElement> click = Arrays.asList(continueToShippingButton, continueToPaymentButton, checkMoneyOrderRadioButton, continueToPaymentInfoButton, continueToConfirmOrderButton, confirmCheckOutCompleteButton);
        for (WebElement clickAll : click) {
            click(clickAll);
        }
    }

    public void continueWithCreditCard(String card, String expirationMonthDate, String expirationYearDate, Customer customer) {
        List<WebElement> click = Arrays.asList(continueToShippingButton, continueToPaymentButton, creditCardRadioButton, continueToPaymentInfoButton);
        for (WebElement clickAll:click) {
            click(clickAll);
        }
        selectFromDropdown(selectCreditCard, card);
        List<String> cardHolder = of(customer.getFirstName() + " " + customer.getLastName(), new ConnectDB().readMysqlDataBaseColumn(CC.CC_TABLE.getCcCredentials(), CC.CC_NUMBER.getCcCredentials()).toString());
        List<WebElement> cardHolderElements = Arrays.asList(cardHolderNameField, cardNumberField);
        for (int i = 0; i < cardHolder.size(); i++) {
            type(cardHolderElements.get(i), cardHolder.get(i).replace("[", "").replace("]", ""));
        }
        selectFromDropdown(selectMonthExpirationDate, expirationMonthDate);
        selectFromDropdown(selectYearExpirationDate, expirationYearDate);
        type(cardCodeField, new ConnectDB().readMysqlDataBaseColumn(CC.CC_TABLE.getCcCredentials(), CC.CC_CODE.getCcCredentials()).toString().replace("[", ""));
        click(continueToConfirmOrderButton);
    }

    public void firstNameLastNameEmailEntered(Customer customer) {
        List<String> billingFields = Arrays.asList(customer.getFirstName(), customer.getLastName(), customer.getEmail());
        List<WebElement> billingFieldsElements = Arrays.asList(billingFirstNameField, billingLastNameField, billingEmailField);
        for (int i = 0; i < billingFields.size(); i++) {
            type(billingFieldsElements.get(i), billingFields.get(i));
        }
    }

    public void addressAndPhoneNumberEntered(Customer customer, State state) {
        selectCountryAndState(state);
        List<String> billingFields = Arrays.asList(customer.getCity(), customer.getAddress(), customer.getZipCode(), customer.getPhoneNumber());
        List<WebElement> billingFieldsElements = Arrays.asList(billingCityField, billingAddressField, billingZipCodeField, billingPhoneNumberField);
        for (int i = 0; i < billingFields.size(); i++) {
            type(billingFieldsElements.get(i), billingFields.get(i));
        }
    }

    public void selectCountryAndState(State state) {
        List<String> countryList = new ExcelReader(Excel.PATH.getExcel()).getEntireColumnForGivenHeader(Excel.SHEET.getExcel(), Excel.HEADER_NAME.getExcel());
        String randomCountry = countryList.get(new Random().nextInt(countryList.size()));
        selectFromDropdown(selectCountryDropDown, randomCountry);
        if (Country.UNITED_STATES.getCountry().equals(randomCountry) || Country.CANADA.getCountry().equals(randomCountry)) {
            selectFromDropdown(selectStateDropDown, state.getState());
        }
    }

    public void continueWithCreditCardOrCheckMoney(String card, String expirationMonthDate, String expirationYearDate, Customer customer) {
         continueWithCreditCard(card, expirationMonthDate, expirationYearDate, customer);
         clickConfirmCheckOutCompleteButton();
        if (wrongCardNumberIsDisplayed()) {
            List<WebElement> webElements = Arrays.asList(returnBackToCreditCard, checkMoneyOrderRadioButton, continueToPaymentInfoButton, continueToConfirmOrderButton, confirmCheckOutCompleteButton);
            for (WebElement clickAllWebElements:webElements) {
                click(clickAllWebElements);
            }
            return;
        }
    }
}