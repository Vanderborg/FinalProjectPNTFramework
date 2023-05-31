package lumapages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvancedSearchPage extends CommonAPI {

    @FindBy(css = "#sku")
    public WebElement skuTextField;

    @FindBy(css = "button[class='action search primary']")
    public WebElement confirmAdvancedSearchBttn;

    public AdvancedSearchPage(WebDriver driver) {PageFactory.initElements(driver,this);}

    public void searchWithSKU() {
        type(skuTextField, "24-MG05");
        click(confirmAdvancedSearchBttn);
    }
}
