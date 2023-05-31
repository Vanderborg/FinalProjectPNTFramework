package nopcommerce.nopcommercepages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class CartPage extends CommonAPI {

    @FindBy(css = "#termsofservice")
    public WebElement termsOfServiceRadioButton;

    @FindBy(css = "#checkout")
    public WebElement checkoutButton;

    @FindBy(xpath = "//button[normalize-space()='Continue shopping']")
    public WebElement continueShoppingButton;

    @FindBy(css = "button[name='updatecart'][type='button']")
    public WebElement deleteItem;

    @FindBy(css = "#updatecart")
    public WebElement updateCartButton;

    @FindBy(xpath = "//a[normalize-space()='Edit']")
    public WebElement editComputer;

    @FindBy(css = ".product-name")
    public WebElement buildComputerIsDisplayed;

    @FindBy(css = "div[class='cart-footer'] div[class='totals']")
    public WebElement totalInfo;

    Logger LOG = LogManager.getLogger(CartPage.class.getName());

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public boolean buildComputerIsDisplayed() {
        LOG.info("Build computer is displayed");
        return checkDisplayed(buildComputerIsDisplayed);
    }

    public boolean totalInfoIsDisplayed() {
        LOG.info("Total info is displayed");
        return checkDisplayed(totalInfo);
    }

    public void updateCartEditComputer() {
        click(editComputer);
        LOG.info("Clicked on edit computer");
    }

    public void clickContinueShoppingButton() {
        click(continueShoppingButton);
        LOG.info("Clicked continue to shopping button");
    }

    public void clickCheckOut() {
        List<WebElement> checkOut = Arrays.asList(termsOfServiceRadioButton, checkoutButton);
        for (WebElement checkOutAll: checkOut) {
            click(checkOutAll);
            LOG.info("Clicked terms of service and checkout button");
        }
    }

    public void deleteSingleItem() {
        click(deleteItem);
        LOG.info("Clicked delete item");
        new NopCommerceHomePage(getDriver()).clickOnNopCommerceLogo();
        LOG.info("Clicked on NopCommerce logo");
        waitFor(1);
    }

    public void removeAndAddHTCM8Phone() {
        click(deleteItem);
        LOG.info("Clicked delete item");
        new NopCommerceHomePage(getDriver()).clickOnNopCommerceLogo();
        LOG.info("Clicked NopCommerce logo");
        waitFor(1);
        new NopCommerceHomePage(getDriver()).addHTCM8AndroidPhoneToCart();
        LOG.info("Added HTCM8 Android phone to cart");
    }

    public void removeAndAddItemWithCheckout() {
        removeAndAddHTCM8Phone();
        LOG.info("Removed and added HTCM8 Android phone");
        new CartPage(getDriver()).clickCheckOut();
        LOG.info("Clicked to check out");
    }

    public void deleteHTCM8PhoneItem() {
        click(deleteItem);
        LOG.info("Clicked to delete item");
        click(updateCartButton);
        LOG.info("Clicked update cart button");
    }
}