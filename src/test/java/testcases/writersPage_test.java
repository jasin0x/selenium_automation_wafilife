package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BookdetailsAndOrderPage;
import pages.LoginPage;
import pages.WritersPage;
import utilities.DriverSetup;

import java.util.List;

public class writersPage_test extends DriverSetup {

    WritersPage writersPage = new WritersPage();
    LoginPage loginPage = new LoginPage();

    BookdetailsAndOrderPage bookdetailsAndOrderPage = new BookdetailsAndOrderPage();

    String booksPageUrl;

    @BeforeClass
    public void logIntoAccount(){
        getDriver().get(loginPage.loginPageUrl);
        loginPage.writeOnElement(loginPage.emailField,"mahamudulh7788@gmail.com");
        loginPage.writeOnElement(loginPage.passwordField,"zxcvqwer");
        loginPage.clickOnElement(loginPage.loginButton);
    }

    @Test
    public void hoverOnWriter() throws InterruptedException {
        WebElement elementToHover = getDriver().findElement(writersPage.writer);
        writersPage.hoverOverElement(elementToHover);
        Thread.sleep(2000);
    }

    @Test
    public void gotoWritersPage(){
        writersPage.clickOnElement(writersPage.writer);
        Assert.assertEquals(getDriver().getCurrentUrl(),writersPage.writerPageUrl);
        Assert.assertEquals(writersPage.getElementText(writersPage.writerPageHeadingElement),"লেখক");
    }

    @Test
    public void gotoNextPage() throws InterruptedException {
        writersPage.clickOnElement(writersPage.writer);
        writersPage.scrolltoElement(writersPage.nextPageButton);
        writersPage.clickOnElement(writersPage.nextPageButton);
        writersPage.pageNavigate("back");
        //Thread.sleep(2000);
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
                booksPageUrl = getDriver().getCurrentUrl();
                Assert.assertEquals(getDriver().getCurrentUrl(),writersPage.selectedWriterBooksUrl);
                Assert.assertEquals(writersPage.getElementText(writersPage.selectedWriterPageHeading), writersPage.preferredWriter);
                //Thread.sleep(5000);
                break;
            }
        }

    }

    //count books of the selected writer and get the name of the books
    @Test
    public void countAndGetBooksName(){
        //getDriver().get(booksPageUrl);
        List<WebElement> books = getDriver().findElements(writersPage.books);
        System.out.println("Total books: "+books.size());
        for (WebElement book: books){
            System.out.println(book.getText());
        }
    }

    @Test
    public void selectBook(){
        getDriver().findElement(By.linkText("Islam Science And Culture")).click();
        Assert.assertEquals(getDriver().getCurrentUrl(), bookdetailsAndOrderPage.bookDetailsUrl);
        Assert.assertEquals(writersPage.getElementText(bookdetailsAndOrderPage.bookHeading),"ISLAM SCIENCE AND CULTURE");
    }



}
