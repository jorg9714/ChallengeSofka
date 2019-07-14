package pages;

import helpers.DriverFacade;
import helpers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {


    public WebDriver webDriver;
    @FindBy(className = "header_user_info")
    private WebElement signInButton;
    @FindBy(id = "header_logo")
    private WebElement logo;
    @FindBy(className = "ajax_cart_quantity")
    private WebElement cartQuantity;
    @FindBy(xpath = "//div[@class='shopping_cart']/a")
    private WebElement cart;
    @FindBy(className = "ajax_cart_block_remove_link")
    private List<WebElement> removeProduct;
    @FindBy(xpath = "//div[@class='cart_block_list']//dt")
    private List<WebElement> products;
    @FindBy(id = "button_order_cart")
    private WebElement checkoutButton;

    public BasePage(WebDriver webDriver) {
        this.webDriver = DriverFactory.getWebDriver();
        PageFactory.initElements(webDriver, this);
    }

    public LoginPage ClickToSignInButtom() {
        DriverFacade.waitTobeVisibilityOf(signInButton);
        signInButton.click();
        return PageFactory.initElements(webDriver, LoginPage.class);
    }

    public String getUserName() {
        return signInButton.getText();
    }

    public HomePage goToHomePage() {
        DriverFacade.waitTobeVisibilityOf(logo);
        logo.click();
        return PageFactory.initElements(webDriver, HomePage.class);
    }

    public String getQuantityCart() {
        DriverFacade.waitTobeVisibilityOf(cartQuantity);
        return cartQuantity.getText();
    }

    public void openCart() {
        DriverFacade.waitTobeVisibilityOf(cart);
        DriverFacade.moveCursorToWebElement(webDriver, cart);
    }

    public void deleteProduct(int productNumber) {
        DriverFacade.waitTobeClickable(removeProduct.get(productNumber));
        removeProduct.get(productNumber).click();
    }

    public WebElement getProduct(int productNumber) {
        return products.get(productNumber);
    }

    public void goToCheckoutPage() {
        DriverFacade.moveCursorToWebElement(webDriver, cart);
        DriverFacade.waitTobeClickable(checkoutButton);
        checkoutButton.click();
    }


}
