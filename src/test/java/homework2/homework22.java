package homework2;

import Helper.Misc;
import Web.MyDriver;
import org.testng.annotations.Test;

public class homework22 {

    @Test
    public void newMethod() {
        MyDriver.launchUrlOnNewWindow("U write some url here");

        // to access driver variable
        MyDriver.getDriver();

        Misc.pause(5);
        MyDriver.quitWindows();
    }

}
