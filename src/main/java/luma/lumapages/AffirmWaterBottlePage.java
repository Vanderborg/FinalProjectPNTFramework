
package luma.lumapages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AffirmWaterBottlePage extends CommonAPI {

    @FindBy(css = "button[id='product-addtocart-button'] span")
    public WebElement addWaterBottleToCart;

    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    public WebElement navigateToShoppingCart;

    Logger LOG = LogManager.getLogger(AffirmWaterBottlePage.class);

    public AffirmWaterBottlePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void addAffirmBottleToCart() {
        waitFor(2);
        click(addWaterBottleToCart);
        LOG.info("Clicked on 'Add to Cart' button");
        click(navigateToShoppingCart);
        LOG.info("Clicked on 'Shopping Cart' link");
    }
}
