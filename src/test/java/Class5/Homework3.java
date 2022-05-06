package Class5;

import Helper.Misc;
import Web.MyDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Homework3 {

    /**
     * TC-1:  darksky.net
     * Verify correct temperature value is displayed after changing temperature units
     */
    /*
        ˚F --> Fahrenheit
        ˚C --> Celsius
        1. Copy F˚ from DarkSky
            - split string at degree symbol
            - store [0] of array in degreesF var
            - use it for formula for conversion
        2. Click on units' dropdown & choose ˚C m/s
        3. Copy ˚C from DarkSky
            - repeat split method from ˚F example
            - store value in degreesC var
            - convert String --> Double and store in convertedC var
        4. Create formula to convert ˚F to ˚C
            - I tried rounding up/down decimal values from my formula
            - DecimalFormat class & methods help to do that
            - I saw some tests failing due to DarkSky & Formula decimal rounding mismatch
            - DarkSky shows 9˚ while my formula calculates 9.4595˚(rounds up to 10˚) <--- Test gets failed
            - Not always, but sometimes DarkSky decimal rounding failed tests
        5. Instead, I find difference between degrees˚C from DarkSky and My Formula
           If difference is less than 0.6˚C, I consider test passed
           if/else block can show difference of +0.5˚ OR - 0.5˚ and never fails
            - First, subtract DarkSky value from my formula
            - Use result for condition where I let it pass ONLY if difference is < 1˚
            - Depending on which block control enters, boolean var takes true or false value
            - assertTrue() method evaluates final test outcome using above var
     */
    @Test
    public void darkSky() {
        MyDriver.launchUrlOnNewWindow("https://darksky.net/");

        String degreesF = MyDriver.getDriver().findElement(By.xpath("//span[@class='summary swap']")).getText();
        String[] arrayF = degreesF.split("˚");
        degreesF = arrayF[0];

        MyDriver.getDriver().findElement(By.xpath("//div[contains(@class,'selectric-units')]")).click();
        Misc.pause(1);
        MyDriver.getDriver().findElement(By.xpath("//div[contains(@class,'selectric-open')]//li[contains(text(),'m/s')]")).click();
        Misc.pause(1);

        String degreesC = MyDriver.getDriver().findElement(By.xpath("//span[@class='summary swap']")).getText();
        String[] arrayC = degreesC.split("˚");
        degreesC = arrayC[0];
        Double convertedC = Double.valueOf(degreesC);

        double degreesFToC = (Integer.valueOf(degreesF) - 32) * 0.5556;
        DecimalFormat df = new DecimalFormat("#"); // <-- DecimalFormat class allows manipulating decimal point (patterns: # | #.## | etc..)

        double result = degreesFToC - convertedC;
        boolean isTestPassed;
        if (result < 0.6 && result > -0.6) { // <-- if degree difference is < 1˚C, pass the test
            isTestPassed = true;                 // Mostly difference ends up around 0.3˚- 0.5˚
        } else {
            isTestPassed = false;
        }
        Assert.assertTrue(isTestPassed, "Test Failed - Degrees don't match");

        // Uncomment following print commands to better understand how my formula & Dark Sky metrics work
//        String cConverted = df.format(degreesFToC); // <-- format() returns String
//        System.out.println("\nFollowing is data from my formula and Dark Sky:");
//        System.out.println("From Dark Sky C˚ [Double] -> " + convertedC);
//        System.out.println("Non-Formatted Formula C˚ [Double] --> " + degreesFToC);
//        System.out.println("Formatted Formula C˚ [String] -> " + cConverted);

        MyDriver.quitWindows();
    }



    /**
     * TC-2: facebook.com
     * Verify current date is selected in the dropdown when user lands on the Create new account form
     */
    /*
        Steps
        1. Launch browser & provide url for webpage
        2. Find locator & get WebElement for create new acc btn
            - click and wait
        3. Find locator & get WebElements for Birthday fields
            - Locate current month and store text in month var
            - Locate current day and store text in day var
            - Locate current year and store text in year var
        4. Create object for Date class
            - Create object of SimpleDateFormat class
            - create date pattern similar to one from facebook B day fields
            - Store today's date in variable
        5. Using month, day & year variables, create one String var of Facebook's current date
            - Verify current date using .assertEquals() and above created local & Facebook's dates
     */
    @Test
    public void facebookTodayDate() {

        MyDriver.launchUrlOnNewWindow("https://facebook.com/");
        MyDriver.getDriver().findElement(By.partialLinkText("new account")).click();
        Misc.pause(1);

        String month = MyDriver.getDriver().findElement(By.xpath("//select[@title='Month']/option[@selected='1']")).getText();
        String day = MyDriver.getDriver().findElement(By.xpath("//select[@title='Day']/option[@selected='1']")).getText();
        String year = MyDriver.getDriver().findElement(By.xpath("//select[@title='Year']/option[@selected='1']")).getText();

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM:dd:yyyy");
        String dateLocal = sdf.format(d);

        String dateFacebook = month + ":" + day + ":" + year;
        Assert.assertEquals(dateFacebook, dateLocal, "Test Fail - Dates don't match");
        MyDriver.quitWindows();
    }



    /**
     * TC-3: https://classroomessentialsonline.com/
     * Verify user lands on Economy Church Chairs page after clicking the option from Church Chairs
     */
    /*
        Steps
        1. Launch browser & provide url for webpage
        2. Create object for Actions class and pass driver as parameter
        3. Find locator for main menu dropdown
            - Find WebElement for the Church Chairs dropdown
            - Hover over target by providing WebElement to method .moveToElement();
            - Find locator and get WebElement of desired link from the dropdown
            - Save href attr value and text of the link tag for assertions
            - Click the link and wait for page to load
        4. Verify user lands on Economy Church Chairs page
            - Verify by comparing current url to href value from previous page
            - Verify page Title tag text contains words from link that we clicked previously
            - Verify h1 tag contains words from link that we clicked.
     */
    @Test
    public void economyChairsPage() {
        MyDriver.launchUrlOnNewWindow("https://classroomessentialsonline.com/");

        Actions a = new Actions(MyDriver.getDriver());
        // Locate menu item, find WebElement & hover over using method from Actions class
        By chairsLocator = By.xpath("//li[@class='navPages-item']/a[contains(text(),'Church')]");
        WebElement churchChairs = MyDriver.getDriver().findElement(chairsLocator);
        a.moveToElement(churchChairs).perform();
        Misc.pause(2);

        // Get text values of href and link item
        String href = MyDriver.getDriver().findElement(By.xpath("//*[text()='Economy Church Chairs']")).getAttribute("href");
        String navLink = MyDriver.getDriver().findElement(By.xpath("//*[text()='Economy Church Chairs']")).getText();

        // Click on link
        MyDriver.getDriver().findElement(By.xpath("//*[text()='Economy Church Chairs']")).click();
        Misc.pause(2);

        // Verify using Current URL
        String currentUrl = MyDriver.getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl, href, "Test Failed - URLs do not match");

        // Verify using Page Title
        String pageTitle = MyDriver.getDriver().getTitle();
        Assert.assertTrue(pageTitle.toLowerCase().contains(navLink.toLowerCase()));

        // Verify using H1
        String pageHeading = MyDriver.getDriver().findElement(By.xpath("//h1[text()='Economy Church Chairs']")).getText();
        Assert.assertTrue(pageHeading.toLowerCase().contains(navLink.toLowerCase()));

        MyDriver.quitWindows();
    }
}
