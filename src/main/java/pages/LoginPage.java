package pages;

import common.CommonAction;
import org.openqa.selenium.By;

public class LoginPage extends GeneralPage {
    private final By userCabinetBtn = By.xpath("//li/rz-user/button[@class='header__button ng-star-inserted']");
    private final By inputPhone = By.xpath("//input[@id='auth_email']");
    private final By inputPassword = By.xpath("//input[@id='auth_pass']");
    private final By submitBtn = By.xpath("//button[@class='button button--large button--green auth-modal__submit ng-star-inserted']");
    private final By captcha = By.xpath("//rz-re-captcha/div[@class='auth-modal__captcha ng-star-inserted']");

    public void enterLoginData(String phone, String password) throws InterruptedException {
        driver.findElement(userCabinetBtn).click();
        driver.findElement(inputPhone).sendKeys(phone);
        driver.findElement(inputPassword).sendKeys(password);
        driver.findElement(submitBtn).click();
        waitElementIsVisible(driver.findElement(captcha)).click();
        waitElementIsVisible(driver.findElement(submitBtn)).click();

        try {
            System.out.println("You have registrated on Rozetka");
        } catch (AssertionError e) {
            System.out.println("Registration failed");
            throw e;
        } finally {
            CommonAction.closeBrowser();
        }
    }
}
