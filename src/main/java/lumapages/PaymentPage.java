package lumapages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends CommonAPI {

    @FindBy(css = "button[title='Place Order']")
    public WebElement placeOrderBttn;

    public PaymentPage(WebDriver driver){PageFactory.initElements(driver, this);}

    public void placeOrder() {
        waitFor(2);click(placeOrderBttn);

        waitFor(10);
    }
}
