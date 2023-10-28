package pages;

import org.openqa.selenium.By;

public class WritersPage extends basePage{
    public By writer = By.xpath("//span[contains(text(),'লেখক')]");
    public String writerPageUrl = "https://www.wafilife.com/cat/books/author/";
    public By writerPageHeadingElement = By.cssSelector(".heading-title.page-title");
    public By writersList = By.cssSelector(".archive-product-subcategories li");
    public By searchBox = By.id("cat_search");
    public By searchButton = By.cssSelector("button[class='btn btn-default'] i[class='fa fa-search']");
    public String preferredWriter = "M. SHAMSHER ALI";
    public By nextPageButton = By.cssSelector(".next.page-numbers");
    public By books = By.className(".product_item_wrapper");

    public String selectedWriterBooksUrl = "https://www.wafilife.com/cat/books/author/m-shamsher-ali/";
    public By selectedWriterPageHeading = By.cssSelector(".heading-title.page-title");

    public String preferredBook = "Islam Science And Culture";
}
