package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.DriverSetup.getDriver;

public class basePage {


    public WebElement getElement(By locator){
        return waitforElementPresence(locator);
    }

    public String getElementText(By locator){
        return getElement(locator).getText();
    }

    public boolean doContain(By locator, String text) {
        return getElement(locator).getText().contains(text);
    }


    public WebElement waitforElementPresence(By locator){
        WebDriverWait wait =new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement waitforElementToBeClickable(By locator){
        WebDriverWait wait =new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean isElementVisible(By locator){
        return getElement(locator).isDisplayed();
    }

    public void clickOnElement(By locator){
        waitforElementPresence(locator).click();
    }

    public void writeOnElement(By locator, String text){
        getElement(locator).clear();
        getElement(locator).sendKeys(text);
    }
}
