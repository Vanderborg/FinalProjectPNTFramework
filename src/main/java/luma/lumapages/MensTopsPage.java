package luma.lumapages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MensTopsPage extends CommonAPI {

    @FindBy(css = "img[alt='Sinbad Fitness Tank']")
    public WebElement blueTankTop;

    @FindBy(xpath = "//div[normalize-space()='Category']")
    public WebElement dropDownCategory;

    @FindBy(xpath = "//a[contains(text(),'Tees')]")
    public WebElement dropDownTeeCategory;

    Logger LOG = LogManager.getLogger(MensTopsPage.class);

    public MensTopsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void goToSinbadTankTop() {
        LOG.info("Clicking on Sinbad Tank Top");
        blueTankTop.click();
    }

    public void goToTees() {
        doubleClick(dropDownCategory,dropDownTeeCategory);
        LOG.info("Clicks on dropDownCategory twice");
    }
}
