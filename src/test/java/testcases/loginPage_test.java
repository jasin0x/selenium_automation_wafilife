package testcases;

import io.qameta.allure.Description;
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
    @Description("Visiting the login page")
    public void checkHeading(){
        //getDriver().get(loginPage.loginPageUrl);
        loginPage.addScreenShot("After visiting the login page");
        Assert.assertEquals(loginPage.getElementText(loginPage.headingElement),loginPage.heading);
    }

    @Test(priority = 2)
    @Description("Check the presence of email and password field")
    public void testInputFields(){
        //getDriver().get(loginPage.loginPageUrl);
        loginPage.addScreenShot("Checking the presence of email and password field");
        Assert.assertTrue(loginPage.isElementVisible(loginPage.emailField));
        Assert.assertTrue(loginPage.isElementVisible(loginPage.passwordField));
    }

    @Test(dataProvider = "invalidCredentials",dataProviderClass = DataSet.class, priority = 3)
    @Description("Testing login functionality with invalid credentials")
    public void testLoginWithoutInvalidCredentials(String email, String password, String warning){
        //getDriver().get(loginPage.loginPageUrl);
        loginPage.writeOnElement(loginPage.emailField,email);
        loginPage.writeOnElement(loginPage.passwordField,password);
        loginPage.clickOnElement(loginPage.loginButton);
        loginPage.addScreenShot("After trying to logging in with wrong credentials");
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.wafilife.com/my-account/");
        Assert.assertEquals(loginPage.getElementText(loginPage.warningMessage), warning);
        //Assert.assertTrue(loginPage.doContain(loginPage.warningMessage,warning));
        //System.out.println(loginPage.getElementText(loginPage.warningMessage));
    }

    @Test(priority = 4)
    @Description("Testing login functionality with valid credentials")
    public void loginWithValidCredential(){
        //getDriver().get(loginPage.loginPageUrl);
        loginPage.writeOnElement(loginPage.emailField,"mahamudulh7788@gmail.com");
        loginPage.writeOnElement(loginPage.passwordField,"zxcvqwer");
        loginPage.clickOnElement(loginPage.loginButton);
        loginPage.addScreenShot("After logging in with correct credentials");
        Assert.assertEquals(loginPage.getElementText(loginPage.confirmationMessageElement),"আসসালামু আলাইকুম mahamudulh7788 (যদি আপনি mahamudulh7788 না হয়ে থাকেন তাহলে লগ অউট করুন)");
        loginPage.clickOnElement(loginPage.logOutButton);
        //System.out.println(loginPage.getElementText(loginPage.confirmationMessageElement));
    }

    @Test(priority = 5)
    @Description("Checking the forget password button")
    public void isForgetPasswordButtonWorking(){
        //getDriver().get(loginPage.loginPageUrl);
        loginPage.clickOnElement(loginPage.forgetpassButton);
        loginPage.addScreenShot("Verify the functionality of forget password button");
        Assert.assertEquals(loginPage.getElementText(loginPage.forgetPasswordMessageElement),loginPage.forgetPasswordMessage);
        System.out.println(loginPage.getElementText(loginPage.forgetPasswordMessageElement));
    }

    @Test(priority = 6)
    @Description("Checking the password reset functionality")
    public void passwordResetConfirmation(){
        //getDriver().get(loginPage.loginPageUrl);
        loginPage.clickOnElement(loginPage.forgetpassButton);
        loginPage.writeOnElement(loginPage.emailForResetPassword,loginPage.userEmail);
        loginPage.clickOnElement(loginPage.passwordResetButton);
        loginPage.addScreenShot("After trying to reset the password");
        Assert.assertEquals(loginPage.getElementText(loginPage.passowrdResetConfirmation),"আপনাকে পাসওয়ার্ড রিসেট ইমেইল পাঠানো হয়েছে।");
    }

}
