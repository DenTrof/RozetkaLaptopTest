package tests;

import common.CommonAction;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.LapTopPage;
import pages.LoginPage;

public class CheckAccount {
    private String phone = "+380954761650";
    private String password = "123Denis4";


    @Test(description = "Rozetka Login page test")
    public void SetRozetkaAccount() throws InterruptedException {
        new LoginPage().enterLoginData(phone, password);
    }

    @Test(description = "LapTopPage test", dependsOnMethods = "SetRozetkaAccount")
    public void lapTopPageTest() throws InterruptedException {
        new LapTopPage().lapTopPage();
    }

    @AfterSuite(alwaysRun = true)
    public void closeBrowser() throws InterruptedException {
        CommonAction.closeBrowser();
    }

}
