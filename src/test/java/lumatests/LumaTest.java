package lumatests;

import base.CommonAPI;
import luma.lumaenums.Login;
import luma.lumapages.*;
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
        LoginPage login = new LoginPage(getDriver());
        GearPage gear = new GearPage(getDriver());
        GearFitnessEquipmentPage gfep = new GearFitnessEquipmentPage(getDriver());
        SpriteYogaCompanionKitPage yoga = new SpriteYogaCompanionKitPage(getDriver());
        WishListPage wish = new WishListPage(getDriver());
        login.customerLogin(Login.EMAIL.getLogin(), Login.PASSWORD.getLogin());
        home.navigateToGear();
        gear.navigateToFitnessPage();
        gfep.navigateToBlueYogaBall();
        yoga.addYogaBallToWishList();
        wish.verifyAddedToWishList();
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
        bags.navigateToShoulderOptionAndSelectStriveBag();
        strive.addStriveShoulderBagToCart();
        cart.deleteItemInCart();
        Assert.assertTrue(cart.verifyRemovalOfCartItems());
    }

    @Test(enabled = false)//7
    public void tShirtPromotionCheckOut() {
        HomePage home = new HomePage(getDriver());
        LoginPage login = new LoginPage(getDriver());
        WomensTeesPage wtees = new WomensTeesPage(getDriver());
        DesireeFitnessTeePage desiree = new DesireeFitnessTeePage(getDriver());
        CartPage cart = new CartPage(getDriver());
        ShippingPage ship = new ShippingPage(getDriver());
        PaymentPage pay = new PaymentPage(getDriver());
        CheckOutSuccessPage success = new CheckOutSuccessPage(getDriver());
        login.customerLogin(Login.EMAIL.getLogin(), Login.PASSWORD.getLogin());
        home.navigateDirectlyToWomenTees();
        wtees.navigateToDesireeTee();
        desiree.addDesireeFitnessTeeToCart();
        cart.adjustItemsInCart();
        desiree.adjustQuantity();
        cart.navigateToCheckout();
        ship.shippingSelection();
        pay.placeOrder();
        Assert.assertTrue(success.verifyReceiptFromOrder());
    }

    @Test(enabled = false)//8
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

    @Test(enabled = false)//9
    public void verifySortByDropDown() {
        HomePage home = new HomePage(getDriver());
        LoginPage login = new LoginPage(getDriver());
        WomensTeesPage wtees = new WomensTeesPage(getDriver());
        login.customerLogin(Login.EMAIL.getLogin(), Login.PASSWORD.getLogin());
        home.navigateDirectlyToWomenTees();
        wtees.priceFromSortBy();
        Assert.assertTrue(wtees.sortByPriceSuccess());
    }

    @Test(enabled = false)//10
    public void verifyItemLimiter() {
        HomePage home = new HomePage(getDriver());
        GearPage gear = new GearPage(getDriver());
        GearBagsPage bags = new GearBagsPage(getDriver());
        home.navigateToGear();
        gear.navigateToBagsPage();
        bags.changeQuantityOfItemsDisplayed();
        Assert.assertTrue(bags.verifyItemQuantitiesShownChanged());
    }

    @Test(enabled = false)//11
    public void verifyLogIn() {
        HomePage home = new HomePage(getDriver());
        LoginPage login = new LoginPage(getDriver());
        login.customerLogin(Login.EMAIL.getLogin(), Login.PASSWORD.getLogin());
        Assert.assertTrue(home.verifyLoggedIn());
    }

    @Test(enabled = false)//12
    public void verifyIncorrectLogin() {
        LoginPage login = new LoginPage(getDriver());
        login.customerLogin(Login.INVALID_LOGIN.getLogin(), Login.PASSWORD.getLogin());
        Assert.assertTrue(login.verifyInvalidLogin());
    }

    @Test(enabled = false)//13
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

    @Test(enabled = false)//14
    public void accountCreation() {
        HomePage home = new HomePage(getDriver());
        LoginPage login = new LoginPage(getDriver());
        AccountCreationPage acp = new AccountCreationPage(getDriver());
        AccountPage ap = new AccountPage(getDriver());
        home.navigateToSignIn();
        login.navigateToCreateAccount();
        acp.createAccount();
        Assert.assertTrue(ap.verifyAccountCreated());
    }

    @Test(enabled = false)//15
    public void verifyAdvancedSearch() {
        HomePage home = new HomePage(getDriver());
        AdvancedSearchPage asp = new AdvancedSearchPage(getDriver());
        CatalogAdvancedSearchPage casp = new CatalogAdvancedSearchPage(getDriver());
        home.navigateToAdvancedSearch();
        asp.searchWithSKU();
        Assert.assertTrue(casp.verifyAdvancedSearch());
    }

    @Test(enabled = false)//16
    public void verifySearchBarFunctionality() {
        HomePage home = new HomePage(getDriver());
        SearchResultsPage srp = new SearchResultsPage(getDriver());
        home.searchBarField();
        Assert.assertTrue(srp.verifySearchBarFunctionality());
    }

    @Test(enabled = false)//17
    public void  verifySearchWithSKU() {
        HomePage home = new HomePage(getDriver());
        SearchResultsPage srp = new SearchResultsPage(getDriver());
        home.searchWithSKU();
        Assert.assertTrue(srp.verifySearchBarSkuFunctionality());
    }

    @Test(enabled = false)//18
    public void verify20PercentOffDiscountWithGuestOrder() {
        HomePage home = new HomePage(getDriver());
        LumaSalePage sale = new LumaSalePage(getDriver());
        WomensSalePage wsale = new WomensSalePage(getDriver());
        OliviaZipJacketPage ozjp = new OliviaZipJacketPage(getDriver());
        CartPage cart = new CartPage(getDriver());
        ShippingPage ship = new ShippingPage(getDriver());
        PaymentPage pay = new PaymentPage(getDriver());
        CheckOutSuccessPage success = new CheckOutSuccessPage(getDriver());
        home.navigateToSaleTab();
        sale.navigateToWomensDeals();
        wsale.navigateToOliviaZipJacket();
        ozjp.addOliviaZipJacketToCart();
        cart.adjustItemsInCart();
        ozjp.adjustQuantity();
        cart.navigateToCheckout();
        ship.fillOutShippingInfo();
        Assert.assertTrue(pay.verifyDiscountApplied());
        pay.placeOrder();
        Assert.assertTrue(success.verifyCheckOutSuccess());
    }

    @Test(enabled = false)//19
    public void verify20PercentOffDiscountWithKnownUserOrder() {
        HomePage home = new HomePage(getDriver());
        LoginPage login = new LoginPage(getDriver());
        LumaSalePage sale = new LumaSalePage(getDriver());
        WomensSalePage wsale = new WomensSalePage(getDriver());
        OliviaZipJacketPage ozjp = new OliviaZipJacketPage(getDriver());
        CartPage cart = new CartPage(getDriver());
        ShippingPage ship = new ShippingPage(getDriver());
        PaymentPage pay = new PaymentPage(getDriver());
        CheckOutSuccessPage success = new CheckOutSuccessPage(getDriver());
        login.customerLogin(Login.EMAIL.getLogin(), Login.PASSWORD.getLogin());
        home.navigateToSaleTab();
        sale.navigateToWomensDeals();
        wsale.navigateToOliviaZipJacket();
        ozjp.addOliviaZipJacketToCart();
        cart.adjustItemsInCart();
        ozjp.adjustQuantity();
        cart.navigateToCheckout();
        ship.shippingSelection();
        Assert.assertTrue(pay.verifyDiscountApplied());
        pay.placeOrder();
        Assert.assertTrue(success.verifyCheckOutSuccess());
    }

    @Test(enabled = false)//20
    public void verifyH2ODiscountWithGuest() {
        HomePage home = new HomePage(getDriver());
        LumaSalePage sale = new LumaSalePage(getDriver());
        GearPage gear = new GearPage(getDriver());
        GearFitnessEquipmentPage gfep = new GearFitnessEquipmentPage(getDriver());
        AffirmWaterBottlePage agua = new AffirmWaterBottlePage(getDriver());
        CartPage cart = new CartPage(getDriver());
        ShippingPage ship = new ShippingPage(getDriver());
        PaymentPage pay = new PaymentPage(getDriver());
        CheckOutSuccessPage success = new CheckOutSuccessPage(getDriver());
        home.navigateToSaleTab();
        sale.navigateToGearDeals();
        gear.navigateToFitnessWaterBottle();
        gfep.navigateToAffirmWaterBottle();
        agua.addAffirmBottleToCart();
        cart.addCouponCode();
        ship.fillOutShippingInfo();
        Assert.assertTrue(pay.verifyBottleDiscount());
        pay.placeOrder();
       Assert.assertTrue(success.verifyCheckOutSuccess());
    }

    @Test(enabled = false)//21
    public void verifyInvalidCouponOnDuplicateOrder() {
        HomePage home = new HomePage(getDriver());
        LoginPage login = new LoginPage(getDriver());
        LumaSalePage sale = new LumaSalePage(getDriver());
        GearPage gear = new GearPage(getDriver());
        GearFitnessEquipmentPage gfep = new GearFitnessEquipmentPage(getDriver());
        AffirmWaterBottlePage agua = new AffirmWaterBottlePage(getDriver());
        CartPage cart = new CartPage(getDriver());
        PaymentPage pay = new PaymentPage(getDriver());
        home.navigateToSaleTab();
        login.customerLogin(Login.EMAIL.getLogin(), Login.PASSWORD.getLogin());
        sale.navigateToGearDeals();
        gear.navigateToFitnessWaterBottle();
        gfep.navigateToAffirmWaterBottle();
        agua.addAffirmBottleToCart();
        cart.addUsedCouponCode();
        Assert.assertTrue(pay.verifyInvalidBottleDiscount());
    }

    @Test(enabled = false)//22
    public void verifyH20DiscountWithRegisteredUser() {
        HomePage home = new HomePage(getDriver());
        LoginPage login = new LoginPage(getDriver());
        AccountCreationPage acp = new AccountCreationPage(getDriver());
        AccountPage ap = new AccountPage(getDriver());
        AddressBookPage abp = new AddressBookPage(getDriver());
        LumaSalePage sale = new LumaSalePage(getDriver());
        GearPage gear = new GearPage(getDriver());
        GearFitnessEquipmentPage gfep = new GearFitnessEquipmentPage(getDriver());
        AffirmWaterBottlePage agua = new AffirmWaterBottlePage(getDriver());
        CartPage cart = new CartPage(getDriver());
        ShippingPage ship = new ShippingPage(getDriver());
        PaymentPage pay = new PaymentPage(getDriver());
        CheckOutSuccessPage success = new CheckOutSuccessPage(getDriver());
        home.navigateToSignIn();
        login.navigateToCreateAccount();
        acp.createAccount();
        ap.navigateToAddressBook();
        abp.addAddressToProfile();
        ap.navigateToHomeScreen();
        home.navigateToSaleTab();
        sale.navigateToGearDeals();
        gear.navigateToFitnessWaterBottle();
        gfep.navigateToAffirmWaterBottle();
        agua.addAffirmBottleToCart();
        cart.addCouponCode();
        ship.shippingSelection();
        Assert.assertTrue(pay.verifyBottleDiscount());
        pay.placeOrder();
        Assert.assertTrue(success.verifyCheckOutSuccess());
    }

    @Test(enabled = false)//23
    public void addFromWishListToCartFromWhatsNew() {
        HomePage home = new HomePage(getDriver());
        LoginPage login = new LoginPage(getDriver());
        WhatsNewPage wnp = new WhatsNewPage(getDriver());
        CartPage cart = new CartPage(getDriver());
        home.navigateToSignIn();
        login.customerLogin(Login.EMAIL.getLogin(), Login.PASSWORD.getLogin());
        home.navigateToWhatsNewTab();
        wnp.addProductFromWishListToCart();
        Assert.assertTrue(cart.verifyWishListItemInCart());
        cart.moveItemFromCartBackToWishList();
    }

    @Test(enabled = false)//24
    public void verifyProductDetailsVisibleOnWishList() {
        HomePage home = new HomePage(getDriver());
        LoginPage login = new LoginPage(getDriver());
        GearPage gear = new GearPage(getDriver());
        GearFitnessEquipmentPage fitness = new GearFitnessEquipmentPage(getDriver());
        SpriteYogaCompanionKitPage yoga = new SpriteYogaCompanionKitPage(getDriver());
        login.customerLogin(Login.EMAIL.getLogin(), Login.PASSWORD.getLogin());
        home.navigateToGear();
        gear.navigateToFitnessPage();
        fitness.navigateToBlueYogaBall();
        yoga.addYogaBundleWithDetailsToWishList();
        Assert.assertTrue(new WishListPage(getDriver()).verifyAddedToWishListWithDetails());
    }

    @Test(enabled = false)//25
    public void verifyReviewFunctionality() {
        HomePage home = new HomePage(getDriver());
        LoginPage gologin = new LoginPage(getDriver());
        MensTeesPage mtees = new MensTeesPage(getDriver());
        StrikeEnduranceTeePage strike = new StrikeEnduranceTeePage(getDriver());
        home.navigateToSignIn();
        gologin.customerLogin(Login.EMAIL.getLogin(), Login.PASSWORD.getLogin());
        home.navigateToMensTees();
        mtees.goToStrikeEnudranceTee();
        strike.createReviewForStrikeTee();
        strike.inputReviewInfo();
        Assert.assertTrue(new StrikeEnduranceTeePage(getDriver()).verifyReviewAddedForModeration());
        strike.navigateToAccountPage();
        Assert.assertTrue(new AccountPage(getDriver()).verifyRecentReviewsVisible());
    }

    @Test(enabled = false)//26
    public void logInWithConnectDB() {
        HomePage home = new HomePage(getDriver());
        LoginPage login = new LoginPage(getDriver());
        home.navigateToSignIn();
        login.logInWithSQLDatabase();
        Assert.assertTrue(new HomePage(getDriver()).verifyDbLoggedIn());
        }

    @Test(enabled = false)//27
    public void createAccountWithoutEmailAndPassword() {
        HomePage home = new HomePage(getDriver());
        LoginPage login = new LoginPage(getDriver());
        AccountCreationPage acc = new AccountCreationPage(getDriver());
        home.navigateToSignIn();
        login.navigateToCreateAccount();
        acc.invalidAccountCreation();
        acc.confirmAccountCreation();
        Assert.assertTrue(acc.verifyInvalidAccountCreationWithoutEmail());
        Assert.assertTrue(acc.verifyInvalidAccountCreationWithoutPassword());
    }

    @Test(enabled = true)//28
    public void editNewsletterSubscription() {
        LoginPage login = new LoginPage(getDriver());
        AccountPage acc = new AccountPage(getDriver());
        NewsletterSubscriptionPage news = new NewsletterSubscriptionPage(getDriver());
        login.customerLogin(Login.EMAIL.getLogin(),Login.PASSWORD.getLogin());
        new StrikeEnduranceTeePage(getDriver()).navigateToAccountPage();
        acc.navigateToNewsletterSubscriptionTab();
        news.enableSubscriptionAndConfirm();
        Assert.assertTrue(acc.verifyNewsletterSubscriptionSuccessful());
    }

    @Test(enabled = false)//29
    public void editBillingAddress() {
        LoginPage login = new LoginPage(getDriver());
        AccountPage acc = new AccountPage(getDriver());
        AddressBookPage addy = new AddressBookPage(getDriver());
        login.customerLogin(Login.EMAIL.getLogin(),Login.PASSWORD.getLogin());
        new StrikeEnduranceTeePage(getDriver()).navigateToAccountPage();
        acc.navigateToAddressBook();
        addy.changeCurrentBillingAddress();
        Assert.assertTrue(addy.verifyBillingAddressChanged());
    }

    @Test(enabled = false)//30
    public void reorderFromPastOrders() {
        LoginPage login = new LoginPage(getDriver());
        AccountPage acc = new AccountPage(getDriver());
        MyOrdersPage ordr = new MyOrdersPage(getDriver());
        CartPage cart = new CartPage(getDriver());
        ShippingPage ship = new ShippingPage(getDriver());
        PaymentPage pay = new PaymentPage(getDriver());
        CheckOutSuccessPage success = new CheckOutSuccessPage(getDriver());
        login.customerLogin(Login.EMAIL.getLogin(),Login.PASSWORD.getLogin());
        new StrikeEnduranceTeePage(getDriver()).navigateToAccountPage();
        acc.navigateToMyOrders();
        ordr.addMostRecentOrderToCart();
        cart.navigateToCheckout();
        ship.shippingSelection();
        pay.placeOrder();
        Assert.assertTrue(success.verifyReceiptFromOrder());
    }

    @Test(enabled = true, dataProvider = "Login", dataProviderClass = DataProviderLuma.class)
    public void loginWithDataProvider(String dataEmail, String dataPassword) {
        LoginPage login = new LoginPage(getDriver());
        HomePage home = new HomePage(getDriver());
        login.loginWithDataProvider(dataEmail, dataPassword);
        Assert.assertTrue(home.verifyLoggedIn());
    }

    @Test(enabled = false)
    public void loginWithExcel() {
        LoginPage login = new LoginPage(getDriver());
        HomePage home = new HomePage(getDriver());
        login.excelLogin();
        Assert.assertTrue(home.verifyLoggedIn());
    }
}


