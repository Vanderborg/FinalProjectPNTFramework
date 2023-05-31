package nopcommerce.nopcommercepages;

import base.CommonAPI;
import nopcommerce.nopcommerceobjects.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class ContactUsPage extends CommonAPI {

    @FindBy(css = "#FullName")
    public WebElement inputNameField;

    @FindBy(css = "#Email")
    public WebElement inputEmailField;

    @FindBy(css = "#Enquiry")
    public WebElement inputEnquiryField;

    @FindBy(css = ".button-1.contact-us-button")
    public WebElement clickSubmitButton;

    @FindBy(css = ".result")
    public WebElement enquiryHasBeenAdded;

    Logger LOG = LogManager.getLogger(ContactUsPage.class.getName());

    public ContactUsPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public boolean verifyEnquiryIsAdded() {
        LOG.info("Enquiry has been added");
        return checkDisplayed(enquiryHasBeenAdded);
    }

    public void contactUsNopCommerce(Customer customer) {
        new NopCommerceHomePage(getDriver()).clickContactUsLink();
        LOG.info("Enquiry has been added");
        List<String> input = Arrays.asList(customer.getDBZName(), customer.getEmail(), customer.getMessage());
        List<WebElement> webElementsInput = Arrays.asList(inputNameField, inputEmailField, inputEnquiryField);
        for (int i = 0; i <input.size() ; i++) {
            type(webElementsInput.get(i), input.get(i) );
            LOG.info("Typed name, email, enquiry field");
        }
        click(clickSubmitButton);
        LOG.info("Clicked submit button");
    }
}
