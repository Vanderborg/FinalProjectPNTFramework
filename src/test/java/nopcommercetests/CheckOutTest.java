package nopcommercetests;

import base.CommonAPI;
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
import nopcommercepages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutTest extends CommonAPI {

    @Test(enabled = true) //1
    public void testCreditCardCheckout() {
        NopCommerceStorePage commerce = new NopCommerceStorePage(getDriver());
        RegisterLoginPage register = new RegisterLoginPage(getDriver());
        ItemsPage item = new ItemsPage(getDriver());
        CheckOutPage checkOut = new CheckOutPage(getDriver());
        CartPage cart = new CartPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        register.registerAndLogin(String.valueOf(Day._10.getDayValue()), Month.April.getMonthValue(), Year._1994.getYearValue());
        item.buildYourOwnComputerGoToShoppingCart(CPU.CPU_1.getProcessorOption(), Ram.RAM_OPTION_2.getRamOption(), HDD.HDD_1.getHDDOption(), OSOption.OS_OPTION_2.getOSOption());
        cart.clickCheckOut();
        checkOut.registeredUserCreditCardCheckout(CCProvider.CARD_VISA.getCardProvider(), ExpMonth.July.getCardExpMonth(), ExpYear._2034.getCardExpYear());
        Assert.assertTrue(complete.yourOrderHasBeenSuccessFullyIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false) //2
    public void testCheckMoneyOrderCheckout() {
        NopCommerceStorePage commerce = new NopCommerceStorePage(getDriver());
        RegisterLoginPage register = new RegisterLoginPage(getDriver());
        ItemsPage item = new ItemsPage(getDriver());
        CheckOutPage checkOut = new CheckOutPage(getDriver());
        CartPage cart = new CartPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        register.registerAndLogin(String.valueOf(Day._31.getDayValue()), Month.December.getMonthValue(), Year._1999.getYearValue());
        item.buildYourOwnComputerGoToShoppingCart(CPU.CPU_2.getProcessorOption(), Ram.RAM_OPTION_1.getRamOption(), HDD.HDD_2.getHDDOption(), OSOption.OS_OPTION_1.getOSOption());
        cart.clickCheckOut();
        checkOut.registeredUserCheckMoneyCheckout();
        Assert.assertTrue(complete.thankYouTextIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false) //3
    public void testMultipleItemsCheckOutWithCheckMoneyOrder() {
        NopCommerceStorePage commerce = new NopCommerceStorePage(getDriver());
        RegisterLoginPage register = new RegisterLoginPage(getDriver());
        CheckOutPage checkOut = new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        CartPage cart = new CartPage(getDriver());
        register.registerAndLogin(String.valueOf(Day._31.getDayValue()), Month.December.getMonthValue(), Year._2000.getYearValue());
        commerce.addMultipleItemsToCart(CPU.CPU_2.getProcessorOption(), Ram.RAM_OPTION_2.getRamOption(), HDD.HDD_1.getHDDOption(), OSOption.OS_OPTION_2.getOSOption());
        cart.clickCheckOut();
        checkOut.registeredUserCheckMoneyCheckout();
        Assert.assertTrue(complete.yourOrderHasBeenSuccessFullyIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false) //4
    public void testMultipleItemsCheckOutWithCreditCard() {
        NopCommerceStorePage commerce = new NopCommerceStorePage(getDriver());
        RegisterLoginPage register = new RegisterLoginPage(getDriver());
        CheckOutPage checkOut = new CheckOutPage(getDriver());
        CartPage cart = new CartPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        register.registerAndLogin(String.valueOf(Day._31.getDayValue()), Month.December.getMonthValue(), Year._1994.getYearValue());
        commerce.addMultipleItemsToCart(CPU.CPU_1.getProcessorOption(), Ram.RAM_OPTION_2.getRamOption(), HDD.HDD_1.getHDDOption(), OSOption.OS_OPTION_2.getOSOption());
        cart.clickCheckOut();
        checkOut.registeredUserCreditCardCheckout(CCProvider.CARD_DISCOVER.getCardProvider(), ExpMonth.December.getCardExpMonth(), ExpYear._2025.getCardExpYear());
        Assert.assertTrue(complete.thankYouTextIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false) //5
    public void testAddTwoItemsDeleteOneCheckOutWithCreditCard() {
        NopCommerceStorePage commerce = new NopCommerceStorePage(getDriver());
        ItemsPage item = new ItemsPage(getDriver());
        RegisterLoginPage register = new RegisterLoginPage(getDriver());
        CartPage cart = new CartPage(getDriver());
        CheckOutPage checkOut = new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        register.registerAndLogin(String.valueOf(Day._31.getDayValue()), Month.December.getMonthValue(), Year._2000.getYearValue());
        item.addComputerAndGiftCardToCart(CPU.CPU_2.getProcessorOption(), Ram.RAM_OPTION_1.getRamOption(), HDD.HDD_2.getHDDOption(), OSOption.OS_OPTION_1.getOSOption());
        cart.deleteSingleItemAndAddHTC8Phone();
        cart.clickCheckOut();
        checkOut.registeredUserCreditCardCheckout(CCProvider.CARD_VISA.getCardProvider(), ExpMonth.September.getCardExpMonth(), ExpYear._2034.getCardExpYear());
        Assert.assertTrue(complete.thankYouTextIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false) //6
    public void testAddTwoItemsDeleteOneCheckOutWithCheckMoneyOrder() {
        NopCommerceStorePage commerce = new NopCommerceStorePage(getDriver());
        ItemsPage item = new ItemsPage(getDriver());
        RegisterLoginPage register = new RegisterLoginPage(getDriver());
        CartPage cart = new CartPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        CheckOutPage checkOut = new CheckOutPage(getDriver());
        register.registerAndLogin(String.valueOf(Day._15.getDayValue()), Month.June.getMonthValue(), Year._2001.getYearValue());
        item.addComputerAndGiftCardToCart(CPU.CPU_1.getProcessorOption(), Ram.RAM_OPTION_2.getRamOption(), HDD.HDD_1.getHDDOption(), OSOption.OS_OPTION_2.getOSOption());
        cart.deleteSingleItemAndAddHTC8Phone();
        cart.clickCheckOut();
        checkOut.registeredUserCheckMoneyCheckout();
        Assert.assertTrue(complete.yourOrderHasBeenSuccessFullyIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false) //7
    public void testCompareTwoItemsAddToCartWithCreditCard() {
        NopCommerceStorePage commerce = new NopCommerceStorePage(getDriver());
        ItemsPage item = new ItemsPage(getDriver());
        CheckOutPage checkOut = new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        commerce.compareItemsThenAddToCart();
        item.clickShoppingCartToCheckOut();
        checkOut.checkOutAsGuestWithCreditCard(CCProvider.CARD_VISA.getCardProvider(), ExpMonth.September.getCardExpMonth(), ExpYear._2034.getCardExpYear());
        Assert.assertTrue(complete.yourOrderHasBeenSuccessFullyIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false) //8
    public void testCompareTwoItemsAddToCartWithCheckMoneyOrder() {
        NopCommerceStorePage commerce = new NopCommerceStorePage(getDriver());
        ItemsPage item = new ItemsPage(getDriver());
        CheckOutPage checkOut = new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        commerce.compareItemsThenAddToCart();
        item.clickShoppingCartToCheckOut();
        checkOut.checkOutAsGuestWithCheckMoney();
        Assert.assertTrue(complete.yourOrderHasBeenSuccessFullyIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false) //9
    public void testCompareAddClearDeleteCheckoutGuestCreditCard() {
        NopCommerceStorePage commerce = new NopCommerceStorePage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        CheckOutPage checkOut = new CheckOutPage(getDriver());
        commerce.compareItemsDeleteOneAddToCart();
        checkOut.checkOutAsGuestWithCreditCard(CCProvider.CARD_VISA.getCardProvider(), ExpMonth.September.getCardExpMonth(), ExpYear._2034.getCardExpYear());
        Assert.assertTrue(complete.yourOrderHasBeenSuccessFullyIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false) //10
    public void testCompareAddClearDeleteCheckoutGuestCheckMoney() {
        NopCommerceStorePage commerce = new NopCommerceStorePage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        CheckOutPage checkOut = new CheckOutPage(getDriver());
        commerce.compareItemsDeleteOneAddToCart();
        checkOut.checkOutAsGuestWithCheckMoney();
        Assert.assertTrue(complete.yourOrderHasBeenSuccessFullyIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false) //11
    public void testSearchItemCheckOutGuestCreditCard() {
        NopCommerceStorePage commerce = new NopCommerceStorePage(getDriver());
        CheckOutPage checkOut = new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        commerce.searchAppleAddToCart(Items.APPLE_MAC.getItems());
        checkOut.checkOutAsGuestWithCreditCard(CCProvider.CARD_VISA.getCardProvider(), ExpMonth.September.getCardExpMonth(), ExpYear._2034.getCardExpYear());
        Assert.assertTrue(complete.yourOrderHasBeenSuccessFullyIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false) //12
    public void testSearchItemCheckOutGuestCheckMoney() {
        NopCommerceStorePage commerce = new NopCommerceStorePage(getDriver());
        CheckOutPage checkOut = new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        commerce.searchAppleAddToCart(Items.APPLE_MAC.getItems());
        checkOut.checkOutAsGuestWithCheckMoney();
        Assert.assertTrue(complete.yourOrderHasBeenSuccessFullyIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false) //13
    public void testChangeQuantityOfItemCheckOutGuestCreditCard() {
        NopCommerceStorePage commerce = new NopCommerceStorePage(getDriver());
        CheckOutPage checkOut = new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        ItemsPage item = new ItemsPage(getDriver());
        commerce.addBuildYourComputerToCart();
        item.buildYourOwnComputerAddToCart(CPU.CPU_2.getProcessorOption(), Ram.RAM_OPTION_1.getRamOption(), HDD.HDD_2.getHDDOption(), OSOption.OS_OPTION_1.getOSOption());
        item.changeProductQuantity(5);
        checkOut.checkOutAsGuestWithCreditCard(CCProvider.CARD_VISA.getCardProvider(), ExpMonth.September.getCardExpMonth(), ExpYear._2034.getCardExpYear());
        Assert.assertTrue(complete.yourOrderHasBeenSuccessFullyIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false) //14
    public void testChangeQuantityOfItemCheckOutGuestCheckMoney() {
        NopCommerceStorePage commerce = new NopCommerceStorePage(getDriver());
        CheckOutPage checkOut = new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        ItemsPage item = new ItemsPage(getDriver());
        commerce.addBuildYourComputerToCart();
        item.buildYourOwnComputerAddToCart(CPU.CPU_2.getProcessorOption(), Ram.RAM_OPTION_1.getRamOption(), HDD.HDD_2.getHDDOption(), OSOption.OS_OPTION_1.getOSOption());
        item.changeProductQuantity(10);
        checkOut.checkOutAsGuestWithCheckMoney();
        Assert.assertTrue(complete.yourOrderHasBeenSuccessFullyIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false) //15
    public void testChangeQuantityUpdateOfItemCheckOutGuestCheckMoney() {
        NopCommerceStorePage commerce = new NopCommerceStorePage(getDriver());
        CheckOutPage checkOut = new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        ItemsPage item = new ItemsPage(getDriver());
        commerce.addBuildYourComputerToCart();
        item.buildYourOwnComputerAddToCart(CPU.CPU_2.getProcessorOption(), Ram.RAM_OPTION_1.getRamOption(), HDD.HDD_2.getHDDOption(), OSOption.OS_OPTION_1.getOSOption());
        item.mistakeChangeProductQuantity(50, 1);
        checkOut.checkOutAsGuestWithCheckMoney();
        Assert.assertTrue(complete.yourOrderHasBeenSuccessFullyIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false) //16
    public void testChangeQuantityUpdateOfItemCheckOutGuestCreditCard() {
        NopCommerceStorePage commerce = new NopCommerceStorePage(getDriver());
        CheckOutPage checkOut = new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        ItemsPage item = new ItemsPage(getDriver());
        commerce.addBuildYourComputerToCart();
        item.buildYourOwnComputerAddToCart(CPU.CPU_2.getProcessorOption(), Ram.RAM_OPTION_1.getRamOption(), HDD.HDD_2.getHDDOption(), OSOption.OS_OPTION_1.getOSOption());
        item.mistakeChangeProductQuantity(50, 1);
        checkOut.checkOutAsGuestWithCreditCard(CCProvider.CARD_VISA.getCardProvider(), ExpMonth.September.getCardExpMonth(), ExpYear._2034.getCardExpYear());
        Assert.assertTrue(complete.yourOrderHasBeenSuccessFullyIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }
}