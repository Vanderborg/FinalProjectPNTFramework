
package luma.lumapages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class OrdersAndReturnsPage extends CommonAPI {

    @FindBy(css = "#oar-order-id")
    public WebElement orderIDField;

    @FindBy(css = "#oar-billing-lastname")
    public WebElement billingLastName;

    @FindBy(css = "#oar_email")
    public WebElement emailField;

    @FindBy(xpath = "//span[normalize-space()='Continue']")
    public WebElement continueBttn;

    @FindBy(xpath = "//span[normalize-space()='May 8, 2023']")
    public WebElement orderDate;

    Logger LOG = LogManager.getLogger(OrdersAndReturnsPage.class);

    public OrdersAndReturnsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyOrderDate() {
        LOG.info("Verifying if order date is displayed");
        return checkDisplayed(orderDate);
    }

    public void fillInOrderInfo() {
        String orderID = "000007519";
        String lastName = "Vanderborg";
        String email = "adamvanderborg@gmail.com";
        List<String> orderAndReturns = Arrays.asList(orderID, lastName, email);
        List<WebElement> orderAndReturnsWebElements = Arrays.asList(orderIDField, billingLastName, emailField);

        for (int i = 0; i < orderAndReturns.size(); i++) {
            String fieldValue = orderAndReturns.get(i);
            WebElement fieldElement = orderAndReturnsWebElements.get(i);
            LOG.info("Typing value: " + fieldValue + " into element: " + fieldElement.toString());
            type(fieldElement, fieldValue);
        }

        LOG.info("Clicking on continue button");
        click(continueBttn);
    }
}