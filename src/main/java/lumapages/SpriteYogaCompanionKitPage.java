package lumapages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpriteYogaCompanionKitPage extends CommonAPI {

    @FindBy(css = "a[class='action towishlist'] span")
    public WebElement addToWishListIcon;

    public SpriteYogaCompanionKitPage(WebDriver driver) {PageFactory.initElements(driver, this);}

    public void addYogaBallToWishList() {
        click(addToWishListIcon);
    }
}
