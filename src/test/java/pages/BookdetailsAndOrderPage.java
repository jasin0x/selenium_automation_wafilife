package pages;

import org.openqa.selenium.By;

public class BookdetailsAndOrderPage extends basePage{

    public String bookDetailsUrl = "https://www.wafilife.com/shop/books/islam-science-and-culture/";
    public By bookHeading = By.cssSelector(".product_title.entry-title");
    public By bookPrice = By.cssSelector("ins[class='single-product-sale-price'] bdi:nth-child(1)");
    public By orderButton = By.xpath("//div[@class='body-wrapper']//button[2]");
    public By itemConfirmation = By.xpath("(//span[normalize-space()='1 items'])[1]");
    public By confirmationWindowClose = By.xpath("//span[@aria-hidden='true']");
    public By cartButton = By.cssSelector("a[title='View your shopping cart']");
    public By cartOrderButton = By.cssSelector(".button.checkout.wc-forward");
    public By nameField = By.cssSelector("#billing_first_name");
    public By phoneNumberField = By.cssSelector("#billing_phone");
    public By emailField = By.cssSelector("#billing_email");
    public By districtDropdown = By.cssSelector("#select2-billing_state-container");
    //public By targetDistrict = By.cssSelector("#select2-billing_state-result-a2cv-BD-12");
    public By targetDistrict = By.linkText("Khulna");
    public By districtInputField = By.cssSelector("input[role='combobox']");
    public By selectedDistrict = By.linkText("Gazipur");
    public By areaDropdown = By.cssSelector("#billing_area");
    public By address = By.cssSelector("#billing_address_1");
    public By deliveryChargeOption = By.id("shipping_method_0_flat_rate8");
    public By paymentMethod = By.id("payment_method_nagad");
    public By myAccount = By.cssSelector("div[class='login-links'] a[title='আমার অ্যাকাউন্ট']");


}
