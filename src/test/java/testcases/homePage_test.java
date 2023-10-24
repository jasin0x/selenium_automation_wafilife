package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverSetup;

import java.sql.Driver;

public class homePage_test extends DriverSetup {

    HomePage homepage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void testHomepageUrl(){
        getDriver().get(homepage.homepageUrl);
        Assert.assertEquals(getDriver().getCurrentUrl(),homepage.homepageUrl);
    }

    @Test
    public void testHomepageTitle(){
        getDriver().get(homepage.homepageUrl);
        Assert.assertEquals(getDriver().getTitle(),homepage.homepageTitle);
    }

    @Test
    public void isLoginButtonVisible(){
        getDriver().get(homepage.homepageUrl);
        Assert.assertTrue(homepage.isElementVisible(homepage.loginButton));
        //System.out.println(homepage.isElementVisible(homepage.loginButton));
    }

    @Test
    public void isLoginButtonClickable(){
        getDriver().get(homepage.homepageUrl);
        homepage.clickOnElement(homepage.loginButton);
        Assert.assertEquals(getDriver().getCurrentUrl(),loginPage.loginPageUrl);
        Assert.assertEquals(getDriver().getTitle(),loginPage.loginPageTitle);
    }


}
