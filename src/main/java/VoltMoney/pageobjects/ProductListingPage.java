package VoltMoney.pageobjects;

import VoltMoney.abstractcomponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductListingPage extends AbstractComponents {
    WebDriver driver;
    public ProductListingPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    @FindBy(id = "shopping_cart_container")
    WebElement cartIcon;
    @FindBy(css = ".inventory_item")
    List<WebElement> productsAvailable;
    By productTitle = By.id("item_4_title_link");
    By addToCartButton = By.cssSelector(".btn_inventory");
    public List<WebElement> getProductList(){
        waitWebElementToAppear(cartIcon);
        List<WebElement> products = productsAvailable;
        return products;
    }
    public WebElement getProductName(String productName){
        WebElement product = getProductList().stream().filter(prod -> prod.findElement(productTitle)
                .getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
        return product;
    }
    public void addProductToCart(String productName){
        WebElement prod = getProductName(productName);
        prod.findElement(addToCartButton).click();

    }
    public CartPage clickOnCartIcon(){
        cartIcon.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }
    public ProductPage clickOnProduct(String productName){
        getProductName(productName).findElement(By.cssSelector(".inventory_item_name")).click();
        ProductPage productPage = new ProductPage(driver);
        return productPage;
    }
}
