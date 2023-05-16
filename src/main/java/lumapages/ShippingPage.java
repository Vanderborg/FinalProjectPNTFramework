package lumapages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage extends CommonAPI {

    @FindBy(css = "input[value='tablerate_bestway']")
    public WebElement freeShippingOption;

    @FindBy(css = ".button.action.continue.primary")
    public WebElement continueToPaymentBttn;

    public ShippingPage(WebDriver driver) {PageFactory.initElements(driver,this);}

    public void shippingSelection(){click(freeShippingOption);click(continueToPaymentBttn);

    }
}
