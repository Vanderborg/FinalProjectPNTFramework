package luma.lumapages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GearBagsPage extends CommonAPI {

    @FindBy(xpath = "//div[normalize-space()='Strap/Handle']")
    public WebElement strapAndHandleOptions;

    @FindBy(css = "a[href='https://magento.softwaretestingboard.com/gear/bags.html?strap_bags=66']")
    public WebElement shoulderOption;

    @FindBy(css = "img[alt='Strive Shoulder Pack']")
    public WebElement striveShoulderBag;

    @FindBy(xpath = "//div[4]//div[3]//div[1]//select[1]")
    public WebElement itemDisplayLimiter;

    @FindBy(xpath = "//div[@class='page-wrapper']//div[2]//p[1]")
    public WebElement quantitiesChangedSuccess;

    Logger LOG = LogManager.getLogger(GearBagsPage.class);

    public GearBagsPage(WebDriver driver) {PageFactory.initElements(driver, this);}

    public boolean verifyItemQuantitiesShownChanged() {
        LOG.info("Verifying if item quantities shown changed");
        return checkDisplayed(quantitiesChangedSuccess);
    }

    public void navigateToShoulderOptionAndSelectStriveBag() {
        click(strapAndHandleOptions);
        LOG.info("Clicked on strap and handle options");
        click(shoulderOption);
        LOG.info("Clicked on shoulder option");
        click(striveShoulderBag);
        LOG.info("Clicked on Strive shoulder bag");
    }

    public void changeQuantityOfItemsDisplayed() {
        LOG.info("Changing quantity of items displayed");
        selectFromDropdown(itemDisplayLimiter, "24");
    }

}
