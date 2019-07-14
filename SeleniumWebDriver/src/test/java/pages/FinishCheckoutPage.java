package pages;

import helpers.DriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinishCheckoutPage extends BasePage {

    @FindBy(className = "box")
    private WebElement descriptionCheckoutBox;

    public FinishCheckoutPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    public String DescriptionCheckoutSuccesful(){
        DriverFacade.waitTobeVisibilityOf(descriptionCheckoutBox);
        return descriptionCheckoutBox.getText();
    }
}
