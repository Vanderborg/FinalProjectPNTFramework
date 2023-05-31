
package luma.lumapages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends CommonAPI {

    @FindBy(xpath = "//div[@class='message notice']")
    public WebElement searchBarSuccess;

    @FindBy(css = ".item.product.product-item")
    public WebElement SKUItemSuccess;

    Logger LOG = LogManager.getLogger(SearchResultsPage.class);

    public SearchResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean verifySearchBarFunctionality() {
        LOG.info("Verifying search bar functionality");
        return checkDisplayed(searchBarSuccess);
    }

    public boolean verifySearchBarSkuFunctionality() {
        LOG.info("Verifying search bar SKU functionality");
        return checkDisplayed(SKUItemSuccess);
    }
}
