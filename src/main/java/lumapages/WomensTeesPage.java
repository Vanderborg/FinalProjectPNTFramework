package lumapages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomensTeesPage extends CommonAPI {

    @FindBy(css = "img[alt='Desiree Fitness Tee']")
    public WebElement desireeFitnessTee;

    @FindBy(xpath = "//div[2]//div[3]//select[1]")
    public WebElement sortByDropDown;

    public WomensTeesPage(WebDriver driver){PageFactory.initElements(driver,this);}

    public void navigateToDesireeTee() {click(desireeFitnessTee);}

    public void priceFromSortBy() {selectFromDropdown(sortByDropDown,"Price");}
}
