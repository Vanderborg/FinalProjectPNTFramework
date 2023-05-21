package lumapages;

import base.CommonAPI;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class ShippingPage extends CommonAPI {

    @FindBy(css = "input[value='tablerate_bestway']")
    public WebElement freeShippingOption;

    @FindBy(css = ".button.action.continue.primary")
    public WebElement continueToPaymentBttn;

    @FindBy(css = "#U7NKY3S")
    public WebElement shippingFirstName;

    @FindBy(css = "#DVIGRGJ")
    public WebElement shippingLastName;

    @FindBy(css = "#XVNG400")
    public WebElement shippingAddress;

    @FindBy(css = "#NUFLGLT")
    public WebElement shippingCity;

    @FindBy(css = "#BDADI2M")
    public WebElement shippingState;

    @FindBy(css = "#TMDDUN0")
    public WebElement shippingZipCode;

    @FindBy(css = "#U0WCRMQ")
    public WebElement shippingCountry;

    @FindBy(css = "#WMV94QK")
    public WebElement shippingPhoneNumber;

    @FindBy(css = "input[value='flatrate_flatrate']")
    public WebElement shippingFlatRateBttn;

    @FindBy(id = "customer-email")
    public WebElement customerEmailField;

    public ShippingPage(WebDriver driver) {PageFactory.initElements(driver,this);}

    public void shippingSelection(){click(freeShippingOption);click(continueToPaymentBttn);
    }

    public void fillOutShippingInfo() {
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
        type(customerEmailField, email);
        waitFor(2);
        List<String> shippingFields = Arrays.asList(firstName, lastName, address, city);
        List<WebElement> shippingElements = Arrays.asList(shippingFirstName, shippingLastName, shippingAddress, shippingCity);
        for (int i = 0; i <shippingFields.size() ; i++) {
            type(shippingElements.get(i), shippingFields.get(i));
        }
        selectFromDropdown(shippingState, state);
        type(shippingZipCode, zipCode);
        type(shippingPhoneNumber, phone);
    }
}
