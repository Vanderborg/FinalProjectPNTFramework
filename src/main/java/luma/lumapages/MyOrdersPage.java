package luma.lumapages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyOrdersPage extends CommonAPI {

    @FindBy(xpath = "//tbody/tr[1]/td[6]/a[2]/span[1]")
    public WebElement firstOrderOnPage;

    Logger LOG = LogManager.getLogger(MyOrdersPage.class);

    public MyOrdersPage(WebDriver driver) {PageFactory.initElements(driver,this);}

    public void addMostRecentOrderToCart() {
        click(firstOrderOnPage);
        LOG.info("Clicked on the first order on the page");
    }
}
