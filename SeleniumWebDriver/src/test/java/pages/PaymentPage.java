package pages;

import helpers.DriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PaymentPage extends BasePage {
    @FindBy(xpath = "//div[@id='HOOK_PAYMENT']//a")
    private List<WebElement> paymentMethods;
    @FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
    private WebElement confirmOrder;

    public PaymentPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    public void setPaymentMethod(int paymentMethod){
        DriverFacade.waitTobeClickable(paymentMethods.get(paymentMethod));
        paymentMethods.get(paymentMethod).click();
    }

    public int quantityOfPaymentMethods(){
        DriverFacade.waitTobeVisibilityOf(paymentMethods.get(0));
        return paymentMethods.size();
    }

    public void confirmOrder(){
        DriverFacade.waitTobeClickable(confirmOrder);
        confirmOrder.click();
    }

}
