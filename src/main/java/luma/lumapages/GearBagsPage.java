package lumapages;

import base.CommonAPI;
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

    public GearBagsPage(WebDriver driver) {PageFactory.initElements(driver, this);}

    public boolean verifyItemQuanititesShownChanged() {return checkDisplayed(quantitiesChangedSuccess);}

    public void navigateToShoulderOption() {click(strapAndHandleOptions);click(shoulderOption);}

    public void goToStriveBag() { click(striveShoulderBag);}

    public void changeQuantityOfItemsDisplayed() {
        selectFromDropdown(itemDisplayLimiter, "24");
    }
}
