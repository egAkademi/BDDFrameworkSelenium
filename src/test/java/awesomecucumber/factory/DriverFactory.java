package awesomecucumber.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    //private static WebDriver driver;
    //private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initializeDriver(String browser){
        WebDriver driver;
        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                //System.setProperty("webdriver.chrome.driver", "/Users/gokhansit/IdeaProjects/kodsis-crm/chromedriver");
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                //System.setProperty("webdriver.gecko.driver", "/Users/gokhansit/IdeaProjects/kodsis-crm/geckodriver");
                driver = new FirefoxDriver();
            }
            default -> throw new IllegalStateException("invalid browser: " + browser);
        }

        driver.manage().window().maximize();
        //DriverFactory.driver.set(driver);
        return driver;
    }
//    public static WebDriver getDriver(){
//        return driver.get();
//    }
}
