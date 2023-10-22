package VoltMoney.pageobjects;

import VoltMoney.abstractcomponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends AbstractComponents {
    WebDriver driver;
    public CheckoutPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "first-name")
    WebElement checkoutFirstName;
    @FindBy(id = "last-name")
    WebElement checkoutLastName;
    @FindBy(id = "postal-code")
    WebElement checkoutPincode;
    @FindBy(xpath = "//input[@type='submit']")
    WebElement checkoutSubmitButton;
    By checkoutForm = By.cssSelector(".checkout_info");
    public void fillCheckoutFields(){
        waitElementLocated(checkoutForm);
        checkoutFirstName.sendKeys("Divya Ranjan");
        checkoutLastName.sendKeys("Dani");
        checkoutPincode.sendKeys("560066");
    }
    public CheckoutConfirmationPage clickOnCheckoutSubmit(){
        checkoutSubmitButton.click();
        CheckoutConfirmationPage checkoutConfirmationPage = new CheckoutConfirmationPage(driver);
        return checkoutConfirmationPage;
    }
}
