package lumapages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GearFitnessEquipmentPage extends CommonAPI {

    @FindBy(css = "img[alt='Sprite Yoga Companion Kit']")
    public WebElement spriteYogaCompanionKit;

public GearFitnessEquipmentPage(WebDriver driver) {PageFactory.initElements(driver, this);}

    public void navigateToBlueYogaBall() {
   click(spriteYogaCompanionKit);
    }
}
