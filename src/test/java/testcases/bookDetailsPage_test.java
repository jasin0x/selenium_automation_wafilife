package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BookdetailsAndOrderPage;
import pages.LoginPage;
import utilities.DriverSetup;

public class bookDetailsPage_test extends DriverSetup {



    BookdetailsAndOrderPage bookdetailsAndOrderPage = new BookdetailsAndOrderPage();
    LoginPage loginPage = new LoginPage();
    JavascriptExecutor js = (JavascriptExecutor)getDriver();
    Select select;
    Actions actions;
    @Test(priority = 1)
    public void goToBookDetailsPage(){
        getDriver().get(loginPage.loginPageUrl);
        loginPage.writeOnElement(loginPage.emailField,"mahamudulh7788@gmail.com");
        loginPage.writeOnElement(loginPage.passwordField,"zxcvqwer");
        loginPage.clickOnElement(loginPage.loginButton);
        getDriver().get(bookdetailsAndOrderPage.bookDetailsUrl);
        Assert.assertEquals(getDriver().getCurrentUrl(),bookdetailsAndOrderPage.bookDetailsUrl);
    }

    @Test(priority = 2)
    public void checkOrderButtonPresence(){
        Assert.assertTrue(bookdetailsAndOrderPage.isElementVisible(bookdetailsAndOrderPage.orderButton));
    }

    @Test(priority = 3)
    public void checkIfProductIsAddedToCart() throws InterruptedException {
        bookdetailsAndOrderPage.clickOnElement(bookdetailsAndOrderPage.orderButton);
        Thread.sleep(5000);
        Assert.assertEquals(bookdetailsAndOrderPage.getElementText(bookdetailsAndOrderPage.itemConfirmation),"1 items");
        bookdetailsAndOrderPage.clickOnElement(bookdetailsAndOrderPage.confirmationWindowClose);
    }

    @Test(priority = 4)
    public void orderConfirmation() throws InterruptedException {

        actions = new Actions(getDriver());
        bookdetailsAndOrderPage.clickOnElement(bookdetailsAndOrderPage.cartButton);
        bookdetailsAndOrderPage.clickOnElement(bookdetailsAndOrderPage.cartOrderButton);
        bookdetailsAndOrderPage.writeOnElement(bookdetailsAndOrderPage.nameField,"Luca Modric");
        bookdetailsAndOrderPage.writeOnElement(bookdetailsAndOrderPage.phoneNumberField,"+8801977776565");
        bookdetailsAndOrderPage.writeOnElement(bookdetailsAndOrderPage.emailField,"+alu@ymail.com");
        bookdetailsAndOrderPage.selectArea(bookdetailsAndOrderPage.districtDropdown,"Faridpur ");
        bookdetailsAndOrderPage.selectArea(bookdetailsAndOrderPage.areaDropdown,"ফরিদপুর সদর");
        bookdetailsAndOrderPage.writeOnElement(bookdetailsAndOrderPage.address,"Banani, Dhaka");
        bookdetailsAndOrderPage.clickOnElement(bookdetailsAndOrderPage.deliveryChargeOption);
        //bookdetailsAndOrderPage.clickOnElement(bookdetailsAndOrderPage.paymentMethod);
        Thread.sleep(5000);
        bookdetailsAndOrderPage.clickOnElement(bookdetailsAndOrderPage.myAccount);
        bookdetailsAndOrderPage.clickOnElement(bookdetailsAndOrderPage.cartButton);
        bookdetailsAndOrderPage.clickOnElement(bookdetailsAndOrderPage.clearCart);
        loginPage.clickOnElement(loginPage.logOutButton);
        Thread.sleep(5000);
        Assert.assertEquals(getDriver().getCurrentUrl(),loginPage.loginPageUrl);
    }

}
