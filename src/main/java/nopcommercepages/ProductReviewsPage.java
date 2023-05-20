package nopcommercepages;

import base.CommonAPI;
import com.github.javafaker.Faker;
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

    public ProductReviewsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean reviewWasAdded() {
        return checkDisplayed(productReviewSuccessfullyAdded);
    }

    public void submitProductReview() {
        String title = new Faker().rickAndMorty().character();
        String text = new Faker().book().publisher();
        List<String> review = Arrays.asList(title, text);
        List<WebElement> reviewWebElements = Arrays.asList(reviewTitleInput, reviewTextInput);
        for (int i = 0; i < review.size() ; i++) {
            type(reviewWebElements.get(i), review.get(i));
        }
        click(submitReviewButton);
        waitFor(5);
    }
}