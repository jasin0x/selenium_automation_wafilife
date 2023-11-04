package testcases;

import io.qameta.allure.Description;
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
    @Description("Visiting book details page")
    public void goToBookDetailsPage(){
        getDriver().get(loginPage.loginPageUrl);
        loginPage.writeOnElement(loginPage.emailField,"mahamudulh7788@gmail.com");
        loginPage.writeOnElement(loginPage.passwordField,"zxcvqwer");
        loginPage.clickOnElement(loginPage.loginButton);
        getDriver().get(bookdetailsAndOrderPage.bookDetailsUrl);
        bookdetailsAndOrderPage.addScreenShot("After going to the preferred book's details page");
        Assert.assertEquals(getDriver().getCurrentUrl(),bookdetailsAndOrderPage.bookDetailsUrl);
    }

    @Test(priority = 2)
    @Description("Order button's visibility")
    public void checkOrderButtonPresence(){
        bookdetailsAndOrderPage.addScreenShot("Checking the order button presence");
        Assert.assertTrue(bookdetailsAndOrderPage.isElementVisible(bookdetailsAndOrderPage.orderButton));
    }

    @Test(priority = 3)
    @Description("Adding book to the cart")
    public void checkIfProductIsAddedToCart() throws InterruptedException {
        bookdetailsAndOrderPage.clickOnElement(bookdetailsAndOrderPage.orderButton);
        Thread.sleep(5000);
        bookdetailsAndOrderPage.addScreenShot("Confirming product added to the cart");
        Assert.assertEquals(bookdetailsAndOrderPage.getElementText(bookdetailsAndOrderPage.itemConfirmation),"1 items");
        bookdetailsAndOrderPage.clickOnElement(bookdetailsAndOrderPage.confirmationWindowClose);
    }

    @Test(priority = 4)
    @Description("Filling billing info and logging out")
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
        bookdetailsAndOrderPage.addScreenShot("After completing the billing information");
        Thread.sleep(5000);
        bookdetailsAndOrderPage.clickOnElement(bookdetailsAndOrderPage.myAccount);
        bookdetailsAndOrderPage.clickOnElement(bookdetailsAndOrderPage.cartButton);
        bookdetailsAndOrderPage.clickOnElement(bookdetailsAndOrderPage.clearCart);
        loginPage.clickOnElement(loginPage.logOutButton);
        Thread.sleep(5000);
        bookdetailsAndOrderPage.addScreenShot("After Logging out");
        Assert.assertEquals(getDriver().getCurrentUrl(),loginPage.loginPageUrl);
    }

}
