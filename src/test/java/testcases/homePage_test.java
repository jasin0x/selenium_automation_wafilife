package testcases;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverSetup;

import java.util.Iterator;
import java.util.Set;

public class homePage_test extends DriverSetup {

    HomePage homepage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(priority = 1)
    @Description("Visiting the home page")
    public void testHomepageUrl(){
        getDriver().get(homepage.homepageUrl);
        homepage.addScreenShot("After visiting the homepage");
        Assert.assertEquals(getDriver().getCurrentUrl(),homepage.homepageUrl);
    }

    @Test(priority = 2)
    @Description("Checking the home page title")
    public void testHomepageTitle(){
        getDriver().get(homepage.homepageUrl);
        homepage.addScreenShot("Checking the home page URL");
        Assert.assertEquals(getDriver().getTitle(),homepage.homepageTitle);
    }

    @Test(priority = 3)
    @Description("Checking the visibility of login button")
    public void isLoginButtonVisible(){
        getDriver().get(homepage.homepageUrl);
        homepage.addScreenShot("Checking the presence of login button");
        Assert.assertTrue(homepage.isElementVisible(homepage.logInButton));
        //System.out.println(homepage.isElementVisible(homepage.loginButton));
    }

    @Test(priority = 3)
    @Description("Checking the functionality of login button")
    public void isLoginButtonClickable(){
        getDriver().get(homepage.homepageUrl);
        homepage.clickOnElement(homepage.logInButton);
        homepage.addScreenShot("After clicking on login button");
        Assert.assertEquals(getDriver().getCurrentUrl(),loginPage.loginPageUrl);
        Assert.assertEquals(getDriver().getTitle(),loginPage.loginPageTitle);
    }

    @Test(priority = 4)
    @Description("Testing linked pages")
    public void testNecessaryLinks(){
        getDriver().get(homepage.homepageUrl);
        WebElement necessaryLinkColumn = getDriver().findElement(homepage.necessaryColumn);
        for (int i=1; i<necessaryLinkColumn.findElements(By.tagName("a")).size(); i++){
            String clickonLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
            necessaryLinkColumn.findElements(By.tagName("a")).get(i).sendKeys(clickonLinkTab);
        }
        Set<String> abc = getDriver().getWindowHandles();
        Iterator<String> it = abc.iterator();

        while (it.hasNext()) {
            getDriver().switchTo().window(it.next());
            //System.out.println(getDriver().getTitle());

        }
        homepage.addScreenShot(" Checking all the clickable link in the footer");
    }


}
