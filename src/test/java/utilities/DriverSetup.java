package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class DriverSetup {

    private static String browserName = System.getProperty("browser","chrome");
    private static final ThreadLocal<WebDriver> LOCAL_DRIVER = new ThreadLocal<>();
    public static void setDriver(WebDriver driver){
        DriverSetup.LOCAL_DRIVER.set(driver);
    }
    public static WebDriver getDriver(){
        return LOCAL_DRIVER.get();
    }
    public static WebDriver createBrowser(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            return new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            return new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            return new FirefoxDriver();
        } else {
            throw new RuntimeException("Browser not fount!!! using the given name: "+browserName);
        }
    }

    @BeforeClass
    public static void setBrowser(){
        WebDriver driver = createBrowser(browserName);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        setDriver(driver);
    }

    @AfterClass
    public static void quitBrowser(){
        getDriver().quit();
    }


}
