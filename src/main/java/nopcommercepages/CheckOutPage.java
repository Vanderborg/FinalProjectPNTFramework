package nopcommercepages;

import base.CommonAPI;
import com.github.javafaker.Faker;
import nopcommerceenums.country.Country;
import nopcommerceenums.creditcard.CC;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utility.ConnectDB;
import utility.ExcelReader;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

    @FindBy(css = "li[class='payment-method'] span[class='value']")
    public WebElement creditCardIsDisplayed;

    @FindBy(css = "button.button-1.confirm-order-button")
    public WebElement hopefullyConfirmOrderButton;

    public CheckOutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean creditCardPaymentIsDisplayed() {
        return checkDisplayed(creditCardIsDisplayed);
    }

    private boolean wrongCardNumberIsDisplayed() {
        return checkDisplayed(wrongCardNumberText);
    }

    public void checkOutAsGuestWithCheckMoney() {
        CartPage cart = new CartPage(getDriver());
        RegisterLoginPage guest = new RegisterLoginPage(getDriver());
        cart.clickCheckOut();
        guest.checkOutAsGuest();
        firstNameLastNameEmailEntered();
        addressAndPhoneNumberEntered();
        continueWithCheckMoneyOrder();
    }

    public void checkOutAsGuestWithCreditCard(String card, String expirationMonthDate, String expirationYearDate) {
        CartPage cart = new CartPage(getDriver());
        RegisterLoginPage guest = new RegisterLoginPage(getDriver());
        cart.clickCheckOut();
        guest.checkOutAsGuest();
        firstNameLastNameEmailEntered();
        addressAndPhoneNumberEntered();
        continueWithCreditCard(card, expirationMonthDate, expirationYearDate);
    }

    public void registeredUserCheckMoneyCheckout() {
        addressAndPhoneNumberEntered();
        continueWithCheckMoneyOrder();
    }

    public void registeredUserCreditCardCheckout(String card, String expirationMonthDate, String expirationYearDate) {
        copyText(billingFirstNameField);
        try {
            String billingFirstName = Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor).toString();
        } catch (UnsupportedFlavorException | IOException e) {
            throw new RuntimeException(e);
        }
        copyText(billingLastNameField);
        try {
            String billingLastName = Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor).toString();
        } catch (UnsupportedFlavorException | IOException e) {
            throw new RuntimeException(e);
        }
        selectCountryAndState();
        addressAndPhoneNumberEntered();
        continueWithCreditCard(card, expirationMonthDate, expirationYearDate);
    }

    public void continueWithCheckMoneyOrder() {
        List<WebElement> click = Arrays.asList(continueToShippingButton, continueToPaymentButton, checkMoneyOrderRadioButton, continueToPaymentInfoButton, continueToConfirmOrderButton, confirmCheckOutCompleteButton);
        for (WebElement clickAll : click) {
            click(clickAll);
        }
    }

    public void continueWithCreditCard(String card, String expirationMonthDate, String expirationYearDate) {
        ConnectDB connectDB = new ConnectDB();
        String firstName = new Faker().name().firstName();
        String lastName = new Faker().name().lastName();
        List<WebElement> click = Arrays.asList(continueToShippingButton, continueToPaymentButton, creditCardRadioButton, continueToPaymentInfoButton);
        for (WebElement clickAll:click) {
            click(clickAll);
        }
        selectFromDropdown(selectCreditCard, card);
        List<String> cardHolder = List.of(firstName + " " + lastName, connectDB.readMysqlDataBaseColumn(CC.CC_TABLE.getCcCredentials(), CC.CC_NUMBER.getCcCredentials()).toString());
        List<WebElement> cardHolderElements = Arrays.asList(cardHolderNameField, cardNumberField);
        for (int i = 0; i < cardHolder.size(); i++) {
            type(cardHolderElements.get(i), cardHolder.get(i).replace("[", "").replace("]", ""));
        }
        selectFromDropdown(selectMonthExpirationDate, expirationMonthDate);
        selectFromDropdown(selectYearExpirationDate, expirationYearDate);
        type(cardCodeField, connectDB.readMysqlDataBaseColumn(CC.CC_TABLE.getCcCredentials(), CC.CC_CODE.getCcCredentials()).toString().replace("[", ""));
        click(continueToConfirmOrderButton);
        Assert.assertTrue(creditCardPaymentIsDisplayed());
        click(confirmCheckOutCompleteButton);
    }

    public void firstNameLastNameEmailEntered() {
        String firstName = new Faker().name().firstName();
        String lastName = new Faker().name().lastName();
        String email = new Faker().bothify("????????###@gmail.com");
        List<String> billingFields = Arrays.asList(firstName, lastName, email);
        List<WebElement> billingFieldsElements = Arrays.asList(billingFirstNameField, billingLastNameField, billingEmailField);
        for (int i = 0; i < billingFields.size(); i++) {
            type(billingFieldsElements.get(i), billingFields.get(i));
        }
    }

    public void addressAndPhoneNumberEntered() {
        String city = new Faker().address().city();
        String address = new Faker().address().streetAddress();
        String zipCode = new Faker().address().zipCode();
        String phone = new Faker().phoneNumber().cellPhone();
        selectCountryAndState();
        List<String> billingFields = Arrays.asList(city, address, zipCode, phone);
        List<WebElement> billingFieldsElements = Arrays.asList(billingCityField, billingAddressField, billingZipCodeField, billingPhoneNumberField);
        for (int i = 0; i < billingFields.size(); i++) {
            type(billingFieldsElements.get(i), billingFields.get(i));
        }
    }

    public void selectCountryAndState() {
        String path = "C:\\Users\\MSI - Laptop\\Downloads\\Country (1).xlsx";
        ExcelReader excel = new ExcelReader(path);
        List<String> countryList = excel.getEntireColumnForGivenHeader("Sheet1", "Country");
        String randomCountry = countryList.get(new Random().nextInt(countryList.size()));
        int index = countryList.indexOf(randomCountry);
        String state = new Faker().address().state();
        selectFromDropdown(selectCountryDropDown, randomCountry);
        if (Country.UNITED_STATES.getCountry().equals(randomCountry) || Country.CANADA.getCountry().equals(randomCountry)) {
            selectFromDropdown(selectStateDropDown, state);
        }
    }

    public void enterCCFields() {

    }

    public void continueWithCreditCardOrCheckMoney(String card, String expirationMonthDate, String expirationYearDate) {
        String firstName = new Faker().name().firstName();
        String lastName = new Faker().name().lastName();
        String cardNumber = new Faker().bothify("###################");
        String cardCode = new Faker().numerify("####");
        List<WebElement> click = Arrays.asList(continueToShippingButton, continueToPaymentButton, creditCardRadioButton, continueToPaymentInfoButton);
        for (WebElement clickAll:click) {
            click(clickAll);
        }
        selectFromDropdown(selectCreditCard, card);
        List<String> cardHolder = List.of(firstName + " " + lastName, cardNumber);
        List<WebElement> cardHolderElements = Arrays.asList(cardHolderNameField, cardNumberField);
        for (int i = 0; i < cardHolder.size(); i++) {
            type(cardHolderElements.get(i), cardHolder.get(i));
        }
        selectFromDropdown(selectMonthExpirationDate, expirationMonthDate);
        selectFromDropdown(selectYearExpirationDate, expirationYearDate);
        type(cardCodeField, cardCode);
        click(continueToConfirmOrderButton);
        if (wrongCardNumberIsDisplayed()) {
            List<WebElement> webElements = Arrays.asList(returnBackToCreditCard, checkMoneyOrderRadioButton, continueToPaymentInfoButton, continueToConfirmOrderButton, confirmCheckOutCompleteButton);
            for (WebElement clickAllWebElements:webElements) {
                click(clickAllWebElements);
            }
            return;
        }
    }
}