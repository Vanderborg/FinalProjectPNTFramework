package lumapages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends CommonAPI {

    @FindBy(xpath = "//a[@class='action action-delete']")
    public WebElement trashCanIcon;

    @FindBy(xpath = "//a[@aria-label='store logo']//img")
    public WebElement lumaHomeIcon;

    @FindBy(css = ".control.qty")
    public WebElement cartQuantityBox;

    @FindBy(css = "button[title='Proceed to Checkout'] span")
    public WebElement checkOutBttn;

    @FindBy(css = "a[title='Edit item parameters']")
    public WebElement pencilIcon;

    @FindBy(xpath = "//p[normalize-space()='You have no items in your shopping cart.']")
    public WebElement removalOfItemsFromCartSuccess;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyRemovalOfCartItems() {return checkDisplayed(removalOfItemsFromCartSuccess);}

    Logger log = LogManager.getLogger(CartPage.class.getName());

    public void deleteItemInCart() {
        click(trashCanIcon);
    }

    public void adjustItemsInCart() {
        click(pencilIcon);
//        waitFor(3);
//        doubleClick(cartQuantityBox,cartQuantityBox);clearAndType(cartQuantityBox,"4");
    }
        public void navigateToCheckout() {
            waitFor(1);
            click(checkOutBttn);
        }
    }


