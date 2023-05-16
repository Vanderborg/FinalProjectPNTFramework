package lumapages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SinbadFitnessTankTopPage extends CommonAPI {

    @FindBy(css = "#option-label-size-143-item-169")
    public WebElement largeSizeOption;

    @FindBy(css = "#option-label-color-93-item-50")
    public WebElement blueColorOption;

    @FindBy(css = "#product-addtocart-button")
    public WebElement addToCartBttn;

    @FindBy(css = ".message-success.success.message")
    public WebElement addedToCartSuccess;

    @FindBy(css = "div[class='product-addto-links'] a[class='action tocompare'] span")
    public WebElement addToComparisonListIcon;

    @FindBy(css = "a[href='https://magento.softwaretestingboard.com/catalog/product_compare/']")
    public WebElement comparisonListLink;

    @FindBy(css = ".base")
    public WebElement addedToComparisonListSuccess;

    public SinbadFitnessTankTopPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public boolean verifyAddedToCart() {return checkDisplayed(addedToCartSuccess);}

    public boolean verifyAddedToComparisonList() {return checkDisplayed(addedToComparisonListSuccess);}

    public void sinbadTankTopAddToCart() {
        click(largeSizeOption);
        click(blueColorOption);
        for (int i = 0; i < 2; i++) {
            waitFor(2);
            click(addToCartBttn);

        }
        waitFor(4);
    }

    public void addTankToComparisonList() {
        click(addToComparisonListIcon);
        click(comparisonListLink);
        waitFor(5);
    }
}
