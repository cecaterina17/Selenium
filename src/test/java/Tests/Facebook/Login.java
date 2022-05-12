package Tests.Facebook;

import Pages.Facebook.LandingPage;
import Web.MyDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {

    @Test
    public void enterLoginInfo() {
        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");
        LandingPage lPage = new LandingPage();
        lPage.enterLoginEmail("cecaterina19@gmail.com");
        lPage.enterLoginPassword("171thsgfs");
        Assert.assertTrue(lPage.isLoginButtonEnabled());
        Assert.assertTrue(lPage.isCreateNewAccBtnEnabled());
        lPage.clickCreateNewAccBtn();
        MyDriver.quitWindows();
    }

}

