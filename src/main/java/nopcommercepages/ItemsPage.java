package nopcommercepages;

import base.CommonAPI;
import com.github.javafaker.Faker;
import nopcommerceenums.computeroptions.OSOption;
import nopcommerceobjects.CPU;
import nopcommerceobjects.HDD;
import nopcommerceobjects.OS;
import nopcommerceobjects.Ram;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Arrays;
import java.util.List;

public class ItemsPage extends CommonAPI {

    @FindBy(xpath = "//select[@id='product_attribute_1']")
    public WebElement selectProcessorFromDropDown;

    @FindBy(xpath = "//select[@id='product_attribute_2']")
    public WebElement selectRAMFromDropDown;

    @FindBy(xpath = "//input[@id='product_attribute_3_6']")
    public WebElement HDD320GBRadioButton;

    @FindBy(css = "#product_attribute_3_7")
    public WebElement HDD400GBRadioButton;

    @FindBy(xpath = "//input[@id='product_attribute_4_8']")
    public WebElement OSVistaHome;

    @FindBy(xpath = "//input[@id='product_attribute_4_9']")
    public WebElement OSVistaPremium;

    @FindBy(xpath= "//input[@id='product_attribute_5_10']")
    public WebElement checkBoxMicrosoftOffice;

    @FindBy(xpath = "//input[@id='product_attribute_5_11']")
    public WebElement checkBoxAcrobatReader;

    @FindBy(xpath = "//input[@id='product_attribute_5_12']")
    public WebElement checkBoxTotalCommander;

    @FindBy(xpath = "//button[@id='add-to-cart-button-1']")
    public WebElement addBuildYourOwnComputerToCart;

    @FindBy(xpath = "//button[@id='add-to-cart-button-4']")
    public WebElement addAppleProductToCart;

    @FindBy(xpath = "//a[normalize-space()='Add your review']")
    public WebElement addAppleMacBookReview;

    @FindBy(css = "#giftcard_43_RecipientName")
    public WebElement inputRecipientsNameForGiftCardField;

    @FindBy(xpath = "//input[@id='giftcard_43_RecipientEmail']")
    public WebElement inputRecipientsEmailForGiftCardField;

    @FindBy(xpath = "//input[@id='giftcard_43_SenderName']")
    public WebElement inputSenderNameForGiftCardField;

    @FindBy(xpath = "//input[@id='giftcard_43_SenderEmail']")
    public WebElement inputSenderEmailForGiftCardField;

    @FindBy(xpath = "//textarea[@id='giftcard_43_Message']")
    public WebElement inputMessageForGiftCardField;

    @FindBy(xpath = "//button[@id='add-to-cart-button-43']")
    public WebElement addGiftCardToCart;

    @FindBy(css = "p[class='content'] a")
    public WebElement clickShoppingCartButton;

    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    public WebElement goToShoppingCartButton;

    @FindBy(css = "#product_enteredQuantity_1")
    public WebElement changeProductQuantity;

    @FindBy(css = "#add-to-cart-button-1")
    public WebElement updateCartButton;

    public ItemsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickAppleLinkReview() {
        click(addAppleMacBookReview);
    }

    public void clickShoppingCartToCheckOut() {
        click(goToShoppingCartButton);
    }

    public void changeProductQuantity(int quantity) {
        CartPage cart = new CartPage(getDriver());
        clear(changeProductQuantity);
        type(changeProductQuantity, String.valueOf(quantity));
        waitFor(1);
        click(updateCartButton);
        waitFor(1);
        click(clickShoppingCartButton);
    }

    public void mistakeChangeProductQuantity(int quantity, int quantity2) {
        CartPage cart = new CartPage(getDriver());
        clear(changeProductQuantity);
        type(changeProductQuantity, String.valueOf(quantity));
        waitFor(1);
        click(updateCartButton);
        click(clickShoppingCartButton);
        cart.updateCartEditComputer();
        clear(changeProductQuantity);
        type(changeProductQuantity, String.valueOf(quantity2));
        click(updateCartButton);
        click(clickShoppingCartButton);
    }

    public void addAppleProductToCartToCheckOut() {
        click(addAppleProductToCart);
    }

    public void buildComputerAndGoToCart(String processorOption, String ramOption, String hddOption, String osOption) {
        NopCommerceHomePage commerce =  new NopCommerceHomePage(getDriver());
        commerce.addBuildYourComputerToCart();
        inputBuildYourOwnComputer(processorOption, ramOption, hddOption, osOption);
        click(goToShoppingCartButton);
    }

    public void buildYourOwnComputerAddToCart(String processorOption, String ramOption, String hddOption, String osOption) {
        NopCommerceHomePage commerce =  new NopCommerceHomePage(getDriver());
        commerce.addBuildYourComputerToCart();
        inputBuildYourOwnComputer(processorOption, ramOption, hddOption, osOption);
    }

    public void addComputerAndGiftCardToCart(String processorOption, String ramOption, String hddOption, String osOption) {
        NopCommerceHomePage commerce =  new NopCommerceHomePage(getDriver());
        buildYourOwnComputerAddToCart(processorOption, ramOption, hddOption, osOption);
        commerce.clickOnNopCommerceLogo();
        commerce.addVirtualGiftCardToCart();
        click(goToShoppingCartButton);
    }

    public void inputInfoForGiftCardAndAddToCart() {
        String recipientsName = new Faker().name().fullName();
        String recipientsEmail = new Faker().bothify("???????#####@gmail.com");
        String senderName = new Faker().name().fullName();
        String senderEmail = new Faker().bothify("??????####@gmail.com");
        String message = new Faker().rickAndMorty().character();
        List<String> giftCard = Arrays.asList(recipientsName, recipientsEmail, senderName);
        List<WebElement> giftCardElements = Arrays.asList(inputRecipientsNameForGiftCardField, inputRecipientsEmailForGiftCardField, inputSenderNameForGiftCardField );
        for (int i = 0; i < giftCard.size() ; i++) {
            type(giftCardElements.get(i), giftCard.get(i));
        }
        clearAndType(inputSenderEmailForGiftCardField, senderEmail);
        type(inputMessageForGiftCardField, message);
        click(addGiftCardToCart);
    }

    public void inputBuildYourOwnComputer(String processorOption, String ramOption, String hddOption, String osOption) {
        selectFromDropdown(selectProcessorFromDropDown, processorOption);
        selectFromDropdown(selectRAMFromDropDown, ramOption);
        List<WebElement> hDD = Arrays.asList(HDD320GBRadioButton, HDD400GBRadioButton);
        for (WebElement hDDOptions:hDD) {
            click(hDDOptions);
        }
        List<WebElement> oS = Arrays.asList(OSVistaHome, OSVistaPremium);
        for (WebElement oSOptions:oS) {
            click(oSOptions);
        }
        click(checkBoxMicrosoftOffice);
        List<WebElement> softWareOptions = Arrays.asList(checkBoxMicrosoftOffice, checkBoxAcrobatReader, checkBoxTotalCommander);
        for (WebElement allOptions : softWareOptions) {
            allOptions.click();
        }
        click(addBuildYourOwnComputerToCart);
    }
}