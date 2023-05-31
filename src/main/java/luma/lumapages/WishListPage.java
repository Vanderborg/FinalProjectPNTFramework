
package luma.lumapages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage extends CommonAPI {

    @FindBy(css = ".message-success.success.message")
    public WebElement productAddedToWishlist;

    @FindBy(css = ".action.details.tooltip.toggle")
    public WebElement wishListItemDetails;

    Logger LOG = LogManager.getLogger(WishListPage.class);

    public WishListPage(WebDriver driver) {PageFactory.initElements(driver,this);}

    public boolean verifyAddedToWishList() {
        LOG.info("Verifying if product is added to Wishlist");
        return checkDisplayed(productAddedToWishlist);
    }

    public boolean verifyAddedToWishListWithDetails() {
        LOG.info("Verifying if product is added to Wishlist with details");
        return checkDisplayed(wishListItemDetails);
    }
}
