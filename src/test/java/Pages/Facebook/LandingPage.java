package Pages.Facebook;

import Pages.Commands;
import org.openqa.selenium.By;

public class LandingPage extends Commands {

    /**
     * HomePage which opens for www.facebook.com
     * This class contains:
     * - Variables of Locators
     * - Methods which use locators to unteract with WebElements on this page
     */

    // Variables for Locators
    By loginEmailLocator = By.id("email");
    By loginPassLocator = By.id("pass");
    By loginButtonLocator = By.tagName("button");
    By createNewAccountBtnLocator = By.xpath("//a[@data-testid='open-registration-form-button']");


    // Methods
    public void enterLoginEmail(String loginEmail) {
        type(loginEmailLocator, loginEmail);
    }

    public void enterLoginPassword(String loginPass) {
        type(loginPassLocator, loginPass);
    }

    public void clickLoginButton() {
        click(loginButtonLocator);
    }

    public boolean isLoginButtonEnabled() {
        return findWebElement(loginButtonLocator).isEnabled();
    }

    public boolean isCreateNewAccBtnEnabled() {
        return findWebElement(createNewAccountBtnLocator).isEnabled();
    }

    public void clickCreateNewAccBtn() {
        click(createNewAccountBtnLocator);
    }


}