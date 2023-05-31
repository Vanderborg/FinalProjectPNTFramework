package luma.lumapages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MensTeesPage extends CommonAPI {

    @FindBy(css = "img[alt='Strike Endurance Tee']")
    public WebElement strikeEnduranceTee;

    Logger LOG = LogManager.getLogger(MensTeesPage.class);

    public MensTeesPage(WebDriver driver) {PageFactory.initElements(driver, this);}

    public void goToStrikeEnudranceTee() {
        LOG.info("Clicking on Strike Endurance Tee");
        click(strikeEnduranceTee);
    }
}
