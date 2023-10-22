package VoltMoney.pageobjects;

import VoltMoney.abstractcomponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends AbstractComponents {
    WebDriver driver;
    public ProductPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".btn_inventory")
    WebElement productAddToCart;
    @FindBy(id = "shopping_cart_container")
    WebElement cartIcon;
    By productDetail = By.cssSelector(".inventory_details_img_container");
    public void addProductToCart(){
        waitElementLocated(productDetail);
        productAddToCart.click();
    }
    public CartPage clickOnCart(){
        cartIcon.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }
}
