package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.WritersPage;
import utilities.DriverSetup;

import java.util.List;

public class writersPage_test extends DriverSetup {

    WritersPage writersPage = new WritersPage();
    LoginPage loginPage = new LoginPage();
    @BeforeMethod
    public void logIntoAccount(){
        getDriver().get(loginPage.loginPageUrl);
        loginPage.writeOnElement(loginPage.emailField,"mahamudulh7788@gmail.com");
        loginPage.writeOnElement(loginPage.passwordField,"zxcvqwer");
        loginPage.clickOnElement(loginPage.loginButton);
    }

    @Test
    public void gotoWritersPage(){
        writersPage.clickOnElement(writersPage.writer);
        Assert.assertEquals(getDriver().getCurrentUrl(),writersPage.writerPageUrl);
        Assert.assertEquals(writersPage.getElementText(writersPage.writerPageHeadingElement),"লেখক");
    }

    //scraping the writer by preferred name and searching by the scraped name
    @Test
    public void searchPreferredWriter() throws InterruptedException {
        writersPage.clickOnElement(writersPage.writer);
        String name;
        List<WebElement> writers = getDriver().findElements(writersPage.writersList);

        for (WebElement writer : writers) {
            if (writer.getText().equalsIgnoreCase(writersPage.preferredWriter)) {
                name = writer.getText();
                writersPage.writeOnElement(writersPage.searchBox,name);
                writersPage.clickOnElement(writersPage.searchButton);
                getDriver().findElement(By.linkText(name)).click();
                Thread.sleep(5000);
                break;
            }
        }

    }



}
