package VoltMoney.pageobjects;

import VoltMoney.abstractcomponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends AbstractComponents {
    WebDriver driver;
    public OrderConfirmationPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "checkout_complete_container")
    WebElement orderConfirmation;
    @FindBy(xpath = "//div/h2[@class='complete-header']")
    WebElement thankYouText;
    @FindBy(id = "back-to-products")
    WebElement backToHomeButton;
    public String confirmOrder(){
        waitWebElementToAppear(orderConfirmation);
        String orderConfirmMessage = thankYouText.getText();
        return orderConfirmMessage;
    }
    public ProductListingPage clickBackToHome(){
        backToHomeButton.click();
        ProductListingPage productListingPage = new ProductListingPage(driver);
        return productListingPage;
    }
}
