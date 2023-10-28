package pages;

import org.openqa.selenium.By;

public class BookDetailsPage {

    public String bookDetailsUrl = "https://www.wafilife.com/shop/books/islam-science-and-culture/";
    public By bookHeading = By.cssSelector(".product_title.entry-title");
    public By bookPrice = By.cssSelector("ins[class='single-product-sale-price'] bdi:nth-child(1)");
    public By orderButton = By.xpath("//div[@id='main-module-container']//button[1]");
}
