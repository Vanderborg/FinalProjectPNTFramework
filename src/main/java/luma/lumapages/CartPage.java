package luma.lumapages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends CommonAPI {

    @FindBy(xpath = "//a[@class='action action-delete']")
    public WebElement trashCanIcon;

    @FindBy(xpath = "//a[@aria-label='store logo']//img")
    public WebElement lumaHomeIcon;

    @FindBy(css = ".control.qty")
    public WebElement cartQuantityBox;

    @FindBy(css = "button[title='Proceed to Checkout'] span")
    public WebElement checkOutBttn;

    @FindBy(css = "a[title='Edit item parameters']")
    public WebElement pencilIcon;

    @FindBy(xpath = "//p[normalize-space()='You have no items in your shopping cart.']")
    public WebElement removalOfItemsFromCartSuccess;

    @FindBy(xpath = "//div[@id='block-discount']//div[@role='tab']")
    public WebElement openDiscountField;

    @FindBy(css = "#coupon_code")
    public WebElement enterCouponCode;

    @FindBy(css = "button[value='Apply Discount'] span")
    public WebElement applyCouponCode;

    @FindBy(css = "td[class='col item'] strong[class='product-item-name']")
    public WebElement wishListItemInCart;

    @FindBy(xpath = "//span[normalize-space()='Move to Wishlist']")
    public WebElement itemBackToWishList;

    Logger LOG = LogManager.getLogger(CartPage.class);

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyRemovalOfCartItems() {
        LOG.info("Verifying if items are successfully removed from the cart");
        return checkDisplayed(removalOfItemsFromCartSuccess);
    }

    public void deleteItemInCart() {
        click(trashCanIcon);
        LOG.info("Clicked trash can icon to delete item from the cart");
    }

    public void moveItemFromCartBackToWishList() {
        click(itemBackToWishList);
        LOG.info("Clicked move item from cart back to wishlist");
    }

    public void adjustItemsInCart() {
        click(pencilIcon);
        LOG.info("Clicked pencil icon to adjust items in the cart");
        waitFor(6);
        LOG.info("Waited for 6 seconds");
    }

    public void navigateToCheckout() {
        waitFor(1);
        LOG.info("Waited for 1 second");
        click(checkOutBttn);
        LOG.info("Clicked checkout button to navigate to checkout");
    }

    public void addCouponCode() {
        click(openDiscountField);
        LOG.info("Clicked open discount field to add coupon code");
        click(enterCouponCode);
        LOG.info("Clicked enter coupon code field");
        type(enterCouponCode, "H20");
        LOG.info("Entered coupon code: H20");
        click(applyCouponCode);
        LOG.info("Clicked apply coupon code button");
        click(checkOutBttn);
        LOG.info("Clicked checkout button after applying coupon code");
        waitFor(2);
        LOG.info("Waited for 2 seconds");
    }

    public void addUsedCouponCode() {
        click(openDiscountField);
        LOG.info("Clicked open discount field to add used coupon code");
        click(enterCouponCode);
        LOG.info("Clicked enter coupon code field");
        type(enterCouponCode, "H20");
        LOG.info("Entered used coupon code: H20");
        click(applyCouponCode);
        LOG.info("Clicked apply coupon code button");
    }

    public boolean verifyWishListItemInCart() {
        LOG.info("Verifying if wishlist item is in the cart.");
        return checkDisplayed(wishListItemInCart);
    }
}



