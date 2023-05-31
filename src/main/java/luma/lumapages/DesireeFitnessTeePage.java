
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

public class DesireeFitnessTeePage extends CommonAPI {

    @FindBy(css = "#option-label-size-143-item-170")
    public WebElement sizeOptionXL;

    @FindBy(css = "#option-label-color-93-item-49")
    public WebElement colorOptionBlack;

    @FindBy(css = "#qty")
    public WebElement quantityBox;

    @FindBy(css = "#product-addtocart-button")
    public WebElement addToCartBttn;

    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    public WebElement cartLink;

    @FindBy(css = "#product-updatecart-button")
    public WebElement updateCartBttn;

    @FindBy(css = "a[class='action tocompare'] span")
    public WebElement addToComparisonListIcon;

    Logger LOG = LogManager.getLogger(DesireeFitnessTeePage.class);

    public DesireeFitnessTeePage(WebDriver driver) {PageFactory.initElements(driver, this);}

    public void addDesireeFitnessTeeToCart() {
        List<WebElement> click = Arrays.asList(sizeOptionXL, colorOptionBlack);
        for (WebElement clickAll : click) {
            click(clickAll);
            LOG.info("Clicked on size option XL and color option Black");
        }
        waitFor(1);
        LOG.info("Waited for 1 second");
        click(addToCartBttn);
        LOG.info("Clicked on Add to Cart button");
        waitFor(1);
        LOG.info("Waited for 1 second");
        click(cartLink);
        LOG.info("Clicked on Cart link");
    }

    public void adjustQuantity() {
        doubleClick(sizeOptionXL, sizeOptionXL);
        LOG.info("Double-clicked on size option XL");
        waitFor(1);
        LOG.info("Waited for 1 second");
        clear(quantityBox);
        LOG.info("Cleared the quantity box");
        type(quantityBox, "4");
        LOG.info("Entered quantity 4");
        waitFor(1);
        LOG.info("Waited for 1 second");
        click(updateCartBttn);
        LOG.info("Clicked on Update Cart button");
    }

    public void addDesireeTeeToComparisonList() {
        click(addToComparisonListIcon);
        LOG.info("Clicked on Add to Comparison List icon");
    }

}