package pages;

import helpers.DriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage extends BasePage {

    @FindBy(xpath = "//table[@id='cart_summary']//p")
    private List<WebElement> productsName;
    @FindBy(xpath = "//input[@class='cart_quantity_input form-control grey']")
    private List<WebElement> quantityProductsInput;
    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
    private WebElement proceedToCheckOutButton;
    @FindBy(xpath = "//i[@class='icon-trash']")
    private List<WebElement> trashIcon;

    public CheckoutPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }
    public String getFirstProductName() {
        DriverFacade.waitTobeVisibilityOf(productsName.get(0));
        return productsName.get(0).getText();
    }

    public void setQuantityOfProduct(int product, long quantity) {
        DriverFacade.waitTobeClickable(quantityProductsInput.get(product));
        quantityProductsInput.get(product).click();
        quantityProductsInput.get(product).sendKeys("" + quantity);
    }

    public String getQuantityOfProduct(int product) {
        DriverFacade.waitTobeVisibilityOf(quantityProductsInput.get(product));
        return quantityProductsInput.get(product).getAttribute("value");
    }

    public void proceedToCheckout() {
        DriverFacade.scrollToDown();
        DriverFacade.waitTobeClickable(proceedToCheckOutButton);
        proceedToCheckOutButton.click();
    }
    public void clickTrashIconOfProduct(int product){
        DriverFacade.waitTobeClickable(trashIcon.get(product));
        trashIcon.get(product).click();
    }

}
