package nopcommercetests;

import base.CommonAPI;
import nopcommercedataproviders.NOPTestData;
import nopcommerceenums.computeroptions.CPU;
import nopcommerceenums.computeroptions.HDD;
import nopcommerceenums.computeroptions.OSOption;
import nopcommerceenums.computeroptions.Ram;
import nopcommerceenums.creditcard.CCProvider;
import nopcommerceenums.creditcard.ExpMonth;
import nopcommerceenums.creditcard.ExpYear;
import nopcommerceenums.datesoptions.Day;
import nopcommerceenums.datesoptions.Month;
import nopcommerceenums.datesoptions.Year;
import nopcommerceenums.searchitems.Items;
import nopcommerceobjects.Customer;
import nopcommerceobjects.State;
import nopcommercepages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutTest extends CommonAPI {

    @Test()
    public void testCreditCardCheckout() {
        new RegisterLoginPage(getDriver()).registerAndLogin(String.valueOf(Day._10.getDayValue()), Month.April.getMonthValue(), Year._1994.getYearValue(), new Customer());
        new ItemsPage(getDriver()).buildComputerAndGoToCart(CPU.CPU_2.getProcessorOption(), Ram.RAM_OPTION_1.getRamOption(), HDD.HDD_2.getHDDOption(), OSOption.OS_OPTION_1.getOSOption());
        new CartPage(getDriver()).clickCheckOut();
        new CheckOutPage(getDriver()).regUserCCCheckout(CCProvider.CARD_VISA.getCardProvider(), ExpMonth.July.getCardExpMonth(), ExpYear._2034.getCardExpYear(), new Customer(), new State());
        Assert.assertTrue(new CheckOutCompletePage(getDriver()).yourOrderHasBeenSuccessFullyIsDisplayed());
        new CheckOutCompletePage(getDriver()).clickBackToHomeButton();
        Assert.assertTrue(new NopCommerceHomePage(getDriver()).welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false)
    public void testCheckMoneyOrderCheckout() {
        new RegisterLoginPage(getDriver()).registerAndLogin(String.valueOf(Day._31.getDayValue()), Month.December.getMonthValue(), Year._1999.getYearValue(), new Customer());
        new ItemsPage(getDriver()).buildComputerAndGoToCart(CPU.CPU_2.getProcessorOption(), Ram.RAM_OPTION_1.getRamOption(), HDD.HDD_2.getHDDOption(), OSOption.OS_OPTION_1.getOSOption());
        new CartPage(getDriver()).clickCheckOut();
        new CheckOutPage(getDriver()).regUserCheckMoneyCheckout(new Customer(), new State());
        Assert.assertTrue(new CheckOutCompletePage(getDriver()).thankYouTextIsDisplayed());
        new CheckOutCompletePage(getDriver()).clickBackToHomeButton();
        Assert.assertTrue(new NopCommerceHomePage(getDriver()).welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false)
    public void testMultipleItemsCheckOutWithCheckMoneyOrder() {
        new RegisterLoginPage(getDriver()).registerAndLogin(String.valueOf(Day._31.getDayValue()), Month.December.getMonthValue(), Year._2000.getYearValue(), new Customer());
        new NopCommerceHomePage(getDriver()).addMultipleItemsToCart(CPU.CPU_2.getProcessorOption(), Ram.RAM_OPTION_2.getRamOption(), HDD.HDD_1.getHDDOption(), OSOption.OS_OPTION_2.getOSOption());
        new CartPage(getDriver()).clickCheckOut();
        new CheckOutPage(getDriver()).regUserCheckMoneyCheckout(new Customer(), new State());
        Assert.assertTrue(new CheckOutCompletePage(getDriver()).yourOrderHasBeenSuccessFullyIsDisplayed());
        new CheckOutCompletePage(getDriver()).clickBackToHomeButton();
        Assert.assertTrue(new NopCommerceHomePage(getDriver()).welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false) //4
    public void testMultipleItemsCheckOutWithCreditCard() {
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        RegisterLoginPage register = new RegisterLoginPage(getDriver());
        CheckOutPage checkOut = new CheckOutPage(getDriver());
        CartPage cart = new CartPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        register.registerAndLogin(String.valueOf(Day._31.getDayValue()), Month.December.getMonthValue(), Year._1994.getYearValue(), new Customer());
        commerce.addMultipleItemsToCart(CPU.CPU_1.getProcessorOption(), Ram.RAM_OPTION_2.getRamOption(), HDD.HDD_1.getHDDOption(), OSOption.OS_OPTION_2.getOSOption());
        cart.clickCheckOut();
        checkOut.regUserCCCheckout(CCProvider.CARD_DISCOVER.getCardProvider(), ExpMonth.December.getCardExpMonth(), ExpYear._2025.getCardExpYear(), new Customer(), new State());
        Assert.assertTrue(complete.thankYouTextIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false) //5
    public void testAddTwoItemsDeleteOneCheckOutWithCreditCard() {
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        ItemsPage item = new ItemsPage(getDriver());
        RegisterLoginPage register = new RegisterLoginPage(getDriver());
        CartPage cart = new CartPage(getDriver());
        CheckOutPage checkOut = new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        register.registerAndLogin(String.valueOf(Day._31.getDayValue()), Month.December.getMonthValue(), Year._2000.getYearValue(), new Customer());
        item.addComputerAndGiftCardToCart(CPU.CPU_2.getProcessorOption(), Ram.RAM_OPTION_1.getRamOption(), HDD.HDD_2.getHDDOption(), OSOption.OS_OPTION_1.getOSOption());
        cart.deleteSingleItemAndAddHTC8Phone();
        cart.clickCheckOut();
        checkOut.regUserCCCheckout(CCProvider.CARD_VISA.getCardProvider(), ExpMonth.September.getCardExpMonth(), ExpYear._2034.getCardExpYear(), new Customer(), new State());
        Assert.assertTrue(complete.thankYouTextIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false) //6
    public void testAddTwoItemsDeleteOneCheckOutWithCheckMoneyOrder() {
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        ItemsPage item = new ItemsPage(getDriver());
        RegisterLoginPage register = new RegisterLoginPage(getDriver());
        CartPage cart = new CartPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        CheckOutPage checkOut = new CheckOutPage(getDriver());
        register.registerAndLogin(String.valueOf(Day._15.getDayValue()), Month.June.getMonthValue(), Year._2001.getYearValue(), new Customer());
        item.addComputerAndGiftCardToCart(CPU.CPU_1.getProcessorOption(), Ram.RAM_OPTION_2.getRamOption(), HDD.HDD_1.getHDDOption(), OSOption.OS_OPTION_2.getOSOption());
        cart.deleteSingleItemAndAddHTC8Phone();
        cart.clickCheckOut();
        checkOut.regUserCheckMoneyCheckout(new Customer(), new State());
        Assert.assertTrue(complete.yourOrderHasBeenSuccessFullyIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false) //7
    public void testCompareTwoItemsAddToCartWithCreditCard() {
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        ItemsPage item = new ItemsPage(getDriver());
        CheckOutPage checkOut = new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        commerce.compareItemsThenAddToCart();
        item.clickShoppingCartToCheckOut();
        checkOut.checkOutAsGuestWithCreditCard(CCProvider.CARD_VISA.getCardProvider(), ExpMonth.September.getCardExpMonth(), ExpYear._2034.getCardExpYear(), new Customer(), new State());
        Assert.assertTrue(complete.yourOrderHasBeenSuccessFullyIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false) //8
    public void testCompareTwoItemsAddToCartWithCheckMoneyOrder() {
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        ItemsPage item = new ItemsPage(getDriver());
        CheckOutPage checkOut = new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        commerce.compareItemsThenAddToCart();
        item.clickShoppingCartToCheckOut();
        checkOut.checkOutAsGuestWithCheckMoney(new Customer(), new State());
        Assert.assertTrue(complete.yourOrderHasBeenSuccessFullyIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false) //9
    public void testCompareAddClearDeleteCheckoutGuestCreditCard() {
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        CheckOutPage checkOut = new CheckOutPage(getDriver());
        commerce.compareItemsDeleteOneAddToCart();
        checkOut.checkOutAsGuestWithCreditCard(CCProvider.CARD_VISA.getCardProvider(), ExpMonth.September.getCardExpMonth(), ExpYear._2034.getCardExpYear(), new Customer(), new State());
        Assert.assertTrue(complete.yourOrderHasBeenSuccessFullyIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false) //10
    public void testCompareAddClearDeleteCheckoutGuestCheckMoney() {
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        CheckOutPage checkOut = new CheckOutPage(getDriver());
        commerce.compareItemsDeleteOneAddToCart();
        checkOut.checkOutAsGuestWithCheckMoney(new Customer(), new State());
        Assert.assertTrue(complete.yourOrderHasBeenSuccessFullyIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false) //11
    public void testSearchItemCheckOutGuestCreditCard() {
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        CheckOutPage checkOut = new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        commerce.searchAppleAddToCart(Items.APPLE_MAC.getItems());
        checkOut.checkOutAsGuestWithCreditCard(CCProvider.CARD_VISA.getCardProvider(), ExpMonth.September.getCardExpMonth(), ExpYear._2034.getCardExpYear(), new Customer(), new State());
        Assert.assertTrue(complete.yourOrderHasBeenSuccessFullyIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false) //12
    public void testSearchItemCheckOutGuestCheckMoney() {
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        CheckOutPage checkOut = new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        commerce.searchAppleAddToCart(Items.APPLE_MAC.getItems());
        checkOut.checkOutAsGuestWithCheckMoney(new Customer(), new State());
        Assert.assertTrue(complete.yourOrderHasBeenSuccessFullyIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false) //13
    public void testChangeQuantityOfItemCheckOutGuestCreditCard() {
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        CheckOutPage checkOut = new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        ItemsPage item = new ItemsPage(getDriver());
        commerce.addBuildYourComputerToCart();
        item.buildYourOwnComputerAddToCart(CPU.CPU_2.getProcessorOption(), Ram.RAM_OPTION_1.getRamOption(), HDD.HDD_2.getHDDOption(), OSOption.OS_OPTION_1.getOSOption());
        item.changeProductQuantity(5);
        checkOut.checkOutAsGuestWithCreditCard(CCProvider.CARD_VISA.getCardProvider(), ExpMonth.September.getCardExpMonth(), ExpYear._2034.getCardExpYear(), new Customer(), new State());
        Assert.assertTrue(complete.yourOrderHasBeenSuccessFullyIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false) //14
    public void testChangeQuantityOfItemCheckOutGuestCheckMoney() {
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        CheckOutPage checkOut = new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        ItemsPage item = new ItemsPage(getDriver());
        commerce.addBuildYourComputerToCart();
        item.buildYourOwnComputerAddToCart(CPU.CPU_2.getProcessorOption(), Ram.RAM_OPTION_1.getRamOption(), HDD.HDD_2.getHDDOption(), OSOption.OS_OPTION_1.getOSOption());
        item.changeProductQuantity(10);
        checkOut.checkOutAsGuestWithCheckMoney(new Customer(), new State());
        Assert.assertTrue(complete.yourOrderHasBeenSuccessFullyIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false) //15
    public void testChangeQuantityUpdateOfItemCheckOutGuestCheckMoney() {
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        CheckOutPage checkOut = new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        ItemsPage item = new ItemsPage(getDriver());
        commerce.addBuildYourComputerToCart();
        item.buildYourOwnComputerAddToCart(CPU.CPU_2.getProcessorOption(), Ram.RAM_OPTION_1.getRamOption(), HDD.HDD_2.getHDDOption(), OSOption.OS_OPTION_1.getOSOption());
        item.mistakeChangeProductQuantity(50, 1);
        checkOut.checkOutAsGuestWithCheckMoney(new Customer(), new State());
        Assert.assertTrue(complete.yourOrderHasBeenSuccessFullyIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false) //16
    public void testChangeQuantityUpdateOfItemCheckOutGuestCreditCard() {
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        CheckOutPage checkOut = new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        ItemsPage item = new ItemsPage(getDriver());
        commerce.addBuildYourComputerToCart();
        item.buildYourOwnComputerAddToCart(CPU.CPU_2.getProcessorOption(), Ram.RAM_OPTION_1.getRamOption(), HDD.HDD_2.getHDDOption(), OSOption.OS_OPTION_1.getOSOption());
        item.mistakeChangeProductQuantity(50, 1);
        checkOut.checkOutAsGuestWithCreditCard(CCProvider.CARD_VISA.getCardProvider(), ExpMonth.September.getCardExpMonth(), ExpYear._2034.getCardExpYear(), new Customer(), new State());
        Assert.assertTrue(complete.yourOrderHasBeenSuccessFullyIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }
}