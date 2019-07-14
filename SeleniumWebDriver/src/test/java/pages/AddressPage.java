package pages;

import helpers.DriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage extends BasePage {

    @FindBy(xpath = "//p[@class='cart_navigation clearfix']//button")
    private WebElement processAddressButton;


    public AddressPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    public void clickProcessAddressButton(){
        DriverFacade.waitTobeClickable(processAddressButton);
        processAddressButton.click();
    }
}
