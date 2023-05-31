package lumapages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.plaf.ComboBoxUI;

public class SearchResultsPage extends CommonAPI {

    @FindBy(xpath = "//div[@class='message notice']")
    public WebElement searchBarSuccess;

    @FindBy(css = ".item.product.product-item")
    public WebElement SKUItemSuccess;

    public SearchResultsPage(WebDriver driver) {PageFactory.initElements(driver,this);}

    public boolean verifySearchBarFunctionality() {return checkDisplayed(searchBarSuccess);}

    public boolean verifySearchBarSkuFunctionality() {return checkDisplayed(SKUItemSuccess);}
}
