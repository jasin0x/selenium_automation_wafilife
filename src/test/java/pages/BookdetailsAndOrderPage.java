package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class BookdetailsAndOrderPage extends basePage{

    public String bookDetailsUrl = "https://www.wafilife.com/shop/books/islam-science-and-culture/";
    public By bookHeading = By.cssSelector(".product_title.entry-title");
    public By bookPrice = By.cssSelector("ins[class='single-product-sale-price'] bdi:nth-child(1)");
    public By orderButton = By.xpath("//div[@class='body-wrapper']//button[2]");
    public By itemConfirmation = By.xpath("(//span[normalize-space()='1 items'])[1]");
    public By confirmationWindowClose = By.xpath("//span[@aria-hidden='true']");
    public By cartButton = By.cssSelector("a[title='View your shopping cart']");
    public By clearCart = By.cssSelector("a[title='বাতিল করুন']");
    public By cartOrderButton = By.cssSelector(".button.checkout.wc-forward");
    public By nameField = By.cssSelector("#billing_first_name");
    public By phoneNumberField = By.cssSelector("#billing_phone");
    public By emailField = By.cssSelector("#billing_email");
    public By districtDropdown = By.cssSelector("#billing_state");
    public By areaDropdown = By.cssSelector("#billing_area");
    public By address = By.cssSelector("#billing_address_1");
    public By deliveryChargeOption = By.cssSelector("#shipping_method_0_flat_rate2");
    public By paymentMethod = By.id("payment_method_nagad");
    public By myAccount = By.xpath("(//a[@title='আমার অ্যাকাউন্ট'][contains(text(),'আমার অ্যাকাউন্ট')])[2]");

    public void selectArea(By field ,String visibleText) throws InterruptedException {
        Thread.sleep(3000);
        Select select = new Select(getElement(field));
        select.selectByVisibleText(visibleText);
    }


}
