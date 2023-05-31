package luma.lumapages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomensTeesPage extends CommonAPI {

    @FindBy(css = "img[alt='Desiree Fitness Tee']")
    public WebElement desireeFitnessTee;

    @FindBy(xpath = "//div[2]//div[3]//select[1]")
    public WebElement sortByDropDown;

    @FindBy(xpath = "//span[contains(text(),'$42.00')]")
    public WebElement highestPriceItem;

    @FindBy(xpath = "//div[@class='column main']//div[2]//div[3]//a[1]")
    public WebElement ascendingOrderBttn;

    Logger LOG = LogManager.getLogger(WomensTeesPage.class);

    public WomensTeesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean sortByPriceSuccess() {
        LOG.info("Verifying if sorting by price is successful");
        return checkDisplayed(highestPriceItem);
    }

    public void navigateToDesireeTee() {
        click(desireeFitnessTee);
        LOG.info("Navigating to Desiree Tee");
    }

    public void priceFromSortBy() {
        selectFromDropdown(sortByDropDown, "Price");
        LOG.info("Selected 'Price' from Sort By dropdown");
        click(ascendingOrderBttn);
        LOG.info("Clicked on Ascending Order button");
    }
}
