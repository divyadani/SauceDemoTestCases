package VoltMoney.featureflow;

import VoltMoney.pageobjects.CartPage;
import VoltMoney.pageobjects.LoginPage;
import VoltMoney.pageobjects.ProductListingPage;
import VoltMoney.pageobjects.ProductPage;
import VoltMoney.testComponents.BrowserInvoke;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class RemoveProduct extends BrowserInvoke{
    @Test(priority = 2)
    public void removeProdListingPage() throws IOException {
        String productName = "Sauce Labs Backpack";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        ProductListingPage productListingPage = loginPage.inputLoginCredential();

        productListingPage.getProductName(productName);
        productListingPage.addProductToCart(productName);
        productListingPage.addProductToCart(productName);
        CartPage cartPage = productListingPage.clickOnCartIcon();

        boolean productPresent = cartPage.isProductPresent(productName);
        Assert.assertFalse(productPresent);
    }

    @Test(priority = 3)
    public void removeProdFrmProdPage() throws IOException {
        String productName = "Sauce Labs Backpack";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        ProductListingPage productListingPage = loginPage.inputLoginCredential();

        ProductPage productPage = productListingPage.clickOnProduct(productName);
        productPage.addProductToCart();

        CartPage cartPage = productPage.clickOnCart();

        boolean productPresent = cartPage.isProductPresent(productName);

        if(productPresent){
            driver.navigate().back();
            productPage.addProductToCart();
        }
        productPage.clickOnCart();
        Assert.assertEquals(0,cartPage.totalProductsPresent());
    }
    @Test(priority = 4)
    public void removeProdFromCart() throws IOException {
        String productName = "Sauce Labs Backpack";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        ProductListingPage productListingPage = loginPage.inputLoginCredential();

        productListingPage.addProductToCart(productName);
        CartPage cartPage = productListingPage.clickOnCartIcon();

        boolean productPresent = cartPage.isProductPresent(productName);

        if(productPresent){
            cartPage.clickOnRemove();
        }
        Assert.assertEquals(0,cartPage.totalProductsPresent());
    }
}
