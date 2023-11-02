package testcases;

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
        Assert.assertTrue(homepage.isElementVisible(homepage.logInButton));
        //System.out.println(homepage.isElementVisible(homepage.loginButton));
    }

    @Test
    public void isLoginButtonClickable(){
        getDriver().get(homepage.homepageUrl);
        homepage.clickOnElement(homepage.logInButton);
        Assert.assertEquals(getDriver().getCurrentUrl(),loginPage.loginPageUrl);
        Assert.assertEquals(getDriver().getTitle(),loginPage.loginPageTitle);
    }

    @Test
    public void testNecessaryLinks(){
        getDriver().get(homepage.homepageUrl);
        WebElement necessaryLinkColumn = getDriver().findElement(homepage.necessaryColumn);
        for (int i=1; i<necessaryLinkColumn.findElements(By.tagName("a")).size(); i++){
            String clickonLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
            necessaryLinkColumn.findElements(By.tagName("a")).get(i).sendKeys(clickonLinkTab);
        }
        Set<String> abc = getDriver().getWindowHandles();//4
        Iterator<String> it = abc.iterator();

        while (it.hasNext()) {
            getDriver().switchTo().window(it.next());
            //System.out.println(getDriver().getTitle());

        }
    }


}
