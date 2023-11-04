package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.DataSet;
import utilities.DriverSetup;
import utilities.DataSet;

public class loginPage_test extends DriverSetup {

    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void getToTheUrl(){
        getDriver().get(loginPage.loginPageUrl);
    }

    @Test(priority = 1)
    public void checkHeading(){
        //getDriver().get(loginPage.loginPageUrl);
        Assert.assertEquals(loginPage.getElementText(loginPage.headingElement),loginPage.heading);
    }

    @Test(priority = 2)
    public void testInputFields(){
        //getDriver().get(loginPage.loginPageUrl);
        Assert.assertTrue(loginPage.isElementVisible(loginPage.emailField));
        Assert.assertTrue(loginPage.isElementVisible(loginPage.passwordField));
    }

    @Test(dataProvider = "invalidCredentials",dataProviderClass = DataSet.class, priority = 3)
    public void testLoginWithoutInvalidCredentials(String email, String password, String warning){
        //getDriver().get(loginPage.loginPageUrl);
        loginPage.writeOnElement(loginPage.emailField,email);
        loginPage.writeOnElement(loginPage.passwordField,password);
        loginPage.clickOnElement(loginPage.loginButton);
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.wafilife.com/my-account/");
        Assert.assertEquals(loginPage.getElementText(loginPage.warningMessage), warning);
        //Assert.assertTrue(loginPage.doContain(loginPage.warningMessage,warning));
        //System.out.println(loginPage.getElementText(loginPage.warningMessage));
    }

    @Test(priority = 4)
    public void loginWithValidCredential(){
        //getDriver().get(loginPage.loginPageUrl);
        loginPage.writeOnElement(loginPage.emailField,"mahamudulh7788@gmail.com");
        loginPage.writeOnElement(loginPage.passwordField,"zxcvqwer");
        loginPage.clickOnElement(loginPage.loginButton);
        Assert.assertEquals(loginPage.getElementText(loginPage.confirmationMessageElement),"আসসালামু আলাইকুম mahamudulh7788 (যদি আপনি mahamudulh7788 না হয়ে থাকেন তাহলে লগ অউট করুন)");
        loginPage.clickOnElement(loginPage.logOutButton);
        //System.out.println(loginPage.getElementText(loginPage.confirmationMessageElement));
    }

    @Test(priority = 5)
    public void isForgetPasswordButtonWorking(){
        //getDriver().get(loginPage.loginPageUrl);
        loginPage.clickOnElement(loginPage.forgetpassButton);
        Assert.assertEquals(loginPage.getElementText(loginPage.forgetPasswordMessageElement),loginPage.forgetPasswordMessage);
        System.out.println(loginPage.getElementText(loginPage.forgetPasswordMessageElement));
    }

    @Test(priority = 6)
    public void passwordResetConfirmation(){
        //getDriver().get(loginPage.loginPageUrl);
        loginPage.clickOnElement(loginPage.forgetpassButton);
        loginPage.writeOnElement(loginPage.emailForResetPassword,loginPage.userEmail);
        loginPage.clickOnElement(loginPage.passwordResetButton);
        Assert.assertEquals(loginPage.getElementText(loginPage.passowrdResetConfirmation),"আপনাকে পাসওয়ার্ড রিসেট ইমেইল পাঠানো হয়েছে।");
    }

}
