package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helpers.DriverFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.PropertyManager;

public class BaseSteps {

    private WebDriver webDriver;

    @Before
    public void setup(){
        webDriver= DriverFactory.setWebDriver();
        webDriver.get(PropertyManager.getValueByKey("URL.HomePage"));
        webDriver.manage().window().maximize();

    }



    @After
    public void close(Scenario scenario) {

            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) DriverFactory.getWebDriver())
                        .getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png"); //stick it in the report
                saveScreenshot(screenshot);
            }
        webDriver.quit();

    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}
