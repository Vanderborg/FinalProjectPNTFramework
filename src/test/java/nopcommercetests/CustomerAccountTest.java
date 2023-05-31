package nopcommercetests;

import base.CommonAPI;
import nopcommerce.nopcommercepages.MyAccountPage;
import nopcommerce.nopcommercepages.NopCommerceHomePage;
import nopcommerce.nopcommercepages.ProductReviewsPage;
import nopcommerce.nopcommercepages.RegisterLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerAccountTest extends CommonAPI {

    @Test(priority = 1)
    public void testReviewItem() {
        RegisterLoginPage login = new RegisterLoginPage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        MyAccountPage account = new MyAccountPage(getDriver());
        ProductReviewsPage product = new ProductReviewsPage(getDriver());
        login.registerAndLogin();
        commerce.clickAppleMacLinkAddReview();
        Assert.assertTrue(product.reviewWasAdded());
        commerce.clickMyAccount();
        account.clickCustomerAccountReviews();
        Assert.assertTrue(account.checkReviewItemHead());
    }

    @Test(priority = 2)
    public void testAddNewAddress() {
        RegisterLoginPage login = new RegisterLoginPage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        MyAccountPage account = new MyAccountPage(getDriver());
        login.registerAndLogin();
        commerce.clickMyAccount();
        account.addCustomerAddress();
        Assert.assertTrue(account.verifyAddressTextIsDisplayed());
        Assert.assertTrue(account.verifyAddressIsAdded());
    }

    @Test(priority = 3)
    public void testAddNewAddressAndDelete() {
        RegisterLoginPage login = new RegisterLoginPage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        MyAccountPage account = new MyAccountPage(getDriver());
        login.registerAndLogin();
        commerce.clickMyAccount();
        account.addCustomerAddress();
        Assert.assertTrue(account.verifyAddressTextIsDisplayed());
        Assert.assertTrue(account.verifyAddressIsAdded());
        account.deleteNewAddedAddress();
        Assert.assertTrue(account.verifyNoAddresses());
    }

    @Test(priority = 4)
    public void testChangeCustomerInfo() {
        RegisterLoginPage login = new RegisterLoginPage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        MyAccountPage account = new MyAccountPage(getDriver());
        login.registerAndLogin();
        commerce.clickMyAccount();
        account.clickCustomerInfo();
        login.changeCustomerInfo();
        Assert.assertTrue(login.verifyCustomerInfoTextIsDisplayed());
    }

    @Test(priority = 5)
    public void testChangeOldPasswordWithNewOne() {
        RegisterLoginPage login = new RegisterLoginPage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        MyAccountPage account = new MyAccountPage(getDriver());
        login.registerAndLogin();
        commerce.clickMyAccount();
        account.changeOldPasswordToNewOne();
        Assert.assertTrue(account.verifyPasswordChanged());
    }

    @Test(priority = 6)
    public void testChangePasswordLogoutLogBackIn() {
        RegisterLoginPage login = new RegisterLoginPage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        MyAccountPage account = new MyAccountPage(getDriver());
        login.registerAndLogin();
        commerce.clickMyAccount();
        account.changeOldPasswordToNewOne();
        Assert.assertTrue(account.verifyPasswordChanged());
        account.logOutAndLogin();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }
}
