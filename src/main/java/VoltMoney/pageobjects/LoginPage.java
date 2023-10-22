package VoltMoney.pageobjects;

import VoltMoney.abstractcomponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponents {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement userName;
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;
    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginButton;
    @FindBy(css = ".error-message-container")
    WebElement errorTextBox;

    public void goTo(){
        driver.get("https://www.saucedemo.com/");

    }
    public ProductListingPage inputLoginCredential(){
        userName.sendKeys("visual_user");
        password.sendKeys("secret_sauce");
        loginButton.click();
        ProductListingPage productListingPage = new ProductListingPage(driver);
        return productListingPage;
    }
    public String errorTextForWrongLogin(){
        String errorMessage = errorTextBox.getText();
        return errorMessage;
    }
    public void multiLoginCredential(String email, String passwordValue){
        userName.sendKeys(email);
        password.sendKeys(passwordValue);
        loginButton.click();
    }
}
