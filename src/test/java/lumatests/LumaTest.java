package lumatests;

import base.CommonAPI;
import lumaenums.Login;
import lumapages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LumaTest extends CommonAPI {

    @Test(enabled = false)
    public void addSinbadTankTopToCart() {
        HomePage home = new HomePage(getDriver());
        LoginPage login = new LoginPage(getDriver());
        SinbadFitnessTankTopPage sin = new SinbadFitnessTankTopPage(getDriver());
        login.customerLogin(Login.EMAIL.getLogin(),Login.PASSWORD.getLogin());
        home.naviagteToSinBadTankTop();
        sin.sinbadTankTopAddToCart();
        Assert.assertTrue(sin.verifyAddedToCart());
    }

    @Test(enabled = false)
    public void subscribeToNewsletter() {
        HomePage home = new HomePage(getDriver());
        LoginPage gologin = new LoginPage(getDriver());
        home.navigateToSignIn();
        gologin.customerLogin(Login.EMAIL.getLogin(),Login.PASSWORD.getLogin());
        home.subscribeToNewsLetter(Login.EMAIL.getLogin());
    }

    @Test(enabled = false)
    public void viewPreviousOrder() {
        HomePage home = new HomePage(getDriver());
        OrdersAndReturnsPage order = new OrdersAndReturnsPage(getDriver());
        home.navigateToOrdersAndReturns();
        order.fillInOrderInfo();
    }

    @Test(enabled = false)
    public void verifyWishList() {
        HomePage home = new HomePage(getDriver());
        LoginPage gologin = new LoginPage(getDriver());
        GearPage gear = new GearPage(getDriver());
        GearFitnessEquipmentPage fitness = new GearFitnessEquipmentPage(getDriver());
        SpriteYogaCompanionKitPage yoga = new SpriteYogaCompanionKitPage(getDriver());
        home.navigateToSignIn();
        gologin.customerLogin(Login.EMAIL.getLogin(),Login.PASSWORD.getLogin());
        home.navigateToGear();
        gear.navigateToFitnessPage();
        fitness.navigateToBlueYogaBall();
        yoga.addYogaBallToWishList();
    }

    @Test(enabled = false)
    public void contactUs() {
        HomePage home = new HomePage(getDriver());
        LoginPage gologin = new LoginPage(getDriver());
        ContactUsPage contact = new ContactUsPage(getDriver());
        home.navigateToSignIn();
        gologin.customerLogin(Login.EMAIL.getLogin(),Login.PASSWORD.getLogin());
        home.navigateToContactUs();
        contact.submitFeedbackToSite();
    }

    @Test(enabled = false)
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
    }
    @Test(enabled = true)
    public void tShirtPromotionCheckOut() {
        HomePage home = new HomePage(getDriver());
        LoginPage gologin = new LoginPage(getDriver());
        WomensTeesPage wtees = new WomensTeesPage(getDriver());
        DesireeFitnessTeePage desiree = new DesireeFitnessTeePage(getDriver());
        CartPage cart = new CartPage(getDriver());
        ShippingPage ship = new ShippingPage(getDriver());
        PaymentPage pay = new PaymentPage(getDriver());
        home.navigateToSignIn();
        gologin.customerLogin(Login.EMAIL.getLogin(),Login.PASSWORD.getLogin());
        home.navigateDirectlyToWomenTees();
        wtees.navigateToDesireeTee();
        desiree.addDesireeFitnessTeeToCart();
        cart.adjustItemsInCart();
        desiree.adjustQuantity();
        cart.navigateToCheckout();
        ship.shippingSelection();
        pay.placeOrder();
    }

    @Test(enabled = false)
    public void addToComparisonList() {
        HomePage home = new HomePage(getDriver());
        LoginPage login = new LoginPage(getDriver());
        WomensTeesPage wtees = new WomensTeesPage(getDriver());
        DesireeFitnessTeePage desiree = new DesireeFitnessTeePage(getDriver());
        SinbadFitnessTankTopPage sin = new SinbadFitnessTankTopPage(getDriver());
        login.customerLogin(Login.EMAIL.getLogin(),Login.PASSWORD.getLogin());
        home.navigateDirectlyToWomenTees();
        wtees.navigateToDesireeTee();
        desiree.addDesireeTeeToComparisonList();
        home.naviagteToSinBadTankTop();
        sin.addTankToComparisonList();
        Assert.assertTrue(sin.verifyAddedToComparisonList());
    }

    @Test(enabled = false)
    public void verifySortByDropDown() {
        HomePage home = new HomePage(getDriver());
        LoginPage login = new LoginPage(getDriver());
        WomensTeesPage wtees = new WomensTeesPage(getDriver());
        login.customerLogin(Login.EMAIL.getLogin(),Login.PASSWORD.getLogin());
        home.navigateDirectlyToWomenTees();
        wtees.priceFromSortBy();
        waitFor(4);
    }

    @Test(enabled = false)
    public void verifyItemLimiter() {
        HomePage home = new HomePage(getDriver());
        GearPage gear = new GearPage(getDriver());
        GearBagsPage bags = new GearBagsPage(getDriver());
        home.navigateToGear();
        gear.navigateToBagsPage();
        bags.changeQuantityOfItemsDisplayed();
        Assert.assertTrue(bags.verifyItemQuanititesShownChanged());
    }
}
