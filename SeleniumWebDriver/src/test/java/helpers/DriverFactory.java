package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.PropertyManager;

public class DriverFactory {

    private static  WebDriver webDriver;
    private static ChromeOptions chromeOptions = new ChromeOptions();

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static WebDriver setWebDriver(){

        if(PropertyManager.getValueByKey("headless").equals("true")){
            chromeOptions.addArguments("--headless");
        }
        return webDriver = new ChromeDriver(chromeOptions);
    }
}
