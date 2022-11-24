package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import static common.ConfigConstants.PLATFORM_BROWSER;
import static common.ConfigConstants.TimeOutVariable.WAITING_TIME;
import common.ConfigConstants.Urls;

public class CommonAction {
    private static WebDriver driver;
    @BeforeTest
    public static WebDriver createDriver() {

        switch (PLATFORM_BROWSER) {
            case "windows_chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                driver.get(Urls.ROZETKA_REGISTRATION.getUrl());
                break;
            default:
                Assert.fail("Incorrect browser name" + PLATFORM_BROWSER);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(WAITING_TIME, TimeUnit.SECONDS);

        return driver;
    }

    public static Object closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
        return null;
    }
}
