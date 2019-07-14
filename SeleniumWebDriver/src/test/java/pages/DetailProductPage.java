package pages;

import helpers.DriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailProductPage extends BasePage {
    @FindBy(id = "add_to_cart")
    private WebElement addToCartButton;

    public DetailProductPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    public void addToCart(){
        DriverFacade.waitTobeClickable(addToCartButton);
        addToCartButton.click();
    }
}
