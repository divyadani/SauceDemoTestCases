package VoltMoney.featureflow;

import VoltMoney.pageobjects.*;
import VoltMoney.testComponents.BrowserInvoke;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginToCheckout extends BrowserInvoke {
    @Test(priority = 1)
    public void checkoutFunctionality() throws IOException {

        String productName = "Sauce Labs Backpack";
        LoginPage loginPage = launchApplication();
        loginPage.goTo();

        ProductListingPage productListingPage = loginPage.inputLoginCredential();
        productListingPage.getProductName(productName);
        productListingPage.addProductToCart(productName);
        CartPage cartPage = productListingPage.clickOnCartIcon();

        boolean productPresent = cartPage.isProductPresent(productName);
        Assert.assertTrue(productPresent);

        CheckoutPage checkoutPage = cartPage.checkoutIconClick();

        checkoutPage.fillCheckoutFields();
        CheckoutConfirmationPage checkoutConfirmationPage = checkoutPage.clickOnCheckoutSubmit();

        boolean productPresentInCheckout = checkoutConfirmationPage.isProductPresent(productName);
        Assert.assertTrue(productPresentInCheckout);
        OrderConfirmationPage orderConfirmationPage = checkoutConfirmationPage.clickOnFinishButton();

        String orderConfirmMessage = orderConfirmationPage.confirmOrder();

        Assert.assertEquals(orderConfirmMessage, "Thank you for your order!");
        orderConfirmationPage.clickBackToHome();
    }
}
