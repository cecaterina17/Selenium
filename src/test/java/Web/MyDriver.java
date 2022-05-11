package Web;

import Helper.Misc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyDriver {


    private static WebDriver driver;

    public static void launchUrlOnNewWindow(String url) {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        Misc.pause(4);
    }

    public static void quitWindows() {
        driver.quit();
    }
    public static WebDriver getDriver() {
        return driver;
    }
}
