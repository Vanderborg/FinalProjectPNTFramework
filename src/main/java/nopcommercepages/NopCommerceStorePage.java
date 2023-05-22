package nopcommercepages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NopCommerceStorePage extends CommonAPI {

    @FindBy(css = "a[class='ico-register']")
    public WebElement registerButton;

    @FindBy(xpath = "//a[@class='ico-account']")
    public WebElement myAccount;

    @FindBy(xpath = "//a[normalize-space()='Log in']")
    public WebElement loginButton;

    @FindBy(css = "a[class='ico-cart']")
    public WebElement shoppingCartButton;

    @FindBy(css = "img[alt='nopCommerce demo store'][src='https://demo.nopcommerce.com/Themes/DefaultClean/Content/images/logo.png']")
    public WebElement nopCommerceBackHomeButton;

    @FindBy(id = "small-searchterms")
    public WebElement searchStoreField;

    @FindBy(css = "button[type='submit']")
    public WebElement searchStoreFieldButton;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")
    public WebElement computersDropDown;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']")
    public WebElement electronicsDropDown;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Apparel']")
    public WebElement apparelDropDown;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Digital downloads']")
    public WebElement digitalDownloadsButton;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Books']")
    public WebElement booksButton;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Jewelry']")
    public WebElement jewelryButton;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Gift Cards']")
    public WebElement giftCardsButton;

    @FindBy(xpath = "//div[@class='page-body']//div[1]//div[1]//div[2]//div[3]//div[2]//button[1]")
    public WebElement addBuildYourComputerToCart;

    @FindBy(xpath = "(//button[@title='Add to compare list'][normalize-space()='Add to compare list'])[1]")
    public WebElement compareBuildYourComputerButton;

    @FindBy(xpath = "//a[normalize-space()='Apple MacBook Pro 13-inch']")
    public WebElement clickAppleMacBookLink;

    @FindBy(xpath = "//div[@class='item-grid']//div[2]//div[1]//div[2]//div[3]//div[2]//button[1]")
    public WebElement addAppleMacBookProToCartButton;

    @FindBy(xpath = "//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[1]/div[4]/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/button[3]")
    public WebElement heartAppleMacBookProAddToWishListButton;

    @FindBy(xpath = "//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[1]/div[4]/div[2]/div[3]/div[1]/div[2]/div[3]/div[2]/button[1]")
    public WebElement addHTCM8AndroidPhoneToCart;

    @FindBy(xpath = "//div[@class='master-wrapper-content']//div[3]//div[1]//div[2]//div[3]//div[2]//button[2]")
    public WebElement compareHTCM8AndroidPhoneButton;

    @FindBy(xpath = "//div[@class='product-grid home-page-product-grid']//div[4]//div[1]//div[2]//div[3]//div[2]//button[1]")
    public WebElement addVirtualGiftCardToCart;

    @FindBy(xpath = "//div[@class='product-grid home-page-product-grid']//div[4]//div[1]//div[2]//div[3]//div[2]//button[2]")
    public WebElement compareGiftCardButton;

    @FindBy(css = "p[class='content'] a")
    public WebElement productComparisonButton;

    @FindBy(css = ".clear-list")
    public WebElement clearList;

    @FindBy(css = "div[class='topic-block-title'] h2")
    public WebElement welcomeToOurStoreTitle;

    @FindBy(css = ".button-2.product-box-add-to-cart-button")
    public WebElement addAppleToCart2;

    public NopCommerceStorePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnRegisterButton() {
        click(registerButton);
    }

    public void clickOnLoginButton() {
        click(loginButton);
    }

    public void clickOnNopCommerceLogo() {
        click(nopCommerceBackHomeButton);
    }

    public void clickMyAccount() {
        click(myAccount);
    }

    public boolean welcomeToOurStoreIsDisplayed() {
        return checkDisplayed(welcomeToOurStoreTitle);
    }

    public void clickAppleMacLinkAddReview() {
        ItemsPage item = new ItemsPage(getDriver());
        ProductReviewsPage review = new ProductReviewsPage(getDriver());
        click(clickAppleMacBookLink);
        item.clickAppleLinkReview();
        review.submitProductReview();
    }

    public void addHTCM8AndroidPhoneToCart() {
        ItemsPage item = new ItemsPage(getDriver());
        click(addHTCM8AndroidPhoneToCart);
        item.clickShoppingCartToCheckOut();
    }

    public void addHTCM8AndroidPhoneToCheckOut() {
        click(addHTCM8AndroidPhoneToCart);
    }

    public void addBuildYourComputerToCart() {
        click(addBuildYourComputerToCart);
    }

    public void searchStoreItem(String search) {
        type(searchStoreField, search);
        click(searchStoreFieldButton);
    }

    public void searchAppleAddToCart(String search) {
        ItemsPage item = new ItemsPage(getDriver());
        type(searchStoreField, search);
        click(searchStoreFieldButton);
        click(addAppleToCart2);
        item.addAppleProductToCartToCheckOut();
        item.clickShoppingCartToCheckOut();
    }

    public void addAppleMacBookProToCart() {
        ItemsPage item = new ItemsPage(getDriver());
        List<WebElement> apple = Collections.singletonList(addAppleMacBookProToCartButton);
        for (WebElement addAppleToCart : apple) {
            click(addAppleToCart);
        }
        item.addAppleProductToCartToCheckOut();
        click(nopCommerceBackHomeButton);
    }

    public void addVirtualGiftCardToCart() {
        ItemsPage item = new ItemsPage(getDriver());
        List<WebElement> virtualCard = Arrays.asList(addVirtualGiftCardToCart, shoppingCartButton);
        for (WebElement addVirtualCardToCart : virtualCard) {
            click(addVirtualCardToCart);
        }
        item.inputInfoForGiftCardAndAddToCart();
    }

    public void addMultipleItemsToCart(String processorOption, String ramOption, String hddOption, String osOption) {
        ItemsPage item = new ItemsPage(getDriver());
        click(addHTCM8AndroidPhoneToCart);
        waitFor(1);
        addAppleMacBookProToCart();
        addVirtualGiftCardToCart();
        click(nopCommerceBackHomeButton);
        addBuildYourComputerToCart();
        item.buildYourOwnComputerGoToShoppingCart(processorOption, ramOption, hddOption, osOption);
    }

    public void compareItemsThenAddToCart() {
        ItemsPage item = new ItemsPage(getDriver());
        click(compareHTCM8AndroidPhoneButton);
        waitFor(1);
        click(compareGiftCardButton);
        waitFor(1);
        List<WebElement> click = Arrays.asList(productComparisonButton, clearList, nopCommerceBackHomeButton);
        for (WebElement clickAll:click) {
            click(clickAll);

        }
        addVirtualGiftCardToCart();
        doubleClick(nopCommerceBackHomeButton, addHTCM8AndroidPhoneToCart);
    }

    public void compareItemsDeleteOneAddToCart() {
        ItemsPage item = new ItemsPage(getDriver());
        CartPage cart = new CartPage(getDriver());
        click(compareHTCM8AndroidPhoneButton);
        waitFor(1);
        click(compareGiftCardButton);
        waitFor(1);
        List<WebElement> click = Arrays.asList(productComparisonButton, clearList, nopCommerceBackHomeButton);
        for (WebElement clickAll:click) {
            click(clickAll);

        }
        addVirtualGiftCardToCart();
        doubleClick(nopCommerceBackHomeButton, addHTCM8AndroidPhoneToCart);
        item.clickShoppingCartToCheckOut();
        cart.deleteHTC8PhoneItem();
    }
}