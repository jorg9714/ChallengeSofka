package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.DriverFacade;
import helpers.DriverFactory;
import modals.QuickViewModal;
import modals.ShoppingCartModal;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.RandomVariables;

public class ShoppingProcessSteps {
    private WebDriver webDriver = DriverFactory.getWebDriver();
    private HomePage homePage = new HomePage(webDriver);
    private ShoppingCartModal shoppingCartModal;
    private int numberArticle;
    private long quantityProductsAdded;
    private String titleArticle;
    private String titleArticleModal;
    private DetailProductPage detailProductPage;
    private CheckoutPage checkoutPage;

    @When("^The user adds any product$")
    public void theUserAddsAnyProduct() {
        numberArticle = RandomVariables.getRandomNumberInRange(0, homePage.getQuantityArticle());
        homePage.moveCursorToArticle(numberArticle);
        homePage.clickToAddToCartInArticle(numberArticle);
        shoppingCartModal = new ShoppingCartModal(webDriver);
        titleArticleModal=shoppingCartModal.getTitleArticle();
        shoppingCartModal.quit();
        titleArticle = homePage.getTitleArticle(numberArticle);

    }

    @Then("^The product is in the shopping cart$")
    public void theProductIsInTheShoppingCart() {
        shoppingCartModal = new ShoppingCartModal(webDriver);
        Assert.assertEquals("The products are different", titleArticle, titleArticleModal);
    }


    @Then("The user can see the products in the shopping cart")
    public void theUserCanSeeTheProductsInTheShoppingCart() {
        Assert.assertEquals("The quantity are different", "" + quantityProductsAdded, homePage.getQuantityCart());
    }

    @When("The user adds {int} products")
    public void theUserAddsProducts(int quantify) {
        quantityProductsAdded = quantify;
        for (int factor = 0; factor < quantify; factor++) {
            numberArticle = RandomVariables.getRandomNumberInRange(0, homePage.getQuantityArticle());
            homePage.moveCursorToArticle(numberArticle);
            homePage.clickToAddToCartInArticle(numberArticle);
            shoppingCartModal = new ShoppingCartModal(webDriver);
            shoppingCartModal.quit();
        }
    }

    @Given("The user has added almost one product to the shopping cart")
    public void theUserHasAddedAlmostOneProductToTheShoppingCart() {
        numberArticle = RandomVariables.getRandomNumberInRange(0, homePage.getQuantityArticle());
        homePage.moveCursorToArticle(numberArticle);
        homePage.clickToAddToCartInArticle(numberArticle);
        shoppingCartModal = new ShoppingCartModal(webDriver);
        shoppingCartModal.quit();
    }

    @When("The user deletes the product from the shopping cart")
    public void theUserDeletesTheProductFromTheShoppingCart() {
        homePage.openCart();
        homePage.deleteProduct(0);
    }

    @Then("The product has been remove")
    public void theProductHasBeenRemove() {
        Assert.assertTrue("The product has not been deleted", DriverFacade.waitToBeInvisibilityOf(homePage.getProduct(0)));
    }

    @And("The user chooses a product")
    public void theUserChoosesAProduct() {
        numberArticle = RandomVariables.getRandomNumberInRange(0, homePage.getQuantityArticle());
        homePage.moveCursorToArticle(numberArticle);
    }


    @Then("The user can see the description about the product;")
    public void theUserCanSeeTheDescriptionAboutTheProduct() {
        QuickViewModal quickViewModal = new QuickViewModal(webDriver);
        Assert.assertNotNull("The description is not null", quickViewModal.getDescription());
        quickViewModal.quit();
    }


    @When("The user open the quickView of the product")
    public void theUserOpenTheQuickViewOfTheProduct() {
        homePage.quickViewProduct(numberArticle);
    }

    @And("The opens the details page of the product chose")
    public void theOpensTheDetailsPageOfTheProductChose() {
        homePage.moreDetailsProduct(numberArticle);
        detailProductPage = new DetailProductPage(webDriver);
    }

    @When("The user adds the product")
    public void theUserAddsTheProduct() {
        quantityProductsAdded = 1;
        detailProductPage.addToCart();
    }

    @When("The user goes to the Checkout Page")
    public void TheUserGoesToTheCheckoutPage() {
        homePage.goToCheckoutPage();
        checkoutPage = new CheckoutPage(webDriver);
    }

    @Then("The product can see in the Summary Checkout Page")
    public void theProductCanSeeInTheSummaryCheckoutPage() {
        Assert.assertEquals("The products are different", titleArticle, checkoutPage.getFirstProductName());

    }


    @Then("The quantity of product has increased")
    public void theQuantityOfProductHasIncreased() {
        Assert.assertEquals("The quantity are different", quantityProductsAdded + "", checkoutPage.getQuantityOfProduct(0));
    }


    @When("The user edits the quantity before for {int} products of the same type chose")
    public void theUserEditsTheQuantityBeforeForProductsOfTheSameTypeChose(int quantity) {
        quantityProductsAdded = quantity;
        checkoutPage.setQuantityOfProduct(0, quantity);
    }


    @Then("The product of the same type is delete from the Summary Checkout Page")
    public void theProductOfTheSameTypeIsDeleteFromTheSummaryCheckoutPage() {
        Assert.assertTrue("The product has not been deleted", DriverFacade.waitToBeInvisibilityOf(checkoutPage.getProduct(0)));

    }

    @When("The user deletes all products of the same type")
    public void theUserDeletesAllProductsOfTheSameType() {
        checkoutPage.clickTrashIconOfProduct(0);

    }

    @When("The user edits the quantity before for <quantity> products of the same type chose")
    public void theUserEditsTheQuantityBeforeForQuantityProductsOfTheSameTypeChose(long quantity) {
        quantityProductsAdded = quantity;
        checkoutPage.setQuantityOfProduct(0, quantity);
    }
}
