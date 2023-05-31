package luma.lumapages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WhatsNewPage extends CommonAPI {

    @FindBy(xpath = "//a[@class='action tocart primary']//span[contains(text(),'Add to Cart')]")
    public WebElement addToCartFromWishListBttn;

    @FindBy(xpath = "//a[@class='action showcart']")
    public WebElement cartIcon;

    @FindBy(xpath = "//span[normalize-space()='View and Edit Cart']")
    public WebElement viewAndEditCart;

    Logger LOG = LogManager.getLogger(WhatsNewPage.class);

    public WhatsNewPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void addProductFromWishListToCart() {
        click(addToCartFromWishListBttn);
        LOG.info("Clicked on 'Add to Cart' button from Wishlist");
        waitFor(2);
        LOG.info("Waiting for 2 seconds");
        click(cartIcon);
        LOG.info("Clicked on Cart icon");
        click(viewAndEditCart);
        LOG.info("Clicked on 'View and Edit Cart'");
    }
}
