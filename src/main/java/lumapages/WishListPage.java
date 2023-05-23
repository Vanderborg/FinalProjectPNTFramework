package lumapages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage extends CommonAPI {

    @FindBy(css = ".message-success.success.message")
    public WebElement productAddedToWishlist;

    public WishListPage(WebDriver driver) {PageFactory.initElements(driver,this);}

    public boolean verifyAddedToWishList() {return checkDisplayed(productAddedToWishlist);}
}
