package pages;

import org.openqa.selenium.By;

public class LoginPage extends basePage{
    public String loginPageUrl = "https://www.wafilife.com/my-account/";
    public String loginPageTitle = "আমার অ্যাকাউন্ট - Wafilife";
    public By headingElement = By.cssSelector(".heading-title.page-title");
    public String heading = "আমার অ্যাকাউন্ট";
    public By emailField = By.cssSelector("#username");
    public By passwordField = By.cssSelector("#password");
    public By loginButton = By.xpath("//input[@name='login']");
    public By forgetpassButton = By.xpath("//a[contains(text(),'আপনি কি পাসওয়ার্ড ভুলে গেছেন?')]");
    public By warningMessage = By.xpath("//li[contains(text(),'Unknown email address. Check again or try your use')]");

    public By confirmationMessageElement = By.xpath("//div[@id='template-wrapper']//p[1]");
}
