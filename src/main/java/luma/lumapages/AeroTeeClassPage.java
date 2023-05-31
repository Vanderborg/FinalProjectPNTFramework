package luma.lumapages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    Logger LOG = LogManager.getLogger(AeroTeeClassPage.class);

    public AeroTeeClassPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void addAeroTeeToCart() {
        click(sizeOptionLarge);
        LOG.info("Selected size option: Large");
        click(colorOptionYellow);
        LOG.info("Selected color option: Yellow");
        click(addAeroToCart);
        LOG.info("Clicked on 'Add to Cart' button");
        waitFor(2);
        click(aeroPageCartIcon);
        LOG.info("Clicked on Aero Tee Cart icon");
        waitFor(2);
        click(proceedToCheckoutBttn);
        LOG.info("Clicked on 'Proceed to Checkout' button");
    }
}
