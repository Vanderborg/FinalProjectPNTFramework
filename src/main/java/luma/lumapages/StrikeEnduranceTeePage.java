
package luma.lumapages;

import base.CommonAPI;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StrikeEnduranceTeePage extends CommonAPI {

    @FindBy(xpath = "//a[normalize-space()='Add Your Review']")
    public WebElement addYourReview;

    @FindBy(css = ".rating-1")
    public WebElement oneStarRating;

    @FindBy(css = ".rating-2")
    public WebElement secStarRating;

    @FindBy(css = ".rating-3")
    public WebElement threeStarRating;

    @FindBy(css = ".rating-4")
    public WebElement fourStarRating;

    @FindBy(css = ".rating-5")
    public WebElement fiveStarRating;

    @FindBy(xpath = "//input[@id='summary_field']")
    public WebElement summaryField;

    @FindBy(xpath = "//textarea[@id='review_field']")
    public WebElement reviewField;

    @FindBy(css = "button[class='action submit primary'] span")
    public WebElement reviewSubmissionBttn;

    @FindBy(css = "div[class='panel header'] button[type='button']")
    public WebElement accountDropDown;

    @FindBy(css = "div[class='panel wrapper'] li:nth-child(1) a:nth-child(1)")
    public WebElement myAccountFeature;

    @FindBy(css = ".message-success.success.message")
    public WebElement reviewSubmittedSuccessfully;

    Logger LOG = LogManager.getLogger(StrikeEnduranceTeePage.class);

    public StrikeEnduranceTeePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyReviewAddedForModeration() {
        LOG.info("Verifying if review is added for moderation");
        return checkDisplayed(reviewSubmittedSuccessfully);
    }

    public void createReviewForStrikeTee() {
        click(addYourReview);
        LOG.info("Clicked on 'Add Your Review' button");
    }

    public void inputReviewInfo() {
        String sum = new Faker().book().title();
        String review = new Faker().rickAndMorty().location();
        click(oneStarRating);
        LOG.info("Clicked on one star rating");
        type(summaryField, sum);
        LOG.info("Entered review summary: " + sum);
        type(reviewField, review);
        LOG.info("Entered review: " + review);
        click(reviewSubmissionBttn);
        LOG.info("Clicked on 'Submit Review' button");
    }

    public void navigateToAccountPage() {
        doubleClick(accountDropDown, myAccountFeature);
        LOG.info("Clicked on Account dropdown and clicked 'My Account' feature");
    }
}