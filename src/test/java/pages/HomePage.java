package pages;

import org.openqa.selenium.By;

public class HomePage extends basePage {

    public String homepageUrl = "https://www.wafilife.com/";
    public String homepageTitle = "Buy Islamic Books - Online Book Shop in Bangladesh | Wafilife";
    public By loginButton = By.cssSelector("a[title='আমার অ্যাকাউন্ট']");
    public By footer = By.cssSelector(".next.page-numbers");
    public By necessaryColumn = By.cssSelector(".fifth-footer-widget-area-2.col-sm-6");

}
