
package luma.lumapages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StriveShoulderBagPage extends CommonAPI {

    @FindBy(css = "button[id='product-addtocart-button'] span")
    public WebElement addToCartBttn;

//    @FindBy(xpath = "//a[@class='action showcart']")
//    public WebElement cartIcon;
//
//    @FindBy(xpath = "//span[normalize-space()='View and Edit Cart']")
//    public WebElement editCartIcon;

    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    public WebElement addedToCartDisplayMessage;

    public StriveShoulderBagPage(WebDriver driver) {PageFactory.initElements(driver,this);}

    public void addStriveShoulderBagToCart() {click(addToCartBttn); click(addedToCartDisplayMessage);}
}
