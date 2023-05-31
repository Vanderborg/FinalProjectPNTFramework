package luma.lumapages;

import base.CommonAPI;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    @FindBy(css = "h2[class='title']")
    public WebElement hotSellersTitle;

    @FindBy(css = "img[alt='Hero Hoodie']")
    public WebElement heroHoodie;

    @FindBy(xpath = "//li[@class='nav item']//a[normalize-space()='Advanced Search']")
    public WebElement advancedSearchLink;

    @FindBy(css = "#search")
    public WebElement searchBar;

    @FindBy(css = "button[title='Search']")
    public WebElement magnifyingGlassIcon;

    @FindBy(css = ".message-success.success.message")
    public WebElement newsletterConfirmation;

    @FindBy(xpath = "//span[normalize-space()='Sale']")
    public WebElement saleTab;

    @FindBy(css = "a[id='ui-id-3'] span:nth-child(1)")
    public WebElement whatsNewTab;

    @FindBy(css = "div[class='panel header'] span[class='logged-in']")
    public WebElement accountNameShown;

    Logger LOG = LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver){PageFactory.initElements(driver, this);}

    public boolean verifyLoggedIn() {
        LOG.info("Homepage displayed successfully");
        return checkDisplayed(hotSellersTitle);
    }

    public boolean verifyDbLoggedIn() {
        LOG.info("Account name is displayed on header");
        return checkDisplayed(accountNameShown);}

    public boolean verifyNewsletterSubscription() {
        LOG.info("We have saved your subscription is displayed");
        return checkDisplayed(newsletterConfirmation);}

    public void navigateToSignIn(){
        click(signInBttn);
        LOG.info("Sign in button is clicked");
    }

    public void navigateToMensPage() {
        click(mensDropdownMenu);
        LOG.info("Men's dropdown menu is clicked");}

    public void navigateDirectlyToWomenTees() {
        click(tShirtPromoBox);
        LOG.info("T-shirt promotion box is clicked");
    }

    public void subscribeToNewsLetter() {
        String email = new Faker().bothify("??????##@gmail.com");
        type(newsletterSignUpBox, email);
        LOG.info("Email is input into newsletter text field");
        click(subscribeNewsletterBttn);
        LOG.info("Newsletter subscription button is selected.");
    }
    public void navigateToOrdersAndReturns() {
        click(ordersAndReturns);
        LOG.info("Orders and return link is clicked.");}

    public void navigateToGear() {
        click(gearTab);
        LOG.info("Gear tab is clicked");}

    public void navigateToContactUs() {
        click(contactUsBttn);
        LOG.info("Contact Us button is clicked");}

    public void navigateToMensTees() {
        navigateToMensPage();
        LOG.info("Mens tab is clicked");
        new MensPage(getDriver()).navigateToTops();
        LOG.info("Men's Tops tab is clicked.");
        new MensTopsPage(getDriver()).goToTees();
        LOG.info("Men's Tees tab is clicked.");
    }
    public void navigateToSinBadTankTop() {
        navigateToMensPage();
        LOG.info("Mens tab is clicked");
        new MensPage(getDriver()).navigateToTops();
        LOG.info("Men's Tops tab is clicked.");
        new MensTopsPage(getDriver()).goToSinbadTankTop();
        LOG.info("Sinbad tank top is clicked.");
    }
    public void navigateToHeroHoodie() {
        click(heroHoodie);
        LOG.info("Hero hoodie is clicked");
    }

    public void navigateToAdvancedSearch() {
        click(advancedSearchLink);
        LOG.info("Advanced Search is clicked");}

    public void searchBarField() {
        String product = new Faker().dragonBall().character();
        typeAndClick(searchBar, product, magnifyingGlassIcon);
        LOG.info("Product is input into search bar and clicks the search icon.");
    }

    public void searchWithSKU() {
        typeAndClick(searchBar,"MT06", magnifyingGlassIcon);
        LOG.info("SKU is input into search bar and clicks the search icon.");
    }

    public void navigateToSaleTab() {
        click(saleTab);
        LOG.info("Sale tab is clicked.");
    }

    public void navigateToWhatsNewTab() {
        click(whatsNewTab);
        LOG.info("What's New tab is clicked");
    }
}