package lumapages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.seleniumhq.jetty9.util.ssl.X509;

public class CheckOutSuccessPage extends CommonAPI {

    @FindBy(xpath = "//div[@class='page-wrapper']//p[1]")
    public WebElement orderConfirmationSuccess;

    @FindBy(xpath = "//a[normalize-space()='Print receipt']")
    public WebElement printOrderReceiptBttn;

    public CheckOutSuccessPage(WebDriver driver){PageFactory.initElements(driver,this);}

    public boolean verifyCheckOutSuccess(){return checkDisplayed(orderConfirmationSuccess);}

    public boolean verifyReceiptFromOrder(){return checkDisplayed(printOrderReceiptBttn);}
}
