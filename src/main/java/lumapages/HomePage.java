package lumapages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonAPI {

    @FindBy(css = "div[class='panel header'] li[data-label='or'] a")
    public WebElement signInBttn;

    @FindBy(css = "#ui-id-5")
    public WebElement mensDropdownMenu;

    @FindBy(css = "#newsletter")
    public WebElement newsletterSignUpBox;

    @FindBy(css = "button[title='Subscribe'] span")
    public WebElement subscribeNewsletterBttn;

    @FindBy(css = "a[href='https://magento.softwaretestingboard.com/sales/guest/form/']")
    public WebElement ordersAndReturns;

    @FindBy(xpath = "//span[normalize-space()='Gear']")
    public WebElement gearTab;

    @FindBy(css = "a[href='https://magento.softwaretestingboard.com/contact/']")
    public WebElement contactUsBttn;

    @FindBy(xpath = "//span[normalize-space()='Buy 3 Luma tees get a 4th free']")
    public WebElement tShirtPromoBox;

    public HomePage(WebDriver driver){
    PageFactory.initElements(driver, this);
}

    public void navigateToSignIn(){click(signInBttn);
    }

    public void navigateToMensPage() {click(mensDropdownMenu);}

    public void navigateDirectlyToWomenTees() {click(tShirtPromoBox);}

    public void subscribeToNewsLetter(String email) {
        click(newsletterSignUpBox);
        type(newsletterSignUpBox, email);
        click(subscribeNewsletterBttn);
    }
    public void navigateToOrdersAndReturns() {click(ordersAndReturns);}

    public void navigateToGear() {click(gearTab);}

    public void navigateToContactUs() {click(contactUsBttn);}

    public void naviagteToSinBadTankTop() {
        HomePage home = new HomePage(getDriver());
        MensPage men = new MensPage(getDriver());
        MensTopsPage tops = new MensTopsPage(getDriver());
        home.navigateToMensPage();
        men.navigateToTops();
        tops.goToTankTop();
    }
    public void navigateToDesireeFitnessTee() {

    }
}

