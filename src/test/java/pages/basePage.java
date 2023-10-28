package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

import static utilities.DriverSetup.getDriver;

public class basePage {

    public WebDriverWait wait;
    public Actions action;


    //it will return single element
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
        wait =new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement waitForElementToBeClickable(By locator){
        wait =new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean isElementVisible(By locator){
        try{
            return getDriver().findElement(locator).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public void clickOnElement(By locator){
        waitforElementPresence(locator).click();
    }

    public void writeOnElement(By locator, String text){
        getElement(locator).clear();
        getElement(locator).sendKeys(text);
    }

    public void selectWithVisibleText(By selectLocator, String visibleText){
        Select select = new Select(getElement(selectLocator));
        select.selectByVisibleText(visibleText);
    }

    public void hoverOverElement(WebElement element){
        action = new Actions(getDriver());
        action.moveToElement(element).build().perform();
    }

    public void scrolltoElement(By locator){
//        JavascriptExecutor js = (JavascriptExecutor)getDriver();
//        js.executeScript("window.scrollBy(0,500)");
        action = new Actions(getDriver());
        action.scrollToElement(getElement(locator)).build().perform();
    }

    public void pageNavigate(String direction){
        if (direction=="back"){
            getDriver().navigate().back();
        }else if (direction=="forward"){
            getDriver().navigate().forward();
        }else if (direction=="refresh"){
            getDriver().navigate().refresh();
        }else {
            getDriver().navigate().refresh();
        }
    }

}
