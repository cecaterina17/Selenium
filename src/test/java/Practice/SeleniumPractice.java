package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumPractice {

    /** git branch commands
     *      - git branch
     *      - git branch newBranchName  <-- to create new branch
     *      - git checkout branchName   <-- to switch branch
     *      - git branch -d branchName  <-- to delete your branch (git branch -D branchName)
     *
     *  Selenium
     *      - Java, IDE (integrated Dev Environment)
     *      - Maven Project
     *          - Selenium Library from mvnRepositories
     *          - testNG library (to create assertions)
     */

    /**
     *  How to use Selenium
     *      - set property for browser (how to launch browser)
     *      - create chromeDriver object
     *
     *      - use object to access methods
     */

    @Test
    public void connection() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
    }

}
