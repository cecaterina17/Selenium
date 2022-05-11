package Pages.Facebook;

import Pages.Commands;
import org.openqa.selenium.By;

public class SignUpPage extends Commands {

    // Locators
    By monthDdLocator = By.id("month");
    By yearDdLocator = By.id("year");
    By dayDdLocator = By.id("day");


    // Methods
    public void selectBirthMonth(String monthName) {
        selectInDropdown(monthDdLocator, monthName);
    }

    public void selectBirthDay(String day) {
        selectInDropdown(dayDdLocator, day);
    }

    public void selectBirthYear(String year) {
        selectInDropdown(yearDdLocator, year);
    }

    public void selectBirthdayDate(String month, String day, String year) {
        selectInDropdown(monthDdLocator, month);
        selectInDropdown(dayDdLocator, day);
        selectInDropdown(yearDdLocator, year);
    }
}