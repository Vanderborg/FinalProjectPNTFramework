package lumapages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GearPage extends CommonAPI {

    @FindBy(xpath = "//ol[@class='items']//a[normalize-space()='Fitness Equipment']")
    public WebElement fitnessEquipmentTab;

    @FindBy(xpath = "//ol[@class='items']//a[normalize-space()='Bags']")
    public WebElement bags;

    public GearPage(WebDriver driver) {PageFactory.initElements(driver, this);}

    public void navigateToFitnessPage() {
        click(fitnessEquipmentTab);
    }

    public void navigateToBagsPage() {click(bags);}
}

