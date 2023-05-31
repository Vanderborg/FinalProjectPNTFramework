
package luma.lumapages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomensSalePage extends CommonAPI {

    @FindBy(xpath = "//div[2]//div[4]//select[1]")
    public WebElement sortByDropDown;

    @FindBy(xpath = "//div[@class='column main']//div[2]//div[4]//a[1]")
    public WebElement descendingOrderBttn;

    @FindBy(css = "img[alt='Olivia 1/4 Zip Light Jacket']")
    public WebElement oliviaZipJacket;

    Logger LOG = LogManager.getLogger(WomensSalePage.class);

    public WomensSalePage(WebDriver driver) {PageFactory.initElements(driver, this);}

    public void navigateToOliviaZipJacket() {
        selectFromDropdown(sortByDropDown, "Price");
        LOG.info("Selected 'Price' from Sort By dropdown");
        click(descendingOrderBttn);
        LOG.info("Clicked on Descending Order button");
        click(oliviaZipJacket);
        LOG.info("Clicked on Olivia Zip Jacket");
    }
}
