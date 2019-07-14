package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFacade {
    private static WebDriverWait wait = new WebDriverWait(DriverFactory.getWebDriver(), 10);


    public static void waitTobeVisibilityOf(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }


    public static void waitTobeClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void moveCursorToWebElement(WebDriver webDriver, WebElement webElement) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webElement).build().perform();
    }

    public static void scrollToDown() {
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebDriver();
        js.executeScript("window.scrollBy(0,1000)");
    }

    public static Boolean waitToBeInvisibilityOf(WebElement webElement) {
        wait.until(ExpectedConditions.invisibilityOf(webElement));
        return true;
    }
}
