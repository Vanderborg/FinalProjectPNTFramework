package luma.lumapages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GearPage extends CommonAPI {

    @FindBy(xpath = "//ol[@class='items']//a[normalize-space()='Fitness Equipment']")
    public WebElement fitnessEquipmentTab;

    @FindBy(xpath = "//ol[@class='items']//a[normalize-space()='Bags']")
    public WebElement bags;

    @FindBy(css = "a[class='block-promo gear-equipment'] span[class='content']")
    public WebElement waterBottlePromoBlock;

    Logger LOG = LogManager.getLogger(GearPage.class);

    public GearPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void navigateToFitnessPage() {
        click(fitnessEquipmentTab);
        LOG.info("Clicked on Fitness Equipment Tab");
    }

    public void navigateToBagsPage() {
        click(bags);
        LOG.info("Clicked on Bags");
    }

    public void navigateToFitnessWaterBottle() {
        click(waterBottlePromoBlock);
        LOG.info("Clicked on Fitness Water Bottle Promo Block");
    }
}

