package luma.lumapages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    Logger LOG = LogManager.getLogger(SinbadFitnessTankTopPage.class);

    public SinbadFitnessTankTopPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyAddedToCart() {
        LOG.info("Verifying if item is added to cart");
        return checkDisplayed(addedToCartSuccess);
    }

    public boolean verifyAddedToComparisonList() {
        LOG.info("Verifying if item is added to comparison list");
        return checkDisplayed(addedToComparisonListSuccess);
    }

    public void sinbadTankTopAddToCart() {
        click(largeSizeOption);
        LOG.info("Clicked on Large size option");
        click(blueColorOption);
        LOG.info("Clicked on Blue color option");
        for (int i = 0; i < 2; i++) {
            waitFor(2);
            LOG.info("Waiting for 2 seconds");
            click(addToCartBttn);
            LOG.info("Clicked on Add to Cart button");
        }
        waitFor(4);
        LOG.info("Waiting for 4 seconds");
    }

    public void addTankToComparisonList() {
        click(addToComparisonListIcon);
        LOG.info("Clicked on Add to Comparison List icon");
        click(comparisonListLink);
        LOG.info("Clicked on Comparison List link");
        waitFor(5);
        LOG.info("Waiting for 5 seconds");
    }
}
