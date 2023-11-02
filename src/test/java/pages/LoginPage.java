package pages;

import org.openqa.selenium.By;

public class LoginPage extends basePage{
    public String loginPageUrl = "https://www.wafilife.com/my-account/";
    public String loginPageTitle = "আমার অ্যাকাউন্ট - Wafilife";
    public By logOutButton = By.xpath("//a[contains(text(),'লগ অউট করুন')]");
    public By headingElement = By.cssSelector(".heading-title.page-title");
    public String heading = "আমার অ্যাকাউন্ট";
    public By emailField = By.cssSelector("#username");
    public String userEmail = "mahamudulh7788@gmail.com";
    public By passwordField = By.cssSelector("#password");
    public By loginButton = By.xpath("//input[@name='login']");
    public By forgetpassButton = By.xpath("//a[contains(text(),'আপনি কি পাসওয়ার্ড ভুলে গেছেন?')]");
    public By passwordResetButton = By.xpath("//button[contains(text(),'পাসওয়ার্ড রিসেট করুন')]");
    public By forgetPasswordMessageElement = By.cssSelector("div[id='template-wrapper'] p:nth-child(1)");
    public String forgetPasswordMessage = "আপনার পাসওয়ার্ড হারিয়েছেন? আপনার ইউজার নাম বা ইমেল ঠিকানা লিখুন. আপনি ইমেইল এর মাধ্যমে একটি নতুন পাসওয়ার্ড তৈরি করার জন্য একটি লিঙ্ক পাবেন.";
    public By emailForResetPassword = By.cssSelector("#user_login");
    public By passowrdResetConfirmation = By.cssSelector(".woocommerce-message");
    public By warningMessage = By.cssSelector("ul[class='woocommerce-error'] li");

    public By confirmationMessageElement = By.xpath("//div[@id='template-wrapper']//p[1]");
}
