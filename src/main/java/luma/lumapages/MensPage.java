
package luma.lumapages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MensPage extends CommonAPI {

    @FindBy(xpath = "//a[contains(text(),'Tops')]")
    public WebElement topsLink;

    Logger LOG = LogManager.getLogger(MensPage.class);

    public MensPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void navigateToTops() {
        LOG.info("Clicking on Tops link");
        click(topsLink);
    }
}
