package lumatests;

import base.CommonAPI;
import lumaenums.Login;
import lumapages.*;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LumaTest extends CommonAPI {

    @Test(enabled = false)//1
    public void addSinbadTankTopToCart() {
        HomePage home = new HomePage(getDriver());
        LoginPage login = new LoginPage(getDriver());
        SinbadFitnessTankTopPage sin = new SinbadFitnessTankTopPage(getDriver());
        login.customerLogin(Login.EMAIL.getLogin(), Login.PASSWORD.getLogin());
        home.navigateToSinBadTankTop();
        sin.sinbadTankTopAddToCart();
        Assert.assertTrue(sin.verifyAddedToCart());
    }
    @Test(enabled = false)//2
    public void subscribeToNewsletter() {
        HomePage home = new HomePage(getDriver());
        LoginPage gologin = new LoginPage(getDriver());
        home.navigateToSignIn();
        gologin.customerLogin(Login.EMAIL.getLogin(), Login.PASSWORD.getLogin());
        home.subscribeToNewsLetter();
        Assert.assertTrue(home.verifyNewsletterSubscription());
    }
    @Test(enabled = false)//3
    public void viewPreviousOrder() {
        HomePage home = new HomePage(getDriver());
        OrdersAndReturnsPage order = new OrdersAndReturnsPage(getDriver());
        home.navigateToOrdersAndReturns();
        order.fillInOrderInfo();
        Assert.assertTrue(order.verifyOrderDate());
    }
    @Test(enabled = false)//4
    public void verifyWishList() {
        HomePage home = new HomePage(getDriver());
        LoginPage gologin = new LoginPage(getDriver());
        GearPage gear = new GearPage(getDriver());
        GearFitnessEquipmentPage fitness = new GearFitnessEquipmentPage(getDriver());
        SpriteYogaCompanionKitPage yoga = new SpriteYogaCompanionKitPage(getDriver());
        WishListPage wish = new WishListPage(getDriver());
        home.navigateToSignIn();
        gologin.customerLogin(Login.EMAIL.getLogin(), Login.PASSWORD.getLogin());
        home.navigateToGear();
        gear.navigateToFitnessPage();
        fitness.navigateToBlueYogaBall();
        yoga.addYogaBallToWishList();
        Assert.assertTrue(wish.verifyAddedToWishList());
    }
    @Test(enabled = false)//5
    public void contactUs() {
        HomePage home = new HomePage(getDriver());
        ContactUsPage contact = new ContactUsPage(getDriver());
        home.navigateToContactUs();
        contact.submitFeedbackToSite();
        Assert.assertTrue(contact.verifyContactUs());
    }
    @Test(enabled = false)//6
    public void additionAndRemovalOfItems() {
        HomePage home = new HomePage(getDriver());
        GearPage gear = new GearPage(getDriver());
        GearBagsPage bags = new GearBagsPage(getDriver());
        StriveShoulderBagPage strive = new StriveShoulderBagPage(getDriver());
        CartPage cart = new CartPage(getDriver());
        home.navigateToGear();
        gear.navigateToBagsPage();
        bags.navigateToShoulderOption();
        bags.goToStriveBag();
        strive.addStriveShoulderBagToCart();
        cart.deleteItemInCart();
        Assert.assertTrue(cart.verifyRemovalOfCartItems());
    }

    @Test(enabled = true)//7
    public void tShirtPromotionCheckOut() {
        HomePage home = new HomePage(getDriver());
        LoginPage gologin = new LoginPage(getDriver());
        WomensTeesPage wtees = new WomensTeesPage(getDriver());
        DesireeFitnessTeePage desiree = new DesireeFitnessTeePage(getDriver());
        CartPage cart = new CartPage(getDriver());
        ShippingPage ship = new ShippingPage(getDriver());
        PaymentPage pay = new PaymentPage(getDriver());
        CheckOutSuccessPage cosp = new CheckOutSuccessPage(getDriver());
        home.navigateToSignIn();
        gologin.customerLogin(Login.EMAIL.getLogin(), Login.PASSWORD.getLogin());
        home.navigateDirectlyToWomenTees();
        wtees.navigateToDesireeTee();
        desiree.addDesireeFitnessTeeToCart();
        cart.adjustItemsInCart();
        desiree.adjustQuantity();
        cart.navigateToCheckout();
        ship.shippingSelection();
        pay.placeOrder();
        Assert.assertTrue(cosp.verifyReceiptFromOrder());
    }

    @Test(enabled = false)//7
    public void addToComparisonList() {
        HomePage home = new HomePage(getDriver());
        LoginPage login = new LoginPage(getDriver());
        WomensTeesPage wtees = new WomensTeesPage(getDriver());
        DesireeFitnessTeePage desiree = new DesireeFitnessTeePage(getDriver());
        SinbadFitnessTankTopPage sin = new SinbadFitnessTankTopPage(getDriver());
        login.customerLogin(Login.EMAIL.getLogin(), Login.PASSWORD.getLogin());
        home.navigateDirectlyToWomenTees();
        wtees.navigateToDesireeTee();
        desiree.addDesireeTeeToComparisonList();
        home.navigateToSinBadTankTop();
        sin.addTankToComparisonList();
        Assert.assertTrue(sin.verifyAddedToComparisonList());
    }

    @Test(enabled = false)//8
    public void verifySortByDropDown() {
        HomePage home = new HomePage(getDriver());
        LoginPage login = new LoginPage(getDriver());
        WomensTeesPage wtees = new WomensTeesPage(getDriver());
        login.customerLogin(Login.EMAIL.getLogin(), Login.PASSWORD.getLogin());
        home.navigateDirectlyToWomenTees();
        wtees.priceFromSortBy();
        Assert.assertTrue(wtees.sortByPriceSuccess());
    }

    @Test(enabled = false)//9
    public void verifyItemLimiter() {
        HomePage home = new HomePage(getDriver());
        GearPage gear = new GearPage(getDriver());
        GearBagsPage bags = new GearBagsPage(getDriver());
        home.navigateToGear();
        gear.navigateToBagsPage();
        bags.changeQuantityOfItemsDisplayed();
        Assert.assertTrue(bags.verifyItemQuanititesShownChanged());
    }

    @Test(enabled = false)//10
    public void verifyLogIn() {
        HomePage home = new HomePage(getDriver());
        LoginPage login = new LoginPage(getDriver());
        login.customerLogin(Login.EMAIL.getLogin(), Login.PASSWORD.getLogin());
        Assert.assertTrue(home.verifyLoggedIn());
    }

    @Test(enabled = false)//11
    public void verifyIncorrectLogin() {
        LoginPage login = new LoginPage(getDriver());
        login.customerLogin(Login.INVALID_LOGIN.getLogin(), Login.PASSWORD.getLogin());
        Assert.assertTrue(login.verifyInvalidLogin());
    }
    @Test(enabled = false)//12
    public void guestCheckout() {
        HomePage home = new HomePage(getDriver());
        HeroHoodiePage hero = new HeroHoodiePage(getDriver());
        AeroTeeClassPage aero = new AeroTeeClassPage(getDriver());
        ShippingPage ship = new ShippingPage(getDriver());
        PaymentPage pay = new PaymentPage(getDriver());
        CheckOutSuccessPage cosp = new CheckOutSuccessPage(getDriver());
        home.navigateToHeroHoodie();
        hero.addHeroHoodieToCart();
        hero.navigateToAeroTee();
        aero.addAeroTeeToCart();
        ship.fillOutShippingInfo();
        pay.placeOrder();
        Assert.assertTrue(cosp.verifyCheckOutSuccess());
}
    @Test(enabled = false)//13
    public void accountCreation() {
        HomePage home = new HomePage(getDriver());
        LoginPage login = new LoginPage(getDriver());
        AccountCreationPage acp= new AccountCreationPage(getDriver());
        AccountPage ap = new AccountPage(getDriver());
        home.navigateToSignIn();
        login.navigateToCreateAccount();
        acp.createAccount();
        Assert.assertTrue(ap.verifyAccountCreated());
    }

    @Test(enabled = false)//14
    public void verifyAdvancedSearch() {
        HomePage home = new HomePage(getDriver());
        AdvancedSearchPage asp = new AdvancedSearchPage(getDriver());
        CatalogAdvancedSearchPage casp = new CatalogAdvancedSearchPage(getDriver());
        home.navigateToAdvancedSearch();
        asp.searchWithSKU();
        Assert.assertTrue(casp.verifyAdvancedSearch());
    }
    @Test(enabled = false)//15
    public void verifySearchBarFunctionality() {
        HomePage home = new HomePage(getDriver());
        SearchResultsPage srp = new SearchResultsPage(getDriver());
        home.searchBarField();
        Assert.assertTrue(srp.verifySearchBarFunctionality());
    }
    @Test(enabled = false)//16
    public void  verifySearchWithSKU() {
        HomePage home = new HomePage(getDriver());
        SearchResultsPage srp = new SearchResultsPage(getDriver());
        home.searchWithSKU();
        Assert.assertTrue(srp.verifySearchBarSkuFunctionality());
    }
//    @Test(enabled = false)
}
