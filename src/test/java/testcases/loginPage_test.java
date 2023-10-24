package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.DataSet;
import utilities.DriverSetup;
import utilities.DataSet;

public class loginPage_test extends DriverSetup {

    LoginPage loginPage = new LoginPage();

    @Test
    public void checkHeading(){
        getDriver().get(loginPage.loginPageUrl);
        Assert.assertEquals(loginPage.getElementText(loginPage.headingElement),loginPage.heading);
    }

    @Test
    public void testInputFields(){
        getDriver().get(loginPage.loginPageUrl);
        Assert.assertTrue(loginPage.isElementVisible(loginPage.emailField));
        Assert.assertTrue(loginPage.isElementVisible(loginPage.passwordField));
    }

    @Test(dataProvider = "invalidCredentials",dataProviderClass = DataSet.class)
    public void testLoginWithoutInvalidCredentials(String email, String password, String warning){
        getDriver().get(loginPage.loginPageUrl);
        loginPage.writeOnElement(loginPage.emailField,email);
        loginPage.writeOnElement(loginPage.passwordField,password);
        loginPage.clickOnElement(loginPage.loginButton);
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.wafilife.com/my-account/");
        //Assert.assertEquals(loginPage.getElementText(loginPage.warningMessage), warning);
        Assert.assertTrue(loginPage.doContain(loginPage.warningMessage,warning));
        System.out.println(loginPage.getElementText(loginPage.warningMessage));
    }

    @Test
    public void loginWithValidCredential(){
        getDriver().get(loginPage.loginPageUrl);
        loginPage.writeOnElement(loginPage.emailField,"mahamudlh7788@gmail.com");
        loginPage.writeOnElement(loginPage.passwordField,"zxcvqwer");
        System.out.println(loginPage.getElementText(loginPage.confirmationMessageElement));
    }

}
