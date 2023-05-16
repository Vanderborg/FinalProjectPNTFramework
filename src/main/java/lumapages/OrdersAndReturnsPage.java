package lumapages;

import base.CommonAPI;
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

    public OrdersAndReturnsPage(WebDriver driver) {PageFactory.initElements(driver, this);}

    public void fillInOrderInfo() {
        String orderID = "000007519";
        String lastName = "Vanderborg";
        String email= "adamvanderborg@gmail.com";
        List<String>orderAndReturns= Arrays.asList(orderID,lastName, email);
        List<WebElement>orderAndReturnsWebElements= Arrays.asList(orderIDField,billingLastName, emailField);
        for (int i = 0; i < orderAndReturns.size(); i++) {
           type(orderAndReturnsWebElements.get(i),orderAndReturns.get(i));
        }
        click(continueBttn);
    }
}
