package tests;

import common.CommonAction;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.LapTopPage;
import pages.LoginPage;

import static common.ConfigConstants.PASSWORD;
import static common.ConfigConstants.PHONE;

public class CheckAccount {

    @Test(description = "Rozetka Login page test")
    public void SetRozetkaAccount() throws InterruptedException {
        new LoginPage().enterLoginData(PHONE, PASSWORD);
    }

    @Test(description = "LapTopPage test", dependsOnMethods = "SetRozetkaAccount")
    public void lapTopPageTest() throws InterruptedException {
        new LapTopPage().lapTopPage();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() throws InterruptedException {
        CommonAction.closeBrowser();
    }

}
