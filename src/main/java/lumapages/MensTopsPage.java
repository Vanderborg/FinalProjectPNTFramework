package lumapages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MensTopsPage extends CommonAPI {

    @FindBy(css = "img[alt='Sinbad Fitness Tank']")
    public WebElement blueTankTop;

    public MensTopsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void goToTankTop() {click(blueTankTop);}
}
