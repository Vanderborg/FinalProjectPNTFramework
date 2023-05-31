package luma.lumapages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GearFitnessEquipmentPage extends CommonAPI {

    @FindBy(css = "img[alt='Sprite Yoga Companion Kit']")
    public WebElement spriteYogaCompanionKit;

    @FindBy(css = "img[alt='Affirm Water Bottle ']")
    public WebElement affirmWaterBottle;

    Logger LOG = LogManager.getLogger(GearFitnessEquipmentPage.class);

    public GearFitnessEquipmentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void navigateToBlueYogaBall() {
        click(spriteYogaCompanionKit);
        LOG.info("Clicked on Sprite Yoga Companion Kit");
    }

    public void navigateToAffirmWaterBottle() {
        click(affirmWaterBottle);
        LOG.info("Clicked on Affirm Water Bottle");
    }
}
