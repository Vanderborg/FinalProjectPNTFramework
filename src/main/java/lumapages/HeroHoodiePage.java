package lumapages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeroHoodiePage extends CommonAPI {

    @FindBy(css = "#product-addtocart-button")
    public WebElement addToCartBttn;

    @FindBy(css = "#option-label-size-143-item-167")
    public WebElement sizeOptionSmall;

    @FindBy(css = "#option-label-color-93-item-53")
    public WebElement colorOptionGreen;

    @FindBy(css = "img[alt='Aero Daily Fitness Tee']")
    public WebElement aeroTee;

    public HeroHoodiePage(WebDriver driver) {PageFactory.initElements(driver,this);}

    public void addHeroHoodieToCart() {
        click(sizeOptionSmall);
        click(colorOptionGreen);
        click(addToCartBttn);
    }
    public void navigateToAeroTee() {
        click(aeroTee);
    }
}
