package VoltMoney.featureflow;

import VoltMoney.pageobjects.LoginPage;
import VoltMoney.testComponents.BrowserInvoke;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ErrorValidation extends BrowserInvoke {
    @Test(dataProvider = "loginCred",priority = 5)
    public void errorValidation(String email, String password) throws IOException {
        LoginPage loginPage = launchApplication();
        loginPage.multiLoginCredential(email, password);
        String errorMessage = loginPage.errorTextForWrongLogin();
        Assert.assertEquals(errorMessage,"Epic sadface: Username and password do not match any user in this service");
    }
    @DataProvider(name="loginCred")
    public Object[][] getData(){
        return new Object[][] {
                {"standard_user", "visual_user"},
                {"visual_user", "visual_user"}
        };
    }
}
