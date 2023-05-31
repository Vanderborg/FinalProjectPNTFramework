
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

public class OliviaZipJacketPage extends CommonAPI {

    @FindBy(css = "#option-label-color-93-item-49")
    public WebElement colorOptionBlack;

    @FindBy(css = "#option-label-size-143-item-170")
    public WebElement sizeOptionXtraLarge;

    @FindBy(css = "#qty")
    public WebElement quantityBox;

    @FindBy(css = "#product-addtocart-button")
    public WebElement addToCartBttn;

    @FindBy(css = "#product-updatecart-button")
    public WebElement updateCartBttn;

    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    public WebElement cartLink;

    Logger LOG = LogManager.getLogger(OliviaZipJacketPage.class);

    public OliviaZipJacketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void addOliviaZipJacketToCart() {
        List<WebElement> clickElements = Arrays.asList(sizeOptionXtraLarge, colorOptionBlack);
        for (WebElement element : clickElements) {
            click(element);
            LOG.info("Clicked on element: " + element.getText());
            waitFor(1);
            LOG.info("Waited for 1 second");
        }
        waitFor(1);
        LOG.info("Waited for 1 second");
        clearAndType(quantityBox, "4");
        LOG.info("Cleared and typed into quantity box: 4");
        waitFor(1);
        LOG.info("Waited for 1 second");
        click(updateCartBttn);
        LOG.info("Clicked on 'Update Cart' button");
        waitFor(1);
        LOG.info("Waited for 1 second");
        click(cartLink);
        LOG.info("Clicked on 'Cart' link");
    }

    public void adjustQuantity() {
        waitFor(1);
        LOG.info("Waiting for 1 second");
        clearAndType(quantityBox,"4");
        LOG.info("Clearing quantity box and type 4 in the text field");
        waitFor(1);
        LOG.info("Waiting for 1 second");
        click(updateCartBttn);
        LOG.info("Clicking on 'Update Cart' button");
    }
}
