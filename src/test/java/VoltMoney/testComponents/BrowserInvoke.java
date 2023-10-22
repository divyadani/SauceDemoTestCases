package VoltMoney.testComponents;

import VoltMoney.pageobjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BrowserInvoke {
    public WebDriver driver;
    public WebDriver selectBrowser() throws IOException {
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//VoltMoney//resources//GlobalData.properties");
        properties.load(file);
        String browserName = properties.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        if(browserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        if(browserName.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
    @BeforeMethod
    public LoginPage launchApplication() throws IOException {
        driver = selectBrowser();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        return loginPage;
    }
    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }
}
