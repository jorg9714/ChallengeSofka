package pages;

import helpers.DriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {


    @FindBy(xpath = "//ul[@id='homefeatured']//li")
    private
    List<WebElement> articles;
    @FindBy(xpath = "//span[contains(text(), 'Add to cart')]")
    private
    List<WebElement> articlesAddToCartButton;
    @FindBy(xpath = "//ul[@id='homefeatured']//a[@class='product-name']")
    private
    List<WebElement> artucleProductName;
    @FindBy(xpath = "//ul[@id='homefeatured']//a[@class='quick-view']")
    private
    List<WebElement> quickViewProduct;
    @FindBy(xpath = "//ul[@id='homefeatured']//li//a[@class='button lnk_view btn btn-default']")
    private
    List<WebElement> moreDetailsProductButton;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }
    public void moveCursorToArticle(int numberArticle) {
        DriverFacade.waitTobeVisibilityOf(articles.get(numberArticle));
        DriverFacade.moveCursorToWebElement(webDriver, articles.get(numberArticle));
    }

    public int getQuantityArticle() {
        DriverFacade.waitTobeVisibilityOf(articles.get(0));
        return articles.size();
    }

    public String getTitleArticle(int numberArticle){
        DriverFacade.waitTobeVisibilityOf(artucleProductName.get(numberArticle));
        return artucleProductName.get(numberArticle).getText();
    }

    public void clickToAddToCartInArticle(int numberArticle) {
        DriverFacade.waitTobeVisibilityOf(articlesAddToCartButton.get(numberArticle));
        articlesAddToCartButton.get(numberArticle).click();
    }
    public void quickViewProduct(int numberArticle){
        DriverFacade.waitTobeClickable(quickViewProduct.get(numberArticle));
        quickViewProduct.get(numberArticle).click();
    }
    public void moreDetailsProduct(int numberArticle){
        DriverFacade.waitTobeClickable(moreDetailsProductButton.get(numberArticle));
        moreDetailsProductButton.get(numberArticle).click();
    }
}

