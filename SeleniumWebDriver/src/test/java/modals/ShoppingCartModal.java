package modals;

import helpers.DriverFacade;
import helpers.DriverFactory;
import org.assertj.core.error.ShouldBeAfterYear;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartModal implements BaseModal{

    @FindBy(xpath = "//span[@id='layer_cart_product_title']")
    private
    WebElement titleArticleModal;
    @FindBy(className = "cross")
    private
    WebElement crossButton;

    public ShoppingCartModal(WebDriver webDriver) {
        PageFactory.initElements(DriverFactory.getWebDriver(), this);
    }
    public String getTitleArticle() {
        DriverFacade.waitTobeVisibilityOf(titleArticleModal);
        return titleArticleModal.getText();
    }
    public void quit() {
        DriverFacade.waitTobeClickable(crossButton);
        crossButton.click();
    }
}
