package Pages;

import Web.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Commands {

    /**
     * Methods present in this class
     * - finElement();
     * - click();
     * - sendKeys();
     * - getText();
     * - isEnabled();
     * - isDisplayed();
     * - selectByVisibleText();
     */

    public WebElement findWebElement(By locator) {
        return MyDriver.getDriver().findElement(locator);
    }

    public void click(By locator) {
        findWebElement(locator).click();
    }

    public void type(By locator, String input) {
        findWebElement(locator).sendKeys(input);
    }

    public String getElementText(By locator) {
        return findWebElement(locator).getText();
    }

    public boolean isElementEnabled(By locator) {
        return findWebElement(locator).isEnabled();
    }

    public boolean isElementDisplayed(By locator) {
        return findWebElement(locator).isDisplayed();
    }

    public void selectInDropdown(By locator, String dataToSelect) {
        WebElement element = findWebElement(locator);
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(dataToSelect);
    }

}

