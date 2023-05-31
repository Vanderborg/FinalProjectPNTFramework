package nopcommerce.nopcommercepages;

import base.CommonAPI;
import nopcommerce.nopcommerceobjects.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class ProductReviewsPage extends CommonAPI {

    @FindBy(css = "#AddProductReview_Title")
    public WebElement reviewTitleInput;

    @FindBy(css = "#AddProductReview_ReviewText")
    public WebElement reviewTextInput;

    @FindBy(css = "button[name='add-review']")
    public WebElement submitReviewButton;

    @FindBy(css = "div[class='result']")
    public WebElement productReviewSuccessfullyAdded;

    Logger LOG = LogManager.getLogger(ProductReviewsPage.class.getName());

    public ProductReviewsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean reviewWasAdded() {
        LOG.info("Product review was successfully added");
        return checkDisplayed(productReviewSuccessfullyAdded);
    }

    public void submitProductReview(Customer customer) {
        List<String> review = Arrays.asList(customer.getMessage(), customer.getMessage());
        List<WebElement> reviewWebElements = Arrays.asList(reviewTitleInput, reviewTextInput);
        for (int i = 0; i < review.size() ; i++) {
            type(reviewWebElements.get(i), review.get(i));
        }
        click(submitReviewButton);
        LOG.info("Clicked submit review");
    }
}