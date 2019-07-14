package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import helpers.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import utils.PropertyManager;

public class UserAccountSteps {
    private WebDriver webDriver = DriverFactory.getWebDriver();
    private pages.LoginPage loginPage;
    private pages.HomePage homePage;


    @Given("^The user goes to the HomePage$")
    public void theUserGoesToTheHomePage() {
        homePage = new HomePage(webDriver);
    }

    @And("^The user clicks the button of Sing In$")
    public void theUserClicksTheButtonOfSingIn() {
        homePage.ClickToSignInButtom();
        loginPage = new LoginPage(webDriver);
    }


    @Then("^The user is logged in$")
    public void theUserIsLoggedIn() {
        Assert.assertEquals("The user name is not equals", PropertyManager.getValueByKey("userName"), loginPage.getUserName());
    }


}
