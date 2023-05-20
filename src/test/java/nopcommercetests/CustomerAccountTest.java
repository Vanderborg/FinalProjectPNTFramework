package nopcommercetests;

import base.CommonAPI;
import nopcommerceenums.datesoptions.Day;
import nopcommerceenums.datesoptions.Month;
import nopcommerceenums.datesoptions.Year;
import nopcommercepages.MyAccountPage;
import nopcommercepages.NopCommerceStorePage;
import nopcommercepages.ProductReviewsPage;
import nopcommercepages.RegisterLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerAccountTest extends CommonAPI {

    @Test()
    public void testReviewItem() {
        NopCommerceStorePage commerce = new NopCommerceStorePage(getDriver());
        RegisterLoginPage register = new RegisterLoginPage(getDriver());
        ProductReviewsPage review = new ProductReviewsPage(getDriver());
        MyAccountPage account = new MyAccountPage(getDriver());
        register.registerAndLogin(String.valueOf(Day._10.getDayValue()), Month.April.getMonthValue(), Year._1994.getYearValue());
        commerce.clickAppleMacLinkAddReview();
        Assert.assertTrue(review.reviewWasAdded());
        commerce.clickMyAccount();
        account.clickCustomerAccountReviews();
        Assert.assertTrue(account.checkReviewItemHead());
    }

    @Test()
    public void testAddNewAddress() {
        NopCommerceStorePage commerce = new NopCommerceStorePage(getDriver());
        RegisterLoginPage register = new RegisterLoginPage(getDriver());
        MyAccountPage account = new MyAccountPage(getDriver());
        register.registerAndLogin(String.valueOf(Day._7.getDayValue()), Month.November.getMonthValue(), Year._1996.getYearValue());
        commerce.clickMyAccount();
        account.addCustomerAddress();
        Assert.assertTrue(account.verifyAddressTextIsDisplayed());
        Assert.assertTrue(account.verifyAddressIsAdded());
    }

    @Test()
    public void testAddNewAddressAndDelete() {
        NopCommerceStorePage commerce = new NopCommerceStorePage(getDriver());
        RegisterLoginPage register = new RegisterLoginPage(getDriver());
        MyAccountPage account = new MyAccountPage(getDriver());
        register.registerAndLogin(String.valueOf(Day._7.getDayValue()), Month.November.getMonthValue(), Year._1996.getYearValue());
        commerce.clickMyAccount();
        account.addCustomerAddress();
        Assert.assertTrue(account.verifyAddressTextIsDisplayed());
        Assert.assertTrue(account.verifyAddressIsAdded());
        account.deleteNewAddedAddress();
        Assert.assertTrue(account.verifyNoAddresses());
    }

    @Test()
    public void testChangeCustomerInfo() {
        NopCommerceStorePage commerce = new NopCommerceStorePage(getDriver());
        RegisterLoginPage register = new RegisterLoginPage(getDriver());
        register.registerAndLogin(String.valueOf(Day._7.getDayValue()), Month.November.getMonthValue(), Year._1996.getYearValue());
        MyAccountPage account = new MyAccountPage(getDriver());
        commerce.clickMyAccount();
        account.clickCustomerInfo();
        register.changeCustomerInfo(String.valueOf(Day._10.getDayValue()), Month.April.getMonthValue(), Year._1994.getYearValue());
        Assert.assertTrue(register.verifyCustomerInfoTextIsDisplayed());
    }

    @Test()
    public void testChangeOldPasswordWithNewOne() {
        NopCommerceStorePage commerce = new NopCommerceStorePage(getDriver());
        RegisterLoginPage register = new RegisterLoginPage(getDriver());
        MyAccountPage account = new MyAccountPage(getDriver());
        register.registerAndLogin(String.valueOf(Day._7.getDayValue()), Month.November.getMonthValue(), Year._1996.getYearValue());
        commerce.clickMyAccount();
        account.changeOldPasswordToNewOne();
        Assert.assertTrue(account.verifyPasswordChanged());
    }

    @Test()
    public void testChangePasswordLogoutLogBackIn() {
        NopCommerceStorePage commerce = new NopCommerceStorePage(getDriver());
        RegisterLoginPage register = new RegisterLoginPage(getDriver());
        MyAccountPage account = new MyAccountPage(getDriver());
        register.registerAndLogin(String.valueOf(Day._1.getDayValue()), Month.January.getMonthValue(), Year._1996.getYearValue());
        commerce.clickMyAccount();
        account.changeOldPasswordToNewOne();
        Assert.assertTrue(account.verifyPasswordChanged());
        account.logOutAndLogin();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }
}