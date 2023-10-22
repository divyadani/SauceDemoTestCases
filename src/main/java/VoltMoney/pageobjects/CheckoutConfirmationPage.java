package VoltMoney.pageobjects;

import VoltMoney.abstractcomponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutConfirmationPage extends AbstractComponents {
    WebDriver driver;
    public CheckoutConfirmationPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".inventory_item_name")
    List<WebElement> totalProductsName;
    @FindBy(id = "finish")
    WebElement finishButton;
    By totalItems = By.cssSelector(".cart_item");
    public List<WebElement> productsInCheckout(){
        waitElementLocated(totalItems);
        List<WebElement> checkoutProducts = totalProductsName;
        return checkoutProducts;
    }
    public boolean isProductPresent(String productName){
        boolean productPresentInCheckout = productsInCheckout().stream().anyMatch(prod -> prod.getText()
                .equalsIgnoreCase(productName));
        return productPresentInCheckout;
    }
    public OrderConfirmationPage clickOnFinishButton(){
        finishButton.click();
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        return orderConfirmationPage;
    }
}
