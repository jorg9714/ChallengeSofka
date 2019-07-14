package modals;

import helpers.DriverFacade;
import helpers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuickViewModal implements BaseModal {

    @FindBy(xpath ="//html")
    private WebElement descriptionProduct;
    @FindBy(xpath ="//a[@class='fancybox-item fancybox-close']")
    private WebElement quit;

    public QuickViewModal(WebDriver webDriver) {
        PageFactory.initElements(DriverFactory.getWebDriver(),this);
    }

    public String getDescription(){
        DriverFacade.waitTobeVisibilityOf(descriptionProduct);
        return descriptionProduct.getText();
    }

    public void quit(){
        DriverFacade.waitTobeClickable(quit);
        quit.click();
    }

}
