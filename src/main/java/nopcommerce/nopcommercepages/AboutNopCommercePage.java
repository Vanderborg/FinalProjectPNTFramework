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

public class AboutNopCommercePage extends CommonAPI {

    @FindBy(css = "#AddNewComment_CommentTitle")
    public WebElement inputTitle;

    @FindBy(css = "#AddNewComment_CommentText")
    public WebElement inputComment;

    @FindBy(css = "button[name='add-comment']")
    public WebElement addNewComment;

    @FindBy(css = ".result")
    public WebElement newCommentIsAddedSuccessfully;

    Logger LOG = LogManager.getLogger(AboutNopCommercePage.class.getName());

    public AboutNopCommercePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public boolean verifyCommentIsAdded() {
        LOG.info("New comment is added successfully");
        return checkDisplayed(newCommentIsAddedSuccessfully);
    }

    public void leaveAComment(Customer customer) {
        new NopCommerceHomePage(getDriver()).clickReadMoreButton();
        LOG.info("Clicked on read more button");
        List<String> input = Arrays.asList(customer.getMessage(), customer.getMessage());
        List<WebElement> webElementsInput = Arrays.asList(inputTitle, inputComment);
        for (int i = 0; i <input.size() ; i++) {
            type(webElementsInput.get(i), input.get(i) );
            LOG.info("Typed input title and comment");
        }
        click(addNewComment);
        LOG.info("Clicked on add new comment button");
    }
}
