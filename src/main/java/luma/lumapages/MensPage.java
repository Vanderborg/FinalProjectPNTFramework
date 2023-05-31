package lumapages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MensPage extends CommonAPI {

    @FindBy(xpath = "//a[contains(text(),'Tops')]")
    public WebElement topsLink;

    public MensPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void navigateToTops(){
        click(topsLink);
    }
}
