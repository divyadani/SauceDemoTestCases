package VoltMoney.pageobjects;

import VoltMoney.abstractcomponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponents {
    WebDriver driver;
    public CartPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "cart_contents_container")
    WebElement cartProduct;
    @FindBy(css = ".inventory_item_name")
    List<WebElement> cartProducts;
    @FindBy(id = "checkout")
    WebElement cartIcon;
    @FindBy(css = ".cart_item")
    List<WebElement> productsCount;
    @FindBy(css = ".cart_list")
    WebElement cartList;
    @FindBy(css = ".cart_button")
    WebElement removeButton;
    public List<WebElement> availableProductsInCart(){
        waitWebElementToAppear(cartProduct);
        List<WebElement> productsInCart = cartProducts;
        return productsInCart;
    }
    public boolean isProductPresent(String productName){
        boolean productPresent = availableProductsInCart().stream().anyMatch(prod -> prod.getText().equalsIgnoreCase(productName));
        return productPresent;
    }
    public CheckoutPage checkoutIconClick(){
        cartIcon.click();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        return checkoutPage;
    }
    public int totalProductsPresent(){
        waitWebElementToAppear(cartList);
        int totalProducts = productsCount.size();
        return totalProducts;
    }
    public void clickOnRemove(){
        removeButton.click();
    }
}
