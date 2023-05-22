package nopcommercetests;

import base.CommonAPI;
import nopcommerceenums.datesoptions.Day;
import nopcommerceenums.datesoptions.Month;
import nopcommerceenums.datesoptions.Year;
import nopcommerceobjects.Customer;
import nopcommercepages.MyAccountPage;
import nopcommercepages.NopCommerceHomePage;
import nopcommercepages.ProductReviewsPage;
import nopcommercepages.RegisterLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerAccountTest extends CommonAPI {

    @Test()
    public void testReviewItem() {
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        RegisterLoginPage register = new RegisterLoginPage(getDriver());
        ProductReviewsPage review = new ProductReviewsPage(getDriver());
        MyAccountPage account = new MyAccountPage(getDriver());
        register.registerAndLogin(String.valueOf(Day._10.getDayValue()), Month.April.getMonthValue(), Year._1994.getYearValue(), new Customer());
        commerce.clickAppleMacLinkAddReview();
        Assert.assertTrue(review.reviewWasAdded());
        commerce.clickMyAccount();
        account.clickCustomerAccountReviews();
        Assert.assertTrue(account.checkReviewItemHead());
    }

    @Test()
    public void testAddNewAddress() {
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        RegisterLoginPage register = new RegisterLoginPage(getDriver());
        MyAccountPage account = new MyAccountPage(getDriver());
        register.registerAndLogin(String.valueOf(Day._7.getDayValue()), Month.November.getMonthValue(), Year._1996.getYearValue(), new Customer());
        commerce.clickMyAccount();
        account.addCustomerAddress();
        Assert.assertTrue(account.verifyAddressTextIsDisplayed());
        Assert.assertTrue(account.verifyAddressIsAdded());
    }

    @Test()
    public void testAddNewAddressAndDelete() {
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        RegisterLoginPage register = new RegisterLoginPage(getDriver());
        MyAccountPage account = new MyAccountPage(getDriver());
        register.registerAndLogin(String.valueOf(Day._7.getDayValue()), Month.November.getMonthValue(), Year._1996.getYearValue(), new Customer());
        commerce.clickMyAccount();
        account.addCustomerAddress();
        Assert.assertTrue(account.verifyAddressTextIsDisplayed());
        Assert.assertTrue(account.verifyAddressIsAdded());
        account.deleteNewAddedAddress();
        Assert.assertTrue(account.verifyNoAddresses());
    }

    @Test()
    public void testChangeCustomerInfo() {
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        RegisterLoginPage register = new RegisterLoginPage(getDriver());
        register.registerAndLogin(String.valueOf(Day._7.getDayValue()), Month.November.getMonthValue(), Year._1996.getYearValue(), new Customer());
        MyAccountPage account = new MyAccountPage(getDriver());
        commerce.clickMyAccount();
        account.clickCustomerInfo();
        register.changeCustomerInfo(String.valueOf(Day._10.getDayValue()), Month.April.getMonthValue(), Year._1994.getYearValue(), new Customer());
        Assert.assertTrue(register.verifyCustomerInfoTextIsDisplayed());
        captureScreenshot();
    }

    @Test()
    public void testChangeOldPasswordWithNewOne() {
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        RegisterLoginPage register = new RegisterLoginPage(getDriver());
        MyAccountPage account = new MyAccountPage(getDriver());
        register.registerAndLogin(String.valueOf(Day._7.getDayValue()), Month.November.getMonthValue(), Year._1996.getYearValue(), new Customer());
        commerce.clickMyAccount();
        account.changeOldPasswordToNewOne();
        Assert.assertTrue(account.verifyPasswordChanged());
    }

    @Test()
    public void testChangePasswordLogoutLogBackIn() {
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        RegisterLoginPage register = new RegisterLoginPage(getDriver());
        MyAccountPage account = new MyAccountPage(getDriver());
        register.registerAndLogin(String.valueOf(Day._1.getDayValue()), Month.January.getMonthValue(), Year._1996.getYearValue(), new Customer());
        commerce.clickMyAccount();
        account.changeOldPasswordToNewOne();
        Assert.assertTrue(account.verifyPasswordChanged());
        account.logOutAndLogin();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }
}