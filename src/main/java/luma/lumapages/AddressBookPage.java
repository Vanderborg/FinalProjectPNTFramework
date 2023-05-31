
package luma.lumapages;

import base.CommonAPI;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class AddressBookPage extends CommonAPI {

    @FindBy(xpath = "//span[normalize-space()='Change Billing Address']")
    public WebElement changeBillingAddress;

    @FindBy(css = "#telephone")
    public WebElement addTelephoneField;

    @FindBy(css = "#street_1")
    public WebElement addStreetField;

    @FindBy(css = "#city")
    public WebElement addCityField;

    @FindBy(css = "#region_id")
    public WebElement addStateField;

    @FindBy(css = "#zip")
    public WebElement addZipcodeField;

    @FindBy(xpath = "//span[normalize-space()='Save Address']")
    public WebElement saveInfoBttn;

    @FindBy(css = ".message-success.success.message")
    public WebElement billingAddressChangedSuccess;

    Logger LOG = LogManager.getLogger(AddressBookPage.class);

    public AddressBookPage(WebDriver driver) {PageFactory.initElements(driver, this);}

    public boolean verifyBillingAddressChanged() {
        LOG.info("Billing address changed successfully");
        return checkDisplayed(billingAddressChangedSuccess);
    }

    public void addAddressToProfile() {
        String telephone = new Faker().phoneNumber().cellPhone();
        String street = new Faker().address().streetAddress();
        String city = new Faker().address().city();
        String zipcode = new Faker().address().zipCode();
        String state = new Faker().address().state();
        List<String> profileAddressField = Arrays.asList(telephone, street, city, zipcode);
        List<WebElement> profileAddressFieldElements = Arrays.asList(addTelephoneField, addStreetField, addCityField, addZipcodeField);
        for (int i = 0; i < profileAddressField.size(); i++) {
            type(profileAddressFieldElements.get(i), profileAddressField.get(i));
            selectFromDropdown(addStateField, state);
            click(saveInfoBttn);
        }
        LOG.info("Address added to profile");
    }

    public void navigateToChangeBillingAddress() {
        click(changeBillingAddress);
        LOG.info("Change billing address link is clicked");
    }

    public void changeCurrentBillingAddress() {
        navigateToChangeBillingAddress();
        String telephone = new Faker().phoneNumber().cellPhone();
        String street = new Faker().address().streetAddress();
        String city = new Faker().address().city();
        String zipcode = new Faker().address().zipCode();
        String state = new Faker().address().state();
        List<String> profileAddressField = Arrays.asList(telephone, street, city, zipcode);
        List<WebElement> profileAddressFieldElements = Arrays.asList(addTelephoneField, addStreetField, addCityField, addZipcodeField);
        for (int i = 0; i < profileAddressField.size(); i++) {
            clear(profileAddressFieldElements.get(i));
            LOG.info("The text fields are cleared by using a for loop to iterate through each one stored in a list");
        }
        List<String> profileAddressFieldType = Arrays.asList(telephone, street, city, zipcode);
        List<WebElement> profileAddressFieldElementsType = Arrays.asList(addTelephoneField, addStreetField, addCityField, addZipcodeField);
        for (int i = 0; i < profileAddressField.size(); i++) {
            type(profileAddressFieldElementsType.get(i), profileAddressFieldType.get(i));
            LOG.info("The text fields are typed in by using a for loop to iterate through each from the stored information in the list");
        }
        selectFromDropdown(addStateField, state);
        click(saveInfoBttn);
        LOG.info("Current billing address changed");
    }
}