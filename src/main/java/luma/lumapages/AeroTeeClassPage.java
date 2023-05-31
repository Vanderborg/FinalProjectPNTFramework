package lumapages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AeroTeeClassPage extends CommonAPI {

    @FindBy(css = "#option-label-size-143-item-169")
    public WebElement sizeOptionLarge;

    @FindBy(css = "#option-label-color-93-item-60")
    public WebElement colorOptionYellow;

    @FindBy(css = "button[id='product-addtocart-button'] span")
    public WebElement addAeroToCart;

    @FindBy(css = ".action.showcart")
    public WebElement aeroPageCartIcon;

    @FindBy(css = "#top-cart-btn-checkout")
    public WebElement proceedToCheckoutBttn;

    public AeroTeeClassPage(WebDriver driver) {PageFactory.initElements(driver, this);}

    public void addAeroTeeToCart() {
        click(sizeOptionLarge);
        click(colorOptionYellow);
        click(addAeroToCart);waitFor(2);
        click(aeroPageCartIcon);
        waitFor(2);
        click(proceedToCheckoutBttn);
    }
}
