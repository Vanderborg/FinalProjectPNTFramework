
package luma.lumapages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogAdvancedSearchPage extends CommonAPI {

    @FindBy(css = ".product.name.product-item-name")
    public WebElement cruiseDualAnalogWatch;

    Logger LOG = LogManager.getLogger(CatalogAdvancedSearchPage.class);

    public CatalogAdvancedSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyAdvancedSearch() {
        LOG.info("Verifying if advanced search is successful");
        return checkDisplayed(cruiseDualAnalogWatch);
    }
}
