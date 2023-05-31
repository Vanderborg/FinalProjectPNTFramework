package luma.lumapages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdvancedSearchPage extends CommonAPI {

    @FindBy(css = "#sku")
    public WebElement skuTextField;

    @FindBy(css = "button[class='action search primary']")
    public WebElement confirmAdvancedSearchBttn;

    Logger LOG = LogManager.getLogger(AdvancedSearchPage.class);

    public AdvancedSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void searchWithSKU() {
        type(skuTextField, "24-MG05");
        LOG.info("SKU is input into the search field");
        click(confirmAdvancedSearchBttn);
        LOG.info("Confirm advanced search button is clicked");
    }
}
