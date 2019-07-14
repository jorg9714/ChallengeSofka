package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.PropertyManager;
import utils.RandomVariables;

public class CheckoutProcessSteps {
    private WebDriver webDriver = DriverFactory.getWebDriver();

    private CheckoutPage checkoutPage;
    private LoginPage loginPage;
    private AddressPage addressPage;
    private ShippingPage shippingPage;
    private PaymentPage paymentPage;
    private FinishCheckoutPage finishCheckoutPage;
    private long quantityProductsAdded;


    @When("The user check the summary checkout")
    public void theUserCheckTheSummaryCheckout() {
        checkoutPage=new CheckoutPage(webDriver);
        checkoutPage.proceedToCheckout();
    }
    @When("The user set your credentials")
    public void theUserSetYourCredentials() {
        loginPage =new LoginPage(webDriver);
        loginPage.setEmail(PropertyManager.getValueByKey("email"));
        loginPage.setPassword(PropertyManager.getValueByKey("password"));
    }
    @And("^The user clicks the button for submit email and password$")
    public void theUserClicksTheButtonForSubmitEmailAndPassword() {
        loginPage.clickSignIn();
    }
    @And("The user check the address")
    public void theUserCheckTheAddress() {
        addressPage= new AddressPage(webDriver);
        addressPage.clickProcessAddressButton();
    }
    @And("The user check the Terms of the service")
    public void theUserCheckTheTermsOfTheService() {
        shippingPage= new ShippingPage(webDriver);
        shippingPage.clickCheckTermsOfService();
        shippingPage.proceedToCheckout();
    }
    @And("The user set any payment method")
    public void theUserSetAnyPaymentMethod() {
        paymentPage = new PaymentPage(webDriver);
        paymentPage.setPaymentMethod(RandomVariables.getRandomNumberInRange(0,paymentPage.quantityOfPaymentMethods()));
        paymentPage.confirmOrder();
    }
    @Then("The process of checkout is completed")
    public void theProcessOfCheckoutIsCompleted() {
        finishCheckoutPage=new FinishCheckoutPage(webDriver);
        Assert.assertNotNull("The checkout process was not complete",finishCheckoutPage.DescriptionCheckoutSuccesful());
    }

    public void theUserEditsTheQuantityBeforeForProductsOfTheSameTypeChose(int quantity) {
        quantityProductsAdded =  quantity;
        checkoutPage.setQuantityOfProduct(0, quantity);
    }

}
