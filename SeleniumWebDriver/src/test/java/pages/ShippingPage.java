package pages;

import helpers.DriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage extends BasePage{


    @FindBy(id = "uniform-cgv")
    private WebElement checkTermsOfService;
    @FindBy(xpath = "//p[@class='cart_navigation clearfix']//button")
    private WebElement proceedToCheckoutButton;

    public ShippingPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }
    public void clickCheckTermsOfService(){
        DriverFacade.scrollToDown();
        DriverFacade.moveCursorToWebElement(webDriver,checkTermsOfService);
        DriverFacade.waitTobeClickable(checkTermsOfService);
        checkTermsOfService.click();
    }

    public void proceedToCheckout(){
        DriverFacade.waitTobeClickable(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
    }
}
