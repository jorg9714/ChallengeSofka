package pages;

import helpers.DriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(id = "email")
    private WebElement fieldEmail;
    @FindBy(id = "SubmitLogin")
    private WebElement submitLoginButton;
    @FindBy(id = "passwd")
    private WebElement fieldPassword;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    public void setEmail(String email) {
        DriverFacade.waitTobeVisibilityOf(fieldEmail);
        fieldEmail.sendKeys(email);
    }

    public void setPassword(String password){
        DriverFacade.waitTobeVisibilityOf(fieldPassword);
        fieldPassword.sendKeys(password);
    }

    public void clickSignIn(){
        DriverFacade.waitTobeClickable(submitLoginButton);
        submitLoginButton.click();
    }
}
