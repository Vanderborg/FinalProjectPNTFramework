
package luma.lumapages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LumaSalePage extends CommonAPI {

    @FindBy(css = ".more.button")
    public WebElement shopWomensDeals;

    @FindBy(xpath = "//span[normalize-space()='Shop Luma Gear']")
    public WebElement shopGearDeals;

    Logger LOG = LogManager.getLogger(LumaSalePage.class);

    public LumaSalePage(WebDriver driver) {PageFactory.initElements(driver,this);}

    public void navigateToWomensDeals() {
        LOG.info("Clicking on Women's Deals");
        click(shopWomensDeals);
    }

    public void navigateToGearDeals() {
        LOG.info("Clicking on Gear Deals");
        click(shopGearDeals);
    }

}
