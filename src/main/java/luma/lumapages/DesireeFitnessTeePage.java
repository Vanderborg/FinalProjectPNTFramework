package lumapages;

import base.CommonAPI;
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

    public DesireeFitnessTeePage(WebDriver driver) {PageFactory.initElements(driver, this);}

    public void addDesireeFitnessTeeToCart() {
        List<WebElement> click = Arrays.asList(sizeOptionXL, colorOptionBlack);
        for (WebElement clickAll:click) {
            click(clickAll);
        }
        waitFor(1);
        click(addToCartBttn);
        waitFor(1);
        click(cartLink);
    }

    public void adjustQuantity() {
        doubleClick(sizeOptionXL, sizeOptionXL);
        waitFor(1);
        clear(quantityBox);
        type(quantityBox,"4");
        waitFor(1);
        click(updateCartBttn);
    }

    public void addDesireeTeeToComparisonList() {
        click(addToComparisonListIcon);
    }
}